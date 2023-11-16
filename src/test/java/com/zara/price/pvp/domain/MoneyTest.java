package com.zara.price.pvp.domain;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;
import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void should_not_create_money_with_null() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(null, null));
        assertEquals("value must not be null", exception.getMessage());
    }
    @Test
    void should_not_create_money_with_null_value() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(null, "EUR"));
        assertEquals("value must not be null", exception.getMessage());
    }

    @Test
    void should_not_create_money_with_negative_value() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(BigDecimal.valueOf(-1), "EUR"));
        assertEquals("value must not be negative", exception.getMessage());
    }

    @Test
    void should_not_create_money_with_null_currency() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> Money.of(TEN, null));
        assertEquals("currency must not be null", exception.getMessage());
    }
    @Test
    void should_create_money() {
         Money.of(TEN, "EUR");
    }
}