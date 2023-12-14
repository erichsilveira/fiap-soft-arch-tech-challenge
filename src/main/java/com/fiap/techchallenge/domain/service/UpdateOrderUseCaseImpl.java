package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.UpdateOrderUseCase;
import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.repository.OrderRepository;
import com.fiap.techchallenge.interfaces.dto.UpdateOrderCommand;
import com.fiap.techchallenge.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UpdateOrderUseCaseImpl implements UpdateOrderUseCase {

    private final OrderRepository repository;

    @Override
    public Order updateOrder(UpdateOrderCommand command) throws ResourceNotFoundException {
        return repository.updateOrder(command.entityId(), command.status());
    }
}
