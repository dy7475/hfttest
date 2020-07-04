package com.myfun.service.business.searchdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class SoSoConverDetectParam extends AbstractEncryParam implements DaoBaseParam{
	@ApiModelProperty(value = "搜搜ID")
	private Integer sosoId;// 搜搜ID
	@ApiModelProperty(hidden = true)
	private Integer sosoProperty;// 据说可以不要了
	@ApiModelProperty(value = "搜搜类型")
	private Integer sosoType;// 搜搜类型
	@ApiModelProperty(value = "1=出售、2=出租、3=转铺、4=合租")
	private String type;// 1=出售、2=出租、3=转铺、4=合租
	@ApiModelProperty(value = "时间")
	private String inTime;// 时间
	@ApiModelProperty(value = "重复房源标记id")
	private Integer repeatId;// 重复房源标记id
	
	public Integer getRepeatId() {
		return repeatId;
	}
	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}
	public Integer getSosoId() {
		return sosoId;
	}
	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}
	public Integer getSosoProperty() {
		return sosoProperty;
	}
	public void setSosoProperty(Integer sosoProperty) {
		this.sosoProperty = sosoProperty;
	}
	public Integer getSosoType() {
		return sosoType;
	}
	public void setSosoType(Integer sosoType) {
		this.sosoType = sosoType;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getInTime() {
		return inTime;
	}
	public void setInTime(String inTime) {
		this.inTime = inTime;
	}
	
	
	
}

