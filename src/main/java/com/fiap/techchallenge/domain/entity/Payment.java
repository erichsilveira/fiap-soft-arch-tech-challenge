package com.fiap.techchallenge.domain.entity;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.Builder;
import lombok.Getter;

@Builder
public class Payment {

    @Getter
    private final String id;

    @Getter
    private BigDecimal orderPrice;

    @Getter
    private PaymentStatus status;

    @Getter
    private ZonedDateTime createdAt;

    @Getter
    private ZonedDateTime updatedAt;

    public boolean canUpdate() {
        return status == PaymentStatus.CREATED || status == PaymentStatus.REJECTED;
    }
}
