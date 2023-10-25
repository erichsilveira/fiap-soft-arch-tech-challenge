package com.fiap.techchallenge.application.port.in.order;

import com.fiap.techchallenge.application.domain.model.Order;

public interface CreateOrderUseCase {

    Order createOrder(Order command);
}
