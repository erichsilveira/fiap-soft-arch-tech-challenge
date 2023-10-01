package com.fiap.techchallenge.application.domain.model.customer;

import lombok.Builder;
import lombok.Getter;

@Builder
public class Customer {

    @Getter
    private final String id;

    @Getter
    private final String cpf;

    @Getter
    private final String name;

    @Getter
    private final String email;
}
