package io.github.devansh2991.zaptrolley.product.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long productId;

    /**
     * The name of the product.
     * Cannot be empty, and must be between 4 and 50 characters.
     */
    @Column(nullable = false)
    private String name;

    /**
     * The description of the product.
     * Cannot be empty, and must be between 10 and 100 characters.
     */
    @Column(nullable = false)
    private String description;

    /**
     * The price of the product. Must be a positive number greater than 0.
     */
    @Column(nullable = false)
    private double price;

    /**
     * The URL of the product image.
     * Must be a valid URL format.
     */
    @Column(nullable = false)
    private String imageUrl;

    public Product() {
    }

    public Product(String name, String description, double price, String imageUrl) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long ProductId) {
        this.productId = ProductId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;
        return productId == product.productId && Double.compare(price, product.price) == 0
                && Objects.equals(name, product.name)
                && Objects.equals(description, product.description)
                && Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        int result = Long.hashCode(productId);
        result = 31 * result + Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(description);
        result = 31 * result + Double.hashCode(price);
        result = 31 * result + Objects.hashCode(imageUrl);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
