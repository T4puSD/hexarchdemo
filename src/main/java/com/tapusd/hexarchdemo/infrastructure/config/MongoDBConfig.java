package com.tapusd.hexarchdemo.infrastructure.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.tapusd.hexarchdemo.infrastructure.repository.mongo")
public class MongoDBConfig {
}
