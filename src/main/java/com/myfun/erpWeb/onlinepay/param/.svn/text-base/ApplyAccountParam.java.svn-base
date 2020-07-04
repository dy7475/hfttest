package com.myfun.erpWeb.onlinepay.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ApplyAccountParam implements EncryParamIfc {

    @ApiModelProperty(value = "账户类型 1=个人账户 2=企业账户  目前需求上是开企业账户", required = true)
    private Byte accountType;
    @ApiModelProperty(value = "主体名，企业账户=执照上的名称 个人账户等于身份证姓名", required = true)
    private String customerFullName;
    @ApiModelProperty(value = "个人账户参数； 身份证号， accountType=1时必传", required = false)
    private String individualIdCardNo;
    @ApiModelProperty(value = "个人账户参数； 银行卡号， accountType=1时必传", required = false)
    private String individualBankCardNo;
    @ApiModelProperty(value = "个人账户参数； 开户预留手机号， accountType=1时必传", required = false)
    private String individualReservedPhoneNo;
    @ApiModelProperty(value = "企业账户参数； 法人身份证姓名， accountType=2时必传", required = false)
    private String enterpriseLegalName;
    @ApiModelProperty(value = "企业账户参数； 企业法人证件类型 B01=身份证，目前是身份证， accountType=2时必传", required = false)
    private String enterpriseLegalIdCardType;
    @ApiModelProperty(value = "企业账户参数； 企业法人证件号， accountType=2时必传", required = false)
    private String enterpriseLegalIdCardNo;
    @ApiModelProperty(value = "企业账户参数； 企业联系人电话， accountType=2时必传", required = false)
    private String enterpriseContactPhone;
    @ApiModelProperty(value = "企业账户参数； 对公账户， accountType=2时必传", required = false)
    private String enterpriseBankCardNo;
    @ApiModelProperty(value = "企业账户参数； 企业统一社会信用代码， accountType=2时必传", required = false)
    private String enterpriseUnifiedCode;
    @ApiModelProperty(value = "企业账户参数； 企业机构信用代码， accountType=2时必传", required = false)
    private String enterpriseCreditCode;
    @ApiModelProperty(value = "企业账户参数； 身份证文件上传后的路径-正面， accountType=2时必传", required = false)
    private String enterpriseLegalFileUrl1;
    @ApiModelProperty(value = "企业账户参数； 身份证文件上传后的路径-反面， accountType=2时必传", required = false)
    private String enterpriseLegalFileUrl2;
    @ApiModelProperty(value = "企业账户参数； 身份证文件上传后的路径， accountType=2时必传", required = false)
    private String enterpriseUnifiedFileUrl;
    @ApiModelProperty(value = "企业账户参数； 联系人姓名， accountType=2时必传", required = false)
    private String enterpriseContactName;
    @ApiModelProperty(value = "企业账户参数； 开户行全名， accountType=2时必传", required = false)
    private String enterpriseBankName;
    @ApiModelProperty(value = "企业账户参数； 开户行行号， accountType=2时必传", required = false)
    private String enterpriseBankCode;
    @ApiModelProperty(value = "唯一标识 对应好房通的体系ID，结合ACCOUNT_TYPE和CITY_ID 使用   1=archiveId  2=erp的compId", hidden = true)
    private Integer accountHftIdentification;
    @ApiModelProperty(value = "城市ID", hidden = true)
    private Integer cityId;
    @ApiModelProperty(value = "公司编号", hidden = true)
    private String compNo;

    public String getCompNo() {
        return compNo;
    }

    public void setCompNo(String compNo) {
        this.compNo = compNo;
    }

    public String getEnterpriseBankCode() {
        return enterpriseBankCode;
    }

    public void setEnterpriseBankCode(String enterpriseBankCode) {
        this.enterpriseBankCode = enterpriseBankCode;
    }

    public String getEnterpriseBankName() {
        return enterpriseBankName;
    }

    public void setEnterpriseBankName(String enterpriseBankName) {
        this.enterpriseBankName = enterpriseBankName;
    }

    public String getEnterpriseContactName() {
        return enterpriseContactName;
    }

    public void setEnterpriseContactName(String enterpriseContactName) {
        this.enterpriseContactName = enterpriseContactName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getAccountHftIdentification() {
        return accountHftIdentification;
    }

    public void setAccountHftIdentification(Integer accountHftIdentification) {
        this.accountHftIdentification = accountHftIdentification;
    }

    public Byte getAccountType() {
        return accountType;
    }

    public void setAccountType(Byte accountType) {
        this.accountType = accountType;
    }

    public String getCustomerFullName() {
        return customerFullName;
    }

    public void setCustomerFullName(String customerFullName) {
        this.customerFullName = customerFullName;
    }

    public String getIndividualIdCardNo() {
        return individualIdCardNo;
    }

    public void setIndividualIdCardNo(String individualIdCardNo) {
        this.individualIdCardNo = individualIdCardNo;
    }

    public String getIndividualBankCardNo() {
        return individualBankCardNo;
    }

    public void setIndividualBankCardNo(String individualBankCardNo) {
        this.individualBankCardNo = individualBankCardNo;
    }

    public String getIndividualReservedPhoneNo() {
        return individualReservedPhoneNo;
    }

    public void setIndividualReservedPhoneNo(String individualReservedPhoneNo) {
        this.individualReservedPhoneNo = individualReservedPhoneNo;
    }

    public String getEnterpriseLegalName() {
        return enterpriseLegalName;
    }

    public void setEnterpriseLegalName(String enterpriseLegalName) {
        this.enterpriseLegalName = enterpriseLegalName;
    }

    public String getEnterpriseLegalIdCardType() {
        return enterpriseLegalIdCardType;
    }

    public void setEnterpriseLegalIdCardType(String enterpriseLegalIdCardType) {
        this.enterpriseLegalIdCardType = enterpriseLegalIdCardType;
    }

    public String getEnterpriseLegalIdCardNo() {
        return enterpriseLegalIdCardNo;
    }

    public void setEnterpriseLegalIdCardNo(String enterpriseLegalIdCardNo) {
        this.enterpriseLegalIdCardNo = enterpriseLegalIdCardNo;
    }

    public String getEnterpriseContactPhone() {
        return enterpriseContactPhone;
    }

    public void setEnterpriseContactPhone(String enterpriseContactPhone) {
        this.enterpriseContactPhone = enterpriseContactPhone;
    }

    public String getEnterpriseBankCardNo() {
        return enterpriseBankCardNo;
    }

    public void setEnterpriseBankCardNo(String enterpriseBankCardNo) {
        this.enterpriseBankCardNo = enterpriseBankCardNo;
    }

    public String getEnterpriseUnifiedCode() {
        return enterpriseUnifiedCode;
    }

    public void setEnterpriseUnifiedCode(String enterpriseUnifiedCode) {
        this.enterpriseUnifiedCode = enterpriseUnifiedCode;
    }

    public String getEnterpriseCreditCode() {
        return enterpriseCreditCode;
    }

    public void setEnterpriseCreditCode(String enterpriseCreditCode) {
        this.enterpriseCreditCode = enterpriseCreditCode;
    }

    public String getEnterpriseLegalFileUrl1() {
        return enterpriseLegalFileUrl1;
    }

    public void setEnterpriseLegalFileUrl1(String enterpriseLegalFileUrl1) {
        this.enterpriseLegalFileUrl1 = enterpriseLegalFileUrl1;
    }

    public String getEnterpriseLegalFileUrl2() {
        return enterpriseLegalFileUrl2;
    }

    public void setEnterpriseLegalFileUrl2(String enterpriseLegalFileUrl2) {
        this.enterpriseLegalFileUrl2 = enterpriseLegalFileUrl2;
    }

    public String getEnterpriseUnifiedFileUrl() {
        return enterpriseUnifiedFileUrl;
    }

    public void setEnterpriseUnifiedFileUrl(String enterpriseUnifiedFileUrl) {
        this.enterpriseUnifiedFileUrl = enterpriseUnifiedFileUrl;
    }
}
