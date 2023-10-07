package com.fiap.techchallenge.application.domain.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
public class Product {

    @Getter
    private final String id;

    @Getter
    private final String name;

    @Getter
    private String description;

    @Getter
    private final BigDecimal price;

    @Getter
    private final String productCategoryId;
}
