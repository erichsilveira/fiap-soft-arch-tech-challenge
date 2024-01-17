package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.PaymentStatus;
import com.fiap.techchallenge.exception.ResourceNotFoundException;

public interface UpdatePaymentUseCase {

    void paymentWebhook(String paymentId, boolean success);

    void updatePayment(String payment, PaymentStatus status) throws ResourceNotFoundException;
}
