package com.myfun.erpWeb.managecenter.buildData.vo;

import com.myfun.repository.erpdb.po.ErpFunSelfbuild;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.List;

@ApiModel
public class ErpFunSelfbuildDto extends ErpFunSelfbuild {
	@ApiModelProperty("行政区名称")
	private String regName;
	@ApiModelProperty("行政区ID")
	private Integer regId;
	@ApiModelProperty("楼盘地址")
	private String buildAddress;
	private Integer sectionId;
	private String sectionName;
	@ApiModelProperty("使用门店Ids,多个逗号隔开")
	private String useDeptIds;
	@ApiModelProperty("最近日志")
	private String recentLog;
	@ApiModelProperty("最近日志的时间")
	private Date recentTime;
	@ApiModelProperty("推广名 --美联用")
	private String promotionName;
	
	public String getPromotionName() {
		return promotionName;
	}
	
	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}
	
	public String getBuildAddress() {
		return buildAddress;
	}

	public void setBuildAddress(String buildAddress) {
		this.buildAddress = buildAddress;
	}

	public String getRegName() {
		return regName;
	}

	public void setRegName(String regName) {
		this.regName = regName;
	}

	public Integer getSectionId() {
		return sectionId;
	}

	public void setSectionId(Integer sectionId) {
		this.sectionId = sectionId;
	}

	public String getSectionName() {
		return sectionName;
	}

	public void setSectionName(String sectionName) {
		this.sectionName = sectionName;
	}

	public Integer getRegId() {
		return regId;
	}

	public void setRegId(Integer regId) {
		this.regId = regId;
	}

	public String getUseDeptIds() {
		return useDeptIds;
	}

	public void setUseDeptIds(String useDeptIds) {
		this.useDeptIds = useDeptIds;
	}

	public String getRecentLog() {
		return recentLog;
	}

	public void setRecentLog(String recentLog) {
		this.recentLog = recentLog;
	}

	public Date getRecentTime() {
		return recentTime;
	}

	public void setRecentTime(Date recentTime) {
		this.recentTime = recentTime;
	}

	public static class MgrFloorListVo {
		private List<ErpFunSelfbuildDto> funSelfbuildDtos;

		public List<ErpFunSelfbuildDto> getFunSelfbuildDtos() {
			return funSelfbuildDtos;
		}

		public void setFunSelfbuildDtos(List<ErpFunSelfbuildDto> funSelfbuildDtos) {
			this.funSelfbuildDtos = funSelfbuildDtos;
		}
	}
}
