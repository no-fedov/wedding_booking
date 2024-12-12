package com.java.academy.wedding_booking.repository;

import com.java.academy.wedding_booking.entity.Booking;
import com.java.academy.wedding_booking.storage.BookingStorage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.util.List;

@Component
@RequiredArgsConstructor
public class BookingRepository implements BookingRepositoryIF {

    private final BookingStorage storage;

    @Override
    public void save(Booking booking) {
        storage.save(booking);
    }

    @Override
    public List<Booking> findBookingsByMonth(Month month) {
        return storage.findBookingsByMonth(month);
    }

    @Override
    public Long findCountOfBookedDaysInMonth(Month month) {
        return storage.getCountOfBookedDaysInMonth(month);
    }

}
