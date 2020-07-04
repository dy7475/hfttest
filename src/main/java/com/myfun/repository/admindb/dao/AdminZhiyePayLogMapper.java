package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminZhiyePayLog;
import com.myfun.repository.admindb.po.AdminZhiyePayLogExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminZhiyePayLogMapper extends BaseMapper<AdminZhiyePayLog, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminZhiyePayLogExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminZhiyePayLogExample example);

	/**
	 * @mbggenerated
	 */List<AdminZhiyePayLog> selectByExample(AdminZhiyePayLogExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminZhiyePayLog record,@Param("example") AdminZhiyePayLogExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminZhiyePayLog record,@Param("example") AdminZhiyePayLogExample example);
}