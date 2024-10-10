package com.buetcsefest2024.workshop.product_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.buetcsefest2024.workshop.product_service.dto.ProductDto;
import com.buetcsefest2024.workshop.product_service.dto.ProductInsertDto;
import com.buetcsefest2024.workshop.product_service.exception.handler.http.NotFoundException;
import com.buetcsefest2024.workshop.product_service.model.Product;
import com.buetcsefest2024.workshop.product_service.repository.ProductResitory;

/*
@GetMapping("/")
    public ResponseEntity<List<Product>> getProducts() {
        return ResponseEntity.ok(productService.getProducts());
    }

    @PostMapping("/")
    public ResponseEntity<Product> addProduct(@RequestBody ProductInsertDto product) {
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @PutMapping("/")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
        return ResponseEntity.ok(productService.updateProduct(product));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(long id) {
        return ResponseEntity.ok(productService.getProductById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProductById(long id) {
        return ResponseEntity.ok(productService.deleteProductById(id));
    } 
*/ 

@Service
public class ProductService {
    
    @Autowired
    private ProductResitory productRepository;

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product addProduct(ProductInsertDto productDto) {
        Product product = Product.builder()
                            .name(productDto.name())
                            .price(productDto.price())
                            .description(productDto.description())
                            .image(productDto.image())
                            .build();
        return productRepository.save(product);
    }

    public Product updateProduct(ProductDto productDto) {
        Product product = productRepository.findById(productDto.id())
                .orElseThrow(() -> new NotFoundException("Product not found"));

        product.setName(productDto.name());
        product.setPrice(productDto.price());
        product.setDescription(productDto.description());
        product.setImage(productDto.image());
        return productRepository.save(product);
    }

    public Product getProductById(long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found"));
    }

    public String deleteProductById(long id) {
        productRepository.deleteById(id);
        return "Product deleted successfully";
    }
}
