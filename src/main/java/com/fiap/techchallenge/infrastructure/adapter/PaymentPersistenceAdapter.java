package com.fiap.techchallenge.infrastructure.adapter;

import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.domain.entity.PaymentStatus;
import com.fiap.techchallenge.domain.repository.PaymentRepository;
import com.fiap.techchallenge.infrastructure.model.PaymentModel;
import com.fiap.techchallenge.infrastructure.persistence.PaymentJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@RequiredArgsConstructor
@Component
public class PaymentPersistenceAdapter implements PaymentRepository {

    private final PaymentJpaRepository springDataRepository;

    @Override
    public Payment getPayment(String paymentId) {
        var model = springDataRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("Payment not found"));

        return PaymentModel.toPayment(model);
    }


    @Override
    public void createPayment(String paymentId, BigDecimal orderPrice) {
        var model = PaymentModel.builder()
            .id(paymentId)
            .orderPrice(orderPrice)
            .status(PaymentStatus.CREATED)
            .build();

        springDataRepository.save(model);
    }

    @Override
    public void updatePayment(String paymentId, PaymentStatus status) {
        var model = springDataRepository.findById(paymentId)
            .orElseThrow(() -> new RuntimeException("Payment not found"));

        model.setStatus(status);

        springDataRepository.save(model);
    }
}
