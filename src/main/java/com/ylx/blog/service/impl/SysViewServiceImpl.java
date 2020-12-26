package com.ylx.blog.service.impl;

import com.ylx.blog.mapper.SysViewMapper;
import com.ylx.blog.pojo.SysView;
import com.ylx.blog.service.SysViewService;
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
public class SysViewServiceImpl implements SysViewService {

    private final SysViewMapper sysViewMapper;
    @Autowired
    public SysViewServiceImpl(SysViewMapper sysViewMapper) {
        this.sysViewMapper = sysViewMapper;
    }

    @Override
    public List<SysView> queryAllView() {
        return sysViewMapper.queryAllView();
    }

    @Override
    public int queryViewNum() {
        return sysViewMapper.queryViewNum();
    }
}
