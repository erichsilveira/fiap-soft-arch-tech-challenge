package com.fiap.techchallenge.application.domain.service.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.port.in.order.UpdateOrderCommand;
import com.fiap.techchallenge.application.port.in.order.UpdateOrderUseCase;
import com.fiap.techchallenge.application.port.out.order.UpdateOrderPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class UpdateOrderService implements UpdateOrderUseCase {

    private final UpdateOrderPort updatePort;

    @Override
    public Order updateOrder(UpdateOrderCommand command) throws ResourceNotFoundException {
        log.info("Updating order {} to status {}", command.entityId(), command.status());
        return updatePort.updateOrder(command.entityId(), command.status());
    }
}
