package com.practice.feign.controller;

import com.practice.feign.entity.Cart;
import com.practice.feign.serviceImpl.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("cart")
public class CartController {
    @Autowired
    private CartService cartService;
    @GetMapping("/")
    public ResponseEntity<?> fetchAllCarts(){
        return ResponseEntity.ok(this.cartService.fetchAllCarts());
    }
    @GetMapping("/{cartId}")
    public ResponseEntity<?> getCartById(@PathVariable(value = "cartId") String cartId){
        return ResponseEntity.ok(this.cartService.fetchCartById(cartId));
    }
    @PostMapping("/addCart")
    public ResponseEntity<?> addCart(@RequestBody Cart cart){
        return ResponseEntity.ok(this.cartService.addCart(cart));
    }
    @DeleteMapping("/{cartId}")
    public ResponseEntity<?> deleteCart(@PathVariable(value = "cartId") String cartId){
        return ResponseEntity.ok(this.cartService.deleteCart(cartId));
    }
}