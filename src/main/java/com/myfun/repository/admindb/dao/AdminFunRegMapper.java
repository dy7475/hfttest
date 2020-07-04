package com.myfun.repository.admindb.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.admindb.po.AdminFunCity;
import com.myfun.repository.admindb.po.AdminFunReg;
import com.myfun.repository.agencydb.dto.SelectDto;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.repository.admindb.po.AdminFunRegExample;

public interface AdminFunRegMapper extends BaseMapper<AdminFunReg, Integer> {

	/**
	 * @mbggenerated
	 */
	int countByExample(AdminFunRegExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(AdminFunRegExample example);

	/**
	 * @mbggenerated
	 */List<AdminFunReg> selectByExample(AdminFunRegExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") AdminFunReg record,@Param("example") AdminFunRegExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") AdminFunReg record,@Param("example") AdminFunRegExample example);

	/**
	 * 根据城市和名称查询
	 * @param cityId
	 * @param regName
	 * @return
	 */
	List<SelectDto> selectByCityIdAndRegName(@Param("cityId") Integer cityId, @Param("regName") String regName);

	AdminFunReg selectByCityAndRegName(@Param("cityId") Integer cityId, @Param("regName")String hftRegName);
	
	/**
	 * 根据城市id,查询该城市下的所有区县(区县ID,区县名称)
	 * @author 何传强
	 * @since 2017年6月19日
	 * @param cityId
	 * @return
	 */
	List<AdminFunReg> getRegByCityId(@Param("cityId") Integer cityId);
	
	/**
	 * 区域列表
	 * @param 
	 * @auther 胡坤
	 * @since 2018/4/12
	 * @return 
	 */
	List<AdminFunReg> getFunRegList(@Param("serviceRegIds") List<Integer> serviceRegIds);
}