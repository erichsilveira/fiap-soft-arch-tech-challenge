package com.fiap.techchallenge.adapter.out.persistence.additional_item;

import com.fiap.techchallenge.application.domain.model.AdditionalItem;
import com.fiap.techchallenge.application.port.out.additional_item.CreateAdditionalItemPort;
import com.fiap.techchallenge.application.port.out.additional_item.SearchAdditionalItemPort;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class AdditionalItemPersistenceAdapter implements CreateAdditionalItemPort,
    SearchAdditionalItemPort {

    private final AdditionalItemJpaRepository springDataRepository;

    private final AdditionalItemEntityMapper entityMapper;

    @Override
    public AdditionalItem createAdditionalItem(AdditionalItem domainEntity) {
        var entity = entityMapper.fromDomainEntity(domainEntity);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public List<AdditionalItem> searchAdditionalItems(String productCategoryId) {
        var filter = AdditionalItemEntity.builder();

        if (StringUtils.isNotBlank(productCategoryId)) {
            filter.productCategoryId(productCategoryId);
        }

        var entities = springDataRepository.findAll(Example.of(filter.build()),
            Sort.by(Sort.Direction.DESC, "name"));

        return entities.stream()
            .map(entityMapper::toDomainEntity)
            .toList();
    }
}
