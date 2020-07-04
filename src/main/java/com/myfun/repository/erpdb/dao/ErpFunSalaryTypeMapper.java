package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.dto.ErpFunSalaryTypeDto;
import com.myfun.repository.erpdb.param.ErpFunSalaryTypeParam;
import com.myfun.repository.erpdb.po.ErpFunSalaryType;
import com.myfun.repository.erpdb.po.ErpFunSalaryTypeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunSalaryTypeMapper extends BaseMapper<ErpFunSalaryType, ErpFunSalaryType> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunSalaryTypeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunSalaryTypeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpFunSalaryType> selectByExample(ErpFunSalaryTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpFunSalaryType record,
			@Param("example") ErpFunSalaryTypeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpFunSalaryType record, @Param("example") ErpFunSalaryTypeExample example);

	/**
	 * 查询工资方案列表
	 * @author 臧铁
	 * @since 2017年8月28日
	 * @param param
	 * @return
	 */
	List<ErpFunSalaryTypeDto> getSalaryType(ErpFunSalaryTypeParam param);

	/**
	 * 工资考核方案下拉列表查询
	 * @author 臧铁
	 * @since 2017年8月29日
	 * @param param id：主键id
	 * @return
	 */
	List<Map<String,Object>> getSalaryTypeNameList(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId);
	ErpFunSalaryType getSalaryTypeInfoByUserId(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId, @Param("compId") Integer compId,@Param("param") Map<String,Object> map);
	String getSalaryTypeTargetProfitByUserId(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId, @Param("compId") Integer compId);
	String getSalaryTypeId(@Param("shardCityId")Integer cityId,@Param("userId") Integer userId,@Param("compId") Integer compId,@Param("param") Map<String,Object> map);

	/**
	 * 工具方案名称统计数量（方案名称判重）
	 * @author 臧铁
	 * @since 2017年8月30日
	 * @param param  salaryTypeName：方案名称
	 * @return
	 */
	int countBySalaryTypeName(ErpFunSalaryTypeParam param);
	
	List<ErpFunSalaryType> getSalaryTypeByCompId(@Param("shardCityId")Integer cityId,@Param("compId")Integer compId);

	ErpFunSalaryType selectSalaryTypeByRoleId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("roleId")String roleId);
}