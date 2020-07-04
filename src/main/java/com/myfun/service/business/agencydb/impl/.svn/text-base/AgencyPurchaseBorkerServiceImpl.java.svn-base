package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyPurchaseBorkerMapper;
import com.myfun.repository.agencydb.po.AgencyPurchaseBorker;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyPurchaseBorkerService;

@Service
public class AgencyPurchaseBorkerServiceImpl extends AbstractService<AgencyPurchaseBorker, Integer> implements AgencyPurchaseBorkerService {
	@Autowired
	private AgencyPurchaseBorkerMapper agencyPurchaseBorkerMapper;
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyPurchaseBorkerMapper;
	}
	@Override
	public int count(AgencyPurchaseBorker agencyPurchaseBorker) {
		return agencyPurchaseBorkerMapper.count(agencyPurchaseBorker);
	}
	@Override
	public List<AgencyPurchaseBorker> getPurchaseList(String cityId, Integer caseId, String caseType) {
		return agencyPurchaseBorkerMapper.getPurchaseList(cityId, caseId, caseType);
	}

	

}
