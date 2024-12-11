package com.java.academy.wedding_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookingCreateDto {

    private Integer month;
    private Integer day;

}
