package com.fiap.techchallenge.adapter.out.persistence.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryEntityMapper {

    ProductCategory toDomainEntity(ProductCategoryEntity entity) {
        return ProductCategory.builder().id(entity.getId().toString())
            .name(entity.getName()).description(entity.getDescription()).build();
    }

    ProductCategoryEntity fromDomainEntity(ProductCategory domainEntity) {
        return ProductCategoryEntity.builder()
            .id(domainEntity.getId())
            .name(domainEntity.getName())
            .description(domainEntity.getDescription())
            .build();
    }
}
