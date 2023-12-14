package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreateOrderUseCase;
import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderRepository repository;

    @Override
    public Order createOrder(Order domainEntity) {
        return repository.createOrder(domainEntity);
    }
}
