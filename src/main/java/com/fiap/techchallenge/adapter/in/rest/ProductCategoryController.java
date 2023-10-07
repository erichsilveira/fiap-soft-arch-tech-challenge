package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.ProductCategoryCreationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.ProductCategoryRestMapper;
import com.fiap.techchallenge.application.domain.model.ProductCategory;
import com.fiap.techchallenge.application.port.in.product_category.CreateProductCategoryUseCase;
import com.fiap.techchallenge.application.port.in.product_category.SearchProductCategoryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/product_categories")
@RequiredArgsConstructor
public class ProductCategoryController {

    private final CreateProductCategoryUseCase createUseCase;

    private final SearchProductCategoryUseCase searchUseCase;

    private final ProductCategoryRestMapper restMapper;

    @PostMapping
    ResponseEntity<ProductCategory> create(
        @RequestBody ProductCategoryCreationRequest registrationRequest) {
        var domainEntity = createUseCase.createProductCategory(
            restMapper.toDomainEntity(registrationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<ProductCategory>> search() {
        var domainEntities = searchUseCase.searchProductCategories();

        return ResponseEntity.ok(domainEntities);
    }
}
