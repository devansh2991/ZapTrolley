package io.github.devansh2991.zaptrolley.order.repository;

import io.github.devansh2991.zaptrolley.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByOrderId(long orderId);

    Order findFirstByOrderId(long orderId);
}
