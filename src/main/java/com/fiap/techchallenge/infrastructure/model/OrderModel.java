package com.fiap.techchallenge.infrastructure.model;

import com.fiap.techchallenge.domain.entity.Order;
import com.fiap.techchallenge.domain.entity.OrderStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
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
public class OrderModel {


    public static OrderModel toOrderModel(Order order) {
        return OrderModel.builder()
            .id(order.getId())
            .productsId(order.getProductsId())
            .orderPrice(order.getOrderPrice())
            .status(order.getStatus())
            .customerId(order.getCustomerId())
            .customerCpf(order.getCustomerCpf())
            .createdAt(order.getCreatedAt())
            .updatedAt(order.getUpdatedAt())
            .build();
    }

    public static Order toOrder(OrderModel orderModel) {
        return Order.builder()
            .id(orderModel.getId())
            .productsId(orderModel.getProductsId())
            .orderPrice(orderModel.getOrderPrice())
            .status(orderModel.getStatus())
            .customerId(orderModel.getCustomerId())
            .customerCpf(orderModel.getCustomerCpf())
            .createdAt(orderModel.getCreatedAt())
            .updatedAt(orderModel.getUpdatedAt())
            .build();
    }

    @Id
    @GeneratedValue
    @UuidGenerator
    private String id;

    private List<String> productsId;

    private BigDecimal orderPrice;

    private OrderStatus status;

    private String customerId;

    private String customerCpf;

    @CreationTimestamp
    private ZonedDateTime createdAt;

    @UpdateTimestamp
    private ZonedDateTime updatedAt;
}
