package com.myfun.erpWeb.openApi.user.param;
/**
 * 
 * @author Administrator
 *
 */

import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class OpenHeaderQuqrtersParam {
	@ApiModelProperty("城市id")
	@NotNull(message="城市id不能为null")
	private Integer cityId;
	@ApiModelProperty("erp公司ID")
	@NotNull(message="公司id不能为null")
	private Integer compId;
	@ApiModelProperty("公司编号")
	@NotNull(message="公司编号不能为null")
	private String compNo;
	@ApiModelProperty("deptNo门店编号")
	@NotNull(message="门店编号不能为空")
	private String deptNo;
	@ApiModelProperty("erp门店id")
	@NotNull(message="门店id不能为空")
	private Integer deptId;
	@ApiModelProperty("operatorType 0修改为总部 -1修改为直营门店")
	@NotNull(message="operatorType不能为null")
	private Integer operatorType;
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
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
	public String getCompNo() {
		return compNo;
	}
	public void setCompNo(String compNo) {
		this.compNo = compNo;
	}
	public String getDeptNo() {
		return deptNo;
	}
	public void setDeptNo(String deptNo) {
		this.deptNo = deptNo;
	}
	public Integer getOperatorType() {
		return operatorType;
	}
	public void setOperatorType(Integer operatorType) {
		this.operatorType = operatorType;
	}
}
