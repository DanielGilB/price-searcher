package com.zara.price.pvp.domain;

import lombok.Value;
import org.springframework.util.Assert;

import java.time.Instant;

@Value(staticConstructor="of")
public class DateRange {
    Instant from;
    Instant to;
    private DateRange(Instant from, Instant to) {
        Assert.notNull(from, "from must not be null");
        Assert.notNull(to, "to must not be null");
        Assert.isTrue(from.isBefore(to), "from must be before to");
        this.from = from;
        this.to = to;
    }
}
