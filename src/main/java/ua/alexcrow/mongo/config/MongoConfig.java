package ua.alexcrow.mongo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import ua.alexcrow.mongo.events.TransferModelListener;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Bean
    public TransferModelListener transferModelListener() {
        return new TransferModelListener();
    }

    @Override
    protected String getDatabaseName() {
        return "mongo-test";
    }
}
