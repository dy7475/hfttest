package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminPropertyDuildMap implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "门店ID（admin库）")
    private Integer deptId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司ID(admin库)")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "楼盘ID")
    private Integer buildId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "经纪人ID,项目管理员 ")
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "状态1：有效；0：无效")
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 门店ID（admin库）
     */
    public Integer getDeptId() {
        return deptId;
    }

    /**
     *
     * @mbggenerated
     * 门店ID（admin库）
     */
    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID(admin库)
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID(admin库)
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * 楼盘ID
     */
    public Integer getBuildId() {
        return buildId;
    }

    /**
     *
     * @mbggenerated
     * 楼盘ID
     */
    public void setBuildId(Integer buildId) {
        this.buildId = buildId;
    }

    /**
     *
     * @mbggenerated
     * 经纪人ID,项目管理员 
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     * 经纪人ID,项目管理员 
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    /**
     *
     * @mbggenerated
     * 状态1：有效；0：无效
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     * 状态1：有效；0：无效
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}