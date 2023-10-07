package com.fiap.techchallenge.application.domain.service.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import com.fiap.techchallenge.application.port.in.product_category.CreateProductCategoryUseCase;
import com.fiap.techchallenge.application.port.out.product_category.CreateProductCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductCategoryService implements CreateProductCategoryUseCase {

    private final CreateProductCategoryPort registerPort;

    @Override
    public ProductCategory createProductCategory(ProductCategory domainEntity) {
        return registerPort.createProductCategory(domainEntity);
    }
}
