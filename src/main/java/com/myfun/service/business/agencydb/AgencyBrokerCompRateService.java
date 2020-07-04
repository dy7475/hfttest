package com.myfun.service.business.agencydb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.po.AgencyBrokerCompRate;
import com.myfun.repository.agencydb.po.AgencyBrokerCompRateKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyBrokerCompRateService extends BaseMapper<AgencyBrokerCompRate, AgencyBrokerCompRateKey>{

	AgencyBrokerCompRate getDistCompCommissionRate(BaseMapParam param);

	Integer setCompCommissionRate(BaseMapParam param);

}
