package com.fiap.techchallenge.application.domain.service.customer;


import com.fiap.techchallenge.application.port.in.customer.ExistsCustomerUseCase;
import com.fiap.techchallenge.application.port.out.customer.ExistsCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ExistsCustomerService implements ExistsCustomerUseCase {

    private final ExistsCustomerPort existsCustomerPort;

    @Override
    public boolean existsCustomer(String cpf) {
        return existsCustomerPort.existsCustomer(cpf);
    }

}
