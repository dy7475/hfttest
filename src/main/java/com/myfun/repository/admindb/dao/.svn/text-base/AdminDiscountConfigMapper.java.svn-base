package com.myfun.repository.admindb.dao;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminDiscountConfig;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminDiscountConfigMapper extends BaseMapper<AdminDiscountConfig, Integer> {
	/**
	 * 获取折扣配置信息
	 * @param cityId
	 * @param type
	 * @return
	 */
	AdminDiscountConfig getConfigByCityAndType(@Param("cityId")Integer cityId, @Param("type")String type);
	
	/**
	 * 查询控件费
	 * @param cityLevel
	 * @param type
	 * @return
	 */
	AdminDiscountConfig getRecordByCityLevelAndType(@Param("cityLevel")Byte cityLevel, @Param("type")String type);
}