package io.github.devansh2991.zaptrolley.cart;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class InMemoryCartService implements CartService {

    private final Map<Long, List<CartItem>> cartMap = new HashMap<>();

    @Override
    public Cart getCart(Long userId) {
        return new Cart(cartMap.getOrDefault(userId, new ArrayList<>()));
    }

    @Override
    public void addToCart(Long userId, Long productId, int quantity) {
        cartMap.putIfAbsent(userId, new ArrayList<>());
        cartMap.get(userId).add(new CartItem(null, null, quantity)); // Mock objects
    }

    @Override
    public void removeFromCart(Long cartItemId) {
        cartMap.values().forEach(list -> list.removeIf(item -> item.getId().equals(cartItemId)));
    }

    @Override
    public void clearCart(Long userId) {
        cartMap.remove(userId);
    }
}
