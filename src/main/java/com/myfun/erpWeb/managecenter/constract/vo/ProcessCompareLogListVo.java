package com.myfun.erpWeb.managecenter.constract.vo;

import com.myfun.repository.erpdb.po.ErpProcessRuntimeStep;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel
public class ProcessCompareLogListVo {
	@ApiModelProperty("新值")
	private ErpProcessRuntimeStep newVal;
	@ApiModelProperty("旧值")
	private ErpProcessRuntimeStep oldVal;

	public ErpProcessRuntimeStep getNewVal() {
		return newVal;
	}

	public void setNewVal(ErpProcessRuntimeStep newVal) {
		this.newVal = newVal;
	}

	public ErpProcessRuntimeStep getOldVal() {
		return oldVal;
	}

	public void setOldVal(ErpProcessRuntimeStep oldVal) {
		this.oldVal = oldVal;
	}
}
