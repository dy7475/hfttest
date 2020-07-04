package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.BestsignContractMapper;
import com.myfun.repository.erpdb.po.BestsignContract;
import com.myfun.service.business.erpdb.BestsignContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author 伍政康
 * @since 2019年12月20日
 */
@Service
public class BestsignContractServiceImpl implements BestsignContractService {
    @Autowired
    private BestsignContractMapper bestsignContractMapper;
	
	@Override
	public void addEntity(BestsignContract bestsignContract) {
		bestsignContractMapper.insert(bestsignContract);
	}

	@Override
	public void updateSignStateById(Integer cityId,String id) {
		Map<String, String> map =new HashMap<String, String>();
		map.put("id", id);
		map.put("shardCityId", String.valueOf(cityId));
		bestsignContractMapper.updateSignState(map);
	}
	
	

}
