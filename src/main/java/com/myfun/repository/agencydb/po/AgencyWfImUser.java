package com.myfun.repository.agencydb.po;

import java.util.Date;

public class AgencyWfImUser {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String email;

    /**
     *
     * @mbggenerated
     */
    private String userName;

    /**
     *
     * @mbggenerated
     */
    private String portait;

    /**
     *
     * @mbggenerated
     */
    private String passwd;

    /**
     *
     * @mbggenerated
     */
    private Date addTime;

    /**
     *
     * @mbggenerated
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     */
    public String getEmail() {
        return email;
    }

    /**
     *
     * @mbggenerated
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPortait() {
        return portait;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPortait(String portait) {
        this.portait = portait == null ? null : portait.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getPasswd() {
        return passwd;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPasswd(String passwd) {
        this.passwd = passwd == null ? null : passwd.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}