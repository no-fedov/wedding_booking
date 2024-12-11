package com.java.academy.wedding_booking.mapper;

import com.java.academy.wedding_booking.dto.BookingCreateDto;
import com.java.academy.wedding_booking.dto.BookingDto;
import com.java.academy.wedding_booking.entity.Booking;
import org.springframework.stereotype.Component;

import java.time.MonthDay;
import java.util.List;
import java.util.Objects;

@Component
public class BookingMapper {

    public Booking convertFromBookingCreateDto(BookingCreateDto dto) {
        Integer monthNumber = dto.getMonth();
        Integer dayNumber = dto.getDay();
        MonthDay monthDay = MonthDay.of(monthNumber, dayNumber);
        return new Booking(monthDay, false);
    }

    public BookingDto convertToBookingDto(Booking booking) {
        int day = booking.getMonthDay().getDayOfMonth();
        int month = booking.getMonthDay().getMonthValue();
        boolean isBooked = booking.isBooked();
        return new BookingDto(month, day, isBooked);
    }

    public List<BookingDto> convertToBookingDto(List<Booking> bookingList) {
        return bookingList.stream()
                .filter(Objects::nonNull)
                .map(this::convertToBookingDto).toList();
    }
}
