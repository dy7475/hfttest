package com.myfun.service.business.admindb.impl;/**
 * Created by hukun on 2018/4/11.
 */

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunBuildAttentionMapper;
import com.myfun.repository.admindb.po.AdminFunBuildAttention;
import com.myfun.repository.admindb.po.AdminFunBuildAttentionKey;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBuildAttentionService;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;


@Service
public class AdminFunBuildAttentionServiceImpl extends AbstractService<AdminFunBuildAttention, AdminFunBuildAttentionKey> implements AdminFunBuildAttentionService {
	
	@Autowired
	AdminFunBuildAttentionMapper adminFunBuildAttentionMapper;
	@Autowired
	AdminFunBuildAttentionService adminFunBuildAttentionService;
	
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunBuildAttentionMapper;
	}
	
	@Override
	public int countData(String newBuildId, Integer cityId, Integer archiveId) {
		int buildCounr=adminFunBuildAttentionMapper.count(cityId,archiveId,newBuildId);
		return buildCounr;
	}

	@Override
	public void createBuildAttention(Integer cityId, Integer archiveId, String oldBuildId, String newBuildId, String newBuildName) {
		adminFunBuildAttentionMapper.delete(cityId,archiveId,oldBuildId);
		int buildCounr = adminFunBuildAttentionMapper.count(cityId,archiveId,null);
		if(buildCounr >= Const.MAX_BIDDING_NUM){
			throw new BusinessException("每个人最多只能关注" + Const.MAX_BIDDING_NUM + "个小区！");
		}
		buildCounr = adminFunBuildAttentionMapper.count(cityId,archiveId,newBuildId);
		AdminFunBuildAttention adminFunBuildAttention=new AdminFunBuildAttention();
		adminFunBuildAttention.setArchiveId(archiveId);
		adminFunBuildAttention.setCityId(cityId);
		adminFunBuildAttention.setBuildName(newBuildName);
		adminFunBuildAttention.setBuildId(StringUtil.paseInteger(newBuildId));
		if(buildCounr == 0){
			adminFunBuildAttentionMapper.insertSelective(adminFunBuildAttention);
		}
		if(buildCounr > 0){
			throw new BusinessException("该小区您已经关注，请更换！");
		}
	}


}
