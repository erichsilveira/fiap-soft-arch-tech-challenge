package com.fiap.techchallenge.interfaces.dto;


import com.fiap.techchallenge.domain.entity.OrderStatus;

public record UpdateOrderCommand(String entityId, OrderStatus status) {

}