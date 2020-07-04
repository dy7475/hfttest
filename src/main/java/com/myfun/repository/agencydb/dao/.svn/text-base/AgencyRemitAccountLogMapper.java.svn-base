package com.myfun.repository.agencydb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyRemitAccountLog;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyRemitAccountLogMapper extends BaseMapper<AgencyRemitAccountLog, Integer> {
	/**
	 * 获取账户日志
	 * @param archiveId
	 * @param compFlag
	 * @return
	 */
	List<AgencyRemitAccountLog> getPaidedHistory(@Param("archiveId")String archiveId, @Param("compFlag")String compFlag);
}