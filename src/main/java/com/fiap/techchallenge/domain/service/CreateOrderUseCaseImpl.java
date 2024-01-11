package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreateOrderUseCase;
import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateOrderUseCaseImpl implements CreateOrderUseCase {

    private final OrderRepository repository;

    @Override
    public Order createOrder(Order order) {
        log.info("Creating order for customer cpf {} orderId {}",
            order.getCustomerCpf(), order.getId());
        return repository.createOrder(order);
    }
}
