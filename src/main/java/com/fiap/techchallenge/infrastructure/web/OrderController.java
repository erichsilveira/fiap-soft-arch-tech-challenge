package com.fiap.techchallenge.infrastructure.web;

import com.fiap.techchallenge.application.usecases.CreateOrderUseCase;
import com.fiap.techchallenge.application.usecases.SearchOrderUseCase;
import com.fiap.techchallenge.application.usecases.UpdateOrderUseCase;
import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.entity.OrderStatus;
import com.fiap.techchallenge.exception.ResourceNotFoundException;
import com.fiap.techchallenge.interfaces.dto.OrderCreationRequest;
import com.fiap.techchallenge.interfaces.dto.OrderUpdateRequest;
import com.fiap.techchallenge.interfaces.dto.SearchOrderByIdCommand;
import com.fiap.techchallenge.interfaces.dto.SearchOrderCommand;
import com.fiap.techchallenge.interfaces.dto.UpdateOrderCommand;
import com.fiap.techchallenge.interfaces.mapper.OrderRestMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final UpdateOrderUseCase updateUseCase;

    private final SearchOrderUseCase searchUseCase;

    private final CreateOrderUseCase createUseCase;

    private final OrderRestMapper restMapper;

    @GetMapping
    ResponseEntity<List<Order>> search(
        @RequestParam(required = false) String cpf,
        @RequestParam(required = false) OrderStatus status) {
        var domainEntities = searchUseCase.searchOrders(
            new SearchOrderCommand(cpf, status));

        return ResponseEntity.ok(domainEntities);
    }

    @GetMapping("/{id}")
    ResponseEntity<Order> searchById(
        @PathVariable String id) throws ResourceNotFoundException {
        var domainEntity = searchUseCase.searchOrderById(
            new SearchOrderByIdCommand(id));

        return ResponseEntity.ok(domainEntity);
    }

    @PutMapping("/{id}")
    ResponseEntity<Order> update(@PathVariable String id,
        @RequestBody @Valid OrderUpdateRequest updateRequest) {
        try {
            var domainEntity = updateUseCase.updateOrder(
                new UpdateOrderCommand(id, updateRequest.status()));

            return new ResponseEntity<>(domainEntity, HttpStatus.OK);

        } catch (ResourceNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    ResponseEntity<Order> create(
        @RequestBody @Valid OrderCreationRequest creationRequest) {
        var domainEntity = createUseCase.createOrder(
            restMapper.toDomainEntity(creationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }
}
