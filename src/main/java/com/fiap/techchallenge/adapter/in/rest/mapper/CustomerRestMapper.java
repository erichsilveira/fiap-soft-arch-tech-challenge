package com.fiap.techchallenge.adapter.in.rest.mapper;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.application.domain.model.customer.Customer;
import org.springframework.stereotype.Component;

@Component
public class CustomerRestMapper {

    public Customer mapToDomainEntity(CustomerRegistrationRequest registrationRequest) {
        return Customer.builder().cpf(registrationRequest.getCpf())
            .name(registrationRequest.getName()).email(registrationRequest.getEmail()).build();
    }
}
