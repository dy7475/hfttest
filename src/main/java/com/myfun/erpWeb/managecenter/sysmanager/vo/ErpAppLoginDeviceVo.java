package com.myfun.erpWeb.managecenter.sysmanager.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.Date;

@ApiModel(description = "获取app登录设备审核列表VO")
public class ErpAppLoginDeviceVo implements Serializable {
    /**
     * @mbggenerated id
     */
    @ApiModelProperty("登录id")
    private Integer loginId;
    /**
     * @mbggenerated 公司id
     */
    @ApiModelProperty("公司id")
    private Integer compId;
    /**
     * @mbggenerated 门店id
     */
    @ApiModelProperty("门店id")
    private Integer deptId;
    /**
     * @mbggenerated 用户id
     */
    @ApiModelProperty("用户id")
    private Integer userId;
    /**
     * @mbggenerated 档案id
     */
    @ApiModelProperty("档案id")
    private Integer archiveId;
    /**
     * @mbggenerated 设备类型 1=android 2=ios
     */
    @ApiModelProperty("设备类型 1=android 2=ios")
    private Byte deviceType;
    /**
     * @mbggenerated 设备编号android=imei iso=idfv
     */
    @ApiModelProperty("设备编号android=imei iso=idfv")
    private String deviceNum1;
    /**
     * @mbggenerated 设备编号2 android=defindid
     */
    @ApiModelProperty("设备编号2 android=defindid")
    private String deviceNum2;
    /**
     * @mbggenerated 状态 0=自动通过审核 1=手动通过审核 2=申请 3=拒绝 4=取消审核 5=过期
     */
    @ApiModelProperty("状态 0=自动通过审核 1=手动通过审核 2=申请 3=拒绝 4=取消审核 5=过期")
    private Byte deviceStatus;
    /**
     * @mbggenerated 定位地址
     */
    @ApiModelProperty("定位地址")
    private String loginAddress;
    /**
     * @mbggenerated 个推的token
     */
    @ApiModelProperty("个推的token")
    private String getuiToken;
    /**
     * @mbggenerated 创建时间
     *
     */
    @ApiModelProperty("创建时间")
    private Date createTime;
    /**
     * @mbggenerated 审核人id
     */
    @ApiModelProperty("审核人id")
    private Integer checkUserId;
    /**
     * @mbggenerated 审核时间
     */
    @ApiModelProperty("审核时间")
    private Date checkTime;
    @ApiModelProperty("经纪人姓名")
    private String userName;//经纪人姓名
    @ApiModelProperty("审核人姓名")
    private String checkUserName;//审核人姓名

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
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

    public Byte getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(Byte deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceNum1() {
        return deviceNum1;
    }

    public void setDeviceNum1(String deviceNum1) {
        this.deviceNum1 = deviceNum1;
    }

    public String getDeviceNum2() {
        return deviceNum2;
    }

    public void setDeviceNum2(String deviceNum2) {
        this.deviceNum2 = deviceNum2;
    }

    public Byte getDeviceStatus() {
        return deviceStatus;
    }

    public void setDeviceStatus(Byte deviceStatus) {
        this.deviceStatus = deviceStatus;
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress;
    }

    public String getGetuiToken() {
        return getuiToken;
    }

    public void setGetuiToken(String getuiToken) {
        this.getuiToken = getuiToken;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getCheckUserId() {
        return checkUserId;
    }

    public void setCheckUserId(Integer checkUserId) {
        this.checkUserId = checkUserId;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCheckUserName() {
        return checkUserName;
    }

    public void setCheckUserName(String checkUserName) {
        this.checkUserName = checkUserName;
    }
}
