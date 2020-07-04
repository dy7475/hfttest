package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminBrokerVisit implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer bvId;

    /**
     *
     * @mbggenerated
     */
    private String bvName;

    /**
     *
     * @mbggenerated
     */
    private String bvPhone;

    /**
     *
     * @mbggenerated
     */
    private Byte bvSex;

    /**
     *
     * @mbggenerated
     */
    private Short bvProvince;

    /**
     *
     * @mbggenerated
     */
    private Short bvCity;

    /**
     *
     * @mbggenerated
     */
    private String cityName;

    /**
     *
     * @mbggenerated
     */
    private String bvQq;

    /**
     *
     * @mbggenerated
     */
    private String bvComp;

    /**
     *
     * @mbggenerated
     */
    private Byte isAvailable;

    /**
     *
     * @mbggenerated
     */
    private Byte isDispos;

    /**
     *
     * @mbggenerated
     */
    private Byte isSms;

    /**
     *
     * @mbggenerated
     */
    private Byte isReg;

    /**
     *
     * @mbggenerated
     */
    private Byte regSource;

    /**
     *
     * @mbggenerated
     */
    private Date regTime;

    /**
     *
     * @mbggenerated
     */
    private Integer creatorComp;

    /**
     *
     * @mbggenerated
     */
    private Integer creatorDept;

    /**
     *
     * @mbggenerated
     */
    private Integer creatorUid;

    /**
     *
     * @mbggenerated
     */
    private Date creatorTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getBvId() {
        return bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvId(Integer bvId) {
        this.bvId = bvId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBvName() {
        return bvName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvName(String bvName) {
        this.bvName = bvName == null ? null : bvName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBvPhone() {
        return bvPhone;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvPhone(String bvPhone) {
        this.bvPhone = bvPhone == null ? null : bvPhone.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getBvSex() {
        return bvSex;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvSex(Byte bvSex) {
        this.bvSex = bvSex;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getBvProvince() {
        return bvProvince;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvProvince(Short bvProvince) {
        this.bvProvince = bvProvince;
    }

    /**
     *
     * @mbggenerated
     */
    public Short getBvCity() {
        return bvCity;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvCity(Short bvCity) {
        this.bvCity = bvCity;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCityName() {
        return cityName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityName(String cityName) {
        this.cityName = cityName == null ? null : cityName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBvQq() {
        return bvQq;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvQq(String bvQq) {
        this.bvQq = bvQq == null ? null : bvQq.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBvComp() {
        return bvComp;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBvComp(String bvComp) {
        this.bvComp = bvComp == null ? null : bvComp.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsAvailable() {
        return isAvailable;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsAvailable(Byte isAvailable) {
        this.isAvailable = isAvailable;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsDispos() {
        return isDispos;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsDispos(Byte isDispos) {
        this.isDispos = isDispos;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsSms() {
        return isSms;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsSms(Byte isSms) {
        this.isSms = isSms;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsReg() {
        return isReg;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsReg(Byte isReg) {
        this.isReg = isReg;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getRegSource() {
        return regSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegSource(Byte regSource) {
        this.regSource = regSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getRegTime() {
        return regTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegTime(Date regTime) {
        this.regTime = regTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorComp() {
        return creatorComp;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorComp(Integer creatorComp) {
        this.creatorComp = creatorComp;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorDept() {
        return creatorDept;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorDept(Integer creatorDept) {
        this.creatorDept = creatorDept;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCreatorUid() {
        return creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorUid(Integer creatorUid) {
        this.creatorUid = creatorUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreatorTime() {
        return creatorTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreatorTime(Date creatorTime) {
        this.creatorTime = creatorTime;
    }

	@Override
	public String toString() {
		return "AdminBrokerVisit [bvId=" + bvId + ", bvName=" + bvName
				+ ", bvPhone=" + bvPhone + ", bvSex=" + bvSex + ", bvProvince="
				+ bvProvince + ", bvCity=" + bvCity + ", cityName=" + cityName
				+ ", bvQq=" + bvQq + ", bvComp=" + bvComp + ", isAvailable="
				+ isAvailable + ", isDispos=" + isDispos + ", isSms=" + isSms
				+ ", isReg=" + isReg + ", regSource=" + regSource
				+ ", regTime=" + regTime + ", creatorComp=" + creatorComp
				+ ", creatorDept=" + creatorDept + ", creatorUid=" + creatorUid
				+ ", creatorTime=" + creatorTime + "]";
	}
    
    
    
    
    
}