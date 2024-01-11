package com.fiap.techchallenge.interfaces.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

public record OrderCreationRequest(@NotNull List<String> productsId,
                                   @NotBlank String customerId,
                                   @NotBlank String customerCpf,
                                   @NotNull BigDecimal orderPrice) {

}
