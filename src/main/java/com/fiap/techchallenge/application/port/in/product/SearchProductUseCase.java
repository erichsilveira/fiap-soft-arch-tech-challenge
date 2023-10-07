package com.fiap.techchallenge.application.port.in.product;

import com.fiap.techchallenge.application.domain.model.Product;
import java.util.List;

public interface SearchProductUseCase {

    List<Product> searchProducts(SearchProductCommand command);
}
