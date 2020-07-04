package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpDealTrack;
import com.myfun.repository.erpdb.po.ErpDealTrackExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpDealTrackMapper extends BaseMapper<ErpDealTrack, ErpDealTrack> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpDealTrack> selectByExample(ErpDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpDealTrack record, @Param("example") ErpDealTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpDealTrack record, @Param("example") ErpDealTrackExample example);
	@SwitchDB(type=SwitchDBType.DB_NAME)
	void insertList(@Param("shardDbName")String shardDbName,@Param("list") List<ErpDealTrack> dealTrackList);
}