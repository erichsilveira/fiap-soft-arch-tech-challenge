package com.fiap.techchallenge.application.port.in.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import java.util.List;

public interface SearchOrderUseCase {

    List<Order> searchOrders(SearchOrderCommand command);

    Order searchOrderById(SearchOrderByIdCommand command) throws ResourceNotFoundException;
}
