package com.myfun.service.business.agencydb;

import java.math.BigDecimal;

import com.myfun.repository.agencydb.po.AgencyFunCustDeal;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.support.param.GeneralParam;

public interface AgencyFunCustDealService extends BaseMapper<AgencyFunCustDeal, Integer> {
	
	BigDecimal[] getFunCustDealData(GeneralParam generalParam, int type);
}
