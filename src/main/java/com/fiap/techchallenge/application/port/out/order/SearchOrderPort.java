package com.fiap.techchallenge.application.port.out.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.domain.model.OrderStatus;
import java.util.List;

public interface SearchOrderPort {

    List<Order> searchOrders(String cpf, OrderStatus status);

    Order searchOrderById(String id) throws ResourceNotFoundException;
}
