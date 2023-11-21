package com.zara.price;

import com.zara.price.pvp.infrastructure.persistence.JpaPvpFinderRepository;
import com.zara.price.pvp.infrastructure.persistence.PriceEntity;
import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class PriceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }

    // This is not a good way to insert init data.
    // The good way should be to use the migration db tool (such as liquibase)
    // To generate sample data (in the exercise context) I prefer to do it by Java code
    private JpaPvpFinderRepository jpaPvpFinderRepository;

    @PostConstruct
    private void init() {
        jpaPvpFinderRepository.saveAll(sampleData());
    }

    private List<PriceEntity> sampleData() {
        return List.of(
                PriceEntity.builder()
                        .brandId(1L)
                        .startAt(LocalDateTime.parse("2020-06-14T00:00:00").toInstant(ZoneOffset.UTC))
                        .endAt(LocalDateTime.parse("2020-12-31T23:59:59").toInstant(ZoneOffset.UTC))
                        .priceList(1L)
                        .productId(35455L)
                        .priority(0)
                        .price(BigDecimal.valueOf(35.50))
                        .currency("EUR")
                        .build(),
                PriceEntity.builder()
                        .brandId(1L)
                        .startAt(LocalDateTime.parse("2020-06-14T15:00:00").toInstant(ZoneOffset.UTC))
                        .endAt(LocalDateTime.parse("2020-06-14T18:30:00").toInstant(ZoneOffset.UTC))
                        .priceList(2L)
                        .productId(35455L)
                        .priority(1)
                        .price(BigDecimal.valueOf(25.45))
                        .currency("EUR")
                        .build(),
                PriceEntity.builder()
                        .brandId(1L)
                        .startAt(LocalDateTime.parse("2020-06-15T00:00:00").toInstant(ZoneOffset.UTC))
                        .endAt(LocalDateTime.parse("2020-06-15T11:00:00").toInstant(ZoneOffset.UTC))
                        .priceList(3L)
                        .productId(35455L)
                        .priority(1)
                        .price(BigDecimal.valueOf(30.50))
                        .currency("EUR")
                        .build(),
                PriceEntity.builder()
                        .brandId(1L)
                        .startAt(LocalDateTime.parse("2020-06-15T16:00:00").toInstant(ZoneOffset.UTC))
                        .endAt(LocalDateTime.parse("2020-12-31T23:59:59").toInstant(ZoneOffset.UTC))
                        .priceList(4L)
                        .productId(35455L)
                        .priority(1)
                        .price(BigDecimal.valueOf(38.95))
                        .currency("EUR")
                        .build()
        );
    }
}
