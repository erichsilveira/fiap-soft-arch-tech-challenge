package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.CustomerRestMapper;
import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.in.customer.RegisterCustomerUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final RegisterCustomerUseCase registerUseCase;

    private final CustomerRestMapper restMapper;

    @PostMapping
    ResponseEntity<Customer> register(
        @RequestBody @Valid CustomerRegistrationRequest registrationRequest) {
        var domainEntity = registerUseCase.registerCustomer(
            restMapper.toDomainEntity(registrationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }
}
