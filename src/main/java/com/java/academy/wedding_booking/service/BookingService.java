package com.java.academy.wedding_booking.service;

import com.java.academy.wedding_booking.dto.BookingCountDto;
import com.java.academy.wedding_booking.dto.BookingCreateDto;
import com.java.academy.wedding_booking.dto.BookingDto;
import com.java.academy.wedding_booking.entity.Booking;
import com.java.academy.wedding_booking.mapper.BookingMapper;
import com.java.academy.wedding_booking.repository.BookingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final BookingMapper mapper;

    public void saveBooking(BookingCreateDto dto) {
        Booking booking = mapper.convertFromBookingCreateDto(dto);
        booking.setBooked(true);
        bookingRepository.save(booking);
    }

    public List<BookingDto> getBookingsByMonth(Month month) {
        return mapper.convertToBookingDto(bookingRepository.getBookingsByMonth(month));
    }

    public BookingCountDto getCountOfBookedDaysInMonth(Month month) {
        return new BookingCountDto(bookingRepository.getCountOfBookedDaysInMonth(month));
    }
}