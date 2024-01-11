package com.fiap.techchallenge.interfaces.dto;


import com.fiap.techchallenge.domain.entity.OrderStatus;

public record SearchOrderCommand(String cpf, OrderStatus status) {

}
