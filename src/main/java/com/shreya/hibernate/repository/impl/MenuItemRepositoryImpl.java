package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.MenuItem;
import com.shreya.hibernate.repository.MenuItemRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("menuItemRepository")
public class MenuItemRepositoryImpl implements MenuItemRepository {

    private final SessionFactory sessionFactory;

    private MenuItemRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addMenuItem(MenuItem menuItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(menuItem);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<MenuItem> retrieveMenuItems() {
        Session session = sessionFactory.openSession();
        Query<MenuItem> query = session.createQuery("from MenuItem", MenuItem.class);
        List<MenuItem> items = query.list();
        session.close();
        return items;
    }

    @Override
    public MenuItem findById(long id) {
        Session session = sessionFactory.openSession();
        MenuItem item = session.get(MenuItem.class, id);
        session.close();
        return item;
    }

    @Override
    public boolean deleteMenuItem(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MenuItem item = session.get(MenuItem.class, id);
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
    public boolean updateMenuItem(MenuItem menuItem) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        MenuItem existing = session.get(MenuItem.class, menuItem.getId());
        if (existing != null) {
            session.merge(menuItem);
            session.getTransaction().commit();
            session.flush();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
