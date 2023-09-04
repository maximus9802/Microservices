package com.quyvx.productservice.api.application.commands.product.create_product_command;

import an.awesome.pipelinr.Command;
import com.quyvx.productservice.domain.aggregate_models.Product;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class CreateProductCommand implements Command<Product> {
    private String name;
    private String description;
    private BigDecimal price;
    private String category;

}
