package com.myfun.repository.erpdb.param;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddOrUpdateIssueInvoiceParam extends AbstractEncryParam implements DaoBaseParam{
	   /**
    *
    * @mbggenerated
   自增主键
    */
	@ApiModelProperty(value = "自增主键,发票id")
	private Integer invoiceId;

   /**
    *
    * @mbggenerated
   城市ID
    */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;

   /**
    *
    * @mbggenerated
   公司编号
    */
	@ApiModelProperty(value = "公司编号")
	private String compNo;

   /**
    *
    * @mbggenerated
   门店编号
    */
	@ApiModelProperty(value = "门店编号")
	private String deptNo;

	@ApiModelProperty(value = "消费记录ID,多个id以,分隔")
	private String paidId;


   /**
    *
    * @mbggenerated
   发票类型，0普票，1专票
    */
	@ApiModelProperty(value = "发票类型，0普票，1专票")
	private Byte invoiceType;

   /**
    *
    * @mbggenerated
   发票抬头
    */
	@ApiModelProperty(value = "发票抬头")
	private String invoiceHeader;

   /**
    *
    * @mbggenerated
   识别号
    */
	@ApiModelProperty(value = "识别号")
	private String identificationNumber;

   /**
    *
    * @mbggenerated
   企业名称
    */
	@ApiModelProperty(value = "企业名称")
	private String businessName;

   /**
    *
    * @mbggenerated
   开户行
    */
	@ApiModelProperty(value = "开户行")
	private String accountBank;

   /**
    *
    * @mbggenerated
   开户账号
    */
	@ApiModelProperty(value = "开户账号")
	private String accountName;

   /**
    *
    * @mbggenerated
   联系人
    */
	@ApiModelProperty(value = "联系人")
	private String accountContact;

   /**
    *
    * @mbggenerated
   收件人
    */
	@ApiModelProperty(value = "收件人")
	private String recipientUname;

   /**
    *
    * @mbggenerated
   收件人地址
    */
	@ApiModelProperty(value = "收件人地址")
	private String recipientAddr;

   /**
    *
    * @mbggenerated
   收件人电话
    */
	@ApiModelProperty(value = "收件人电话")
	private String recipientPhone;

   /**
    *
    * @mbggenerated
   快递信息
    */
	@ApiModelProperty(value = "快递信息")
	private String expressInfo;
   /**
    *
    * @mbggenerated
   公司地址
    */
	@ApiModelProperty(value = "公司地址")
	private String businessAddr;

   /**
    *
    * @mbggenerated
   公司电话
    */
	@ApiModelProperty(value = "公司电话")
	private String businessPhone;

   /**
    *
    * @mbggenerated
   发票内容
    */
	@ApiModelProperty(value = "发票内容")
	private String invoiceContent;

   /**
    *
    * @mbggenerated
   消费金额
    */
	@ApiModelProperty(value = "消费金额")
	private BigDecimal consumptionAmount;
   /**
    *
    * @mbggenerated
   发票编号
    */
	@ApiModelProperty(value = "发票编号")
	private String invoiceNo;
   
	@ApiModelProperty(value = "eslist字符串")
	private String esList;
   
	@ApiModelProperty(value = "月份标记")
	private String monthFlag;
	
	@ApiModelProperty(value = "经纪人档案id")
	private Integer archiveId;
	
	@ApiModelProperty(value = "用户id")
	private Integer userId;
	
	@ApiModelProperty(value = "用户姓名")
	private String userName ;
	
	@ApiModelProperty(value = "是否是总经理")
	private  boolean isGeneralManager;
	
	@ApiModelProperty(value = "资金账户id")
	private Integer uaid;
	
	@ApiModelProperty(value = "0 普通发票     1 电子发票")
	private Byte electronicInvoice;
	
	public Integer getUaid() {
		return uaid;
	}
	
	public void setUaid(Integer uaid) {
		this.uaid = uaid;
	}
	
	public boolean isGeneralManager() {
		return isGeneralManager;
	}
	
	public void setGeneralManager(boolean isGeneralManager) {
		this.isGeneralManager = isGeneralManager;
	}
	
	public Integer getArchiveId() {
		return archiveId;
	}
	
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getMonthFlag() {
		return monthFlag;
   }

   public void setMonthFlag(String monthFlag) {
		this.monthFlag = monthFlag;
   }
	
	public String getEsList() {
		return esList;
   }
   
	public void setEsList(String esList) {
		this.esList = esList;
	}
	public Integer getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(Integer invoiceId) {
		this.invoiceId = invoiceId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public String getPaidId() {
		return paidId;
	}
	public void setPaidId(String paidId) {
		this.paidId = paidId;
	}
	public Byte getInvoiceType() {
		return invoiceType;
	}
	public void setInvoiceType(Byte invoiceType) {
		this.invoiceType = invoiceType;
	}
	public String getInvoiceHeader() {
		return invoiceHeader;
	}
	public void setInvoiceHeader(String invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}
	public String getIdentificationNumber() {
		return identificationNumber;
	}
	public void setIdentificationNumber(String identificationNumber) {
		this.identificationNumber = identificationNumber;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getAccountBank() {
		return accountBank;
	}
	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getAccountContact() {
		return accountContact;
	}
	public void setAccountContact(String accountContact) {
		this.accountContact = accountContact;
	}
	public String getRecipientUname() {
		return recipientUname;
	}
	public void setRecipientUname(String recipientUname) {
		this.recipientUname = recipientUname;
	}
	public String getRecipientAddr() {
		return recipientAddr;
	}
	public void setRecipientAddr(String recipientAddr) {
		this.recipientAddr = recipientAddr;
	}
	public String getRecipientPhone() {
		return recipientPhone;
	}
	public void setRecipientPhone(String recipientPhone) {
		this.recipientPhone = recipientPhone;
	}
	public String getExpressInfo() {
		return expressInfo;
	}
	public void setExpressInfo(String expressInfo) {
		this.expressInfo = expressInfo;
	}
	public String getBusinessAddr() {
		return businessAddr;
	}
	public void setBusinessAddr(String businessAddr) {
		this.businessAddr = businessAddr;
	}
	public String getBusinessPhone() {
		return businessPhone;
	}
	public void setBusinessPhone(String businessPhone) {
		this.businessPhone = businessPhone;
	}
	public String getInvoiceContent() {
		return invoiceContent;
	}
	public void setInvoiceContent(String invoiceContent) {
		this.invoiceContent = invoiceContent;
	}
	public BigDecimal getConsumptionAmount() {
		return consumptionAmount;
	}
	public void setConsumptionAmount(BigDecimal consumptionAmount) {
		this.consumptionAmount = consumptionAmount;
	}
	public String getInvoiceNo() {
		return invoiceNo;
	}
	public void setInvoiceNo(String invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Byte getElectronicInvoice() {
		return electronicInvoice;
	}

	public void setElectronicInvoice(Byte electronicInvoice) {
		this.electronicInvoice = electronicInvoice;
	}

}
