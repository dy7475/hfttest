package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunSectionMapper;
import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.admindb.po.AdminFunSectionKey;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunSelectService;
@Service
public class AdminFunSelectServiceImpl extends AbstractService<AdminFunSection, AdminFunSectionKey> implements AdminFunSelectService {
	@Autowired
	private AdminFunSectionMapper adminFunSectionMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunSectionMapper;
	}
	@Override
	public List<SelectDto> getSectionInfo(String cityId, String regId) {
		return adminFunSectionMapper.getSectionInfo(cityId, regId);
	}

	

}
