package com.ylx.blog.mapper;

import com.ylx.blog.pojo.SysLog;

import java.util.List;

import com.ylx.blog.pojo.SysView;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysLogMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysLog record);

    int insertSelective(SysLog record);

    SysLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysLog record);

    int updateByPrimaryKey(SysLog record);

    //查询所有日志记录
    List<SysLog> queryAllLog();

    //查询日志数量
    int queryLogNum();
}