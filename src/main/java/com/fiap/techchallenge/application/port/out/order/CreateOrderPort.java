package com.fiap.techchallenge.application.port.out.order;

import com.fiap.techchallenge.application.domain.model.Order;

public interface CreateOrderPort {

    Order createOrder(Order domainEntity);
}
