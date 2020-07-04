package com.myfun.repository.erpdb.dao;

import com.myfun.erpWeb.managecenter.axn.param.BindLogListParam;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneBindHistory;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneBindHistoryExample;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpAliyunPhoneBindHistoryMapper extends BaseMapper<ErpAliyunPhoneBindHistory, ErpAliyunPhoneBindHistory> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpAliyunPhoneBindHistoryExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpAliyunPhoneBindHistoryExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpAliyunPhoneBindHistory> selectByExample(ErpAliyunPhoneBindHistoryExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpAliyunPhoneBindHistory record,
			@Param("example") ErpAliyunPhoneBindHistoryExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpAliyunPhoneBindHistory record,
			@Param("example") ErpAliyunPhoneBindHistoryExample example);
	
	List<ErpAliyunPhoneBindHistory> getAliyunPhoneBindHistory(@Param("shardCityId") Integer shardCityId, @Param("param") BindLogListParam param);
}