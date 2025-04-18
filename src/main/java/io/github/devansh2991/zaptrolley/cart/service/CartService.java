package io.github.devansh2991.zaptrolley.cart.service;

import io.github.devansh2991.zaptrolley.cart.model.Cart;

public interface CartService {
    Cart getCart(Long userId);
    void addToCart(Long userId, Long productId, int quantity);
    void removeFromCart(Long cartItemId);
    void clearCart(Long userId);
}
