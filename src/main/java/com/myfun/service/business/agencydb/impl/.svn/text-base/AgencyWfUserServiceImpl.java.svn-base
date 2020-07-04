package com.myfun.service.business.agencydb.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfUserMapper;
import com.myfun.repository.agencydb.po.AgencyWfUser;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfUserService;

@Service
public class AgencyWfUserServiceImpl extends AbstractService<AgencyWfUser, Integer> implements AgencyWfUserService {
	@Autowired
	private AgencyWfUserMapper agencyWfUserMapper;
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyWfUserMapper;
	}
}
