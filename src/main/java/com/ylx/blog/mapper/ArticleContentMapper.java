package com.ylx.blog.mapper;

import com.ylx.blog.pojo.ArticleContent;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ArticleContentMapper {

    int deleteByPrimaryKey(Long id);

    int insert(ArticleContent record);

    int insertSelective(ArticleContent record);

    ArticleContent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ArticleContent record);

    int updateByPrimaryKeyWithBLOBs(ArticleContent record);

    int updateByPrimaryKey(ArticleContent record);

    //通过文章id修改文章内容
    int updateContentByArticleId(ArticleContent articleContent);

    //通过文章id删除文章内容
    int deleteContentByArticleId(Long articleId);
}