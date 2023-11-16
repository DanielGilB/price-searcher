package com.zara.price.pvp;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.DAYS;
import static org.junit.jupiter.api.Assertions.*;

class DateRangeTest {

    @Test
    void should_not_create_date_range_with_dates_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateRange.of(null, null));
        assertEquals("from must not be null", exception.getMessage());
    }

    @Test
    void should_not_create_date_range_with_null_from() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateRange.of(null, Instant.now()));
        assertEquals("from must not be null", exception.getMessage());
    }

    @Test
    void should_not_create_date_range_with_null_to() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateRange.of(Instant.now(), null));
        assertEquals("to must not be null", exception.getMessage());
    }

    @Test
    void should_not_create_date_range_with_to_before_from() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateRange.of(Instant.now(), Instant.now().minus(1, DAYS)));
        assertEquals("from must be before to", exception.getMessage());
    }

    @Test
    void should_not_create_date_range_with_same_dates() {
        Instant date = Instant.now();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> DateRange.of(date, date));
        assertEquals("from must be before to", exception.getMessage());
    }
}