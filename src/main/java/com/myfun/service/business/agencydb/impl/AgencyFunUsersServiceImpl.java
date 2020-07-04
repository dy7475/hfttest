package com.myfun.service.business.agencydb.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.repository.agencydb.dao.AgencyFunUsersMapper;
import com.myfun.repository.agencydb.dto.AgencyFunUsersDto;
import com.myfun.repository.agencydb.param.AgencyFunUsersParam;
import com.myfun.repository.agencydb.po.AgencyFunUsers;
import com.myfun.repository.agencydb.po.AgencyFunUsersKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunUsersService;

@Service
public class AgencyFunUsersServiceImpl extends AbstractService<AgencyFunUsers, AgencyFunUsersKey>  implements AgencyFunUsersService {
	@Autowired
	private AgencyFunUsersMapper agencyFunUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunUsersMapper;
	}

	/**
	 * **/
	@Override
	public Integer checkMobile(String mobile) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("userMobile", mobile);
		AgencyFunUsers af = agencyFunUsersMapper.getFunUserByMobile(paramMap);
		return null != af ? 0 : 1;
	}

	@Override
	public AgencyFunUsers getFunUserByBuildIdAndCityId(Integer buildId, Integer cityId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cityId", cityId);
		paramMap.put("buildId", buildId);
		List<AgencyFunUsers> resList = agencyFunUsersMapper.getFunUserByBuildIdAndCityId(paramMap);
		if(null != resList && resList.size() > 0) {
			return resList.get(0);
		}
		return null;
	}

	/**
	 * 置业顾问
	 * **/
	@Override
	public PageInfo<AgencyFunUsersDto> getFunUserListByBuildIdAndCityId(AgencyFunUsersParam agencyFunUsersParam) {
		PageHelper.startPage(agencyFunUsersParam.getPageNum(), agencyFunUsersParam.getPageSize(), true);
		List<AgencyFunUsersDto> resList = agencyFunUsersMapper.getFunUserListByBuildIdAndCityId(agencyFunUsersParam);
		PageInfo<AgencyFunUsersDto> pageInfo = new PageInfo<>(resList);
		return pageInfo;
	}

	
	

}
