package ru.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.example.demo.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
}

