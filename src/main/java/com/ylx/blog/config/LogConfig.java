package com.ylx.blog.config;


import com.ylx.blog.pojo.SysLog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @ClassName LogConfig
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/19 0:00
 * @Version 1.0
 **/
@Configuration
public class LogConfig {
    private static final Logger LOG =LoggerFactory.getLogger(LogConfig.class);

    @Bean
    public SysLog logMethod() {
        LOG.info("==========print log==========");
        return new SysLog();
    }
}
