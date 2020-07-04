package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunTaskTimed extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键id
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    公司Id
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    大区Id
     */
    private Integer areaId;

    /**
     *
     * @mbggenerated
    片区id
     */
    private Integer regId;

    /**
     *
     * @mbggenerated
    门店id
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    分组id
     */
    private Integer grId;

    /**
     *
     * @mbggenerated
    员工id
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    档案id
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    任务iD
     */
    private Integer taskId;

    /**
     *
     * @mbggenerated
    taskTime
     */
    private Date taskTime;

    /**
     *
     * @mbggenerated
    被提醒人
     */
    private Integer taskOwner;

    /**
     *
     * @mbggenerated
    任务所属
     */
    private Integer taskCreate;

    /**
     *
     * @mbggenerated
    阅读标记 1=已读
     */
    private Byte readFlag;

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
    public Integer getAreaId() {
        return areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getRegId() {
        return regId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setRegId(Integer regId) {
        this.regId = regId;
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
    public Integer getGrId() {
        return grId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setGrId(Integer grId) {
        this.grId = grId;
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
    public Integer getTaskId() {
        return taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getTaskTime() {
        return taskTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskTime(Date taskTime) {
        this.taskTime = taskTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTaskOwner() {
        return taskOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskOwner(Integer taskOwner) {
        this.taskOwner = taskOwner;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getTaskCreate() {
        return taskCreate;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTaskCreate(Integer taskCreate) {
        this.taskCreate = taskCreate;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getReadFlag() {
        return readFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public void setReadFlag(Byte readFlag) {
        this.readFlag = readFlag;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunTaskTimed() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunTaskTimed(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}