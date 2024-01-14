package com.fiap.techchallenge.application.usecases;

import java.math.BigDecimal;

public interface CreatePaymentUseCase {

    void createPayment(String orderId, BigDecimal orderPrice);
}
