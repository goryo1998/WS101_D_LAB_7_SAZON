package com.sazon.lab_7;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // In-memory database
    private final List<Product> productList = new ArrayList<>();
    // Counter to simulate auto-incrementing IDs
    private long nextId = 1;

    // Constructor to initialize mock data
    public ProductService() {
        productList.add(new Product(nextId++, "Laptop Pro", 1200.00));
        productList.add(new Product(nextId++, "Smartphone X", 800.00));
        productList.add(new Product(nextId++, "Wireless Earbuds", 150.00));
    }

    // 1. Return all products
    public List<Product> findAll() {
        return productList;
    }

    // 2. Find by ID
    public Optional<Product> findById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    // 3. Create new product (Auto-increment ID)
    public Product save(Product product) {
        product.setId(nextId++);
        productList.add(product);
        return product;
    }

    // 4. Update product
    public boolean update(Long id, Product updatedProduct) {
        Optional<Product> existingOpt = findById(id);
        if (existingOpt.isPresent()) {
            Product existing = existingOpt.get();
            existing.setName(updatedProduct.getName());
            existing.setPrice(updatedProduct.getPrice());
            return true;
        }
        return false;
    }

    // 5. Delete product
    public boolean delete(Long id) {
        return productList.removeIf(p -> p.getId().equals(id));
    }
}