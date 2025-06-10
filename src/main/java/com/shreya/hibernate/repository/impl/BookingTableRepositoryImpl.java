package com.shreya.hibernate.repository.impl;

import com.shreya.hibernate.config.HibernateConfig;
import com.shreya.hibernate.model.BookingTable;
import com.shreya.hibernate.repository.BookingTableRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Repository("bookingTableRepository")
public class BookingTableRepositoryImpl implements BookingTableRepository {

    private final SessionFactory sessionFactory;

    private BookingTableRepositoryImpl() {
        sessionFactory = HibernateConfig.SESSION_FACTORY;
    }

    @Override
    public boolean addBooking(BookingTable bookingTable) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(bookingTable);
        session.getTransaction().commit();
        session.close();
        return false;
    }

    @Override
    public List<BookingTable> retrieveBookings() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from BookingTable");
        return query.list();
    }

    @Override
    public BookingTable findById(long id) {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("from BookingTable where id=" + id);
        BookingTable bookingTable = (BookingTable) query.uniqueResult();

        return bookingTable;
    }

    @Override
    public boolean deleteBooking(long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        BookingTable tobeDeletedBookingTable = (BookingTable) session.load(BookingTable.class, id);
        session.delete(tobeDeletedBookingTable);
        session.getTransaction().commit();
        session.flush();
        session.close();
        return false;
    }

    @Override
    public boolean updateBooking(BookingTable bookingTable) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        BookingTable existing = session.get(BookingTable.class, bookingTable.getId());
        if (existing != null) {
            session.merge(bookingTable);
            session.getTransaction().commit();
            session.flush();
            session.close();
            return true;
        }
        session.getTransaction().rollback();
        session.close();
        return false;
    }

    @Override
    public Set<BookingTable> findBookingTable(int page, int size){
        Session session = sessionFactory.openSession();
        return (Set<BookingTable>)  session.createQuery(("from BookingTable"))
                .setFirstResult((page - 1) * size)
                .setMaxResults(size)
                .list().parallelStream().collect(Collectors.toSet());
    }

}

