package com.zara.price.pvp.domain;

import lombok.Builder;
import org.springframework.util.Assert;

import java.time.Instant;

@Builder
public record Criteria(
        Long productId,
        Long brandId,
        Instant date
) {
    public Criteria {
        Assert.notNull(brandId, "brandId must not be null");
        Assert.notNull(productId, "productId must not be null");
        Assert.notNull(date, "date must not be null");
    }
}
