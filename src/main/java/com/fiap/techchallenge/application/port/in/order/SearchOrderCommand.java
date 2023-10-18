package com.fiap.techchallenge.application.port.in.order;

import com.fiap.techchallenge.application.domain.model.OrderStatus;

public record SearchOrderCommand(String cpf, OrderStatus status) {

}
