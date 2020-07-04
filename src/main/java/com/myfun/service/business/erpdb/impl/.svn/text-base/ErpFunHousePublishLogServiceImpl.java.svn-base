package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunHousePublishLogMapper;
import com.myfun.repository.erpdb.po.ErpFunHousePublishLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunHousePublishLogService;

@Service
public class ErpFunHousePublishLogServiceImpl extends AbstractService<ErpFunHousePublishLog, Integer> implements ErpFunHousePublishLogService{
	@Autowired
	private ErpFunHousePublishLogMapper erpFunHousePublishLogMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunHousePublishLogMapper;
	}

	@Override
	public ArrayList<ErpFunHousePublishLog> getListInfo(String cityId, String pubId) {
		return erpFunHousePublishLogMapper.getListInfo(cityId, pubId);
	}

}
