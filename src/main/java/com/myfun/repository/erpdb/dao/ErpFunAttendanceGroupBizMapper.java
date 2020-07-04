package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBiz;
import com.myfun.repository.erpdb.po.ErpFunAttendanceGroupBizExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunAttendanceGroupBizMapper extends BaseMapper<ErpFunAttendanceGroupBiz, ErpFunAttendanceGroupBiz> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunAttendanceGroupBizExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunAttendanceGroupBizExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunAttendanceGroupBiz> selectByExample(ErpFunAttendanceGroupBizExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunAttendanceGroupBiz record,
			@Param("example") ErpFunAttendanceGroupBizExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunAttendanceGroupBiz record,
			@Param("example") ErpFunAttendanceGroupBizExample example);


	/**
	 * 通过bizId和compId更新
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/25
	 */
	void updateByBizIdAndCompId(ErpFunAttendanceGroupBiz erpFunAttendanceGroupBizPO);
}