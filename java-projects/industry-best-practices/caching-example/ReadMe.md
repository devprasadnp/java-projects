# Getting Started

# Spring Boot Product Caching Example

This is a simple Spring Boot application demonstrating caching using Spring Cache abstraction with a `Product` entity. It implements basic CRUD operations and shows how to cache data to improve performance and reduce database accesses.

---

## Table of Contents
- [Features](#features)
- [Technologies](#technologies)
- [Getting Started](#getting-started)
- [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Caching Details](#caching-details)
- [Notes](#notes)
- [License](#license)

---

## Features

- RESTful API to manage `Product` entities (Create, Read, Update, Delete)
- Uses Spring Data JPA for database operations
- Integrates Spring Cache abstraction for caching with annotations:
  - `@Cacheable` to cache product fetch by ID
  - `@CachePut` to update cache on product save/update
  - `@CacheEvict` to clear cache on product deletion
- Automatic cache management to improve performance and reduce redundant DB queries

---

## Technologies

- Java 17+ (or your JDK version)
- Spring Boot
- Spring Data JPA
- Spring Cache
- H2 / Other relational database (configure as needed)
- Maven / Gradle (based on your build tool)

---

## Getting Started

### Prerequisites

- Java JDK installed
- Able to run the Redis docuker image with port 5540 (use the command ==> docker run -d --name redisinsight -p 5540:5540 redis/redisinsight:latest -v redisinsight:/data)
- Maven or Gradle installed
- (Optional) Postman or curl for API testing

### Build

Clone the repository:

git clone https://github.com/yourusername/spring-boot-product-caching.git
cd spring-boot-product-caching


Build the project using Maven:

mvn clean install


---

## Running the Application

Run the Spring Boot application:

mvn spring-boot:run


The application will start on [http://localhost:8080](http://localhost:8080).

---

## API Endpoints

| Method | Endpoint           | Description                          | Request Body                 |
|--------|--------------------|------------------------------------|-----------------------------|
| GET    | `/api/products`    | Get all products                   | -                           |
| GET    | `/api/products/{id}` | Get product by ID                  | -                           |
| POST   | `/api/products`    | Create a new product               | JSON with `name`, `description` |
| PUT    | `/api/products/{id}` | Update existing product by ID     | JSON with updated `name`, `description` |
| DELETE | `/api/products/{id}` | Delete product by ID               | -                           |

### Example JSON for product creation or update

{
"name": "Example Product",
"description": "This is an example product"
}


---

## Caching Details

- The `ProductService` class uses Spring Cache annotations:
  - `@Cacheable("products")` caches product lookups by ID.
  - `@CachePut("products")` updates the cache when a product is saved or updated.
  - `@CacheEvict("products")` removes product entries from cache when deleted.

- This reduces database hits for repeated product fetch requests.

- Cache implementation can be customized by configuring cache manager (e.g., Ehcache, Caffeine, Redis). By default, Spring Boot uses a simple in-memory map cache for demonstration.

---

## Notes

- The project currently uses an in-memory cache and assumes default datasource configuration. You can configure a DB like H2, MySQL, or PostgreSQL as needed in `application.properties`.

- Add your database credentials and settings if you switch from in-memory DB.

- Feel free to extend this project with more complex caching strategies or distributed caches.

---

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

---

Feel free to open issues or submit pull requests for improvements!

---

*Created by PrasadNP*


