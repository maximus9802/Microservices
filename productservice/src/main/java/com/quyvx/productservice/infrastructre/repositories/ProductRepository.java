package com.quyvx.productservice.infrastructre.repositories;

import com.quyvx.productservice.domain.aggregate_models.Product;
import com.quyvx.productservice.domain.repositories.IProductRepository;
import com.quyvx.productservice.infrastructre.entities.ProductEntity;
import com.quyvx.productservice.infrastructre.entitiy_mapper.ProductEntityMapper;
import com.quyvx.productservice.infrastructre.jpa_repositories.ProductJpaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
@Transactional
public class ProductRepository implements IProductRepository {
    private final ProductJpaRepository productJpaRepository;
    private final ProductEntityMapper mapper;
    @Override
    public Product save(Product model) {
        ProductEntity entity = mapper.modelToEntity(model);
        entity = productJpaRepository.save(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public Product update(Product model) {
        ProductEntity entity = mapper.modelToEntity(model);
        entity = productJpaRepository.save(entity);
        return mapper.entityToModel(entity);
    }

    @Override
    public void deleteById(Long id) {
        productJpaRepository.deleteById(id);
    }
}
