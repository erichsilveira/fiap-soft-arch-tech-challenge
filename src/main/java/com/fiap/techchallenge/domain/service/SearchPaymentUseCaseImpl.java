package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.SearchPaymentUseCase;
import com.fiap.techchallenge.domain.entity.Payment;
import com.fiap.techchallenge.domain.repository.PaymentRepository;
import com.fiap.techchallenge.exception.ResourceNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
@Slf4j
public class SearchPaymentUseCaseImpl implements SearchPaymentUseCase {

    private final PaymentRepository repository;

    @Override
    public Payment searchPayment(String paymentId) throws ResourceNotFoundException {
        log.info("Searching payment with id {}", paymentId);
        Payment payment = repository.getPayment(paymentId);
        if (payment == null) {
            throw new ResourceNotFoundException();
        }
        return payment;
    }
}
