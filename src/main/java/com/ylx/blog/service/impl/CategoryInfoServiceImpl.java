package com.ylx.blog.service.impl;

import com.ylx.blog.dto.CompleteArticle;
import com.ylx.blog.dto.NumOfArticlesCategory;
import com.ylx.blog.mapper.ArticleCategoryMapper;
import com.ylx.blog.mapper.ArticleInfoMapper;
import com.ylx.blog.mapper.CategoryInfoMapper;
import com.ylx.blog.pojo.CategoryInfo;
import com.ylx.blog.service.CategoryInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CategoryInfoServiceImpl
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/20 16:52
 * @Version 1.0
 **/
@Service
public class CategoryInfoServiceImpl implements CategoryInfoService {

    private final CategoryInfoMapper categoryInfoMapper;
    private final ArticleCategoryMapper articleCategoryMapper;
    private final ArticleInfoMapper articleInfoMapper;

    @Autowired
    public CategoryInfoServiceImpl(CategoryInfoMapper categoryInfoMapper, ArticleCategoryMapper articleCategoryMapper, ArticleInfoMapper articleInfoMapper) {
        this.categoryInfoMapper = categoryInfoMapper;
        this.articleCategoryMapper = articleCategoryMapper;
        this.articleInfoMapper = articleInfoMapper;
    }

    @Override
    public int addCategory(String name) {
        return categoryInfoMapper.addCategory(name);
    }

    @Override
    public int deleteByPrimaryKey(Long id) {
        int articleNum = articleCategoryMapper.queryArticleNumByCategoryId(id);
        if(articleNum>0) return 0;
        return categoryInfoMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<CategoryInfo> queryAllCategoryInfo() {
        return categoryInfoMapper.queryAllCategoryInfo();
    }

    @Override
    public CategoryInfo queryCategoryInfoByName(String name) {
        return categoryInfoMapper.queryCategoryInfoByName(name);
    }

    @Override
    public int updateCategoryNameByArticleId(Long articleId,String name) {
        Long categoryId = articleCategoryMapper.queryCategoryIdByArticleId(articleId);
        return categoryInfoMapper.updateCategoryName(categoryId,name);
    }
    //通过分类id修改分类名称
    @Override
    public int updateCategoryNameByCategoryId(Long categoryId,String name) {
        return categoryInfoMapper.updateCategoryName(categoryId,name);
    }

    //查找对应分类及其下面文章数量
    @Override
    public List<NumOfArticlesCategory> queryArticleNumOnCategory() {
        return categoryInfoMapper.queryArticleNumOnCategory();
    }

    //查找剩余文章数量
    @Override
    public int NumberOfArticlesRemaining() {
        int currNum=0;
        List<NumOfArticlesCategory> numOfArticlesCategories = categoryInfoMapper.queryArticleNumOnCategory();
        for (NumOfArticlesCategory numOfArticlesCategory : numOfArticlesCategories) {
            currNum+=numOfArticlesCategory.getArticleNum();
        }
        return articleInfoMapper.queryArticleTotal()-currNum;
    }

}
