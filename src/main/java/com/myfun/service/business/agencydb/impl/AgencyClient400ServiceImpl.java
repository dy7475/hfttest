package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyClient400Mapper;
import com.myfun.repository.agencydb.po.AgencyClient400;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyClient400Service;

@Service
public class AgencyClient400ServiceImpl extends AbstractService<AgencyClient400, Integer> implements AgencyClient400Service {
	@Autowired
	private AgencyClient400Mapper agencyClient400Mapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyClient400Mapper;
	}

}
