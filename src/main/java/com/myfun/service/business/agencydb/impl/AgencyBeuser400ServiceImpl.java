package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyBeuse400Mapper;
import com.myfun.repository.agencydb.po.AgencyBeuse400;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBeuser400Service;

@Service
public class AgencyBeuser400ServiceImpl extends AbstractService<AgencyBeuse400, String> 
implements AgencyBeuser400Service {
	@Autowired
	private AgencyBeuse400Mapper agencyBeuse400Mapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBeuse400Mapper;
	}

	@Override
	public List<AgencyBeuse400> getListByOccUpy(String occupy) {
		return agencyBeuse400Mapper.getListByOccUpy(occupy);
	}

	@Override
	public int updateOccupy(AgencyBeuse400 record) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
