package com.java.academy.wedding_booking.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.MonthDay;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Booking {

    private MonthDay monthDay;
    private boolean isBooked;

}
