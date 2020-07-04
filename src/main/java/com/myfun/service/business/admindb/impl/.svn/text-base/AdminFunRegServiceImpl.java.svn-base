package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunRegMapper;
import com.myfun.repository.admindb.po.AdminFunReg;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunRegService;
@Service
public class AdminFunRegServiceImpl extends AbstractService<AdminFunReg, Integer> implements AdminFunRegService {
	@Autowired
	private AdminFunRegMapper adminFunRegMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunRegMapper;
		
	}

	/**
	 * 根据城市和名称查询
	 * @param cityId
	 * @param regName
	 * @return
	 */
	@Override
	public List<SelectDto> selectByCityIdAndRegName(Integer cityId, String regName) {
		return adminFunRegMapper.selectByCityIdAndRegName(cityId, regName);
	}

}
