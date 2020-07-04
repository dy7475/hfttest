package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpBuildingSet;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 栋座规则的参数
 * @author 张宏利
 * @since 2017年8月21日
 */
@ApiModel
public class ErpBuildingSetParam extends ErpBuildingSet implements EncryParamIfc{
	private static final long serialVersionUID = 1L;

	@ApiModelProperty("单元数")
	private Integer buildUnitNum;// 单元数
	private Integer areaId;
	private Integer regId;
	private Integer deptId;
	@ApiModelProperty("当前用户ID")
	private Integer selfUserId;// 当前用户ID
	@ApiModelProperty("老的单元号")
	private String oldBuildUnit;// 老的单元号
	@ApiModelProperty("老的栋号")
	private String oldBuildRoof;// 老的栋号
	@ApiModelProperty("使用单元和楼层通拍号")
	private Integer addedByAllUnits;// 使用单元和楼层通拍号
	@ApiModelProperty("栋座前缀")
	private String roofPrefix;// 栋座前缀
	@ApiModelProperty("栋座后缀类型，1=数字，2=字母")
	private Integer roofSuffixType;// 栋座后缀类型，1=数字，2=字母
	@ApiModelProperty("栋座后缀开始")
	private String roofSuffixStart;// 栋座后缀开始
	@ApiModelProperty("栋座后缀结束")
	private String roofSuffixEnd;// 栋座后缀结束
	@ApiModelProperty("单元前缀")
	private String unitPrefix;// 单元前缀
	@ApiModelProperty("单元后缀类型，1=数字，2=字母")
	private Integer unitSuffixType;// 单元后缀类型，1=数字，2=字母
	@ApiModelProperty("单元后缀开始")
	private String unitSuffixStart;// 单元后缀开始
	@ApiModelProperty("单元后缀结束")
	private String unitSuffixEnd;// 单元后缀结束
	
	public Integer getBuildUnitNum() {
		return buildUnitNum;
	}

	public void setBuildUnitNum(Integer buildUnitNum) {
		this.buildUnitNum = buildUnitNum;
	}

	public Integer getAreaId() {
		return areaId;
	}

	public void setAreaId(Integer areaId) {
		this.areaId = areaId;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public String getOldBuildUnit() {
		return oldBuildUnit;
	}

	public void setOldBuildUnit(String oldBuildUnit) {
		this.oldBuildUnit = oldBuildUnit;
	}

	public Integer getAddedByAllUnits() {
		return addedByAllUnits;
	}

	public void setAddedByAllUnits(Integer addedByAllUnits) {
		this.addedByAllUnits = addedByAllUnits;
	}

	public String getOldBuildRoof() {
		return oldBuildRoof;
	}

	public void setOldBuildRoof(String oldBuildRoof) {
		this.oldBuildRoof = oldBuildRoof;
	}

	public String getRoofPrefix() {
		return roofPrefix;
	}

	public void setRoofPrefix(String roofPrefix) {
		this.roofPrefix = roofPrefix;
	}

	public Integer getRoofSuffixType() {
		return roofSuffixType;
	}

	public void setRoofSuffixType(Integer roofSuffixType) {
		this.roofSuffixType = roofSuffixType;
	}

	public String getRoofSuffixStart() {
		return roofSuffixStart;
	}

	public void setRoofSuffixStart(String roofSuffixStart) {
		this.roofSuffixStart = roofSuffixStart;
	}

	public String getRoofSuffixEnd() {
		return roofSuffixEnd;
	}

	public void setRoofSuffixEnd(String roofSuffixEnd) {
		this.roofSuffixEnd = roofSuffixEnd;
	}

	public Integer getSelfUserId() {
		return selfUserId;
	}

	public void setSelfUserId(Integer selfUserId) {
		this.selfUserId = selfUserId;
	}
	
	public String getUnitPrefix() {
		return unitPrefix;
	}
	
	public void setUnitPrefix(String unitPrefix) {
		this.unitPrefix = unitPrefix;
	}
	
	public Integer getUnitSuffixType() {
		return unitSuffixType;
	}
	
	public void setUnitSuffixType(Integer unitSuffixType) {
		this.unitSuffixType = unitSuffixType;
	}
	
	public String getUnitSuffixStart() {
		return unitSuffixStart;
	}
	
	public void setUnitSuffixStart(String unitSuffixStart) {
		this.unitSuffixStart = unitSuffixStart;
	}
	
	public String getUnitSuffixEnd() {
		return unitSuffixEnd;
	}
	
	public void setUnitSuffixEnd(String unitSuffixEnd) {
		this.unitSuffixEnd = unitSuffixEnd;
	}
}
