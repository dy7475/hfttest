package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpBillPrintTemplet extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    创建人ID
     */
    private Integer userId;

    /**
     *
     * @mbggenerated
    archiveId
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    票据内容
     */
    private String billInformation;

    /**
     *
     * @mbggenerated
    票据图片地址
     */
    private String billAddr;

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
    public String getBillInformation() {
        return billInformation;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBillInformation(String billInformation) {
        this.billInformation = billInformation == null ? null : billInformation.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getBillAddr() {
        return billAddr;
    }

    /**
     *
     * @mbggenerated
     */
    public void setBillAddr(String billAddr) {
        this.billAddr = billAddr == null ? null : billAddr.trim();
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
    public ErpBillPrintTemplet() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpBillPrintTemplet(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}