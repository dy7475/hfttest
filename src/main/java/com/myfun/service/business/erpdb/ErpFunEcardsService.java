package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunEcards;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateErpFunEcardsParam;

public interface ErpFunEcardsService extends BaseMapper<ErpFunEcards, ErpFunEcards>{
	/**
	 * @throws Exception 
	* @Date:2016-9-24
	* @Athor:方李骥
	* @Title: insertErpFunEcards 
	* @Description: TODO(创建工作日志) 
	* @param param   
	* @return void    返回类型 
	* @throws
	 */
	public void insertErpFunEcards(CreateOrUpdateErpFunEcardsParam param) throws Exception;
	/**
	 * @throws Exception 
	 * @Date:2016-9-24
	 * @Athor:方李骥
	 * @Title: insertErpFunEcards 
	 * @Description: TODO(更新工作日志) 
	 * @param param   
	 * @return void    返回类型 
	 * @throws
	 */
	public void updateErpFunEcards(CreateOrUpdateErpFunEcardsParam param) throws Exception;
	
	public void insertEcards(ErpFunUsers erpFunUsers, ErpFunDepts erpFunDepts);
	
	public int updateCompAndRole(Integer archiveId, String deptName, String roleId, Integer compId, String roleName);
	
}
