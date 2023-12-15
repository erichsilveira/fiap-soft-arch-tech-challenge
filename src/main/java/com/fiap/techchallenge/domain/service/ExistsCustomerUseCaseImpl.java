package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.ExistsCustomerUseCase;
import com.fiap.techchallenge.domain.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExistsCustomerUseCaseImpl implements ExistsCustomerUseCase {

    private final CustomerRepository repository;

    @Override
    public boolean existsCustomer(String cpf) {
        return repository.existsCustomer(cpf);
    }

}
