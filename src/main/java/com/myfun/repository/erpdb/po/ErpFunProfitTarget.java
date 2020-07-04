package com.myfun.repository.erpdb.po;

import com.myfun.repository.support.generator.shard.ShardDb;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import io.swagger.annotations.ApiModelProperty;

public class ErpFunProfitTarget extends ShardDb implements Serializable {

	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="业绩ID") private Integer id;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="设置月份") private Date targetDate;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="设置目标") private BigDecimal targetProfit;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="大区") private Integer areaId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="片区") private Integer regId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="所属公司") private Integer compId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="门店") private Integer deptId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="经纪人") private Integer userId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="目标类型") private Byte profitType;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="暂无使用") private Integer templetId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="设置时间") private Date createTime;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="经纪人档案ID") private Integer archiveId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="分组ID") private Integer grId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org1;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org2;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org3;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org4;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org5;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org6;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org7;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org8;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org9;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org10;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org11;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org12;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org13;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer org14;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer defId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private Integer organizationId;
	/**
	 * @mbggenerated
	 */@ApiModelProperty(value="null") private String organizationPath;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated 业绩ID
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @mbggenerated 业绩ID
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @mbggenerated 设置月份
	 */
	public Date getTargetDate() {
		return targetDate;
	}

	/**
	 * @mbggenerated 设置月份
	 */
	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}

	/**
	 * @mbggenerated 设置目标
	 */
	public BigDecimal getTargetProfit() {
		return targetProfit;
	}

	/**
	 * @mbggenerated 设置目标
	 */
	public void setTargetProfit(BigDecimal targetProfit) {
		this.targetProfit = targetProfit;
	}

	/**
	 * @mbggenerated 大区
	 */
	public Integer getAreaId() {
		return areaId;
	}

	/**
	 * @mbggenerated 大区
	 */
	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	/**
	 * @mbggenerated 片区
	 */
	public Integer getRegId() {
		return regId;
	}

	/**
	 * @mbggenerated 片区
	 */
	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	/**
	 * @mbggenerated 所属公司
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated 所属公司
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated 门店
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated 门店
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated 经纪人
	 */
	public Integer getUserId() {
		return userId;
	}

	/**
	 * @mbggenerated 经纪人
	 */
	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	/**
	 * @mbggenerated 目标类型
	 */
	public Byte getProfitType() {
		return profitType;
	}

	/**
	 * @mbggenerated 目标类型
	 */
	public void setProfitType(Byte profitType) {
		this.profitType = profitType;
	}

	/**
	 * @mbggenerated 暂无使用
	 */
	public Integer getTempletId() {
		return templetId;
	}

	/**
	 * @mbggenerated 暂无使用
	 */
	public void setTempletId(Integer templetId) {
		this.templetId = templetId;
	}

	/**
	 * @mbggenerated 设置时间
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * @mbggenerated 设置时间
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * @mbggenerated 经纪人档案ID
	 */
	public Integer getArchiveId() {
		return archiveId;
	}

	/**
	 * @mbggenerated 经纪人档案ID
	 */
	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public Integer getGrId() {
		return grId;
	}

	/**
	 * @mbggenerated 分组ID
	 */
	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg1() {
		return org1;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg1(Integer org1) {
		this.org1 = org1;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg2() {
		return org2;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg2(Integer org2) {
		this.org2 = org2;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg3() {
		return org3;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg3(Integer org3) {
		this.org3 = org3;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg4() {
		return org4;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg4(Integer org4) {
		this.org4 = org4;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg5() {
		return org5;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg5(Integer org5) {
		this.org5 = org5;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg6() {
		return org6;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg6(Integer org6) {
		this.org6 = org6;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg7() {
		return org7;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg7(Integer org7) {
		this.org7 = org7;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg8() {
		return org8;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg8(Integer org8) {
		this.org8 = org8;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg9() {
		return org9;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg9(Integer org9) {
		this.org9 = org9;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg10() {
		return org10;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg10(Integer org10) {
		this.org10 = org10;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg11() {
		return org11;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg11(Integer org11) {
		this.org11 = org11;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg12() {
		return org12;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg12(Integer org12) {
		this.org12 = org12;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg13() {
		return org13;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg13(Integer org13) {
		this.org13 = org13;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrg14() {
		return org14;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrg14(Integer org14) {
		this.org14 = org14;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getDefId() {
		return defId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setDefId(Integer defId) {
		this.defId = defId;
	}

	/**
	 * @mbggenerated -
	 */
	public Integer getOrganizationId() {
		return organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}

	/**
	 * @mbggenerated -
	 */
	public String getOrganizationPath() {
		return organizationPath;
	}

	/**
	 * @mbggenerated -
	 */
	public void setOrganizationPath(String organizationPath) {
		this.organizationPath = organizationPath;
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProfitTarget() {
	}

	/**
	 * @mbggenerated
	 */
	public ErpFunProfitTarget(Integer shardCityId, Integer id) {
		super(shardCityId);
		this.id = id;
	}
}