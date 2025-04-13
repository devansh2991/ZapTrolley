package io.github.devansh2991.zaptrolley.product.exceptions;

/**
 * Exception thrown when there is an issue with product validation.
 * For example, when the required fields are missing or have invalid values.
 */
public class ProductValidationException extends RuntimeException {

    /**
     * Creates a new ProductValidationException with the specified message.
     * @param message The error message explaining the validation isse.
     */
    public ProductValidationException(String message) {
        super(message);
    }
}

