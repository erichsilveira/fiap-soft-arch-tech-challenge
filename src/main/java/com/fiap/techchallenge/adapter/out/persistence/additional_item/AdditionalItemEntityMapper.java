package com.fiap.techchallenge.adapter.out.persistence.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import org.springframework.stereotype.Component;

@Component
public class AdditionalItemEntityMapper {

    AdditionalItem toDomainEntity(AdditionalItemEntity entity) {
        return AdditionalItem.builder().id(entity.getId())
            .name(entity.getName()).description(entity.getDescription())
            .productCategoryId(entity.getProductCategoryId()).price(entity.getPrice()).build();
    }

    AdditionalItemEntity fromDomainEntity(AdditionalItem domainEntity) {
        return AdditionalItemEntity.builder().
            id(domainEntity.getId())
            .name(domainEntity.getName()).description(domainEntity.getDescription())
            .productCategoryId(domainEntity.getProductCategoryId()).price(
                domainEntity.getPrice()).build();
    }
}
