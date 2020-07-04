package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
@ApiModel
public class NameAuthenticationParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "经纪人Id", hidden = true)
    private Integer archiveId;
    @ApiModelProperty(value = "身份证号", required = true)
    @NotNull(message = "身份证号不能为空！请检查参数")
    private String userIccode;
    @ApiModelProperty(value = "用户名", required = true)
    private String userName;
    @ApiModelProperty(value = "身份证正面照", required = true)
    private String icPhoto;
    @ApiModelProperty(value = "工作头像", required = true)
    private String userPhoto;
    @ApiModelProperty(value = "公司名称（精英版需要传，门店版不用传）")
    private String compName;
    @ApiModelProperty(value = "是否为人工审核(1.人工审核    0.人脸识别)", required = true)
    private String artificial;
    @ApiModelProperty(value = "人工审核：手持申请的图片地址", required = true)
    private String realNamePhoto;
    @ApiModelProperty(value = "版本", hidden = true)
    private boolean isPersonalVersion;
    @ApiModelProperty(value = "销售id", hidden = true)
    private Integer sellId;

    public String getRealNamePhoto() {
        return realNamePhoto;
    }

    public void setRealNamePhoto(String realNamePhoto) {
        this.realNamePhoto = realNamePhoto;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getArtificial() {
        return artificial;
    }

    public void setArtificial(String artificial) {
        this.artificial = artificial;
    }

    public String getIcPhoto() {
        return icPhoto;
    }

    public void setIcPhoto(String icPhoto) {
        this.icPhoto = icPhoto;
    }

    public String getUserPhoto() {
        return userPhoto;
    }

    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto;
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

    public String getUserIccode() {
        return userIccode;
    }

    public void setUserIccode(String userIccode) {
        this.userIccode = userIccode;
    }

    public boolean isPersonalVersion() {
        return isPersonalVersion;
    }

    public void setPersonalVersion(boolean isPersonalVersion) {
        this.isPersonalVersion = isPersonalVersion;
    }

    public Integer getSellId() {
        return sellId;
    }

    public void setSellId(Integer sellId) {
        this.sellId = sellId;
    }

}
