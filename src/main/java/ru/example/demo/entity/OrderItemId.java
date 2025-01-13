package ru.example.demo.entity;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class OrderItemId implements Serializable {
    private Integer orderId;
    private Integer menuId;
}

