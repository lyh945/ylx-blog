package com.ylx.blog.service.impl;

import com.ylx.blog.mapper.ArticleCategoryMapper;
import com.ylx.blog.mapper.ArticleInfoMapper;
import com.ylx.blog.mapper.CategoryInfoMapper;
import com.ylx.blog.service.ArticleCategoryService;
import org.springframework.stereotype.Service;

/**
 * @ClassName ArticleCategoryServiceImpl
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/22 4:25
 * @Version 1.0
 **/
@Service
public class ArticleCategoryServiceImpl implements ArticleCategoryService {

    private final ArticleCategoryMapper articleCategoryMapper;
    private final CategoryInfoMapper categoryInfoMapper;
    private final ArticleInfoMapper articleInfoMapper;

    public ArticleCategoryServiceImpl(ArticleCategoryMapper articleCategoryMapper, CategoryInfoMapper categoryInfoMapper, ArticleInfoMapper articleInfoMapper) {
        this.articleCategoryMapper = articleCategoryMapper;
        this.categoryInfoMapper = categoryInfoMapper;
        this.articleInfoMapper = articleInfoMapper;
    }

    //通过文章id获取分类id
    @Override
    public Long queryCategoryIdByArticleId(Long articleId) {
        return articleCategoryMapper.queryCategoryIdByArticleId(articleId);
    }

    //通过分类id获取对应文章数量
    @Override
    public int queryArticleNumByCategoryId(Long categoryId) {
        int articleNum = articleCategoryMapper.queryArticleNumByCategoryId(categoryId);
        if(categoryId==0) articleNum=articleInfoMapper.queryArticleTotal();
        return articleNum;
    }

    //通过文章id获取对应分分类下文章数量
    @Override
    public int queryArticleNumByArticleId(Long articleId) {
        Long categoryId = articleCategoryMapper.queryCategoryIdByArticleId(articleId);
        return articleCategoryMapper.queryArticleNumByCategoryId(categoryId);
    }

    //修改分类id
    @Override
    public int updateCategoryIdByArticleId(Long articleId,Long categoryId) {
        return articleCategoryMapper.updateCategoryIdByArticleId(articleId,categoryId);
    }
}
