package com.java.academy.wedding_booking.service;

import com.java.academy.wedding_booking.dto.BookingCountDto;
import com.java.academy.wedding_booking.dto.BookingCreateDto;
import com.java.academy.wedding_booking.dto.BookingDto;

import java.time.Month;
import java.util.List;

public interface BookingServiceIF {

    void createBooking(BookingCreateDto dto);

    List<BookingDto> getBookingsByMonth(Month month);

    BookingCountDto getCountOfBookedDaysInMonth(Month month);

}
