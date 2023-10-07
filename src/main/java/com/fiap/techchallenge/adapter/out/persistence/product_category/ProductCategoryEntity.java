package com.fiap.techchallenge.adapter.out.persistence.product_category;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

@Entity
@Table(name = "customers")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductCategoryEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private String name;

    private String description;
}
