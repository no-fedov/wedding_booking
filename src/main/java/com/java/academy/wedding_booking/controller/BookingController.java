package com.java.academy.wedding_booking.controller;

import com.java.academy.wedding_booking.dto.BookingCountDto;
import com.java.academy.wedding_booking.dto.BookingCreateDto;
import com.java.academy.wedding_booking.dto.BookingDto;
import com.java.academy.wedding_booking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Month;
import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public void saveBooking(@RequestBody BookingCreateDto dto) {
        bookingService.createBooking(dto);
    }

    @GetMapping("/month/{monthNumber}")
    public List<BookingDto> getBookingsBuMonth(@PathVariable Integer monthNumber) {
        return bookingService.getBookingsByMonth(Month.of(monthNumber));
    }


    @GetMapping("/month/{monthNumber}/free")
    public BookingCountDto getCountOfBookedDaysInMonth(@PathVariable Integer monthNumber) {
        return bookingService.getCountOfBookedDaysInMonth(Month.of(monthNumber));
    }

}
