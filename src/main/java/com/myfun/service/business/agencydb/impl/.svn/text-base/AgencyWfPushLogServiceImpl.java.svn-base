package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfPushLogMapper;
import com.myfun.repository.agencydb.dto.EntrustCountDto;
import com.myfun.repository.agencydb.po.AgencyWfPushLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfPushLogService;

@Service
public class AgencyWfPushLogServiceImpl extends AbstractService<AgencyWfPushLog, Integer> implements AgencyWfPushLogService {
	@Autowired
	private AgencyWfPushLogMapper agencyWfPushLogMapper;
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyWfPushLogMapper;
	}
	@Override
	public List<EntrustCountDto> getEntrustCountInfo(Integer cityId, Integer wxId) throws Exception {
		return agencyWfPushLogMapper.getEntrustCountInfo(cityId, wxId);
	}
}
