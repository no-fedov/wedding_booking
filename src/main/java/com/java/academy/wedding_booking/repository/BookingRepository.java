package com.java.academy.wedding_booking.repository;

import com.java.academy.wedding_booking.entity.Booking;
import com.java.academy.wedding_booking.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingRepository {

    private final BookingStorage storage;

    public void save(Booking booking) {
        storage.save(booking);
    }

    public List<Booking> findBookingsByMonth(Month month) {
        return storage.findBookingsByMonth(month);
    }

    public Long getCountOfBookedDaysInMonth(Month month) {
        return storage.getCountOfBookedDaysInMonth(month);
    }
}
