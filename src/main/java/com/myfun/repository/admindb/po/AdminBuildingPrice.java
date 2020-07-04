package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBuildingPrice implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer fid;

    /**
     *
     * @mbggenerated
     */
    private Integer fcityid;

    /**
     *
     * @mbggenerated
     */
    private Integer fhouseid;

    /**
     *
     * @mbggenerated
     */
    private String fstdate;

    /**
     *
     * @mbggenerated
     */
    private Byte fcasetype;

    /**
     *
     * @mbggenerated
     */
    private Integer fstvalue;

    /**
     *
     * @mbggenerated
     */
    private Byte fstatus;

    /**
     *
     * @mbggenerated
     */
    private Date fcreatetime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getFid() {
        return fid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFid(Integer fid) {
        this.fid = fid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFcityid() {
        return fcityid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcityid(Integer fcityid) {
        this.fcityid = fcityid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFhouseid() {
        return fhouseid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFhouseid(Integer fhouseid) {
        this.fhouseid = fhouseid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFstdate() {
        return fstdate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFstdate(String fstdate) {
        this.fstdate = fstdate == null ? null : fstdate.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFcasetype() {
        return fcasetype;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcasetype(Byte fcasetype) {
        this.fcasetype = fcasetype;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFstvalue() {
        return fstvalue;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFstvalue(Integer fstvalue) {
        this.fstvalue = fstvalue;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFstatus() {
        return fstatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFstatus(Byte fstatus) {
        this.fstatus = fstatus;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getFcreatetime() {
        return fcreatetime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFcreatetime(Date fcreatetime) {
        this.fcreatetime = fcreatetime;
    }
}