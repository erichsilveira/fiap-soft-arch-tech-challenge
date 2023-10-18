package com.fiap.techchallenge.adapter.in.rest.data.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.List;

public record OrderCreationRequest(@NotNull List<ProductCreationRequest> products,
                                   @NotBlank String customerId,
                                   @NotBlank String customerCpf) {

}
