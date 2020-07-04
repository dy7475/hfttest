package com.myfun.repository.admindb.dto;

import com.myfun.repository.admindb.po.AdminFunDepts;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月22日 上午9:43:35 
 * 合同列表查询实体
*/
@ApiModel
public class AdminCrmFunContrackDto extends AdminFunDepts{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "城市名称")
	private String cityName;
	
	@ApiModelProperty(value = "真实微信")
	private String realWeixin;
	
	@ApiModelProperty(value = "安全路径")
	private String safetyPath;
	
	@ApiModelProperty(value = "合同编号")
	private String contractNo;
	
	@ApiModelProperty(value = "合同路径")
	private String contractPath;
	
	@ApiModelProperty(value = "合同版本")
	private String contractVersion;
	
	@ApiModelProperty(value = "升级协议")
	private String upgradeProtocol;
	
	@ApiModelProperty(value = "合同页面")
	private String contractHtml;
	
	@ApiModelProperty(value = "签署状态")
	private String signStatus;
	
	@ApiModelProperty(value = "1=已审核(已同意协议)，0=未审核(default  签订审核）代理商审核（未同意协议）")
	private String signExam;
	
	@ApiModelProperty(value = "签署时间")
	private String signDate;
	
	@ApiModelProperty(value = "甲方经办人，销售NAME")
	private String partyBAgent;
	
	@ApiModelProperty(value = "2=已赠送，1=已申请，0=未赠送(default) -1=未通过 赠送标记")
	private String payGifted;
	
	@ApiModelProperty(value = "1=团购赠送，0=等额赠送 赠送类型")
	private String giftType;
	
	@ApiModelProperty(value = "申请时间")
	private String reqTime;
	
	@ApiModelProperty(value = "申请人")
	private String reqUid;
	
	@ApiModelProperty(value = "审核时间")
	private String giftTime;
	
	@ApiModelProperty(value = "赠送扣费金额")
	private String giftPrice;
	
	@ApiModelProperty(value = "微信合同页面")
	private String weiContractHtml;
	
	@ApiModelProperty(value = "微信合同路径")
	private String weiContractPath;
	
	@ApiModelProperty(value = "合同状态")
	private String contractStatus;

	@ApiModelProperty(value = "1:图片 2:制式模板页面 3:静态HTML页面")
	private Integer fileType;
	
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	public String getRealWeixin() {
		return realWeixin;
	}
	public void setRealWeixin(String realWeixin) {
		this.realWeixin = realWeixin;
	}
	public String getSafetyPath() {
		return safetyPath;
	}
	public void setSafetyPath(String safetyPath) {
		this.safetyPath = safetyPath;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getContractPath() {
		return contractPath;
	}
	public void setContractPath(String contractPath) {
		this.contractPath = contractPath;
	}
	public String getContractVersion() {
		return contractVersion;
	}
	public void setContractVersion(String contractVersion) {
		this.contractVersion = contractVersion;
	}
	public String getUpgradeProtocol() {
		return upgradeProtocol;
	}
	public void setUpgradeProtocol(String upgradeProtocol) {
		this.upgradeProtocol = upgradeProtocol;
	}
	public String getContractHtml() {
		return contractHtml;
	}
	public void setContractHtml(String contractHtml) {
		this.contractHtml = contractHtml;
	}
	public String getSignStatus() {
		return signStatus;
	}
	public void setSignStatus(String signStatus) {
		this.signStatus = signStatus;
	}
	public String getSignExam() {
		return signExam;
	}
	public void setSignExam(String signExam) {
		this.signExam = signExam;
	}
	public String getSignDate() {
		return signDate;
	}
	public void setSignDate(String signDate) {
		this.signDate = signDate;
	}
	public String getPartyBAgent() {
		return partyBAgent;
	}
	public void setPartyBAgent(String partyBAgent) {
		this.partyBAgent = partyBAgent;
	}
	public String getPayGifted() {
		return payGifted;
	}
	public void setPayGifted(String payGifted) {
		this.payGifted = payGifted;
	}
	public String getGiftType() {
		return giftType;
	}
	public void setGiftType(String giftType) {
		this.giftType = giftType;
	}
	public String getReqTime() {
		return reqTime;
	}
	public void setReqTime(String reqTime) {
		this.reqTime = reqTime;
	}
	public String getReqUid() {
		return reqUid;
	}
	public void setReqUid(String reqUid) {
		this.reqUid = reqUid;
	}
	public String getGiftTime() {
		return giftTime;
	}
	public void setGiftTime(String giftTime) {
		this.giftTime = giftTime;
	}
	public String getGiftPrice() {
		return giftPrice;
	}
	public void setGiftPrice(String giftPrice) {
		this.giftPrice = giftPrice;
	}
	public String getWeiContractHtml() {
		return weiContractHtml;
	}
	public void setWeiContractHtml(String weiContractHtml) {
		this.weiContractHtml = weiContractHtml;
	}
	public String getWeiContractPath() {
		return weiContractPath;
	}
	public void setWeiContractPath(String weiContractPath) {
		this.weiContractPath = weiContractPath;
	}
	public String getContractStatus() {
		return contractStatus;
	}
	public void setContractStatus(String contractStatus) {
		this.contractStatus = contractStatus;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Integer getFileType() {
		return fileType;
	}

	public void setFileType(Integer fileType) {
		this.fileType = fileType;
	}
}
