package com.xyhsoft.loganalyst.repository;

import com.mongodb.Mongo;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * 修改版的MongoTemplate，移除序列化时自动加入的 _class 属性
 */
public class RepositoryTemplate {

    private MongoTemplate mongoTemplate;

    public RepositoryTemplate(Mongo mongo, String databaseName) {
        MongoDbFactory mongoDbFactory = new SimpleMongoDbFactory(mongo, databaseName);
        MappingMongoConverter converter = new MappingMongoConverter(mongoDbFactory, new MongoMappingContext());
        converter.setTypeMapper(new DefaultMongoTypeMapper(null));
        mongoTemplate = new MongoTemplate(mongoDbFactory, converter);
    }

    public MongoTemplate getMongoTemplate() {
        return mongoTemplate;
    }
}
