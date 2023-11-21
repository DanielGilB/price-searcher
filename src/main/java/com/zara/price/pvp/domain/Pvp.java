package com.zara.price.pvp.domain;


import lombok.Builder;
import lombok.Getter;
import org.springframework.util.Assert;

@Getter
@Builder
public class Pvp {
    // If we want to be more strict we can create more value objects. BrandId, ProductId, PriceList.
    private Long brandId;
    private Long productId;
    private Long priceList;
    private DateRange dateRange;
    private Money money;

    public Pvp(Long brandId, Long productId, Long priceList, DateRange dateRange, Money money) {
        // I am using third party library (Assert) to avoid create domain validations and domains exceptions.
        // Too much boilerplate for an exercise.
        Assert.notNull(brandId, "brandId must not be null");
        Assert.notNull(productId, "productId must not be null");
        Assert.notNull(priceList, "priceList must not be null");
        Assert.notNull(dateRange, "dateRange must not be null");
        Assert.notNull(money, "money must not be null");
        this.brandId = brandId;
        this.dateRange = dateRange;
        this.priceList = priceList;
        this.productId = productId;
        this.money = money;
    }
}
