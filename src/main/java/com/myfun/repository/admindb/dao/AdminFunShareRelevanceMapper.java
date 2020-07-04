package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunShareRelevance;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunShareRelevanceExample;

public interface AdminFunShareRelevanceMapper extends BaseMapper<AdminFunShareRelevance, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunShareRelevanceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunShareRelevanceExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminFunShareRelevance> selectByExample(AdminFunShareRelevanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminFunShareRelevance record,
			@Param("example") AdminFunShareRelevanceExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminFunShareRelevance record,
			@Param("example") AdminFunShareRelevanceExample example);

	/**
	 * 更新加盟圈
	 * @param shareRelevance
	 */
	void updateByShareCompNo(AdminFunShareRelevance shareRelevance);
	
	/**
	 * 获取指定加盟圈内所有的公司ID,FLAG = 1
	 */
	List<AdminFunShareRelevance> getCompIdsByShareId(@Param("shareId")Integer shareId);
}