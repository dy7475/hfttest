package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import com.myfun.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.admindb.dao.AdminFunSectionMapper;
import com.myfun.repository.admindb.dto.AdminFunSectionDto;
import com.myfun.repository.admindb.param.AdminFunSectionParam;
import com.myfun.repository.admindb.po.AdminFunSection;
import com.myfun.repository.admindb.po.AdminFunSectionKey;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.erpdb.dao.ErpFunSectionMapper;
import com.myfun.repository.erpdb.po.ErpFunSection;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunSectionService;
import com.myfun.utils.StringUtil;

@Service
public class AdminFunSectionServiceImpl extends AbstractService<AdminFunSection, AdminFunSectionKey> implements AdminFunSectionService {
	@Autowired
	private AdminFunSectionMapper adminFunSectionMapper;
	@Autowired
	private ErpFunSectionMapper erpFunSectionMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunSectionMapper;
	}

	@Override
	public PageInfo<AdminFunSectionDto> getSectionsData(AdminFunSectionParam adminFunSectionParam) {
		PageHelper.startPage(adminFunSectionParam.getPageNum(), adminFunSectionParam.getPageSize(), true);
		List<AdminFunSectionDto> sections = adminFunSectionMapper.getSectionsData(adminFunSectionParam);
		PageInfo<AdminFunSectionDto> pageInfo = new PageInfo<>(sections);
		return pageInfo;
	}

	@Transactional
	@Override
	public void createRecords(AdminFunSection adminFunSection) {
		//获取ID
	/*	int sectionId = adminFunSectionMapper.getId() + 1;
		adminFunSection.setSectionId(sectionId);*/
		adminFunSectionMapper.insertSelective(adminFunSection);
		//往ERP库中插入数据
		ErpFunSection record = new ErpFunSection();
		record.setSectionId(adminFunSection.getSectionId());
		record.setShardCityId(StringUtil.parseInteger(String.valueOf(adminFunSection.getCityId())));
		record.setCityId(adminFunSection.getCityId());
		record.setRegId(adminFunSection.getRegId());
		record.setSectionCode(adminFunSection.getSectionCode());
		record.setSectionName(adminFunSection.getSectionName());
		byte f = adminFunSection.getVertifyFlag();
		record.setVertifyFlag(f);
		erpFunSectionMapper.insertDefaultSelective(record);
	}

	@Transactional
	@Override
	public void updateRecords(AdminFunSection adminFunSection) {
		adminFunSectionMapper.updateByPrimaryKeySelective(adminFunSection);
		//更新ERP库中数据
		ErpFunSection record = new ErpFunSection();
		record.setShardCityId(StringUtil.parseInteger(String.valueOf(adminFunSection.getCityId())));
		record.setCityId(adminFunSection.getCityId());
		record.setRegId(adminFunSection.getRegId());
		record.setSectionCode(adminFunSection.getSectionCode());
		record.setSectionName(adminFunSection.getSectionName());
		record.setVertifyFlag(adminFunSection.getVertifyFlag());
		record.setSectionId(adminFunSection.getSectionId());
		record.setUpdateTime(DateUtil.DateToString(new Date()));
		erpFunSectionMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 查询板块列表
	 * **/
	@Override
	public List<SelectDto> selectSectionByRegIdAndSectionName(Integer regId, String sectionName) {
		return adminFunSectionMapper.selectSectionByRegIdAndSectionName(regId, sectionName);
	}
	

}
