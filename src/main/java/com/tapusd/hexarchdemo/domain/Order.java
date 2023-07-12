package com.tapusd.hexarchdemo.domain;

import org.springframework.util.Assert;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class Order {
    private UUID id;
    private OrderStatus status;
    private List<OrderItem> items;
    private BigDecimal price;

    public Order(UUID id, Product product) {
        Assert.notNull(id, "Order can not be null!");
        validateProduct(product);
        this.id = id;
        this.status = OrderStatus.CREATED;
        this.items = Collections.singletonList(new OrderItem(product));
        this.price = product.getPrice();
    }

    public void complete() {
        validateState();
    }


    public void addOrderProduct(Product product) {
        validateState();
        validateProduct(product);

        items.add(new OrderItem(product));
        price = price.add(product.getPrice());
    }

    public void removeOrderProduct(UUID productId) {
        validateState();
        items.stream()
                .filter(orderItem -> orderItem.getProductId().equals(productId))
                .findFirst()
                .ifPresentOrElse(orderItem -> {
                    items.remove(orderItem);
                    price = price.subtract(orderItem.getPrice());
                }, () -> {
                    throw new IllegalArgumentException("No order item found with given product id!");
                });
    }


    private void validateState() {
        Assert.isTrue(status.equals(OrderStatus.CREATED),
                "Invalid order status CREATED!");
    }

    private void validateProduct(Product product) {
        Assert.notNull(product, "Product can not be null!");
    }

    public UUID getId() {
        return id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public List<OrderItem> getItems() {
        return items;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
