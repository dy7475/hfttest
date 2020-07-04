package com.myfun.repository.agencydb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.agencydb.po.AgencyWfUser;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AgencyWfUserMapper extends BaseMapper<AgencyWfUser, Integer> {
	
	/**
	 * 通过caseIds查询
	 * @author 何传强
	 * @since 2017年8月18日
	 * @param caseIds
	 * @return
	 */
	List<AgencyWfUser> getWfUserListByCaseIds(@Param("caseIds") Set<Integer> caseIds);
}