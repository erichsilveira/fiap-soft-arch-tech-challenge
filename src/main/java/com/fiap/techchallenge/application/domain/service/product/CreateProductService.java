package com.fiap.techchallenge.application.domain.service.product;

import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.product.CreateProductUseCase;
import com.fiap.techchallenge.application.port.out.product.CreateProductPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort registerPort;

    @Override
    public Product createProduct(Product domainEntity) {
        return registerPort.createProduct(domainEntity);
    }
}
