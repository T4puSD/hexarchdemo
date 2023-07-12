package com.tapusd.hexarchdemo.domain.service;

import com.tapusd.hexarchdemo.domain.Order;
import com.tapusd.hexarchdemo.domain.Product;
import com.tapusd.hexarchdemo.domain.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.assertj.core.api.Assertions.assertThat;

class OrderServiceTest {

    private OrderRepository orderRepository;
    private DomainOrderService orderService;

    @BeforeEach
    void setUp() {
        orderRepository = mock(OrderRepository.class);
        orderService = new DomainOrderService(orderRepository);
    }

    @Test
    void createOrder_whenValidProduct_shouldSaveIt() {
        var product = new Product(UUID.randomUUID(), "Product1", BigDecimal.TEN);
        UUID orderId = orderService.createOrder(product);

        verify(orderRepository).save(any(Order.class));
        assertThat(orderId)
                .isNotNull();
    }

    @Test
    void createOrder_whenNullProduct_shouldThrow_illegalStateException() {
        assertThatThrownBy(() -> {
            orderService.createOrder(null);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}