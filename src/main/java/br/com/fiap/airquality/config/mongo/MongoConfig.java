package br.com.fiap.airquality.config.mongo;

import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.lang.NonNull;

import static java.util.Collections.singletonList;

@Configuration
public class MongoConfig extends AbstractMongoClientConfiguration {

    @Autowired
    Environment env;

    @Bean
    public MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        String mongoHost = env.getProperty("spring.data.mongodb.host");
        builder
                .applyToClusterSettings(settings  -> {
                    settings.hosts(singletonList(new ServerAddress(mongoHost)));
                });
    }

    @Override
    @NonNull
    protected String getDatabaseName() {
        return "air_quality";
    }

}