package com.tapusd.hexarchdemo.domain.repository;

import com.tapusd.hexarchdemo.domain.Order;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class DomainOrderRepository implements OrderRepository {

    private final OrderRepository orderRepository;

    public DomainOrderRepository(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return orderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }
}
