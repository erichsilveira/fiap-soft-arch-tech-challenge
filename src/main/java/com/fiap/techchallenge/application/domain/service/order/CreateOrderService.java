package com.fiap.techchallenge.application.domain.service.order;

import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.port.in.order.CreateOrderUseCase;
import com.fiap.techchallenge.application.port.out.order.CreateOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final CreateOrderPort createPort;

    @Override
    public Order createOrder(Order domainEntity) {
        return createPort.createOrder(domainEntity);
    }
}
