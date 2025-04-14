package io.github.devansh2991.zaptrolley.order;

import io.github.devansh2991.zaptrolley.user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    private final DatabaseOrderService databaseOrderService;

    @Autowired
    public OrderController(DatabaseOrderService databaseOrderService) {
        this.databaseOrderService = databaseOrderService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createOrder(@RequestBody Order order) {
        Order createdOrder = databaseOrderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Order> getOrder(@PathVariable Long orderId) {
        Order order = databaseOrderService.getOrderById(orderId);
        return ResponseEntity.ok(order);
    }
}
