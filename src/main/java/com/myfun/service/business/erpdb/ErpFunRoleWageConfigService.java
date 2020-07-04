package com.myfun.service.business.erpdb;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.myfun.repository.erpdb.dto.ErpFunRoleWageConfigDto;
import com.myfun.repository.erpdb.dto.WageCountTypePackDto;
import com.myfun.repository.erpdb.param.RoleWageConfigParam;
import com.myfun.repository.erpdb.po.ErpFunPerformanceType;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpFunRoleWageConfigService extends BaseMapper<ErpFunRoleWageConfig, ErpFunRoleWageConfig>{

	Integer updateRoleWageConfig(Integer adminCompId, Integer cityId, Integer compId, Integer updateRoleWageConfig, RoleWageConfigParam roleWageConfigParam);
	Integer updateRoleWageConfigNewOrg(Integer adminCompId, Integer cityId, Integer compId, Integer updateRoleWageConfig, RoleWageConfigParam roleWageConfigParam);

	/**
	 * 薪资配置保存并应用到其它角色
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @param userId 用户ID
	 * @param roleWageConfigParam 配置数据
	 * @return
	 */
	void salaryConfigApplyOtherRoles(Integer adminCompId, Integer cityId, Integer compId, Integer userId, RoleWageConfigParam roleWageConfigParam);

	/**
	 * 根据职级查询薪资配置
	 * 如果职级没有设置薪资配置，则查询默认配置
	 * @Package com.myfun.repository.erpdb.dao 
	 * @author 陈文超   
	 * @date 2019年8月1日 下午2:07:31
	 */
	public ErpFunRoleWageConfigDto getRoleWageConfigInfo(Integer cityId, Integer compId, String roleId, Integer roleLevelId, String assessMentMonth);

	/**
	 * 删除一个职级的薪资配置后恢复到基本薪资配置
	 * 
	 * baseWageConfigId:删除薪资配置后需要恢复的默认配置
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年8月6日 下午5:00:35
	 */
	public void deleteWageRoleLevelAfterInitBase(Integer oldWageConfigId, Integer baseWageConfigId, Integer compId, Integer cityId, String roleId, Integer roleLevelId);
	
	/**
	 * 获取用户的提成配置数据集合，funcountwage
	 * 该方法只使用通提方式
	 * 
	 * 关键对应关系：
	 * performanceId：WageCountTypePackDto
	 * 
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年9月5日 下午5:05:36
	 */
	public Map<Byte, WageCountTypePackDto> getUserFunCountWageType(Integer compId, Integer cityId, Integer userId, String assessMentMonth, Set<Integer> perosonPerformanceType);
}
