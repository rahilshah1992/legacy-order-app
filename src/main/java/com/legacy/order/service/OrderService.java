package com.legacy.order.service;

import com.legacy.order.dao.OrderDAO;
import com.legacy.order.model.Order;

public class OrderService {

    private OrderDAO dao = new OrderDAO();

    public Order getOrderById(int id) {
        if (id <= 0) {
            throw new RuntimeException("Invalid Order ID");
        }
        return dao.fetchOrder(id);
    }

    public void createOrder(Order order) {
        if (order.getAmount() > 10000) {
            System.out.println("High value order");
        }
        dao.saveOrder(order);
    }
}
