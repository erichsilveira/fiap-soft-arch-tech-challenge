package com.fiap.techchallenge.adapter.in.rest.data.request;

import com.fiap.techchallenge.application.domain.model.OrderStatus;
import jakarta.validation.constraints.NotNull;

public record OrderUpdateRequest(@NotNull OrderStatus status) {

}
