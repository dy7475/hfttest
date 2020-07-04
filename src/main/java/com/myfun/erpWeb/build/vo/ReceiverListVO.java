package com.myfun.erpWeb.build.vo;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class ReceiverListVO implements Serializable {

	@ApiModelProperty("接盘人列表id")
	private List<ReceiverVO> receiverListVO;

	public List<ReceiverVO> getReceiverListVO() {
		return receiverListVO;
	}

	public void setReceiverListVO(List<ReceiverVO> receiverListVO) {
		this.receiverListVO = receiverListVO;
	}
	
}
