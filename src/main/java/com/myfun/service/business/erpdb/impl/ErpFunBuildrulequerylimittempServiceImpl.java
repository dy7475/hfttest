package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunBuildrulequerylimitMapper;
import com.myfun.repository.erpdb.dao.ErpFunBuildrulequerylimittempMapper;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittemp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBuildrulequerylimittempService;

@Service
public class ErpFunBuildrulequerylimittempServiceImpl extends AbstractService<ErpFunBuildrulequerylimittemp, ErpFunBuildrulequerylimittemp> implements ErpFunBuildrulequerylimittempService{
	@Autowired ErpFunBuildrulequerylimittempMapper erpFunBuildrulequerylimittempMapper;
	
	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunBuildrulequerylimittempMapper;
	}

	@Override
	public void insertList(String shardDbName,List<ErpFunBuildrulequerylimittemp> listTempList){
		erpFunBuildrulequerylimittempMapper.insertList(shardDbName, listTempList);
	}
}
