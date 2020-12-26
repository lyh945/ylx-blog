package com.ylx.blog.config;

import com.ylx.blog.mapper.AdminInfoMapper;
import com.ylx.blog.pojo.AdminInfo;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName MyRealm
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/17 22:04
 * @Version 1.0
 **/
public class MyRealm extends AuthorizingRealm {

    private final AdminInfoMapper adminInfoMapper;

    public MyRealm(AdminInfoMapper adminInfoMapper) {
        this.adminInfoMapper = adminInfoMapper;
    }

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Object username = principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(getRoles(username.toString()));
        return simpleAuthorizationInfo;
    }
    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername();
        Map<String, Object> userInfo = getUserInfo(username);
        if(userInfo==null){
            throw new UnknownAccountException();
        }
        //盐值，此处使用用户名作为盐
        ByteSource salt=ByteSource.Util.bytes(username);
        return new SimpleAuthenticationInfo(username, userInfo.get("password"), salt, getName());
    }
    //模拟数据库查询，通过用户名获取用户信息
    private Map<String,Object> getUserInfo(String username){
        AdminInfo adminInfo = adminInfoMapper.queryAdminByUsername(username);
        Map<String,Object> userInfo=null;
        if(adminInfo.getUsername().equals(username)){
            userInfo=new HashMap<>();
            userInfo.put("username",adminInfo.getUsername());
            //加密算法，原密码，盐值，加密次数
            userInfo.put("password",new SimpleHash("MD5",adminInfo.getPassword(),username,3));
        }
        return userInfo;
    }
    //模拟查询数据库，获取用户角色列表
    private Set<String> getRoles(String username){
        AdminInfo adminInfo = adminInfoMapper.queryAdminByUsername(username);
        Set<String> roles=new HashSet<>();
        roles.add(adminInfo.getRole());
        return roles;
    }
}
