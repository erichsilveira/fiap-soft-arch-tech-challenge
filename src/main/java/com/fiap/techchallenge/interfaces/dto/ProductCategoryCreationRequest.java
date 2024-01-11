package com.fiap.techchallenge.interfaces.dto;

import jakarta.validation.constraints.NotBlank;

public record ProductCategoryCreationRequest(@NotBlank String name, String description) {

}
