package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.agencydb.dao.AgencyFunCompRealMapper;
import com.myfun.repository.agencydb.dto.AgencyFunCompRealDto;
import com.myfun.repository.agencydb.param.AgencyFunCompRealParam;
import com.myfun.repository.agencydb.po.AgencyFunCompReal;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFumCompRealService;

/**
 * 开发商管理
 * @author lcb
 *
 */
@Service
public class AgencyCompRealServiceImpl extends AbstractService<AgencyFunCompReal, Integer> implements AgencyFumCompRealService {
	
	@Autowired
	private AgencyFunCompRealMapper agencyFunCompRealMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyFunCompRealMapper;
	}

	// 列表
	@Override
	public PageInfo<AgencyFunCompRealDto> getFunCompRealList(AgencyFunCompRealParam agencyFunCompRealParam) {
		PageHelper.startPage(agencyFunCompRealParam.getPageNum(), agencyFunCompRealParam.getPageSize(), true);
		List<AgencyFunCompRealDto> resList = agencyFunCompRealMapper.getFunCompRealList(agencyFunCompRealParam);
		PageInfo<AgencyFunCompRealDto> pageInfo = new PageInfo<AgencyFunCompRealDto>(resList);
		return pageInfo;
	}

	
}
