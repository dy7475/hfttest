package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpTrackUsersMapper;
import com.myfun.repository.erpdb.po.ErpTrackUsers;
import com.myfun.repository.erpdb.po.ErpTrackUsersKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpTrackUsersService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringHelper;
@Service
public class ErpTrackUsersServiceImpl extends AbstractService<ErpTrackUsers, ErpTrackUsersKey> implements ErpTrackUsersService{
	@Autowired ErpTrackUsersMapper erpTrackUsersMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpTrackUsersMapper;
	}

	@Transactional
	@Override
	public void createTargetUser(Integer trackId, Integer cityId, Integer compId, String userIds, String userNames, String deptNames) {
		deptNames = Optional.ofNullable(deptNames).orElse("");
		String[] userIdArr = StringHelper.split(userIds, ",");
		String[] userNameArr = StringHelper.split(userNames, ",");
		String[] deptNameArr = StringHelper.split(deptNames, ",");
		for (int i = 0; i < userIdArr.length; i++) {
			ErpTrackUsers erpTrackUsers = new ErpTrackUsers();
			erpTrackUsers.setTrackId(trackId);
			erpTrackUsers.setTrackTime(DateTimeHelper.formatDateTimetoString(new Date()));
			erpTrackUsers.setShardCityId(cityId);
			erpTrackUsers.setCompId(compId);
			erpTrackUsers.setUserId(Integer.valueOf(userIdArr[i]));
			if(deptNameArr != null && deptNameArr.length > i) {
				erpTrackUsers.setDeptName(deptNameArr[i]);
			}
			erpTrackUsers.setUserName(userNameArr[i]);
			erpTrackUsersMapper.insertSelective(erpTrackUsers);
		}
	}


}
