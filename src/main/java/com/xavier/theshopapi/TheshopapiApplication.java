package com.xavier.theshopapi;

import com.github.mongobee.Mongobee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
public class TheshopapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(TheshopapiApplication.class, args);
	}

	@Autowired
	MongoTemplate mongoTemplate;

	@Bean
	public Mongobee mongobee() {
		Mongobee runner = new Mongobee("mongodb://localhost:27017/theshop");
		runner.setMongoTemplate(mongoTemplate);
		runner.setChangeLogsScanPackage("com.xavier.theshop.repository.db.migration");

		return runner;
	}

}
