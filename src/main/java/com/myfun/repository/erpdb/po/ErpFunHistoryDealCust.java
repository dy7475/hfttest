package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

public class ErpFunHistoryDealCust extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer funHistoryDealCustId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建人") private Integer createdUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="创建时间") private Date createdTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="更新人") private Integer updatedUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="更新时间") private Date updatedTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房客编号") private String caseNum;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房客ID") private Integer caseId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="房客类型1出租2出售3求租4求购") private Integer caseType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="客户姓名") private String custName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="联系电话") private String custTel;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交时间") private Date dealTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交类型1出租方2卖方3承租4买房") private Integer dealType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交人") private Integer dealUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交人名称") private String dealUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交组织ID") private Integer dealOrgId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交组织线") private String dealOrgPath;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交组织名称") private String dealOrgName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交物业") private String dealProperty;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="成交单号") private String dealNum;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="数据归属人ID") private Integer belongUserId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="数据归属人名称") private String belongUserName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="归属组织ID") private Integer belongOrgId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="归属组织线") private String belongOrgPath;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="归属组织名称") private String belongOrgName;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="楼盘id") private Integer buildId;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated -
	 */
	public Integer getFunHistoryDealCustId() {
		return funHistoryDealCustId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setFunHistoryDealCustId(Integer funHistoryDealCustId) {
		this.funHistoryDealCustId = funHistoryDealCustId;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public Integer getCreatedUserId() {
		return createdUserId;
	}

	/**
	 * @mbggenerated 创建人
	 */
	public void setCreatedUserId(Integer createdUserId) {
		this.createdUserId = createdUserId;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public Date getCreatedTime() {
		return createdTime;
	}

	/**
	 * @mbggenerated 创建时间
	 */
	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

	/**
	 * @mbggenerated 更新人
	 */
	public Integer getUpdatedUserId() {
		return updatedUserId;
	}

	/**
	 * @mbggenerated 更新人
	 */
	public void setUpdatedUserId(Integer updatedUserId) {
		this.updatedUserId = updatedUserId;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public Date getUpdatedTime() {
		return updatedTime;
	}

	/**
	 * @mbggenerated 更新时间
	 */
	public void setUpdatedTime(Date updatedTime) {
		this.updatedTime = updatedTime;
	}

	/**
	 * @mbggenerated 房客编号
	 */
	public String getCaseNum() {
		return caseNum;
	}

	/**
	 * @mbggenerated 房客编号
	 */
	public void setCaseNum(String caseNum) {
		this.caseNum = caseNum;
	}

	/**
	 * @mbggenerated 房客ID
	 */
	public Integer getCaseId() {
		return caseId;
	}

	/**
	 * @mbggenerated 房客ID
	 */
	public void setCaseId(Integer caseId) {
		this.caseId = caseId;
	}

	/**
	 * @mbggenerated 房客类型1出租2出售3求租4求购
	 */
	public Integer getCaseType() {
		return caseType;
	}

	/**
	 * @mbggenerated 房客类型1出租2出售3求租4求购
	 */
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}

	/**
	 * @mbggenerated 客户姓名
	 */
	public String getCustName() {
		return custName;
	}

	/**
	 * @mbggenerated 客户姓名
	 */
	public void setCustName(String custName) {
		this.custName = custName;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public String getCustTel() {
		return custTel;
	}

	/**
	 * @mbggenerated 联系电话
	 */
	public void setCustTel(String custTel) {
		this.custTel = custTel;
	}

	/**
	 * @mbggenerated 成交时间
	 */
	public Date getDealTime() {
		return dealTime;
	}

	/**
	 * @mbggenerated 成交时间
	 */
	public void setDealTime(Date dealTime) {
		this.dealTime = dealTime;
	}

	/**
	 * @mbggenerated 成交类型1出租方2卖方3承租4买房
	 */
	public Integer getDealType() {
		return dealType;
	}

	/**
	 * @mbggenerated 成交类型1出租方2卖方3承租4买房
	 */
	public void setDealType(Integer dealType) {
		this.dealType = dealType;
	}

	/**
	 * @mbggenerated 成交人
	 */
	public Integer getDealUserId() {
		return dealUserId;
	}

	/**
	 * @mbggenerated 成交人
	 */
	public void setDealUserId(Integer dealUserId) {
		this.dealUserId = dealUserId;
	}

	/**
	 * @mbggenerated 成交人名称
	 */
	public String getDealUserName() {
		return dealUserName;
	}

	/**
	 * @mbggenerated 成交人名称
	 */
	public void setDealUserName(String dealUserName) {
		this.dealUserName = dealUserName;
	}

	/**
	 * @mbggenerated 成交组织ID
	 */
	public Integer getDealOrgId() {
		return dealOrgId;
	}

	/**
	 * @mbggenerated 成交组织ID
	 */
	public void setDealOrgId(Integer dealOrgId) {
		this.dealOrgId = dealOrgId;
	}

	/**
	 * @mbggenerated 成交组织线
	 */
	public String getDealOrgPath() {
		return dealOrgPath;
	}

	/**
	 * @mbggenerated 成交组织线
	 */
	public void setDealOrgPath(String dealOrgPath) {
		this.dealOrgPath = dealOrgPath;
	}

	/**
	 * @mbggenerated 成交组织名称
	 */
	public String getDealOrgName() {
		return dealOrgName;
	}

	/**
	 * @mbggenerated 成交组织名称
	 */
	public void setDealOrgName(String dealOrgName) {
		this.dealOrgName = dealOrgName;
	}

	/**
	 * @mbggenerated 成交物业
	 */
	public String getDealProperty() {
		return dealProperty;
	}

	/**
	 * @mbggenerated 成交物业
	 */
	public void setDealProperty(String dealProperty) {
		this.dealProperty = dealProperty;
	}

	/**
	 * @mbggenerated 成交单号
	 */
	public String getDealNum() {
		return dealNum;
	}

	/**
	 * @mbggenerated 成交单号
	 */
	public void setDealNum(String dealNum) {
		this.dealNum = dealNum;
	}

	/**
	 * @mbggenerated 数据归属人ID
	 */
	public Integer getBelongUserId() {
		return belongUserId;
	}

	/**
	 * @mbggenerated 数据归属人ID
	 */
	public void setBelongUserId(Integer belongUserId) {
		this.belongUserId = belongUserId;
	}

	/**
	 * @mbggenerated 数据归属人名称
	 */
	public String getBelongUserName() {
		return belongUserName;
	}

	/**
	 * @mbggenerated 数据归属人名称
	 */
	public void setBelongUserName(String belongUserName) {
		this.belongUserName = belongUserName;
	}

	/**
	 * @mbggenerated 归属组织ID
	 */
	public Integer getBelongOrgId() {
		return belongOrgId;
	}

	/**
	 * @mbggenerated 归属组织ID
	 */
	public void setBelongOrgId(Integer belongOrgId) {
		this.belongOrgId = belongOrgId;
	}

	/**
	 * @mbggenerated 归属组织线
	 */
	public String getBelongOrgPath() {
		return belongOrgPath;
	}

	/**
	 * @mbggenerated 归属组织线
	 */
	public void setBelongOrgPath(String belongOrgPath) {
		this.belongOrgPath = belongOrgPath;
	}

	/**
	 * @mbggenerated 归属组织名称
	 */
	public String getBelongOrgName() {
		return belongOrgName;
	}

	/**
	 * @mbggenerated 归属组织名称
	 */
	public void setBelongOrgName(String belongOrgName) {
		this.belongOrgName = belongOrgName;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public Integer getBuildId() {
		return buildId;
	}

	/**
	 * @mbggenerated 楼盘id
	 */
	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHistoryDealCust() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunHistoryDealCust(Integer shardCityId, Integer funHistoryDealCustId) {
		super(shardCityId);
		this.funHistoryDealCustId = funHistoryDealCustId;
	}
}