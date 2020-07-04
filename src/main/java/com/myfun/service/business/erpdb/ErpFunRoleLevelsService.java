package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.managecenter.sysmanager.param.RoleLevelParam;
import com.myfun.repository.erpdb.po.ErpFunRoleLevels;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunRoleLevelsService extends BaseMapper<ErpFunRoleLevels, ErpFunRoleLevels>{
	
	/**
	 * 更新用户级别后的操作
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年7月29日 下午5:38:47
	 */
	public ErpFunRoleLevels updateRoleLevelInfo(Integer compId, Integer userId, Integer roleLevelId);
	
	/**
	 * 修改和添加角色职级数据
	 * @Package com.myfun.service.business.erpdb 
	 * @author 陈文超   
	 * @date 2019年7月30日 下午8:05:05
	 */
	public void addOrEditRoleLevelData(Integer cityId, Integer compId, String roleId, List<RoleLevelParam> roleLevelList);
}
