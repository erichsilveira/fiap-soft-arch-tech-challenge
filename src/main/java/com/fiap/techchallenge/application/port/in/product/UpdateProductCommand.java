package com.fiap.techchallenge.application.port.in.product;

import com.fiap.techchallenge.application.domain.model.Product;

public record UpdateProductCommand(String entityId, Product domainEntity) {

}
