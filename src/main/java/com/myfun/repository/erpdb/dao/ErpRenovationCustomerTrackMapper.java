package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrack;
import com.myfun.repository.erpdb.po.ErpRenovationCustomerTrackExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ErpRenovationCustomerTrackMapper extends BaseMapper<ErpRenovationCustomerTrack, ErpRenovationCustomerTrack> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpRenovationCustomerTrackExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpRenovationCustomerTrackExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpRenovationCustomerTrack> selectByExample(ErpRenovationCustomerTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpRenovationCustomerTrack record,
			@Param("example") ErpRenovationCustomerTrackExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpRenovationCustomerTrack record,
			@Param("example") ErpRenovationCustomerTrackExample example);
}