package com.atzz.mine.bean;

import org.springframework.web.bind.annotation.PathVariable;

import javax.validation.constraints.Pattern;
import java.util.Date;

public class UserRegister {
    private Long id;

    private Date createTime;

    private Date updateTime;

    private Date deletedAt;

    @Pattern(regexp = "^1\\d{10}$",message = "不是完整的11位手机号")
    private String mobile;

    @Pattern(regexp = "(^[a-zA-Z0-9_-]{6,16}$)|(^[\\u2E80-\\u9FFF]{2,5})",
            message = "用户名必须是2-5位中文或者6-16位英文和数字的组合")
    private String nickName;

    private String avatar;

    @Pattern(regexp = "^\\d{9}$", message = "学号输入错误")
    private String studentNumber;

    @Pattern(regexp = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$", message = "邮箱格式不正确")
    private String email;

    @Pattern(regexp = "^(\\w){6,20}$", message = "密码格式不正确")
    private String password;

    private Byte sex;

    private String constellation;

    private String role;

    private String authenticationToken;

    private String emailAuthentication;

    private String binningTime;

    private Byte isReal;

    private Long adminId;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber == null ? null : studentNumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation == null ? null : constellation.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAuthenticationToken() {
        return authenticationToken;
    }

    public void setAuthenticationToken(String authenticationToken) {
        this.authenticationToken = authenticationToken == null ? null : authenticationToken.trim();
    }

    public String getEmailAuthentication() {
        return emailAuthentication;
    }

    public void setEmailAuthentication(String emailAuthentication) {
        this.emailAuthentication = emailAuthentication == null ? null : emailAuthentication.trim();
    }

    public String getBinningTime() {
        return binningTime;
    }

    public void setBinningTime(String binningTime) {
        this.binningTime = binningTime == null ? null : binningTime.trim();
    }

    public Byte getIsReal() {
        return isReal;
    }

    public void setIsReal(Byte isReal) {
        this.isReal = isReal;
    }

    public Long getAdminId() {
        return adminId;
    }

    public void setAdminId(Long adminId) {
        this.adminId = adminId;
    }

    public UserRegister(Long id, Date createTime, Date updateTime, Date deletedAt, String mobile, String nickName, String avatar, String studentNumber, String email, String password, Byte sex, String constellation, String role, String authenticationToken, String emailAuthentication, String binningTime, Byte isReal, Long adminId) {
        this.id = id;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.deletedAt = deletedAt;
        this.mobile = mobile;
        this.nickName = nickName;
        this.avatar = avatar;
        this.studentNumber = studentNumber;
        this.email = email;
        this.password = password;
        this.sex = sex;
        this.constellation = constellation;
        this.role = role;
        this.authenticationToken = authenticationToken;
        this.emailAuthentication = emailAuthentication;
        this.binningTime = binningTime;
        this.isReal = isReal;
        this.adminId = adminId;
    }

    public UserRegister() {
    }
}