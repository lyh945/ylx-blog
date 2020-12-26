package com.ylx.blog.service.impl;

import com.ylx.blog.mapper.ArticleContentMapper;
import com.ylx.blog.pojo.ArticleContent;
import com.ylx.blog.service.ArticleContentService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ArticleContentServiceImpl
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/22 13:42
 * @Version 1.0
 **/
@Service
public class ArticleContentServiceImpl implements ArticleContentService {

    private final ArticleContentMapper articleContentMapper;

    public ArticleContentServiceImpl(ArticleContentMapper articleContentMapper) {
        this.articleContentMapper = articleContentMapper;
    }

    @Override
    public int updateContentByArticleId(Long articleId, String content) {
        ArticleContent articleContent = new ArticleContent();
        articleContent.setArticleId(articleId);
        articleContent.setContent(content);
        return articleContentMapper.updateContentByArticleId(articleContent);
    }
}
