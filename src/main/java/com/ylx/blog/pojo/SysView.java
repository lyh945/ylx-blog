package com.ylx.blog.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

@JsonFormat(pattern = "yyyyMMdd HH:mm:ss",timezone = "GMT+8")
public class SysView {
    private Long id;

    private String ip;

    private Date createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public Date getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Date createBy) {
        this.createBy = createBy;
    }

    @Override
    public String toString() {
        return "SysView{" +
                "id=" + id +
                ", ip='" + ip + '\'' +
                ", createBy=" + createBy +
                '}';
    }
}