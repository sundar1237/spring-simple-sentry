package com;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Date;


@SpringBootApplication(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ImportResource("classpath:spring/applicationContext.xml")
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableAsync
@EnableScheduling
public class Application extends SpringBootServletInitializer {

    private static final Logger loggerApp = LoggerFactory.getLogger(Application.class);
    private static Class<Application> applicationClass = Application.class;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        loggerApp.error("http://acdf2bbb14e64563a7eacc22e69548d5@10.144.108.22:9000/2");
        loggerApp.info("iSpring application is running, since - {}", new Date());
        loggerApp.warn("iSpring application is running, since - {}", new Date());
        loggerApp.error("iSpring application is running, since - {}", new Date());
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(applicationClass);
    }
}