package com.zara.price.pvp;

import lombok.Value;
import org.springframework.util.Assert;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

@Value(staticConstructor="of")
public class Money {
    BigDecimal value;
    String currency;

    private Money(BigDecimal value, String currencyCode) {
        // I am using third party library (Assert) to avoid create domain validations since this is a workshop not a prd code
        Assert.notNull(value, "value must not be null");
        Assert.isTrue(value.compareTo(ZERO) >= 0, "value must not be negative");
        Assert.notNull(currencyCode, "currency must not be null");
       // TODO: this should has a better validation but I think is out scope
        // Maybe use java.util.Currency instead String then validate the value is valid for a Currency
        this.value = value;
        this.currency = currencyCode;
    }
}
