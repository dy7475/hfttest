package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunProvince;
import com.myfun.repository.admindb.po.AdminFunProvinceExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface AdminFunProvinceMapper extends BaseMapper<AdminFunProvince, Short> {
	
	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunProvinceExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunProvinceExample example);

	/**
	 * @mbggenerated
	 */List<AdminFunProvince> selectByExample(AdminFunProvinceExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminFunProvince record,@Param("example") AdminFunProvinceExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminFunProvince record,@Param("example") AdminFunProvinceExample example);

	List<AdminFunProvince> selectByProvinceAll(String provinceName);
	
	/**
	 * 查询全部省份
	 * @return
	 */
	List<AdminFunProvince> getProvinceAll(@Param("proviceName")String proviceName);
	
	/**
	 * 根据省份ID获取省份
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/23
	 * @return 
	 * 
	 */
	AdminFunProvince getFunProviceById(@Param("provinceId") Integer provinceId);
}