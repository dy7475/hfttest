package com.myfun.repository.erpdb.param;

import com.myfun.repository.erpdb.po.ErpFunDeal;
import com.myfun.repository.param.EncryParamIfc;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 创建手动录入业绩，编辑信息
 * @author 方李骥
 * @since 2016年8月31日
 */
@ApiModel
public class CreateOrUpdateByHandProfitParam extends ErpFunDeal implements EncryParamIfc{
	@ApiModelProperty("城市Id")
	private Integer cityId;
	@ApiModelProperty("业绩列表")
	private String profitJson;
	@ApiModelProperty("当前登录人Id")
	private Integer currentUserId;
	@ApiModelProperty("当前登录人公司Id")
	private Integer currentCompId;
	@ApiModelProperty(value = "被移除的业绩ID，例：898979,649821,782332")
	private String removeProfitIds;
	
	public Integer getCityId() {
		return cityId;
	}
	public void setCityId(Integer cityId) {
		this.cityId = cityId;
	}
	public Integer getCurrentUserId() {
		return currentUserId;
	}
	public void setCurrentUserId(Integer currentUserId) {
		this.currentUserId = currentUserId;
	}
	public String getProfitJson() {
		return profitJson;
	}
	public void setProfitJson(String profitJson) {
		this.profitJson = profitJson;
	}
	public Integer getCurrentCompId() {
		return currentCompId;
	}
	public void setCurrentCompId(Integer currentCompId) {
		this.currentCompId = currentCompId;
	}
	public String getRemoveProfitIds() {
		return removeProfitIds;
	}
	public void setRemoveProfitIds(String removeProfitIds) {
		this.removeProfitIds = removeProfitIds;
	}
}
