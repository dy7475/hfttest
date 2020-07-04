package com.myfun.repository.erpdb.dao;

import com.myfun.repository.erpdb.po.ErpFunHousePublishStatus;
import com.myfun.repository.support.annotation.SwitchDB;
import com.myfun.repository.support.datasource.SwitchDBType;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import org.apache.ibatis.annotations.Param;

@SwitchDB(type = SwitchDBType.CITY_ID)
public interface ErpFunHousePublishStatusMapper extends BaseMapper<ErpFunHousePublishStatus, ErpFunHousePublishStatus> {
	/**
	 * 根据条件查询对象
	 * @param obj
	 * @return
	 */
	public ErpFunHousePublishStatus getDataObject(ErpFunHousePublishStatus obj);

	/**
	 * 通过archiveId更新
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/5/25
	 */	
	void updateByArchiveId(ErpFunHousePublishStatus funHousePublishStatusPO);

	Integer getQQPublishCount(@Param("shardCityId")Integer cityId, @Param("archiveId")Integer archiveId);
}