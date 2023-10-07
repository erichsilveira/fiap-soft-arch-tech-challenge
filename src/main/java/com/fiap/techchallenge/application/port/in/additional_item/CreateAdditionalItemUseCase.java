package com.fiap.techchallenge.application.port.in.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;

public interface CreateAdditionalItemUseCase {

    AdditionalItem createAdditionalItem(AdditionalItem command);
}
