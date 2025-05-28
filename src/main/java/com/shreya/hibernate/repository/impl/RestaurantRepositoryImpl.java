package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.model.Restaurant;
import com.shreya.hibernate.repository.RestaurantRepository;

import java.util.List;

public class RestaurantRepositoryImpl implements RestaurantRepository {
    @Override
    public void addRestaurant(Restaurant restaurant) {

    }

    @Override
    public List<Restaurant> retrieveRestaurants() {
        return List.of();
    }

    @Override
    public Restaurant retrieveRestaurant(int id) {
        return null;
    }

    @Override
    public boolean deleteRestaurant(int id) {
        return false;
    }

    @Override
    public boolean updateRestaurant(Restaurant restaurant) {
        return false;
    }
}
