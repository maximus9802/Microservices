package com.quyvx.productservice.infrastructre.queries;

import com.quyvx.productservice.api.application.models.product.ProductSummary;
import com.quyvx.productservice.api.application.queries.product.IProductQueriesService;
import com.quyvx.productservice.infrastructre.jpa_repositories.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductQueriesService implements IProductQueriesService {
    private final ProductJpaRepository productJpaRepository;
    @Override
    public ProductSummary findProductByName(String name) {
        return productJpaRepository.findProductByName(name);
    }
}
