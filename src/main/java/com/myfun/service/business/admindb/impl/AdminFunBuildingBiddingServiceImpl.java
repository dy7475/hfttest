package com.myfun.service.business.admindb.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminFunBuildingBiddingMapper;
import com.myfun.repository.admindb.po.AdminFunBuildingBidding;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBuildingBiddingService;
@Service
public class AdminFunBuildingBiddingServiceImpl extends AbstractService<AdminFunBuildingBidding, Integer> implements AdminFunBuildingBiddingService{

	@Autowired
	AdminFunBuildingBiddingMapper adminFunBuildingBiddingMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunBuildingBiddingMapper;
	}

	
	public AdminFunBuildingBidding getBuildOwnerInfo(Integer cityId,Integer buildId) throws Exception{
		AdminFunBuildingBidding condition = new AdminFunBuildingBidding();
		condition.setCityId(cityId);
		condition.setBuildId(buildId);
		List<AdminFunBuildingBidding> resList = adminFunBuildingBiddingMapper.getFunBuildBiddingSuccInfo(condition);
		return resList.size() > 0 ? resList.get(0) : null;
		
	}
}
