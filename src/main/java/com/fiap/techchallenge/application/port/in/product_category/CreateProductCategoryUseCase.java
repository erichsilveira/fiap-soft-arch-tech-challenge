package com.fiap.techchallenge.application.port.in.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;

public interface CreateProductCategoryUseCase {

    ProductCategory createProductCategory(ProductCategory command);
}
