package com.prasadnp.caching.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.prasadnp.caching.model.Product;
import com.prasadnp.caching.service.ProductService;

import java.util.List;
import java.util.Optional;

/**
 * REST controller to handle HTTP requests related to Product entities.
 * Provides endpoints for CRUD operations on products.
 * 
 * @author devprasadnp
 */
@RestController
@RequestMapping("/api/products")  // Base URL path for all product-related endpoints.
public class ProductController {

    @Autowired
    private ProductService productService;  // Injects the ProductService to access business logic.

    /**
     * GET /api/products/{id}
     * Retrieve a single product by its ID.
     *
     * @param id the product ID from the URL path
     * @return ResponseEntity containing the product if found, or 404 Not Found otherwise.
     */
    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);
        // If product present, return 200 OK with product; otherwise, return 404 Not Found.
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * GET /api/products
     * Retrieve a list of all products.
     *
     * @return List of all Product objects.
     */
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    /**
     * POST /api/products
     * Create a new product.
     *
     * @param product The product details sent in the request body.
     * @return The saved product instance.
     */
    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    /**
     * PUT /api/products/{id}
     * Update an existing product.
     *
     * @param id The product ID to update (from URL path).
     * @param product The updated product data sent in the request body.
     * @return ResponseEntity with the updated product or 404 if not found.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id, @RequestBody Product product) {
        Optional<Product> existingProduct = productService.getProductById(id);

        if (existingProduct.isPresent()) {
            product.setId(id);  // Ensure the product ID is set to the path variable id.
            Product updatedProduct = productService.saveProduct(product);
            return ResponseEntity.ok(updatedProduct);  // Return 200 OK with updated product.
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if product doesn't exist.
        }
    }

    /**
     * DELETE /api/products/{id}
     * Delete a product by its ID.
     *
     * @param id The product ID to delete.
     * @return ResponseEntity with status 200 OK if deleted, or 404 if not found.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable int id) {
        Optional<Product> product = productService.getProductById(id);

        if (product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.ok().build();  // Return 200 OK with empty body.
        } else {
            return ResponseEntity.notFound().build();  // Return 404 if product doesn't exist.
        }
    }
}
