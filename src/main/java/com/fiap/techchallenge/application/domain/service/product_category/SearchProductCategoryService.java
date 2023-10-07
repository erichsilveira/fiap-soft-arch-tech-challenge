package com.fiap.techchallenge.application.domain.service.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import com.fiap.techchallenge.application.port.in.product_category.SearchProductCategoryUseCase;
import com.fiap.techchallenge.application.port.out.product_category.SearchProductCategoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchProductCategoryService implements SearchProductCategoryUseCase {

    private final SearchProductCategoryPort searchPort;

    @Override
    public List<ProductCategory> searchProductCategories() {
        return searchPort.searchProductCategories();
    }
}
