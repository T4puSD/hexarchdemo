package com.tapusd.hexarchdemo.infrastructure.config;

import com.tapusd.hexarchdemo.domain.repository.OrderRepository;
import com.tapusd.hexarchdemo.domain.service.DomainOrderService;
import com.tapusd.hexarchdemo.domain.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public OrderService orderService(OrderRepository orderRepository) {
        return new DomainOrderService(orderRepository);
    }
}
