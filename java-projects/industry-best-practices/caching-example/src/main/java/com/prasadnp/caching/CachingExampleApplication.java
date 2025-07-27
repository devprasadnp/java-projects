package com.prasadnp.caching;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * Main entry point for the Spring Boot application.
 * Enables Spring's caching support.
 * 
 * @author devprasadnp
 */
@SpringBootApplication // Marks this as a Spring Boot application and triggers auto-configuration and component scanning.
@EnableCaching      // Enables Spring's annotation-driven cache management capability.
public class CachingExampleApplication {

    /**
     * The main method used to launch the Spring Boot application.
     * @param args command-line arguments passed during application startup.
     */
    public static void main(String[] args) {
        // Run the Spring Boot application, starting the embedded server and Spring context.
        SpringApplication.run(CachingExampleApplication.class, args);
    }

}