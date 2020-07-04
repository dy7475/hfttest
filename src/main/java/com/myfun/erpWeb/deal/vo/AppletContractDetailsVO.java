package com.myfun.erpWeb.deal.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;
@ApiModel
public class AppletContractDetailsVO implements Serializable {
    @ApiModelProperty("合同模板内容")
    private String contractTemplateContent;
    @ApiModelProperty("合同数据")
    private List indexList;
    @ApiModelProperty("经纪人名字")
    private String userName;
    @ApiModelProperty("经纪人电话")
    private String userTel;
    @ApiModelProperty("经纪人头像")
    private String userImageUrl;
    @ApiModelProperty("门店名称")
    private String userDeptName;
    @ApiModelProperty("经纪人ID")
    private Integer userId;
    @ApiModelProperty("经纪人档案ID")
    private Integer archiveId;
    @ApiModelProperty("城市ID")
    private Integer cityId;
    @ApiModelProperty("合同pdfUrl")
    private String pdfUrl;


    public String getContractTemplateContent() {
        return contractTemplateContent;
    }

    public void setContractTemplateContent(String contractTemplateContent) {
        this.contractTemplateContent = contractTemplateContent;
    }

    public List getIndexList() {
        return indexList;
    }

    public void setIndexList(List indexList) {
        this.indexList = indexList;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel;
    }

    public String getUserImageUrl() {
        return userImageUrl;
    }

    public void setUserImageUrl(String userImageUrl) {
        this.userImageUrl = userImageUrl;
    }

    public String getUserDeptName() {
        return userDeptName;
    }

    public void setUserDeptName(String userDeptName) {
        this.userDeptName = userDeptName;
    }

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

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }


}
