package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.ProductCreationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.ProductRestMapper;
import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.in.product.CreateProductUseCase;
import com.fiap.techchallenge.application.port.in.product.SearchProductCommand;
import com.fiap.techchallenge.application.port.in.product.SearchProductUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final CreateProductUseCase createUseCase;

    private final SearchProductUseCase searchUseCase;

    private final ProductRestMapper restMapper;

    @PostMapping
    ResponseEntity<Product> create(
        @RequestBody @Valid ProductCreationRequest registrationRequest) {
        var domainEntity = createUseCase.createProduct(
            restMapper.toDomainEntity(registrationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<Product>> search(
        @RequestParam(required = false) String productCategoryId) {
        var domainEntities = searchUseCase.searchProducts(
            new SearchProductCommand(productCategoryId));

        return ResponseEntity.ok(domainEntities);
    }
}
