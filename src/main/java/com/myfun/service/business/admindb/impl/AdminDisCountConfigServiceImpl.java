package com.myfun.service.business.admindb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminDiscountConfigMapper;
import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminDisCountConfigService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年4月8日 下午6:20:33 
 * 类说明 
*/
@Service
public class AdminDisCountConfigServiceImpl extends AbstractService<AdminDiscountConfig, Integer>implements AdminDisCountConfigService {
	@Autowired
	private AdminDiscountConfigMapper adminDiscountConfigMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminDiscountConfigMapper;
	}

	@Override
	public AdminDiscountConfig getConfigByCityAndType(Integer cityId, String type) {
		return adminDiscountConfigMapper.getConfigByCityAndType(cityId, type);
	}

	@Override
	public AdminDiscountConfig getRecordByCityLevelAndType(Byte cityLevel, String type) {
		return adminDiscountConfigMapper.getRecordByCityLevelAndType(cityLevel, type);
	}

	

}
