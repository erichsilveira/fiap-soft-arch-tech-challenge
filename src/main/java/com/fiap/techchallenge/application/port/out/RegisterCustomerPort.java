package com.fiap.techchallenge.application.port.out;

import com.fiap.techchallenge.application.domain.model.customer.Customer;

public interface RegisterCustomerPort {

    Customer registerCustomer(Customer customer);
}
