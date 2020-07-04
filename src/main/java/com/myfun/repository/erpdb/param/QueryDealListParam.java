package com.myfun.repository.erpdb.param;

import java.util.Set;

import com.myfun.framework.annotation.DefaultValue;
import com.myfun.repository.param.AbstractEncryParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 查询合同列表参数
 * @author Administrator
 *
 */
@ApiModel
public class QueryDealListParam extends AbstractEncryParam {
	@ApiModelProperty("公司id")
	private Integer compId;

	@ApiModelProperty("门店id")
	private Integer deptId;

	@ApiModelProperty("员工id")
	private Integer userId;

	@ApiModelProperty("片区id")
	private Integer regId;

	@ApiModelProperty("分组id")
	private Integer grId;

	@ApiModelProperty("大区id")
	private Integer areaId;

	@ApiModelProperty("档案id")
	private Integer arichveId;

	@ApiModelProperty("创建人:1  流程负责人:2 执行人：5 签约员工:3 签约主管:4 房源房：6 客源方:7 合同相关人: 8：分成人")
	private String flag;

	@ApiModelProperty("合同类型(101.出售 102.出租)")
	private String dealType;

	@ApiModelProperty("合同审核状态(0=未审核，1=初审，2=复审，3=作废 4=未作废)")
	private String dealAuditStatus;

	@ApiModelProperty("流程状态（全部:\"\" 未履行:0 履行中:1 已办结:2 未办结:3）")
	private String processStatus;

	@ApiModelProperty("财务状态主键id")
	private Integer financStatusId;

	@ApiModelProperty("支付方式主键id")
	private Integer payTypeId;

	@ApiModelProperty("用途，DD:HOUSE_USEAGE")
	private String houseUseage;

	@ApiModelProperty("楼盘id")
	private String buildId;

	@ApiModelProperty("楼盘名称")
	private String buildName;

	@ApiModelProperty("合同类别id")
	private String categoryId;

	@ApiModelProperty("银行名称")
	private String bankName;

	@ApiModelProperty("")
	private String shareId;

	@ApiModelProperty("公司编号")
	private String compNo;

	@ApiModelProperty("智能搜索(CONTRACT_NO=合同编号 BUY_OWNER_NAME=买方业主姓名 HOUSEADDRESS=合同成交时的房源地址描述 " +
			"SELL_OWNER_NAME=卖方业主姓名 SELL_ADDRESS=卖方物业地址 产权地址 DEAL_HOUSE_NO=房源编号 DEAL_CUSTOMER_NO=客源编号 " +
			"SELL_CALL_PHONE=卖方联系电话 BUY_CALL_PHONE=买方联系电话 BUY_ID_CARD=买方身份证号 SELL_ID_CARD=业主身份证号)")
	private String intelligentSearch;

	@ApiModelProperty("合同状态 全部:\"\" 未分配:\"0\" 待结算:\"1\" 未结算:\"6\" 已结算:\"2\"")
	private String dealStatus;

	@ApiModelProperty("时间类型")
	private String dateType;

	@ApiModelProperty("时间 本周:12 本月:13 上月:3 本季:14 半年:5 全部:0")
	private String date;

	@ApiModelProperty("时间范围")
	private String dateRange;

	@ApiModelProperty("排序字段")
	private String orderBy;

	@ApiModelProperty("贷款方式(商业贷 值:1 公积金 值:2 组合贷 值:3)")
	private String buyMortgageType;

	@ApiModelProperty("合同编号")
	private String contractNo;

	@ApiModelProperty("类型")
	private String caseType;

	@ApiModelProperty("出租付款方式(月付 值:1 季付 值:2 半年付 值:3 年付 值:4)")
	private String rentPayMethod;

	@ApiModelProperty("you+合同审核状态")
	private String youAduitStatus;

	@ApiModelProperty("当前登录人userId")
	private Integer currentUserId;

	@ApiModelProperty("财务状态名称")
	private String financName;

	@ApiModelProperty(value = "特殊处理优家新版合同的定制 1.一次性 2.贷款", hidden = true)
	private Integer youjiaPayTypeId;
	
	@ApiModelProperty(value = "是否是宽列表1=是")
	private Byte isWideList;

	
	@ApiModelProperty(value = "权限范围 0=本人 1=本人团队 2=下级所有  (房基地参数)")
    private Integer operLevel;
	
	@ApiModelProperty(value = "用户层级  " ,hidden=true)
	private Integer userLevel;
	@ApiModelProperty(hidden=true)
	private Set<Integer> archiveIds;
	
	@ApiModelProperty(hidden=true)
	@DefaultValue(value="false")
	private boolean newOrganization = false;
	
	@ApiModelProperty(value = "组织机构ID")
	private Integer organizationId;
	
	public Set<Integer> getArchiveIds() {
		return archiveIds;
	}

	public void setArchiveIds(Set<Integer> archiveIds) {
		this.archiveIds = archiveIds;
	}

	public Integer getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(Integer userLevel) {
		this.userLevel = userLevel;
	}

	public Integer getOperLevel() {
		return operLevel;
	}

	public void setOperLevel(Integer operLevel) {
		this.operLevel = operLevel;
	}

	public Integer getYoujiaPayTypeId() {
		return youjiaPayTypeId;
	}

	public void setYoujiaPayTypeId(Integer youjiaPayTypeId) {
		this.youjiaPayTypeId = youjiaPayTypeId;
	}

	public String getFinancName() {
		return financName;
	}
	public void setFinancName(String financName) {
		this.financName = financName;
	}
	public Integer getArichveId() {
		return arichveId;
	}
	public void setArichveId(Integer arichveId) {
		this.arichveId = arichveId;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
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
	public Integer getRegId() {
		return regId;
	}
	public void setRegId(Integer regId) {
		this.regId = regId;
	}
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public Integer getAreaId() {
		return areaId;
	}
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public String getDealType() {
		return dealType;
	}
	public void setDealType(String dealType) {
		this.dealType = dealType;
	}
	public String getDealAuditStatus() {
		return dealAuditStatus;
	}
	public void setDealAuditStatus(String dealAuditStatus) {
		this.dealAuditStatus = dealAuditStatus;
	}
	public String getProcessStatus() {
		return processStatus;
	}
	public void setProcessStatus(String processStatus) {
		this.processStatus = processStatus;
	}
	public Integer getFinancStatusId() {
		return financStatusId;
	}
	public void setFinancStatusId(Integer financStatusId) {
		this.financStatusId = financStatusId;
	}
	public Integer getPayTypeId() {
		return payTypeId;
	}
	public void setPayTypeId(Integer payTypeId) {
		this.payTypeId = payTypeId;
	}
	public String getHouseUseage() {
		return houseUseage;
	}
	public void setHouseUseage(String houseUseage) {
		this.houseUseage = houseUseage;
	}
	public String getBuildId() {
		return buildId;
	}
	public void setBuildId(String buildId) {
		this.buildId = buildId;
	}
	public String getBuildName() {
		return buildName;
	}
	public void setBuildName(String buildName) {
		this.buildName = buildName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getShareId() {
		return shareId;
	}
	public void setShareId(String shareId) {
		this.shareId = shareId;
	}
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getIntelligentSearch() {
		return intelligentSearch;
	}
	public void setIntelligentSearch(String intelligentSearch) {
		this.intelligentSearch = intelligentSearch;
	}
	public String getDealStatus() {
		return dealStatus;
	}
	public void setDealStatus(String dealStatus) {
		this.dealStatus = dealStatus;
	}
	public String getDateType() {
		return dateType;
	}
	public void setDateType(String dateType) {
		this.dateType = dateType;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDateRange() {
		return dateRange;
	}
	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}
	public String getOrderBy() {
		return orderBy;
	}
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	public String getBuyMortgageType() {
		return buyMortgageType;
	}
	public void setBuyMortgageType(String buyMortgageType) {
		this.buyMortgageType = buyMortgageType;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getRentPayMethod() {
		return rentPayMethod;
	}
	public void setRentPayMethod(String rentPayMethod) {
		this.rentPayMethod = rentPayMethod;
	}
	public String getYouAduitStatus() {
		return youAduitStatus;
	}
	public void setYouAduitStatus(String youAduitStatus) {
		this.youAduitStatus = youAduitStatus;
	}

	public Byte getIsWideList() {
		return isWideList;
	}

	public void setIsWideList(Byte isWideList) {
		this.isWideList = isWideList;
	}

	public Integer getOrganizationId() {
	
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
	
		this.organizationId = organizationId;
	}

	public boolean isNewOrganization() {
	
		return newOrganization;
	}

	public void setNewOrganization(boolean newOrganization) {
	
		this.newOrganization = newOrganization;
	}

	
}
