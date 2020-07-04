package com.myfun.service.business.agencydb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.agencydb.dao.AgencyVipQueueMapper;
import com.myfun.repository.agencydb.po.AgencyVipQueue;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyVipQueueService;

@Service
public class AgencyVipQueueServiceImpl extends AbstractService<AgencyVipQueue, Integer> implements AgencyVipQueueService {
	
	@Autowired
	private AgencyVipQueueMapper agencyVipQueueMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyVipQueueMapper;
	}
	
	@Override
	public PageInfo<AgencyVipQueue> queryAgencyVipQueueList(Integer cityId, Integer wxId , Integer pageNum ,Integer pageSize) throws Exception {
		PageHelper.startPage(pageNum, pageSize , false);
		AgencyVipQueue vipQueue = new AgencyVipQueue();
		vipQueue.setCityId(cityId);
		vipQueue.setWxId(wxId);
		List<AgencyVipQueue> tmps = agencyVipQueueMapper.queryVipQueueList(vipQueue);
		return new PageInfo<AgencyVipQueue>(tmps);
		
		
	}
}
