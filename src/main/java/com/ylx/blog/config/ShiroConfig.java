package com.ylx.blog.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.ylx.blog.mapper.AdminInfoMapper;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName ShiroConfig
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/17 22:03
 * @Version 1.0
 **/
@Configuration
public class ShiroConfig {

    private final AdminInfoMapper adminInfoMapper;

    public ShiroConfig(AdminInfoMapper adminInfoMapper) {
        this.adminInfoMapper = adminInfoMapper;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){

        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //设置未认证(登录)时，访问需要认证的资源时跳转的页面
        shiroFilterFactoryBean.setLoginUrl("/admin/logout");
        //设置访问无权限的资源时跳转的页面
        shiroFilterFactoryBean.setUnauthorizedUrl("/jump/user/unauthorized");
        //指定路径和过滤器的对应关系
        Map<String,String> filterMap=new HashMap<>();
        //设置/user/login不需要登录就能访问
//        filterMap.put("/user/login","anon");
        filterMap.put("/user/*","anon");
        filterMap.put("/admin/login","anon");
        filterMap.put("/admin/loginCheck","anon");
        //设置/user/list需要登录用户拥有角色时才能访问
        filterMap.put("/ylx/**","roles[princess],roles[knight]");
        //设置/user/**只有权限为user:[*]才能访问
//        filterMap.put("/index", "perms[user:*]");
        //其他路径则需要登录才能访问
        filterMap.put("/admin","authc");
        filterMap.put("/admin/*","authc");
        filterMap.put("/admin/**","authc");
        filterMap.put("/adminArticle/*","authc");
        filterMap.put("/adminCategory/*","authc");
        filterMap.put("/adminStatistics/*","authc");
        filterMap.put("/adminTextEdit/*","authc");
        filterMap.put("/jump/admin/*","authc");
        //注销登录
//        filterMap.put("/admin/logout","logout");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("realm") Realm realm){
        DefaultWebSecurityManager defaultWebSecurityManager=new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(realm);
        return defaultWebSecurityManager;
    }

    @Bean
    public Realm realm(){
        MyRealm realm = new MyRealm(adminInfoMapper);
        //使用HashedCredentialsMatcher带加密的匹配器来替代原先明文密码匹配器
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //指定加密的算法
        hashedCredentialsMatcher.setHashAlgorithmName("MD5");
        //指定加密次数
        hashedCredentialsMatcher.setHashIterations(3);
        realm.setCredentialsMatcher(hashedCredentialsMatcher);
        return realm;
    }

    //整合ShiroDialec：用来整合shiro thymeleaf
    @Bean
    public ShiroDialect shiroDialect(){
        return new ShiroDialect();
    }


}
