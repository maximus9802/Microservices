package com.quyvx.productservice.api.controllers;

import an.awesome.pipelinr.Pipeline;
import com.quyvx.productservice.api.application.commands.product.create_product_command.CreateProductCommand;
import com.quyvx.productservice.api.application.commands.product.update_product_command.UpdateProductCommand;
import com.quyvx.productservice.api.application.models.product.ProductInfo;
import com.quyvx.productservice.api.application.queries.product.ProductQueries;
import com.quyvx.productservice.api.dto.product.CreateProductReq;
import com.quyvx.productservice.api.dto.product.UpdateProductReq;
import com.quyvx.productservice.domain.aggregate_models.Product;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductQueries productQueries;
    private final Pipeline pipeline;

    @PostMapping
    public Product createProduct(@Valid @RequestBody CreateProductReq req){
        CreateProductCommand command =CreateProductCommand.builder()
                .name(req.getName())
                .description(req.getDescription())
                .price(req.getPrice())
                .category(req.getCategory())
                .build();
        return pipeline.send(command);
    }

    @PutMapping
    public Product updateProduct(@Valid @RequestBody UpdateProductReq req){
        UpdateProductCommand command = UpdateProductCommand.builder()
                .id(req.getId())
                .category(req.getCategory())
                .description(req.getDescription())
                .name(req.getName())
                .price(req.getPrice())
                .build();
        return pipeline.send(command);
    }

    @GetMapping("")
    public ProductInfo getProductInfoByName(@RequestParam("name") String name){
        return productQueries.getProductInfoByProductName(name);
    }
}
