package com.fiap.techchallenge.adapter.out.persistence.additional_item;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataAdditionalItemRepository extends
    CrudRepository<AdditionalItemEntity, String> {

}
