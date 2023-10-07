package com.fiap.techchallenge.adapter.out.persistence.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.out.additional_item.CreateAdditionalItemPort;
import com.fiap.techchallenge.application.port.out.additional_item.SearchAdditionalItemPort;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AdditionalItemPersistenceAdapter implements CreateAdditionalItemPort,
    SearchAdditionalItemPort {

    private final SpringDataAdditionalItemRepository springDataRepository;

    private final AdditionalItemEntityMapper entityMapper;

    @Override
    public AdditionalItem createAdditionalItem(AdditionalItem domainEntity) {
        var entity = entityMapper.fromDomainEntity(domainEntity);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public List<AdditionalItem> searchAdditionalItems() {
        return StreamSupport.stream(springDataRepository.findAll().spliterator(), false)
            .map(entityMapper::toDomainEntity)
            .collect(Collectors.toList());
    }
}
