package com.myfun.service.business.admindb.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminVoteLogMapper;
import com.myfun.repository.admindb.dao.AdminVoteMapper;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminVote;
import com.myfun.repository.admindb.po.AdminVoteLog;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminVoteService;

/**
 * 投票
 * 
 * @author lcb
 *
 */
@Service
public class AdminVoteServiceImpl extends AbstractService<AdminVote, Integer> implements AdminVoteService {
	
	@Autowired
	private AdminVoteMapper adminVoteMapper;
	@Autowired
	private AdminVoteLogMapper adminVoteLogMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminVoteMapper;
	}

	@Transactional
	@Override
	public Integer updateVoteCount(Integer bulletId, String vids, Integer bound, AdminCrmUser adminCrmUser) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("bulletId", bulletId);
		paramMap.put("voteIds", vids);
		Integer res = adminVoteMapper.updateVoteCount(paramMap);
		updateVateLog(bound, bulletId, vids, adminCrmUser);
		return res;
	}
	
	private void updateVateLog(Integer bound, Integer bulletid, String vids, AdminCrmUser crmUser) {
		if(vids.contains(",")) {
			List<String> list = Arrays.asList(vids.split(","));
			for (String vid : list) {
				AdminVoteLog voteLog = new AdminVoteLog();
				voteLog.setVoteId(Integer.parseInt(vid));
				voteLog.setArchiveId(crmUser.getArchiveId());
				voteLog.setBulletId(bulletid);
				adminVoteLogMapper.insertSelective(voteLog);
			}
		}else{
			AdminVoteLog voteLog = new AdminVoteLog();
			voteLog.setVoteId(Integer.parseInt(vids));
			voteLog.setArchiveId(crmUser.getArchiveId());
			voteLog.setBulletId(bulletid);
			adminVoteLogMapper.insertSelective(voteLog);
			
		}
	}
	
}
