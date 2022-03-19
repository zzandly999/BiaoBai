package com.atzz.mine.bean;

import java.util.Date;

public class OnlineLogs {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private String ip;

    private String operatingSystem;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem == null ? null : operatingSystem.trim();
    }

    public Long getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(Long userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public OnlineLogs(Long id, Date createTime, Date updateTime, Date deletedAt, String ip, String operatingSystem, Long userRegisterId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.ip = ip;
        this.operatingSystem = operatingSystem;
        this.userRegisterId = userRegisterId;
    }

    public OnlineLogs() {
    }
}