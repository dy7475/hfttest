package com.myfun.service.business.agencydb;

import java.math.BigDecimal;

import com.myfun.repository.agencydb.po.AgencyVoipAmount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyVoipAmountService extends BaseMapper<AgencyVoipAmount, String> {
	public BigDecimal syncVoipAmount(String mobile);

	public void createVoipAmount(String mobile);

	public String callPhone(String caller, String called);
}
