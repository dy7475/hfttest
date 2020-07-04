package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class ErpFunEntrustTrack extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer entrustId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte caseType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer caseId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte trackType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String trackDesc;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer trackUid;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String trackTime;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getEntrustId() {
        return entrustId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setEntrustId(Integer entrustId) {
        this.entrustId = entrustId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getCaseType() {
        return caseType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCaseId() {
        return caseId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getTrackType() {
        return trackType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTrackType(Byte trackType) {
        this.trackType = trackType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getTrackDesc() {
        return trackDesc;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTrackDesc(String trackDesc) {
        this.trackDesc = trackDesc;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getTrackUid() {
        return trackUid;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTrackUid(Integer trackUid) {
        this.trackUid = trackUid;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getTrackTime() {
        return trackTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTrackTime(String trackTime) {
        this.trackTime = trackTime;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunEntrustTrack() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunEntrustTrack(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}