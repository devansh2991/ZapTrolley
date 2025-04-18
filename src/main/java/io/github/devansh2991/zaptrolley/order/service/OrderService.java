package io.github.devansh2991.zaptrolley.order.service;

import io.github.devansh2991.zaptrolley.order.model.Order;

public interface OrderService {
    Order getOrderById(Long orderId);

    Order createOrder(Order order);
}

