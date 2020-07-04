package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunStatisticTotleMapper;
import com.myfun.repository.erpdb.po.ErpFunStatisticTotle;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunStatisticTotleService;

@Service
public class ErpFunStatisticTotleServiceImpl extends AbstractService<ErpFunStatisticTotle, Integer>implements ErpFunStatisticTotleService {
	@Autowired
	private ErpFunStatisticTotleMapper erpFunStatisticTotleMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunStatisticTotleMapper;
	}

}
