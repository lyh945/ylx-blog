package com.ylx.blog.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

import java.nio.charset.StandardCharsets;

/**
 * @ClassName CharacterEncodingFilterConfig
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 23:55
 * @Version 1.0
 **/
@Configuration
public class CharacterEncodingFilterConfig {
    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        //用于注册过滤器
        FilterRegistrationBean frb = new FilterRegistrationBean();
        // 使用spring 提供的字符编码过滤器，不用自己写过滤器
        CharacterEncodingFilter cef = new CharacterEncodingFilter(StandardCharsets.UTF_8.toString(),true);
        frb.setFilter(cef);
        return frb;
    }

}
