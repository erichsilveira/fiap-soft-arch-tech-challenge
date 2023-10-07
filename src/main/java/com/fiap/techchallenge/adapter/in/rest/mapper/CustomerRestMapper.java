package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.application.domain.model.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRestMapper {

    public Customer toDomainEntity(CustomerRegistrationRequest restEntity) {
        return Customer.builder().cpf(restEntity.cpf())
            .name(restEntity.name()).email(restEntity.email()).build();
    }
}
