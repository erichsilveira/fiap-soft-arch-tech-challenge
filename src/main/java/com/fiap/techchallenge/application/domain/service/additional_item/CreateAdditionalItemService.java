package com.fiap.techchallenge.application.domain.service.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.in.additional_item.CreateAdditionalItemUseCase;
import com.fiap.techchallenge.application.port.out.additional_item.CreateAdditionalItemPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class CreateAdditionalItemService implements CreateAdditionalItemUseCase {

    private final CreateAdditionalItemPort registerPort;

    @Override
    public AdditionalItem createAdditionalItem(AdditionalItem domainEntity) {
        log.info("Creating AdditionalItem: {}", domainEntity.getName());
        return registerPort.createAdditionalItem(domainEntity);
    }
}
