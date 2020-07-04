package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpTrackUsers;
import com.myfun.repository.erpdb.po.ErpTrackUsersKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpTrackUsersService extends BaseMapper<ErpTrackUsers, ErpTrackUsersKey> {

	public void createTargetUser(Integer trackId, Integer cityId, Integer compId, String userIds, String userNames, String deptNames);
}
