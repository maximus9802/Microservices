package com.quyvx.productservice.api.dto.product;

import lombok.Getter;

import java.math.BigDecimal;
@Getter
public class UpdateProductReq {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private String category;
}
