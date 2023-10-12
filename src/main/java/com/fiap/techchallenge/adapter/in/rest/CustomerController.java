package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.CustomerRestMapper;
import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.in.customer.ExistsCustomerUseCase;
import com.fiap.techchallenge.application.port.in.customer.RegisterCustomerUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final RegisterCustomerUseCase registerUseCase;
    private final ExistsCustomerUseCase existsCustomerUseCase;

    private final CustomerRestMapper restMapper;

    @PostMapping
    ResponseEntity<Customer> register(
        @RequestBody @Valid CustomerRegistrationRequest registrationRequest) {
        var domainEntity = registerUseCase.registerCustomer(
            restMapper.toDomainEntity(registrationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }

    @RequestMapping(method = {RequestMethod.HEAD})
    ResponseEntity<String> exists(@RequestParam @Valid String cpf) {
        boolean exists = existsCustomerUseCase.existsCustomer(cpf);
        return new ResponseEntity<>(exists ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

}
