package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.sysmanager.param.DeleteGroupParam;
import com.myfun.erpWeb.managecenter.sysmanager.param.MoveUserToNewGroupParam;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.support.mybatis.api.BaseMapper;

public interface ErpFunDeptsGroupService extends BaseMapper<ErpFunDeptsgroup, ErpFunDeptsgroup> {

	/**
	 * 调分组
	 * @author 朱科
	 * @since 2018年4月28日
	 * @param param
	 */
	public Integer moveUserToNewGroup(MoveUserToNewGroupParam param);
	
	/**
	 * 删除分组
	 * @author 朱科
	 * @since 2018年4月28日
	 * @param param
	 */
	public void deleteGroup(DeleteGroupParam param);
	
	/**
	 * 清理分组信息
	 * @author 朱科
	 * @since 2018年4月28日
	 * @param erpFunDeptsgroup
	 */
	public void evictCacheableModelData(Integer compId,Integer cityId);
}
