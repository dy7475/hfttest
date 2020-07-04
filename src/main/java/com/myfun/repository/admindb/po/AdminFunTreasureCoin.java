package com.myfun.repository.admindb.po;

import java.io.Serializable;
import java.util.Date;

public class AdminFunTreasureCoin implements Serializable {
    /**
     *
     * @mbggenerated
    主键自增ID
     */
    private Integer id;

    /**
     *
     * @mbggenerated
    城市ID
     */
    private Integer cityId;

    /**
     *
     * @mbggenerated
    档案ID
     */
    private Integer archiveId;

    /**
     *
     * @mbggenerated
    消费的夺宝币数量
     */
    private Integer coin;

    /**
     *
     * @mbggenerated
    消费前的数量
     */
    private Integer coinBefore;

    /**
     *
     * @mbggenerated
    消费后的数量
     */
    private Integer coinAfter;

    /**
     *
     * @mbggenerated
    获取途径，1=点亮真房源 2=房源推广 3=小区竞价 
     */
    private Integer coinSource;

    /**
     *
     * @mbggenerated
    消费类型，1=获取 2=消费 3=扣除
     */
    private Integer coinType;

    /**
     *
     * @mbggenerated
    消费说明
     */
    private String coinDesc;

    /**
     *
     * @mbggenerated
    创建时间
     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
    关联所属的数据ID
     */
    private Integer sourceId;

    /**
     *
     * @mbggenerated
    关联所属的数据类型
     */
    private Integer sourceType;

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
    public Integer getCoin() {
        return coin;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCoinBefore() {
        return coinBefore;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoinBefore(Integer coinBefore) {
        this.coinBefore = coinBefore;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCoinAfter() {
        return coinAfter;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoinAfter(Integer coinAfter) {
        this.coinAfter = coinAfter;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCoinSource() {
        return coinSource;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoinSource(Integer coinSource) {
        this.coinSource = coinSource;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getCoinType() {
        return coinType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoinType(Integer coinType) {
        this.coinType = coinType;
    }

    /**
     *
     * @mbggenerated
     */
    public String getCoinDesc() {
        return coinDesc;
    }

    /**
     *
     * @mbggenerated
     */
    public void setCoinDesc(String coinDesc) {
        this.coinDesc = coinDesc;
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
    public Integer getSourceId() {
        return sourceId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getSourceType() {
        return sourceType;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSourceType(Integer sourceType) {
        this.sourceType = sourceType;
    }
}