package com.fiap.techchallenge.adapter.out.persistence.order;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Order;
import com.fiap.techchallenge.application.domain.model.OrderStatus;
import com.fiap.techchallenge.application.port.out.order.CreateOrderPort;
import com.fiap.techchallenge.application.port.out.order.SearchOrderPort;
import com.fiap.techchallenge.application.port.out.order.UpdateOrderPort;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;
import java.util.List;

@RequiredArgsConstructor
@Component
public class OrderPersistenceAdapter implements UpdateOrderPort,
    SearchOrderPort, CreateOrderPort {

    private final OrderJpaRepository springDataRepository;

    private final OrderEntityMapper entityMapper;

    @Override
    public List<Order> searchOrders(String cpf, OrderStatus status) {
        var filter = OrderEntity.builder();

        if (StringUtils.isNotBlank(cpf)) {
            filter.customerCpf(cpf);
        }

        if (status != null) {
            filter.status(status);
        }

        var entities = springDataRepository.findAll(Example.of(filter.build()),
            Sort.by(Sort.Direction.DESC, "id"));

        return entities.stream()
            .map(entityMapper::toDomainEntity).toList();
    }

    @Override
    public Order searchOrderById(String entityId) throws ResourceNotFoundException {
        var entity = springDataRepository.findById(entityId)
            .orElseThrow(ResourceNotFoundException::new);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public Order updateOrder(String entityId, OrderStatus status)
        throws ResourceNotFoundException {
        var entity = springDataRepository.findById(entityId)
            .orElseThrow(ResourceNotFoundException::new);

        entity.setStatus(status);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public Order createOrder(Order domainEntity) {
        var entity = entityMapper.fromDomainEntity(domainEntity);

        entity.setStatus(OrderStatus.REQUESTED);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }
}
