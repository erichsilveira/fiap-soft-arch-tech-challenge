package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.ProductCategory;
import java.util.List;

public interface SearchProductCategoryUseCase {

    List<ProductCategory> searchProductCategories();
}
