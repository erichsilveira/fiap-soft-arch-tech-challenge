package com.fiap.techchallenge.adapter.out.persistence.customer;

import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.out.customer.ExistsCustomerPort;
import com.fiap.techchallenge.application.port.out.customer.RegisterCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerPersistenceAdapter implements RegisterCustomerPort, ExistsCustomerPort {

    private final CustomerJpaRepository springDataRepository;

    private final CustomerEntityMapper entityMapper;

    @Override
    public Customer registerCustomer(Customer customer) {
        CustomerEntity customerEntity = entityMapper.fromDomainEntity(customer);

        springDataRepository.save(customerEntity);

        return entityMapper.toDomainEntity(customerEntity);
    }

    @Override
    public boolean existsCustomer(String cpf) {
        return springDataRepository.existsByCpf(cpf);
    }
}
