package com.ylx.blog.service.impl;

import com.ylx.blog.mapper.CommentMapper;
import com.ylx.blog.pojo.Comment;
import com.ylx.blog.service.CommentService;
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
public class CommentServiceImpl implements CommentService {

    private final CommentMapper commentMapper;
    @Autowired
    public CommentServiceImpl(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        return commentMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Comment> queryAllComment() {
        return commentMapper.queryAllComment();
    }

    @Override
    public int queryCommentNum() {
        return commentMapper.queryCommentNum();
    }
}
