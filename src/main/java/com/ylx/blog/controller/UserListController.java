package com.ylx.blog.controller;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.mapper.CategoryInfoMapper;
import com.ylx.blog.service.ArticleCategoryService;
import com.ylx.blog.service.ArticleInfoService;
import com.ylx.blog.util.PageUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName UserListController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/24 0:34
 * @Version 1.0
 **/
@Controller
@RequestMapping("/list")
public class UserListController {

    private final ArticleInfoService articleInfoService;
    private final CategoryInfoMapper categoryInfoMapper;
    private final ArticleCategoryService articleCategoryService;

    public UserListController(ArticleInfoService articleInfoService, CategoryInfoMapper categoryInfoMapper, ArticleCategoryService articleCategoryService) {
        this.articleInfoService = articleInfoService;
        this.categoryInfoMapper = categoryInfoMapper;
        this.articleCategoryService = articleCategoryService;
    }


    //点击标签更换文章列表
    @RequestMapping("/articleListByCategory")
    public String articleListByCategory(Model model, Long id){
        List<CompleteArticle> completeArticles = articleInfoService.queryCompleteArticleByCategoryId(id);
        model.addAttribute("completeArticles",completeArticles);
        return "userPage/list::articleListByCategory";
    }
    //获取点击的标签名
    @RequestMapping("/getCategoryName")
    public String getCategoryName(Model model, Long id){
        String categoryName = categoryInfoMapper.queryCategoryNameById(id);
        model.addAttribute("categoryName",categoryName);
        return "/userPage/list::categoryName";
    }
    //分页查询数据
    @RequestMapping("/pageQuery")
    public String pageQuery(Model model,@RequestParam(required = false,defaultValue="1",value="pageNum")Integer pageNum,
                            @RequestParam(defaultValue="4",value="pageSize")Integer pageSize,@RequestParam("categoryId") Long categoryId){
        //为了程序的严谨性，判断非空：
        if(pageNum == null){
            pageNum = 1;   //设置默认当前页
        }
        if(pageNum <= 0){
            pageNum = 1;
        }
        if(pageSize == null){
            pageSize = 4;    //设置默认每页显示的数据数
        }
        List<CompleteArticle> allCompleteArticles = articleInfoService.queryCompleteArticleByCategoryId(categoryId);
        int total = articleCategoryService.queryArticleNumByCategoryId(categoryId);
        PageUtil<CompleteArticle> completeArticlePageUtil = new PageUtil<>(allCompleteArticles, total);
        completeArticlePageUtil.setPageNum(pageNum);
        completeArticlePageUtil.setPageSize(pageSize);
        List<CompleteArticle> completeArticles;
        if(completeArticlePageUtil.isLast()){
            completeArticles = completeArticlePageUtil.lastPage(completeArticlePageUtil.getPageCount());
        }else if(completeArticlePageUtil.isFirst()){
            completeArticles = completeArticlePageUtil.firstPage();
        }else{
            completeArticles = completeArticlePageUtil.startPaging();
        }

        model.addAttribute("isFirst",completeArticlePageUtil.isFirst());
        model.addAttribute("isLast",completeArticlePageUtil.isLast());
        model.addAttribute("currPageNum",completeArticlePageUtil.getPageNum());
        model.addAttribute("totalPageNum",completeArticlePageUtil.getPageCount());
        model.addAttribute("completeArticles",completeArticles);
        return "userPage/list::articleListByCategory";
    }
}
