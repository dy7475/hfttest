package com.myfun.service.business.erpdb.impl;

import java.util.Map;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.myfun.repository.erpdb.dao.ErpBroadcastMapper;
import com.myfun.repository.erpdb.po.ErpBroadcast;
import com.myfun.repository.erpdb.po.ErpBroadcastKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBroadcastService;
import com.myfun.utils.StringUtil;

@Service
public class ErpBroadcastServiceImpl extends AbstractService<ErpBroadcast, ErpBroadcastKey> implements
ErpBroadcastService {
	@Autowired ErpBroadcastMapper erpBroadcastMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpBroadcastMapper;
	}
	
	@Override
	public void insertBulletBroadcast(Integer cityId, Integer bulletId, Map<String, Object> pMap) {
		Integer bound = StringUtil.parseInteger(pMap.get("bound"));
		Integer compId = StringUtil.parseInteger(pMap.get("compId"));
		Integer userId = StringUtil.parseInteger(pMap.get("userId"));
		Integer deptId = StringUtil.parseInteger(pMap.get("deptId"));
		erpBroadcastMapper.insertBulletBroadcast(cityId, compId, bulletId, bound, userId, deptId,false,null);
	}

}
