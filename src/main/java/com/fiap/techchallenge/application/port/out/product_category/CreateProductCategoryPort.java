package com.fiap.techchallenge.application.port.out.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;

public interface CreateProductCategoryPort {

    ProductCategory createProductCategory(ProductCategory domainEntity);
}
