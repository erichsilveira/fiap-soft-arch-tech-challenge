package com.fiap.techchallenge.application.domain.service.customer;

import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.in.customer.RegisterCustomerUseCase;
import com.fiap.techchallenge.application.port.out.customer.RegisterCustomerPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class RegisterCustomerService implements RegisterCustomerUseCase {

    private final RegisterCustomerPort registerPort;

    @Override
    public Customer registerCustomer(Customer customer) {
        log.info("Registering customer with cpf {}", customer.getCpf());
        return registerPort.registerCustomer(customer);
    }
}
