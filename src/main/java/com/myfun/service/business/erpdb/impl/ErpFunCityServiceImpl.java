package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunCityMapper;
import com.myfun.repository.erpdb.po.ErpFunCity;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunCityService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月31日 上午10:35:01 
 * 类说明 
*/
@Service
public class ErpFunCityServiceImpl extends AbstractService<ErpFunCity, ErpFunCity>implements ErpFunCityService {
	@Autowired
	private ErpFunCityMapper erpFunCityMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunCityMapper;
	}

	

}
