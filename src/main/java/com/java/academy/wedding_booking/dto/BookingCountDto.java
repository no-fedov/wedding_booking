package com.java.academy.wedding_booking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingCountDto {

    @JsonProperty("count")
    private Long countBookedDays;

}
