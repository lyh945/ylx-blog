package com.ylx.blog.controller;

import com.ylx.blog.service.SysViewService;
import org.springframework.stereotype.Controller;

/**
 * @ClassName SysViewController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 2:21
 * @Version 1.0
 **/
@Controller
public class SysViewController {

    private final SysViewService sysViewService;

    public SysViewController(SysViewService sysViewService) {
        this.sysViewService = sysViewService;
    }

}
