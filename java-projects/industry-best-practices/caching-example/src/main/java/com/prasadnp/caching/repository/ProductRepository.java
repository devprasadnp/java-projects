package com.prasadnp.caching.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prasadnp.caching.model.Product;

/**
 * Repository interface for Product entity.
 * Extends JpaRepository to provide CRUD operations and 
 * additional JPA-related methods for Product objects.
 * 
 * No implementation is required here as Spring Data JPA 
 * automatically provides the implementation at runtime.
 * 
 * @author devprasadnp
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
    // JpaRepository<Product, Integer> provides:
    // - CRUD methods: save, findById, findAll, deleteById, etc.
    // - Pagination and sorting capabilities.
    //
    // The first generic parameter specifies the entity type (Product).
    // The second parameter specifies the type of the entity's ID (Integer).
}
