package com.myfun.repository.admindb.po;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class AdminBankFourElement implements Serializable {
    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "主键")
    private Integer id;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "姓名")
    private String userName;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "身份证")
    private String idCard;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "银行卡")
    private String bankCardNumber;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "电话")
    private String userMobile;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "认证状态 1：通过 ")
    private Byte validationStatus;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "合同或合作id")
    private Integer cooperateDealId;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "银行全称")
    private String bankNameAll;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "银行简称")
    private String bankNameSimple;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "银行编码")
    private String bankNo;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "认证方 1业主 2客户")
    private Byte certificationParty;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "成交类型 1合同 2合作")
    private Byte dealType;

    /**
     *
     * @mbggenerated
     */
    @ApiModelProperty(value= "null")
    private Integer archiveId;

    /**
     *
     * @mbggenerated
     */
    private static final long serialVersionUID = 1L;

    /**
     *
     * @mbggenerated
     * 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     *
     * @mbggenerated
     * 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     *
     * @mbggenerated
     * 姓名
     */
    public String getUserName() {
        return userName;
    }

    /**
     *
     * @mbggenerated
     * 姓名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @mbggenerated
     * 身份证
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     *
     * @mbggenerated
     * 身份证
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     *
     * @mbggenerated
     * 银行卡
     */
    public String getBankCardNumber() {
        return bankCardNumber;
    }

    /**
     *
     * @mbggenerated
     * 银行卡
     */
    public void setBankCardNumber(String bankCardNumber) {
        this.bankCardNumber = bankCardNumber;
    }

    /**
     *
     * @mbggenerated
     * 电话
     */
    public String getUserMobile() {
        return userMobile;
    }

    /**
     *
     * @mbggenerated
     * 电话
     */
    public void setUserMobile(String userMobile) {
        this.userMobile = userMobile;
    }

    /**
     *
     * @mbggenerated
     * 认证状态 1：通过 
     */
    public Byte getValidationStatus() {
        return validationStatus;
    }

    /**
     *
     * @mbggenerated
     * 认证状态 1：通过 
     */
    public void setValidationStatus(Byte validationStatus) {
        this.validationStatus = validationStatus;
    }

    /**
     *
     * @mbggenerated
     * 合同或合作id
     */
    public Integer getCooperateDealId() {
        return cooperateDealId;
    }

    /**
     *
     * @mbggenerated
     * 合同或合作id
     */
    public void setCooperateDealId(Integer cooperateDealId) {
        this.cooperateDealId = cooperateDealId;
    }

    /**
     *
     * @mbggenerated
     * 银行全称
     */
    public String getBankNameAll() {
        return bankNameAll;
    }

    /**
     *
     * @mbggenerated
     * 银行全称
     */
    public void setBankNameAll(String bankNameAll) {
        this.bankNameAll = bankNameAll;
    }

    /**
     *
     * @mbggenerated
     * 银行简称
     */
    public String getBankNameSimple() {
        return bankNameSimple;
    }

    /**
     *
     * @mbggenerated
     * 银行简称
     */
    public void setBankNameSimple(String bankNameSimple) {
        this.bankNameSimple = bankNameSimple;
    }

    /**
     *
     * @mbggenerated
     * 银行编码
     */
    public String getBankNo() {
        return bankNo;
    }

    /**
     *
     * @mbggenerated
     * 银行编码
     */
    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    /**
     *
     * @mbggenerated
     * 认证方 1业主 2客户
     */
    public Byte getCertificationParty() {
        return certificationParty;
    }

    /**
     *
     * @mbggenerated
     * 认证方 1业主 2客户
     */
    public void setCertificationParty(Byte certificationParty) {
        this.certificationParty = certificationParty;
    }

    /**
     *
     * @mbggenerated
     * 成交类型 1合同 2合作
     */
    public Byte getDealType() {
        return dealType;
    }

    /**
     *
     * @mbggenerated
     * 成交类型 1合同 2合作
     */
    public void setDealType(Byte dealType) {
        this.dealType = dealType;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public Integer getArchiveId() {
        return archiveId;
    }

    /**
     *
     * @mbggenerated
     * -
     */
    public void setArchiveId(Integer archiveId) {
        this.archiveId = archiveId;
    }
}