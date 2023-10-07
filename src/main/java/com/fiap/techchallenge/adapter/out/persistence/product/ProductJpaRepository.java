package com.fiap.techchallenge.adapter.out.persistence.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends
    JpaRepository<ProductEntity, String> {

}
