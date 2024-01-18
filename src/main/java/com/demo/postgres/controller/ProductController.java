package com.demo.postgres.controller;

import com.demo.postgres.entity.Product;
import com.demo.postgres.repo.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/createProduct")
    public ResponseEntity<Object> createProduct(){
        Product product = new Product();
        product.setName("Book");
        product.setId(2);
        product.setPrice(20);
        product = productRepository.save(product);
        return new ResponseEntity<Object>(product, HttpStatus.OK);
    }

    @GetMapping("/fetchProduct")
    public ResponseEntity<Object> fetchProduct(){
        List<Product> list = productRepository.findAll();
        return new ResponseEntity<Object>( list, HttpStatus.OK);
    }
}
