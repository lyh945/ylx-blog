package com.ylx.blog.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.mapper.ArticleCategoryMapper;
import com.ylx.blog.mapper.ArticleContentMapper;
import com.ylx.blog.mapper.ArticleInfoMapper;
import com.ylx.blog.mapper.CategoryInfoMapper;
import com.ylx.blog.pojo.ArticleCategory;
import com.ylx.blog.pojo.ArticleContent;
import com.ylx.blog.pojo.ArticleInfo;
import com.ylx.blog.service.ArticleInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName ArticleInfoServiceImpl
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/21 15:12
 * @Version 1.0
 **/
@Service
public class ArticleInfoServiceImpl implements ArticleInfoService {

    private final ArticleInfoMapper articleInfoMapper;
    private final ArticleCategoryMapper articleCategoryMapper;
    private final ArticleContentMapper articleContentMapper;
    private final CategoryInfoMapper categoryInfoMapper;

    @Autowired
    public ArticleInfoServiceImpl(ArticleInfoMapper articleInfoMapper, ArticleCategoryMapper articleCategoryMapper, ArticleContentMapper articleContentMapper, CategoryInfoMapper categoryInfoMapper) {
        this.articleInfoMapper = articleInfoMapper;
        this.articleCategoryMapper = articleCategoryMapper;
        this.articleContentMapper = articleContentMapper;
        this.categoryInfoMapper = categoryInfoMapper;

        //缓存一些数据
        completeArticles = articleInfoMapper.queryCompleteArticleInfo();
    }

    //缓存一些数据
    List<CompleteArticle> completeArticles=null;

    //通过主键删除文章信息
    @Override
    public int deleteByPrimaryKey(Long id) {
        articleCategoryMapper.deleteRelationByArticleId(id);
        articleContentMapper.deleteContentByArticleId(id);
        return articleInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<ArticleInfo> queryAllArticleInfo() {
        return articleInfoMapper.queryAllArticleInfo();
    }

    @Override
    public CompleteArticle queryOneCompleteArticleInfo(Long id) {
        CompleteArticle completeArticle = null;
        for (CompleteArticle article : completeArticles) {
            if(article.getId().equals(id)){
                completeArticle=article;
                break;
            }
        }
        return completeArticle;
    }

    //通过分类id查出文章全部信息
    @Override
    public List<CompleteArticle> queryCompleteArticleByCategoryId(Long id) {
        completeArticles = articleInfoMapper.queryCompleteArticleInfo();
        List<CompleteArticle> newCompleteArticles;
        if(id!=0){
            newCompleteArticles=new ArrayList<>();
            String name = categoryInfoMapper.queryCategoryNameById(id);
            for (CompleteArticle completeArticle : completeArticles) {
                if(completeArticle.getName().equals(name)) {
                    newCompleteArticles.add(completeArticle);
                }
            }
            return newCompleteArticles;
        }
        return completeArticles;
    }


    //查询所有文章全部信息集
    @Override
    public List<CompleteArticle> queryCompleteArticleInfo() {
        return articleInfoMapper.queryCompleteArticleInfo();
    }

    //通过分类id查出文章基本信息
    @Override
    public List<ArticleInfo> queryArticleInfoByCategoryId(Long id) {
        return null;
    }

    //更新文章基本信息
    @Override
    public int updateArticleInfo(CompleteArticle completeArticle) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(completeArticle.getId());
        articleInfo.setTitle(completeArticle.getTitle());
        articleInfo.setSummary(completeArticle.getSummary());
        articleInfo.setIsTop(completeArticle.getTop());
        return articleInfoMapper.updateArticleInfo(articleInfo);
    }

    @Override
    public int changePictureUrl(Long id,String pictureUrl) {
        ArticleInfo articleInfo = new ArticleInfo();
        articleInfo.setId(id);
        articleInfo.setPictureUrl(pictureUrl);
        return articleInfoMapper.changePictureUrl(articleInfo);
    }

    //查询最热四篇文章基本及其关联信息
    @Override
    public List<CompleteArticle> queryHotCompleteArticleInfo() {
        return articleInfoMapper.queryHotCompleteArticleInfo();
    }

    //查询最新四篇文章基本及其关联信息
    @Override
    public List<CompleteArticle> queryNewCompleteArticleInfo() {
        return articleInfoMapper.queryNewCompleteArticleInfo();
    }

    @Override
    public List<ArticleInfo> queryHotArticleInfo() {
        return articleInfoMapper.queryHotArticleInfo();
    }

    @Override
    public List<ArticleInfo> queryNewArticleInfo() {
        return articleInfoMapper.queryNewArticleInfo();
    }

    //查询文章总数
    @Override
    public int queryArticleTotal() {
        return articleInfoMapper.queryArticleTotal();
    }

    //发表文章
    @Override
    public int publishCompleteArticle(CompleteArticle completeArticle) {
        ArticleInfo articleInfo = new ArticleInfo();
        ArticleCategory articleCategory = new ArticleCategory();
        ArticleContent articleContent = new ArticleContent();

        //添加文章基本信息
        articleInfo.setTitle(completeArticle.getTitle());
        articleInfo.setSummary(completeArticle.getSummary());
        articleInfo.setIsTop(completeArticle.getTop());
        articleInfo.setPictureUrl(completeArticle.getPictureUrl());
        articleInfoMapper.insertSelective(articleInfo);
        Long articleId = articleInfo.getId();
        //添加文章分类关联信息
        Long categoryId = categoryInfoMapper.queryCategoryInfoByName(completeArticle.getName()).getId();
        articleCategory.setArticleId(articleId);
        articleCategory.setCategoryId(categoryId);
        articleCategoryMapper.insertSelective(articleCategory);
        //添加文章内容信息
        articleContent.setArticleId(articleId);
        articleContent.setContent(completeArticle.getContent());
        articleContentMapper.insertSelective(articleContent);
        return 0;
    }
}
