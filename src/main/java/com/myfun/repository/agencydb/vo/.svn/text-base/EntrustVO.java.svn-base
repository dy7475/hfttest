package com.myfun.repository.agencydb.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * @author czq
 * @since 2019/8/15
 */
public class EntrustVO implements Serializable {

    @ApiModelProperty(value = "委托表主键ID")
    private Integer wfId;

    @ApiModelProperty(value = "是否是专属委托 1：是、0：否")
    private Byte isVip;

    @ApiModelProperty(value = "房客源ID")
    private Integer caseId;

    @ApiModelProperty(value = "委托类型 1=出售 2=出租 3=求购 4=求租")
    private Byte caseType;

    @ApiModelProperty(value = "发布委托的优优用户名")
    private String youyouUsername;

    @ApiModelProperty(value = "信息标题摘要")
    private String caseSubject;

    @ApiModelProperty(value = "描述")
    private String caseDesc;

    @ApiModelProperty(value = "状态(-2 已删除,-1未正常支付的,0无效1正常,2成交)  查询列表的时候-1和-2的不查询")
    private Integer wfStatus;

    @ApiModelProperty(value = "委托时间", hidden = true)
    private Date creationTime;

    @ApiModelProperty(value = "微信ID，目前作为USER_ID使用")
    private Integer wxId;

    @ApiModelProperty(value = "经纪人委托接单记录表中数量(大于0表示有人抢单)")
    private Long logCount;

    @ApiModelProperty(value = "委托时间")
    private String wtTime;

    public Integer getWfId() {
        return wfId;
    }

    public void setWfId(Integer wfId) {
        this.wfId = wfId;
    }

    public Byte getIsVip() {
        return isVip;
    }

    public void setIsVip(Byte isVip) {
        this.isVip = isVip;
    }

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public Byte getCaseType() {
        return caseType;
    }

    public void setCaseType(Byte caseType) {
        this.caseType = caseType;
    }

    public String getYouyouUsername() {
        return youyouUsername;
    }

    public void setYouyouUsername(String youyouUsername) {
        this.youyouUsername = youyouUsername;
    }

    public String getCaseSubject() {
        return caseSubject;
    }

    public void setCaseSubject(String caseSubject) {
        this.caseSubject = caseSubject;
    }

    public String getCaseDesc() {
        return caseDesc;
    }

    public void setCaseDesc(String caseDesc) {
        this.caseDesc = caseDesc;
    }

    public Integer getWfStatus() {
        return wfStatus;
    }

    public void setWfStatus(Integer wfStatus) {
        this.wfStatus = wfStatus;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getWxId() {
        return wxId;
    }

    public void setWxId(Integer wxId) {
        this.wxId = wxId;
    }

    public Long getLogCount() {
        return logCount;
    }

    public void setLogCount(Long logCount) {
        this.logCount = logCount;
    }

    public String getWtTime() {
        return wtTime;
    }

    public void setWtTime(String wtTime) {
        this.wtTime = wtTime;
    }
}