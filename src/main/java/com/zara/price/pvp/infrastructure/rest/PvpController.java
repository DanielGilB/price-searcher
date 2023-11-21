package com.zara.price.pvp.infrastructure.rest;

import com.zara.price.pvp.application.find.PvpFinder;
import com.zara.price.pvp.domain.Criteria;
import com.zara.price.pvp.domain.Pvp;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.util.Optional;

import static org.springframework.format.annotation.DateTimeFormat.ISO.DATE_TIME;

@RestController
@AllArgsConstructor
public class PvpController {

    private PvpFinder finder;

    @GetMapping("brands/{brandId}/products/{productId}/pvp")
    ResponseEntity<PvpResponse> find(@PathVariable final Long brandId,
                                     @PathVariable final Long productId,
                                     @RequestParam final @DateTimeFormat(iso = DATE_TIME) Optional<Instant> date) {

        Criteria criteria = Criteria.builder()
                .brandId(brandId)
                .productId(productId)
                .date(date.orElse(Instant.now()))
                .build();

        return ResponseEntity.of(finder.find(criteria).map(this::toDto));
    }

    private PvpResponse toDto(Pvp pvp) {
        return PvpResponse.builder()
                .brandId(pvp.getBrandId())
                .startAt(pvp.getDateRange().getFrom())
                .endAt(pvp.getDateRange().getTo())
                .priceList(pvp.getPriceList())
                .productId(pvp.getProductId())
                .price(pvp.getMoney().getValue())
                .currency(pvp.getMoney().getCurrency())
                .build();
    }
}
// TODO: error handler