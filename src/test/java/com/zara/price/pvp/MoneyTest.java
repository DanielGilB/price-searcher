package com.zara.price.pvp;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void should_not_create_money_with_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(null, null));
        assertEquals(exception.getMessage(), "value must not be null");
    }
    @Test
    void should_not_create_money_with_null_value() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(null, "EUR"));
        assertEquals(exception.getMessage(), "value must not be null");
    }

    @Test
    void should_not_create_money_with_negative_value() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(BigDecimal.valueOf(-1), "EUR"));
        assertEquals(exception.getMessage(), "value must not be negative");
    }

    @Test
    void should_not_create_money_with_null_currency() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(TEN, null));
        assertEquals(exception.getMessage(), "currency must not be null");
    }
    @Test
    void should_create_money() {
         Money.of(TEN, "EUR");
    }
}