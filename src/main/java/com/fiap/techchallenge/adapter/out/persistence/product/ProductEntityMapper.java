package com.fiap.techchallenge.adapter.out.persistence.product;

import com.fiap.techchallenge.application.domain.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductEntityMapper {

    Product toDomainEntity(ProductEntity entity) {
        return Product.builder().id(entity.getId())
            .name(entity.getName()).description(entity.getDescription())
            .productCategoryId(entity.getProductCategoryId()).price(entity.getPrice()).build();
    }

    ProductEntity fromDomainEntity(Product domainEntity) {
        return ProductEntity.builder().
            id(domainEntity.getId())
            .name(domainEntity.getName()).description(domainEntity.getDescription())
            .productCategoryId(domainEntity.getProductCategoryId()).price(
                domainEntity.getPrice()).build();
    }
}
