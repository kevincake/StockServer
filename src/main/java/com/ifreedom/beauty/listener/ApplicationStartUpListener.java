package com.ifreedom.beauty.listener;

import com.ifreedom.beauty.datacenter.DataManager;
import com.ifreedom.beauty.util.PropertyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * @atuhor:eavawu
 * @date:4/29/16
 * @todo:
 */
public class ApplicationStartUpListener implements WebApplicationInitializer {
    @Autowired
    DataManager dataManager;

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        PropertyUtil.loadAllProperties();
        System.out.println("ApplicationStartUpListener");
    }
}
