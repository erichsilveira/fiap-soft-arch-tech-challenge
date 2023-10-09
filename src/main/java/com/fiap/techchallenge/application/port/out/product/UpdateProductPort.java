package com.fiap.techchallenge.application.port.out.product;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Product;

public interface UpdateProductPort {

    Product updateProduct(String entityId, Product domainEntity) throws ResourceNotFoundException;
}
