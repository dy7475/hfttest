package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.util.Date;

public class ErpFunPersonnelLevels extends ShardDb implements Serializable {
    /**
     *
     * @mbggenerated
    ְID
     */
    private Integer levelsId;

    /**
     *
     * @mbggenerated
    ID
     */
    private Integer compId;

    /**
     *
     * @mbggenerated
    ְ
     */
    private String levelsName;

    /**
     *
     * @mbggenerated
    ְн
     */
    private Integer levelsSalary;

    /**
     *
     * @mbggenerated

     */
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    private Integer seq;

    /**
     *
     * @mbggenerated
     */
    private Byte levelsStatus;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     */
    public Integer getLevelsId() {
        return levelsId;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLevelsId(Integer levelsId) {
        this.levelsId = levelsId;
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
    public String getLevelsName() {
        return levelsName;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLevelsName(String levelsName) {
        this.levelsName = levelsName == null ? null : levelsName.trim();
    }

    /**
     *
     * @mbggenerated
     */
    public Integer getLevelsSalary() {
        return levelsSalary;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLevelsSalary(Integer levelsSalary) {
        this.levelsSalary = levelsSalary;
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
    public Integer getSeq() {
        return seq;
    }

    /**
     *
     * @mbggenerated
     */
    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    /**
     *
     * @mbggenerated
     */
    public Byte getLevelsStatus() {
        return levelsStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public void setLevelsStatus(Byte levelsStatus) {
        this.levelsStatus = levelsStatus;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPersonnelLevels() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpFunPersonnelLevels(Integer shardCityId, Integer levelsId) {
        super(shardCityId);
        this.levelsId = levelsId;
    }
}