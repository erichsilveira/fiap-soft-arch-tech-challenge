package com.fiap.techchallenge.application.domain.service.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.port.in.order.SearchOrderByIdCommand;
import com.fiap.techchallenge.application.port.in.order.SearchOrderCommand;
import com.fiap.techchallenge.application.port.in.order.SearchOrderUseCase;
import com.fiap.techchallenge.application.port.out.order.SearchOrderPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@RequiredArgsConstructor
@Service
public class SearchOrderService implements SearchOrderUseCase {

    private final SearchOrderPort searchPort;

    @Override
    public List<Order> searchOrders(SearchOrderCommand command) {
        return searchPort.searchOrders(command.cpf(), command.status());
    }

    @Override
    public Order searchOrderById(SearchOrderByIdCommand command) throws ResourceNotFoundException {
        return searchPort.searchOrderById(command.id());
    }
}
