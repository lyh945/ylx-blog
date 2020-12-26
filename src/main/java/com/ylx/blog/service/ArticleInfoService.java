package com.ylx.blog.service;

import com.github.pagehelper.PageInfo;
import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.pojo.ArticleInfo;

import java.util.List;

/**
 * @ClassName ArticleInfoService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/21 15:12
 * @Version 1.0
 **/
public interface ArticleInfoService {

    //通过主键删除一篇文章
    int deleteByPrimaryKey(Long id);

    //查询所有文章信息
    List<ArticleInfo> queryAllArticleInfo();

    //根据id查询一条文章及其分类名、内容信息
    CompleteArticle queryOneCompleteArticleInfo(Long id);

    //根据分类id查询文章全部信息集
    List<CompleteArticle> queryCompleteArticleByCategoryId(Long id);

    //查询文章全部信息集
    List<CompleteArticle> queryCompleteArticleInfo();

    //根据分类id查询文章基本信息
    List<ArticleInfo> queryArticleInfoByCategoryId(Long id);

    //修改文章基本信息
    int updateArticleInfo(CompleteArticle completeArticle);

    //根据文章id更改题图Url
    int changePictureUrl(Long id,String pictureUrl);

    //查询最热四篇文章及其分类名、内容信息
    List<CompleteArticle> queryHotCompleteArticleInfo();

    //查询最新四篇文章及其分类名、内容信息
    List<CompleteArticle> queryNewCompleteArticleInfo();

    //查询最热四篇文章
    List<ArticleInfo> queryHotArticleInfo();

    //查询最新四篇文章
    List<ArticleInfo> queryNewArticleInfo();

    //查询文章总数
    int queryArticleTotal();

    //发表一篇文章
    int publishCompleteArticle(CompleteArticle completeArticle);
}
