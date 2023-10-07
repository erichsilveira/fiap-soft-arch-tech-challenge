package com.fiap.techchallenge.application.port.out.product;

import com.fiap.techchallenge.application.domain.model.Product;

public interface CreateProductPort {

    Product createProduct(Product domainEntity);
}
