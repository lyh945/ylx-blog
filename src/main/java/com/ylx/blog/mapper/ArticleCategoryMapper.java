package com.ylx.blog.mapper;

import com.ylx.blog.pojo.ArticleCategory;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleCategoryMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ArticleCategory record);

    int insertSelective(ArticleCategory record);

    ArticleCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleCategory record);

    int updateByPrimaryKey(ArticleCategory record);

    //通过文章id修改分类id
    int updateCategoryIdByArticleId(Long articleId,Long categoryId);

    //通过文章id获取分类id
    Long queryCategoryIdByArticleId(Long articleId);

    //通过分类id获取对应分文章数量
    int queryArticleNumByCategoryId(Long categoryId);

    //通过文章id删除本关联
    int deleteRelationByArticleId(Long articleId);

}