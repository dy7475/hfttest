package com.myfun.service.business.agencydb.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyFunRewardLogMapper;
import com.myfun.repository.agencydb.dto.AgencyFunRewardLogDto;
import com.myfun.repository.agencydb.po.AgencyFunRewardLog;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunRewardLogService;

/**
 * @TODO
 * @author lcb
 * @2016-9-19 上午11:00:25
 */

@Service
public class AgencyFunRewardLogServiceImpl extends AbstractService<AgencyFunRewardLog, Integer>implements AgencyFunRewardLogService {
	@Autowired
	AgencyFunRewardLogMapper agencyFunRewardLogMapper;
	@Autowired
	ErpFunUsersMapper funUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunRewardLogMapper;
	}

	/**
	 * @TODO 带看奖励记录列表查询
	 * @author lcb
	 * @2016-9-19 上午11:05:12
	 */
	@Override
	public PageInfo<AgencyFunRewardLogDto> getDistDaikanRewardsList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		if(null != pMap.get("startTime")) {
			pMap.put("startTime", pMap.get("startTime") + "00:00:00");
		}
		if(null != pMap.get("endTime")) {
			pMap.put("endTime", pMap.get("endTime") + "23:59:59");
		}
		List<String> rUserIdsList = new ArrayList<>();
		// 查询userId....
		if(null != pMap.get("areaId")) {
			rUserIdsList = funUsersMapper.getFunUserIds( param.getInteger("cityId"), pMap.get("areaId") + "", param.getInteger("compId"), null, null);
			if(null == rUserIdsList || rUserIdsList.size() == 0) {
				return new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		if(null != pMap.get("regId")) {
			rUserIdsList = funUsersMapper.getFunUserIds( param.getInteger("cityId"), null, param.getInteger("compId"), pMap.get("regId") + "",  null);
			if(null == rUserIdsList || rUserIdsList.size() == 0) {
				return new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		if(null != pMap.get("grId")) {
			rUserIdsList = funUsersMapper.getFunUserIds( param.getInteger("cityId"), null, param.getInteger("compId"), null, pMap.get("grId") + "");
			if(null == rUserIdsList || rUserIdsList.size() == 0) {
				return new PageInfo<>(new ArrayList<AgencyFunRewardLogDto>());
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyFunRewardLogDto> resList = agencyFunRewardLogMapper.getDistDaikanRewardsList(pMap);
		return new PageInfo<>(resList);
	}


	
}
