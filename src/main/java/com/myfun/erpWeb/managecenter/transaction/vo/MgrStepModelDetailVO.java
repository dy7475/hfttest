package com.myfun.erpWeb.managecenter.transaction.vo;

import com.myfun.repository.erpdb.dto.ErpModelStepDetailDto;
import com.myfun.repository.erpdb.po.ErpProcessModel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

@ApiModel
public class MgrStepModelDetailVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@ApiModelProperty(value = "项目步骤列表")
	List<ErpModelStepDetailDto> list;

	@ApiModelProperty(value = "模板")
    ErpProcessModel erpProcessModel;

	public List<ErpModelStepDetailDto> getList() {
		return list;
	}

	public void setList(List<ErpModelStepDetailDto> list) {
		this.list = list;
	}

	public ErpProcessModel getErpProcessModel() {
		return erpProcessModel;
	}

	public void setErpProcessModel(ErpProcessModel erpProcessModel) {
		this.erpProcessModel = erpProcessModel;
	}
}
