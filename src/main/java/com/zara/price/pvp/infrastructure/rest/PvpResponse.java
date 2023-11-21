package com.zara.price.pvp.infrastructure.rest;

import lombok.Builder;

import java.math.BigDecimal;
import java.time.Instant;

@Builder
public record PvpResponse(
        Long brandId,
        Instant startAt,
        Instant endAt,
        Long priceList,
        Long productId,
        BigDecimal price,
        String currency
) {
}
