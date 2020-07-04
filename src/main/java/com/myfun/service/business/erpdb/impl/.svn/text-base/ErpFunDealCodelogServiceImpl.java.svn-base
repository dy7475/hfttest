package com.myfun.service.business.erpdb.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunDealCodelogMapper;
import com.myfun.repository.erpdb.po.ErpFunDealCodelog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDealCodelogService;

@Service
public class ErpFunDealCodelogServiceImpl extends AbstractService<ErpFunDealCodelog, ErpFunDealCodelog> implements ErpFunDealCodelogService {
	
	@Autowired
	private ErpFunDealCodelogMapper erpFunDealCodelogMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunDealCodelogMapper;
	}

	@Override
	public void updateFunDealCodeLog(Integer cityId, Map<String, Object> param) {
		erpFunDealCodelogMapper.updateFunDealCodeLog(cityId,param);
	}

	@Override
	public void createBatchFunDealCodeLogList(List<ErpFunDealCodelog> list) {
		for (ErpFunDealCodelog erpFunDealCodelog : list) {
			erpFunDealCodelogMapper.insertSelective(erpFunDealCodelog);
		}
	}

	@Override
	public void deleteByCodeId(Integer cityId, Integer codeId) {
		erpFunDealCodelogMapper.deleteByCodeId(cityId,codeId);
	}


}
