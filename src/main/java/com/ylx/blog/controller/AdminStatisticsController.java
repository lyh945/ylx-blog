package com.ylx.blog.controller;

import com.ylx.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName AdminStatisticsController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 15:12
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adminStatistics")
public class AdminStatisticsController {

    private final CommentService commentService;

    @Autowired
    public AdminStatisticsController(CommentService commentService) {
        this.commentService = commentService;
    }

    //通过主键删除一条留言
    @RequestMapping("/deleteComment")
    public String deleteCommentById(Long id){
        commentService.deleteByPrimaryKey(id);
        return "redirect:/admin/init/statistics-comment";
    }
}
