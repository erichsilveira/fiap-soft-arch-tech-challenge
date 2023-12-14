package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.RegisterCustomerUseCase;
import com.fiap.techchallenge.domain.entity.Customer;
import com.fiap.techchallenge.domain.repository.CustomerRepository;
import com.fiap.techchallenge.infrastructure.model.CustomerModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterCustomerUseCaseImpl implements RegisterCustomerUseCase {

    private final CustomerRepository repository;

    @Override
    public Customer registerCustomer(Customer customer) {
        return repository.registerCustomer(customer);
    }
}
