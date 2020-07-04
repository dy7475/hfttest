package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyFunCityMapper;
import com.myfun.repository.agencydb.po.AgencyFunCity;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunCityService;

@Service
public class AgencyFunCityServiceImpl extends AbstractService<AgencyFunCity, Integer> implements AgencyFunCityService {

	@Autowired
	private AgencyFunCityMapper agencyFunCityMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunCityMapper;
	}

	@Override
	public List<AgencyFunCity> getCityList() {
		List<AgencyFunCity> list = agencyFunCityMapper.getCityList();
		return list;
	}

	@Override
	public List<AgencyFunCity> getBatchCityList(String[] ids) {
		List<AgencyFunCity> list = agencyFunCityMapper.getBatchCityList(ids);
		return list;
	}

}
