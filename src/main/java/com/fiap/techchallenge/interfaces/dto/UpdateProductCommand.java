package com.fiap.techchallenge.interfaces.dto;

import com.fiap.techchallenge.domain.entity.Product;

public record UpdateProductCommand(String entityId, Product domainEntity) {

}
