package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminSolrSync implements Serializable {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private String coreName;

    /**
     *
     * @mbggenerated
     */
    private Integer batchNum;

    /**
     *
     * @mbggenerated
     */
    private Integer pid;

    /**
     *
     * @mbggenerated
     */
    private Integer nid;

    /**
     *
     * @mbggenerated
     */
    private Byte type;

    /**
     *
     * @mbggenerated
     */
    private String executeStr;

    /**
     *
     * @mbggenerated
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Date executeTime;

    /**
     *
     * @mbggenerated
     */
    private Date completeTime;

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
    public String getCoreName() {
        return coreName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoreName(String coreName) {
        this.coreName = coreName == null ? null : coreName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getBatchNum() {
        return batchNum;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBatchNum(Integer batchNum) {
        this.batchNum = batchNum;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getNid() {
        return nid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setNid(Integer nid) {
        this.nid = nid;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getType() {
        return type;
    }

    /**
     *
     * @mbggenerated
     */
    public void setType(Byte type) {
        this.type = type;
    }

    /**
     *
     * @mbggenerated
     */
    public String getExecuteStr() {
        return executeStr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExecuteStr(String executeStr) {
        this.executeStr = executeStr == null ? null : executeStr.trim();
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
    public Date getExecuteTime() {
        return executeTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExecuteTime(Date executeTime) {
        this.executeTime = executeTime;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCompleteTime() {
        return completeTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCompleteTime(Date completeTime) {
        this.completeTime = completeTime;
    }
}