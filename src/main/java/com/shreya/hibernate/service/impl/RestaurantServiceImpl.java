package com.shreya.hibernate.service.impl;

import com.shreya.hibernate.exception.RestaurantDeleteException;
import com.shreya.hibernate.exception.RestaurantNotFoundException;
import com.shreya.hibernate.exception.RestaurantUpdateException;
import com.shreya.hibernate.model.Restaurant;
import com.shreya.hibernate.repository.RestaurantRepository;
import com.shreya.hibernate.service.RestaurantService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    private final Logger log = LoggerFactory.getLogger(RestaurantServiceImpl.class);

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public void insertRestaurant(Restaurant restaurant) throws SQLException {
        restaurantRepository.addRestaurant(restaurant);
    }

    @Override
    public List<Restaurant> retrieveRestaurants() {
        return restaurantRepository.retrieveRestaurants();
    }

    @Override
    public Restaurant getRestaurantById(int id) {
        Restaurant restaurant = restaurantRepository.retrieveRestaurant(id);
        if (restaurant == null) {
            throw new RestaurantNotFoundException("Restaurant not found with ID: " + id);
        }
        return restaurant;
    }

    @Override
    public boolean deleteRestaurant(int id) throws SQLException {
        if (!restaurantRepository.deleteRestaurant(id)) {
            throw new RestaurantDeleteException("Failed to delete restaurant with ID: " + id);
        }
        return true;
    }

    @Override
    public boolean updateRestaurant(int id) throws SQLException {
        if (!restaurantRepository.updateRestaurant(id)) {
            throw new RestaurantUpdateException("Failed to update restaurant with ID: " + id);
        }
        return true;
    }
}
