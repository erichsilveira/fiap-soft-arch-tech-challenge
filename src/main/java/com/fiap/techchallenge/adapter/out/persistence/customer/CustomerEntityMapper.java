package com.fiap.techchallenge.adapter.out.persistence.customer;

import com.fiap.techchallenge.application.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    Customer toDomainEntity(CustomerEntity entity) {
        return Customer.builder().id(entity.getId()).cpf(entity.getCpf())
            .name(entity.getName()).email(entity.getEmail())
            .createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }

    CustomerEntity fromDomainEntity(Customer domainEntity) {
        return CustomerEntity.builder().
            id(domainEntity.getId()).cpf(domainEntity.getCpf())
            .name(domainEntity.getName()).email(
                domainEntity.getEmail())
            .createdAt(domainEntity.getCreatedAt()).updatedAt(domainEntity.getUpdatedAt()).build();
    }
}
