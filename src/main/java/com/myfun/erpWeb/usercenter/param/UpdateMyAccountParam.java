package com.myfun.erpWeb.usercenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel
public class UpdateMyAccountParam implements EncryParamIfc {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "验证码", required = true)
    private String key;
    @ApiModelProperty(value = "手机号", required = true)
    private String mobile;
    @ApiModelProperty(value = "创建时间", hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "用户名", hidden = true)
    private String userName;
    @ApiModelProperty(value = "经纪人档案ID", hidden = true)
    private Integer archiveId;
    @ApiModelProperty(value = "城市ID", hidden = true)
    private Integer cityId;
    @ApiModelProperty(value = "公司ID", hidden = true)
    private Integer compId;
    @ApiModelProperty(value = "部门ID", hidden = true)
    private Integer deptId;
    @ApiModelProperty(value = "省份ID", hidden = true)
    private Integer provinceId;
    @ApiModelProperty(value = "跟进内容", hidden = true)
    private String trackContent;
    @ApiModelProperty(value = "跟进描述", hidden = true)
    private String trackDesc;
    @ApiModelProperty(value = "跟进时间", hidden = true)
    private Date trackTime;
    @ApiModelProperty(value = "跟进人", hidden = true)
    private Integer trackUser;
    @ApiModelProperty(value = "验证码ID", hidden = true)
    private Integer keyId;
    @ApiModelProperty(value = "原有资金账户ID", hidden = true)
    private Integer oldUaId;
    @ApiModelProperty(value = "原有账户的所有人姓名", hidden = true)
    private String oldUserName;
    @ApiModelProperty(value = "原有账户的所有人archiveId", hidden = true)
    private Integer oldArchiveId;

    public Integer getOldArchiveId() {
        return oldArchiveId;
    }

    public void setOldArchiveId(Integer oldArchiveId) {
        this.oldArchiveId = oldArchiveId;
    }

    public String getOldUserName() {
        return oldUserName;
    }

    public void setOldUserName(String oldUserName) {
        this.oldUserName = oldUserName;
    }

    public Integer getOldUaId() {
        return oldUaId;
    }

    public void setOldUaId(Integer oldUaId) {
        this.oldUaId = oldUaId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
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

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getTrackContent() {
        return trackContent;
    }

    public void setTrackContent(String trackContent) {
        this.trackContent = trackContent;
    }

    public String getTrackDesc() {
        return trackDesc;
    }

    public void setTrackDesc(String trackDesc) {
        this.trackDesc = trackDesc;
    }

    public Date getTrackTime() {
        return trackTime;
    }

    public void setTrackTime(Date trackTime) {
        this.trackTime = trackTime;
    }

    public Integer getTrackUser() {
        return trackUser;
    }

    public void setTrackUser(Integer trackUser) {
        this.trackUser = trackUser;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
