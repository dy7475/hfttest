package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunAttendanceScopeWifiMapper;
import com.myfun.repository.erpdb.param.ErpAttendanceScopeParam;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeWifi;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunAttendanceScopeWifiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;

@Service
public class ErpFunAttendanceScopeWifiServiceImpl extends AbstractService<ErpFunAttendanceScopeWifi, ErpFunAttendanceScopeWifi> implements ErpFunAttendanceScopeWifiService {
	@Autowired private ErpFunAttendanceScopeWifiMapper erpFunAttendanceScopeWifiMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunAttendanceScopeWifiMapper;
	}

	/**
	 * @Title
	 * @Author lcb
	 * @Date 2018/3/7
	 * @Param
	 **/
	@Override
	public Integer updateScopeWifiStatus(Integer cityId, Integer compId, ErpAttendanceScopeParam param) {

		ErpFunAttendanceScopeWifi erpFunAttendanceScopeWifi = new ErpFunAttendanceScopeWifi();

		erpFunAttendanceScopeWifi.setShardCityId(cityId);
		erpFunAttendanceScopeWifi.setWifiStatus(param.getWifiStatus());
		erpFunAttendanceScopeWifi.setId(param.getWifiId());
		erpFunAttendanceScopeWifi.setUpdateTime(new Date());
		return erpFunAttendanceScopeWifiMapper.updateByPrimaryKeySelective(erpFunAttendanceScopeWifi);
	}
}
