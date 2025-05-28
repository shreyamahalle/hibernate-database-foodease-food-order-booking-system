package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Feedback;
import com.shreya.hibernate.repository.FeedbackRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("feedbackRepository")
public class FeedbackRepositoryImpl implements FeedbackRepository {

    private final SessionFactory sessionFactory;

    private FeedbackRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addFeedback(Feedback feedback) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(feedback);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public List<Feedback> retrieveFeedbacks() {
        Session session = sessionFactory.openSession();
        Query<Feedback> query = session.createQuery("from Feedback", Feedback.class);
        List<Feedback> feedbackList = query.list();
        session.close();
        return feedbackList;
    }

    @Override
    public Optional<Feedback> findById(Long id) {
        Session session = sessionFactory.openSession();
        Feedback feedback = session.get(Feedback.class, id);
        session.close();
        return Optional.ofNullable(feedback);
    }

    @Override
    public boolean deleteFeedback(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Feedback toDelete = session.get(Feedback.class, id);
        if (toDelete != null) {
            session.delete(toDelete);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateFeedback(Feedback feedback) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Feedback existing = session.get(Feedback.class, feedback.getId());
        if (existing != null) {
            session.merge(feedback);
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
