package com.ylx.blog.mapper;

import com.ylx.blog.pojo.SysView;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SysViewMapper {

    int deleteByPrimaryKey(Long id);

    int insert(SysView record);

    int insertSelective(SysView record);

    SysView selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(SysView record);

    int updateByPrimaryKey(SysView record);

    //查询所有访问记录
    List<SysView> queryAllView();

    //查询访问记录数量
    int queryViewNum();
}