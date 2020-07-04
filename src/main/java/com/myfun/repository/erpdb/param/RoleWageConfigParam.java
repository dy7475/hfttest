package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "角色-职级薪资配置")
public class RoleWageConfigParam extends ErpFunRoleWageConfig implements EncryParamIfc{

	@ApiModelProperty("个人工作量的数据")
	private String personWorkCountData;
	@ApiModelProperty("管理工作量的数据")
	private String manageWorkCountData;
	@ApiModelProperty("个人绩效数据")
	private String personProfitData;
	@ApiModelProperty("管理绩效数据")
	private String manageProfitData;
	@ApiModelProperty("业务提成数据")
	private String businessCommsionData;
	@ApiModelProperty("管理提成数据")
	private String manageCommsionData;
	@ApiModelProperty("工作量统计数据")
	private String erpFunRoleWageWorkcountList;
	@ApiModelProperty("工作业绩提成数据")
	private String erpFunRoleWageProfitList;
	@ApiModelProperty("业务提成方案书据")
	private String erpRoleWagetypeRelativeList;
	@ApiModelProperty("其它角色IDs")
	private String otherRoleIds;
	@ApiModelProperty("管理的提成方案配置数据")
    private String wageTypeNewManageJson;
	@ApiModelProperty("业务的提成方案配置数据")
    private String wageTypeNewBusinessJson;

    public String getOtherRoleIds() {
        return otherRoleIds;
    }

    public void setOtherRoleIds(String otherRoleIds) {
        this.otherRoleIds = otherRoleIds;
    }

    public String getErpFunRoleWageWorkcountList() {
		return erpFunRoleWageWorkcountList;
	}

	public void setErpFunRoleWageWorkcountList(String erpFunRoleWageWorkcountList) {
		this.erpFunRoleWageWorkcountList = erpFunRoleWageWorkcountList;
	}

	public String getErpFunRoleWageProfitList() {
		return erpFunRoleWageProfitList;
	}

	public void setErpFunRoleWageProfitList(String erpFunRoleWageProfitList) {
		this.erpFunRoleWageProfitList = erpFunRoleWageProfitList;
	}

	public String getErpRoleWagetypeRelativeList() {
		return erpRoleWagetypeRelativeList;
	}

	public void setErpRoleWagetypeRelativeList(String erpRoleWagetypeRelativeList) {
		this.erpRoleWagetypeRelativeList = erpRoleWagetypeRelativeList;
	}


	public String getPersonWorkCountData() {
		return personWorkCountData;
	}

	public void setPersonWorkCountData(String personWorkCountData) {
		this.personWorkCountData = personWorkCountData;
	}

	public String getManageWorkCountData() {
		return manageWorkCountData;
	}

	public void setManageWorkCountData(String manageWorkCountData) {
		this.manageWorkCountData = manageWorkCountData;
	}

	public String getPersonProfitData() {
		return personProfitData;
	}

	public void setPersonProfitData(String personProfitData) {
		this.personProfitData = personProfitData;
	}

	public String getManageProfitData() {
		return manageProfitData;
	}

	public void setManageProfitData(String manageProfitData) {
		this.manageProfitData = manageProfitData;
	}

	public String getBusinessCommsionData() {
		return businessCommsionData;
	}

	public void setBusinessCommsionData(String businessCommsionData) {
		this.businessCommsionData = businessCommsionData;
	}

	public String getManageCommsionData() {
		return manageCommsionData;
	}

	public void setManageCommsionData(String manageCommsionData) {
		this.manageCommsionData = manageCommsionData;
	}

	public String getWageTypeNewManageJson() {
		return wageTypeNewManageJson;
	}

	public void setWageTypeNewManageJson(String wageTypeNewManageJson) {
		this.wageTypeNewManageJson = wageTypeNewManageJson;
	}

	public String getWageTypeNewBusinessJson() {
		return wageTypeNewBusinessJson;
	}

	public void setWageTypeNewBusinessJson(String wageTypeNewBusinessJson) {
		this.wageTypeNewBusinessJson = wageTypeNewBusinessJson;
	}
}
