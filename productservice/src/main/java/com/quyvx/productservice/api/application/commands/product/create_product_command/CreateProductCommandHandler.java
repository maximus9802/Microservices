package com.quyvx.productservice.api.application.commands.product.create_product_command;

import an.awesome.pipelinr.Command;
import com.quyvx.productservice.domain.aggregate_models.Product;
import com.quyvx.productservice.domain.repositories.IProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@Component
public class CreateProductCommandHandler implements Command.Handler<CreateProductCommand, Product> {

    private final IProductRepository productRepository;

    @Override
    public Product handle(CreateProductCommand command) {
        Product.ProductBuilder<?, ?> productBuilder = Product.builder()
                .name(command.getName())
                .description(command.getDescription())
                .category(command.getCategory())
                .price(command.getPrice());
        Product saveProduct = productRepository.save(productBuilder.build());
        log.info("-----CreateProductCommandHandler: Product #{} was created.", saveProduct.getId());
        return saveProduct;
    }
}
