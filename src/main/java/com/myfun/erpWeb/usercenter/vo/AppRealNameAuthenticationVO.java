package com.myfun.erpWeb.usercenter.vo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
/**
 *
 * @param  * @param null
 * @author 黄建海
 * @since 2018/12/30 0030
 */
public class AppRealNameAuthenticationVO implements Serializable {
    private static final long serialVersionUID = 1L;
    @ApiModelProperty(value = "手持申请图片")
    private String realNamePhoto;
    @ApiModelProperty(value = "人工审核状态    0=失败，1=成功，100=等待审核")
    private Integer checkFlag;
    @ApiModelProperty(value = "身份证号")
    private String userIccode;
    @ApiModelProperty(value = "实名认证状态")
    private Integer userRight;

    public Integer getUserRight() {
        return userRight;
    }

    public void setUserRight(Integer userRight) {
        this.userRight = userRight;
    }

    public String getUserIccode() {
        return userIccode;
    }

    public void setUserIccode(String userIccode) {
        this.userIccode = userIccode;
    }

    public Integer getCheckFlag() {
        return checkFlag;
    }

    public void setCheckFlag(Integer checkFlag) {
        this.checkFlag = checkFlag;
    }

    public String getRealNamePhoto() {
        return realNamePhoto;
    }

    public void setRealNamePhoto(String realNamePhoto) {
        this.realNamePhoto = realNamePhoto;
    }

}