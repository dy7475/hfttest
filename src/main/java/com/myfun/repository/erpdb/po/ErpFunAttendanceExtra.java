package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunAttendanceExtra extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    主键
     */
    private Integer attExtraId;

    /**
     *
     * @mbggenerated
    考勤详细记录表ID
     */
    private Integer attId;

    /**
     *
     * @mbggenerated
    附件访问路径
     */
    private String filePath;

    /**
     *
     * @mbggenerated
    是否有效（0=失效 1=有效）
     */
    private Byte resultful;

    /**
     *
     * @mbggenerated
    附件类型
     */
    private Integer extraType;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getAttExtraId() {
        return attExtraId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAttExtraId(Integer attExtraId) {
        this.attExtraId = attExtraId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getAttId() {
        return attId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setAttId(Integer attId) {
        this.attId = attId;
    }

    /**
     *
     * @mbggenerated
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @mbggenerated
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath == null ? null : filePath.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getResultful() {
        return resultful;
    }

    /**
     *
     * @mbggenerated
     */
    public void setResultful(Byte resultful) {
        this.resultful = resultful;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getExtraType() {
        return extraType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setExtraType(Integer extraType) {
        this.extraType = extraType;
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
    public ErpFunAttendanceExtra() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunAttendanceExtra(Integer shardCityId, Integer attExtraId) {
        super(shardCityId);
        this.attExtraId = attExtraId;
    }
}