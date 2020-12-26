package com.ylx.blog.service;

import com.ylx.blog.dto.NumOfArticlesCategory;
import com.ylx.blog.pojo.CategoryInfo;

import java.util.List;

/**
 * @ClassName CategoryInfoService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 16:51
 * @Version 1.0
 **/
public interface CategoryInfoService {

    //添加一条分类
    int addCategory(String name);

    //通过主键删除一条分类
    int deleteByPrimaryKey(Long id);

    //查询所有分类信息
    List<CategoryInfo> queryAllCategoryInfo();

    //通过分类名称查找分类
    CategoryInfo queryCategoryInfoByName(String name);

    //通过文章id修改分类的名称
    int updateCategoryNameByArticleId(Long articleId,String name);

    //通过分类id修改分类的名称
    int updateCategoryNameByCategoryId(Long categoryId,String name);

    //查找对应分类及其下面文章数量
    List<NumOfArticlesCategory> queryArticleNumOnCategory();

    //查询没有显示的剩余文章数量
    int NumberOfArticlesRemaining();
}
