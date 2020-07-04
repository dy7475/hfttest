package com.myfun.service.business.searchdb.bean.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.DaoBaseParam;

import io.swagger.annotations.ApiModelProperty;

public class SoSoConvertRegisterParam extends AbstractEncryParam implements DaoBaseParam {
	
	@ApiModelProperty(value = "repeatId,备注：repeatId和sosoId一起传")
	private Integer repeatId;// 搜搜ID
	@ApiModelProperty(value = "sosoId,备注：sosoId和phone只传一个")
	private Integer sosoId;// 搜搜ID
	@ApiModelProperty(value = "类型1=出售、2=出租、3=转铺、4=合租",required = true)
	private Integer sosoType;// 搜搜类型
	@ApiModelProperty(value = "电话")
	private String phone; // 电话
	public Integer getSosoId() {
		return sosoId;
	}
	public void setSosoId(Integer sosoId) {
		this.sosoId = sosoId;
	}
	public Integer getSosoType() {
		return sosoType;
	}
	public void setSosoType(Integer sosoType) {
		this.sosoType = sosoType;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Integer getRepeatId() {
		return repeatId;
	}
	public void setRepeatId(Integer repeatId) {
		this.repeatId = repeatId;
	}
}
