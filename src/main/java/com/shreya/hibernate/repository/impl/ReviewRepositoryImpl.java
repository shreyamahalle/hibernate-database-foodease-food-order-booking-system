package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Review;
import com.shreya.hibernate.repository.ReviewRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ReviewRepositoryImpl implements ReviewRepository {

    private final SessionFactory sessionFactory;

    public ReviewRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addReview(Review review) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(review);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<Review> retrieveReviews() {
        Session session = sessionFactory.openSession();
        Query<Review> query = session.createQuery("from Review", Review.class);
        List<Review> reviews = query.getResultList();
        session.close();
        return reviews;
    }

    @Override
    public Review findById(long id) {
        Session session = sessionFactory.openSession();
        Review review = session.get(Review.class, id);
        session.close();
        return review;
    }

    @Override
    public boolean deleteReview(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Review review = session.get(Review.class, id);
        if (review != null) {
            session.delete(review);
            session.getTransaction().commit();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public boolean updateReview(Review review) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(review);
        session.getTransaction().commit();
        session.close();
        return true;
    }
}
