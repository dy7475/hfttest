package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class AddDeptParam extends ErpFunDepts implements EncryParamIfc {
	@ApiModelProperty(value = "新增人档案ID")
	private Integer archiveId;
	@ApiModelProperty(value = "省份")
	private Integer provinceId;
	@ApiModelProperty(value = "城市")
	private Integer cityId;
	@ApiModelProperty(value = "公司名称")
	private String compName;
	@ApiModelProperty(value = "经度")
	private String positionX;
	@ApiModelProperty(value = "纬度")
	private String positionY;
	@ApiModelProperty(value = "联系人电话")
	private String contractPhone;
	@ApiModelProperty(hidden = true)
	private Integer addType;

	public Integer getAddType() {
		return addType;
	}

	public void setAddType(Integer addType) {
		this.addType = addType;
	}

	public String getContractPhone() {
		return contractPhone;
	}

	public void setContractPhone(String contractPhone) {
		this.contractPhone = contractPhone;
	}

	public String getPositionX() {
		return positionX;
	}

	public void setPositionX(String positionX) {
		this.positionX = positionX;
	}

	public String getPositionY() {
		return positionY;
	}

	public void setPositionY(String positionY) {
		this.positionY = positionY;
	}

	public Integer getCityId() {
		return cityId;
	}

	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}

	public String getCompName() {
		return compName;
	}

	public void setCompName(String compName) {
		this.compName = compName;
	}

	public Integer getArchiveId() {
		return archiveId;
	}

	public void setArchiveId(Integer archiveId) {
		this.archiveId = archiveId;
	}

	public Integer getProvinceId() {
		return provinceId;
	}

	public void setProvinceId(Integer provinceId) {
		this.provinceId = provinceId;
	}
}
