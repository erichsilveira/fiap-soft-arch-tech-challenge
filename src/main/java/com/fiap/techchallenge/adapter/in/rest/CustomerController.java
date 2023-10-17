package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerLoginRequest;
import com.fiap.techchallenge.adapter.in.rest.data.request.CustomerRegistrationRequest;
import com.fiap.techchallenge.adapter.in.rest.data.response.CustomerLoginResponse;
import com.fiap.techchallenge.adapter.in.rest.mapper.CustomerRestMapper;
import com.fiap.techchallenge.application.domain.model.Customer;
import com.fiap.techchallenge.application.port.in.customer.ExistsCustomerUseCase;
import com.fiap.techchallenge.application.port.in.customer.RegisterCustomerUseCase;
import com.fiap.techchallenge.security.JwtUtil;
import com.fiap.techchallenge.security.JwtUtil.JwtToken;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    private final JwtUtil jwtUtil;

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

    @PostMapping(value = "/tokens")
    ResponseEntity<CustomerLoginResponse> login(
        @RequestBody @Valid CustomerLoginRequest loginRequest) {

        String cpf = loginRequest.cpf();
        if (!existsCustomerUseCase.existsCustomer(cpf)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        JwtToken jwtToken = jwtUtil.createToken(cpf);
        CustomerLoginResponse loginResponse =
            new CustomerLoginResponse(jwtToken.token(), jwtToken.exp(), jwtToken.sub());

        return new ResponseEntity<>(loginResponse, HttpStatus.OK);
    }

}
