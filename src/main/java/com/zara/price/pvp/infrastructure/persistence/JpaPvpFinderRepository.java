package com.zara.price.pvp.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.Instant;
import java.util.Optional;

public interface JpaPvpFinderRepository extends JpaRepository<PriceEntity, Long> {
    Optional<PriceEntity> findAllByStartAtGreaterThanEqualAndEndAtLessThanEqualOrderByPriorityDesc(Instant from, Instant to);

    Optional<PriceEntity> findFirstByBrandIdAndProductIdAndStartAtLessThanEqualAndEndAtGreaterThanEqualOrderByPriorityDesc(Long brandId, Long productId, Instant from, Instant to);
}
