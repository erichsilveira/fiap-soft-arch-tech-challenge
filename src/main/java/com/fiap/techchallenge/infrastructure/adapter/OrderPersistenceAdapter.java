package com.fiap.techchallenge.infrastructure.adapter;

import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.entity.OrderStatus;
import com.fiap.techchallenge.domain.repository.OrderRepository;
import com.fiap.techchallenge.exception.ResourceNotFoundException;
import com.fiap.techchallenge.infrastructure.model.OrderModel;
import com.fiap.techchallenge.infrastructure.persistence.OrderJpaRepository;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderPersistenceAdapter implements OrderRepository {

    private final OrderJpaRepository springDataRepository;

    @Override
    public List<Order> searchOrders(String cpf, OrderStatus status) {
        var filter = OrderModel.builder();

        if (StringUtils.isNotBlank(cpf)) {
            filter.customerCpf(cpf);
        }

        if (status != null) {
            filter.status(status);
        }

        var entities = springDataRepository.findAll(Example.of(filter.build()),
            Sort.by(Sort.Order.desc("status")).and(Sort.by(Sort.Order.asc("createdAt"))));

        return entities.stream()
            .filter(entity -> !OrderStatus.DELIVERED.equals(entity.getStatus()))
            .map(OrderModel::toOrder).toList();
    }

    @Override
    public Order searchOrderById(String entityId) throws ResourceNotFoundException {
        var model = springDataRepository.findById(entityId)
            .orElseThrow(ResourceNotFoundException::new);

        return OrderModel.toOrder(model);
    }

    @Override
    public Order updateOrder(String entityId, OrderStatus status)
        throws ResourceNotFoundException {
        var model = springDataRepository.findById(entityId)
            .orElseThrow(ResourceNotFoundException::new);

        model.setStatus(status);

        springDataRepository.save(model);

        return OrderModel.toOrder(model);
    }

    @Override
    public Order createOrder(Order order) {
        var model = OrderModel.toOrderModel(order);

        model.setStatus(OrderStatus.WAITING_PAYMENT);

        springDataRepository.save(model);

        return OrderModel.toOrder(model);
    }
}
