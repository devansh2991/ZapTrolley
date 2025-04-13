package io.github.devansh2991.zaptrolley.product.service;

import io.github.devansh2991.zaptrolley.product.exceptions.ProductNotFoundException;
import io.github.devansh2991.zaptrolley.product.exceptions.ProductValidationException;
import io.github.devansh2991.zaptrolley.product.model.Product;
import io.github.devansh2991.zaptrolley.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * A service that uses a database to store and manage product information.
 * This class implements the ProductService interface and uses a ProductRepository
 * to perform operations on the database.
 */
@Service
public class DatabaseProductService implements ProductService {
    /**
     * The repository used to access the database.
     */
    private final ProductRepository productRepository;

    /**
     * Creates a new DatabaseProductService with the provided repository.
     *
     * @param productRepository the repository to use for database operations
     */
    @Autowired
    public DatabaseProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * Adds a new product to the database.
     *
     * @param product the product to add
     * @return the saved product with any database-generated values (like ID)
     */
    @Override
    public Product createProduct(Product product) {
        if (product == null) {
            throw new ProductValidationException("Product must not be null");
        }
        return productRepository.save(product);
    }

    /**
     * Gets a list of all products from the database.
     *
     * @return a list containing all products
     */
    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = productRepository.findAll();
        if (productList.isEmpty()) {
            throw new ProductNotFoundException("No products found");
        }
        return productList;
    }

    /**
     * Finds a product in the database using its ID.
     *
     * @param id the ID of the product to find
     * @return the found product, or null if no product exists with the given ID
     */
    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
    }

    /**
     * Finds a product in the database using its name.
     *
     * @param name the name of the product to find
     * @return the found product, or null if no product exists with the given name
     */
    @Override
    public Product getProductByName(String name) {
        return productRepository.findByName(name)
                .orElseThrow(() -> new ProductNotFoundException("Product with name " + name + " not found"));
    }

    /**
     * Updates the price of a product in the database.
     *
     * @param id       the ID of the product to update
     * @param newPrice the new price to set
     * @return the updated product, or null if no product exists with the given ID
     */
    @Override
    public Product updateProductPrice(long id, double newPrice) {
        if (newPrice <= 0) {
            throw new ProductValidationException("Price must be greater than 0");
        }
        Product product = getProductById(id);
        if (product != null) {
            product.setPrice(newPrice);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Updates the name of a product in the database.
     *
     * @param id      the ID of the product to update
     * @param newName the new name to set
     * @return the updated product, or null if no product exists with the given ID
     */
    @Override
    public Product updateProductName(long id, String newName) {
        if (newName == null || newName.isEmpty()) {
            throw new ProductValidationException("Name must not be null or empty");
        }
        Product product = getProductById(id);
        if (product != null) {
            product.setName(newName);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Updates the description of a product in the database.
     *
     * @param id             the ID of the product to update
     * @param newDescription the new description to set
     * @return the updated product, or null if no product exists with the given ID
     */
    @Override
    public Product updateProductDescription(long id, String newDescription) {
        if (newDescription == null || newDescription.isEmpty()) {
            throw new ProductValidationException("Description must not be null or empty");
        }
        Product product = getProductById(id);
        if (product != null) {
            product.setDescription(newDescription);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Updates the image URL of a product in the database.
     *
     * @param id          the ID of the product to update
     * @param newImageUrl the new image URL to set
     * @return the updated product, or null if no product exists with the given ID
     */
    @Override
    public Product updateProductImageUrl(long id, String newImageUrl) {
        if (newImageUrl == null || newImageUrl.isEmpty()) {
            throw new ProductValidationException("Image url must not be null or empty");
        }
        Product product = getProductById(id);
        if (product != null) {
            product.setImageUrl(newImageUrl);
            return productRepository.save(product);
        }
        return null;
    }

    /**
     * Deletes a product from the database.
     *
     * @param id the ID of the product to delete
     * @return true if a product was deleted, false if no product exists with the given ID
     */
    @Override
    public boolean deleteProduct(long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        } else {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }
    }
}
