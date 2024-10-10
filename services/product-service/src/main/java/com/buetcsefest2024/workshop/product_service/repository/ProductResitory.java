package com.buetcsefest2024.workshop.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.buetcsefest2024.workshop.product_service.model.Product;


public interface ProductResitory extends JpaRepository<Product, Long> {
}