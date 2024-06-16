package com.trabalho.products_control.repositories;

import com.trabalho.products_control.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, String> {
}
