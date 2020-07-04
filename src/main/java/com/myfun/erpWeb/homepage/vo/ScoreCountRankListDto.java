package com.myfun.erpWeb.homepage.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;
@ApiModel
public class ScoreCountRankListDto {
	@ApiModelProperty(value = "返回列表")
	List<ScoreCountRankDto> scoreCountRankDtoList;

	public List<ScoreCountRankDto> getScoreCountRankDtoList() {
		return scoreCountRankDtoList;
	}

	public void setScoreCountRankDtoList(List<ScoreCountRankDto> scoreCountRankDtoList) {
		this.scoreCountRankDtoList = scoreCountRankDtoList;
	}
}
