package com.fiap.techchallenge.application.port.out.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import java.util.List;

public interface SearchProductCategoryPort {

    List<ProductCategory> searchProductCategories();
}
