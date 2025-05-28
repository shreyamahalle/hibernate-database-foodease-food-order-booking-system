package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.CartItem;

import java.util.List;
import java.util.Optional;

public interface CartItemRepository {

    CartItem addCartItem(CartItem cartItem);

    List<CartItem> retrieveCartItems();

    Optional<CartItem> findById(int id);

    CartItem deleteCartItem(int id);

    CartItem updateCartItem(CartItem cartItem);

    CartItem updatePartialCartItem(CartItem cartItem);
}