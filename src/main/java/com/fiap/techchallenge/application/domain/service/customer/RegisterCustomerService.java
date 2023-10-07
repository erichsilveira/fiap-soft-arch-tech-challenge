package com.fiap.techchallenge.application.domain.service.customer;

import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.in.customer.RegisterCustomerUseCase;
import com.fiap.techchallenge.application.port.out.customer.RegisterCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final RegisterCustomerPort registerPort;

    @Override
    public Customer registerCustomer(Customer customer) {
        return registerPort.registerCustomer(customer);
    }
}
