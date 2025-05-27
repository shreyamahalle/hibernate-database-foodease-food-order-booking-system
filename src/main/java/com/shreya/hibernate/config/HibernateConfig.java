package com.shreya.hibernate.config;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@org.springframework.context.annotation.Configuration
public class HibernateConfig {

    public static final SessionFactory SESSION_FACTORY = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {

        try {
            return new Configuration().configure().buildSessionFactory();
        } catch (HibernateException e) {
            System.err.println("SessionFactory creation failed " + e);
            throw new RuntimeException(e);
        }
    }

    public static void shutdown() {
        SESSION_FACTORY.close();
    }
}
