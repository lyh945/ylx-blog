package com.ylx.blog.pojo;

import java.util.Date;

public class Comment {
    private Long id;

    private String content;

    private Date createBy;

    private String email;

    private String name;

    private String ip;

    private Boolean isEffective;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Boolean getIsEffective() {
        return isEffective;
    }

    public void setIsEffective(Boolean isEffective) {
        this.isEffective = isEffective;
    }

    @Override
    public String toString() {
        return "BlComment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", createBy=" + createBy +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", isEffective=" + isEffective +
                '}';
    }
}