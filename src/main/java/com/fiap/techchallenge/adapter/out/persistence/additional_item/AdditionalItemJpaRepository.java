package com.fiap.techchallenge.adapter.out.persistence.additional_item;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalItemJpaRepository extends
    JpaRepository<AdditionalItemEntity, String> {

}
