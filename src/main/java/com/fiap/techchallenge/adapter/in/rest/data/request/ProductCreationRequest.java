package com.fiap.techchallenge.adapter.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record ProductCreationRequest(@NotBlank String name, String description,
                                     @NotBlank String productCategoryId,
                                     @NotNull BigDecimal price) {

}
