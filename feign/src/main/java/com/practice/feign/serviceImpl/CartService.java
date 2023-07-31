package com.practice.feign.serviceImpl;

import com.practice.feign.entity.Cart;
import com.practice.feign.entity.CartResponse;
import com.practice.feign.entity.Product;
import com.practice.feign.repository.CartRepository;
import com.practice.feign.service.ICartService;
import com.practice.feign.service.ProductServiceFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CartService implements ICartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private ProductServiceFeign productServiceFeign;

    @Override
    public Optional<?> fetchAllCarts() {
        List<Cart> allCart = this.cartRepository.findAll();

        Object cart = null;
//        Product product = productServiceFeign.getProductById(cart.getProudctId);
        return Optional.of(allCart);
    }

    @Override
    public Optional<?> fetchCartById(String cartId) {
        Optional<Cart> optionalCart = this.cartRepository.findByCartId(cartId);

        Product product = productServiceFeign.getProductByCartId(cartId);
        optionalCart.get().setProducts(List.of(product));
        return optionalCart;
    }

    @Override
    public Optional<?> addCart(Cart cart) {
        Optional<?> cart1 = this.cartRepository.findCartByCartNameIgnoreCase(cart.getCartName());
        if (cart1.isPresent())
            return Optional.ofNullable("Data Already Exist");

        cart.setCartId(UUID.randomUUID().toString());
        CartResponse cartResponse = CartResponse.builder()
                .cartId(cart.getCartId())
                .cartName(cart.getCartName())
//                .product(cart.setProductId)
                .build();

        this.cartRepository.saveAndFlush(cart);
        return Optional.ofNullable("Data Added Successfully");
    }

    @Override
    public Optional<?> deleteCart(String cartId) {
        Optional<Cart> cart = this.cartRepository.findByCartId(cartId);
        if (cart.isEmpty())
            return Optional.of("Data Not Found");

        this.cartRepository.delete(cart.get());
        return Optional.of("Data deleted");
    }
}