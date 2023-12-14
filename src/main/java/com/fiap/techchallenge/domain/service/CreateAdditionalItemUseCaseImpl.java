package com.fiap.techchallenge.domain.service;

import com.fiap.techchallenge.application.usecases.CreateAdditionalItemUseCase;
import com.fiap.techchallenge.domain.entity.AdditionalItem;
import com.fiap.techchallenge.domain.repository.AdditionalItemRepository;
import com.fiap.techchallenge.infrastructure.model.AdditionalItemModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateAdditionalItemUseCaseImpl implements CreateAdditionalItemUseCase {

    private final AdditionalItemRepository repository;

    @Override
    public AdditionalItem createAdditionalItem(AdditionalItem additionalItem) {
        return repository.createAdditionalItem(additionalItem);
    }
}
