package com.ylx.blog.service;

import com.ylx.blog.pojo.SysLog;
import com.ylx.blog.pojo.SysView;

import java.util.List;

/**
 * @ClassName SysLogService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 3:13
 * @Version 1.0
 **/
public interface SysLogService {

    //查询所有日志记录
    List<SysLog> queryAllLog();

    //查询日志数量
    int queryLogNum();
}
