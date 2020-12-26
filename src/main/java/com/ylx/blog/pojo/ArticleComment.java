package com.ylx.blog.pojo;

import java.util.Date;

public class ArticleComment {
    private Long id;

    private Long articleId;

    private Long commentId;

    private Date createBy;

    private Boolean isEffective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    @Override
    public String toString() {
        return "BlArticleComment{" +
                "id=" + id +
                ", articleId=" + articleId +
                ", commentId=" + commentId +
                ", createBy=" + createBy +
                ", isEffective=" + isEffective +
                '}';
    }
}