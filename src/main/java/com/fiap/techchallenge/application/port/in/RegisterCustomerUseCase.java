package com.fiap.techchallenge.application.port.in;

import com.fiap.techchallenge.application.domain.model.customer.Customer;

public interface RegisterCustomerUseCase {

    Customer registerCustomer(Customer command);
}
