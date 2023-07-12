package com.tapusd.hexarchdemo;

import com.tapusd.hexarchdemo.application.cli.CliOrderController;
import com.tapusd.hexarchdemo.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.UUID;

@SpringBootApplication
public class HexarchdemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(HexarchdemoApplication.class, args);
    }

    @Autowired
    CliOrderController cliOrderController;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        var product = new Product(UUID.randomUUID(), "Product2", BigDecimal.TEN.multiply(BigDecimal.TEN));
        UUID orderId = cliOrderController.createNewOrder(product);
        System.out.println("Order UUID: " + orderId);
    }
}
