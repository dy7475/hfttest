package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunHouseBidding;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunHouseBiddingExample;

public interface AdminFunHouseBiddingMapper extends BaseMapper<AdminFunHouseBidding, Integer> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */List<AdminFunHouseBidding> selectByExample(AdminFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminFunHouseBidding record,@Param("example") AdminFunHouseBiddingExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminFunHouseBidding record,@Param("example") AdminFunHouseBiddingExample example);

	void updateBiddingEndTimeToLastTime(@Param("archiveIds")List<Integer> archiveIds, @Param("toLastTime")String toLastTime, @Param("nowDate")String nowDate);
}