package com.fiap.techchallenge.adapter.in.rest;

import com.fiap.techchallenge.adapter.in.rest.data.request.AdditionalItemCreationRequest;
import com.fiap.techchallenge.adapter.in.rest.mapper.AdditionalItemRestMapper;
import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.in.additional_item.CreateAdditionalItemUseCase;
import com.fiap.techchallenge.application.port.in.additional_item.SearchAdditionalItemUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    ResponseEntity<List<AdditionalItem>> search() {
        var domainEntities = searchUseCase.searchAdditionalItems();

        return ResponseEntity.ok(domainEntities);
    }
}
