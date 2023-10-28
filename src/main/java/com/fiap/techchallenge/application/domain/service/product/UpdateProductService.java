package com.fiap.techchallenge.application.domain.service.product;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.product.UpdateProductCommand;
import com.fiap.techchallenge.application.port.in.product.UpdateProductUseCase;
import com.fiap.techchallenge.application.port.out.product.UpdateProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UpdateProductService implements UpdateProductUseCase {

    private final UpdateProductPort updatePort;

    @Override
    public Product updateProduct(UpdateProductCommand command) throws ResourceNotFoundException {
        log.info("Updating product: {}", command.entityId());
        return updatePort.updateProduct(command.entityId(), command.domainEntity());
    }
}
