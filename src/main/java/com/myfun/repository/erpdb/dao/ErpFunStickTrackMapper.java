package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunStickTrack;
import com.myfun.repository.erpdb.po.ErpFunStickTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpFunStickTrackMapper extends BaseMapper<ErpFunStickTrack, ErpFunStickTrack> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunStickTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunStickTrackExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunStickTrack> selectByExample(ErpFunStickTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunStickTrack record,
			@Param("example") ErpFunStickTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunStickTrack record, @Param("example") ErpFunStickTrackExample example);
}