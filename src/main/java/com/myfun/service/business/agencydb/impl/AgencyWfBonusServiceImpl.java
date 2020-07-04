package com.myfun.service.business.agencydb.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWfBonusMapper;
import com.myfun.repository.agencydb.po.AgencyWfBonus;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWfBonusService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年6月21日 下午2:06:49 
 * 类说明 
*/
@Service
public class AgencyWfBonusServiceImpl extends AbstractService<AgencyWfBonus, Integer>implements AgencyWfBonusService {
	@Autowired
	private AgencyWfBonusMapper agencyWfBonusMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyWfBonusMapper;
	}


}
