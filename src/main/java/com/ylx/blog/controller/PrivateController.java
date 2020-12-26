package com.ylx.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName PrivateController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/25 20:10
 * @Version 1.0
 **/
@Controller
@RequestMapping("/ylx")
public class PrivateController {

    @RequestMapping("/privateSpace")
    public String toPrivateSpace(){
        return "userPage/private";
    }
}
