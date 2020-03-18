package com.biaolibill.springbootreactive.config;

import org.springframework.boot.autoconfigure.mongo.embedded.EmbeddedMongoAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(EmbeddedMongoAutoConfiguration.class)
public class DataConfig {
}
