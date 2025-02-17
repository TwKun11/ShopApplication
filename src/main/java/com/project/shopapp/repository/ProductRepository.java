package com.project.shopapp.repository;

import com.project.shopapp.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ProductRepository extends JpaRepository<Product, Long> {
 boolean existsByName(String name);
 Page<Product> findAll(Pageable pageable);
}
