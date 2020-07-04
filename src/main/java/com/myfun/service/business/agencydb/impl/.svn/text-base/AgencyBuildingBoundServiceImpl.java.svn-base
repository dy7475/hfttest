package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyBuildingBoundMapper;
import com.myfun.repository.agencydb.dao.AgencyBuildingCompMapper;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.agencydb.po.AgencyBuildingBound;
import com.myfun.repository.agencydb.po.AgencyBuildingBoundKey;
import com.myfun.repository.agencydb.po.AgencyBuildingComp;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBuildingBoundService;
import com.myfun.utils.StringUtil;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月11日 上午10:36:37 
 * 类说明 
*/
@Service
public class AgencyBuildingBoundServiceImpl extends AbstractService<AgencyBuildingBound, AgencyBuildingBoundKey>implements AgencyBuildingBoundService {
	@Autowired
	private AgencyBuildingBoundMapper agencyBuildingBoundMapper;
	@Autowired
	private AgencyBuildingCompMapper agencyBuildingCompMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBuildingBoundMapper;
	}

	@Override
	public List<SelectDto> getBuildingBoundList(Integer buildId, Integer cityId) {
		// 查询是否是全国投放
		List<AgencyBuildingBound> res =  agencyBuildingBoundMapper.getBuildingBoundList(buildId);
		Integer isAllCity = 0;
		//看看是不是全国投放
		if(null != res && res.size() == 1){
			AgencyBuildingBound agencyBuildingBound = res.get(0);
			if("0".equals(agencyBuildingBound.getCityId())){
				isAllCity = 1;
			}
		}			
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		paramMap.put("isAllCity", isAllCity);
		List<SelectDto> resList = agencyBuildingBoundMapper.getCityList(paramMap);
		return resList;
	}

	@Transactional
	@Override
	public Integer updateCityList(String cityIds, Integer buildId, Integer cityId, AdminCrmUser adminCrmUser) {
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		Integer count = agencyBuildingCompMapper.countComp(paramMap);
		Integer res = 0;
		if(count != 0){
			res = -1;
		}else {
			if(StringUtil.isNotBlank(cityIds)) {
				Date d = new Date();
				AgencyBuildingBound agencyBound = new AgencyBuildingBound();
				agencyBound.setbCityId(cityId.shortValue());
				agencyBound.setBuildId(buildId);
				agencyBound.setCrmUserId(adminCrmUser.getUserId());
				agencyBound.setDateLimit(d);
				agencyBound.setUpdateTime(d);
				String[] paramStr = cityIds.split(",");
				for (String cityIdStr : paramStr) {
					agencyBound.setCityId(new Short(cityIdStr));
					agencyBuildingBoundMapper.insertSelective(agencyBound);
				}
			}
			res = 1;
		}
		return res;
	}


}
