package com.myfun.repository.commdb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class CommContractSignSite implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键ID")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同所属城市ID")
    private Integer cityId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同ID")
    private Integer dealId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "签名A位置,格式x轴坐标,y轴坐标,页数x轴坐标,y轴坐标,页数x轴坐标,y轴坐标,页数签名A位置,格式x轴坐标,y轴坐标,页数")
    private String partyAInfo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "签名B位置,格式如上")
    private String partyBInfo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "盖章位置,格式如上")
    private String partyCInfo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "签名A时间位置,格式如上")
    private String partyADate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "签名B时间位置,格式如上")
    private String partyBDate;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "总页数")
    private Byte page;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同PDF路径")
    private String pdfPath;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同图片路径")
    private String imagePath;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同A4纸高度")
    private String a4Hight;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同内容高度")
    private String contentHight;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键ID
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键ID
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 合同所属城市ID
     */
    public Integer getCityId() {
        return cityId;
    }

    /**
     *
     * @mbggenerated
     * 合同所属城市ID
     */
    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     *
     * @mbggenerated
     * 合同ID
     */
    public Integer getDealId() {
        return dealId;
    }

    /**
     *
     * @mbggenerated
     * 合同ID
     */
    public void setDealId(Integer dealId) {
        this.dealId = dealId;
    }

    /**
     *
     * @mbggenerated
     * 签名A位置,格式x轴坐标,y轴坐标,页数
x轴坐标,y轴坐标,页数
x轴坐标,y轴坐标,页数
签名A位置,格式x轴坐标,y轴坐标,页数
     */
    public String getPartyAInfo() {
        return partyAInfo;
    }

    /**
     *
     * @mbggenerated
     * 签名A位置,格式x轴坐标,y轴坐标,页数
x轴坐标,y轴坐标,页数
x轴坐标,y轴坐标,页数
签名A位置,格式x轴坐标,y轴坐标,页数
     */
    public void setPartyAInfo(String partyAInfo) {
        this.partyAInfo = partyAInfo == null ? null : partyAInfo.trim();
    }

    /**
     *
     * @mbggenerated
     * 签名B位置,格式如上
     */
    public String getPartyBInfo() {
        return partyBInfo;
    }

    /**
     *
     * @mbggenerated
     * 签名B位置,格式如上
     */
    public void setPartyBInfo(String partyBInfo) {
        this.partyBInfo = partyBInfo == null ? null : partyBInfo.trim();
    }

    /**
     *
     * @mbggenerated
     * 盖章位置,格式如上
     */
    public String getPartyCInfo() {
        return partyCInfo;
    }

    /**
     *
     * @mbggenerated
     * 盖章位置,格式如上
     */
    public void setPartyCInfo(String partyCInfo) {
        this.partyCInfo = partyCInfo == null ? null : partyCInfo.trim();
    }

    /**
     *
     * @mbggenerated
     * 签名A时间位置,格式如上
     */
    public String getPartyADate() {
        return partyADate;
    }

    /**
     *
     * @mbggenerated
     * 签名A时间位置,格式如上
     */
    public void setPartyADate(String partyADate) {
        this.partyADate = partyADate == null ? null : partyADate.trim();
    }

    /**
     *
     * @mbggenerated
     * 签名B时间位置,格式如上
     */
    public String getPartyBDate() {
        return partyBDate;
    }

    /**
     *
     * @mbggenerated
     * 签名B时间位置,格式如上
     */
    public void setPartyBDate(String partyBDate) {
        this.partyBDate = partyBDate == null ? null : partyBDate.trim();
    }

    /**
     *
     * @mbggenerated
     * 总页数
     */
    public Byte getPage() {
        return page;
    }

    /**
     *
     * @mbggenerated
     * 总页数
     */
    public void setPage(Byte page) {
        this.page = page;
    }

    /**
     *
     * @mbggenerated
     * 合同PDF路径
     */
    public String getPdfPath() {
        return pdfPath;
    }

    /**
     *
     * @mbggenerated
     * 合同PDF路径
     */
    public void setPdfPath(String pdfPath) {
        this.pdfPath = pdfPath == null ? null : pdfPath.trim();
    }

    /**
     *
     * @mbggenerated
     * 合同图片路径
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     *
     * @mbggenerated
     * 合同图片路径
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath == null ? null : imagePath.trim();
    }

    /**
     *
     * @mbggenerated
     * 合同A4纸高度
     */
    public String getA4Hight() {
        return a4Hight;
    }

    /**
     *
     * @mbggenerated
     * 合同A4纸高度
     */
    public void setA4Hight(String a4Hight) {
        this.a4Hight = a4Hight == null ? null : a4Hight.trim();
    }

    /**
     *
     * @mbggenerated
     * 合同内容高度
     */
    public String getContentHight() {
        return contentHight;
    }

    /**
     *
     * @mbggenerated
     * 合同内容高度
     */
    public void setContentHight(String contentHight) {
        this.contentHight = contentHight == null ? null : contentHight.trim();
    }
}