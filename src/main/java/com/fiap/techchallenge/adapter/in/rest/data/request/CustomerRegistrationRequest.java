package com.fiap.techchallenge.adapter.in.rest.data.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CustomerRegistrationRequest {

    private String cpf;

    private String name;

    private String email;

}
