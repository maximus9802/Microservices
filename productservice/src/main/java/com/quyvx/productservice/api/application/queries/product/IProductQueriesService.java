package com.quyvx.productservice.api.application.queries.product;

import com.quyvx.productservice.api.application.models.product.ProductInfo;
import com.quyvx.productservice.api.application.models.product.ProductSummary;

public interface IProductQueriesService {
    ProductSummary findProductByName(String name);
}
