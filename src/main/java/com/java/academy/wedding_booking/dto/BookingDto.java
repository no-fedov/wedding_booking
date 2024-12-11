package com.java.academy.wedding_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingDto {

    private Integer monthNumber;
    private Integer dayNumber;
    private Boolean booked;

}
