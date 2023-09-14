package com.evision.dbtestadapter.config;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@ConditionalOnProperty(name = "selected.database", havingValue = "mongodb")
public class MongoDBConfig {

    @Bean
    public MongoClient mongoClient() {
        MongoClientURI uri = new MongoClientURI("mongodb://your_mongodb_host:27017");
        return MongoClients.create(String.valueOf(uri));
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "your_mongodb_database");
    }
}
