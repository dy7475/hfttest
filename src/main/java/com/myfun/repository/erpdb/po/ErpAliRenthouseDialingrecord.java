package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpAliRenthouseDialingrecord extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String aliUserId;

    /**
     *
     * @mbggenerated
     */
    private String zhimaOpenId;

    /**
     *
     * @mbggenerated
     */
    private String roomCode;

    /**
     *
     * @mbggenerated
     */
    private Integer flatsTag;

    /**
     *
     * @mbggenerated
     */
    private Date recordTime;

    /**
     *
     * @mbggenerated
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    private Integer caseType;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

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
    public String getAliUserId() {
        return aliUserId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAliUserId(String aliUserId) {
        this.aliUserId = aliUserId == null ? null : aliUserId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getZhimaOpenId() {
        return zhimaOpenId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setZhimaOpenId(String zhimaOpenId) {
        this.zhimaOpenId = zhimaOpenId == null ? null : zhimaOpenId.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getRoomCode() {
        return roomCode;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRoomCode(String roomCode) {
        this.roomCode = roomCode == null ? null : roomCode.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getFlatsTag() {
        return flatsTag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFlatsTag(Integer flatsTag) {
        this.flatsTag = flatsTag;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getRecordTime() {
        return recordTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
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
    public Integer getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCaseType(Integer caseType) {
        this.caseType = caseType;
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
    public ErpAliRenthouseDialingrecord() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpAliRenthouseDialingrecord(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}