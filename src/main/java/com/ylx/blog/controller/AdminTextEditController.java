package com.ylx.blog.controller;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.service.ArticleInfoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @ClassName AdminTextEditController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/25 17:26
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adminTextEdit")
public class AdminTextEditController {

    private final ArticleInfoService articleInfoService;

    public AdminTextEditController(ArticleInfoService articleInfoService) {
        this.articleInfoService = articleInfoService;
    }

    @PostMapping("/publishArticle")
    public String publishArticle(CompleteArticle completeArticle/*, @RequestParam("isTop") int isTop, @RequestParam("pictureUrl") String pictureUrl*/){
//        System.out.println(isTop);
//        completeArticle.setTop(isTop == 1);
        articleInfoService.publishCompleteArticle(completeArticle);
        return "redirect:/admin/init/article";
    }
}
