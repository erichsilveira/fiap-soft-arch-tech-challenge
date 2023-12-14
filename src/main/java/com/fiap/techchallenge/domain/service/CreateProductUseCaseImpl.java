package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreateProductUseCase;
import com.fiap.techchallenge.domain.entity.Product;
import com.fiap.techchallenge.domain.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductUseCaseImpl implements CreateProductUseCase {

    private final ProductRepository repository;

    @Override
    public Product createProduct(Product domainEntity) {
        return repository.createProduct(domainEntity);
    }
}
