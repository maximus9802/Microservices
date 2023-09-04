package com.quyvx.productservice.api.application.commands.product.update_product_command;

import an.awesome.pipelinr.Command;
import com.quyvx.productservice.domain.aggregate_models.Product;
import com.quyvx.productservice.domain.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class UpdateProductCommandHandler implements Command.Handler<UpdateProductCommand, Product> {
    private final IProductRepository productRepository;
    @Override
    public Product handle(UpdateProductCommand command) {
        Product.ProductBuilder<?, ?> productBuilder = Product.builder()
                .id(command.getId())
                .description(command.getDescription())
                .price(command.getPrice())
                .name(command.getName())
                .category(command.getCategory());
        Product product = productRepository.save(productBuilder.build());
        log.info("-----UpdateProductCommandHandler: update product #{} successful.", product.getId());
        return product;
    }
}
