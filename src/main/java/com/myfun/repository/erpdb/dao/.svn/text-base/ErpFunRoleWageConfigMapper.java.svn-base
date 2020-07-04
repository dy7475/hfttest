package com.myfun.repository.erpdb.dao;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.myfun.erpWeb.managecenter.sysmanager.vo.GetCompRoleCountWageVo;
import com.myfun.erpWeb.managecenter.sysmanager.vo.GetCompRoleWageInfoVo;
import com.myfun.repository.erpdb.dto.ErpCountWageTypeDto;
import com.myfun.repository.erpdb.dto.ErpFunRoleWageConfigDto;
import com.myfun.repository.erpdb.param.RoleWageConfigParam;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfigExample;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRoleWageConfigMapper extends BaseMapper<ErpFunRoleWageConfig, ErpFunRoleWageConfig> {

	/**
	 * @mbggenerated
	 */
	int countByExample(ErpFunRoleWageConfigExample example);

	/**
	 * @mbggenerated
	 */
	int deleteByExample(ErpFunRoleWageConfigExample example);

	/**
	 * @mbggenerated
	 */List<ErpFunRoleWageConfig> selectByExample(ErpFunRoleWageConfigExample example);

	/**
	 * @mbggenerated
	 */int updateByExampleSelective(@Param("record") ErpFunRoleWageConfig record,@Param("example") ErpFunRoleWageConfigExample example);

	/**
	 * @mbggenerated
	 */int updateByExample(@Param("record") ErpFunRoleWageConfig record,@Param("example") ErpFunRoleWageConfigExample example);

	/**
	 * 根据职级查询薪资配置
	 * 如果职级没有设置薪资配置，则查询默认配置
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年8月1日 下午2:07:31
	 */
	public ErpFunRoleWageConfigDto getRoleWageConfig(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("roleId") String roleId, @Param("roleLevelId") Integer roleLevelId, @Param("assessMentMonth") String assessMentMonth);

	public void updateBaseWageById(@Param("shardCityId")Integer cityId, @Param("param")  RoleWageConfigParam roleWageConfigParam);

	public List<ErpFunRoleWageConfig> getRoleWageConfigList(@Param("shardCityId")Integer cityId,  @Param("compId")Integer compId, @Param("userRoles")Set<String> userRoles,  @Param("startTime")Date startTime, @Param("endTime") Date endTime);

	public int countRelativeThisMonth(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId,@Param("wageTypeId") Integer wageTypeId, @Param("assessMentMonth")String assessMentMonth);

	/**
	 * 由角色ids获取薪资配置列表
	 * @param roleIdList 多个角色id
	 * @param assessMentMonth  薪资岳峰
	 * @param compId 公司ID
	 * @param cityId 城市ID
	 * @param isCheck 是否考核 0不考核 1考核  和是否作废一个意思
	 * @return
	 */
	List<ErpFunRoleWageConfig> selectFunRoleWageConfigListByRoleIdList(@Param("roleIds") List<String> roleIdList,@Param("month")String assessMentMonth,@Param("compId")Integer compId,
													                @Param("shardCityId")Integer cityId,@Param("isCheck")Byte isCheck);

	/**
	 * 查询公司所有角色在某月的薪资配置
	 * @author LI XIAO TONG
	 * @since 2019年8月28日 下午2:29:54
	 * @param cityId
	 * @param compId
	 * @param assessmentMonth
	 * @return
	 * Modified XXX Li Xiao Tong 2019年8月28日
	 */
	List<GetCompRoleWageInfoVo> getCompRoleWageInfo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("assessmentMonth") String assessmentMonth);

	/**
	 * 查询公司角色提成最低比例
	 * @author LI XIAO TONG
	 * @since 2019年8月28日 下午4:32:42
	 * @param cityId
	 * @param compId
	 * @param assessmentMonth
	 * @return
	 * Modified XXX Li Xiao Tong 2019年8月28日
	 */
	List<GetCompRoleCountWageVo> getCompRoleCountWage(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId,@Param("assessmentMonth") String assessmentMonth);
	
	/**
	 * 查询用户关联的提成比例数据
	 * 用于计算业绩提成
	 * 关联表：	FUN_COUNTWAGE
				FUN_WAGE_TYPE_NEW
				FUN_ROLE_WAGE_CONFIG
				ROLE_WAGETYPE_RELATIVE
				SALARY_TYPE_RELATIVE
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月4日 下午4:51:04
	 */
	List<ErpCountWageTypeDto> queryRoleWagetypeInfo(@Param("shardCityId")Integer cityId,@Param("compId") Integer compId, @Param("assessmentMonth") String assessmentMonth);
	
	/**
	 * 查询用户指定月份的薪资和提成配置数据
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年9月5日 下午5:11:58
	 */
	ErpFunRoleWageConfig selectRoleWageConfigByUserId(@Param("shardCityId")Integer cityId, @Param("compId")Integer compId, @Param("userId")Integer userId, @Param("assessMentMonth")String assessMentMonth);

	BigDecimal getRoleWageMaxPro(@Param("shardCityId")Integer cityId, @Param("compId") Integer compId, @Param("assessmentMonth") String assessmentMonth, @Param("userPosition") String userPosition);
}