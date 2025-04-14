package io.github.devansh2991.zaptrolley.cart;

import io.github.devansh2991.zaptrolley.product.model.Product;
import io.github.devansh2991.zaptrolley.product.repository.ProductRepository;
import io.github.devansh2991.zaptrolley.user.model.User;
import io.github.devansh2991.zaptrolley.user.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatabaseCartService implements CartService {

    private final CartItemRepository cartItemRepository;
    private final UserRepository userRepository;
    private final ProductRepository productRepository;

    public DatabaseCartService(CartItemRepository cartItemRepository, UserRepository userRepository, ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.userRepository = userRepository;
        this.productRepository = productRepository;
    }

    @Override
    public Cart getCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<CartItem> items = cartItemRepository.findByUser(user);
        return new Cart(items);
    }

    @Override
    public void addToCart(Long userId, Long productId, int quantity) {
        User user = userRepository.findById(userId).orElseThrow();
        Product product = productRepository.findById(productId).orElseThrow();
        cartItemRepository.save(new CartItem(product, user, quantity));
    }

    @Override
    public void removeFromCart(Long cartItemId) {
        cartItemRepository.deleteById(cartItemId);
    }

    @Override
    public void clearCart(Long userId) {
        User user = userRepository.findById(userId).orElseThrow();
        List<CartItem> items = cartItemRepository.findByUser(user);
        cartItemRepository.deleteAll(items);
    }
}
