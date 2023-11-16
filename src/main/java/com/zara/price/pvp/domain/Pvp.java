package com.zara.price.pvp.domain;


import lombok.Builder;
import org.springframework.util.Assert;

@Builder
public class Pvp {
    // If we want to be more strict we can type ids as values object. Ex: BrandId
    private Long brandId;
    private Long productId;
    private Long priceList;
    private DateRange dateRange;
    private Money money;

    private Pvp(Long brandId, Long productId, Long priceList, DateRange dateRange, Money money) {
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
