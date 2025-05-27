package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.BookingTable;
import com.shreya.hibernate.repository.impl.BookingTableRepositoryImpl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class BookingTableRepository implements BookingTableRepositoryImpl {

    private final Logger log = LoggerFactory.getLogger(BookingTableRepository.class);
    private static final SessionFactory sessionFactory;

    static {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    @Override
    public boolean addBooking(BookingTable bookingTable) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.save(bookingTable);
            tx.commit();
            return true;
        } catch (Exception e) {
            log.error("Failed to add booking", e);
            return false;
        }
    }

    @Override
    public List<BookingTable> retrieveBookings() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM BookingTable", BookingTable.class).list();
        } catch (Exception e) {
            log.error("Failed to retrieve bookings", e);
            return List.of();
        }
    }


    @Override
    public boolean updateBooking(BookingTable bookingTable) {
        try (Session session = sessionFactory.openSession()) {
            Transaction tx = session.beginTransaction();
            session.update(bookingTable);
            tx.commit();
            return true;
        } catch (Exception e) {
            log.error("Failed to update booking", e);
            return false;
        }
    }

    @Override
    public boolean deleteBooking(long id) {
        try (Session session = sessionFactory.openSession()) {
            BookingTable table = session.get(BookingTable.class, id);
            if (table == null) return false;
            Transaction tx = session.beginTransaction();
            session.delete(table);
            tx.commit();
            return true;
        } catch (Exception e) {
            log.error("Failed to delete booking", e);
            return false;
        }
    }

    @Override
    public BookingTable findById(long id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(BookingTable.class, id);
        } catch (Exception e) {
            log.error("Error fetching booking by ID", e);
            return null;
        }
    }
}