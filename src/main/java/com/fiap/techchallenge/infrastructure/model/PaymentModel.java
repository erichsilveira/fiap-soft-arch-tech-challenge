package com.fiap.techchallenge.infrastructure.model;

import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.domain.entity.PaymentStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.ZonedDateTime;

@Entity
@Table(name = "payments")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentModel {

    public static PaymentModel toPaymentModel(Payment payment) {
        return PaymentModel.builder()
            .id(payment.getId())
            .orderPrice(payment.getOrderPrice())
            .status(payment.getStatus())
            .createdAt(payment.getCreatedAt())
            .updatedAt(payment.getUpdatedAt())
            .build();
    }

    public static Payment toPayment(PaymentModel paymentModel) {
        return Payment.builder()
            .id(paymentModel.getId())
            .orderPrice(paymentModel.getOrderPrice())
            .status(paymentModel.getStatus())
            .createdAt(paymentModel.getCreatedAt())
            .updatedAt(paymentModel.getUpdatedAt())
            .build();
    }

    @Id
    private String id;

    private BigDecimal orderPrice;

    private PaymentStatus status;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
