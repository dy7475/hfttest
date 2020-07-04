package com.myfun.service.business.agencydb;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.repository.support.mybatis.api.BaseMapper;

/**
 * @TODO
 * @author lcb
 * @2016-9-24 下午5:04:16
 */

public interface AgencyCooperationRuleService extends BaseMapper<AgencyCooperationRule, Integer>{

	AgencyCooperationRule getDistCooperationRuleDetailed(BaseMapParam param);

}
