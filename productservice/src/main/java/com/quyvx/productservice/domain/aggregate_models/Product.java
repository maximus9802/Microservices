package com.quyvx.productservice.domain.aggregate_models;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@SuperBuilder
@Getter
public class Product {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
}
