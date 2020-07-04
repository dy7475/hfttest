package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpCityshareHouse extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID 自增
     */
    private Integer sharehouseId;

    /**
     *
     * @mbggenerated
    城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    分享人ID
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    分享人档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    房源ID
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
    房源类型（1=出售，2=出租）
     */
    private Byte caseType;

    /**
     *
     * @mbggenerated
    下架时间
     */
    private Date downTime;

    /**
     *
     * @mbggenerated
    下架类型 （1=注销，2=成交，3=合作方，4=手动 5=投诉 ）
     */
    private Byte downType;

    /**
     *
     * @mbggenerated
    分享类型（1=普通分享 2=隐号分享 3= 物业分享）
     */
    private Byte cooperationType;

    /**
     *
     * @mbggenerated
    分佣比例
     */
    private Integer commissionRate;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    隐号联系金额
     */
    private BigDecimal contactAmount;

    /**
     *
     * @mbggenerated
    经纪人门店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    投诉标记，0= 未投诉 1= 投诉中 2= 投诉成功
     */
    private Byte complainFlag;

    /**
     *
     * @mbggenerated
    投诉判断标记，0 没有投诉1 有投诉 （弃用）
     */
    private Byte isComplain;

    /**
     *
     * @mbggenerated
    上次投诉时间 
     */
    private Date lastComplainTime;

    /**
     *
     * @mbggenerated
    房源状态，1=上架中0=已下架
     */
    private Byte houseState;

    /**
     *
     * @mbggenerated
    房源NO
     */
    private String caseNo;

    /**
     *
     * @mbggenerated
    1=物业数据
     */
    private Byte isWuyeData;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getSharehouseId() {
        return sharehouseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSharehouseId(Integer sharehouseId) {
        this.sharehouseId = sharehouseId;
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
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getDownTime() {
        return downTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getDownType() {
        return downType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setDownType(Byte downType) {
        this.downType = downType;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getCooperationType() {
        return cooperationType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCooperationType(Byte cooperationType) {
        this.cooperationType = cooperationType;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCommissionRate() {
        return commissionRate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCommissionRate(Integer commissionRate) {
        this.commissionRate = commissionRate;
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

    /**
     *
     * @mbggenerated
     */
    public BigDecimal getContactAmount() {
        return contactAmount;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContactAmount(BigDecimal contactAmount) {
        this.contactAmount = contactAmount;
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
    public Byte getComplainFlag() {
        return complainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setComplainFlag(Byte complainFlag) {
        this.complainFlag = complainFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsComplain() {
        return isComplain;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsComplain(Byte isComplain) {
        this.isComplain = isComplain;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getLastComplainTime() {
        return lastComplainTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLastComplainTime(Date lastComplainTime) {
        this.lastComplainTime = lastComplainTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getHouseState() {
        return houseState;
    }

    /**
     *
     * @mbggenerated
     */
    public void setHouseState(Byte houseState) {
        this.houseState = houseState;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCaseNo() {
        return caseNo;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo == null ? null : caseNo.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getIsWuyeData() {
        return isWuyeData;
    }

    /**
     *
     * @mbggenerated
     */
    public void setIsWuyeData(Byte isWuyeData) {
        this.isWuyeData = isWuyeData;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareHouse() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpCityshareHouse(Integer shardCityId, Integer sharehouseId) {
        super(shardCityId);
        this.sharehouseId = sharehouseId;
    }
}