package com.fiap.techchallenge.application.port.out.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.domain.model.OrderStatus;
import com.fiap.techchallenge.application.domain.model.Product;

public interface UpdateOrderPort {

    Order updateOrder(String entityId, OrderStatus status) throws ResourceNotFoundException;
}
