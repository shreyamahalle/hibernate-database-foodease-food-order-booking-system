package com.shreya.hibernate.service.impl;

import com.shreya.hibernate.exception.BookingAddFailedException;
import com.shreya.hibernate.exception.IdNotFoundException;
import com.shreya.hibernate.exception.NoBookingTablesFoundException;
import com.shreya.hibernate.model.BookingTable;
import com.shreya.hibernate.repository.BookingTableRepository;
import com.shreya.hibernate.service.BookingTableService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BookingTableServiceImpl implements BookingTableService {

    private static final Logger log = LoggerFactory.getLogger(BookingTableServiceImpl.class);
    private final BookingTableRepository bookingTableRepository;

    @Override
    public void addBooking(BookingTable bookingTable) {
        log.info("Adding booking: {}", bookingTable);
        boolean added = bookingTableRepository.addBooking(bookingTable);
        if (!added) {
            log.error("Failed to add booking.");
            throw new BookingAddFailedException("Failed to add booking.");
        }
        log.info("Booking added successfully.");
    }

    @Override
    public List<BookingTable> getAllBookings() {
        log.info("Fetching all bookings");
        List<BookingTable> bookings = bookingTableRepository.retrieveBookings();
        if (bookings == null || bookings.isEmpty()) {
            log.warn("No booking tables found.");
            throw new NoBookingTablesFoundException("No booking available; table is full.");
        }
        log.info("Retrieved {} bookings", bookings.size());
        return bookings;
    }

    @Override
    public BookingTable getBookingById(Long id) {
        log.info("Getting booking by ID: {}", id);
        BookingTable booking = bookingTableRepository.findById(id);
        if (booking == null) {
            log.warn("Booking not found with id: {}", id);
            throw new IdNotFoundException("Booking not found with id: " + id);
        }
        return booking;
    }

    @Override
    public boolean deleteBooking(Long id) {
        log.info("Deleting booking by ID: {}", id);
        boolean deleted = bookingTableRepository.deleteBooking(id);
        if (!deleted) {
            log.warn("Booking not found for deletion with id: {}", id);
            throw new IdNotFoundException("Booking not found with id: " + id);
        }
        return true;
    }

    @Override
    public boolean updateBooking(long id, BookingTable bookingTable) {
        log.info("Updating booking by ID {} with data {}", id, bookingTable);
        boolean updated = bookingTableRepository.updateBooking(bookingTable);
        if (!updated) {
            log.warn("Booking update failed. No booking found with id: {}", id);
            throw new IdNotFoundException("Booking not found with id: " + id);
        }
        return true;
    }

    public Set<BookingTable> findBookingTable(int page, int size) {
        bookingTableRepository.findBookingTable(page, size);
        return Set.of();
    }
}
