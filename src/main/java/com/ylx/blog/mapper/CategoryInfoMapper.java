package com.ylx.blog.mapper;

import com.ylx.blog.dto.NumOfArticlesCategory;
import com.ylx.blog.pojo.CategoryInfo;

import com.ylx.blog.pojo.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CategoryInfoMapper {

    //通过主键删除一条分类
    int deleteByPrimaryKey(Long id);

    //添加一条分类
    int addCategory(String name);

    int insertSelective(CategoryInfo categoryInfo);

    CategoryInfo selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CategoryInfo categoryInfo);

    int updateByPrimaryKey(CategoryInfo categoryInfo);

    //查询所有分类信息
    List<CategoryInfo> queryAllCategoryInfo();

    //通过id查找分类名称
    String queryCategoryNameById(Long id);

    //通过分类名称查找分类
    CategoryInfo queryCategoryInfoByName(String name);

    //通过分类id修改分类的名称
    int updateCategoryName(Long categoryId,String name);

    //查找对应分类及其下面文章数量
    List<NumOfArticlesCategory> queryArticleNumOnCategory();
}