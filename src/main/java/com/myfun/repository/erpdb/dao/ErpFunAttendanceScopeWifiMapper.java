package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeWifi;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeWifiExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceScopeWifiMapper extends BaseMapper<ErpFunAttendanceScopeWifi, ErpFunAttendanceScopeWifi> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceScopeWifiExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceScopeWifiExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceScopeWifi> selectByExample(ErpFunAttendanceScopeWifiExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceScopeWifi record,
			@Param("example") ErpFunAttendanceScopeWifiExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceScopeWifi record,
			@Param("example") ErpFunAttendanceScopeWifiExample example);
}