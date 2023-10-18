package com.fiap.techchallenge.adapter.out.persistence.order;

import com.fiap.techchallenge.adapter.out.persistence.product.ProductEntity;
import com.fiap.techchallenge.adapter.out.persistence.product.ProductEntityMapper;
import com.fiap.techchallenge.application.domain.model.Order;
import org.springframework.stereotype.Component;
import java.util.stream.Collectors;

@Component
public class OrderEntityMapper {

    ProductEntityMapper productMapper;

    public Order toDomainEntity(OrderEntity entity) {
        return Order.builder().id(entity.getId())
            .products(entity.getProducts().stream().map(productMapper::toDomainEntity)
                .collect(Collectors.toList()))
            .orderPrice(entity.getOrderPrice())
            .status(entity.getStatus()).customerId(entity.getCustomerId())
            .customerCpf(entity.getCustomerCpf()).createdAt(entity.getCreatedAt())
            .updatedAt(entity.getUpdatedAt()).build();
    }

    public OrderEntity fromDomainEntity(Order domainEntity) {
        return OrderEntity.builder().id(domainEntity.getId())
            .products(domainEntity.getProducts().stream().map(productMapper::fromDomainEntity)
                .collect(Collectors.toList()))
            .orderPrice(domainEntity.getOrderPrice())
            .status(domainEntity.getStatus()).customerId(domainEntity.getCustomerId())
            .customerCpf(domainEntity.getCustomerCpf()).createdAt(domainEntity.getCreatedAt())
            .updatedAt(domainEntity.getUpdatedAt()).build();
    }
}
