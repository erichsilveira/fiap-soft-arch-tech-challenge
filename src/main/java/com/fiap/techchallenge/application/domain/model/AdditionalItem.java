package com.fiap.techchallenge.application.domain.model;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
public class AdditionalItem {

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

    @Getter
    private ZonedDateTime createdAt;

    @Getter
    private ZonedDateTime updatedAt;
}
