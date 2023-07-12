package com.tapusd.hexarchdemo.application.controller;

import com.tapusd.hexarchdemo.application.request.AddProductRequest;
import com.tapusd.hexarchdemo.application.request.CreateOrderRequest;
import com.tapusd.hexarchdemo.application.response.CreateOrderResponse;
import com.tapusd.hexarchdemo.application.response.Response;
import com.tapusd.hexarchdemo.domain.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderRestController {

    private final OrderService orderService;

    @Autowired
    public OrderRestController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ExceptionHandler
    public ResponseEntity<Response<Object>> handleException(IllegalArgumentException ex) {
        return ResponseEntity.badRequest()
                .body(new Response<>()
                        .setCode(HttpStatus.BAD_REQUEST.value())
                        .setMessage(ex.getMessage())
                );
    }

    @ExceptionHandler
    public ResponseEntity<Response<?>> handleException(IllegalStateException ex) {
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                .body(new Response<>()
                        .setCode(HttpStatus.UNPROCESSABLE_ENTITY.value())
                        .setMessage(ex.getMessage())
                );
    }

    @PostMapping
    public ResponseEntity<Response<CreateOrderResponse>> createOrder(@RequestBody CreateOrderRequest request) {
        var orderId = orderService.createOrder(request.product());
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response<CreateOrderResponse>()
                .setCode(HttpStatus.CREATED.value())
                .setMessage("Created")
                .setData(new CreateOrderResponse(orderId)));
    }

    @PostMapping("/{orderId}/products")
    public void addOrderProduct(@PathVariable UUID orderId, @RequestBody AddProductRequest request) {
        orderService.addOrderProduct(orderId, request.product());
    }

    @DeleteMapping("/{orderId}/products/{productId}")
    public void removeOrderProduct(@PathVariable UUID orderId, @PathVariable UUID productId) {
        orderService.removeOrderProduct(orderId, productId);
    }

    @PostMapping("/{orderId}")
    public void complete(@PathVariable UUID orderId) {
        orderService.completeOrder(orderId);
    }
}
