package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunDealTrack;
import com.myfun.repository.erpdb.po.ErpFunDealTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunDealTrackMapper extends BaseMapper<ErpFunDealTrack, ErpFunDealTrack> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunDealTrack> selectByExample(ErpFunDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunDealTrack record,
			@Param("example") ErpFunDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunDealTrack record, @Param("example") ErpFunDealTrackExample example);
}