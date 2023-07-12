package com.tapusd.hexarchdemo.infrastructure.repository.mongo;

import com.tapusd.hexarchdemo.domain.Order;
import com.tapusd.hexarchdemo.domain.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
@Primary
public class MongoDBOrderRepository implements OrderRepository {

    private final SpringDataMongoDBOrderRepository mongodbOrderRepository;

    @Autowired
    public MongoDBOrderRepository(SpringDataMongoDBOrderRepository mongodbOrderRepository) {
        this.mongodbOrderRepository = mongodbOrderRepository;
    }

    @Override
    public List<Order> findAll() {
        return mongodbOrderRepository.findAll();
    }

    @Override
    public Optional<Order> findById(UUID id) {
        return mongodbOrderRepository.findById(id);
    }

    @Override
    public void save(Order order) {
        mongodbOrderRepository.save(order);
    }
}
