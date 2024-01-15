package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.UpdateOrderUseCase;
import com.fiap.techchallenge.application.usecases.UpdatePaymentUseCase;
import com.fiap.techchallenge.domain.entity.OrderStatus;
import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.domain.entity.PaymentStatus;
import com.fiap.techchallenge.domain.repository.PaymentRepository;
import com.fiap.techchallenge.exception.ResourceNotFoundException;
import com.fiap.techchallenge.interfaces.dto.UpdateOrderCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UpdatePaymentUseCaseImpl implements UpdatePaymentUseCase {

    private final PaymentRepository paymentRepository;

    private final UpdateOrderUseCase updateOrderUseCase;

    // webhook simulation
    public void paymentWebhook(String paymentId, boolean success) {
        log.info("Payment webhook for paymentId {} success {}", paymentId, success);

        try {
            updatePayment(paymentId, success ? PaymentStatus.APPROVED : PaymentStatus.REJECTED);
        } catch (ResourceNotFoundException e) {
            log.error("Failed to update payment for order {}", paymentId);
            throw new RuntimeException("Order not found");
        }
    }

    @Override
    public void updatePayment(String paymentId, PaymentStatus paymentStatus)
        throws ResourceNotFoundException {
        log.info("Updating payment for paymentId {} paymentStatus {}",
            paymentId, paymentStatus);

        Payment currentPayment = paymentRepository.getPayment(paymentId);

        if (currentPayment.canUpdate()) {
            paymentRepository.updatePayment(paymentId, paymentStatus);
        } else {
            throw new RuntimeException("Payment cannot be updated");
        }

        if (paymentStatus.equals(PaymentStatus.APPROVED)) {
            updateOrderUseCase.updateOrder(
                new UpdateOrderCommand(paymentId, OrderStatus.REQUESTED));
        }
    }
}
