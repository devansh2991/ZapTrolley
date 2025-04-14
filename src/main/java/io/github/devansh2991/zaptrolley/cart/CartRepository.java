package io.github.devansh2991.zaptrolley.cart;

import io.github.devansh2991.zaptrolley.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUser(User user);
}
