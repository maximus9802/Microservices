package com.quyvx.productservice.api.application.queries.product;

import com.quyvx.productservice.api.application.models.product.ProductInfo;
import com.quyvx.productservice.api.application.models.product.ProductSummary;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductQueries {
    private final IProductQueriesService productQueriesService;

    public ProductInfo getProductInfoByProductName(String name){
        ProductSummary productSummary = productQueriesService.findProductByName(name);
        return ProductInfo.builder()
                .id(productSummary.getId())
                .name(productSummary.getName())
                .price(productSummary.getPrice())
                .description(productSummary.getDescription())
                .category(productSummary.getCategory())
                .build();
    }
}
