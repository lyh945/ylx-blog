package com.ylx.blog.controller;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.dto.NumOfArticlesCategory;
import com.ylx.blog.pojo.ArticleInfo;
import com.ylx.blog.pojo.CategoryInfo;
import com.ylx.blog.service.ArticleInfoService;
import com.ylx.blog.service.CategoryInfoService;
import com.ylx.blog.util.PageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 18:05
 * @Version 1.0
 **/
@Controller
public class InitUserController {

    private final ArticleInfoService articleInfoService;
    private final CategoryInfoService categoryInfoService;

    @Autowired
    public InitUserController(ArticleInfoService articleInfoService, CategoryInfoService categoryInfoService) {
        this.articleInfoService = articleInfoService;
        this.categoryInfoService = categoryInfoService;
    }

    //初始化首页(显示最热四篇)
    @RequestMapping({"/","/index","/init/index"})
    public String initBlogIndex(Model model){
        List<ArticleInfo> articleInfos = articleInfoService.queryHotArticleInfo();
        model.addAttribute("articleInfos",articleInfos);
        return "userPage/index";
    }
    //显示首页最热四篇博客列表
    @RequestMapping("/init/hotArticle")
    public String initNewArticle(Model model){
        List<ArticleInfo> articleInfos = articleInfoService.queryHotArticleInfo();
        model.addAttribute("articleInfos",articleInfos);
        return "userPage/index::hotNewList";
    }
    //显示首页最新四篇博客列表
    @RequestMapping("/init/newArticle")
    public String initHotArticle(Model model){
        List<ArticleInfo> articleInfos = articleInfoService.queryNewArticleInfo();
        model.addAttribute("articleInfos",articleInfos);
        return "userPage/index::hotNewList";
    }
    //显示所有博客列表
    @RequestMapping("/init/articleList")
    public String initArticleList(Model model){
        List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
        List<CompleteArticle> allCompleteArticles = articleInfoService.queryCompleteArticleByCategoryId(0L);
        List<NumOfArticlesCategory> numOfArticlesCategories = categoryInfoService.queryArticleNumOnCategory();
        int articleTotal = articleInfoService.queryArticleTotal();
        int articleRemaining = categoryInfoService.NumberOfArticlesRemaining();

        /*分页*/
        PageUtil<CompleteArticle> completeArticlePageUtil = new PageUtil<>(allCompleteArticles, articleTotal);
        completeArticlePageUtil.setPageNum(1);
        completeArticlePageUtil.setPageSize(4);
        List<CompleteArticle> completeArticles = completeArticlePageUtil.startPaging();
        model.addAttribute("currPageNum",completeArticlePageUtil.getPageNum());
        model.addAttribute("totalPageNum",completeArticlePageUtil.getPageCount());
        model.addAttribute("isFirst",completeArticlePageUtil.isFirst());
        model.addAttribute("isLast",completeArticlePageUtil.isLast());

        model.addAttribute("categoryInfos",categoryInfos);
        model.addAttribute("completeArticles",completeArticles);
        model.addAttribute("numOfArticlesCategories",numOfArticlesCategories);
        model.addAttribute("articleTotal",articleTotal);
        model.addAttribute("articleRemaining",articleRemaining);
        return "userPage/list";
    }
    //初始化博文页
    @RequestMapping("/init/article")
    public String initBlogArticle(Long id,Model model){
        CompleteArticle completeArticle = articleInfoService.queryOneCompleteArticleInfo(id);
        model.addAttribute("completeArticle",completeArticle);
        return "userPage/article";
    }

}
