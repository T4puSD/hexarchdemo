package com.tapusd.hexarchdemo.domain.service;

import com.tapusd.hexarchdemo.domain.Order;
import com.tapusd.hexarchdemo.domain.Product;
import com.tapusd.hexarchdemo.domain.repository.OrderRepository;

import java.util.UUID;

public class DomainOrderService implements OrderService {

    private final OrderRepository orderRepository;

    public DomainOrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public UUID createOrder(Product product) {
        var order = new Order(UUID.randomUUID(), product);
        orderRepository.save(order);
        return order.getId();
    }

    @Override
    public void addOrderProduct(UUID id, Product product) {
        var order = getOrder(id);
        order.addOrderProduct(product);
        orderRepository.save(order);
    }

    @Override
    public void removeOrderProduct(UUID id, UUID productId) {
        var order = getOrder(id);
        order.removeOrderProduct(productId);
        orderRepository.save(order);
    }

    @Override
    public void completeOrder(UUID orderId) {
        var order = getOrder(orderId);
        order.complete();
        orderRepository.save(order);
    }

    @Override
    public Order getOrder(UUID id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("No order found with provided id!"));
    }
}
