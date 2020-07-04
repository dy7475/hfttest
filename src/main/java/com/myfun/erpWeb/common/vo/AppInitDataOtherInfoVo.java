package com.myfun.erpWeb.common.vo;

import com.myfun.repository.admindb.po.AdminFunCity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel
public class AppInitDataOtherInfoVo {
	@ApiModelProperty(value = "当前贷款利率")
	private List<AdminLoanRateVo> currLoanRate;
	@ApiModelProperty(value = "税费")
	private List<AdminLocalTaxesVo> taxes;
	@ApiModelProperty(value = "贷款利率")
	private List<AdminDuesLoanrateVo> loanrate;
	@ApiModelProperty(value = "水印")
	private List<AdminNPicWatermarkVo> watermarkPos;
	@ApiModelProperty("发发服务器")
	private List<FafaServiceVo>  fafaService;
	@ApiModelProperty("城市列表")
	private List<AdminFunCity> cityList;

	public List<AdminFunCity> getCityList() {
		return cityList;
	}

	public void setCityList(List<AdminFunCity> cityList) {
		this.cityList = cityList;
	}

	public List<AdminLoanRateVo> getCurrLoanRate() {
		return currLoanRate;
	}

	public void setCurrLoanRate(List<AdminLoanRateVo> currLoanRate) {
		this.currLoanRate = currLoanRate;
	}

	public List<AdminLocalTaxesVo> getTaxes() {
		return taxes;
	}

	public void setTaxes(List<AdminLocalTaxesVo> taxes) {
		this.taxes = taxes;
	}

	public List<AdminDuesLoanrateVo> getLoanrate() {
		return loanrate;
	}

	public void setLoanrate(List<AdminDuesLoanrateVo> loanrate) {
		this.loanrate = loanrate;
	}

	public List<AdminNPicWatermarkVo> getWatermarkPos() {
		return watermarkPos;
	}

	public void setWatermarkPos(List<AdminNPicWatermarkVo> watermarkPos) {
		this.watermarkPos = watermarkPos;
	}

	public List<FafaServiceVo> getFafaService() {
		return fafaService;
	}

	public void setFafaService(List<FafaServiceVo> fafaService) {
		this.fafaService = fafaService;
	}
}
