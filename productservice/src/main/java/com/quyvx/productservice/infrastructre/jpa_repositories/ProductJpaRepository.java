package com.quyvx.productservice.infrastructre.jpa_repositories;

import com.quyvx.productservice.api.application.models.product.ProductSummary;
import com.quyvx.productservice.infrastructre.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductEntity, Long>, JpaSpecificationExecutor<ProductEntity> {
    @Query(value = "SELECT p.id as id, p.name as name, p.description as description, p.price as price, p.category as category " +
            "FROM product as p " +
            "WHERE p.name = :name ", nativeQuery = true)
    ProductSummary findProductByName(@Param("name") String name);
}
