package com.fiap.techchallenge.application.domain.service.product;

import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.product.CreateProductUseCase;
import com.fiap.techchallenge.application.port.out.product.CreateProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateProductService implements CreateProductUseCase {

    private final CreateProductPort registerPort;

    @Override
    public Product createProduct(Product domainEntity) {
        log.info("Creating product {} with description {}", domainEntity.getName(), domainEntity.getDescription());
        return registerPort.createProduct(domainEntity);
    }
}
