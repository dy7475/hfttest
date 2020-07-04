package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBiz;
import com.myfun.repository.erpdb.po.ErpFunAttendanceScopeBizExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceScopeBizMapper extends BaseMapper<ErpFunAttendanceScopeBiz, ErpFunAttendanceScopeBiz> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceScopeBizExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceScopeBizExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceScopeBiz> selectByExample(ErpFunAttendanceScopeBizExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceScopeBiz record,
			@Param("example") ErpFunAttendanceScopeBizExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceScopeBiz record,
			@Param("example") ErpFunAttendanceScopeBizExample example);

	/**
	 * 通过bizId和CompId更新
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/25
	 */
	void updateByUserId(ErpFunAttendanceScopeBiz erpFunAttendanceScopeBizPO);
}