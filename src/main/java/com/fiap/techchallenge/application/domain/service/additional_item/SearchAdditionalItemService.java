package com.fiap.techchallenge.application.domain.service.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.in.additional_item.SearchAdditionalItemUseCase;
import com.fiap.techchallenge.application.port.out.additional_item.SearchAdditionalItemPort;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SearchAdditionalItemService implements SearchAdditionalItemUseCase {

    private final SearchAdditionalItemPort searchPort;

    @Override
    public List<AdditionalItem> searchAdditionalItems() {
        return searchPort.searchAdditionalItems();
    }
}
