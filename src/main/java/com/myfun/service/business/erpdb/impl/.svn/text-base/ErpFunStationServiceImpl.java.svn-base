package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunStationMapper;
import com.myfun.repository.erpdb.po.ErpFunStation;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunStationService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月30日 下午4:12:13 
 * 类说明 
*/
@Service
public class ErpFunStationServiceImpl extends AbstractService<ErpFunStation, Integer>implements ErpFunStationService {
	@Autowired
	private ErpFunStationMapper erpFunStationMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunStationMapper;
	}

	@Override
	public List<ErpFunStation> getStationList(String cityId, String stationId) {
		return erpFunStationMapper.getStationList(cityId, stationId.split(","));
	}

	@Override
	public List<ErpFunStation> formatStation(String cityId, String stationIds) {
		return erpFunStationMapper.formatStation(cityId, stationIds.split(","));
	}

}
