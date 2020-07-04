package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpFunTrackExtend;
import com.myfun.repository.erpdb.po.ErpFunTrackExtendExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunTrackExtendMapper extends BaseMapper<ErpFunTrackExtend, ErpFunTrackExtend> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunTrackExtendExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunTrackExtendExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunTrackExtend> selectByExample(ErpFunTrackExtendExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunTrackExtend record,
			@Param("example") ErpFunTrackExtendExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunTrackExtend record, @Param("example") ErpFunTrackExtendExample example);

	List<ErpFunTrackExtend> selectByAuditId(@Param("shardCityId") Integer shardCityId, @Param("compId") Integer compId, @Param("auditId") Integer auditId);
	
	List<ErpFunTrackExtend> getFunTrackExtendListByTrackIds(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("trackIds") Set<Integer> trackIds);
}