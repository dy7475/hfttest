package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class AdminOnlinePaymentReceiptFile implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer fileId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "记录写时间")
    private Date creationTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "关联到订单ID")
    private Integer orderId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "oss文件地址")
    private String filePath;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "是否下载完成 1=下载完成")
    private Byte downCompleted;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "下载时间")
    private Date downTime;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "下载失败次数")
    private Integer downFailTimes;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "业务ID")
    private Integer businessId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "业务类型")
    private Byte businessType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "新网文件码，方便排错")
    private String xwFileCode;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "订单编号")
    private String orderNo;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getFileId() {
        return fileId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    /**
     *
     * @mbggenerated
     * 记录写时间
     */
    public Date getCreationTime() {
        return creationTime;
    }

    /**
     *
     * @mbggenerated
     * 记录写时间
     */
    public void setCreationTime(Date creationTime) {
        this.creationTime = creationTime;
    }

    /**
     *
     * @mbggenerated
     * 关联到订单ID
     */
    public Integer getOrderId() {
        return orderId;
    }

    /**
     *
     * @mbggenerated
     * 关联到订单ID
     */
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    /**
     *
     * @mbggenerated
     * oss文件地址
     */
    public String getFilePath() {
        return filePath;
    }

    /**
     *
     * @mbggenerated
     * oss文件地址
     */
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     *
     * @mbggenerated
     * 是否下载完成 1=下载完成
     */
    public Byte getDownCompleted() {
        return downCompleted;
    }

    /**
     *
     * @mbggenerated
     * 是否下载完成 1=下载完成
     */
    public void setDownCompleted(Byte downCompleted) {
        this.downCompleted = downCompleted;
    }

    /**
     *
     * @mbggenerated
     * 下载时间
     */
    public Date getDownTime() {
        return downTime;
    }

    /**
     *
     * @mbggenerated
     * 下载时间
     */
    public void setDownTime(Date downTime) {
        this.downTime = downTime;
    }

    /**
     *
     * @mbggenerated
     * 下载失败次数
     */
    public Integer getDownFailTimes() {
        return downFailTimes;
    }

    /**
     *
     * @mbggenerated
     * 下载失败次数
     */
    public void setDownFailTimes(Integer downFailTimes) {
        this.downFailTimes = downFailTimes;
    }

    /**
     *
     * @mbggenerated
     * 业务ID
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     *
     * @mbggenerated
     * 业务ID
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     *
     * @mbggenerated
     * 业务类型
     */
    public Byte getBusinessType() {
        return businessType;
    }

    /**
     *
     * @mbggenerated
     * 业务类型
     */
    public void setBusinessType(Byte businessType) {
        this.businessType = businessType;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 新网文件码，方便排错
     */
    public String getXwFileCode() {
        return xwFileCode;
    }

    /**
     *
     * @mbggenerated
     * 新网文件码，方便排错
     */
    public void setXwFileCode(String xwFileCode) {
        this.xwFileCode = xwFileCode;
    }

    /**
     *
     * @mbggenerated
     * 订单编号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     *
     * @mbggenerated
     * 订单编号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}