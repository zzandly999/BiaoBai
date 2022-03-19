package com.atzz.mine.bean;

import java.util.Date;

public class UserRealnames {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    private String studentNumber;

    private String school;

    private String realName;

    private String academy;

    private String age;

    private String teacherName;

    private String dormitoryFloorNumber;

    private String dormitoryNumber;

    private Long userRegisterId;

    private Long teacherId;

    private String type;

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

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school == null ? null : school.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getAcademy() {
        return academy;
    }

    public void setAcademy(String academy) {
        this.academy = academy == null ? null : academy.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName == null ? null : teacherName.trim();
    }

    public String getDormitoryFloorNumber() {
        return dormitoryFloorNumber;
    }

    public void setDormitoryFloorNumber(String dormitoryFloorNumber) {
        this.dormitoryFloorNumber = dormitoryFloorNumber == null ? null : dormitoryFloorNumber.trim();
    }

    public String getDormitoryNumber() {
        return dormitoryNumber;
    }

    public void setDormitoryNumber(String dormitoryNumber) {
        this.dormitoryNumber = dormitoryNumber == null ? null : dormitoryNumber.trim();
    }

    public Long getUserRegisterId() {
        return userRegisterId;
    }

    public void setUserRegisterId(Long userRegisterId) {
        this.userRegisterId = userRegisterId;
    }

    public Long getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Long teacherId) {
        this.teacherId = teacherId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public UserRealnames(Long id, Date createTime, Date updateTime, Date deletedAt, String studentNumber, String school, String realName, String academy, String age, String teacherName, String dormitoryFloorNumber, String dormitoryNumber, Long userRegisterId, Long teacherId, String type) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.studentNumber = studentNumber;
        this.school = school;
        this.realName = realName;
        this.academy = academy;
        this.age = age;
        this.teacherName = teacherName;
        this.dormitoryFloorNumber = dormitoryFloorNumber;
        this.dormitoryNumber = dormitoryNumber;
        this.userRegisterId = userRegisterId;
        this.teacherId = teacherId;
        this.type = type;
    }

    public UserRealnames() {
    }
}