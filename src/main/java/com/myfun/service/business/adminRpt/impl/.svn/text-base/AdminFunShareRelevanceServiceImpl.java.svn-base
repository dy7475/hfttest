package com.myfun.service.business.adminRpt.impl;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunShareRelevanceMapper;
import com.myfun.repository.admindb.po.AdminFunShareRelevance;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.adminRpt.AdminFunShareRelevanceService;
@Service
public class AdminFunShareRelevanceServiceImpl extends AbstractService<AdminFunShareRelevance, Integer> implements AdminFunShareRelevanceService {

	@Autowired
	private AdminFunShareRelevanceMapper adminFunShareRelevanceMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunShareRelevanceMapper;
	}

	@Override
	public List<Integer> getCompIdsByShareId(Integer shareId, Integer cityId) {
		List<AdminFunShareRelevance> compIdsByShareId = adminFunShareRelevanceMapper.getCompIdsByShareId(shareId);
		List<Integer> resultList = null;
		if(null == compIdsByShareId || compIdsByShareId.size() < 1){
			return null;
		}
		List<String> shareCompNos = compIdsByShareId.stream().collect(Collectors.mapping(AdminFunShareRelevance::getShareCompNo, Collectors.toList()));
		if(null != shareCompNos){
			resultList = erpFunCompMapper.getCompIdsByCompNos(cityId, shareCompNos);
		}
		return resultList;
	}

	
}
