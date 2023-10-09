package com.fiap.techchallenge.adapter.out.persistence.product_category;

import com.fiap.techchallenge.application.domain.model.ProductCategory;
import com.fiap.techchallenge.application.port.out.product_category.CreateProductCategoryPort;
import com.fiap.techchallenge.application.port.out.product_category.SearchProductCategoryPort;
import java.util.List;
import java.util.stream.StreamSupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductCategoryPersistenceAdapter implements CreateProductCategoryPort,
    SearchProductCategoryPort {

    private final ProductCategoryJpaRepository springDataRepository;

    private final ProductCategoryEntityMapper entityMapper;

    @Override
    public ProductCategory createProductCategory(ProductCategory domainEntity) {
        var entity = entityMapper.fromDomainEntity(domainEntity);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public List<ProductCategory> searchProductCategories() {
        return StreamSupport.stream(springDataRepository.findAll().spliterator(), false)
            .map(entityMapper::toDomainEntity)
            .toList();
    }
}
