package com.myfun.service.business.admindb.impl;

import com.myfun.repository.admindb.dao.AdminFunBrandCityMapper;
import com.myfun.repository.admindb.dao.AdminFunExperienceAccountMapper;
import com.myfun.repository.admindb.dto.AdminFunBrandCityDto;
import com.myfun.repository.admindb.po.AdminFunBrandCity;
import com.myfun.repository.admindb.po.AdminFunExperienceAccount;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunBrandCityService;
import com.myfun.service.business.admindb.AdminFunExperienceAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static com.myfun.utils.DateTimeHelper.getTimeNow;


@Service
public class AdminFunExperienceAccountServiceImpl extends AbstractService<AdminFunExperienceAccount, Integer> implements AdminFunExperienceAccountService {
	@Autowired
	private AdminFunExperienceAccountMapper adminFunExperienceAccountMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunExperienceAccountMapper;
	}
	
	
	@Override
	public void updateLastLoginTime(String macAddr) {
		AdminFunExperienceAccount account= adminFunExperienceAccountMapper.getFunExperienceAccount(macAddr);
		// 不存在时插入，存在时更新最后登录时间
		if (account == null) {
			AdminFunExperienceAccount poInsert = new AdminFunExperienceAccount();
			poInsert.setMacaddr(macAddr);
			poInsert.setLastLoginTime(new Date());
			poInsert.setCreationTime(new Date());
			adminFunExperienceAccountMapper.insertSelective(poInsert);
		} else {
			adminFunExperienceAccountMapper.updateLastLoginTime(account.getId(),new Date());
		}
	
	}
}
