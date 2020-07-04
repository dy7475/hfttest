package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBuildingIndex extends AdminBuildingIndexKey implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private String fname;

    /**
     *
     * @mbggenerated
     */
    private Integer fregionid;

    /**
     *
     * @mbggenerated
     */
    private Integer fbusinessid;

    /**
     *
     * @mbggenerated
     */
    private Long fhousewebid;

    /**
     *
     * @mbggenerated
     */
    private String fstdate;

    /**
     *
     * @mbggenerated
     */
    private Integer fstvalue;

    /**
     *
     * @mbggenerated
     */
    private Date flastdate;

    /**
     *
     * @mbggenerated
     */
    private Byte fdealflag;

    /**
     *
     * @mbggenerated
     */
    private String fexinfo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public String getFname() {
        return fname;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFname(String fname) {
        this.fname = fname == null ? null : fname.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFregionid() {
        return fregionid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFregionid(Integer fregionid) {
        this.fregionid = fregionid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFbusinessid() {
        return fbusinessid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFbusinessid(Integer fbusinessid) {
        this.fbusinessid = fbusinessid;
    }

    /**
     *
     * @mbggenerated
     */
    public Long getFhousewebid() {
        return fhousewebid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFhousewebid(Long fhousewebid) {
        this.fhousewebid = fhousewebid;
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
    public Date getFlastdate() {
        return flastdate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlastdate(Date flastdate) {
        this.flastdate = flastdate;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getFdealflag() {
        return fdealflag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFdealflag(Byte fdealflag) {
        this.fdealflag = fdealflag;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFexinfo() {
        return fexinfo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFexinfo(String fexinfo) {
        this.fexinfo = fexinfo == null ? null : fexinfo.trim();
    }
}