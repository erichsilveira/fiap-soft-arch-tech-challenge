package com.fiap.techchallenge.application.domain.service.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.in.additional_item.CreateAdditionalItemUseCase;
import com.fiap.techchallenge.application.port.out.additional_item.CreateAdditionalItemPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateAdditionalItemService implements CreateAdditionalItemUseCase {

    private final CreateAdditionalItemPort registerPort;

    @Override
    public AdditionalItem createAdditionalItem(AdditionalItem domainEntity) {
        return registerPort.createAdditionalItem(domainEntity);
    }
}
