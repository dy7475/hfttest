package com.myfun.repository.erpdb.po;

import java.io.Serializable;
import com.myfun.repository.support.generator.shard.ShardDb;

public class ErpFunWageType extends ShardDb implements Serializable {

	/**
	 * @mbggenerated 工资类别ID
	 */
	private Integer wagetypeId;
	/**
	 * @mbggenerated 公司ID
	 */
	private Integer compId;
	/**
	 * @mbggenerated 分店ID
	 */
	private Integer deptId;
	/**
	 * @mbggenerated 类型名字CN
	 */
	private String wageTypeCn;
	/**
	 * @mbggenerated 英文类型名
	 */
	private String wageTypeEn;
	/**
	 * @mbggenerated 序号判断出现位置
	 */
	private Byte seq;
	/**
	 * @mbggenerated 创建日期
	 */
	private String createDate;
	/**
	 * @mbggenerated 薪资的计算方式 1.阶梯计算 2.通提计算
	 */
	private Byte wageCountType;
	/**
	 * @mbggenerated 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
	 */
	private Byte performanceType;
	/**
	 * @mbggenerated 提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司
	 */
	private Byte royaltyRange;
	/**
	 * @mbggenerated 业绩范围，0=人均 1店均 2总业绩
	 */
	private Byte profitRange;
	/**
	 * @mbggenerated 保底比例，当前提成方式等于通提的时候，
	 */
	private Integer baseProportion;
	/**
	 * @mbggenerated 提成方案说明
	 */
	private String wageTypeDesc;
	/**
	 * @mbggenerated
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @mbggenerated
	 */
	public Integer getWagetypeId() {
		return wagetypeId;
	}

	/**
	 * @mbggenerated
	 */
	public void setWagetypeId(Integer wagetypeId) {
		this.wagetypeId = wagetypeId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getCompId() {
		return compId;
	}

	/**
	 * @mbggenerated
	 */
	public void setCompId(Integer compId) {
		this.compId = compId;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getDeptId() {
		return deptId;
	}

	/**
	 * @mbggenerated
	 */
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	/**
	 * @mbggenerated
	 */
	public String getWageTypeCn() {
		return wageTypeCn;
	}

	/**
	 * @mbggenerated
	 */
	public void setWageTypeCn(String wageTypeCn) {
		this.wageTypeCn = wageTypeCn == null ? null : wageTypeCn.trim();
	}

	/**
	 * @mbggenerated
	 */
	public String getWageTypeEn() {
		return wageTypeEn;
	}

	/**
	 * @mbggenerated
	 */
	public void setWageTypeEn(String wageTypeEn) {
		this.wageTypeEn = wageTypeEn == null ? null : wageTypeEn.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getSeq() {
		return seq;
	}

	/**
	 * @mbggenerated
	 */
	public void setSeq(Byte seq) {
		this.seq = seq;
	}

	/**
	 * @mbggenerated
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @mbggenerated
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate == null ? null : createDate.trim();
	}

	/**
	 * @mbggenerated
	 */
	public Byte getWageCountType() {
		return wageCountType;
	}

	/**
	 * @mbggenerated
	 */
	public void setWageCountType(Byte wageCountType) {
		this.wageCountType = wageCountType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getPerformanceType() {
		return performanceType;
	}

	/**
	 * @mbggenerated
	 */
	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getRoyaltyRange() {
		return royaltyRange;
	}

	/**
	 * @mbggenerated
	 */
	public void setRoyaltyRange(Byte royaltyRange) {
		this.royaltyRange = royaltyRange;
	}

	/**
	 * @mbggenerated
	 */
	public Byte getProfitRange() {
		return profitRange;
	}

	/**
	 * @mbggenerated
	 */
	public void setProfitRange(Byte profitRange) {
		this.profitRange = profitRange;
	}

	/**
	 * @mbggenerated
	 */
	public Integer getBaseProportion() {
		return baseProportion;
	}

	/**
	 * @mbggenerated
	 */
	public void setBaseProportion(Integer baseProportion) {
		this.baseProportion = baseProportion;
	}

	/**
	 * @mbggenerated
	 */
	public String getWageTypeDesc() {
		return wageTypeDesc;
	}

	/**
	 * @mbggenerated
	 */
	public void setWageTypeDesc(String wageTypeDesc) {
		this.wageTypeDesc = wageTypeDesc == null ? null : wageTypeDesc.trim();
	}

	/**
	 * @mbggenerated
	 */
	public void ErpFunWageTypeKey() {
	}

	/**
	 * @mbggenerated
	 */
	public void ErpFunWageTypeKey(Integer wagetypeId, Integer compId) {
		this.wagetypeId = wagetypeId;
		this.compId = compId;
	}
}