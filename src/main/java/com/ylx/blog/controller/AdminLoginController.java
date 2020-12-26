package com.ylx.blog.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName AdminLoginController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/19 15:27
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class AdminLoginController {
    @RequestMapping("/login")
    public String userLogin(String username, String password, Model model){
        String loginResult;
        //获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        //用户是否已经登录，未登录则进行登录
        if(!currentUser.isAuthenticated()){
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
                //登录，进行密码对比，登录失败时抛出对应异常
                currentUser.login(token);
                return "redirect:/admin/";
            }catch(UnknownAccountException uae){
                loginResult="用户名不存在";
            }catch(IncorrectCredentialsException ice){
                loginResult="密码错误";
            }catch(AuthenticationException ae){
                loginResult="登录失败，请检查账号和密码";
            }
        }else{
            loginResult="您已经登录成功了";
        }
        model.addAttribute("loginResult",loginResult);
        return "adminPage/login";
    }

    //退出登录
    @GetMapping("/logout")
    public String adminLogout(){
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "adminPage/login";
    }
}
