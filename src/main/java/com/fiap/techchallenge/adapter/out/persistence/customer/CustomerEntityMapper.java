package com.fiap.techchallenge.adapter.out.persistence.customer;

import com.fiap.techchallenge.application.domain.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerEntityMapper {

    Customer mapToDomainEntity(CustomerEntity customerEntity) {
        return Customer.builder().id(customerEntity.getId()).cpf(customerEntity.getCpf())
            .name(customerEntity.getName()).email(customerEntity.getEmail()).build();
    }

    CustomerEntity fromDomainEntity(Customer customer) {
        return CustomerEntity.builder().id(customer.getId()).cpf(customer.getCpf())
            .name(customer.getName()).email(
                customer.getEmail()).build();
    }
}
