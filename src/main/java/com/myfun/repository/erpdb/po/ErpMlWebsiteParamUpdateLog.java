package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpMlWebsiteParamUpdateLog extends ShardDb implements Serializable {
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
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String updateParamId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private String updateDate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date createTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Byte taskUpdate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Date taskUpdateTime;

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
    public String getUpdateParamId() {
        return updateParamId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setUpdateParamId(String updateParamId) {
        this.updateParamId = updateParamId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Byte getTaskUpdate() {
        return taskUpdate;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTaskUpdate(Byte taskUpdate) {
        this.taskUpdate = taskUpdate;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Date getTaskUpdateTime() {
        return taskUpdateTime;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setTaskUpdateTime(Date taskUpdateTime) {
        this.taskUpdateTime = taskUpdateTime;
    }

    /**
     *
     * @mbggenerated
     */
    public ErpMlWebsiteParamUpdateLog() {
        
    }

    /**
     *
     * @mbggenerated
     */
    public ErpMlWebsiteParamUpdateLog(Integer shardCityId, Integer id) {
        super(shardCityId);
        this.id = id;
    }
}