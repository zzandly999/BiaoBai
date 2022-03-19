package com.atzz.mine.bean;

import java.util.Date;

public class InfoLogs {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private String url;

    private Long userRegisterId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Date deletedAt) {
        this.deletedAt = deletedAt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Long getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(Long userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public InfoLogs(Long id, Date createTime, Date updateTime, Date deletedAt, String url, Long userRegisterId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.url = url;
        this.userRegisterId = userRegisterId;
    }

    public InfoLogs() {
    }
}