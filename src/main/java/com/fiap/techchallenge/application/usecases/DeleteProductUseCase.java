package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.interfaces.dto.DeleteProductCommand;

public interface DeleteProductUseCase {

    void deleteProduct(DeleteProductCommand command);
}
