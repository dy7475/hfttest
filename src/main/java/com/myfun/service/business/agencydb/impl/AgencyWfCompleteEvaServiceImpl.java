package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfCompleteEvaMapper;
import com.myfun.repository.agencydb.po.AgencyWfCompleteEva;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfCompleteEvaService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午4:26:31 
 * 类说明 
*/
@Service
public class AgencyWfCompleteEvaServiceImpl extends AbstractService<AgencyWfCompleteEva, Integer>implements AgencyWfCompleteEvaService {
	@Autowired
	private AgencyWfCompleteEvaMapper agencyWfCompleteEvaMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyWfCompleteEvaMapper;
	}

	

}
