package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunMsgMapper;
import com.myfun.repository.erpdb.po.ErpFunMsg;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunMsgService;

@Service
public class ErpFunMsgServiceImpl extends AbstractService<ErpFunMsg, ErpFunMsg> implements ErpFunMsgService {
	@Autowired
	private ErpFunMsgMapper erpFunMsgMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunMsgMapper;
	}

	@Override
	public void insertFunMsg(ErpFunMsg erpFunMsg) {
		erpFunMsgMapper.insertFunMsg(erpFunMsg);
		
	}

	
}
