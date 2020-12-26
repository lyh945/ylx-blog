package com.ylx.blog.service;

/**
 * @ClassName ArticleCategoryService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/22 4:25
 * @Version 1.0
 **/
public interface ArticleCategoryService {

    //通过文章id修改分类id
    int updateCategoryIdByArticleId(Long articleId,Long categoryId);

    //通过文章id获取分类id
    Long queryCategoryIdByArticleId(Long articleId);

    //通过分类id获取对应分文章数量
    int queryArticleNumByCategoryId(Long categoryId);

    //通过文章id获取对应分分类下文章数量
    int queryArticleNumByArticleId(Long articleId);

}
