package io.github.devansh2991.zaptrolley.order;

public interface OrderService {
    Order getOrderById(Long orderId);

    Order createOrder(Order order);
}

