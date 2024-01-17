package com.fiap.techchallenge.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record PaymentWebhookUpdateRequest(@NotBlank String paymentId, @NotNull boolean success) {
}
