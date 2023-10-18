package com.fiap.techchallenge.application.domain.service.order;

import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.order.CreateOrderUseCase;
import com.fiap.techchallenge.application.port.out.order.CreateOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;

@RequiredArgsConstructor
@Service
public class CreateOrderService implements CreateOrderUseCase {

    private final CreateOrderPort createPort;

    @Override
    public Order createOrder(Order domainEntity) {

        var orderPrice = domainEntity.getProducts().stream().map(Product::getPrice)
            .reduce(BigDecimal.ZERO, BigDecimal::add);

        domainEntity.setOrderPrice(orderPrice);

        return createPort.createOrder(domainEntity);
    }
}
