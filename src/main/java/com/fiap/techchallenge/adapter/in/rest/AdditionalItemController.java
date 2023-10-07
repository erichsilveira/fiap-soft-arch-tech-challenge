package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.AdditionalItemCreationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.AdditionalItemRestMapper;
import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.in.additional_item.CreateAdditionalItemUseCase;
import com.fiap.techchallenge.application.port.in.additional_item.SearchAdditionalItemCommand;
import com.fiap.techchallenge.application.port.in.additional_item.SearchAdditionalItemUseCase;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/additional_items")
@RequiredArgsConstructor
public class AdditionalItemController {

    private final CreateAdditionalItemUseCase createUseCase;

    private final SearchAdditionalItemUseCase searchUseCase;

    private final AdditionalItemRestMapper restMapper;

    @PostMapping
    ResponseEntity<AdditionalItem> create(
        @RequestBody @Valid AdditionalItemCreationRequest registrationRequest) {
        var domainEntity = createUseCase.createAdditionalItem(
            restMapper.toDomainEntity(registrationRequest));

        return new ResponseEntity<>(domainEntity, HttpStatus.CREATED);
    }

    @GetMapping
    ResponseEntity<List<AdditionalItem>> search(
        @RequestParam(required = false) String productCategoryId) {
        var domainEntities = searchUseCase.searchAdditionalItems(
            new SearchAdditionalItemCommand(productCategoryId));

        return ResponseEntity.ok(domainEntities);
    }
}
