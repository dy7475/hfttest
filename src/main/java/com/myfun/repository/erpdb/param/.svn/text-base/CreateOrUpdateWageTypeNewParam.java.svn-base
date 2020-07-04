package com.myfun.repository.erpdb.param;

import java.math.BigDecimal;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.DaoBaseParam;
/**
 * 创建提成方案或者更新的参数类
 * @author Administrator
 *
 */
public class CreateOrUpdateWageTypeNewParam implements EncryParamIfc{
	
	private String wageTypeName;//新增方案名称
	private Integer id; //薪资方案ID
	private Byte wageCountType;//薪资的计算方式 1.阶梯计算 2.通提计算
	private Byte performanceType;//业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
	private Byte royaltyRange;//提成范围，0=个人 1=分组 2=门店 3=片区 4=大区 5=公司
	private Byte profitRange;//业绩范围，0=人均 1店均 2总业绩
	private BigDecimal baseProportion;//保底比例，当前提成方式等于通提的时候
	private String wageTypeDesc;//提成方案说明
	private Byte managePlan;//提成类型 0=业务1=管理
	private String countWageJson;//提成算法json字符串形式
	private Integer compId;
	private Integer deptId;
	private Integer cityId;
	
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
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Byte getManagePlan() {
		return managePlan;
	}
	public void setManagePlan(Byte managePlan) {
		this.managePlan = managePlan;
	}
	public String getWageTypeName() {
		return wageTypeName;
	}
	public void setWageTypeName(String wageTypeName) {
		this.wageTypeName = wageTypeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Byte getWageCountType() {
		return wageCountType;
	}
	public void setWageCountType(Byte wageCountType) {
		this.wageCountType = wageCountType;
	}
	public Byte getPerformanceType() {
		return performanceType;
	}
	public void setPerformanceType(Byte performanceType) {
		this.performanceType = performanceType;
	}
	public Byte getRoyaltyRange() {
		return royaltyRange;
	}
	public void setRoyaltyRange(Byte royaltyRange) {
		this.royaltyRange = royaltyRange;
	}
	public Byte getProfitRange() {
		return profitRange;
	}
	public void setProfitRange(Byte profitRange) {
		this.profitRange = profitRange;
	}
	public String getWageTypeDesc() {
		return wageTypeDesc;
	}
	public void setWageTypeDesc(String wageTypeDesc) {
		this.wageTypeDesc = wageTypeDesc;
	}
	public String getCountWageJson() {
		return countWageJson;
	}
	public void setCountWageJson(String countWageJson) {
		this.countWageJson = countWageJson;
	}
	public BigDecimal getBaseProportion() {
		return baseProportion;
	}
	public void setBaseProportion(BigDecimal baseProportion) {
		this.baseProportion = baseProportion;
	}
	
}
