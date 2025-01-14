package com.example.springmongodb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;

@SpringBootApplication
public class SpringMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringMongodbApplication.class, args);
	}
	@Bean
	public MongoTemplate mongoTemplate(MongoDatabaseFactory databaseFactory, MappingMongoConverter converter) {
		converter.setTypeMapper(new DefaultMongoTypeMapper(null));
		return new MongoTemplate(databaseFactory, converter);
	}
}
