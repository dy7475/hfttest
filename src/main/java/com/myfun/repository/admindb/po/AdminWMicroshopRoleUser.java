package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminWMicroshopRoleUser implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private Integer roleId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}