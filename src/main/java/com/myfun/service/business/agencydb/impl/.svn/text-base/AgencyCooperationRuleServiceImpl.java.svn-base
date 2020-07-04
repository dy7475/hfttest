package com.myfun.service.business.agencydb.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyCooperationRuleMapper;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyCooperationRuleService;

/**
 * @TODO
 * @author lcb
 * @2016-9-24 下午5:05:52
 */

@Service
public class AgencyCooperationRuleServiceImpl extends AbstractService<AgencyCooperationRule, Integer>implements AgencyCooperationRuleService {
	@Autowired
	AgencyCooperationRuleMapper agencyCooperationRuleMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyCooperationRuleMapper;
	}

	/**
	 * @TODO 
	 * @author lcb
	 * @2016-9-24 下午5:09:28
	 */
	@Override
	public AgencyCooperationRule getDistCooperationRuleDetailed(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		return agencyCooperationRuleMapper.getDistCooperationRuleDetailed(pMap);
	}

}
