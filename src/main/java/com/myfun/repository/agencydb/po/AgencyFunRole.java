package com.myfun.repository.agencydb.po;

import java.io.Serializable;

public class AgencyFunRole implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String roleId;

    /**
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     *
     * @mbggenerated
     */
    private Integer seqNo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getRoleId() {
        return roleId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSeqNo() {
        return seqNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeqNo(Integer seqNo) {
        this.seqNo = seqNo;
    }
}