package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunVoipLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CallParam;

public interface ErpFunVoipLogService extends BaseMapper<ErpFunVoipLog, ErpFunVoipLog> {
	public String call(CallParam param);

	ErpFunVoipLog getErpFunVoipLogByCallId(String shardConnId, String callId);
}
