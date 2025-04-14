package io.github.devansh2991.zaptrolley.cart;

import io.github.devansh2991.zaptrolley.product.model.Product;
import io.github.devansh2991.zaptrolley.user.model.User;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Product product;

    @ManyToOne
    private User user;

    private int quantity;

    // Constructors, Getters, Setters
    public CartItem() {}

    public CartItem(Product product, User user, int quantity) {
        this.product = product;
        this.user = user;
        this.quantity = quantity;
    }

    // Getters and setters...
}
