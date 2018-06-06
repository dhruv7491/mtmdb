package com.dhruv.mdbmt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.dhruv.mdbmt.config.MultiTenantMongoDbFactory;
import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@SpringBootApplication
@EnableAsync
@EnableMongoAuditing
@EnableScheduling
public class MdbmtApplication extends SpringBootServletInitializer {
	
	  @Bean
	  public Mongo mongo() throws Exception {
	    return new MongoClient("localhost", 27017);
	  }

	 @Bean
	    public MongoTemplate mongoTemplate() throws Exception {
	        return new MongoTemplate(mongoDbFactory(mongo()));
	    }

	    @Bean
	    public MultiTenantMongoDbFactory mongoDbFactory(final Mongo mongo) throws Exception {
	        return new MultiTenantMongoDbFactory(mongo, "test");
	    }

	public static void main(String[] args) {
		SpringApplication.run(MdbmtApplication.class, args);
	}

}
