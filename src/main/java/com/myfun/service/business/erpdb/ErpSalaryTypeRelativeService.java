package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.support.mybatis.api.BaseMapper;


public interface ErpSalaryTypeRelativeService extends BaseMapper<ErpSalaryTypeRelative, ErpSalaryTypeRelative>{
	
	/**
	 * 关联到人数据
	 * 用于关联用户与基本薪资配置的功能
	 * roleWageConfigId:FUN_ROLE_WAGE_CONFIG的主键
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年8月2日 上午11:31:38
	 */
	public void initUserBaseSalaryTypeRelative(Integer cityId, Integer compId, String roleId, Integer roleWageConfigId);
}
