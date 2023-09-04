package com.quyvx.productservice.domain.repositories;

import com.quyvx.productservice.domain.aggregate_models.Product;

public interface IProductRepository {
    Product save(Product model);

    Product update(Product model);

    void deleteById(Long id);
}
