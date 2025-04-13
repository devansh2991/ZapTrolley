package io.github.devansh2991.zaptrolley.product.exceptions;

/**
 * Exception thrown when a product is not found in the database.
 * Used when searching for a product by id or name.
 */
public class ProductNotFoundException extends RuntimeException {

    /**
     * Creates a new ProductNotFoundException with the specified message.
     * @param message The error message explaining why the product was not found.
     */
    public ProductNotFoundException(String message) {
        super(message);
    }
}

