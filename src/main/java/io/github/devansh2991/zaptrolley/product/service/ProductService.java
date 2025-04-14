package io.github.devansh2991.zaptrolley.product.service;

import io.github.devansh2991.zaptrolley.product.model.Product;

import java.util.List;

public interface ProductService {
    Product createProduct(Product product);

    List<Product> getAllProducts();

    Product getProductById(long productId);

    Product getProductByName(String name);

    Product updateProductPrice(long productId, double newPrice);

    Product updateProductName(long productId, String newName);

    Product updateProductDescription(long productId, String newDescription);

    Product updateProductImageUrl(long productId, String newImageUrl);

    boolean deleteProduct(long productId);
}
