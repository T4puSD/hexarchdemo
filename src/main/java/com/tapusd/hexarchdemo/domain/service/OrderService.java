package com.tapusd.hexarchdemo.domain.service;

import com.tapusd.hexarchdemo.domain.Order;
import com.tapusd.hexarchdemo.domain.Product;

import java.util.List;
import java.util.UUID;

public interface OrderService {

    UUID createOrder(Product product);

    void addOrderProduct(UUID id, Product product);

    void removeOrderProduct(UUID id, UUID productId);

    void completeOrder(UUID orderId);

    Order getOrder(UUID id);
}
