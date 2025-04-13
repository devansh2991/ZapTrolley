package io.github.devansh2991.zaptrolley.product.service;

import io.github.devansh2991.zaptrolley.product.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long id);

    Product getProductByName(String name);

    Product updateProductPrice(long id, double newPrice);

    Product updateProductName(long id, String newName);

    Product updateProductDescription(long id, String newDescription);

    Product updateProductImageUrl(long id, String newImageUrl);

    boolean deleteProduct(long id);
}
