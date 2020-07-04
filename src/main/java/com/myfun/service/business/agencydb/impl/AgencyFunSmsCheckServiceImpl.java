package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyFunSmsCheckMapper;
import com.myfun.repository.agencydb.po.AgencyFunSmsCheck;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunSmsCheckService;

@Service
public class AgencyFunSmsCheckServiceImpl extends AbstractService<AgencyFunSmsCheck, Integer>
		implements AgencyFunSmsCheckService {
	@Autowired
	private AgencyFunSmsCheckMapper agencyFunSmsCheckMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunSmsCheckMapper;
	}
}
