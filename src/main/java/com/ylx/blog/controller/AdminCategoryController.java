package com.ylx.blog.controller;

import com.ylx.blog.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @ClassName AdminCategoryController
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 18:18
 * @Version 1.0
 **/
@Controller
@RequestMapping("/adminCategory")
public class AdminCategoryController {

    private final CategoryInfoService categoryInfoService;

    @Autowired
    public AdminCategoryController(CategoryInfoService categoryInfoService) {
        this.categoryInfoService = categoryInfoService;
    }

    //通过id删除一条分类(异步刷新获取提示)
    @RequestMapping("/getDelTip")
    @ResponseBody
    public String getDelTip(Long id){
        int i = categoryInfoService.deleteByPrimaryKey(id);
        if(i==0) return "删除失败，该分类下还存在文章";
        return "删除成功";
    }

    //通过分类id修改分类名称
    @RequestMapping("/modifyCategory")
    @ResponseBody
    public String modifyCategory(Long id, String name){
        if(null==name || "".equals(name)){
            return "输入的分类名称不能为空!";
        }else if(categoryInfoService.queryCategoryInfoByName(name)!=null){
            return "输入的分类名称已经存在!";
        }else{
            categoryInfoService.updateCategoryNameByCategoryId(id, name);
        }
        return "修改成功!";
    }

    //添加一条分类
    @RequestMapping("/addCategory")
    @ResponseBody
    public String addCategory(String name){
        if(null==name || "".equals(name)){
            return "输入的分类名称不能为空!";
        }else if(categoryInfoService.queryCategoryInfoByName(name)!=null){
            return "输入的分类名称已经存在!";
        }else{
            categoryInfoService.addCategory(name);
        }
        return "添加成功!";
    }
}
