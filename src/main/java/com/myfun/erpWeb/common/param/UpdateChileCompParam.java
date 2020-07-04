package com.myfun.erpWeb.common.param;

import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;

@ApiModel
public class UpdateChileCompParam extends AbstractEncryParam {

    @ApiModelProperty(value = "城市")
    @NotNull(message = "城市参数缺失")
    private Integer cityId;
    @ApiModelProperty("公司名称")
    @NotNull(message = "公司名称不能为空")
    private String compName;
    @ApiModelProperty("联系电话")
    @NotNull(message = "联系电话不能为空")
    private String contactPhoneNumber;
    @ApiModelProperty("联系地址")
    @NotNull(message = "联系地址不能为空")
    private String contactAddress;
    @ApiModelProperty("负责人电话")
    @NotNull
    private String userMobile;
    @ApiModelProperty("负责人名字")
    @NotNull
    private String userName;
    @ApiModelProperty("公司Id")
    private Integer compId;
    @ApiModelProperty("更换的userId")
    private Integer userId;
    @ApiModelProperty(value = "是否主公司",hidden = true)
    private Integer mainComp = 2;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getContactPhoneNumber() {
        return contactPhoneNumber;
    }

    public void setContactPhoneNumber(String contactPhoneNumber) {
        this.contactPhoneNumber = contactPhoneNumber;
    }

    public String getContactAddress() {
        return contactAddress;
    }

    public void setContactAddress(String contactAddress) {
        this.contactAddress = contactAddress;
    }

    public String getUserMobile() {
        return userMobile;
    }

    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    public Integer getMainComp() {
        return mainComp;
    }

    public void setMainComp(Integer mainComp) {
        this.mainComp = mainComp;
    }

    public Integer getCompId() {
        return compId;
    }

    public void setCompId(Integer compId) {
        this.compId = compId;
    }
}
