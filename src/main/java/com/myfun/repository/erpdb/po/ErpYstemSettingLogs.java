package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpYstemSettingLogs extends ShardDb {
    /**
     *
     * @mbggenerated
     */
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    private Byte sslType;

    /**
     *
     * @mbggenerated
     */
    private Integer createUid;

    /**
     *
     * @mbggenerated
     */
    private Integer influenceUid;

    /**
     *
     * @mbggenerated
     */
    private String logContent;

    /**
     *
     * @mbggenerated
     */
    private String createTime;

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
    public Byte getSslType() {
        return sslType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSslType(Byte sslType) {
        this.sslType = sslType;
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
    public Integer getInfluenceUid() {
        return influenceUid;
    }

    /**
     *
     * @mbggenerated
     */
    public void setInfluenceUid(Integer influenceUid) {
        this.influenceUid = influenceUid;
    }

    /**
     *
     * @mbggenerated
     */
    public String getLogContent() {
        return logContent;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLogContent(String logContent) {
        this.logContent = logContent == null ? null : logContent.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public String getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public ErpYstemSettingLogs() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpYstemSettingLogs(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}