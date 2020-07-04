package com.myfun.service.business.admindb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.admindb.dao.AdminFunUsersCountMapper;
import com.myfun.repository.admindb.dao.AdminScoreConfigMapper;
import com.myfun.repository.admindb.dto.AdminFunUsersCountDto;
import com.myfun.repository.admindb.po.AdminFunUsersCount;
import com.myfun.repository.admindb.po.AdminScoreConfig;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunUsersCountService;

@Service
public class AdminFunUsersCountServiceImpl extends AbstractService<AdminFunUsersCount, Integer> implements AdminFunUsersCountService {
	
	@Autowired
	private AdminFunUsersCountMapper adminFunUsersCountMapper;
	@Autowired
	private AdminScoreConfigMapper adminScoreConfigMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunUsersCountMapper;
	}

	@Override
	public Map<Integer, AdminFunUsersCountDto> getUserScorByArchiveIds(List<Integer> archiveIds) {
		List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(archiveIds.toArray(new Integer[archiveIds.size()]));
		Map<Integer, AdminFunUsersCountDto> map = new HashMap<Integer, AdminFunUsersCountDto>();
		for (AdminFunUsersCountDto adminFunUsersCount : list) {
			map.put(adminFunUsersCount.getArchiveId(), adminFunUsersCount);
		}
		return map;
	}

	@Override
	public AdminFunUsersCountDto getUserScorByArchiveId(Integer archiveId) {
		List<AdminFunUsersCountDto> list = adminFunUsersCountMapper.getUserScorByArchiveIds(new Integer[]{archiveId});
		if(list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public AdminFunUsersCount createBycreateArchiveId(Integer archiveId) {
		if(archiveId == null){
			return null;
		}
		AdminFunUsersCount funUsersCount = adminFunUsersCountMapper.selectByPrimaryKey(archiveId);
		if (funUsersCount == null) {
			funUsersCount = new AdminFunUsersCount();
			funUsersCount.setArchiveId(archiveId);
			funUsersCount.setUserSalePer(1.0);
			funUsersCount.setUserSaleScore(0.0);
			funUsersCount.setUserLeasePer(1.0);
			funUsersCount.setUserLeaseScore(0.0);
			funUsersCount.setUserUinfoPer(1.0);
			funUsersCount.setUserUinfoScore(0.0);
			funUsersCount.setUserPaidPer(1.0);
			funUsersCount.setUserPaidScore(0.0);
			funUsersCount.setUserPubPer(1.0);
			funUsersCount.setUserPubScore(0.0);
			adminFunUsersCountMapper.insertSelective(funUsersCount);
		}
		return funUsersCount;
	}

	@Transactional
	@Override
	public void addScore(Integer archiveId, Integer scoreType, Double score) {
		AdminFunUsersCount funUsersCount = this.createBycreateArchiveId(archiveId);
		
		AdminScoreConfig scoreConfig = adminScoreConfigMapper.selectByPrimaryKey(scoreType);
		if(scoreConfig.getPer() == 1) {
			score = score * scoreConfig.getScore();
		}
		AdminFunUsersCount updateSelective = new AdminFunUsersCount();
		updateSelective.setArchiveId(archiveId);
		if (scoreType < 4) {// --用户资料完善
			updateSelective.setUserUinfoScore(funUsersCount.getUserUinfoScore() + score);
		} else if (scoreType == 4) {// --消费积分
			updateSelective.setUserPaidScore(funUsersCount.getUserPaidScore() + score);
		} else if (scoreType > 4 && scoreType < 12) {
			if (score == 1) {
				updateSelective.setUserSaleScore(funUsersCount.getUserSaleScore() + score);
			} else if (score == 2) {
				updateSelective.setUserLeaseScore(funUsersCount.getUserLeaseScore() + score);
			}
		} else {
			updateSelective.setUserPubScore(funUsersCount.getUserPubScore() == null?0:funUsersCount.getUserPubScore() + score);
		}
		adminFunUsersCountMapper.updateByPrimaryKeySelective(updateSelective);
	}
}
