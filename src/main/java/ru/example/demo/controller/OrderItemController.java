package ru.example.demo.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.example.demo.entity.OrderItem;
import ru.example.demo.service.OrderItemService;

import java.util.List;

@Controller
@RequestMapping("/order-items")
@AllArgsConstructor
public class OrderItemController {
    private final OrderItemService orderItemService;

    @GetMapping("/")
    public String listOrderItems(Model model) {
        List<OrderItem> orderItems = orderItemService.getAllOrderItems();
        model.addAttribute("orderItems", orderItems);
        return "order-item-list";
    }

    @GetMapping("/new")
    public String createOrderItemForm(Model model) {
        model.addAttribute("orderItem", new OrderItem());
        return "order-item-form";
    }

    @PostMapping("/save")
    public String saveOrderItem(@ModelAttribute OrderItem orderItem) {
        orderItemService.addOrderItem(orderItem);
        return "redirect:/order-items/";
    }

    @PostMapping("/delete/{id}")
    public String deleteOrderItem(@PathVariable Integer id) {
        orderItemService.deleteOrderItem(id);
        return "redirect:/order-items/";
    }
}

