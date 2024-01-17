package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreatePaymentUseCase;
import com.fiap.techchallenge.domain.repository.PaymentRepository;
import java.math.BigDecimal;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreatePaymentUseCaseImpl implements CreatePaymentUseCase {

    private final PaymentRepository paymentRepository;

    // only to simulate payment webhook
    private final UpdatePaymentUseCaseImpl updatePaymentUseCase;

    @Override
    public void createPayment(String orderId, BigDecimal orderPrice) {
        log.info("Creating payment for orderId {} orderPrice {}",
            orderId, orderPrice);

        paymentRepository.createPayment(orderId, orderPrice);

        // start a payment timer process to simulate a payment
        simulateCustomerPayment(orderId);
    }

    private void simulateCustomerPayment(String orderId) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);

                // get random between boolean
                boolean success = Math.random() < 0.5;

                updatePaymentUseCase.paymentWebhook(orderId, success);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread.start();
    }
}
