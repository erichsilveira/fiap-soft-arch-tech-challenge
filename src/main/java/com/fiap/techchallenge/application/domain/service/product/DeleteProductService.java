package com.fiap.techchallenge.application.domain.service.product;

import com.fiap.techchallenge.application.port.in.product.DeleteProductCommand;
import com.fiap.techchallenge.application.port.in.product.DeleteProductUseCase;
import com.fiap.techchallenge.application.port.out.product.DeleteProductPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class DeleteProductService implements DeleteProductUseCase {

    private final DeleteProductPort deletePort;

    @Override
    public void deleteProduct(DeleteProductCommand command) {
        log.warn("Deleting product: {}", command.entityId());
        deletePort.deleteProduct(command.entityId());
    }
}
