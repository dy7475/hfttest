package com.myfun.repository.admindb.dao;

import java.util.ArrayList;
import java.util.Map;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminDicDefinitions;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminDicDefinitionsMapper extends BaseMapper<AdminDicDefinitions, Integer> {
	/**
	 * 根据编码查询Text
	 * @param dicValue
	 * @return
	 */
	public  AdminDicDefinitions getMsg(@Param("dicType")String dicType, @Param("dicValue")String dicValue, @Param("cityId")String cityId);

	public AdminDicDefinitions getMsgS(@Param("cityId")String cityId, @Param("dicType")String dicType, @Param("dicValue")String dicValue);

	public ArrayList<SelectDto> getMsgList(@Param("cityId")String cityId, @Param("dicType")String dicType);
	/**
	 * You+提现
	 * @param dicType
	 * @auther 胡坤
	 * @since 2018/4/10
	 * @return 
	 * 
	 */
	@MapKey("DIC_TYPE")
	Map<String,AdminDicDefinitions> getDicDefMapByDicType(@Param("dicType") String dicType);
}