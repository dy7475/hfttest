package com.myfun.service.business.erpdb;

import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.po.ErpIpCallLogRecord;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpIpCallLogRecordService extends BaseMapper<ErpIpCallLogRecord, ErpIpCallLogRecord>{
	
	public void insertHouseCallRecord(AdminIpCallLog adminIpCallLog);
}
