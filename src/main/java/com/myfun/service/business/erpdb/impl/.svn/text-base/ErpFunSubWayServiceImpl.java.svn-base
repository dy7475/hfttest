package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpFunSubwayMapper;
import com.myfun.repository.erpdb.po.ErpFunSubway;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunSubWayService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月30日 下午3:59:02 
 * 类说明 
*/
@Service
public class ErpFunSubWayServiceImpl extends AbstractService<ErpFunSubway, Integer>implements ErpFunSubWayService {
	@Autowired
	private ErpFunSubwayMapper erpFunSubwayMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper  = erpFunSubwayMapper;
	}

	@Override
	public List<ErpFunSubway> getSubwayList(String cityId) {
		return erpFunSubwayMapper.getSubwayList(cityId);
	}

	@Override
	public List<ErpFunSubway> getSubwayListByCityIdAndSubId(String cityId, String subIds) {
		return erpFunSubwayMapper.getSubwayListByCityIdAndSubId(cityId, subIds.split(","));
	}
	
}
