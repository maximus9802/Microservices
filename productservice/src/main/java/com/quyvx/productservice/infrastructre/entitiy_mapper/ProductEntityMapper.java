package com.quyvx.productservice.infrastructre.entitiy_mapper;

import com.quyvx.productservice.domain.aggregate_models.Product;
import com.quyvx.productservice.infrastructre.entities.ProductEntity;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

@Service
public class ProductEntityMapper {
    public ProductEntity modelToEntity(Product model){
        return ProductEntity.builder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .description(model.getDescription())
                .category(model.getCategory())
                .build();
    }

    public Product entityToModel(ProductEntity entity){
        if(ObjectUtils.isEmpty(entity)){
            return null;
        }
        return Product.builder()
                .id(entity.getId())
                .price(entity.getPrice())
                .description(entity.getDescription())
                .name(entity.getName())
                .category(entity.getCategory())
                .build();
    }
}
