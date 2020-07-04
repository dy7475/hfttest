package com.myfun.repository.erpdb.dao;

import java.util.List;
import java.util.Map;

import com.myfun.repository.erpdb.dto.ErpFunSalaryTypeDto;
import org.apache.ibatis.annotations.Param;

import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelativeExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpSalaryTypeRelativeMapper extends BaseMapper<ErpSalaryTypeRelative, ErpSalaryTypeRelative> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpSalaryTypeRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpSalaryTypeRelativeExample example);

	/**
	 * @mbggenerated
	 */
	List<ErpSalaryTypeRelative> selectByExample(ErpSalaryTypeRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExampleSelective(@Param("record") ErpSalaryTypeRelative record,
			@Param("example") ErpSalaryTypeRelativeExample example);

	/**
	 * @mbggenerated
	 */
	int updateByExample(@Param("record") ErpSalaryTypeRelative record,
			@Param("example") ErpSalaryTypeRelativeExample example);

	/**
	 * 查询未删除的薪资配置
	 * @author 张宏利
	 * @since 2017年9月4日
	 * @param cityId
	 * @param userId
	 * @return
	 */
	Map<String, Object> getSalaryTypeAndNameByUserId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId);
	
	ErpSalaryTypeRelative getBySalaryTypeId(@Param("shardCityId") Integer cityId, @Param("userId") Integer userId,@Param("salaryTypeId") Integer salaryTypeId);
	
	List<Map<String,Object>> getUserProfitMoney(@Param("shardCityId")Integer cityId,@Param("param")Map<String, Object> param,@Param("userIdList") List<Integer> userIdList);
	
	/**
	 * 查询未删除的薪资配置
	 * @author 张宏利
	 * @since 2017年9月4日
	 * @param cityId
	 * @param userIds
	 * @return
	 */
	List<ErpSalaryTypeRelative> getSalaryTypeByUserIds(@Param("shardCityId")Integer cityId, @Param("userIds")Integer[] userIds);

	/**
	 * 根据salaryTypeId逻辑删除
	 * @author 臧铁
	 * @since 2017年9月4日
	 * @param erpSalaryTypeRelative
	 */
	void delSalaryTypeRelativeById(ErpSalaryTypeRelative erpSalaryTypeRelative);

	List<Map<String, Object>> getUserSalaryTypeList(@Param("shardCityId")Integer cityId, @Param("param")Map<String, Object> map);

	List<String> getUserSalaryTypeRoleList(@Param("shardCityId")Integer cityId,@Param("param") Map<String, Object> map);

	/**
	 * 查询薪资信息
	 *
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	ErpSalaryTypeRelative getSalaryRelativeData(@Param("shardCityId") Integer cityId,
			@Param("compId") Integer compId, @Param("userId") Integer userId,
			@Param("endTime")String endTime, @Param("startTime")String startTime);
	
	/**
	 * 查询薪资信息
	 *
	 * @author 张宏利
	 * @since 2018年4月25日
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param endTime
	 * @param startTime
	 * @return
	 */
	ErpSalaryTypeRelative getLastMonthSalaryRelativeData(@Param("shardCityId") Integer cityId,
			@Param("compId") Integer compId, @Param("userId") Integer userId,
			@Param("endTime")String endTime, @Param("startTime")String startTime);
	
	/**
	 * 是否有薪资方案
	 * @param
	 * @auther 胡坤
	 * @since 2018/4/24
	 * @return
	 *
	 */
	Integer getFunSalaryTypeRelativeByUserId(@Param("shardCityId") Integer cityId,@Param("userId") Integer userId);

	ErpFunSalaryTypeDto getLatestConfigureTime(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("userIds") List<Integer> userIds,@Param("creationTime") String creationTime);

	ErpFunSalaryTypeDto getSalaryTypeRelativeInfoOffUserId(@Param("shardCityId")Integer userId,@Param("compId") Integer compId,@Param("startDate") String startDate,@Param("endDate") String endDate);

	/**
	 * 批量创建薪资配置和用户的关联关系
	 * 当删除一个职级的薪资配置后，该职级薪资的所有用户都更新到使用角色下的基本薪资配置
	 * 
	 * 参考：ErpFunRoleWageConfigService.deleteWageRoleLevelAfterInitBase方法
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年8月6日 下午6:05:09
	 */
	void batCreateWageConfigForUsers(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("userIds") List<Integer> userIds, @Param("wageConfigId") Integer wageConfigId);
}

