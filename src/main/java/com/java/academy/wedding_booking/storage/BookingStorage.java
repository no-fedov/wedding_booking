package com.java.academy.wedding_booking.storage;

import com.java.academy.wedding_booking.entity.Booking;
import org.springframework.stereotype.Component;

import java.time.Month;
import java.time.MonthDay;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Component
public class BookingStorage {

    private static final Integer MAX_COUNT_DAY_IN_MONTH = 31;

    private final Map<Month, List<Booking>> storage = new HashMap<>();

    public void save(Booking booking) {
        MonthDay monthDay = booking.getMonthDay();
        int day = monthDay.getDayOfMonth();
        List<Booking> bookingsInCurrentMonth = storage.computeIfAbsent(
                monthDay.getMonth(),
                key -> new ArrayList<>(Collections.nCopies(MAX_COUNT_DAY_IN_MONTH, null))
        );

        if (Objects.nonNull(bookingsInCurrentMonth.get(day))) {
            throw new RuntimeException("Эта дата уже забронирована");
        }

        bookingsInCurrentMonth.add(day, booking);
    }


    public List<Booking> findBookingsByMonth(Month month) {
        if (storage.containsKey(month)) {
            return new ArrayList<>(storage.get(month));
        }
        return List.of();
    }

    public Long getCountOfBookedDaysInMonth(Month month) {
        if (storage.containsKey(month)) {
            return storage.get(month).stream()
                    .filter(Objects::nonNull)
                    .filter(Booking::isBooked)
                    .count();
        }

        return 0L;
    }

}
