package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.ProductCreationRequest;
import com.fiap.techchallenge.application.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductRestMapper {

    public Product toDomainEntity(ProductCreationRequest restEntity) {
        return Product.builder().name(restEntity.name())
            .description(restEntity.description()).productCategoryId(restEntity.productCategoryId())
            .price(restEntity.price()).build();
    }
}
