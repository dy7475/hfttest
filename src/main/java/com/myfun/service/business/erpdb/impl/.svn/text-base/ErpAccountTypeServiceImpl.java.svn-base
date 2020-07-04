package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpAccountTypeMapper;
import com.myfun.repository.erpdb.dto.ErpAccountTypeDto;
import com.myfun.repository.erpdb.param.AccountTypeParam;
import com.myfun.repository.erpdb.po.ErpAccountType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAccountTypeService;

@Service
public class ErpAccountTypeServiceImpl extends AbstractService<ErpAccountType, ErpAccountType> implements
		ErpAccountTypeService {
	@Autowired private ErpAccountTypeMapper erpAccountTypeMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAccountTypeMapper;
	}
	
	@Override
	public List<ErpAccountTypeDto> getAccountTypeList(BaseMapParam param) {
		return erpAccountTypeMapper.getAccountTypeList(param.getInteger("cityId"), param.getMap());
	}
	
	@Override
	public void insertAccountType(AccountTypeParam accountTypeParam) {
		erpAccountTypeMapper.insertSelective(accountTypeParam);
	}
	
	@Override
	public void updateAccountType(AccountTypeParam accountTypeParam) {
		if (accountTypeParam.getAtId() != null) {
			erpAccountTypeMapper.updateByPrimaryKeySelective(accountTypeParam);
		}
	}
	
	@Override
	public void deleteAccountType(BaseMapParam accountTypeParam) {
		ErpAccountType record = new ErpAccountType();
		record.setAtId(accountTypeParam.getInteger("atId"));
		record.setShardCityId(accountTypeParam.getInteger("cityId"));
		erpAccountTypeMapper.deleteByPrimaryKey(record);
	}
	
	
	
}
