package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyFunProvinceMapper;
import com.myfun.repository.agencydb.po.AgencyFunProvince;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunProvinceService;

@Service
public class AgencyFunProvinceServiceImpl extends AbstractService<AgencyFunProvince, Integer>
		implements AgencyFunProvinceService {

	@Autowired
	private AgencyFunProvinceMapper agencyFunProvinceMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunProvinceMapper;
	}

}
