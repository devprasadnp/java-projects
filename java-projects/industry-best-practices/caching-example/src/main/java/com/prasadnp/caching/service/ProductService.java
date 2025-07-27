package com.prasadnp.caching.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.prasadnp.caching.model.Product;
import com.prasadnp.caching.repository.ProductRepository;

import java.util.List;
import java.util.Optional;

/**
 * Service class that handles business logic related to Product entities.
 * Integrates caching to improve performance by reducing database calls.
 * 
 * @author devprasadnp
 */
@Service  // Marks this class as a Spring service component for component scanning.
public class ProductService {

    @Autowired
    private ProductRepository productRepository;  // Injects the repository to perform database operations.

    /**
     * Retrieves a product by its ID.
     * Uses cache to avoid repeated DB queries for the same product ID.
     *
     * @param id the product ID to look up.
     * @return an Optional containing the product if found, or empty if not.
     */
    @Cacheable(value = "products", key = "#id")
    public Optional<Product> getProductById(int id) {
        System.out.println("Fetching product from database...");  // This message will only appear if cache miss occurs.
        return productRepository.findById(id);
    }

    /**
     * Saves or updates a product in the database.
     * Updates the cache entry for the product with the new data.
     *
     * @param product the product to save or update.
     * @return the saved Product instance.
     */
    @CachePut(value = "products", key = "#product.id")
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

    /**
     * Deletes a product by its ID.
     * Evicts the corresponding cache entry to keep cache consistent.
     *
     * @param id the product ID to delete.
     */
    @CacheEvict(value = "products", key = "#id")
    public void deleteProduct(int id) {
        productRepository.deleteById(id);
    }

    /**
     * Retrieves all products from the database.
     * Note: This method does not use caching.
     *
     * @return a List of all Product entities.
     */
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
