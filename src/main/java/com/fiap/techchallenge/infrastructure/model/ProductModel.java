package com.fiap.techchallenge.infrastructure.model;

import com.fiap.techchallenge.domain.entity.Product;
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
@Table(name = "products")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductModel {

    public static ProductModel toProductModel(Product product) {
        return ProductModel.builder()
            .id(product.getId())
            .name(product.getName())
            .description(product.getDescription())
            .price(product.getPrice())
            .productCategoryId(product.getProductCategoryId())
            .createdAt(product.getCreatedAt())
            .updatedAt(product.getUpdatedAt())
            .build();
    }

    public static Product toProduct(ProductModel productModel) {
        return Product.builder()
            .id(productModel.getId())
            .name(productModel.getName())
            .description(productModel.getDescription())
            .price(productModel.getPrice())
            .productCategoryId(productModel.getProductCategoryId())
            .createdAt(productModel.getCreatedAt())
            .updatedAt(productModel.getUpdatedAt())
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
