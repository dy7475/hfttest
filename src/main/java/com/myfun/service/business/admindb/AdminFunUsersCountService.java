package com.myfun.service.business.admindb;

import java.util.List;
import java.util.Map;

import com.myfun.repository.admindb.dto.AdminFunUsersCountDto;
import com.myfun.repository.admindb.po.AdminFunUsersCount;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunUsersCountService extends BaseMapper<AdminFunUsersCount, Integer> {

	Map<Integer, AdminFunUsersCountDto> getUserScorByArchiveIds(List<Integer> userIds);
	AdminFunUsersCountDto getUserScorByArchiveId(Integer archiveId);
	
	void addScore(Integer archiveId, Integer scoreType, Double score);
	
	AdminFunUsersCount createBycreateArchiveId(Integer archiveId);
}
