package com.myfun.service.business.erpdb;

import java.util.Map;

import com.myfun.repository.erpdb.po.ErpBroadcast;
import com.myfun.repository.erpdb.po.ErpBroadcastKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpBroadcastService extends BaseMapper<ErpBroadcast, ErpBroadcastKey>{
	void insertBulletBroadcast(Integer cityId,Integer bulletId,Map<String, Object> pMap);
}
	