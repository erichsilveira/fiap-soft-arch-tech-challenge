package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.exception.ResourceNotFoundException;

public interface SearchPaymentUseCase {

    Payment searchPayment(String paymentId) throws ResourceNotFoundException;
}
