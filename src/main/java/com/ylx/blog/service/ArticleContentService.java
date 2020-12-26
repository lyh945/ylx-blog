package com.ylx.blog.service;

import com.ylx.blog.pojo.ArticleContent;

/**
 * @ClassName ArticleContentService
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/22 13:42
 * @Version 1.0
 **/
public interface ArticleContentService {

    //通过文章id修改文章内容
    int updateContentByArticleId(Long articleId,String Content);
}
