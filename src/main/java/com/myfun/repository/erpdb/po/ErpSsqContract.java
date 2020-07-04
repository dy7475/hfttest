package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpSsqContract extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "上上签合同id")
	private String ssqContractId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "好房通合同id,FUN_DEAL")
	private Integer dealId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同状态 0=未完成 1=已完成 ")
	private Integer contractStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否已作废 0=否 1=是")
	private Byte isDel;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同页数")
	private Integer pages;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "初始化的合同pdf文件")
	private String initContractPdf;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "已完成签署的合同pdf文件")
	private String completeContractPdf;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "合同md5")
	private String fmd5;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "生成合同账号")
	private String account;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "甲方(卖方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}")
	private String partyAInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "乙方(买方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}")
	private String partyBInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "丙方(经纪公司)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页'}")
	private String partyCInfo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "甲方(卖方)是否完成了签字 1=是")
	private Byte partyAComplete;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "乙方(买方)是否完成了签字 1=是")
	private Byte partyBComplete;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "创建时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签约完成时间")
	private Date completeTime;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 上上签合同id
	 */
	public String getSsqContractId() {
		return ssqContractId;
	}

	/**
	 * @mbggenerated 上上签合同id
	 */
	public void setSsqContractId(String ssqContractId) {
		this.ssqContractId = ssqContractId;
	}

	/**
	 * @mbggenerated 好房通合同id,FUN_DEAL
	 */
	public Integer getDealId() {
		return dealId;
	}

	/**
	 * @mbggenerated 好房通合同id,FUN_DEAL
	 */
	public void setDealId(Integer dealId) {
		this.dealId = dealId;
	}

	/**
	 * @mbggenerated 合同状态 0=未完成 1=已完成 
	 */
	public Integer getContractStatus() {
		return contractStatus;
	}

	/**
	 * @mbggenerated 合同状态 0=未完成 1=已完成 
	 */
	public void setContractStatus(Integer contractStatus) {
		this.contractStatus = contractStatus;
	}

	/**
	 * @mbggenerated 是否已作废 0=否 1=是
	 */
	public Byte getIsDel() {
		return isDel;
	}

	/**
	 * @mbggenerated 是否已作废 0=否 1=是
	 */
	public void setIsDel(Byte isDel) {
		this.isDel = isDel;
	}

	/**
	 * @mbggenerated 合同页数
	 */
	public Integer getPages() {
		return pages;
	}

	/**
	 * @mbggenerated 合同页数
	 */
	public void setPages(Integer pages) {
		this.pages = pages;
	}

	/**
	 * @mbggenerated 初始化的合同pdf文件
	 */
	public String getInitContractPdf() {
		return initContractPdf;
	}

	/**
	 * @mbggenerated 初始化的合同pdf文件
	 */
	public void setInitContractPdf(String initContractPdf) {
		this.initContractPdf = initContractPdf;
	}

	/**
	 * @mbggenerated 已完成签署的合同pdf文件
	 */
	public String getCompleteContractPdf() {
		return completeContractPdf;
	}

	/**
	 * @mbggenerated 已完成签署的合同pdf文件
	 */
	public void setCompleteContractPdf(String completeContractPdf) {
		this.completeContractPdf = completeContractPdf;
	}

	/**
	 * @mbggenerated 合同md5
	 */
	public String getFmd5() {
		return fmd5;
	}

	/**
	 * @mbggenerated 合同md5
	 */
	public void setFmd5(String fmd5) {
		this.fmd5 = fmd5;
	}

	/**
	 * @mbggenerated 生成合同账号
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * @mbggenerated 生成合同账号
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * @mbggenerated 甲方(卖方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}
	 */
	public String getPartyAInfo() {
		return partyAInfo;
	}

	/**
	 * @mbggenerated 甲方(卖方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}
	 */
	public void setPartyAInfo(String partyAInfo) {
		this.partyAInfo = partyAInfo;
	}

	/**
	 * @mbggenerated 乙方(买方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}
	 */
	public String getPartyBInfo() {
		return partyBInfo;
	}

	/**
	 * @mbggenerated 乙方(买方)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页','dateX':'时间','dateY':'时间'}
	 */
	public void setPartyBInfo(String partyBInfo) {
		this.partyBInfo = partyBInfo;
	}

	/**
	 * @mbggenerated 丙方(经纪公司)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页'}
	 */
	public String getPartyCInfo() {
		return partyCInfo;
	}

	/**
	 * @mbggenerated 丙方(经纪公司)签约信息 json --{'signX':'x坐标','signY':'y坐标','pageNum':'第几页'}
	 */
	public void setPartyCInfo(String partyCInfo) {
		this.partyCInfo = partyCInfo;
	}

	/**
	 * @mbggenerated 甲方(卖方)是否完成了签字 1=是
	 */
	public Byte getPartyAComplete() {
		return partyAComplete;
	}

	/**
	 * @mbggenerated 甲方(卖方)是否完成了签字 1=是
	 */
	public void setPartyAComplete(Byte partyAComplete) {
		this.partyAComplete = partyAComplete;
	}

	/**
	 * @mbggenerated 乙方(买方)是否完成了签字 1=是
	 */
	public Byte getPartyBComplete() {
		return partyBComplete;
	}

	/**
	 * @mbggenerated 乙方(买方)是否完成了签字 1=是
	 */
	public void setPartyBComplete(Byte partyBComplete) {
		this.partyBComplete = partyBComplete;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 签约完成时间
	 */
	public Date getCompleteTime() {
		return completeTime;
	}

	/**
	 * @mbggenerated 签约完成时间
	 */
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}

	/**
	 * @mbggenerated
	 */
	public ErpSsqContract() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpSsqContract(Integer shardCityId, String ssqContractId) {
		super(shardCityId);
		this.ssqContractId = ssqContractId;
	}
}