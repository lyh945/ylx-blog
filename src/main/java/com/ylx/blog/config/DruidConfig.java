package com.ylx.blog.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName DruidConfig
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 23:40
 * @Version 1.0
 **/
@Configuration
public class DruidConfig {

    //注入数据源
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    //后台监控
    @Bean
    public ServletRegistrationBean statViewServlet() {
        ServletRegistrationBean<StatViewServlet> registrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账户密码配置
        HashMap<String, String> initParameters = new HashMap<>();
        //增加配置
        initParameters.put("loginUsername", "admin");
        initParameters.put("loginPassword", "lyh945");
        //允许谁可以访问
        initParameters.put("allow", "");
        //禁止谁不可以访问 initParameters.put("lyh","192.168.21.23")

        registrationBean.setInitParameters(initParameters);
        return registrationBean;
    }

    //filter
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String, String> initParameters = new HashMap<>();

        //这些不进行统计
        initParameters.put("exclusions", "*.js,*.png,*.jpg,*.ico,*.gif,*.css,/druid/*");

        bean.setInitParameters(initParameters);
        return bean;
    }
}
