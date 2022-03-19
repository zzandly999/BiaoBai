package com.atzz.mine.bean;

import java.util.Date;

public class FatherComments {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private Long like;

    private Long unLike;

    private Long numberFloor;

    private String comment;

    private Byte report;

    private Long dynamicInformationId;

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

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getUnLike() {
        return unLike;
    }

    public void setUnLike(Long unLike) {
        this.unLike = unLike;
    }

    public Long getNumberFloor() {
        return numberFloor;
    }

    public void setNumberFloor(Long numberFloor) {
        this.numberFloor = numberFloor;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment == null ? null : comment.trim();
    }

    public Byte getReport() {
        return report;
    }

    public void setReport(Byte report) {
        this.report = report;
    }

    public Long getDynamicInformationId() {
        return dynamicInformationId;
    }

    public void setDynamicInformationId(Long dynamicInformationId) {
        this.dynamicInformationId = dynamicInformationId;
    }

    public Long getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(Long userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public FatherComments(Long id, Date createTime, Date updateTime, Date deletedAt, Long like, Long unLike, Long numberFloor, String comment, Byte report, Long dynamicInformationId, Long userRegisterId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.like = like;
        this.unLike = unLike;
        this.numberFloor = numberFloor;
        this.comment = comment;
        this.report = report;
        this.dynamicInformationId = dynamicInformationId;
        this.userRegisterId = userRegisterId;
    }

    public FatherComments() {
    }
}