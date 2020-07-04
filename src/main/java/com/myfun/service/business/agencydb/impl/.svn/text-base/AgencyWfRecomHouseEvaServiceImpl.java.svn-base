package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfRecomHouseEvaMapper;
import com.myfun.repository.agencydb.po.AgencyWfRecomHouseEva;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfRecomHouseEvaService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 上午11:13:10 
 * 类说明 
*/
@Service
public class AgencyWfRecomHouseEvaServiceImpl extends AbstractService<AgencyWfRecomHouseEva, Integer>implements AgencyWfRecomHouseEvaService {
	@Autowired
	private AgencyWfRecomHouseEvaMapper agencyWfRecomHouseEvaMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyWfRecomHouseEvaMapper;
	}


}
