package com.fiap.techchallenge.application.port.in.order;

import com.fiap.techchallenge.application.domain.model.OrderStatus;

public record UpdateOrderCommand(String entityId, OrderStatus status) {

}