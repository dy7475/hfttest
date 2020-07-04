package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.myfun.repository.agencydb.dao.AgencyDayDetailMapper;
import com.myfun.repository.agencydb.dto.AgencyDayDetallDto;
import com.myfun.repository.agencydb.po.AgencyDayDetail;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyDayDetallService;

@Service
public class AgencyDayDetallServiceImpl extends AbstractService<AgencyDayDetail, Integer> implements AgencyDayDetallService {
	
	@Autowired
	private AgencyDayDetailMapper agencyDayDetailMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyDayDetailMapper;
	}
	@Override
	public Page<AgencyDayDetallDto> getLogList(String cityId, String caseId, String caseType) {
		PageHelper.startPage(1, 100, true);
		Page<AgencyDayDetallDto> list = agencyDayDetailMapper.getLogList(cityId, caseId, caseType);
		return list;
	}
	
	

}
