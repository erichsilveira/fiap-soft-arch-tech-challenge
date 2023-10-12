package com.fiap.techchallenge.adapter.out.persistence.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import org.springframework.stereotype.Component;

@Component
public class ProductCategoryEntityMapper {

    ProductCategory toDomainEntity(ProductCategoryEntity entity) {
        return ProductCategory.builder().id(entity.getId())
            .name(entity.getName()).description(entity.getDescription())
            .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }

    ProductCategoryEntity fromDomainEntity(ProductCategory domainEntity) {
        return ProductCategoryEntity.builder()
            .id(domainEntity.getId())
            .name(domainEntity.getName())
            .description(domainEntity.getDescription())
            .createdAt(domainEntity.getCreatedAt()).updatedAt(domainEntity.getUpdatedAt())
            .build();
    }
}
