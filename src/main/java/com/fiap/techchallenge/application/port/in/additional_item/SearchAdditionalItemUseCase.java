package com.fiap.techchallenge.application.port.in.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;

import java.util.List;

public interface SearchAdditionalItemUseCase {

    List<AdditionalItem> searchAdditionalItems(SearchAdditionalItemCommand command);
}
