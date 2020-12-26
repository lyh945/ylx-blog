package com.ylx.blog.dto;

import java.util.Date;

/**
 * @ClassName CompleteArticle
 * @Description DOTO
 * @Author lyh945
 * @Date 2020/12/21 23:46
 * @Version 1.0
 **/
public class CompleteArticle {
    private Long id;

    private String title;

    private String summary;

    private Boolean isTop;

    private Integer traffic;

    private String pictureUrl;

    private Date createBy;

    private Date modifiedBy;

    private String name;

    private String content;

    public CompleteArticle() {
    }

    public CompleteArticle(String title, String summary, Boolean isTop, Integer traffic, String pictureUrl, Date createBy, Date modifiedBy, String name, String content) {
        this.title = title;
        this.summary = summary;
        this.isTop = isTop;
        this.traffic = traffic;
        this.pictureUrl = pictureUrl;
        this.createBy = createBy;
        this.modifiedBy = modifiedBy;
        this.name = name;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Boolean getTop() {
        return isTop;
    }

    public void setTop(Boolean top) {
        isTop = top;
    }

    public Integer getTraffic() {
        return traffic;
    }

    public void setTraffic(Integer traffic) {
        this.traffic = traffic;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "CompleteArticle{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", isTop=" + isTop +
                ", traffic=" + traffic +
                ", pictureUrl='" + pictureUrl + '\'' +
                ", createBy=" + createBy +
                ", modifiedBy=" + modifiedBy +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
