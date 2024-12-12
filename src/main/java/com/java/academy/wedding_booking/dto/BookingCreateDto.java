package com.java.academy.wedding_booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingCreateDto {

    private Integer month;
    private Integer day;

}
