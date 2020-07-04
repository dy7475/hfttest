package com.myfun.repository.admindb.dao;

import com.myfun.repository.admindb.po.AdminMobileKey;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminMobileKeyExample;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdminMobileKeyMapper extends BaseMapper<AdminMobileKey, Integer> {
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminMobileKeyExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminMobileKeyExample example);

	/**
	 * @mbggenerated
	 */
	List<AdminMobileKey> selectByExample(AdminMobileKeyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") AdminMobileKey record,
			@Param("example") AdminMobileKeyExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") AdminMobileKey record, @Param("example") AdminMobileKeyExample example);

	/**
	 * 阿萨sdfs第三方的搜搜
	 */
	public void sdfasf();

	void updateMobileKey(@Param("param")AdminMobileKey updateModel);

	List<AdminMobileKey> getCheckMobileDialToday(@Param("mobile")String mobile);

	void updateWrongTime(@Param("keyId") Integer keyId,@Param("wrongTime") Integer wrongTime);

	void updateStatus(@Param("keyId")Integer keyId);

	List<AdminMobileKey> getMobileKey(@Param("mobile") String mobile, @Param("date") Date minTime, @Param("errorCountInt") Integer errorCountInt);
}