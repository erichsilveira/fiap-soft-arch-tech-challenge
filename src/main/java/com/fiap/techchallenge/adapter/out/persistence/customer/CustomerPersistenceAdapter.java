package com.fiap.techchallenge.adapter.out.persistence.customer;

import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.out.customer.RegisterCustomerPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerPersistenceAdapter implements RegisterCustomerPort {

    private final CustomerJpaRepository springDataRepository;

    private final CustomerEntityMapper entityMapper;

    @Override
    public Customer registerCustomer(Customer customer) {
        CustomerEntity customerEntity = entityMapper.fromDomainEntity(customer);

        springDataRepository.save(customerEntity);

        return entityMapper.toDomainEntity(customerEntity);
    }
}
