package com.fiap.techchallenge.application.port.in.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import java.util.List;

public interface SearchProductCategoryUseCase {

    List<ProductCategory> searchProductCategories();
}
