package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.ProductCategory;

public interface CreateProductCategoryUseCase {

    ProductCategory createProductCategory(ProductCategory command);
}
