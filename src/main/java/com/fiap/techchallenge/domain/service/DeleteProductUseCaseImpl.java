package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.DeleteProductUseCase;
import com.fiap.techchallenge.domain.repository.ProductRepository;
import com.fiap.techchallenge.interfaces.dto.DeleteProductCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class DeleteProductUseCaseImpl implements DeleteProductUseCase {

    private final ProductRepository repository;

    @Override
    public void deleteProduct(DeleteProductCommand command) {
        repository.deleteProduct(command.entityId());
    }
}
