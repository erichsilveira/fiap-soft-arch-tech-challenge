package com.fiap.techchallenge.application.domain.service.product;

import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.product.SearchProductCommand;
import com.fiap.techchallenge.application.port.in.product.SearchProductUseCase;
import com.fiap.techchallenge.application.port.out.product.SearchProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchProductService implements SearchProductUseCase {

    private final SearchProductPort searchPort;

    @Override
    public List<Product> searchProducts(SearchProductCommand command) {
        return searchPort.searchProducts(command.productCategoryId());
    }
}
