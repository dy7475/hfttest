package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminCrmParas implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "Id")
    private String paramId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "公司ID")
    private Integer compId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "参数值")
    private String paramValue;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "默认值")
    private String defaultValue;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "显示标记 0 不显示 1显示  默认0")
    private Byte showFlag;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "描述")
    private String paramMsg;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "分类 CRM_DIC: DIC_TYPE=PARAM_TYPE")
    private String paramType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "策略参数开启状态 0=未开启 1=开启 2=关闭第一天  默认 1")
    private Byte status;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "当前执行值")
    private String runParamValue;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "暂时弃用")
    private Integer ctrParamValue;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * Id
     */
    public String getParamId() {
        return paramId;
    }

    /**
     *
     * @mbggenerated
     * Id
     */
    public void setParamId(String paramId) {
        this.paramId = paramId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public Integer getCompId() {
        return compId;
    }

    /**
     *
     * @mbggenerated
     * 公司ID
     */
    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    /**
     *
     * @mbggenerated
     * 参数值
     */
    public String getParamValue() {
        return paramValue;
    }

    /**
     *
     * @mbggenerated
     * 参数值
     */
    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }

    /**
     *
     * @mbggenerated
     * 默认值
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     *
     * @mbggenerated
     * 默认值
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    /**
     *
     * @mbggenerated
     * 显示标记 0 不显示 1显示  默认0
     */
    public Byte getShowFlag() {
        return showFlag;
    }

    /**
     *
     * @mbggenerated
     * 显示标记 0 不显示 1显示  默认0
     */
    public void setShowFlag(Byte showFlag) {
        this.showFlag = showFlag;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public String getParamMsg() {
        return paramMsg;
    }

    /**
     *
     * @mbggenerated
     * 描述
     */
    public void setParamMsg(String paramMsg) {
        this.paramMsg = paramMsg;
    }

    /**
     *
     * @mbggenerated
     * 分类 CRM_DIC: DIC_TYPE=PARAM_TYPE
     */
    public String getParamType() {
        return paramType;
    }

    /**
     *
     * @mbggenerated
     * 分类 CRM_DIC: DIC_TYPE=PARAM_TYPE
     */
    public void setParamType(String paramType) {
        this.paramType = paramType;
    }

    /**
     *
     * @mbggenerated
     * 策略参数开启状态 0=未开启 1=开启 2=关闭第一天  默认 1
     */
    public Byte getStatus() {
        return status;
    }

    /**
     *
     * @mbggenerated
     * 策略参数开启状态 0=未开启 1=开启 2=关闭第一天  默认 1
     */
    public void setStatus(Byte status) {
        this.status = status;
    }

    /**
     *
     * @mbggenerated
     * 当前执行值
     */
    public String getRunParamValue() {
        return runParamValue;
    }

    /**
     *
     * @mbggenerated
     * 当前执行值
     */
    public void setRunParamValue(String runParamValue) {
        this.runParamValue = runParamValue;
    }

    /**
     *
     * @mbggenerated
     * 暂时弃用
     */
    public Integer getCtrParamValue() {
        return ctrParamValue;
    }

    /**
     *
     * @mbggenerated
     * 暂时弃用
     */
    public void setCtrParamValue(Integer ctrParamValue) {
        this.ctrParamValue = ctrParamValue;
    }
}