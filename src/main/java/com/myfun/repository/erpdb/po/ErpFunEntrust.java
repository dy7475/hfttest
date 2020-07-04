package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class ErpFunEntrust extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "主键ID，自增")
	private Integer entrustId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源ID")
	private Integer caseId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "房源类型（1=出售；2=出租）")
	private Byte caseType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "公司ID")
	private Integer compId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托业务（1=出售委托；2出租委托; 3=出租出售委托）")
	private Byte entrustBusiness;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权地址")
	private String houseAddr;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托类型（1=普通；2=独家）")
	private Byte entrustType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否电子委托（0=否；1=是）")
	private Byte electronicEntrust;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "产权状态（1=完整产权；2=有抵押）")
	private Byte houseStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托编号")
	private String entrustNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托起始期限")
	private String entrustStart;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托截止期限")
	private String entrustEnd;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "电子委托书类型（1=标准；2=简易）")
	private Byte electronicEntrustType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "代业主保管文件（多选，英文逗号隔开）：房地产复印件，产权人身份资料复印件，房地产买卖合同复印件，购买发票复印件，付清房款证明复印件，产权人委托书")
	private String depositFileForCustom;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）")
	private Byte inspectionType;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出售佣金")
	private BigDecimal saleCommission;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租佣金")
	private BigDecimal leaseCommission;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有租约 0=否 1=是")
	private Byte hasLeaseContract;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "租期到期")
	private Date leaseEndTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "原租约租金")
	private BigDecimal oldRentMoney;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否有效（1=有效；0=无效）")
	private Byte isEffective;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "是否签约（1=签约完毕；0=待签约）")
	private Byte signStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核状态（0=待审核 1=审核拒绝 2=审核完成）")
	private Byte auditStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "失效时间")
	private Date incalidDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "签约完成时间")
	private Date signFinashDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核时间")
	private Date auditDate;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "审核人")
	private Integer auditUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "失效原因")
	private Byte incalidReason;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案人")
	private Integer recordUser;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案人门店")
	private String recordOrganizationName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案日期")
	private Date recordTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案号")
	private String recordNo;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案修改时间")
	private Date recordUpdateTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "备案状态（1=正常（未备案） 2=已备案 0=清空备案）")
	private Byte recordStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请人门店")
	private String approveOrganizationName;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请人")
	private Integer approveUserId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "申请时间")
	private Date createTime;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "代业主保管文件(其他)")
	private String depositFileForCustomOther;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格")
	private Byte entrustStatus;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出售价格")
	private BigDecimal salePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "出租价格")
	private BigDecimal leasePrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "委托是否共享，0=否 1=是（创建时是租售房源且委托共享参数开启） 默认0")
	private Byte isShare;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String contractId;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String recordUserDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String approveDept;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte hasAccountOccupancy;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte hasDegreeOccupation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal propertySituation;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String propertySituationOther;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte numberOfKeys;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String certificateOfProduction;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String landNature;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal entrustedAmount;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal entrustArea;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private String entrustNote;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private Byte priceUnit;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal saleEntrustPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal leaseEntrustPrice;
	/**
	 * @mbggenerated
	 */
	@ApiModelProperty(value = "null")
	private BigDecimal customRentAmount;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 主键ID，自增
	 */
	public Integer getEntrustId() {
		return entrustId;
	}

	/**
	 * @mbggenerated 主键ID，自增
	 */
	public void setEntrustId(Integer entrustId) {
		this.entrustId = entrustId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房源ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房源类型（1=出售；2=出租）
	 */
	public Byte getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房源类型（1=出售；2=出租）
	 */
	public void setCaseType(Byte caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 公司ID
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public Integer getCityId() {
		return cityId;
	}

	/**
	 * @mbggenerated 城市ID
	 */
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	/**
	 * @mbggenerated 委托业务（1=出售委托；2出租委托; 3=出租出售委托）
	 */
	public Byte getEntrustBusiness() {
		return entrustBusiness;
	}

	/**
	 * @mbggenerated 委托业务（1=出售委托；2出租委托; 3=出租出售委托）
	 */
	public void setEntrustBusiness(Byte entrustBusiness) {
		this.entrustBusiness = entrustBusiness;
	}

	/**
	 * @mbggenerated 产权地址
	 */
	public String getHouseAddr() {
		return houseAddr;
	}

	/**
	 * @mbggenerated 产权地址
	 */
	public void setHouseAddr(String houseAddr) {
		this.houseAddr = houseAddr;
	}

	/**
	 * @mbggenerated 委托类型（1=普通；2=独家）
	 */
	public Byte getEntrustType() {
		return entrustType;
	}

	/**
	 * @mbggenerated 委托类型（1=普通；2=独家）
	 */
	public void setEntrustType(Byte entrustType) {
		this.entrustType = entrustType;
	}

	/**
	 * @mbggenerated 是否电子委托（0=否；1=是）
	 */
	public Byte getElectronicEntrust() {
		return electronicEntrust;
	}

	/**
	 * @mbggenerated 是否电子委托（0=否；1=是）
	 */
	public void setElectronicEntrust(Byte electronicEntrust) {
		this.electronicEntrust = electronicEntrust;
	}

	/**
	 * @mbggenerated 产权状态（1=完整产权；2=有抵押）
	 */
	public Byte getHouseStatus() {
		return houseStatus;
	}

	/**
	 * @mbggenerated 产权状态（1=完整产权；2=有抵押）
	 */
	public void setHouseStatus(Byte houseStatus) {
		this.houseStatus = houseStatus;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public String getEntrustNo() {
		return entrustNo;
	}

	/**
	 * @mbggenerated 委托编号
	 */
	public void setEntrustNo(String entrustNo) {
		this.entrustNo = entrustNo;
	}

	/**
	 * @mbggenerated 委托起始期限
	 */
	public String getEntrustStart() {
		return entrustStart;
	}

	/**
	 * @mbggenerated 委托起始期限
	 */
	public void setEntrustStart(String entrustStart) {
		this.entrustStart = entrustStart;
	}

	/**
	 * @mbggenerated 委托截止期限
	 */
	public String getEntrustEnd() {
		return entrustEnd;
	}

	/**
	 * @mbggenerated 委托截止期限
	 */
	public void setEntrustEnd(String entrustEnd) {
		this.entrustEnd = entrustEnd;
	}

	/**
	 * @mbggenerated 电子委托书类型（1=标准；2=简易）
	 */
	public Byte getElectronicEntrustType() {
		return electronicEntrustType;
	}

	/**
	 * @mbggenerated 电子委托书类型（1=标准；2=简易）
	 */
	public void setElectronicEntrustType(Byte electronicEntrustType) {
		this.electronicEntrustType = electronicEntrustType;
	}

	/**
	 * @mbggenerated 代业主保管文件（多选，英文逗号隔开）：房地产复印件，产权人身份资料复印件，房地产买卖合同复印件，购买发票复印件，付清房款证明复印件，产权人委托书
	 */
	public String getDepositFileForCustom() {
		return depositFileForCustom;
	}

	/**
	 * @mbggenerated 代业主保管文件（多选，英文逗号隔开）：房地产复印件，产权人身份资料复印件，房地产买卖合同复印件，购买发票复印件，付清房款证明复印件，产权人委托书
	 */
	public void setDepositFileForCustom(String depositFileForCustom) {
		this.depositFileForCustom = depositFileForCustom;
	}

	/**
	 * @mbggenerated 看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）
	 */
	public Byte getInspectionType() {
		return inspectionType;
	}

	/**
	 * @mbggenerated 看房方式（1=甲方将物业钥匙交予乙方作看房之用；2=双方另行约定时间看房）
	 */
	public void setInspectionType(Byte inspectionType) {
		this.inspectionType = inspectionType;
	}

	/**
	 * @mbggenerated 出售佣金
	 */
	public BigDecimal getSaleCommission() {
		return saleCommission;
	}

	/**
	 * @mbggenerated 出售佣金
	 */
	public void setSaleCommission(BigDecimal saleCommission) {
		this.saleCommission = saleCommission;
	}

	/**
	 * @mbggenerated 出租佣金
	 */
	public BigDecimal getLeaseCommission() {
		return leaseCommission;
	}

	/**
	 * @mbggenerated 出租佣金
	 */
	public void setLeaseCommission(BigDecimal leaseCommission) {
		this.leaseCommission = leaseCommission;
	}

	/**
	 * @mbggenerated 是否有租约 0=否 1=是
	 */
	public Byte getHasLeaseContract() {
		return hasLeaseContract;
	}

	/**
	 * @mbggenerated 是否有租约 0=否 1=是
	 */
	public void setHasLeaseContract(Byte hasLeaseContract) {
		this.hasLeaseContract = hasLeaseContract;
	}

	/**
	 * @mbggenerated 租期到期
	 */
	public Date getLeaseEndTime() {
		return leaseEndTime;
	}

	/**
	 * @mbggenerated 租期到期
	 */
	public void setLeaseEndTime(Date leaseEndTime) {
		this.leaseEndTime = leaseEndTime;
	}

	/**
	 * @mbggenerated 原租约租金
	 */
	public BigDecimal getOldRentMoney() {
		return oldRentMoney;
	}

	/**
	 * @mbggenerated 原租约租金
	 */
	public void setOldRentMoney(BigDecimal oldRentMoney) {
		this.oldRentMoney = oldRentMoney;
	}

	/**
	 * @mbggenerated 是否有效（1=有效；0=无效）
	 */
	public Byte getIsEffective() {
		return isEffective;
	}

	/**
	 * @mbggenerated 是否有效（1=有效；0=无效）
	 */
	public void setIsEffective(Byte isEffective) {
		this.isEffective = isEffective;
	}

	/**
	 * @mbggenerated 是否签约（1=签约完毕；0=待签约）
	 */
	public Byte getSignStatus() {
		return signStatus;
	}

	/**
	 * @mbggenerated 是否签约（1=签约完毕；0=待签约）
	 */
	public void setSignStatus(Byte signStatus) {
		this.signStatus = signStatus;
	}

	/**
	 * @mbggenerated 审核状态（0=待审核 1=审核拒绝 2=审核完成）
	 */
	public Byte getAuditStatus() {
		return auditStatus;
	}

	/**
	 * @mbggenerated 审核状态（0=待审核 1=审核拒绝 2=审核完成）
	 */
	public void setAuditStatus(Byte auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * @mbggenerated 失效时间
	 */
	public Date getIncalidDate() {
		return incalidDate;
	}

	/**
	 * @mbggenerated 失效时间
	 */
	public void setIncalidDate(Date incalidDate) {
		this.incalidDate = incalidDate;
	}

	/**
	 * @mbggenerated 签约完成时间
	 */
	public Date getSignFinashDate() {
		return signFinashDate;
	}

	/**
	 * @mbggenerated 签约完成时间
	 */
	public void setSignFinashDate(Date signFinashDate) {
		this.signFinashDate = signFinashDate;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public Date getAuditDate() {
		return auditDate;
	}

	/**
	 * @mbggenerated 审核时间
	 */
	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public Integer getAuditUserId() {
		return auditUserId;
	}

	/**
	 * @mbggenerated 审核人
	 */
	public void setAuditUserId(Integer auditUserId) {
		this.auditUserId = auditUserId;
	}

	/**
	 * @mbggenerated 失效原因
	 */
	public Byte getIncalidReason() {
		return incalidReason;
	}

	/**
	 * @mbggenerated 失效原因
	 */
	public void setIncalidReason(Byte incalidReason) {
		this.incalidReason = incalidReason;
	}

	/**
	 * @mbggenerated 备案人
	 */
	public Integer getRecordUser() {
		return recordUser;
	}

	/**
	 * @mbggenerated 备案人
	 */
	public void setRecordUser(Integer recordUser) {
		this.recordUser = recordUser;
	}

	/**
	 * @mbggenerated 备案人门店
	 */
	public String getRecordOrganizationName() {
		return recordOrganizationName;
	}

	/**
	 * @mbggenerated 备案人门店
	 */
	public void setRecordOrganizationName(String recordOrganizationName) {
		this.recordOrganizationName = recordOrganizationName;
	}

	/**
	 * @mbggenerated 备案日期
	 */
	public Date getRecordTime() {
		return recordTime;
	}

	/**
	 * @mbggenerated 备案日期
	 */
	public void setRecordTime(Date recordTime) {
		this.recordTime = recordTime;
	}

	/**
	 * @mbggenerated 备案号
	 */
	public String getRecordNo() {
		return recordNo;
	}

	/**
	 * @mbggenerated 备案号
	 */
	public void setRecordNo(String recordNo) {
		this.recordNo = recordNo;
	}

	/**
	 * @mbggenerated 备案修改时间
	 */
	public Date getRecordUpdateTime() {
		return recordUpdateTime;
	}

	/**
	 * @mbggenerated 备案修改时间
	 */
	public void setRecordUpdateTime(Date recordUpdateTime) {
		this.recordUpdateTime = recordUpdateTime;
	}

	/**
	 * @mbggenerated 备案状态（1=正常（未备案） 2=已备案 0=清空备案）
	 */
	public Byte getRecordStatus() {
		return recordStatus;
	}

	/**
	 * @mbggenerated 备案状态（1=正常（未备案） 2=已备案 0=清空备案）
	 */
	public void setRecordStatus(Byte recordStatus) {
		this.recordStatus = recordStatus;
	}

	/**
	 * @mbggenerated 申请人门店
	 */
	public String getApproveOrganizationName() {
		return approveOrganizationName;
	}

	/**
	 * @mbggenerated 申请人门店
	 */
	public void setApproveOrganizationName(String approveOrganizationName) {
		this.approveOrganizationName = approveOrganizationName;
	}

	/**
	 * @mbggenerated 申请人
	 */
	public Integer getApproveUserId() {
		return approveUserId;
	}

	/**
	 * @mbggenerated 申请人
	 */
	public void setApproveUserId(Integer approveUserId) {
		this.approveUserId = approveUserId;
	}

	/**
	 * @mbggenerated 申请时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 申请时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 代业主保管文件(其他)
	 */
	public String getDepositFileForCustomOther() {
		return depositFileForCustomOther;
	}

	/**
	 * @mbggenerated 代业主保管文件(其他)
	 */
	public void setDepositFileForCustomOther(String depositFileForCustomOther) {
		this.depositFileForCustomOther = depositFileForCustomOther;
	}

	/**
	 * @mbggenerated 委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格
	 */
	public Byte getEntrustStatus() {
		return entrustStatus;
	}

	/**
	 * @mbggenerated 委托状态：1=正常 2=已过期 3=已撤销 4=已删除 5=已驳回 6=转暂缓 7=内成交 8=外成交 9=转删除 10=未签署 11=待签署 12=清空备案 13=修改价格
	 */
	public void setEntrustStatus(Byte entrustStatus) {
		this.entrustStatus = entrustStatus;
	}

	/**
	 * @mbggenerated 出售价格
	 */
	public BigDecimal getSalePrice() {
		return salePrice;
	}

	/**
	 * @mbggenerated 出售价格
	 */
	public void setSalePrice(BigDecimal salePrice) {
		this.salePrice = salePrice;
	}

	/**
	 * @mbggenerated 出租价格
	 */
	public BigDecimal getLeasePrice() {
		return leasePrice;
	}

	/**
	 * @mbggenerated 出租价格
	 */
	public void setLeasePrice(BigDecimal leasePrice) {
		this.leasePrice = leasePrice;
	}

	/**
	 * @mbggenerated 委托是否共享，0=否 1=是（创建时是租售房源且委托共享参数开启） 默认0
	 */
	public Byte getIsShare() {
		return isShare;
	}

	/**
	 * @mbggenerated 委托是否共享，0=否 1=是（创建时是租售房源且委托共享参数开启） 默认0
	 */
	public void setIsShare(Byte isShare) {
		this.isShare = isShare;
	}

	/**
	 * @mbggenerated -
	 */
	public String getContractId() {
		return contractId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setContractId(String contractId) {
		this.contractId = contractId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getRecordUserDept() {
		return recordUserDept;
	}

	/**
	 * @mbggenerated -
	 */
	public void setRecordUserDept(String recordUserDept) {
		this.recordUserDept = recordUserDept;
	}

	/**
	 * @mbggenerated -
	 */
	public String getApproveDept() {
		return approveDept;
	}

	/**
	 * @mbggenerated -
	 */
	public void setApproveDept(String approveDept) {
		this.approveDept = approveDept;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getHasAccountOccupancy() {
		return hasAccountOccupancy;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHasAccountOccupancy(Byte hasAccountOccupancy) {
		this.hasAccountOccupancy = hasAccountOccupancy;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getHasDegreeOccupation() {
		return hasDegreeOccupation;
	}

	/**
	 * @mbggenerated -
	 */
	public void setHasDegreeOccupation(Byte hasDegreeOccupation) {
		this.hasDegreeOccupation = hasDegreeOccupation;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getPropertySituation() {
		return propertySituation;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPropertySituation(BigDecimal propertySituation) {
		this.propertySituation = propertySituation;
	}

	/**
	 * @mbggenerated -
	 */
	public String getPropertySituationOther() {
		return propertySituationOther;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPropertySituationOther(String propertySituationOther) {
		this.propertySituationOther = propertySituationOther;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getNumberOfKeys() {
		return numberOfKeys;
	}

	/**
	 * @mbggenerated -
	 */
	public void setNumberOfKeys(Byte numberOfKeys) {
		this.numberOfKeys = numberOfKeys;
	}

	/**
	 * @mbggenerated -
	 */
	public String getCertificateOfProduction() {
		return certificateOfProduction;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCertificateOfProduction(String certificateOfProduction) {
		this.certificateOfProduction = certificateOfProduction;
	}

	/**
	 * @mbggenerated -
	 */
	public String getLandNature() {
		return landNature;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLandNature(String landNature) {
		this.landNature = landNature;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getEntrustedAmount() {
		return entrustedAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustedAmount(BigDecimal entrustedAmount) {
		this.entrustedAmount = entrustedAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getEntrustArea() {
		return entrustArea;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustArea(BigDecimal entrustArea) {
		this.entrustArea = entrustArea;
	}

	/**
	 * @mbggenerated -
	 */
	public String getEntrustNote() {
		return entrustNote;
	}

	/**
	 * @mbggenerated -
	 */
	public void setEntrustNote(String entrustNote) {
		this.entrustNote = entrustNote;
	}

	/**
	 * @mbggenerated -
	 */
	public Byte getPriceUnit() {
		return priceUnit;
	}

	/**
	 * @mbggenerated -
	 */
	public void setPriceUnit(Byte priceUnit) {
		this.priceUnit = priceUnit;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getSaleEntrustPrice() {
		return saleEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setSaleEntrustPrice(BigDecimal saleEntrustPrice) {
		this.saleEntrustPrice = saleEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getLeaseEntrustPrice() {
		return leaseEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public void setLeaseEntrustPrice(BigDecimal leaseEntrustPrice) {
		this.leaseEntrustPrice = leaseEntrustPrice;
	}

	/**
	 * @mbggenerated -
	 */
	public BigDecimal getCustomRentAmount() {
		return customRentAmount;
	}

	/**
	 * @mbggenerated -
	 */
	public void setCustomRentAmount(BigDecimal customRentAmount) {
		this.customRentAmount = customRentAmount;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEntrust() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunEntrust(Integer shardCityId, Integer entrustId) {
		super(shardCityId);
		this.entrustId = entrustId;
	}

	@Override
	public String toString() {
		return "ErpFunEntrust [entrustId=" + entrustId + ", caseId=" + caseId + ", caseType=" + caseType + ", compId="
				+ compId + ", cityId=" + cityId + ", entrustBusiness=" + entrustBusiness + ", houseAddr=" + houseAddr
				+ ", entrustType=" + entrustType + ", electronicEntrust=" + electronicEntrust + ", houseStatus="
				+ houseStatus + ", entrustNo=" + entrustNo + ", entrustStart=" + entrustStart + ", entrustEnd="
				+ entrustEnd + ", electronicEntrustType=" + electronicEntrustType + ", depositFileForCustom="
				+ depositFileForCustom + ", inspectionType=" + inspectionType + ", saleCommission=" + saleCommission
				+ ", leaseCommission=" + leaseCommission + ", hasLeaseContract=" + hasLeaseContract + ", leaseEndTime="
				+ leaseEndTime + ", oldRentMoney=" + oldRentMoney + ", isEffective=" + isEffective + ", signStatus="
				+ signStatus + ", auditStatus=" + auditStatus + ", incalidDate=" + incalidDate + ", signFinashDate="
				+ signFinashDate + ", auditDate=" + auditDate + ", auditUserId=" + auditUserId + ", incalidReason="
				+ incalidReason + ", recordUser=" + recordUser + ", recordOrganizationName=" + recordOrganizationName
				+ ", recordTime=" + recordTime + ", recordNo=" + recordNo + ", recordUpdateTime=" + recordUpdateTime
				+ ", recordStatus=" + recordStatus + ", approveOrganizationName=" + approveOrganizationName
				+ ", approveUserId=" + approveUserId + ", createTime=" + createTime + ", depositFileForCustomOther="
				+ depositFileForCustomOther + ", entrustStatus=" + entrustStatus + ", salePrice=" + salePrice
				+ ", leasePrice=" + leasePrice + ", isShare=" + isShare + ", contractId=" + contractId
				+ ", recordUserDept=" + recordUserDept + ", approveDept=" + approveDept + ", hasAccountOccupancy="
				+ hasAccountOccupancy + ", hasDegreeOccupation=" + hasDegreeOccupation + ", propertySituation="
				+ propertySituation + ", propertySituationOther=" + propertySituationOther + ", numberOfKeys="
				+ numberOfKeys + ", certificateOfProduction=" + certificateOfProduction + ", landNature=" + landNature
				+ ", entrustedAmount=" + entrustedAmount + ", entrustArea=" + entrustArea + ", entrustNote="
				+ entrustNote + ", priceUnit=" + priceUnit + ", saleEntrustPrice=" + saleEntrustPrice
				+ ", leaseEntrustPrice=" + leaseEntrustPrice + "]";
	}
	
	
}