package com.ylx.blog.controller;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.pojo.*;
import com.ylx.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName IndexController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/18 18:05
 * @Version 1.0
 **/
@Controller
@RequestMapping("/admin")
public class InitAdminController {

    private final SysViewService sysViewService;
    private final SysLogService sysLogService;
    private final CommentService commentService;
    private final CategoryInfoService categoryInfoService;
    private final ArticleInfoService articleInfoService;

    @Autowired
    public InitAdminController(SysViewService sysViewService, SysLogService sysLogService, CommentService commentService, CategoryInfoService categoryInfoService, ArticleInfoService articleInfoService) {
        this.sysViewService = sysViewService;
        this.sysLogService = sysLogService;
        this.commentService = commentService;
        this.categoryInfoService = categoryInfoService;
        this.articleInfoService = articleInfoService;

        statNum=new HashMap<>();
        statNum.put("viewNum",sysViewService.queryViewNum());
        statNum.put("logNum",sysLogService.queryLogNum());
        statNum.put("commentNum",commentService.queryCommentNum());
    }
    //公共数据缓存
    private Map<String,Integer> statNum;

    //初始化统计浏览页面
    @RequestMapping({"","/init/statistics-view"})
    public String initStatBrowse(Model model){
        List<SysView> sysViews = sysViewService.queryAllView();
        model.addAttribute("sysViews",sysViews);
        model.addAttribute("statNum",statNum);
        return "adminPage/statistics-view";
    }
    //初始化统计日志页面
    @RequestMapping("/init/statistics-log")
    public String initStatLog(Model model){
        List<SysLog> sysLogs = sysLogService.queryAllLog();
        model.addAttribute("sysLogs",sysLogs);
        model.addAttribute("statNum",statNum);
        return "adminPage/statistics-log";
    }
    //初始化统计留言页面
    @RequestMapping("/init/statistics-comment")
    public String initStatComment(Model model){
        List<Comment> comments = commentService.queryAllComment();
        model.addAttribute("comments",comments);
        model.addAttribute("statNum",statNum);
        return "adminPage/statistics-comment";
    }
    //初始化分类管理页面
    @RequestMapping("/init/category")
    public String initCategory(HttpSession session, Model model){
        List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
        model.addAttribute("categoryInfos",categoryInfos);
        return "adminPage/category";
    }
    //初始化博文管理页面
    @RequestMapping("/init/article")
    public String initArticle(Model model){
        List<CompleteArticle> completeArticles = articleInfoService.queryCompleteArticleByCategoryId(0L);
        List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
        model.addAttribute("completeArticles",completeArticles);
        model.addAttribute("categoryInfos",categoryInfos);
        return "adminPage/article";
    }
    //初始化博文管理页面替换表格
    @RequestMapping("/init/articleTable")
    public String initArticleTable(Long id,Model model){
        List<CompleteArticle> completeArticles = articleInfoService.queryCompleteArticleByCategoryId(id);
        List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
        model.addAttribute("completeArticles",completeArticles);
        model.addAttribute("categoryInfos",categoryInfos);
        return "adminPage/article::dataTable";
    }
    //初始化评论页面
    @RequestMapping("/init/comment")
    public String initComment(Model model){
        List<Comment> comments = commentService.queryAllComment();
        model.addAttribute("comments",comments);
        return "adminPage/comment";
    }
    //初始化文本输入页面
    @RequestMapping("/init/textEdit")
    public String initTextEdit(Model model){
        List<CategoryInfo> categoryInfos = categoryInfoService.queryAllCategoryInfo();
        model.addAttribute("categoryInfos",categoryInfos);
        return "adminPage/textEdit";
    }
}
