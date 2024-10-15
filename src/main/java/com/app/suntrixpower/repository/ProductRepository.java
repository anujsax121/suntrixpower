package com.app.suntrixpower.repository;

import com.app.suntrixpower.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {

    // Find all products with pagination
    Page<Product> findAll(Pageable pageable);
}
