package com.ifreedom.beauty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;

/**
 * Created by eavawu on 4/26/16.
 */
@SpringBootApplication
public class BeautyApplication extends SpringBootServletInitializer {
    public static void main(String[] args) {

        SpringApplication application = new SpringApplication(BeautyApplication.class);
        application.run(args);
    }
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        Object[] sources = {BeautyApplication.class,RedisConfig.class};
        return application.sources(BeautyApplication.class);
    }
}
