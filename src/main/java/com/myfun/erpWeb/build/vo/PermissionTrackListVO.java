package com.myfun.erpWeb.build.vo;

import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

public class PermissionTrackListVO {



    @ApiModelProperty(value="主键ID") private Integer id;

    @ApiModelProperty(value="操作类型：-1=修改删除，0=修改新增，1=授权，2=删除，3=复制，4=全部复制") private Integer trackType;

    @ApiModelProperty(value="公司ID") private Integer compId;

    @ApiModelProperty(value="授权组织ID") private Integer organizationId;

    @ApiModelProperty(value="授权组织名称") private Integer organizationName;

    @ApiModelProperty(value="操作楼盘IDS 操作类型为删除时，删除了查看权的楼盘IDS") private String buildIdsView;

    @ApiModelProperty(value="操作楼盘IDS 操作类型为删除时，删除了查看权与编辑权的楼盘IDS") private String buildIdsEdit;

    @ApiModelProperty(value="操作楼盘IDS 操作类型为删除时，删除了三个权限的楼盘IDS") private String buildIdsAdd;

    @ApiModelProperty(value="楼盘名称字符串") private String buildNames;

    @ApiModelProperty(value="类型为复制时，复制的目标组织ID") private Integer targetOrganizationId;

    @ApiModelProperty(value="操作人USER_ID") private Integer creationUid;

    @ApiModelProperty(value="创建时间") private Date creationTime;

    @ApiModelProperty(value="跟进内容") private String content;


    public Integer getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(Integer organizationName) {
        this.organizationName = organizationName;
    }

    public String getBuildNames() {
        return buildNames;
    }

    public void setBuildNames(String buildNames) {
        this.buildNames = buildNames;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrackType() {
        return trackType;
    }

    public void setTrackType(Integer trackType) {
        this.trackType = trackType;
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

    public String getBuildIdsView() {
        return buildIdsView;
    }

    public void setBuildIdsView(String buildIdsView) {
        this.buildIdsView = buildIdsView;
    }

    public String getBuildIdsEdit() {
        return buildIdsEdit;
    }

    public void setBuildIdsEdit(String buildIdsEdit) {
        this.buildIdsEdit = buildIdsEdit;
    }

    public String getBuildIdsAdd() {
        return buildIdsAdd;
    }

    public void setBuildIdsAdd(String buildIdsAdd) {
        this.buildIdsAdd = buildIdsAdd;
    }

    public Integer getTargetOrganizationId() {
        return targetOrganizationId;
    }

    public void setTargetOrganizationId(Integer targetOrganizationId) {
        this.targetOrganizationId = targetOrganizationId;
    }

    public Integer getCreationUid() {
        return creationUid;
    }

    public void setCreationUid(Integer creationUid) {
        this.creationUid = creationUid;
    }

    public Date getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
