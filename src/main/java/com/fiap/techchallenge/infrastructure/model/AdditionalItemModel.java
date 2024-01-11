package com.fiap.techchallenge.infrastructure.model;

import com.fiap.techchallenge.domain.entity.AdditionalItem;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "additional_items")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AdditionalItemModel {

    public static AdditionalItemModel toAdditionalItemModel(AdditionalItem additionalItem) {
        return AdditionalItemModel.builder()
            .id(additionalItem.getId())
            .name(additionalItem.getName())
            .description(additionalItem.getDescription())
            .price(additionalItem.getPrice())
            .productCategoryId(additionalItem.getProductCategoryId())
            .createdAt(additionalItem.getCreatedAt())
            .updatedAt(additionalItem.getUpdatedAt())
            .build();
    }

    public static AdditionalItem toAdditionalItem(AdditionalItemModel additionalItemModel) {
        return AdditionalItem.builder()
            .id(additionalItemModel.getId())
            .name(additionalItemModel.getName())
            .description(additionalItemModel.getDescription())
            .price(additionalItemModel.getPrice())
            .productCategoryId(additionalItemModel.getProductCategoryId())
            .createdAt(additionalItemModel.getCreatedAt())
            .updatedAt(additionalItemModel.getUpdatedAt())
            .build();
    }

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;

    private String description;

    private BigDecimal price;

    private String productCategoryId;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
