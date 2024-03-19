package com.desafio.briks.controller;

import com.desafio.briks.model.Product;
import com.desafio.briks.service.ServiceProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ControllerProduct {
    @Autowired
    private ServiceProduct serviceProduct;


    @GetMapping
    public ResponseEntity<Page<Product>> getAllProduct(@RequestParam(defaultValue = "0") int page,
                                                     @RequestParam(defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Product> products = serviceProduct.findAll(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product creProduct = serviceProduct.save(product);
        return new ResponseEntity<>(creProduct, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Integer id) {
        Product product = serviceProduct.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductById(@PathVariable Integer id) {
        serviceProduct.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Integer id, @RequestBody Product updatedProduct) {
        return serviceProduct.updateProduct(id, updatedProduct);
    }
}
