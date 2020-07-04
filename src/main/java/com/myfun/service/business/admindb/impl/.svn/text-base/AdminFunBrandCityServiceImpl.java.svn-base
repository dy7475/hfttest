package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunBrandCityMapper;
import com.myfun.repository.admindb.dto.AdminFunBrandCityDto;
import com.myfun.repository.admindb.po.AdminFunBrandCity;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBrandCityService;

/**
 * @author lcb
 *
 */
@Service
public class AdminFunBrandCityServiceImpl extends AbstractService<AdminFunBrandCity, Integer> implements AdminFunBrandCityService {
	@Autowired
	private AdminFunBrandCityMapper adminFunBrandCityMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminFunBrandCityMapper;
	}

	/**
	 * @author lcb
	 * **/
	@Override
	public List<AdminFunBrandCityDto> getFunBrandCity(Integer brandId) {
		return adminFunBrandCityMapper.getAdminFunBrandCityByBrandId(brandId);
	}
	
	
}
