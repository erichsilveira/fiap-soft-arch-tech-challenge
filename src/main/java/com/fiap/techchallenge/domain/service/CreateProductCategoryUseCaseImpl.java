package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreateProductCategoryUseCase;
import com.fiap.techchallenge.domain.entity.ProductCategory;
import com.fiap.techchallenge.domain.repository.ProductCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductCategoryUseCaseImpl implements CreateProductCategoryUseCase {

    private final ProductCategoryRepository repository;

    @Override
    public ProductCategory createProductCategory(ProductCategory domainEntity) {
        return repository.createProductCategory(domainEntity);
    }
}
