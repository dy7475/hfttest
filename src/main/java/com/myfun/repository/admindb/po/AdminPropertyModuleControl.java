package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminPropertyModuleControl implements Serializable {
    /**
     *
     * @mbggenerated
    主键 物业版本控制id
     */
    private Integer propertyId;

    /**
     *
     * @mbggenerated
    城市id
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    admin公司id
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    公司编号
     */
    private String compNo;

    /**
     *
     * @mbggenerated
    admin门店id
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    门店编号
     */
    private String deptNo;

    /**
     *
     * @mbggenerated
    城市交流开启状态，0 关闭 1 开启
     */
    private Byte cityExchangesFlag;

    /**
     *
     * @mbggenerated
    好房搜搜开启状态，0 关闭 1 开启
     */
    private Byte hfSosoFlag;

    /**
     *
     * @mbggenerated
    微店开启状态，0 关闭 1 开启
     */
    private Byte weiDeptFlag;

    /**
     *
     * @mbggenerated
    优优好房开启状态，0 关闭 1 开启
     */
    private Byte youHfFlag;

    /**
     *
     * @mbggenerated
    好房发发开启状态，0 关闭 1 开启
     */
    private Byte hfFafaFlag;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getPropertyId() {
        return propertyId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPropertyId(Integer propertyId) {
        this.propertyId = propertyId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

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
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getDeptNo() {
        return deptNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDeptNo(String deptNo) {
        this.deptNo = deptNo == null ? null : deptNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCityExchangesFlag() {
        return cityExchangesFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCityExchangesFlag(Byte cityExchangesFlag) {
        this.cityExchangesFlag = cityExchangesFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHfSosoFlag() {
        return hfSosoFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHfSosoFlag(Byte hfSosoFlag) {
        this.hfSosoFlag = hfSosoFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getWeiDeptFlag() {
        return weiDeptFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setWeiDeptFlag(Byte weiDeptFlag) {
        this.weiDeptFlag = weiDeptFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getYouHfFlag() {
        return youHfFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setYouHfFlag(Byte youHfFlag) {
        this.youHfFlag = youHfFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHfFafaFlag() {
        return hfFafaFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHfFafaFlag(Byte hfFafaFlag) {
        this.hfFafaFlag = hfFafaFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }
}