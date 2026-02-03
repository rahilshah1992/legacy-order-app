package com.legacy.order.controller;

import com.legacy.order.model.Order;
import com.legacy.order.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private OrderService service = new OrderService();

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id) {
        return service.getOrderById(id);
    }

    @PostMapping
    public String createOrder(@RequestBody Order order) {
        service.createOrder(order);
        return "Order Created";
    }
}
