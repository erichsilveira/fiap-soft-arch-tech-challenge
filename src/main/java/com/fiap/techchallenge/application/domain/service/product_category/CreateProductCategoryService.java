package com.fiap.techchallenge.application.domain.service.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import com.fiap.techchallenge.application.port.in.product_category.CreateProductCategoryUseCase;
import com.fiap.techchallenge.application.port.out.product_category.CreateProductCategoryPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateProductCategoryService implements CreateProductCategoryUseCase {

    private final CreateProductCategoryPort registerPort;

    @Override
    public ProductCategory createProductCategory(ProductCategory domainEntity) {
        log.info("Creating ProductCategory {} with description {}",
            domainEntity.getName(), domainEntity.getDescription());
        return registerPort.createProductCategory(domainEntity);
    }
}
