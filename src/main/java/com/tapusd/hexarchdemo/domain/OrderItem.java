package com.tapusd.hexarchdemo.domain;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {
    private UUID productId;
    private BigDecimal price;

    public OrderItem(Product product) {
        this.productId = product.getId();
        this.price = product.getPrice();
    }

    public UUID getProductId() {
        return productId;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
