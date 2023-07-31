package com.practice.feign.service;

import com.practice.feign.entity.Cart;

import java.util.List;
import java.util.Optional;

public interface ICartService {
    public Optional<?> fetchAllCarts();

    public Optional<?> fetchCartById(String cartId);

    public Optional<?> addCart(Cart cart);

    public Optional<?> deleteCart(String cartId);
}
