package com.shreya.hibernate.model;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.Cacheable;
import java.sql.Time;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class BookingTable {
    private Long id;
    private String customerName;
    private String restaurantName;
    private LocalDateTime bookingTime;
    private int numberOfPeople;
    private String status;

    public BookingTable(long id, String customerName, String restaurantName, Time bookingTime, int numberOfPeople, String status) {
    }
}
