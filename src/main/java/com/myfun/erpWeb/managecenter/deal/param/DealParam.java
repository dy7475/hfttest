package com.myfun.erpWeb.managecenter.deal.param;

import com.myfun.repository.param.AbstractEncryParam;
import com.myfun.repository.support.param.PageParam;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author guohao
 * @date 2019-03-16 17:21
 */
public class DealParam extends AbstractEncryParam {
	@NotBlank
	private String dealId;

	public String getDealId() {
		return dealId;
	}

	public void setDealId(String dealId) {
		this.dealId = dealId;
	}
}
