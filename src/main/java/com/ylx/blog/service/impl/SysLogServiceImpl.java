package com.ylx.blog.service.impl;

import com.ylx.blog.mapper.SysLogMapper;
import com.ylx.blog.mapper.SysViewMapper;
import com.ylx.blog.pojo.SysLog;
import com.ylx.blog.service.SysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName SysViewServiceImpl
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 2:17
 * @Version 1.0
 **/
@Service
public class SysLogServiceImpl implements SysLogService {

    private final SysLogMapper sysLogMapper;
    @Autowired
    public SysLogServiceImpl(SysLogMapper sysLogMapper) {
        this.sysLogMapper = sysLogMapper;
    }

    @Override
    public List<SysLog> queryAllLog() {
        return sysLogMapper.queryAllLog();
    }

    @Override
    public int queryLogNum() {
        return sysLogMapper.queryLogNum();
    }
}
