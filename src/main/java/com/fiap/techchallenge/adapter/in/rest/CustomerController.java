package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.CustomerRestMapper;
import com.fiap.techchallenge.application.port.in.RegisterCustomerUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {

    private final RegisterCustomerUseCase registerCustomerUseCase;

    private final CustomerRestMapper customerRestMapper;

    @PostMapping
    void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest){
        registerCustomerUseCase.registerCustomer(customerRestMapper.mapToDomainEntity(customerRegistrationRequest));
    }
}
