package com.ifreedom.beauty;

import com.ifreedom.beauty.listener.ApplicationStartUpListener;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.Properties;

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
        return application.sources(BeautyApplication.class);
    }
}
