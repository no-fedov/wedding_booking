package com.java.academy.wedding_booking.repository;

import com.java.academy.wedding_booking.entity.Booking;

import java.time.Month;
import java.util.List;

public interface BookingRepositoryIF {

    void save(Booking booking);

    List<Booking> findBookingsByMonth(Month month);

    Long findCountOfBookedDaysInMonth(Month month);

}
