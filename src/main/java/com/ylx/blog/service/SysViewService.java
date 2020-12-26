package com.ylx.blog.service;

import com.ylx.blog.pojo.SysView;

import java.util.List;

/**
 * @ClassName SysViewService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 2:16
 * @Version 1.0
 **/
public interface SysViewService {

    //查询所有访问记录
    List<SysView> queryAllView();

    //查询访问记录数量
    int queryViewNum();
}
