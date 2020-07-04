package com.myfun.erpWeb.managecenter.buildData.vo;

import com.myfun.repository.erpdb.po.ErpFunBuildRule;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ErpFunBuildRuleDto extends ErpFunBuildRule {
	@ApiModelProperty("总户数")
	private Integer totalRoomCount;
	@ApiModelProperty("房号")
	private String houseNum;
	@ApiModelProperty("最后跟进内容")
	private String lastTrancContent;
	@ApiModelProperty("跟进内容")
	private String  trackContent;
	@ApiModelProperty("跟进时间")
	private String trackTime;
	@ApiModelProperty("是否能够查看电话 1是")
	private Integer canLook;

	public String getTrackContent() {
		return trackContent;
	}

	public void setTrackContent(String trackContent) {
		this.trackContent = trackContent;
	}

	public String getTrackTime() {
		return trackTime;
	}

	public void setTrackTime(String trackTime) {
		this.trackTime = trackTime;
	}

	public Integer getCanLook() {
		return canLook;
	}

	public void setCanLook(Integer canLook) {
		this.canLook = canLook;
	}

	public Integer getTotalRoomCount() {
		return totalRoomCount;
	}

	public void setTotalRoomCount(Integer totalRoomCount) {
		this.totalRoomCount = totalRoomCount;
	}

	public String getHouseNum() {
		return houseNum;
	}

	public void setHouseNum(String houseNum) {
		this.houseNum = houseNum;
	}

	public String getLastTrancContent() {
		return lastTrancContent;
	}

	public void setLastTrancContent(String lastTrancContent) {
		this.lastTrancContent = lastTrancContent;
	}
}
