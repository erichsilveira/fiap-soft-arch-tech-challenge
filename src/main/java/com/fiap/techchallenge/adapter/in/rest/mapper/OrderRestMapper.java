package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.OrderCreationRequest;
import com.fiap.techchallenge.application.domain.model.Order;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrderRestMapper {

    ProductRestMapper productRestMapper;

    public Order toDomainEntity(OrderCreationRequest restEntity) {
        return Order.builder().customerCpf(restEntity.customerCpf())
            .customerId(restEntity.customerId())
            .products(restEntity.products().stream().map(productRestMapper::toDomainEntity)
                .collect(Collectors.toList())).build();
    }
}
