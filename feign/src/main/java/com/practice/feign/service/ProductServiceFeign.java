package com.practice.feign.service;

import com.practice.feign.entity.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@FeignClient(name = "PRODUCT-SERVICE/product", url = "http://localhost:9000/product")
public interface ProductServiceFeign {

    @GetMapping("/{productId}")
    public Product getProductById(String productId);

    @GetMapping("/cart/{cartId}")
    public Product getProductByCartId(@PathVariable String cartId);

    @PostMapping("/addProduct")
    public Optional<?> addProduct(@RequestBody Product product);

    @PutMapping("/UpdateProduct")
    public Optional<?> UpdateProduct(@RequestBody Product product);
}