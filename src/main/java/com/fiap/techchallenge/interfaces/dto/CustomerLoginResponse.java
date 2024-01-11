package com.fiap.techchallenge.interfaces.dto;

public record CustomerLoginResponse(String token, Long exp, String sub) {

}
