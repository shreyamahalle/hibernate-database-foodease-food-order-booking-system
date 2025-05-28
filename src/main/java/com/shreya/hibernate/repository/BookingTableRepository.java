package com.shreya.hibernate.repository;

import com.shreya.hibernate.model.BookingTable;

import java.util.List;

public interface BookingTableRepository {

    boolean addBooking(BookingTable bookingTable);
    List<BookingTable> retrieveBookings();
    BookingTable findById(long id);
    boolean deleteBooking(long id);
    boolean updateBooking(BookingTable bookingTable);

}