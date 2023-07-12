package com.tapusd.hexarchdemo.application.cli;

import com.tapusd.hexarchdemo.domain.Product;
import com.tapusd.hexarchdemo.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CliOrderController {

    private final OrderService orderService;

    @Autowired
    public CliOrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    public UUID createNewOrder(Product product) {
        return orderService.createOrder(product);
    }

    public void addNewOrderProduct(UUID orderId, Product product) {
        orderService.addOrderProduct(orderId, product);
    }

    public void removeOrderProduct(UUID orderId, UUID productId) {
        orderService.removeOrderProduct(orderId, productId);
    }

    public void complete(UUID orderId) {
        orderService.completeOrder(orderId);
    }
}
