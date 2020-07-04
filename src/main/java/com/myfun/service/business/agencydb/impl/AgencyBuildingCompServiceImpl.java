package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.agencydb.dao.AgencyBuildingBoundMapper;
import com.myfun.repository.agencydb.dao.AgencyBuildingCompMapper;
import com.myfun.repository.agencydb.dto.AgencyCompListDto;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.agencydb.po.AgencyBuildingBoundKey;
import com.myfun.repository.agencydb.po.AgencyBuildingComp;
import com.myfun.repository.agencydb.po.AgencyBuildingCompKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBuildingCompService;
import com.myfun.utils.StringUtil;

@Service
public class AgencyBuildingCompServiceImpl extends AbstractService<AgencyBuildingComp, AgencyBuildingCompKey>implements AgencyBuildingCompService {
	@Autowired
	private AgencyBuildingCompMapper agencyBuildingCompMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AgencyBuildingBoundMapper agencyBuildingBoundMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBuildingCompMapper;
	}

	/**
	 * 查询公司列表(禁用)
	 * ***/
	@Override
	@Deprecated
	public List<AgencyCompListDto> getFunCompList(Integer buildId, Integer cityId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("cityId", cityId);
		paramMap.put("buildId", buildId);
		List<AgencyCompListDto> resList = agencyBuildingCompMapper.getCompList(paramMap);
		if(null != resList && resList.size() > 0) {
			for (AgencyCompListDto agencyCompListDto : resList) {
				AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(agencyCompListDto.getCompNo());
				if(null != adminFunComp) {
					agencyCompListDto.setCompName(adminFunComp.getCompName());
				}
			}
		}
		return resList;
	}

	@Override
	public AdminFunComp getCompListByCompNoAction(String compNo) {
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);
		return adminFunComp;
	}

	@Override
	public Integer updateComp(String compNos, Integer buildId, Integer cityId, AdminCrmUser adminCrmUser) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		Integer count = agencyBuildingCompMapper.countComp(paramMap);
		Integer res = 0;
		if(count != 0){
			res = -1;
		}else {
			if(StringUtil.isNotBlank(compNos)) {
				Date d = new Date();
				AgencyBuildingComp agencyBuildingComp = new AgencyBuildingComp();
				agencyBuildingComp.setbCityId(cityId.shortValue());
				agencyBuildingComp.setBuildId(buildId);
				agencyBuildingComp.setCrmUserId(adminCrmUser.getUserId());
				agencyBuildingComp.setDateLimit(d);
				agencyBuildingComp.setUpdateTime(d);
				String[] paramStr = compNos.split(",");
				for (String compNo : paramStr) {
					agencyBuildingComp.setCompNo(compNo);
					agencyBuildingCompMapper.insertSelective(agencyBuildingComp);
				}
			}
			res = 1;
		}
		return res;
	}

	@Override
	public List<AgencyCompListDto> getFunCityList(Integer buildId, Integer cityId) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		List<AgencyCompListDto> cityList = agencyBuildingBoundMapper.getSelectCityList(paramMap);
		if(null != cityList && cityList.size() > 0) {
			for (AgencyCompListDto agencyCompListDto : cityList) {
				AdminFunCity adminFunCity = adminFunCityMapper.selectByPrimaryKey(agencyCompListDto.getCityId().shortValue());
				if(null != adminFunCity) {
					agencyCompListDto.setCityName(adminFunCity.getCityName());
				}
			}
		}
		return cityList;
	}




	

}
