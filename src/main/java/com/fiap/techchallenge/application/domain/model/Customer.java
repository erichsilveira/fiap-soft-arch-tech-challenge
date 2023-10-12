package com.fiap.techchallenge.application.domain.model;

import java.time.ZonedDateTime;
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

    @Getter
    private ZonedDateTime createdAt;

    @Getter
    private ZonedDateTime updatedAt;
}
