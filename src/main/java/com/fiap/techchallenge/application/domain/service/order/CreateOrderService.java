package com.fiap.techchallenge.application.domain.service.order;

import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.port.in.order.CreateOrderUseCase;
import com.fiap.techchallenge.application.port.out.order.CreateOrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateOrderService implements CreateOrderUseCase {

    private final CreateOrderPort createPort;

    @Override
    public Order createOrder(Order domainEntity) {
        log.info("Creating order for customer cpf {} orderId {}",
            domainEntity.getCustomerCpf(), domainEntity.getId());
        return createPort.createOrder(domainEntity);
    }
}
