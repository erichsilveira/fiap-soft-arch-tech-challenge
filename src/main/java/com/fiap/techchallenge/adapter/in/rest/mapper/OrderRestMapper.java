package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.OrderCreationRequest;
import com.fiap.techchallenge.application.domain.model.Order;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrderRestMapper {

    public Order toDomainEntity(OrderCreationRequest restEntity) {
        return Order.builder().customerCpf(restEntity.customerCpf())
            .customerId(restEntity.customerId())
            .orderPrice(restEntity.orderPrice())
            .productsId(restEntity.productsId()).build();
    }
}
