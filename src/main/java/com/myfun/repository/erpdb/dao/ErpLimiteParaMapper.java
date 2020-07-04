package com.myfun.repository.erpdb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpLimitePara;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpLimiteParaMapper extends BaseMapper<ErpLimitePara, ErpLimitePara> {

	
	int selectRecordCount(@Param("shardCityId") Short cityId, @Param("archiveId") Integer archiveId);
}