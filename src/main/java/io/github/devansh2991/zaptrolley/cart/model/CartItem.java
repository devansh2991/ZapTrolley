package io.github.devansh2991.zaptrolley.cart.model;

import io.github.devansh2991.zaptrolley.product.model.Product;
import io.github.devansh2991.zaptrolley.user.model.User;
import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cartItemId;

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

    public Long getCartId() {
        return cartItemId;
    }

    public void setCartId(Long cartId) {
        this.cartItemId = cartId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return quantity == cartItem.quantity && Objects.equals(cartItemId, cartItem.cartItemId) && Objects.equals(product, cartItem.product) && Objects.equals(user, cartItem.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cartItemId, product, user, quantity);
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "cartId=" + cartItemId +
                ", product=" + product +
                ", user=" + user +
                ", quantity=" + quantity +
                '}';
    }
}
