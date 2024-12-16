package com.example.productCatalogSystem.repository;

import com.example.productCatalogSystem.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product,Long> {

   Optional<Product> findByProductname(String prodName);
}
