package com.fiap.techchallenge.domain.repository;

import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.domain.entity.PaymentStatus;
import java.math.BigDecimal;

public interface PaymentRepository {

    Payment getPayment(String paymentId);

    void createPayment(String paymentId, BigDecimal orderPrice);

    void updatePayment(String paymentId, PaymentStatus status);
}
