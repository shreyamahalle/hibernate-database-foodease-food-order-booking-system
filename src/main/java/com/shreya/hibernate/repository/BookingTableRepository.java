package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.BookingTable;

import java.util.List;
import java.util.Set;

public interface BookingTableRepository {

    boolean addBooking(BookingTable bookingTable);

    List<BookingTable> retrieveBookings();

    BookingTable findById(long id);

    boolean deleteBooking(long id);

    boolean updateBooking(BookingTable bookingTable);

    Set<BookingTable> findBookingTable(int page, int size);

    }