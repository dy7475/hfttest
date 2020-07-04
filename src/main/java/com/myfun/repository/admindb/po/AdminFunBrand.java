package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunBrand implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer brandId;

    /**
     *
     * @mbggenerated
     */
    private String brandName;

    /**
     *
     * @mbggenerated
     */
    private String brandAddr;

    /**
     *
     * @mbggenerated
     */
    private Byte writeOff;

    /**
     *
     * @mbggenerated
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getBrandId() {
        return brandId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getBrandName() {
        return brandName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrandName(String brandName) {
        this.brandName = brandName == null ? null : brandName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBrandAddr() {
        return brandAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBrandAddr(String brandAddr) {
        this.brandAddr = brandAddr == null ? null : brandAddr.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWriteOff() {
        return writeOff;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWriteOff(Byte writeOff) {
        this.writeOff = writeOff;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

	@Override
	public String toString() {
		return "AdminFunBrand [brandId=" + brandId + ", brandName=" + brandName
				+ ", brandAddr=" + brandAddr + ", writeOff=" + writeOff
				+ ", updateTime=" + updateTime + "]";
	}
    
    
}