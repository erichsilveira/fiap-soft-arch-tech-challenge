package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.AdditionalItemCreationRequest;
import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import org.springframework.stereotype.Component;

@Component
public class AdditionalItemRestMapper {

    public AdditionalItem toDomainEntity(AdditionalItemCreationRequest restEntity) {
        return AdditionalItem.builder().name(restEntity.name())
            .description(restEntity.description()).productCategoryId(restEntity.productCategoryId())
            .price(restEntity.price()).build();
    }
}
