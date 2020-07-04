package com.myfun.erpWeb.homepage.param;

import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.spi.valuehandling.ValidatedValueUnwrapper;
import org.springframework.beans.factory.annotation.Autowired;

public class AppWorkCountStatisticsRankParam implements EncryParamIfc {

	@ApiModelProperty(value = "管理范围，1:公司 2:大区3：片区 4：门店 5：分组 6：到人", required = true)
	private Integer rangeType;
	@ApiModelProperty(value = "范围id（如rangeType为1,则rangeId为对应的compId）,隔开", required = true)
	private String rangeIds;
	@ApiModelProperty(value = "查看类型,产值参考数据字典类型DIC_TYPE = 'STATISTICS_TYPE'的DIC_VALUE值", required = true)
	private Integer lookRankType;
	@ApiModelProperty(value = "用于区分房客源跟进，登记 1=房源，2=客源")
	private Integer funCust;
	@ApiModelProperty(value = "开始时间", required = true)
	private String startDate;
	@ApiModelProperty(value = "查询分组的情况把deptId带上，其他情况不传")
	private  Integer deptId;
	@ApiModelProperty(value = "结束时间,如:2018-12-11", required = true)
	private String endDate;
	@ApiModelProperty(value = "考核类型，1=日考核2=周考核3=月考核")
	private  Integer dateType;
	@ApiModelProperty(value = "2=按大区3=按片区4=按门店5=按分组6按员工")
	private Integer lookType;
	@ApiModelProperty(value = "分组Id")
	private Integer grId;
	@ApiModelProperty(value = "片区Id")
	private Integer regId;
	@ApiModelProperty(value = "大区Id")
	private Integer areaId;
	@ApiModelProperty(value = "房基地查询范围，1=全公司，2=我的团队")
	private  Integer fjdRangeType;
	@ApiModelProperty(value = "层级主键ID (员工:-2),全公司0")
	private Integer defId;
	@ApiModelProperty(value = "查看层级ID (员工:-2)")
	private Integer lookDefId;
	@ApiModelProperty(value = "管理范围Ids")
	private String organizationIds;

	public Integer getLookDefId() {
		return lookDefId;
	}

	public void setLookDefId(Integer lookDefId) {
		this.lookDefId = lookDefId;
	}

	public String getOrganizationIds() {
		return organizationIds;
	}

	public void setOrganizationIds(String organizationIds) {
		this.organizationIds = organizationIds;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getGrId() {
		return grId;
	}

	public void setGrId(Integer grId) {
		this.grId = grId;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public Integer getDateType() {
		return dateType;
	}

	public void setDateType(Integer dateType) {
		this.dateType = dateType;
	}

	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getRangeType() {
		return rangeType;
	}
	public void setRangeType(Integer rangeType) {
		this.rangeType = rangeType;
	}
	public String getRangeIds() {
		return rangeIds;
	}
	public void setRangeIds(String rangeIds) {
		this.rangeIds = rangeIds;
	}
	public Integer getLookRankType() {
		return lookRankType;
	}
	public void setLookRankType(Integer lookRankType) {
		this.lookRankType = lookRankType;
	}
	public Integer getFunCust() {
		return funCust;
	}
	public void setFunCust(Integer funCust) {
		this.funCust = funCust;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getLookType() {
		return lookType;
	}

	public void setLookType(Integer lookType) {
		this.lookType = lookType;
	}

	public Integer getFjdRangeType() {
		return fjdRangeType;
	}

	public void setFjdRangeType(Integer fjdRangeType) {
		this.fjdRangeType = fjdRangeType;
	}

	public Integer getDefId() {
		return defId;
	}

	public void setDefId(Integer defId) {
		this.defId = defId;
	}
}
