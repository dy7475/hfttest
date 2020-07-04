package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyDicDefinitionsMapper;
import com.myfun.repository.agencydb.po.AgencyDicDefinitions;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyDicDefinitionsService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 下午12:44:24 
 * 类说明 
*/
@Service
public class AgencyDicDefinitionsServiceImpl extends AbstractService<AgencyDicDefinitions, Integer>implements AgencyDicDefinitionsService {
	@Autowired
	private AgencyDicDefinitionsMapper agencyDicDefinitionsMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyDicDefinitionsMapper;
	}

	@Override
	public AgencyDicDefinitions getMsg(String dicType, String dicValue) {
		AgencyDicDefinitions agencyDicDefinitions = agencyDicDefinitionsMapper.getMsg(dicType, dicValue);
		return agencyDicDefinitions;
	}


}
