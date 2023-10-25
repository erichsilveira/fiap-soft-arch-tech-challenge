package com.fiap.techchallenge.application.port.in.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;

public interface UpdateOrderUseCase {

    Order updateOrder(UpdateOrderCommand command) throws ResourceNotFoundException;
}
