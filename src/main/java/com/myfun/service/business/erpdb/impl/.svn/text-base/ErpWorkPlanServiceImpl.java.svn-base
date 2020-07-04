/**
 * @author 方李骥
 * @since 2016年9月19日
 */
package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.dao.ErpWorkPlanMapper;
import com.myfun.repository.erpdb.po.ErpWorkPlan;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpWorkPlanService;
import com.myfun.service.business.erpdb.bean.param.CreateOrUpdateWorkLogParam;
import com.myfun.utils.DateTimeHelper;

/**
 * @author 方李骥
 * @since 2016年9月19日
 */
@Service
public class ErpWorkPlanServiceImpl extends AbstractService<ErpWorkPlan, ErpWorkPlan> implements ErpWorkPlanService{
	@Autowired 
	private ErpWorkPlanMapper erpWorkPlanMapper;
	/**
	 * @author 方李骥
	 * @since 2016年9月19日
	 */
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpWorkPlanMapper;
	}
	@Transactional
	@Override
	public void insertByWorkLog(CreateOrUpdateWorkLogParam param) {
		//前端参数需要改一下
		String jsonStr = param.getPlanJson();
		List<ErpWorkPlan> workPlanList = JSON.parseArray(jsonStr,ErpWorkPlan.class);
		String timeNow = DateTimeHelper.formatDateTimetoString(new Date());
		// 写工作计划
		for(ErpWorkPlan workPlan:workPlanList){
			workPlan.setShardCityId(param.getCityId());
			workPlan.setWlId(param.getWlId());
			workPlan.setCreatorUid(param.getCurrentUserId());
			workPlan.setCreationTime(timeNow);
			workPlan.setCompId(param.getCompId());
			erpWorkPlanMapper.insertSelective(workPlan);
		}
	}
	/**
	 * 删除原有工作计划
	 */
	@Override
	public void deleteOldWorkPlan(Integer cityId, Integer wlId) {
		erpWorkPlanMapper.deleteOldWorkPlan(cityId, wlId);
	}
	

}
