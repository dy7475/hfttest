 package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;

import com.myfun.utils.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.repository.erpdb.dao.ErpFunCountwageMapper;
import com.myfun.repository.erpdb.dao.ErpFunWageTypeNewMapper;
import com.myfun.repository.erpdb.dao.ErpWagetypeUserRelativeMapper;
import com.myfun.repository.erpdb.param.CreateOrUpdateWageTypeNewParam;
import com.myfun.repository.erpdb.po.ErpFunCountwage;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelativeExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunWageTypeNewService;
import com.myfun.utils.DateTimeHelper;
@Service
public class ErpFunWageTypeNewServiceImpl extends AbstractService<ErpFunWageTypeNew, ErpFunWageTypeNew> implements ErpFunWageTypeNewService {
	@Autowired private ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired private ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired private ErpWagetypeUserRelativeMapper erpWagetypeUserRelativeMapper;
	@PostConstruct
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunWageTypeNewMapper;
	}
	
	@Transactional
	@Override
	public void insertOrUpdateWageType(CreateOrUpdateWageTypeNewParam param) throws Exception {
		Set<Integer> wagecountIds = new HashSet<Integer>();
		Integer wageTypeId = param.getId();
		//1更新
		if(param.getId()!=null){
			ErpFunWageTypeNew key = new ErpFunWageTypeNew();
			key.setShardCityId(param.getCityId());
			key.setId(param.getId());
			ErpFunWageTypeNew erpFunWageTypeNew = erpFunWageTypeNewMapper.selectByPrimaryKey(key);
			//如果是管理业绩类的提成方案，那么如果提成范围修改以后，已经分配的员工关系应该要删除了
			if(erpFunWageTypeNew!=null){
				if("1".equals(erpFunWageTypeNew.getManagePlan().toString())&&"1".equals(param.getManagePlan().toString())&&!param.getRoyaltyRange().toString().equals(erpFunWageTypeNew.getRoyaltyRange().toString())){
					ErpWagetypeUserRelativeExample delExample = new ErpWagetypeUserRelativeExample();
					delExample.setShardCityId(param.getCityId());
					delExample.createCriteria().andWageTypeIdEqualTo(param.getId().toString());
					erpWagetypeUserRelativeMapper.deleteByExample(delExample);
				}
			}
			ErpFunWageTypeNew inErpFunWageTypeNew = new ErpFunWageTypeNew();
			BeanUtils.copyProperties(param, inErpFunWageTypeNew);
			inErpFunWageTypeNew.setCompId(param.getCompId());
			inErpFunWageTypeNew.setDeptId(param.getDeptId());
			inErpFunWageTypeNew.setCreateDate(DateTimeHelper.formatDateTimetoString(new Date()));
			inErpFunWageTypeNew.setShardCityId(param.getCityId());
			if(!erpFunWageTypeNew.getManagePlan().toString().equals(param.getManagePlan().toString())){
				ErpWagetypeUserRelativeExample delExample = new ErpWagetypeUserRelativeExample();
				delExample.setShardCityId(param.getCityId());
				delExample.createCriteria().andWageTypeIdEqualTo(param.getId().toString());
				erpWagetypeUserRelativeMapper.deleteByExample(delExample);
				//改为业绩
				if("1".equals(erpFunWageTypeNew.getManagePlan().toString())){
					erpFunWageTypeNewMapper.clearManagePlanInfo(param.getCityId(),inErpFunWageTypeNew);
				}else{
					erpFunWageTypeNewMapper.updateByPrimaryKeySelective(inErpFunWageTypeNew);
				}
			}else{
				erpFunWageTypeNewMapper.updateByPrimaryKeySelective(inErpFunWageTypeNew);
			}
			if(!StringUtils.isBlank(param.getCountWageJson())){
				List<ErpFunCountwage> countWagelist = JSON.parseArray(param.getCountWageJson(), ErpFunCountwage.class); 
				for(ErpFunCountwage inErpFunCountwage:countWagelist){
					inErpFunCountwage.setCompId(param.getCompId());
					inErpFunCountwage.setShardCityId(param.getCityId());
					inErpFunCountwage.setWagetypeId(inErpFunWageTypeNew.getId());
					if(inErpFunCountwage.getWagecountId()==null){
						inErpFunCountwage.setDeptId(param.getDeptId());
						erpFunCountwageMapper.insertSelective(inErpFunCountwage);
					}else{
						erpFunCountwageMapper.updateByPrimaryKeySelective(inErpFunCountwage);
					}
					wagecountIds.add(inErpFunCountwage.getWagecountId());
				}
			}
		}else{
			//新增
			ErpFunWageTypeNew upErpFunWageTypeNew = new ErpFunWageTypeNew();
			BeanUtils.copyProperties(param, upErpFunWageTypeNew);
			upErpFunWageTypeNew.setCompId(param.getCompId());
			upErpFunWageTypeNew.setShardCityId(param.getCityId());
			upErpFunWageTypeNew.setCreateDate(DateUtil.DateToString(new Date()));
			erpFunWageTypeNewMapper.insertSelective(upErpFunWageTypeNew);
			wageTypeId = upErpFunWageTypeNew.getId();
			if(!StringUtils.isBlank(param.getCountWageJson())){
				List<ErpFunCountwage> countWagelist = JSON.parseArray(param.getCountWageJson(), ErpFunCountwage.class); 
				for(ErpFunCountwage inErpFunCountwage:countWagelist){
					inErpFunCountwage.setShardCityId(param.getCityId());
					inErpFunCountwage.setWagetypeId(upErpFunWageTypeNew.getId());
					inErpFunCountwage.setCompId(param.getCompId());
					inErpFunCountwage.setDeptId(param.getDeptId());
					erpFunCountwageMapper.insertSelective(inErpFunCountwage);
					wagecountIds.add(inErpFunCountwage.getWagecountId());
				}
			
			}else{
				//理论上来讲是都有算法的，所以应该不会全部删除
				erpFunCountwageMapper.delFunCountwageByWageTypeId(param.getCityId(), param.getCompId(), upErpFunWageTypeNew.getWagetypeId());
			}
		}
		//删除掉的提成算法
		if(!wagecountIds.isEmpty()){
			erpFunCountwageMapper.delFunCountwageNotInwageCountIds(param.getCityId(), param.getCompId(), wageTypeId, wagecountIds);
		}
	}
	
	/**
	 * 获取提成方案详情
	 */
	@Override
	public Map<String, Object> getWageTypeDetail(Integer cityId, Integer compId, Integer wagetypeId) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ErpFunWageTypeNew key = new ErpFunWageTypeNew();
		key.setShardCityId(cityId);
		key.setId(wagetypeId);
		ErpFunWageTypeNew erpFunWageTypeNew = erpFunWageTypeNewMapper.selectByPrimaryKey(key);
		List<ErpFunWageTypeNew> wageTypeNewlist = new ArrayList<ErpFunWageTypeNew>();
		wageTypeNewlist.add(erpFunWageTypeNew);
		resultMap.put("wageType", wageTypeNewlist);
		List<ErpFunCountwage> countWageList = erpFunCountwageMapper.selectFunCountWageListByWageTypeId(cityId, compId, wagetypeId);
		resultMap.put("countList", countWageList);
		return resultMap;
	}
	
	/**
	 * 获取公司的某一种提成方案
	 */
	@Override
	public List<ErpFunWageTypeNew> getSalaryPlanByComp(
			Integer cityId, Integer compId) {
		List<ErpFunWageTypeNew> list = erpFunWageTypeNewMapper.getSalaryPlanByComp(cityId,compId);
		return list;
	}
	
	/**
	 * 获取某一个员工的提成方案
	 */
	@Override
	public List<ErpFunWageTypeNew> getSalaryPlanByUserId(Integer cityId,
			Integer compId, Integer userId) {
		List<ErpFunWageTypeNew> list = erpFunWageTypeNewMapper.getSalaryPlanByUserId(cityId, compId, userId);
		return list;
	}
	
	/**
	 * 获取每一种分类下的提成员工
	 *//*
	@Override
	public Map<String,List<ErpFunWageTypeNew>> getSalaryPlanGroupByPerformanceType(Integer cityId,
			Integer compId) {
		List<ErpFunWageTypeNew> list = erpFunWageTypeNewMapper.getSalaryPlanByUserId(cityId, compId, userId);
		return list;
	}*/
}
