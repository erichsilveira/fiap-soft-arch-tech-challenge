package com.fiap.techchallenge.adapter.out.persistence.customer;

import com.fiap.techchallenge.application.domain.model.customer.Customer;
import com.fiap.techchallenge.application.port.out.RegisterCustomerPort;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class CustomerPersistenceAdapter implements RegisterCustomerPort {

    private final SpringDataCustomerRepository springDataCustomerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public Customer registerCustomer(Customer customer) {

        CustomerEntity customerEntity = customerEntityMapper.fromDomainEntity(customer);
        customerEntity.setId(UUID.randomUUID().toString());

        springDataCustomerRepository.save(customerEntity);

        return customerEntityMapper.mapToDomainEntity(customerEntity);
    }
}
