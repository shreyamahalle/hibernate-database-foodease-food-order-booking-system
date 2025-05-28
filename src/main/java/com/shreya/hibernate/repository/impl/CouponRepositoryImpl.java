package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.Coupon;
import com.shreya.hibernate.repository.CouponRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("couponRepository")
public class CouponRepositoryImpl implements CouponRepository {

    private final SessionFactory sessionFactory;

    public CouponRepositoryImpl() {
        this.sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(coupon);
        session.getTransaction().commit();
        session.close();
        return coupon;
    }

    @Override
    public List<Coupon> getAllCoupons() {
        Session session = sessionFactory.openSession();
        Query<Coupon> query = session.createQuery("from Coupon", Coupon.class);
        List<Coupon> list = query.list();
        session.close();
        return list;
    }

    @Override
    public Optional<Coupon> findById(long id) {
        Session session = sessionFactory.openSession();
        Coupon coupon = session.get(Coupon.class, id);
        session.close();
        return Optional.ofNullable(coupon);
    }

    @Override
    public Coupon deleteCoupon(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Coupon coupon = session.get(Coupon.class, id);
        if (coupon != null) {
            session.delete(coupon);
            session.getTransaction().commit();
        } else {
            session.getTransaction().rollback();
        }
        session.close();
        return coupon;
    }

    @Override
    public Coupon updateCoupon(Coupon coupon) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Coupon existing = session.get(Coupon.class, coupon.getId());
        if (existing != null) {
            session.merge(coupon);
            session.getTransaction().commit();
            session.close();
            return coupon;
        } else {
            session.getTransaction().rollback();
            session.close();
            return null;
        }
    }
}
