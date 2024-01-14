package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.Order;

public interface CreateOrderCheckoutUseCase {

    Order createOrderCheckout(Order command);
}
