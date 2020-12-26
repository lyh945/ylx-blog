package com.ylx.blog.controller;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.service.ArticleCategoryService;
import com.ylx.blog.service.ArticleContentService;
import com.ylx.blog.service.ArticleInfoService;
import com.ylx.blog.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName AdminArticleController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/21 15:14
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adminArticle")
public class AdminArticleController {

    private final ArticleInfoService articleInfoService;
    private final ArticleCategoryService articleCategoryService;
    private final CategoryInfoService categoryInfoService;
    private final ArticleContentService articleContentService;

    @Autowired
    public AdminArticleController(ArticleInfoService articleInfoService, ArticleCategoryService articleCategoryService, CategoryInfoService categoryInfoService, ArticleContentService articleContentService) {
        this.articleInfoService = articleInfoService;
        this.articleCategoryService = articleCategoryService;
        this.categoryInfoService = categoryInfoService;
        this.articleContentService = articleContentService;
    }

    //修改文章基本信息
    @PostMapping("/modifyArticle")
    public String modifyCategory(CompleteArticle completeArticle,@RequestParam("isTop") int isTop){
        completeArticle.setTop(isTop == 1);
        articleInfoService.updateArticleInfo(completeArticle);
        articleCategoryService.updateCategoryIdByArticleId(completeArticle.getId(),categoryInfoService.queryCategoryInfoByName(completeArticle.getName()).getId());
        return "redirect:/admin/init/article";
    }

    //修改文章内容
    @PostMapping("/modifyArticleContent")
    public String modifyArticleContent(@RequestParam("articleId") Long articleId, String content){
        articleContentService.updateContentByArticleId(articleId,content);
        return "redirect:/admin/init/article";
    }

    //删除一篇文章
    @RequestMapping("/deleteArticle")
    public String deleteArticle(Long id){
        articleInfoService.deleteByPrimaryKey(id);
        return "redirect:/admin/init/article";
    }

    //更改文章题图Url
    @RequestMapping("/changePictureUrl")
    public String changePicture(Long id,String pictureUrl){
        articleInfoService.changePictureUrl(id,pictureUrl);
        return "redirect:/admin/init/article";
    }
}
