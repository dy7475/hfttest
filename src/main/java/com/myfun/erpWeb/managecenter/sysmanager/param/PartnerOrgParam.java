package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class PartnerOrgParam implements EncryParamIfc {

    private static final long serialVersionUID = 1L;
    @ApiModelProperty(hidden = true)
    private Integer selfUserId;
    @ApiModelProperty(hidden = true)
    private Integer cityId;
    @ApiModelProperty(hidden = true)
    private Integer compId;
    @ApiModelProperty(hidden = true)
    private String selfCompNo;
    @ApiModelProperty(value = "跟进人姓名", hidden = true)
    private String userName;

    @ApiModelProperty(value = "组织id")
    private Integer organizationId;
    @ApiModelProperty(hidden = true)
    private String organizationPath;

    @ApiModelProperty(value = "加盟商id")
    private Integer partnerId;
    @ApiModelProperty(value = "类型：0.直营，1.加盟，2总部")
    private Byte partnerType;
    @ApiModelProperty(value = "合作开始时间：yyyy-MM-dd")
    private Date cooperateStartTime;
    @ApiModelProperty(value = "合作结束时间: yyyy-MM-dd")
    private Date cooperateEndTime;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSelfUserId() {
        return selfUserId;
    }

    public void setSelfUserId(Integer selfUserId) {
        this.selfUserId = selfUserId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getSelfCompNo() {
        return selfCompNo;
    }

    public void setSelfCompNo(String selfCompNo) {
        this.selfCompNo = selfCompNo;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Byte getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(Byte partnerType) {
        this.partnerType = partnerType;
    }

    public Date getCooperateStartTime() {
        return cooperateStartTime;
    }

    public void setCooperateStartTime(Date cooperateStartTime) {
        this.cooperateStartTime = cooperateStartTime;
    }

    public Date getCooperateEndTime() {
        return cooperateEndTime;
    }

    public void setCooperateEndTime(Date cooperateEndTime) {
        this.cooperateEndTime = cooperateEndTime;
    }

    public String getOrganizationPath() {
        return organizationPath;
    }

    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
    }
}
