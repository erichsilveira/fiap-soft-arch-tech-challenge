package com.fiap.techchallenge.adapter.out.persistence.customer;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends CrudRepository<CustomerEntity, String> {

    boolean existsByCpf(String cpf);

}
