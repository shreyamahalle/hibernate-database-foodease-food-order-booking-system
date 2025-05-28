package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.CartItem;
import com.shreya.hibernate.service.CartItemService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("cartItemRepository")
public class CartItemRepositoryImpl implements CartItemService {

    private final SessionFactory sessionFactory;

    public CartItemRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addCartItem(CartItem cartItem) throws SQLException {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(cartItem);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean deleteCartItem(int id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartItem item = session.get(CartItem.class, id);
        if (item != null) {
            session.delete(item);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateCartItem(CartItem cartItem) throws SQLException {
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
    public List<CartItem> retrieveCartItem() {
        Session session = sessionFactory.openSession();
        Query<CartItem> query = session.createQuery("from CartItem", CartItem.class);
        List<CartItem> list = query.list();
        session.close();
        return list;
    }

    @Override
    public CartItem getCartItem(int id) {
        Session session = sessionFactory.openSession();
        CartItem item = session.get(CartItem.class, id);
        session.close();
        return item;
    }

    @Override
    public boolean updatePartialCartItem(CartItem cartItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        CartItem existing = session.get(CartItem.class, cartItem.getId());
        if (existing != null) {
            if (cartItem.getQuantity() != null) {
                existing.setQuantity(cartItem.getQuantity());
            }
            if (cartItem.getMenu_item_id() != null) {
                existing.setMenu_item_id(cartItem.getMenu_item_id());
            }
            session.update(existing);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
