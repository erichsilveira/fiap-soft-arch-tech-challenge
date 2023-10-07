package com.fiap.techchallenge.application.port.out.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;

import java.util.List;

public interface SearchAdditionalItemPort {

    List<AdditionalItem> searchAdditionalItems();
}
