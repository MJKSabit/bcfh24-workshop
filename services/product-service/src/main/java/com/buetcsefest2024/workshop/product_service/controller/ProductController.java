package com.buetcsefest2024.workshop.product_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.buetcsefest2024.workshop.product_service.dto.ProductDto;
import com.buetcsefest2024.workshop.product_service.dto.ProductInsertDto;
import com.buetcsefest2024.workshop.product_service.model.Product;
import com.buetcsefest2024.workshop.product_service.service.ProductService;


@Controller
public class ProductController {
    
    @Autowired
    private ProductService productService;

    @GetMapping("/health")
    public ResponseEntity<String> health() {
        return ResponseEntity.ok("Product Service is up and running");
    }

    @GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody ProductInsertDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody ProductDto product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(@PathVariable long id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    }

    

}
