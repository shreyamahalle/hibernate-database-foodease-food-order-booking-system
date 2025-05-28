package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.CartItem;
import com.shreya.hibernate.repository.impl.CartItemRepositoryImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class CartItemRepository implements CartItemRepositoryImpl {

    private final Logger log = LoggerFactory.getLogger(CartItemRepository.class);

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public List<CartItem> retrieveCartItems() {
        return List.of();
    }

    @Override
    public Optional<CartItem> findById(int id) {
        return Optional.empty();
    }

    @Override
    public CartItem deleteCartItem(int id) {
        return null;
    }

    @Override
    public CartItem updateCartItem(CartItem cartItem) {
        return null;
    }

    @Override
    public CartItem updatePartialCartItem(CartItem cartItem) {
        return null;
    }
}