package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.CartItem;
import com.shreya.hibernate.repository.CartItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("cartItemRepository")
public class CartItemRepositoryImpl implements CartItemRepository {

    private final SessionFactory sessionFactory;

    public CartItemRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addCartItem(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cartItem);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<CartItem> retrieveCartItems() {
        Session session = sessionFactory.openSession();
        Query<CartItem> query = session.createQuery("from CartItem", CartItem.class);
        List<CartItem> cartItems = query.list();
        session.close();
        return cartItems;
    }

    @Override
    public Optional<CartItem> findById(int id) {
        Session session = sessionFactory.openSession();
        CartItem cartItem = session.get(CartItem.class, id);
        session.close();
        return Optional.ofNullable(cartItem);
    }

    @Override
    public boolean deleteCartItem(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartItem cartItem = session.load(CartItem.class, id);
        if (cartItem != null) {
            session.delete(cartItem);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartItem existing = session.get(CartItem.class, cartItem.getId());
        if (existing != null) {
            session.merge(cartItem);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updatePartialCartItem(CartItem cartItem) {

        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartItem existing = session.get(CartItem.class, cartItem.getId());
        if (existing != null) {
            // Example partial update: update quantity only (change as needed)
            existing.setQuantity(cartItem.getQuantity());
            session.merge(existing);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
