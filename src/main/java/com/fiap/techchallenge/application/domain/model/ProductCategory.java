package com.fiap.techchallenge.application.domain.model;

import lombok.Builder;
import lombok.Getter;

@Builder
public class ProductCategory {

    @Getter
    private final String id;

    @Getter
    private final String name;

    @Getter
    private final String description;
}
