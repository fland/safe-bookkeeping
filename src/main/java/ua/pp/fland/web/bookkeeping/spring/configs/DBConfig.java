package ua.pp.fland.web.bookkeeping.spring.configs;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.net.UnknownHostException;

/**
 * Created with IntelliJ IDEA.
 * User: maxim
 * Date: 9/25/14
 * Time: 7:03 PM
 * To change this template use File | Settings | File Templates.
 */
@Configuration
@ComponentScan(basePackages = "ua.pp.fland.web.bookkeeping.storage.dao")
public class DBConfig {

    @Bean
    public Mongo mongo() throws UnknownHostException {
        return new MongoClient("localhost");
    }

    @Bean
    public MongoTemplate mongoTemplate() throws UnknownHostException {
        return new MongoTemplate(mongo(), "bookkeeping");
    }
}
