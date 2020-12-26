package com.ylx.blog.dto;

/**
 * @ClassName NumOfArticlesCategory
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/24 1:07
 * @Version 1.0
 **/
public class NumOfArticlesCategory {
    private Long id;
    private String name;
    private int articleNum;

    public NumOfArticlesCategory() {
    }

    public NumOfArticlesCategory(Long id, String name, int articleNum) {
        this.id = id;
        this.name = name;
        this.articleNum = articleNum;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getArticleNum() {
        return articleNum;
    }

    public void setArticleNum(int articleNum) {
        this.articleNum = articleNum;
    }

    @Override
    public String toString() {
        return "NumOfArticlesCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", articleNum=" + articleNum +
                '}';
    }
}
