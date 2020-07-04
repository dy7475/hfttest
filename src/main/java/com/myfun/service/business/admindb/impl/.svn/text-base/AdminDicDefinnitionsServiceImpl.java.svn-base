package com.myfun.service.business.admindb.impl;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminDicDefinitionsMapper;
import com.myfun.repository.admindb.po.AdminDicDefinitions;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminDicDefinnitionsService;

@Service
public class AdminDicDefinnitionsServiceImpl extends AbstractService<AdminDicDefinitions, Integer> implements AdminDicDefinnitionsService {
	@Autowired
	private AdminDicDefinitionsMapper adminDicDefinitionsMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminDicDefinitionsMapper;
	}
	@Override
	public AdminDicDefinitions getMsg(String dicType, String dicValue) {
		return adminDicDefinitionsMapper.getMsg(dicType, dicValue, "");
	}
	@Override
	public AdminDicDefinitions getMsgS(String cityId, String dicType, String dicValue) {
		return adminDicDefinitionsMapper.getMsgS(cityId, dicType, dicValue);
	}
	@Override
	public ArrayList<SelectDto> getMsgList(String cityId, String dicType) {
		return adminDicDefinitionsMapper.getMsgList(cityId, dicType);
	}

	

}
