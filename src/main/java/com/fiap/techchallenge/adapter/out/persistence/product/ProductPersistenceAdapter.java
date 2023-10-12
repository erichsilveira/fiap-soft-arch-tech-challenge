package com.fiap.techchallenge.adapter.out.persistence.product;

import com.fiap.techchallenge.application.domain.exception.ResourceNotFoundException;
import com.fiap.techchallenge.application.domain.model.Product;
import com.fiap.techchallenge.application.port.out.product.CreateProductPort;
import com.fiap.techchallenge.application.port.out.product.DeleteProductPort;
import com.fiap.techchallenge.application.port.out.product.SearchProductPort;
import com.fiap.techchallenge.application.port.out.product.UpdateProductPort;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class ProductPersistenceAdapter implements CreateProductPort,
    SearchProductPort, UpdateProductPort, DeleteProductPort {

    private final ProductJpaRepository springDataRepository;

    private final ProductEntityMapper entityMapper;

    @Override
    public Product createProduct(Product domainEntity) {
        var entity = entityMapper.fromDomainEntity(domainEntity);

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }

    @Override
    public List<Product> searchProducts(String productCategoryId) {
        var filter = ProductEntity.builder();

        if (StringUtils.isNotBlank(productCategoryId)) {
            filter.productCategoryId(productCategoryId);
        }

        var entities = springDataRepository.findAll(Example.of(filter.build()),
            Sort.by(Sort.Direction.DESC, "name"));

        return entities.stream()
            .map(entityMapper::toDomainEntity).toList();
    }

    @Override
    public void deleteProduct(String entityId) {
        springDataRepository.deleteById(entityId);
    }

    @Override
    public Product updateProduct(String entityId, Product domainEntity)
        throws ResourceNotFoundException {
        var entity = springDataRepository.findById(entityId)
            .orElseThrow(ResourceNotFoundException::new);

        entity.setDescription(domainEntity.getDescription());
        entity.setName(domainEntity.getName());
        entity.setPrice(domainEntity.getPrice());

        springDataRepository.save(entity);

        return entityMapper.toDomainEntity(entity);
    }
}
