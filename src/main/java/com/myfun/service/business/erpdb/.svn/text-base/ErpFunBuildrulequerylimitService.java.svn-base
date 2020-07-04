package com.myfun.service.business.erpdb;

import java.util.List;

import com.myfun.erpWeb.managecenter.buildData.param.FunBuildDataParam;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimit;
import com.myfun.repository.erpdb.po.ErpFunBuildrulequerylimittemp;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunBuildrulequerylimitService extends BaseMapper<ErpFunBuildrulequerylimit, ErpFunBuildrulequerylimit>{
	public List<ErpFunBuildrulequerylimittemp> addFunBuildrulequerylimitList(String shardDbName) throws Exception;
	
	/**
	 * 删除用户查看权限
	 * @author 朱科
	 * @since 2018年7月23日
	 * @return
	 */
	void deleteBuildrulequerylimits(Integer cityId, Integer compId, String limitIds);

	void setMgrUserViewRight(Integer cityId,Integer compId,Integer userId,String userName,String deptName,FunBuildDataParam param) throws Exception;
}
