package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfCollectMapper;
import com.myfun.repository.agencydb.po.AgencyWfCollect;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfCollectService;

@Service
public class AgencyWfCollectServiceImpl extends AbstractService<AgencyWfCollect, Integer> implements AgencyWfCollectService {
	@Autowired
	private AgencyWfCollectMapper agencyWfCollectMapper;
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyWfCollectMapper;
	}
	@Override
	public AgencyWfCollect getWfCollectInfo(Integer caseId, Byte caseType, String wxId, Integer cityId) throws Exception {
		AgencyWfCollect agencyWfCollect = new AgencyWfCollect();
		agencyWfCollect.setCaseId(caseId);
		agencyWfCollect.setCaseType(caseType);
		agencyWfCollect.setWxId(wxId);
		agencyWfCollect.setCityId(cityId);
		List<AgencyWfCollect> agencyWfCollects = agencyWfCollectMapper.queryWfCollectInfoByCondition(agencyWfCollect);
		return agencyWfCollects.size() > 0 ? agencyWfCollects.get(0) : null;
	}
	
}
