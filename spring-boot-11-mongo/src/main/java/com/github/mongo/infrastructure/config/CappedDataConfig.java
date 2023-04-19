package com.github.mongo.infrastructure.config;

import com.github.mongo.domain.entity.CappedDataEntity;
import jakarta.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.CollectionOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

/**
 * create in 2023/3/27 14:24
 *
 * @author shishaodong
 * @version 0.0.1
 */
@Component
public class CappedDataConfig implements CommandLineRunner {

    @Resource
    private MongoTemplate template;

    @Override
    public void run(String... args) {
        if (!template.collectionExists(CappedDataEntity.class)) {
            CollectionOptions options = CollectionOptions.empty().capped().maxDocuments(10).size(10000L);
            template.createCollection(CappedDataEntity.class, options);
        }
    }
}
