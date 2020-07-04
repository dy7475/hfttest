package com.myfun.erpWeb.managecenter.sysmanager.param;

import com.myfun.repository.param.EncryParamIfc;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author guohao
 * @date 2019-03-08 18:33
 */
public class IdParam implements EncryParamIfc {
	@ApiModelProperty("贷款银行主键id")
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
