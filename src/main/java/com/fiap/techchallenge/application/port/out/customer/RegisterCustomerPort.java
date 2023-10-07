package com.fiap.techchallenge.application.port.out.customer;

import com.fiap.techchallenge.application.domain.model.Customer;

public interface RegisterCustomerPort {

    Customer registerCustomer(Customer domainEntity);
}
