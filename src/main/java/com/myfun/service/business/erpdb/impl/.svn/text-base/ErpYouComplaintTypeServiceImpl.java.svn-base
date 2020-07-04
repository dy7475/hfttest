package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.ErpYouComplaintTypeMapper;
import com.myfun.repository.admindb.po.ErpYouComplaintType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouComplaintTypeService;

@Service
public class ErpYouComplaintTypeServiceImpl extends AbstractService<ErpYouComplaintType, Integer> implements ErpYouComplaintTypeService {

	@Autowired
	ErpYouComplaintTypeMapper erpYouComplaintTypeMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=erpYouComplaintTypeMapper;
	}

	@Override
	public List<ErpYouComplaintType> getComplainTypeList(String owner) {
		return erpYouComplaintTypeMapper.getComplainTypeList(owner);
	}

	@Override
	public ErpYouComplaintType selectByComplaintType(Byte complainType) {
		return erpYouComplaintTypeMapper.selectByYctId(complainType);
	}

	

}
