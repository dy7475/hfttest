package com.myfun.erpWeb.managecenter.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2018-11-13 15:40
 */
public class ParaParam implements EncryParamIfc {
	@ApiModelProperty("检索关键字")
	private String para;
	@ApiModelProperty("楼盘Id")
	private Integer buildId;

	public Integer getBuildId() {
		return buildId;
	}

	public void setBuildId(Integer buildId) {
		this.buildId = buildId;
	}

	public String getPara() {
		return para;
	}

	public void setPara(String para) {
		this.para = para;
	}
}
