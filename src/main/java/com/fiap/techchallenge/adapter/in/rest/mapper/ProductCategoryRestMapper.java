package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.ProductCategoryCreationRequest;
import com.fiap.techchallenge.application.domain.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryRestMapper {

    public ProductCategory toDomainEntity(ProductCategoryCreationRequest restEntity) {
        return ProductCategory.builder().name(restEntity.name())
            .description(restEntity.description()).build();
    }
}
