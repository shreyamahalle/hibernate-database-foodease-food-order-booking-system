package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Notification;
import com.shreya.hibernate.repository.NotificationRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("notificationRepository")
public class NotificationRepositoryImpl implements NotificationRepository {

    private final SessionFactory sessionFactory;

    private NotificationRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean saveNotification(Notification notification) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(notification);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Notification> getAllNotifications() {
        Session session = sessionFactory.openSession();
        Query<Notification> query = session.createQuery("from Notification", Notification.class);
        List<Notification> notifications = query.list();
        session.close();
        return notifications;
    }

    @Override
    public List<Notification> getNotificationsByCustomerId(Long customerId) {
        Session session = sessionFactory.openSession();
        Query<Notification> query = session.createQuery(
                "from Notification where customer.id = :customerId", Notification.class);
        query.setParameter("customerId", customerId);
        List<Notification> notifications = query.list();
        session.close();
        return notifications;
    }

    @Override
    public boolean markAsRead(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Notification notification = session.get(Notification.class, id);
        if (notification != null) {
            notification.set_read(true); // assumes there's a 'read' field
            session.update(notification);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }
}
