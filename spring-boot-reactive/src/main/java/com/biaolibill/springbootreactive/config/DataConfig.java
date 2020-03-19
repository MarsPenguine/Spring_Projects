package com.biaolibill.springbootreactive.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

/**
 * Mongo configuration
 */

@EnableReactiveMongoRepositories
public class DataConfig extends AbstractReactiveMongoConfiguration {

    public static final String DATABASE_NAME = "reservations";

    @Override
    public MongoClient reactiveMongoClient() {
        return MongoClients.create();
    }

    @Override
    protected String getDatabaseName() {
        return DATABASE_NAME;
    }
}

