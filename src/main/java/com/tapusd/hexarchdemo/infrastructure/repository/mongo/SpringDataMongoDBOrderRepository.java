package com.tapusd.hexarchdemo.infrastructure.repository.mongo;

import com.tapusd.hexarchdemo.domain.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface SpringDataMongoDBOrderRepository extends MongoRepository<Order, UUID> {
}
