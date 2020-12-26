package com.ylx.blog.mapper;

import com.ylx.blog.pojo.Comment;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CommentMapper {
    //通过ID删除留言
    int deleteByPrimaryKey(Long id);

    int insert(Comment record);

    int insertSelective(Comment record);


    Comment selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);

    //查询所有留言记录
    List<Comment> queryAllComment();

    //查询留言数量
    int queryCommentNum();
}