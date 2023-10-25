package com.fiap.techchallenge.adapter.out.persistence.order;

import com.fiap.techchallenge.application.domain.model.Order;
import org.springframework.stereotype.Component;

@Component
public class OrderEntityMapper {

    public Order toDomainEntity(OrderEntity entity) {
        return Order.builder().id(entity.getId())
            .productsId(entity.getProductsId())
            .orderPrice(entity.getOrderPrice())
            .status(entity.getStatus()).customerId(entity.getCustomerId())
            .customerCpf(entity.getCustomerCpf()).createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt()).build();
    }

    public OrderEntity fromDomainEntity(Order domainEntity) {
        return OrderEntity.builder().id(domainEntity.getId())
            .productsId(domainEntity.getProductsId())
            .orderPrice(domainEntity.getOrderPrice())
            .status(domainEntity.getStatus()).customerId(domainEntity.getCustomerId())
            .customerCpf(domainEntity.getCustomerCpf()).createdAt(domainEntity.getCreatedAt())
            .updatedAt(domainEntity.getUpdatedAt()).build();
    }
}
