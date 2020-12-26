package com.ylx.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName JumpController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 17:58
 * @Version 1.0
 **/
@Controller
@RequestMapping("/jump")
public class JumpController {
    //跳转到用户首页页
    @RequestMapping("/user/index")
    public String toUserIndex(){
        return "/userPage/index";
    }
    //跳转到无权限页面
    @RequestMapping("/user/unauthorized")
    public String toUserAbout(){
        return "/userPage/unauthorizedPage";
    }
    //跳转到用户联系页
    @RequestMapping("/user/contact")
    public String toUserContact(){
        return "/userPage/contact";
    }
    //跳转到文本编辑页
    @RequestMapping("/admin/textEdit")
    public String toUserBlogs(){
        return "/adminPage/textEdit";
    }
    //跳转到管理员登录页
    @RequestMapping("/admin/toLogin")
    public String toAdminLogin(){
        return "/adminPage/login";
    }
    //跳转到管理员浏览统计页
    @RequestMapping("/admin/statistics-view")
    public String toAdminIndex(){
        return "redirect:/admin/init/statistics-view";
    }
    //跳转到管理员日志统计页
    @RequestMapping("/admin/statistics-log")
    public String toAdminStatisticsLog(){
        return "redirect:/admin/init/statistics-log";
    }
    //跳转到管理员评论统计页
    @RequestMapping("/admin/statistics-comment")
    public String toAdminStatisticsComment(){
        return "redirect:/admin/init/statistics-comment";
    }
}
