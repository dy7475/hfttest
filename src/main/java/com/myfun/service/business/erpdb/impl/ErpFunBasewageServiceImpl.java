 package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.utils.DateUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.myfun.framework.exception.ConfirmException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.erpdb.dto.ErpFunBasewageDto;
import com.myfun.repository.erpdb.dto.ErpWagetypeUserRelativeDto;
import com.myfun.repository.erpdb.param.SaveSalaryPlanRelativeUserParam;
import com.myfun.repository.erpdb.po.ErpFunWageTypeNewExample.Criteria;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBasewageService;
import com.myfun.service.business.erpdb.ErpWagetypeUserRelativeService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.SortUtil;
import com.myfun.utils.SystemOperateUtil;

@Service
public class ErpFunBasewageServiceImpl extends AbstractService<ErpFunBasewage, ErpFunBasewage> implements ErpFunBasewageService{
	
	@Autowired private ErpFunSalaryTypeMapper erpFunSalaryTypeMapper;
	@Autowired private ErpFunBasewageMapper erpFunBasewageMapper;
	@Autowired private ErpWagetypeUserRelativeMapper erpWagetypeUserRelativeMapper;
	@Autowired private ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired private ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired private ErpWagetypeUserRelativeService erpWagetypeUserRelativeService;
	@Autowired private ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired private ErpRoleWagetypeRelativeMapper erpRoleWagetypeRelativeMapper;
	@Autowired private ErpSystemSettingLogsMapper erpSystemSettingLogsMapper;
	@Autowired private ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired private ErpSysParaMapper erpSysParaMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunBasewageMapper;
	}

	@Override
	public void creatBasewage(ErpFunUsers erpFunUsers) {
		ErpFunBasewage insertModel = new ErpFunBasewage();
		insertModel.setShardCityId(erpFunUsers.getCityId().intValue());
		insertModel.setUserId(erpFunUsers.getUserId());
		insertModel.setDeptId(erpFunUsers.getDeptId());
		insertModel.setCompId(erpFunUsers.getCompId());
		insertModel.setBaseMoney(0);
		erpFunBasewageMapper.insertSelective(insertModel);
	}
	
	@Override
	public List<ErpWagetypeUserRelativeDto> getSalarySchemeUserList(Integer cityId, Integer wageTypeId) {
		List<ErpWagetypeUserRelativeDto> relativeDtoList = erpWagetypeUserRelativeMapper.getUserWageTypeList(cityId, null, wageTypeId);
		return relativeDtoList;
	}
	
	@Transactional
	@Override
	public void deleteSalaryScheme(Integer cityId, Integer compId, Integer wageTypeId) {
		// FUN_COUNTWAGE  WAGETYPE_USER_RELATIVE
//		ErpWagetypeUserRelativeExample example = new ErpWagetypeUserRelativeExample();
//		example.createCriteria().andWageTypeIdEqualTo(String.valueOf(wageTypeId));
//		example.setShardCityId(cityId);
//		int count = erpWagetypeUserRelativeMapper.countByExample(example);
//		if(count > 0) {
//			throw new ConfirmException("薪资方案已经被使用，不能删除");
//		}
//		count = erpRoleWagetypeRelativeMapper.countIsUseByWageTypeId(cityId,compId,wageTypeId);
//		if(count > 0) {
//			throw new ConfirmException("薪资方案已经被应用到角色，不能删除");
//		}

		String wageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(wageAccountingDay, 0);
		// 查询本月是否再用
		Integer count = erpFunRoleWageConfigMapper.countRelativeThisMonth(cityId, compId, wageTypeId, assessMentMonth);
		if(count > 0) {
			throw new ConfirmException("薪资方案已经被使用，不能删除");
		}



		// 没有被使用，直接删除该条记录
		ErpFunWageTypeNewExample delRecord = new ErpFunWageTypeNewExample();
		delRecord.createCriteria().andCompIdEqualTo(compId).andIdEqualTo(wageTypeId);
		delRecord.setShardCityId(cityId);
		int deleteCount = erpFunWageTypeNewMapper.deleteByExample(delRecord);
		if(deleteCount <= 0) {
			throw new ConfirmException("薪资方案不存在，删除失败");
		}
		// 删除配置
		ErpFunCountwageExample countwageExample = new ErpFunCountwageExample();
		countwageExample.createCriteria().andWagetypeIdEqualTo(wageTypeId);
		countwageExample.setShardCityId(cityId);
		erpFunCountwageMapper.deleteByExample(countwageExample);
	}
	
	@Override
	public List<ErpFunWageTypeNew> getSalarySchemeListByType(BaseMapParam param) {
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		Integer performanceType = param.getInteger("performanceType");
//		Integer wageTypeId = param.getInteger("wageTypeId");
		String wageTypeName = param.getString("wageTypeName");
		ErpFunWageTypeNewExample example = new ErpFunWageTypeNewExample();
		Criteria criteria = example.createCriteria().andCompIdEqualTo(compId);
		if(performanceType != null) {
			criteria.andPerformanceTypeEqualTo(performanceType.byteValue());
		}
//		if(wageTypeId != null) {
//			criteria.andIdEqualTo(wageTypeId);
//		}
		if (null != wageTypeName) {
			criteria.andWageTypeNameLike("%"+wageTypeName+"%");
		}
		example.setShardCityId(cityId);
		example.setOrderByClause("WAGE_TYPE_NAME asc,PERFORMANCE_TYPE asc");
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<ErpFunWageTypeNew> wageTypeList = erpFunWageTypeNewMapper.selectByExample(example);
		return wageTypeList;
	}
	
	@Override
	public List<ErpFunBasewageDto> getSalarySchemeListByUser(BaseMapParam param) {
		Integer cityId = param.getInteger("cityId");
		Integer compId = param.getInteger("compId");
		Integer deptId = param.getInteger("deptId");
		Integer userId = param.getInteger("userId");
		String roleId = param.getString("roleId");
		// 获取基本薪资
		String startTime = DateTimeHelper.formatDatetoString(new Date());
		List<ErpFunBasewageDto> funBasewageList = erpFunBasewageMapper.getUserBasewage(cityId, compId, deptId, userId, startTime ,roleId);
		// 获取到业绩类别
		Set<Integer> userIdSet = funBasewageList.stream().collect(Collectors.mapping(ErpFunBasewageDto::getUserId, Collectors.toSet()));
		Integer[] userIds = userIdSet.toArray(new Integer[]{});
		// 获取薪资考核方案
		List<ErpSalaryTypeRelative> salaryTypeList = erpSalaryTypeRelativeMapper.getSalaryTypeByUserIds(cityId, userIds);
		Map<Integer, ErpSalaryTypeRelative> salaryTypeMap = salaryTypeList.stream().collect(Collectors.toMap(ErpSalaryTypeRelative::getUserId, val -> val));
		
		List<ErpWagetypeUserRelativeDto> relativeDtoList = erpWagetypeUserRelativeMapper.getUserWageTypeList(cityId, userIds, null);
		Map<Integer, List<ErpWagetypeUserRelativeDto>> relativeDtoMap = relativeDtoList.stream().collect(Collectors.groupingBy(ErpWagetypeUserRelativeDto::getUserId));
		// 依据类型设置佣金类型中文
		for (ErpFunBasewageDto erpFunBasewageDto : funBasewageList) {
			List<ErpWagetypeUserRelativeDto> userRelativeDtoList = relativeDtoMap.get(erpFunBasewageDto.getUserId());
			if(userRelativeDtoList != null) {
				for (ErpWagetypeUserRelativeDto userRelativeDto : userRelativeDtoList) {
					setPerformance(erpFunBasewageDto, userRelativeDto);
				}
			}
			// 设置薪资考核方案
			ErpSalaryTypeRelative salaryTypeRelative = salaryTypeMap.get(erpFunBasewageDto.getUserId());
			if(salaryTypeRelative != null) {
				erpFunBasewageDto.setSalaryTypeId(salaryTypeRelative.getSalaryTypeId());
			}
		}
		SortUtil.collectionsSort(funBasewageList, new String[]{"deptId", "userId"}, true);
		return funBasewageList;
	}
	
	/**
	 * 依据类型设置佣金类型中文
	 * @author 张宏利
	 * @since 2017年5月16日
	 * @param erpFunBasewageDto
	 * @param userRelativeDto
	 */
	private void setPerformance(ErpFunBasewageDto erpFunBasewageDto, ErpWagetypeUserRelativeDto userRelativeDto){
		if(erpFunBasewageDto == null || userRelativeDto == null) {
			return;
		}
		String wageTypeName = userRelativeDto.getWageTypeName();
		String wageTypeId = userRelativeDto.getWageTypeId();
		Integer performanceType = userRelativeDto.getPerformanceType();
		// 业绩类别，0=总业绩 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融
		if(userRelativeDto.getManagePlan() != null && userRelativeDto.getManagePlan() == 0) {// 业务业绩类型
			if(performanceType == null || performanceType == 0) {
				erpFunBasewageDto.setTotalPerformanceName(wageTypeName);
				erpFunBasewageDto.setTotalPerformanceId(wageTypeId);
			} else if(performanceType == 1) {
				erpFunBasewageDto.setTransferPerformanceName(wageTypeName);
				erpFunBasewageDto.setTransferPerformanceId(wageTypeId);
			} else if(performanceType == 2) {
				erpFunBasewageDto.setSecondhandPerformanceName(wageTypeName);
				erpFunBasewageDto.setSecondhandPerformanceId(wageTypeId);
			} else if(performanceType == 3) {
				erpFunBasewageDto.setNewhousePerformanceName(wageTypeName);
				erpFunBasewageDto.setNewhousePerformanceId(wageTypeId);
			} else if(performanceType == 4) {
				erpFunBasewageDto.setLeasePerformanceName(wageTypeName);
				erpFunBasewageDto.setLeasePerformanceId(wageTypeId);
			} else if(performanceType == 5) {
				erpFunBasewageDto.setFinancePerformanceName(wageTypeName);
				erpFunBasewageDto.setFinancePerformanceId(wageTypeId);
			}
		} else {// 管理业绩类型
			if(performanceType == null || performanceType == 0) {
				erpFunBasewageDto.setMgTotalPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgTotalPerformanceId(wageTypeId);
			} else if(performanceType == 1) {
				erpFunBasewageDto.setMgTransferPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgTransferPerformanceId(wageTypeId);
			} else if(performanceType == 2) {
				erpFunBasewageDto.setMgSecondhandPerformanceName(wageTypeName);
				erpFunBasewageDto.setMgSecondhandPerformanceId(wageTypeId);
			} else if(performanceType == 3) {
				erpFunBasewageDto.setMgNewhousePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgNewhousePerformanceId(wageTypeId);
			} else if(performanceType == 4) {
				erpFunBasewageDto.setMgLeasePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgLeasePerformanceId(wageTypeId);
			} else if(performanceType == 5) {
				erpFunBasewageDto.setMgFinancePerformanceName(wageTypeName);
				erpFunBasewageDto.setMgFinancePerformanceId(wageTypeId);
			}
		}
	}
	/**
	 * 获取基本工资列表
	 */
	@Override
	public List<ErpFunBasewageDto> getBaseWageList(Integer cityId, Integer compId ,Integer deptId, String userPosition) throws Exception {
		Calendar calendar = Calendar.getInstance();
		String nowTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMddHHmmssS);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(),DateTimeHelper.FMT_yyyyMMdd);
		//查询基本工资列表
		List<ErpFunBasewageDto> list = erpFunBasewageMapper.getBaseWageList(cityId, compId, deptId,userPosition,startTime,nowTime);
		/*if(list==null||list.isEmpty()){
			return list;
		}
		//加入门店ID
		Set<Integer> deptIds = new HashSet<Integer>();
		Set<Integer> userIds = new HashSet<Integer>(); 
		for(ErpFunBasewageDto dto:list){
			deptIds.add(dto.getDeptId());
			if("1".equals(dto.getChangeDeptFlag())){
				userIds.add(dto.getUserId());
			}
		}
		//查询员工异动列表
		List<ErpFunChangeUsersDto> changeUserList = erpFunUsersMapper.getChangeUsersNewDeptIds(cityId,compId,userIds);
		Map<Object,ErpFunChangeUsersDto> changeUserMap = BeanUtilsHelper.listToMapObjectOffKeyType(changeUserList, "userId");
		for(ErpFunChangeUsersDto dto:changeUserList){
			deptIds.add(dto.getDeptId());
		}
		List<ErpFunDepts> deptList = erpFunDeptsMapper.getDeptListByDeptIds(cityId, deptIds);
		Map<Object,ErpFunDepts> deptMap = BeanUtilsHelper.listToMapObjectOffKeyType(deptList, "deptId");
		for(ErpFunBasewageDto dto:list){
			Integer onceDeptId = dto.getDeptId();
			ErpFunDepts onceDept = deptMap.get(onceDeptId);
			if(onceDept!=null){
				dto.setOnceDeptName(onceDept.getDeptCname());
			}
			if("1".equals(dto.getChangeDeptFlag())){
				ErpFunChangeUsersDto changeUsersDto = changeUserMap.get(dto.getUserId());
				if(changeUsersDto!=null){
					Integer nowDeptId = changeUsersDto.getDeptId();
					ErpFunDepts nowDept = deptMap.get(nowDeptId);
					if(nowDept!=null){
						dto.setNowDeptName(nowDept.getDeptCname());
					}
				}
			}
		}*/
		return list;
	}
	
	/**
	 * 更新基本工资
	 * 这里可能后面需要写一套批量查询的接口
	 * @param cityId
	 * @param compId
	 * @throws Exception
	 */
	@Transactional
	@Override
	public void updateBaseWage(Integer cityId, Integer compId, String baseWageJson) throws Exception{
		List<ErpFunBasewage> list = JSON.parseArray(baseWageJson,ErpFunBasewage.class);
		for(ErpFunBasewage funBaseWage:list){
			funBaseWage.setShardCityId(cityId);
			funBaseWage.setCompId(compId);
			erpFunBasewageMapper.updateByPrimaryKeySelective(funBaseWage);
		}
	}
	
	/**
	 * 
	 */
	@Override
	public List<ErpFunWageTypeNew> getSalaryPlanNameList(
			Integer cityId, Integer compId) {
		return erpFunWageTypeNewMapper.selectWageTypeNewListByComp(cityId,compId);
	}

	@Transactional
	@Override
	public void updateWagetypeUserRelative(SaveSalaryPlanRelativeUserParam param, List<ErpFunUsers> userList ,ErpFunSalaryType erpFunSalaryType) {
		Integer salaryTypeId = param.getId();
		String roleId = param.getRoleId();
		Integer compId = param.getCompId();
		if (salaryTypeId == null) {
			ErpFunSalaryType insertModel = new ErpFunSalaryType();
			// 创建薪资方案
			Date nowDate = new Date();
			BeanUtils.copyProperties(param, insertModel);
			insertModel.setCompId(param.getCompId());
			insertModel.setShardCityId(param.getCityId());
			insertModel.setSalaryMoney(param.getSalaryMoney());
			insertModel.setCreateUserId(param.getCurrentUserId());
			insertModel.setCreationTime(nowDate);
			insertModel.setUpdateTime(DateTimeHelper.formatDateTimetoString(nowDate, DateTimeHelper.FMT_yyyyMMddHHmmssS));
			erpFunSalaryTypeMapper.insertSelective(insertModel);
			salaryTypeId = insertModel.getId();

			ErpRoleWagetypeRelative insertRoleRelative = new ErpRoleWagetypeRelative();
			BeanUtils.copyProperties(param, insertRoleRelative);
			insertRoleRelative.setCompId(param.getCompId());
			insertRoleRelative.setShardCityId(param.getCityId());
			insertRoleRelative.setSalaryTypeId(salaryTypeId);
			insertRoleRelative.setCountType(Byte.valueOf("0"));
			//insertRoleRelati
			erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
			insertRoleRelative = new ErpRoleWagetypeRelative();
			insertRoleRelative.setCompId(param.getCompId());
			insertRoleRelative.setShardCityId(param.getCityId());
			insertRoleRelative.setSalaryTypeId(salaryTypeId);
			insertRoleRelative.setFinanceId(param.getMfinanceId());
			insertRoleRelative.setNewhouseId(param.getMnewhouseId());
			insertRoleRelative.setLeaseId(param.getMleaseId());
			insertRoleRelative.setSecondhandId(param.getMsecondhandId());
			insertRoleRelative.setTotalId(param.getMtotalId());
			insertRoleRelative.setTransferId(param.getMtransferId());
			insertRoleRelative.setCountType(Byte.valueOf("1"));
			erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
		}else {
			boolean isHaveSalaryType = false;
			Date createDate = erpFunSalaryType.getCreationTime();
			Date dateNow = new Date();
			// 判断是否在同一个月
			if(dateNow.getYear() == createDate.getYear() && dateNow.getMonth() == createDate.getMonth()) {
				isHaveSalaryType = true;
			}
			ErpFunSalaryType id = new ErpFunSalaryType();
			id.setShardCityId(param.getCityId());
			id.setId(param.getId());
			ErpFunSalaryType oldModel = erpFunSalaryTypeMapper.selectByPrimaryKey(id);
			ErpRoleWagetypeRelativeExample queryExample = new ErpRoleWagetypeRelativeExample();
			queryExample.setShardCityId(param.getCityId());
			queryExample.createCriteria().andCompIdEqualTo(param.getCompId()).andSalaryTypeIdEqualTo(param.getId());
			List<ErpRoleWagetypeRelative> roleWagetypeRelaList = erpRoleWagetypeRelativeMapper.selectByExample(queryExample);
			Map<String,Object> beforeMap = new HashMap<String,Object>();
			beforeMap.put("FUN_SALARY_TYPE", oldModel);
			beforeMap.put("ROLE_WAGETYPE_RELATIVE", roleWagetypeRelaList);
			//如果是当月的更新
			if (isHaveSalaryType) {
				ErpFunSalaryType insertModel = new ErpFunSalaryType();
				// 创建薪资方案
				BeanUtils.copyProperties(param, insertModel);
				insertModel.setShardCityId(param.getCityId());
				insertModel.setUpdateTime(DateTimeHelper.formatDateTimetoString(dateNow, DateTimeHelper.FMT_yyyyMMddHHmmssS));
				erpFunSalaryTypeMapper.updateByPrimaryKeySelective(insertModel);
				salaryTypeId = insertModel.getId();
				ErpRoleWagetypeRelativeExample example = new ErpRoleWagetypeRelativeExample();
				example.setShardCityId(param.getCityId());
				example.createCriteria().andCompIdEqualTo(param.getCompId()).andSalaryTypeIdEqualTo(salaryTypeId);
				erpRoleWagetypeRelativeMapper.deleteByExample(example);
				ErpRoleWagetypeRelative insertRoleRelative = new ErpRoleWagetypeRelative();
				BeanUtils.copyProperties(param, insertRoleRelative);
				insertRoleRelative.setCompId(param.getCompId());
				insertRoleRelative.setShardCityId(param.getCityId());
				insertRoleRelative.setSalaryTypeId(salaryTypeId);
				insertRoleRelative.setCountType(Byte.valueOf("0"));
				erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
				insertRoleRelative = new ErpRoleWagetypeRelative();
				insertRoleRelative.setCompId(param.getCompId());
				insertRoleRelative.setShardCityId(param.getCityId());
				insertRoleRelative.setSalaryTypeId(salaryTypeId);
				insertRoleRelative.setFinanceId(param.getMfinanceId());
				insertRoleRelative.setNewhouseId(param.getMnewhouseId());
				insertRoleRelative.setLeaseId(param.getMleaseId());
				insertRoleRelative.setSecondhandId(param.getMsecondhandId());
				insertRoleRelative.setTotalId(param.getMtotalId());
				insertRoleRelative.setTransferId(param.getMtransferId());
				insertRoleRelative.setCountType(Byte.valueOf("1"));
				erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
			} else {
				id = new ErpFunSalaryType();
				id.setId(salaryTypeId);
				id.setShardCityId(param.getCityId());
				//不是当月的更新，那么逻辑应该是
				//将之前的薪资记录变更为删除，将现在的记录变更为删除
				id.setDelFlag(1);
				erpFunSalaryTypeMapper.updateByPrimaryKeySelective(id);
				//删除关联信息]
				ErpSalaryTypeRelativeExample example = new ErpSalaryTypeRelativeExample();
				example.setShardCityId(param.getCityId());
				example.createCriteria().andSalaryTypeIdEqualTo(salaryTypeId);
				ErpSalaryTypeRelative record = new ErpSalaryTypeRelative();
				record.setDelFlag(1);
				Calendar calendar = Calendar.getInstance();
				calendar.setTime(dateNow);
				calendar.set(Calendar.DAY_OF_MONTH, 1);
				calendar.add(Calendar.DAY_OF_MONTH, -1);
				record.setDelTime(calendar.getTime());
				erpSalaryTypeRelativeMapper.updateByExampleSelective(record, example);
				ErpFunSalaryType insertModel = new ErpFunSalaryType();
				// 创建薪资方案
				Date nowDate = new Date();
				BeanUtils.copyProperties(param, insertModel);
				insertModel.setCompId(param.getCompId());
				insertModel.setShardCityId(param.getCityId());
				insertModel.setRoleId(erpFunSalaryType.getRoleId());
				insertModel.setSalaryMoney(param.getSalaryMoney());
				insertModel.setCreateUserId(param.getCurrentUserId());
				insertModel.setCreationTime(nowDate);
				insertModel.setUpdateTime(DateTimeHelper.formatDateTimetoString(nowDate, DateTimeHelper.FMT_yyyyMMddHHmmssS));
				erpFunSalaryTypeMapper.insertSelective(insertModel);
				salaryTypeId = insertModel.getId();
				ErpRoleWagetypeRelative insertRoleRelative = new ErpRoleWagetypeRelative();
				BeanUtils.copyProperties(param, insertRoleRelative);
				insertRoleRelative.setCompId(param.getCompId());
				insertRoleRelative.setShardCityId(param.getCityId());
				insertRoleRelative.setSalaryTypeId(salaryTypeId);
				insertRoleRelative.setCountType(Byte.valueOf("0"));
				erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
				insertRoleRelative = new ErpRoleWagetypeRelative();
				insertRoleRelative.setCompId(param.getCompId());
				insertRoleRelative.setShardCityId(param.getCityId());
				insertRoleRelative.setSalaryTypeId(salaryTypeId);
				insertRoleRelative.setFinanceId(param.getMfinanceId());
				insertRoleRelative.setNewhouseId(param.getMnewhouseId());
				insertRoleRelative.setLeaseId(param.getMleaseId());
				insertRoleRelative.setSecondhandId(param.getMsecondhandId());
				insertRoleRelative.setTotalId(param.getMtotalId());
				insertRoleRelative.setTransferId(param.getMtransferId());
				insertRoleRelative.setCountType(Byte.valueOf("1"));
				erpRoleWagetypeRelativeMapper.insertSelective(insertRoleRelative);
				
			}
			id = new ErpFunSalaryType();
			id.setShardCityId(param.getCityId());
			id.setId(salaryTypeId);
			ErpFunSalaryType newModel = erpFunSalaryTypeMapper.selectByPrimaryKey(id);
			queryExample = new ErpRoleWagetypeRelativeExample();
			queryExample.setShardCityId(param.getCityId());
			queryExample.createCriteria().andCompIdEqualTo(param.getCompId()).andSalaryTypeIdEqualTo(salaryTypeId);
			roleWagetypeRelaList = erpRoleWagetypeRelativeMapper.selectByExample(queryExample);
			Map<String,Object> afterMap = new HashMap<String,Object>();
			afterMap.put("FUN_SALARY_TYPE", newModel);
			afterMap.put("ROLE_WAGETYPE_RELATIVE", roleWagetypeRelaList);
			String currentUserName = erpFunUsersMapper.getCurrUserName(param.getCityId(), param.getCurrentUserId(), param.getCurrentDeptId());
			ErpCompRolesExample roleExample = new ErpCompRolesExample();
			roleExample.setShardCityId(param.getCityId());
			roleExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
			List<ErpCompRoles> roleList = erpCompRolesMapper.selectByExample(roleExample);
			String roleName = "";
			if (!roleList.isEmpty()) {
				roleName = roleList.get(0).getRoleName();
			}
			ErpSystemSettingLogs record = new ErpSystemSettingLogs();
			record.setShardCityId(param.getCityId());
			record.setCompId(param.getCompId());
			record.setCreateUid(param.getCurrentUserId());
			record.setCreateDept(param.getCurrentDeptId());
			record.setCreateTime(DateTimeHelper.formatDateTimetoString(new Date()));
			record.setModular(4);
			record.setSslType(Byte.valueOf(SystemOperateUtil.SSL_TYPE.UPDATE_SALARY_TYPE.toString()));
			record.setLogContent(currentUserName+"修改了角色"+roleName+"薪资配置");
			record.setBeforeModification(JSON.toJSONString(beforeMap));
			record.setAfterModification(JSON.toJSONString(afterMap));
			erpSystemSettingLogsMapper.insertSelective(record);
		}
		// 给范围内的所有员工配置薪资方案
		for (ErpFunUsers erpFunUsers : userList) {
			// 修改基本薪资
			this.updateUserBasewage(param.getCityId(), param.getCompId(), erpFunUsers.getUserId(), param.getSalaryMoney().intValue());
			// 修改薪资方案
			erpWagetypeUserRelativeService.createSalaryTypeRelative(salaryTypeId, erpFunUsers);
		}
		param.setId(salaryTypeId);
		System.out.println(param.toString());
		// 修改提成方案
		updateWagetypeUserRelative(param, param.getTotalId(),"0","0");
		updateWagetypeUserRelative(param, param.getTransferId(),"1","0");
		updateWagetypeUserRelative(param, param.getSecondhandId(),"2","0");
		updateWagetypeUserRelative(param, param.getNewhouseId(),"3","0");
		updateWagetypeUserRelative(param, param.getLeaseId(),"4","0");
		updateWagetypeUserRelative(param, param.getFinanceId(),"5","0");

		updateWagetypeUserRelative(param, param.getMtotalId(),"0","1");
		updateWagetypeUserRelative(param, param.getMtransferId(),"1","1");
		updateWagetypeUserRelative(param, param.getMsecondhandId(),"2","1");
		updateWagetypeUserRelative(param, param.getMnewhouseId(),"3","1");
		updateWagetypeUserRelative(param, param.getMleaseId(),"4","1");
		updateWagetypeUserRelative(param, param.getMfinanceId(),"5","1");
	}
	
	private void updateWagetypeUserRelative(SaveSalaryPlanRelativeUserParam param, Integer wageTypeId,String performanceType,String managePlan){
		erpWagetypeUserRelativeMapper.deleteWageTypeUserRelativeByRole(param.getCityId(),param.getCompId(),param.getRoleId(),performanceType,managePlan);
		if(wageTypeId == null) {
			return;
		}
		// 查询方案是否存在，是否是这个公司的
		ErpFunWageTypeNewExample seWageTypeNew = new ErpFunWageTypeNewExample();
		seWageTypeNew.setShardCityId(param.getCityId());
		seWageTypeNew.createCriteria().andCompIdEqualTo(param.getCompId()).andIdEqualTo(wageTypeId);
		List<ErpFunWageTypeNew> wageTypeNew = erpFunWageTypeNewMapper.selectByExample(seWageTypeNew);
		if (wageTypeNew == null || wageTypeNew.size() <= 0) {
			return;
		}
		erpWagetypeUserRelativeMapper.updateWagetypeUserRelative(param.getCityId(), wageTypeId, param.getCompId(), param.getDeptId(), param.getRoleId(), param.getId());
	}
	
	/**
	 * 重新设置薪资提成方案
	 * flj
	 * 2017-11-17
	 */
	@Transactional
	@Override
	public void resetWagetypeUserRelativeOffUserId(Integer cityId,Integer compId, Integer userId, Integer salaryTypeId){
		SaveSalaryPlanRelativeUserParam param = new SaveSalaryPlanRelativeUserParam();
		ErpRoleWagetypeRelativeExample example = new ErpRoleWagetypeRelativeExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andSalaryTypeIdEqualTo(salaryTypeId);
		// 业绩提成
		List<ErpRoleWagetypeRelative> roleWageList = erpRoleWagetypeRelativeMapper.selectByExample(example);
		for (ErpRoleWagetypeRelative roleWageRelative:roleWageList) {
			 if (Byte.valueOf("0").equals(roleWageRelative.getCountType())) {
				param.setTransferId(roleWageRelative.getTransferId());
				param.setTotalId(roleWageRelative.getTotalId());
				param.setSecondhandId(roleWageRelative.getSecondhandId());
				param.setFinanceId(roleWageRelative.getFinanceId());
				param.setLeaseId(roleWageRelative.getLeaseId());
				param.setNewhouseId(roleWageRelative.getNewhouseId());
				
			 } else if (Byte.valueOf("1").equals(roleWageRelative.getCountType())) {
				param.setMtransferId(roleWageRelative.getTransferId());
				param.setMtotalId(roleWageRelative.getTotalId());
				param.setMsecondhandId(roleWageRelative.getSecondhandId());
				param.setMfinanceId(roleWageRelative.getFinanceId());
				param.setMleaseId(roleWageRelative.getLeaseId());
				param.setMnewhouseId(roleWageRelative.getNewhouseId());
			 }
		}
		param.setId(salaryTypeId);
		param.setCityId(cityId);
		param.setCompId(compId);
		param.setResetUserId(userId);
		// 修改提成方案
		updateWagetypeUserRelativeOffUserId(param, param.getTotalId(),"0","0");
		updateWagetypeUserRelativeOffUserId(param, param.getTransferId(),"1","0");
		updateWagetypeUserRelativeOffUserId(param, param.getSecondhandId(),"2","0");
		updateWagetypeUserRelativeOffUserId(param, param.getNewhouseId(),"3","0");
		updateWagetypeUserRelativeOffUserId(param, param.getLeaseId(),"4","0");
		updateWagetypeUserRelativeOffUserId(param, param.getFinanceId(),"5","0");

		updateWagetypeUserRelativeOffUserId(param, param.getMtotalId(),"0","1");
		updateWagetypeUserRelativeOffUserId(param, param.getMtransferId(),"1","1");
		updateWagetypeUserRelativeOffUserId(param, param.getMsecondhandId(),"2","1");
		updateWagetypeUserRelativeOffUserId(param, param.getMnewhouseId(),"3","1");
		updateWagetypeUserRelativeOffUserId(param, param.getMleaseId(),"4","1");
		updateWagetypeUserRelativeOffUserId(param, param.getMfinanceId(),"5","1");
	}
	
	private void updateWagetypeUserRelativeOffUserId(SaveSalaryPlanRelativeUserParam param, Integer wageTypeId,String performanceType,String managePlan){
		if(wageTypeId == null) {
			erpWagetypeUserRelativeMapper.deleteWageTypeUserRelativeByUserId(param.getCityId(),param.getCompId(),param.getResetUserId(),performanceType,managePlan);
			return;
		}
		// 查询方案是否存在，是否是这个公司的
		ErpFunWageTypeNewExample seWageTypeNew = new ErpFunWageTypeNewExample();
		seWageTypeNew.setShardCityId(param.getCityId());
		seWageTypeNew.createCriteria().andCompIdEqualTo(param.getCompId()).andIdEqualTo(wageTypeId);
		List<ErpFunWageTypeNew> wageTypeNew = erpFunWageTypeNewMapper.selectByExample(seWageTypeNew);
		if (wageTypeNew == null || wageTypeNew.size() <= 0) {
			return;
		}
		erpWagetypeUserRelativeMapper.deleteWageTypeUserRelativeByUserId(param.getCityId(),param.getCompId(),param.getResetUserId(),performanceType,managePlan);
		erpWagetypeUserRelativeMapper.updateWagetypeUserRelativeOffUserId(param.getCityId(), wageTypeId,
				param.getCompId(), param.getDeptId(), param.getResetUserId(), param.getId());
	}

	@Override
	public void updateUserBasewage(Integer cityId, Integer compId, Integer userId, Integer baseWage) {
		ErpFunBasewage upModel = new ErpFunBasewage();
		upModel.setShardCityId(cityId);
		upModel.setCompId(compId);
		upModel.setUserId(userId);
		upModel.setBaseMoney(baseWage);
		upModel.setAssessmentFlag(new Byte("1"));//参与考核
		erpFunBasewageMapper.updateByPrimaryKeySelective(upModel);
	}
}
