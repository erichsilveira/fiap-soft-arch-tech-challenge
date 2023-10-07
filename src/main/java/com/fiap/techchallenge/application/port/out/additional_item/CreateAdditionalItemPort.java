package com.fiap.techchallenge.application.port.out.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;

public interface CreateAdditionalItemPort {

    AdditionalItem createAdditionalItem(AdditionalItem domainEntity);
}
