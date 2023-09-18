package com.fiap.techchallenge.entrypoint.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/hello")
public class HelloWorldEndpoint {

    @GetMapping
    public ResponseEntity<Object> hello() {
        log.info("Hello from logs =)");
        return ResponseEntity.ok().body("Hello from backend =)");
    }
}