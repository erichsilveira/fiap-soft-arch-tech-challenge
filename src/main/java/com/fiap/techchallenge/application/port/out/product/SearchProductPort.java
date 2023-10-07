package com.fiap.techchallenge.application.port.out.product;

import com.fiap.techchallenge.application.domain.model.Product;
import java.util.List;

public interface SearchProductPort {

    List<Product> searchProducts(String productCategoryId);
}
