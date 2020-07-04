package com.myfun.repository.erpdb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunVoipLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunVoipLogMapper extends BaseMapper<ErpFunVoipLog, ErpFunVoipLog> {
	ErpFunVoipLog getErpFunVoipLogByCallId(@Param("shardConnId") String shardConnId, @Param("callId") String callId);
}