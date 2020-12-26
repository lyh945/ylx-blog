package com.ylx.blog.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


/**
 * @ClassName MyWebMvcConfigurer
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 23:51
 * @Version 1.0
 **/
@Configuration
public class MyWebMvcConfigurer implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        registry.addViewController("/").setViewName("sign-in");
//        registry.addViewController("/statistics-view.html").setViewName("sign-in");
//        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("404.html").setViewName("404");
    }
}
