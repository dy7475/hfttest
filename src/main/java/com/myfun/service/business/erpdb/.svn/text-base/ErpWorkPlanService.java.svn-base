/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.service.business.erpdb;

import com.myfun.repository.erpdb.po.ErpWorkPlan;
import com.myfun.repository.support.mybatis.api.BaseMapper;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateWorkLogParam;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
public interface ErpWorkPlanService extends BaseMapper<ErpWorkPlan, ErpWorkPlan>{

	void insertByWorkLog(CreateOrUpdateWorkLogParam param);
	/**
	 * 删除原有工作计划
	 * @author 何传强
	 * @since 2017年6月15日
	 * @param cityId
	 * @param wlId
	 * @throws Exception
	 */
	void deleteOldWorkPlan(Integer cityId, Integer wlId);
}
