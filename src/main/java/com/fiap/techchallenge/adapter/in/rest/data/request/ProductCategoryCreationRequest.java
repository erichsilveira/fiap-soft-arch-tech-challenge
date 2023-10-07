package com.fiap.techchallenge.adapter.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;

public record ProductCategoryCreationRequest(@NotBlank String name, String description) {

}
