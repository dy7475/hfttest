package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Date: 2019/12/3 15:22
 * @Description:
 */
@ApiModel
public class QueryPartnerOrgVo {

    @ApiModelProperty(value = "组织id")
    private Integer organizationId;
    @ApiModelProperty(value = "组织名称")
    private String organizationName;
    @ApiModelProperty(value = "组织path路径")
    private String organizationPath;
    @ApiModelProperty(value = "分组id")
    private Integer partnerId;
    @ApiModelProperty(value = "公司id")
    private Integer compId;
    @ApiModelProperty(value = "分组名")
    private String partnerName;
    @ApiModelProperty(value = "分组类型：0直营，1.加盟，2.总部")
    private Byte partnerType;
    @ApiModelProperty(value = "加盟合作开始时间")
    private Date cooperateStartTime;
    @ApiModelProperty(value = "加盟合作结束时间")
    private Date cooperateEndTime;
    @ApiModelProperty(value = "主管，多个‘、’隔开")
    private String userNames;


    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public String getOrganizationPath() {
        return organizationPath;
    }

    public void setOrganizationPath(String organizationPath) {
        this.organizationPath = organizationPath;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
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

    public String getUserNames() {
        return userNames;
    }

    public void setUserNames(String userNames) {
        this.userNames = userNames;
    }
}
