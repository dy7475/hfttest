package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminPushMessage;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminPushMessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminPushMessageMapper extends BaseMapper<AdminPushMessage, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminPushMessageExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminPushMessageExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminPushMessage> selectByExample(AdminPushMessageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminPushMessage record,
			@Param("example") AdminPushMessageExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminPushMessage record, @Param("example") AdminPushMessageExample example);
}