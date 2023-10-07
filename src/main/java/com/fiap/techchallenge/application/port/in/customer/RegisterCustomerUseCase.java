package com.fiap.techchallenge.application.port.in.customer;

import com.fiap.techchallenge.application.domain.model.Customer;

public interface RegisterCustomerUseCase {

    Customer registerCustomer(Customer command);
}
