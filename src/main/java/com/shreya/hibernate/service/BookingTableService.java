package com.shreya.hibernate.service;

import com.shreya.hibernate.model.BookingTable;

import java.sql.SQLException;
import java.util.List;
import java.util.Set;

public interface BookingTableService {

    void addBooking(BookingTable bookingTable) throws SQLException;

    List<BookingTable> getAllBookings();

    BookingTable getBookingById(Long id);

    boolean deleteBooking(Long id);

    boolean updateBooking(long id, BookingTable bookingTable);

    Set<BookingTable> findBookingTable(int page, int size);


}
