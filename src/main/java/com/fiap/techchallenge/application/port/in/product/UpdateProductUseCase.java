package com.fiap.techchallenge.application.port.in.product;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Product;

public interface UpdateProductUseCase {

    Product updateProduct(UpdateProductCommand command) throws ResourceNotFoundException;
}
