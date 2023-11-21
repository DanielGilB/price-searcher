package com.zara.price.pvp.infrastructure.persistence;

import com.zara.price.pvp.domain.*;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@AllArgsConstructor
public class SqlPvpFinderRepository implements PvpFinderRepository {

    private JpaPvpFinderRepository jpaPvpFinderRepository;

    @Override
    public Optional<Pvp> find(Criteria criteria) {

        return jpaPvpFinderRepository.findFirstByBrandIdAndProductIdAndStartAtLessThanEqualAndEndAtGreaterThanEqualOrderByPriorityDesc(criteria.brandId(), criteria.productId(), criteria.date(), criteria.date())
                .map(this::map);
    }

    private Pvp map(PriceEntity entity) {
        return Pvp.builder()
                .brandId(entity.getBrandId())
                .productId(entity.getProductId())
                .priceList(entity.getPriceList())
                .dateRange(DateRange.of(entity.getStartAt(), entity.getEndAt()))
                .money(Money.of(entity.getPrice(), entity.getCurrency()))
                .build();
    }
}
