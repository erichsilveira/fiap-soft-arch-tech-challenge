package com.fiap.techchallenge.interfaces.dto;

import com.fiap.techchallenge.domain.entity.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderUpdateRequest(@NotNull OrderStatus status) {

}
