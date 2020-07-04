package com.myfun.service.business.erpdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunKeyParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "查询类型")
	private String operateType;//查询类型，byInfo根据房源所属查询，byKey根据钥匙所属查询
	@ApiModelProperty(value = "公司ID")
	private Integer compId;//公司ID
	@ApiModelProperty(value = "城市ID")
	private Integer cityId;//城市ID
	@ApiModelProperty(value = "大区ID")
	private Integer areaId;//大区ID
	@ApiModelProperty(value = "片区ID")
	private Integer regId;//片区ID
	@ApiModelProperty(value = "门店ID")
	private Integer deptId;//门店ID
	@ApiModelProperty(value = "用户ID")
	private Integer userId;//用户ID
	@ApiModelProperty(value = "钥匙编号")
	private String keyNo;//钥匙编号
	@ApiModelProperty(value = "房源编号")
	private String houseNo;//房源编号
	@ApiModelProperty(value = "房源编号")
	private String caseNo;//房源编号
	@ApiModelProperty(value = "房源类型1出售2出租")
	private Integer caseType;//房源类型1出售2出租

	@ApiModelProperty(value = "组织ID, 公司=0")
	private Integer organizationId;

	@ApiModelProperty(value = "钥匙类型，1：数量，2：密码")
	private Byte keyType;

	public Byte getKeyType() {
		return keyType;
	}

	public void setKeyType(Byte keyType) {
		this.keyType = keyType;
	}

	public String getOperateType() {
		return operateType;
	}
	public void setOperateType(String operateType) {
		this.operateType = operateType;
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
	public String getKeyNo() {
		return keyNo;
	}
	public void setKeyNo(String keyNo) {
		this.keyNo = keyNo;
	}
	public String getHouseNo() {
		return houseNo;
	}
	public void setHouseNo(String houseNo) {
		this.houseNo = houseNo;
	}
	public Integer getCaseType() {
		return caseType;
	}
	public void setCaseType(Integer caseType) {
		this.caseType = caseType;
	}
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
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}

	public Integer getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(Integer organizationId) {
		this.organizationId = organizationId;
	}
}
