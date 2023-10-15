package com.fiap.techchallenge.adapter.in.rest.data.response;

public record CustomerLoginResponse(String token, Long exp, String sub) {

}
