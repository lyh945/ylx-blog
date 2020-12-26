package com.ylx.blog.service;

import com.ylx.blog.pojo.Comment;

import java.util.List;

/**
 * @ClassName SysViewService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 2:16
 * @Version 1.0
 **/
public interface CommentService {
    //通过ID删除留言
    int deleteByPrimaryKey(Long id);

    //查询所有留言记录
    List<Comment> queryAllComment();

    //查询留言数量
    int queryCommentNum();
}
