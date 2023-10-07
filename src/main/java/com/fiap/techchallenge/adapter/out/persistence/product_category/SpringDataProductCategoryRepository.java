package com.fiap.techchallenge.adapter.out.persistence.product_category;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringDataProductCategoryRepository extends CrudRepository<ProductCategoryEntity, UUID> {

}
