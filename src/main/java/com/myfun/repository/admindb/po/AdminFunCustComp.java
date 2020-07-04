package com.myfun.repository.admindb.po;

import java.io.Serializable;

public class AdminFunCustComp implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String compNo;

    /**
     *
     * @mbggenerated
     */
    private String personalAddr;

    /**
     *
     * @mbggenerated
     */
    private String enterAddr;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getCompNo() {
        return compNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompNo(String compNo) {
        this.compNo = compNo == null ? null : compNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPersonalAddr() {
        return personalAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPersonalAddr(String personalAddr) {
        this.personalAddr = personalAddr == null ? null : personalAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getEnterAddr() {
        return enterAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEnterAddr(String enterAddr) {
        this.enterAddr = enterAddr == null ? null : enterAddr.trim();
    }
}