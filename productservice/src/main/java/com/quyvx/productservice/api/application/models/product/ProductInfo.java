package com.quyvx.productservice.api.application.models.product;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class ProductInfo {
    private String id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
}
