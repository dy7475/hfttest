package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * @Author 蔡春林
 * @Date 2020/1/15 0015 下午 6:28
 **/
@ApiModel
public class GetOrganizationUserVo implements Serializable {

    @ApiModelProperty("经纪人Id")
    private Integer userId;
    @ApiModelProperty("经纪人档案Id")
    private Integer archiveId;
    @ApiModelProperty("经纪人档案姓名")
    private String userName;
    @ApiModelProperty("经纪人电话")
    private String userMobile;
    @ApiModelProperty("经纪人组织名称")
    private String orgName;
    @ApiModelProperty("经纪人组织Id")
    private Integer organizationId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getArchiveId() {
        return archiveId;
    }

    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

}
