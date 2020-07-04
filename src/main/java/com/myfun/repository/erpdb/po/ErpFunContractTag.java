package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunContractTag extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键
     */
    private Integer tagId;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
    唯一码
     */
    private String uniqueKey;

    /**
     *
     * @mbggenerated
    合同ID
     */
    private Integer contractId;

    /**
     *
     * @mbggenerated
    门店ID
     */
    private Integer deptId;

    /**
     *
     * @mbggenerated
    公司ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    批注人  对应admin库WEI_USER_INFO
     */
    private Integer createUid;

    /**
     *
     * @mbggenerated
    0:新版本  1:旧版本
     */
    private Byte tagShow;

    /**
     *
     * @mbggenerated
    更新时间
     */
    private Date updateTime;

    /**
     *
     * @mbggenerated
    更细人
     */
    private Integer updateId;

    /**
     *
     * @mbggenerated
    批注状态 0:正常 1:删除
     */
    private Byte tagStatus;

    /**
     *
     * @mbggenerated
    批注内容
     */
    private String tagContent;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getTagId() {
        return tagId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTagId(Integer tagId) {
        this.tagId = tagId;
    }

    /**
     *
     * @mbggenerated
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public String getUniqueKey() {
        return uniqueKey;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUniqueKey(String uniqueKey) {
        this.uniqueKey = uniqueKey == null ? null : uniqueKey.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getContractId() {
        return contractId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setContractId(Integer contractId) {
        this.contractId = contractId;
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
    public Integer getCreateUid() {
        return createUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateUid(Integer createUid) {
        this.createUid = createUid;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTagShow() {
        return tagShow;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTagShow(Byte tagShow) {
        this.tagShow = tagShow;
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

    /**
     *
     * @mbggenerated
     */
    public Integer getUpdateId() {
        return updateId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setUpdateId(Integer updateId) {
        this.updateId = updateId;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getTagStatus() {
        return tagStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTagStatus(Byte tagStatus) {
        this.tagStatus = tagStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public String getTagContent() {
        return tagContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setTagContent(String tagContent) {
        this.tagContent = tagContent == null ? null : tagContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunContractTag() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunContractTag(Integer shardCityId, Integer tagId) {
        super(shardCityId);
        this.tagId = tagId;
    }
}