package com.fiap.techchallenge.application.domain.service;

import com.fiap.techchallenge.application.domain.model.customer.Customer;
import com.fiap.techchallenge.application.port.in.RegisterCustomerUseCase;
import com.fiap.techchallenge.application.port.out.RegisterCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final RegisterCustomerPort registerCustomerPort;

    @Override
    public Customer registerCustomer(Customer customer) {
        return registerCustomerPort.registerCustomer(customer);
    }
}
