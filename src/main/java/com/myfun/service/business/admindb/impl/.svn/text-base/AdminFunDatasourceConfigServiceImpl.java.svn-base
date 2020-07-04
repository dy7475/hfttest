package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.po.AdminFunDatasourceConfig;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunDatasourceConfigService;

@Service
public class AdminFunDatasourceConfigServiceImpl extends AbstractService<AdminFunDatasourceConfig, Integer>
		implements AdminFunDatasourceConfigService {
	@Autowired
	private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunDatasourceConfigMapper;
	}

	@Override
	public void updateAllCompVersion(String compVersion) {
		adminFunDatasourceConfigMapper.updateAllCompVersion(compVersion);
	}

}
