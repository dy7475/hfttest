package com.myfun.erpWeb.managecenter.transaction.param;

import java.math.BigDecimal;


import com.myfun.erpWeb.managecenter.transaction.vo.HouseInfoVO;
import com.myfun.repository.erpdb.po.ErpFunDeposit;
import com.myfun.repository.param.EncryParamIfc;
import com.myfun.repository.support.param.GeneralParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class PayDepositToOwnerParam implements EncryParamIfc{
	@ApiModelProperty("转佣金的id")
	private Integer id;
	@ApiModelProperty("转佣金的金额")
	private BigDecimal commssion;
	@ApiModelProperty("备注")
	private String depositRemark;
	@ApiModelProperty(hidden = true)
	private GeneralParam generalParam;
	@ApiModelProperty(hidden = true)
	private Integer cityId;
	@ApiModelProperty(hidden = true)
	private Integer userId;
	@ApiModelProperty(hidden = true)
	private String userName;
	@ApiModelProperty(hidden = true)
	private Integer compId;
	@ApiModelProperty(hidden = true)
	private Integer areaId;
	@ApiModelProperty(hidden = true)
	private Integer regId;
	@ApiModelProperty(hidden = true)
	private Integer deptId;
	@ApiModelProperty(hidden = true)
	private Integer grId;
	@ApiModelProperty(hidden = true)
	private String deptCName;
	@ApiModelProperty(hidden = true)
	private ErpFunDeposit deposit;
	@ApiModelProperty(hidden = true)
	private HouseInfoVO houseInfo;
	
	public HouseInfoVO getHouseInfo() {
		return houseInfo;
	}
	public void setHouseInfo(HouseInfoVO houseInfo) {
		this.houseInfo = houseInfo;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public BigDecimal getCommssion() {
		return commssion;
	}
	public void setCommssion(BigDecimal commssion) {
		this.commssion = commssion;
	}
	public String getDepositRemark() {
		return depositRemark;
	}
	public void setDepositRemark(String depositRemark) {
		this.depositRemark = depositRemark;
	}
	public GeneralParam getGeneralParam() {
		return generalParam;
	}
	public void setGeneralParam(GeneralParam generalParam) {
		this.generalParam = generalParam;
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
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Integer getCompId() {
		return compId;
	}
	public void setCompId(Integer compId) {
		this.compId = compId;
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
	public Integer getGrId() {
		return grId;
	}
	public void setGrId(Integer grId) {
		this.grId = grId;
	}
	public String getDeptCName() {
		return deptCName;
	}
	public void setDeptCName(String deptCName) {
		this.deptCName = deptCName;
	}
	public ErpFunDeposit getDeposit() {
		return deposit;
	}
	public void setDeposit(ErpFunDeposit deposit) {
		this.deposit = deposit;
	}
}
