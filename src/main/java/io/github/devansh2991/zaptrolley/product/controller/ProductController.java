package io.github.devansh2991.zaptrolley.product.controller;

import io.github.devansh2991.zaptrolley.product.model.Product;
import io.github.devansh2991.zaptrolley.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing products in the Shopkart application.
 * Provides endpoints for CRUD operations on products.
 */
@RestController
@RequestMapping("/api/products")
@Validated
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("databaseProductService") ProductService productService) {
        this.productService = productService;
    }

    /**
     * Creates a new product.
     *
     * @param product The product information to create
     * @return The created product with HTTP status 201 (created)
     */
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product savedProduct = productService.createProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    /**
     * Retrieves all products from the system.
     *
     * @return ResponseEntity containing a list of all products with HTTP status 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Product>> getAllProducts(@RequestBody Product product) {
        List<Product> products = productService.getAllProducts();
        return ResponseEntity.ok(products);
    }

    /**
     * Retrieves a specific product by its ID.
     *
     * @param id the unique identifier of the product
     * @return ResponseEntity containing the product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the product doesn't exist
     */
    @GetMapping("/{productId}")
    public ResponseEntity<Product> getProductById(@PathVariable long productId) {
        Product product = productService.getProductById(productId);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Retrieves a product by its name.
     *
     * @param name the name of the product to search for
     * @return ResponseEntity containing the product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if no product with the given name exists
     */
    @GetMapping("/byName")
    public ResponseEntity<Product> getProductByName(@RequestParam String name) {
        Product product = productService.getProductByName(name);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the price of a specific product.
     *
     * @param id    the unique identifier of the product to update
     * @param price the new price value (must be non-negative)
     * @return ResponseEntity containing the updated product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the product doesn't exist
     */
    @PutMapping("/{productId}/price")
    public ResponseEntity<Product> updateProductPrice(
            @PathVariable long productId,
            @RequestParam double price
    ) {
        Product product = productService.updateProductPrice(productId, price);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the name of a specific product.
     *
     * @param id   the unique identifier of the product to update
     * @param name the new name (must be between 4 and 50 characters)
     * @return ResponseEntity containing the updated product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the product doesn't exist
     */
    @PutMapping("/{productId}/name")
    public ResponseEntity<Product> updateProductName(
            @PathVariable long productId,
            @RequestParam String name
    ) {
        Product product = productService.updateProductName(productId, name);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the description of a specific product.
     *
     * @param id          the unique identifier of the product to update
     * @param description the new description (must be between 10 and 100 characters)
     * @return ResponseEntity containing the updated product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the product doesn't exist
     */
    @PutMapping("/{productId}/description")
    public ResponseEntity<Product> updateProductDescription(
            @PathVariable long productId,
            @RequestParam String description
    ) {
        Product product = productService.updateProductDescription(productId, description);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Updates the image URL of a specific product.
     *
     * @param id       the unique identifier of the product to update
     * @param imageUrl the new image URL (must be a valid URL)
     * @return ResponseEntity containing the updated product with HTTP status 200 (OK) if found,
     * or HTTP status 404 (Not Found) if the product doesn't exist
     */
    @PutMapping("/{productId}/imageUrl")
    public ResponseEntity<Product> updateProductImageUrl(
            @PathVariable long productId,
            @RequestParam String imageUrl
    ) {
        Product product = productService.updateProductImageUrl(productId, imageUrl);
        if (product != null) {
            return ResponseEntity.ok(product);
        }
        return ResponseEntity.notFound().build();
    }

    /**
     * Deletes a specific product from the system.
     *
     * @param id the unique identifier of the product to delete
     * @return ResponseEntity with a success message and HTTP status 200 (OK) if deleted,
     * or an error message and HTTP status 404 (Not Found) if the product doesn't exist
     */
    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable long productId) {
        boolean deleted = productService.deleteProduct(productId);
        if (deleted) {
            return ResponseEntity.ok("Product deleted successfully");
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
    }
}