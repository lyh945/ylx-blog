package com.ylx.blog.mapper;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.pojo.ArticleInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ArticleInfoMapper {

    //通过主键删除一篇文章
    int deleteByPrimaryKey(Long id);

    int insert(ArticleInfo record);

    int insertSelective(ArticleInfo record);

    ArticleInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleInfo record);

    int updateByPrimaryKey(ArticleInfo record);

    //查询所有文章信息
    List<ArticleInfo> queryAllArticleInfo();

    //查询文章及其分类名、内容信息
    List<CompleteArticle> queryCompleteArticleInfo();

    //修改文章基本信息
    int updateArticleInfo(ArticleInfo articleInfo);

    //根据文章id更改题图Url
    int changePictureUrl(ArticleInfo articleInfo);

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
}