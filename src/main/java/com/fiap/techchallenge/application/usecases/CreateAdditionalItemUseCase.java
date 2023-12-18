package com.fiap.techchallenge.application.usecases;

import com.fiap.techchallenge.domain.entity.AdditionalItem;

public interface CreateAdditionalItemUseCase {

    AdditionalItem createAdditionalItem(AdditionalItem command);
}
