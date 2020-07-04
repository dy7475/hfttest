package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dao.ErpFunWageTypeNewMapper;
import com.myfun.repository.erpdb.dao.ErpSalaryTypeRelativeMapper;
import com.myfun.repository.erpdb.dao.ErpWagetypeUserRelativeMapper;
import com.myfun.repository.erpdb.param.CreateOrUpdateUserSalaryPlanParam;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNew;
import com.myfun.repository.erpdb.po.ErpSalaryTypeRelative;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelative;
import com.myfun.repository.erpdb.po.ErpWagetypeUserRelativeExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBasewageService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpWagetypeUserRelativeService;
import com.myfun.utils.BeanUtilsHelper;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.StringUtil;
@Service
public class ErpWagetypeUserRelativeServiceImpl extends AbstractService<ErpWagetypeUserRelative, ErpWagetypeUserRelative> implements ErpWagetypeUserRelativeService{
	@Autowired ErpWagetypeUserRelativeMapper erpWagetypeUserRelativeMapper;
	@Autowired ErpFunBasewageService erpFunBasewageService;
	@Autowired ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpWagetypeUserRelativeMapper;
		
	}
	@Override
	public List<Map<String,Object>> getSalaryPlanByUserId(Integer cityId,
			Integer compId, Integer userId) {
		return erpWagetypeUserRelativeMapper.getSalaryPlanByUserId(cityId,compId,userId);
	}
	
	@Transactional
	@Override
	public void createSalaryTypeRelative(Integer salaryTypeId,ErpFunUsers erpFunUsers){
		ErpSalaryTypeRelative typeRelative = erpSalaryTypeRelativeMapper.getBySalaryTypeId(erpFunUsers.getCityId().intValue(), erpFunUsers.getUserId(), salaryTypeId);
		boolean isHaveRelative = false;
		if(typeRelative != null) {// 取出最后一条，如果是同一个月的则修改，否则新增一条新的
			Date dateNow = new Date();
			Date dateLast = typeRelative.getCreationTime();
			// 判断是否在同一个月
			if(dateNow.getYear() == dateLast.getYear() && dateNow.getMonth() == dateLast.getMonth()) {
				isHaveRelative = true;
			}
		}
		// 把之前的记录标记为删除
		if(typeRelative != null && (salaryTypeId == null || !isHaveRelative)) {
			Calendar calendar  = Calendar.getInstance();
			calendar.set(Calendar.DAY_OF_MONTH, 1);
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			ErpSalaryTypeRelative relative = new ErpSalaryTypeRelative();
			relative.setDelFlag(1);
			relative.setDelTime(calendar.getTime());
			relative.setId(typeRelative.getId());
			relative.setShardCityId(erpFunUsers.getCityId().intValue());
			erpSalaryTypeRelativeMapper.updateByPrimaryKeySelective(relative);
		}
		// 新分配的方案为空则返回
		if(salaryTypeId == null) {
			return;
		}
		ErpSalaryTypeRelative relative = new ErpSalaryTypeRelative();
		relative.setSalaryTypeId(salaryTypeId);
		relative.setCompId(erpFunUsers.getCompId());
		relative.setAreaId(erpFunUsers.getAreaId());
		relative.setRegId(erpFunUsers.getRegId());
		relative.setDeptId(erpFunUsers.getDeptId());
		relative.setGrId(erpFunUsers.getGrId());
		relative.setUserId(erpFunUsers.getUserId());
		relative.setRoleId(erpFunUsers.getUserPosition());
		relative.setCreationTime(new Date());
		relative.setShardCityId(erpFunUsers.getCityId().intValue());
		if(isHaveRelative) {
			relative.setId(typeRelative.getId());
			erpSalaryTypeRelativeMapper.updateByPrimaryKeySelective(relative);
		} else {
			erpSalaryTypeRelativeMapper.insertSelective(relative);
		}
	}
	
	/**
	 * 新增或者更新某一个人的薪资计划
	 * @throws Exception 
	 */
	@Transactional
	@Override
	public void insertOrUpdateUserSalaryPlan(Integer cityId, Integer compId, CreateOrUpdateUserSalaryPlanParam param, ErpFunUsers erpFunUsers) {
		this.createSalaryTypeRelative(param.getSalaryTypeId(), erpFunUsers);
		// 1.查询这个人已经关联的工资计划，按管理业绩类型+业绩类别，只能有一个提成方案
		List<Map<String, Object>> userWagetypeRelativeList = erpWagetypeUserRelativeMapper.getUserWageTypeRelativeMap(cityId, compId, param.getUserId());
		Set<String> relativeSet = new HashSet<>();
		if (userWagetypeRelativeList != null && !userWagetypeRelativeList.isEmpty()) {
			relativeSet = userWagetypeRelativeList.stream()
					.collect(Collectors.mapping(map -> String.valueOf(map.get("WAGE_TYPE_ID")), Collectors.toSet()));
		}
		// 1.更新基本薪资
		erpFunBasewageService.updateUserBasewage(cityId, compId, param.getUserId(), StringUtil.parseInteger(param.getBaseWage()));
		// 2.删除某一个人的薪资计划
		ErpWagetypeUserRelative inTotalWagetype = new ErpWagetypeUserRelative();
		inTotalWagetype.setShardCityId(cityId);
		inTotalWagetype.setCreateTime(new Date());
		inTotalWagetype.setUserId(param.getUserId());
		// 4.插入每一个人的薪资计划
		List<String> saveWageTypeIds = new ArrayList<String>();
		insertOnePlanForUser(param.getBusinessTotalId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getBusinessFinanceId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getBusinessLeaseId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getBusinessNewhouseId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getBusinessSecondhandId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getBusinessTransferId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageTotalId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageFinanceId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageLeaseId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageNewhouseId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageSecondhandId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		insertOnePlanForUser(param.getManageTransferId(), relativeSet, saveWageTypeIds, inTotalWagetype);
		// 删除不在这次关联范围内的这个人的提成方案
		ErpWagetypeUserRelativeExample delWageTypeUserExample = new ErpWagetypeUserRelativeExample();
		delWageTypeUserExample.setShardCityId(cityId);
		if (!saveWageTypeIds.isEmpty()) {
			delWageTypeUserExample.createCriteria().andUserIdEqualTo(param.getUserId()).andWageTypeIdNotIn(saveWageTypeIds);
		} else {// 和前端对的一个都没传就是清空，就直接删除这个人的所有方案
			delWageTypeUserExample.createCriteria().andUserIdEqualTo(param.getUserId());
		}
		erpWagetypeUserRelativeMapper.deleteByExample(delWageTypeUserExample);
	}
	
	private void insertOnePlanForUser(Integer wageTypeId, Set<String> relativeSet,
			List<String> saveWageTypeIds, ErpWagetypeUserRelative inTotalWagetype) {
		if (wageTypeId != null) {
			String id = wageTypeId.toString();
			saveWageTypeIds.add(id);
			if (!relativeSet.contains(id)) {
				inTotalWagetype.setWageTypeId(id);
				erpWagetypeUserRelativeMapper.insertSelective(inTotalWagetype);
			}
		}
	}
	
	@Override
	public List<Map<String, Object>> getOneSalaryPlanUserList(Integer cityId,
			Integer compId, BaseMapParam param) {
		Integer wageTypeId = param.getInteger("wagetypeId");
		Integer deptId = param.getInteger("deptId");
		String userRole = param.getString("userRole");
		Calendar calendar = Calendar.getInstance();
		String nowTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		return erpWagetypeUserRelativeMapper.getOneSalaryPlanUserList(cityId, compId, wageTypeId, deptId, userRole, startTime, nowTime);
	}
	
	@Transactional
	@Override
	public void saveOneSalaryPlanRelativeUser(Integer cityId, Integer compId,
			Integer wageTypeId,String royaltyRange,String salaryPlanUserJson,String delUsers) throws Exception {
		ErpFunWageTypeNew key = new ErpFunWageTypeNew();
		key.setShardCityId(cityId);
		key.setId(wageTypeId);
		ErpFunWageTypeNew erpFunWageTypeNew = erpFunWageTypeNewMapper.selectByPrimaryKey(key);
		//判断如果其他人已经修改了该薪资方案的提成范围之后，进行提示
		if(!royaltyRange.equals(erpFunWageTypeNew.getRoyaltyRange().toString())){
			throw new BusinessException("该薪资方案已经被其他人修改了提成范围，关闭之后，刷新列表之后重新配置！");
		}
		List<ErpWagetypeUserRelative> list = JSON.parseArray(salaryPlanUserJson, ErpWagetypeUserRelative.class);
		List<Map<String,Object>>  userWagetypeRelativeList = erpWagetypeUserRelativeMapper.getUserWageTypeRelativeAndManagePlanMap(cityId, compId, wageTypeId);
		Map<String,Object> userWagetypeRelativeMap = null;
		if(userWagetypeRelativeList!=null && !userWagetypeRelativeList.isEmpty()){
			userWagetypeRelativeMap = BeanUtilsHelper.listMapToKeyMapObject(userWagetypeRelativeList, "USER_ID");
		}
		if(StringUtils.isNotBlank(delUsers)){
			String[] delUserIds = delUsers.split(",");
			List<Integer> delIds = new ArrayList<Integer>();
			for(String delId:delUserIds){
				delIds.add(StringUtil.parseInteger(delId, 0));
			}
			ErpWagetypeUserRelativeExample delExample = new ErpWagetypeUserRelativeExample();
			delExample.setShardCityId(cityId);
			delExample.createCriteria().andWageTypeIdEqualTo(wageTypeId.toString()).andUserIdIn(delIds);
			erpWagetypeUserRelativeMapper.deleteByExample(delExample);
		}
		Date nowDate = new Date();
		//再狠狠的插入
		for(ErpWagetypeUserRelative userRelative:list){
			userRelative.setShardCityId(cityId);
			userRelative.setCreateTime(nowDate);
			userRelative.setWageTypeId(wageTypeId.toString());
			if(userRelative.getId()==null){
				if(userWagetypeRelativeMap!=null){
					if(userWagetypeRelativeMap.get(userRelative.getUserId().toString())!=null){
						Map<String,Object> userTypeMap = (Map<String, Object>) userWagetypeRelativeMap.get(userRelative.getUserId().toString());
						String plan = userTypeMap.get("MANAGE_PLAN").toString();
						String planName = "";
						if("0".equals(plan)){
							planName = "业务薪资方案";
						}else if("1".equals(plan)){
							planName= "管理薪资方案";
						}
						String info = erpFunUsersService.getUserInfoByUserId(cityId, userRelative.getUserId()).getUserName();
						throw new BusinessException(planName+"里已经为"+info+"分配了"+Const.PERFORMANCETYPENAME_MAP.get(erpFunWageTypeNew.getPerformanceType().toString())+"薪资方案！"); 
					}
				}
				erpWagetypeUserRelativeMapper.insertSelective(userRelative);
			}else{
				erpWagetypeUserRelativeMapper.updateByPrimaryKeySelective(userRelative);
			}
		}
	}
	
}
