package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfRedpackagesMapper;
import com.myfun.repository.agencydb.po.AgencyWfRedpackages;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfRedpackagesService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午2:46:29 
 * 红包信息
*/
@Service
public class AgencyWfRedpackagesServiceImpl extends AbstractService<AgencyWfRedpackages, Integer>implements AgencyWfRedpackagesService {
	
	@Autowired
	private AgencyWfRedpackagesMapper agencyWfRedpackagesMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyWfRedpackagesMapper;
	}

	@Override
	public AgencyWfRedpackages getRecordForUUMobile(Integer cityId, Integer caseId, Integer caseType, int type) {
		AgencyWfRedpackages agencyWfRedpackages = agencyWfRedpackagesMapper.getRecordForUUMobile(cityId, caseId, caseType, type);
		return agencyWfRedpackages;
	}
	

}
