package com.fiap.techchallenge.adapter.out.persistence.order;

import com.fiap.techchallenge.adapter.out.persistence.product.ProductEntity;
import com.fiap.techchallenge.application.domain.model.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.UuidGenerator;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderEntity {

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    @OneToMany(fetch = FetchType.LAZY)
    private List<ProductEntity> products;

    private BigDecimal orderPrice;

    private OrderStatus status;

    private String customerId;

    private String customerCpf;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
