package com.myfun.repository.erpdb.param;

import com.myfun.repository.param.EncryParamIfc;

/**
 * 应用薪资方案
 * @author 张宏利
 * @since 2017年8月28日
 */
public class AppliedSalarySchemeParam extends CreateOrUpdateUserSalaryPlanParam{
	
	private Integer deptId;// 应用的门店范围
	private Integer roleId;// 应用的角色ID
	private Integer salaryTypeId;// 薪资方案id
	private Integer salaryMoney;// 基本薪资
	
	
	private Integer compId;
	private Integer cityId;
	
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
	}
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	
	
}
