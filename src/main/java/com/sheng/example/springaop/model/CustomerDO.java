package com.sheng.example.springaop.model;

import java.util.Date;

/**
 * @author huangy
 * @date 2018/3/14
 */
public class CustomerDO {
    private static final long serialVersionUID = 7946668960323073922L;

    /**
     * 客服id
     */
    private String customerId;

    /**
     * 企业
     */
    private String fsEa;

    /**
     * 纷享用户id
     */
    private Integer userId;

    /**
     * 微联服务号id
     */
    private String appId;

    /**
     * 微信服务号id
     */
    private String wxAppId;

    /**
     * 来源类型, 1.手动添加 . 2 .crm同步
     */
    private Integer srcType;

    /**
     * 客服角色. 1.普通客服. 2.专属客服. 3.客服主管
     */
    private Integer role;

    /**
     * 状态. 1. 有效. 2.无效
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date gmtCreate;

    /**
     * 最后修改时间
     */
    private Date gmtModified;

    /**
     * 分组id
     */
    private Long groupId;

    /**
     * 部门id
     * 按部门添加客服专员时使用
     */
    private Integer departmentId;

    /**
     * 是部门（1） 不是部门（2）
     */
    private Integer isDepartment;

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Integer getIsDepartment() {
        return isDepartment;
    }

    public void setIsDepartment(Integer isDepartment) {
        this.isDepartment = isDepartment;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFsEa() {
        return fsEa;
    }

    public void setFsEa(String fsEa) {
        this.fsEa = fsEa;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public Integer getSrcType() {
        return srcType;
    }

    public void setSrcType(Integer srcType) {
        this.srcType = srcType;
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "OpenCustomerDO{" +
                "customerId='" + customerId + '\'' +
                ", fsEa='" + fsEa + '\'' +
                ", userId=" + userId +
                ", appId='" + appId + '\'' +
                ", wxAppId='" + wxAppId + '\'' +
                ", srcType=" + srcType +
                ", role=" + role +
                ", status=" + status +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", groupId=" + groupId +
                ", departmentId=" + departmentId +
                ", isDepartment=" + isDepartment +
                '}';
    }

}
