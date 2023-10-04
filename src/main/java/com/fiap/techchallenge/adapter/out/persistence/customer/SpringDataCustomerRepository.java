package com.fiap.techchallenge.adapter.out.persistence.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataCustomerRepository extends CrudRepository<CustomerEntity, String> {

}
