package com.ylx.blog.mapper;

import com.ylx.blog.pojo.AdminInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @ClassName AdminInfoMapper
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/25 20:20
 * @Version 1.0
 **/
@Repository
@Mapper
public interface AdminInfoMapper {

    //通过用户名获取管理员对象
    AdminInfo queryAdminByUsername(String username);
}
