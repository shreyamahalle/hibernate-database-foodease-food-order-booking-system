package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Restaurant;
import com.shreya.hibernate.repository.RestaurantRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RestaurantRepositoryImpl implements RestaurantRepository {

    private final SessionFactory sessionFactory;

    public RestaurantRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public void addRestaurant(Restaurant restaurant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(restaurant);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public List<Restaurant> retrieveRestaurants() {
        Session session = sessionFactory.openSession();
        Query<Restaurant> query = session.createQuery("from Restaurant", Restaurant.class);
        List<Restaurant> restaurants = query.getResultList();
        session.close();
        return restaurants;
    }

    @Override
    public Restaurant retrieveRestaurant(int id) {
        Session session = sessionFactory.openSession();
        Restaurant restaurant = session.get(Restaurant.class, id);
        session.close();
        return restaurant;
    }

    @Override
    public boolean deleteRestaurant(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Restaurant restaurant = session.get(Restaurant.class, id);
        if (restaurant != null) {
            session.delete(restaurant);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateRestaurant(int restaurant) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(restaurant);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
