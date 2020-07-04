package com.myfun.erpWeb.usercenter.vo;

import com.myfun.repository.admindb.dto.AdminFunArchiveDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel(description = "获取夺宝币排行榜VO")
public class TreasureCoinRankingVo implements Serializable {
	@ApiModelProperty("档案列表")
	private List<AdminFunArchiveDto> totalRanking;
	@ApiModelProperty("档案信息")
	private AdminFunArchiveDto selfRanking;

	public List<AdminFunArchiveDto> getTotalRanking() {
		return totalRanking;
	}

	public void setTotalRanking(List<AdminFunArchiveDto> totalRanking) {
		this.totalRanking = totalRanking;
	}

	public AdminFunArchiveDto getSelfRanking() {
		return selfRanking;
	}

	public void setSelfRanking(AdminFunArchiveDto selfRanking) {
		this.selfRanking = selfRanking;
	}
}
