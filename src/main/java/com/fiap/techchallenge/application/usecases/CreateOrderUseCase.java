package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order command);
}
