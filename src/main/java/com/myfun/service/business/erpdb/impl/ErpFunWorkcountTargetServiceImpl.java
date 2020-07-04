package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.profit.ProfitBusinessController;
import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetParam;
import com.myfun.erpWeb.managecenter.profit.param.AppFunWorkCountTargetSubParam;
import com.myfun.framework.taskJob.ErpFunWorkcountTargetTask;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.param.ErpFunWorkCountTargetParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunWorkcountTargetService;
import com.myfun.service.business.erpdb.ErpNoTransactionService;
import com.myfun.utils.Assert;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ErpFunWorkcountTargetServiceImpl extends AbstractService<ErpFunWorkcountTarget, ErpFunWorkcountTarget> implements ErpFunWorkcountTargetService {
	@Autowired
    ErpFunWorkcountTargetMapper erpFunWorkcountTargetMapper;
	@Autowired
    ErpFunWorkcountTargetTemplateMapper erpFunWorkcountTargetTemplateMapper;
	@Autowired
    ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
    ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
    ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
    ErpNoTransactionService erpNoTransactionService;
	@Autowired
    ErpFunWorkcountTargetTask erpFunWorkcountTargetTask;
	@Autowired
	private ErpFunWorkcountTargetOrgTemplateMapper erpFunWorkcountTargetOrgTemplateMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunWorkcountTargetMapper;
	}

	/**
	 * @Title 更新业绩目标
	 * @Author lcb
	 * @Date 2018/2/9
	 * @Param
	 **/
	@Override
	@Transactional
	public Integer updateWorkCountTargetDetail(Integer cityId, Integer compId, ErpFunWorkCountTargetParam param) {
		Integer id = param.getId();
		if(null == id) {
			// 根据条件找人
			ErpFunUsersExample example = new ErpFunUsersExample();
			example.setShardCityId(cityId);
			ErpFunUsersExample.Criteria criteria = example.createCriteria();
			criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
			if(null != param.getAreaId()) {
				criteria.andAreaIdEqualTo(param.getAreaId());
			}
			if(null != param.getRegId()) {
				criteria.andRegIdEqualTo(param.getRegId());
			}
			if(null != param.getDeptId()) {
				criteria.andDeptIdEqualTo(param.getDeptId());
			}
			if(null != param.getGrId()) {
				criteria.andGrIdEqualTo(param.getGrId());
			}
			if(null != param.getUserId()) {
				criteria.andUserIdEqualTo(param.getUserId());
			}
			if(StringUtils.isNotBlank(param.getUserPosition())) {
				criteria.andUserPositionEqualTo(param.getUserPosition());
			}
			List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.selectByExample(example);
			// id 为空 是批量设置业绩目标
			// 获取到角色信息

			// 防止串数据
//			ErpFunWorkCountTargetParam queryParam = new ErpFunWorkCountTargetParam();
//			queryParam.setUserPosition(param.getUserPosition());
//			queryParam.setTargetType(param.getTargetType());
//			List<ErpFunWorkCountTargetDto> workCountTargetList = erpFunWorkcountTargetMapper.getWorkCountTargetList(cityId, compId, param);
//
//			// 查询人的信息
//			Set<Integer> userIdSet = workCountTargetList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
//			if(userIdSet == null || userIdSet.isEmpty()) {
//				return 0;
//			}
//			List<ErpFunUsers> userListByUserIds = erpFunUsersMapper.getUserListByUserIds(cityId, userIdSet);
//			Map<Integer, ErpFunUsers> usersMap = userListByUserIds.stream().collect(Collectors.toMap(ErpFunUsers::getUserId, val->val));
			for (ErpFunUsers erpFunUsers : userListByUserIds) {
//				id = erpFunWorkCountTargetDto.getId();
//				ErpFunUsers erpFunUsers = usersMap.get(erpFunWorkCountTargetDto.getUserId());
				ErpFunWorkcountTarget erpFunWorkCountTarget = new ErpFunWorkcountTarget();
				BeanUtils.copyProperties(param, erpFunWorkCountTarget);
				erpFunWorkCountTarget.setShardCityId(cityId);
//				if(createTimeCalendar.after(calendar)) {
//					// 直接修改
//					erpFunWorkCountTarget.setCreateTime(null);
//					erpFunWorkCountTarget.setId(id);
//					erpFunWorkcountTargetMapper.updateByPrimaryKeySelective(erpFunWorkCountTarget);
//				}else {
				erpFunWorkCountTarget.setCompId(erpFunUsers.getCompId());
				erpFunWorkCountTarget.setUserId(erpFunUsers.getUserId());
				erpFunWorkCountTarget.setCreateTime(new Date());
				erpFunWorkcountTargetMapper.insertSelective(erpFunWorkCountTarget);
				id = erpFunWorkCountTarget.getId();
//				}
			}
		}else {
			// 有id 就单个人修改
			ErpFunWorkcountTarget erpFunWorkcountTarget = new ErpFunWorkcountTarget();
			erpFunWorkcountTarget.setShardCityId(cityId);
			erpFunWorkcountTarget.setId(id);
			erpFunWorkcountTarget = erpFunWorkcountTargetMapper.selectByPrimaryKey(erpFunWorkcountTarget);
			erpFunWorkcountTarget.setId(null);
			Integer userId = erpFunWorkcountTarget.getUserId();
			Integer archiveId = erpFunWorkcountTarget.getArchiveId();
			Byte targetType = erpFunWorkcountTarget.getTargetType();
			Calendar calendar = Calendar.getInstance();
			// 周考核目标
			if(2 == erpFunWorkcountTarget.getTargetType().intValue()) {
				// 周表  如果创建时间在本周一之后就修改，否则就新增
				Date thisWeekMonday = DateUtil.getThisWeekMonday();
				calendar.setTime(thisWeekMonday);
			}
			Calendar createTimeCalendar = Calendar.getInstance();
			createTimeCalendar.setTime(erpFunWorkcountTarget.getCreateTime());
			calendar.set(Calendar.HOUR_OF_DAY, 0);
			calendar.set(Calendar.MINUTE, 0);
			calendar.set(Calendar.SECOND, 0);
			calendar.set(Calendar.MILLISECOND, 0);
			BeanUtils.copyProperties(param, erpFunWorkcountTarget);
			erpFunWorkcountTarget.setShardCityId(cityId);
			erpFunWorkcountTarget.setCompId(compId);
			erpFunWorkcountTarget.setUserId(userId);
			erpFunWorkcountTarget.setCreateTime(new Date());
			erpFunWorkcountTarget.setArchiveId(archiveId);
			erpFunWorkcountTarget.setTargetType(targetType);
			erpFunWorkcountTargetMapper.insertSelective(erpFunWorkcountTarget);
			id = erpFunWorkcountTarget.getId();
		}
		// 清楚缓存
//		String key = CacheStructure.hfterpdb_funWorkCountTypeCacheByCompId+cityId+"_"+compId+"_"+param.getTargetType()+"*";
//		erpNoTransactionService.evictWorkCountTargetData(key);
		return id;
	}

	@Override
	public void appUpdateWorkCountTargetDetail(Integer cityId, Integer compId, AppFunWorkCountTargetParam param) {
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();// 选择全公司的时候就是null，否则就是对于的门店id
		Integer grId = param.getGrId();
		String userPosition = param.getUserPosition();// 选择全部的时候就是空字符串，否则就是对应的角色id
		//设置经济人目标工作量
		updateUserWorkCountTarget(cityId, compId, param);
		/**
		 * 针对参数中的deptId和userPosition情况进行分析：
		 * 1、全公司和全部角色	deptId = null 、 userPosition = ""
		 * 2、某一范围和全部角色	deptId = 123   、 userPosition = ""
		 * 3、全公司和某一角色	deptId = null  、 userPosition = "GENERL_MANAGER"
		 * 4、某一范围和某一角色	deptId = 123   、  userPosition = "GENERL_MANAGER"
		 */
		if (null == param.getUserId()) {
			// 找出公司的所有在使用的角色
			ErpCompRolesExample erpCompRolesExample = new ErpCompRolesExample();
			erpCompRolesExample.setShardCityId(cityId);
			erpCompRolesExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(Byte.valueOf("0"));
			List<ErpCompRoles> erpCompRolesList = erpCompRolesMapper.selectByExample(erpCompRolesExample);

			// 找出公司所有正常的门店数据
			ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
			erpFunDeptsExample.setShardCityId(cityId);
			ErpFunDeptsExample.Criteria deptCriteria = erpFunDeptsExample.createCriteria().andCompIdEqualTo(compId).andDeptFlagIn(Arrays.asList(1, 2));
			//加盟商模式添加范围限制[标准非加盟模式param.getPartnerIds = null]
			if (param.isSeparationConfig() && Objects.nonNull(param.getPartnerIds()) && !param.getPartnerIds().isEmpty()) {
				deptCriteria.andPartnerIdIn(param.getPartnerIds());
			}
			List<ErpFunDepts> deptsList = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);
			if (!param.isSeparationConfig()) {
				//脱了裤儿撒泡尿
				deptsList.forEach(obj->obj.setPartnerId(-1));
			}
			Map<Integer, Integer> dept2Partner = deptsList.stream().collect(Collectors.toMap(ErpFunDepts::getDeptId, ErpFunDepts::getPartnerId));
			if (null == deptId && StringUtils.isBlank(userPosition)) {// 1、全公司和全部角色
				createAllCompAllPositionTargetTemplate(cityId, compId, deptId, param, erpCompRolesList,dept2Partner);
			} else if (null == deptId && StringUtils.isNotBlank(userPosition)) {// 3全公司和某一角色
				String[] split = userPosition.split(",");
				for (String userPosition2:split) {
					createAllCompOnePositionTargetTemplate(cityId, compId, deptId, param, userPosition2,dept2Partner);
				}
			} else if (null != deptId && StringUtils.isBlank(userPosition)) {// 2、某一范围和全部角色
				param.setPartnerId(dept2Partner.getOrDefault(deptId,param.getPartnerId()));
				createOneDeptAllPositionTargetTemplate(cityId, compId, deptId, param, erpCompRolesList);
			} else if (null != deptId && StringUtils.isNotBlank(userPosition)) {// 4、某一范围和某一角色
				String[] split = userPosition.split(",");
				for (String userPosition2:split) {
					param.setPartnerId(dept2Partner.getOrDefault(deptId,param.getPartnerId()));
					createOneDeptOnePositionTargetTemplate(cityId, compId, deptId, param, userPosition2);
				}
			}
		}
	}

	/**
	 * 修改经纪人工作量目标
	 * @param cityId
	 * @param compId
	 * @param param
	 */
	private void updateUserWorkCountTarget(Integer cityId, Integer compId, AppFunWorkCountTargetParam param) {
		Integer areaId = param.getAreaId();
		Integer regId = param.getRegId();
		Integer deptId = param.getDeptId();// 选择全公司的时候就是null，否则就是对于的门店id
		Integer grId = param.getGrId();
		String userPosition = param.getUserPosition();// 选择全部的时候就是空字符串，否则就是对应的角色id
		// 日目标量
		AppFunWorkCountTargetSubParam dayTargetParam = param.getDayTargetList();
		// 周目标量
		AppFunWorkCountTargetSubParam weekTargetParam = param.getWeekTargetList();
		// 月目标量
		AppFunWorkCountTargetSubParam monthTargetParam = param.getMonthTargetList();
		ErpFunUsersExample example = new ErpFunUsersExample();
		example.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		if (null != param.getAreaId()) {
			criteria.andAreaIdEqualTo(param.getAreaId());
		}
		if (null != param.getRegId()) {
			criteria.andRegIdEqualTo(param.getRegId());
		}
		if (null != param.getDeptId()) {
			criteria.andDeptIdEqualTo(param.getDeptId());
		}
		if (null != param.getUserId()) {
			criteria.andUserIdEqualTo(param.getUserId());
		}
		if (null != param.getGrId()) {
			criteria.andGrIdEqualTo(param.getGrId());
		}
		if (StringUtils.isNotBlank(param.getUserPosition())) {
			String userPosition1 = param.getUserPosition();
			String[] split = userPosition1.split(",");
			criteria.andUserPositionIn(Arrays.asList(split));
		}
		//加盟商模式添加范围限制
		if (param.isSeparationConfig() && Objects.nonNull(param.getPartnerIds()) && !param.getPartnerIds().isEmpty()) {
			criteria.andPartnerIdIn(param.getPartnerIds());
		}
		Integer countUser = erpFunUsersMapper.countByExample(example);

		if (countUser > 0) {
			List<String> userPositinolist = null;
			if(StringUtils.isNotBlank(userPosition)){
				String[] split = userPosition.split(",");
				userPositinolist = Arrays.asList(split);
			}

			if (null != dayTargetParam) {
				erpFunWorkcountTargetMapper.createTarget(cityId, compId,param.getPartnerIds(), areaId, regId, deptId, grId, 1,
						userPositinolist, param.getUserId(),dayTargetParam);
			}
			if (null != weekTargetParam) {
				erpFunWorkcountTargetMapper.createTarget(cityId, compId,param.getPartnerIds(), areaId, regId, deptId, grId, 2,
						userPositinolist, param.getUserId(),weekTargetParam);
			}
			if (null != monthTargetParam) {
				erpFunWorkcountTargetMapper.createTarget(cityId, compId,param.getPartnerIds(), areaId, regId, deptId, grId, 3,
						userPositinolist, param.getUserId(),monthTargetParam);
			}
		}
	}

	/**
	 * 创建全公司全角色情况的考核配置模板数据
	 */
	private void createAllCompAllPositionTargetTemplate(Integer cityId, Integer compId, Integer deptId,
														AppFunWorkCountTargetParam param, List<ErpCompRoles> erpCompRolesList,  Map<Integer, Integer> dept2Partner) {
		/**
		 * 全部角色就是全部员工，因为有员工就肯定有角色，先全部删除
		 */
		ErpFunWorkcountTargetTemplateExample example = new ErpFunWorkcountTargetTemplateExample();
		example.setShardCityId(cityId);
		ErpFunWorkcountTargetTemplateExample.Criteria criteria = example.createCriteria().andCompIdEqualTo(compId);
		if (param.isSeparationConfig()) {
			criteria.andPartnerIdIn(param.getPartnerIds());
		}
		erpFunWorkcountTargetTemplateMapper.deleteByExample(example);
		Date date = new Date();
		if (null != param.getDayTargetList()) {
			// 创建一条符合条件的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(),0, null, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("1"), date);
			// 插入一条级别在公司且角色为空的数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {
				// 创建一条符合条件的数据 总部时插入一条直营模板
				erpFunWorkcountTargetTemplate = createOneInsertData(compId, -1,0, null, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("1"), date);
				// 插入一条级别在公司且角色为空的数据
				erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			}
			// 异步组装日考核数据插入
			erpFunWorkcountTargetTask.asyncAssemblyAndInsertDayData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
		}
		if (null != param.getWeekTargetList()) {
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), 0, null, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("1"), date);
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//总部时插入一条直营模板
				erpFunWorkcountTargetTemplate = createOneInsertData(compId, -1, 0, null, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("1"), date);
				erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			}
			// 异步组装周考核数据插入
			erpFunWorkcountTargetTask.asyncAssemblyAndInsertWeekData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
		}
		if (null != param.getMonthTargetList()) {
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), 0, null, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("1"), date);
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//总部时插入一条直营模板
				erpFunWorkcountTargetTemplate = createOneInsertData(compId, -1, 0, null, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("1"), date);
				erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			}
			// 异步组装月考核数据插入
			erpFunWorkcountTargetTask.asyncAssemblyAndInsertMonthData(cityId, compId, dept2Partner, erpCompRolesList, param, date);
		}
	}
	
	/**
	 * 异步组装日考核数据插入
	 */
	@Override
	public void asyncAssemblyAndInsertDayData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
                                              List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		// 需要插入的组装的集合
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		// 公司级别的所有角色也需要每个单独来一条
		insertTargetList.addAll(assemblyAllPositionInsertData(compId, param.getPartnerId(),0, erpCompRolesList, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("1"), date));
		if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//总部操作时为直营门店插入模板
			insertTargetList.addAll(assemblyAllPositionInsertData(compId, -1,0, erpCompRolesList, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("1"), date));
		}
		// 每个门店也要一条角色为null条件的数据
		insertTargetList.addAll(assemblyAllDeptInsertData(compId,param.getPartnerId(), dept2Partner, param.getDayTargetList(), Byte.valueOf("1"), date));
		// 组装每个门店的每个角色的配置数据
		insertTargetList.addAll(assemblyInsertData(compId,param.getPartnerId(), erpCompRolesList, dept2Partner, param.getDayTargetList(), Byte.valueOf("1"), date));
		// 分批次插入批量创建的配置数据
		batchInsertBatchData(cityId, insertTargetList);
	}
	
	/**
	 * 异步组装周考核数据插入
	 */
	@Override
	public void asyncAssemblyAndInsertWeekData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
                                               List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		// 需要插入的组装的集合
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		// 公司级别的所有角色也需要每个单独来一条
		insertTargetList.addAll(assemblyAllPositionInsertData(compId, param.getPartnerId(),0, erpCompRolesList, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("1"), date));
		if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//总部操作时为直营门店插入模板
			insertTargetList.addAll(assemblyAllPositionInsertData(compId, -1,0, erpCompRolesList, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("1"), date));
		}
		// 每个门店也要一条角色为null条件的数据
		insertTargetList.addAll(assemblyAllDeptInsertData(compId, param.getPartnerId(), dept2Partner, param.getWeekTargetList(), Byte.valueOf("2"), date));
		// 组装每个门店的每个角色的配置数据
		insertTargetList.addAll(assemblyInsertData(compId,param.getPartnerId(), erpCompRolesList, dept2Partner, param.getWeekTargetList(), Byte.valueOf("2"), date));
		// 分批次插入批量创建的配置数据
		batchInsertBatchData(cityId, insertTargetList);
		
	}
	
	/**
	 * 异步组装月考核数据插入
	 */
	@Override
	public void asyncAssemblyAndInsertMonthData(Integer cityId, Integer compId, Map<Integer,Integer> dept2Partner,
                                                List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetParam param, Date date) {
		// 需要插入的组装的集合
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		// 公司级别的所有角色也需要每个单独来一条
		insertTargetList.addAll(assemblyAllPositionInsertData(compId, param.getPartnerId(),0, erpCompRolesList, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("1"), date));
		if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//总部操作时为直营门店插入模板
			insertTargetList.addAll(assemblyAllPositionInsertData(compId, -1,0, erpCompRolesList, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("1"), date));
		}
		// 每个门店也要一条角色为null条件的数据
		insertTargetList.addAll(assemblyAllDeptInsertData(compId, param.getPartnerId(), dept2Partner, param.getMonthTargetList(), Byte.valueOf("3"), date));
		// 组装每个门店的每个角色的配置数据
		insertTargetList.addAll(assemblyInsertData(compId,param.getPartnerId(), erpCompRolesList, dept2Partner, param.getMonthTargetList(), Byte.valueOf("3"), date));
		// 分批次插入批量创建的配置数据
		batchInsertBatchData(cityId, insertTargetList);
	}

	/**
	 * 创建全公司某一角色情况的考核配置模板数据
	 */
	private void createAllCompOnePositionTargetTemplate(Integer cityId, Integer compId, Integer deptId,
                                                        AppFunWorkCountTargetParam param, String userPosition,Map<Integer,Integer> dept2Partner) {
		/**
		 * 全公司某一角色就是先删除条件为公司且角色等于这个角色的所有数据
		 */
		ErpFunWorkcountTargetTemplateExample example = new ErpFunWorkcountTargetTemplateExample();
		example.setShardCityId(cityId);
		ErpFunWorkcountTargetTemplateExample.Criteria criteria = example.createCriteria().andCompIdEqualTo(compId).andUserPositionEqualTo(param.getUserPosition());
		//开启加盟商[ 为写入数据库的id，直营和总部都是0，加盟商>0
		if (param.isSeparationConfig()) {
			criteria.andPartnerIdIn(param.getPartnerIds());
		}
		erpFunWorkcountTargetTemplateMapper.deleteByExample(example);
		
		Date date = new Date();
		// 需要插入的组装的集合
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		if (null != param.getDayTargetList()) {
			assemblyInsertData(cityId, compId, param, userPosition, dept2Partner, date, param.getDayTargetList(), "1");
		}
		if (null != param.getWeekTargetList()) {
			// 创建一条公司级别的该角色的数据
			assemblyInsertData(cityId, compId, param, userPosition, dept2Partner, date, param.getWeekTargetList(), "2");
		}
		if (null != param.getMonthTargetList()) {
			// 创建一条公司级别的该角色的数据
			assemblyInsertData(cityId, compId, param, userPosition, dept2Partner, date, param.getMonthTargetList(), "3");
		}
	}

	private void assemblyInsertData(Integer cityId, Integer compId, AppFunWorkCountTargetParam param, String userPosition,
									Map<Integer, Integer> dept2Partner, Date date, AppFunWorkCountTargetSubParam dayTargetList, String targetType) {
		List<ErpFunWorkcountTargetTemplate> insertTargetList;// 创建一条公司级别的该角色的数据
		ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), 0, userPosition, dayTargetList, Byte.valueOf(targetType), Byte.valueOf("1"), date);
		// 插入一条级别在公司该角色的数据
		erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
		if (param.isSeparationConfig() && Objects.equals(param.getPartnerId(), 0)) {//加盟模式下为直营类型创建一条
			erpFunWorkcountTargetTemplate = createOneInsertData(compId, -1, 0, userPosition, dayTargetList, Byte.valueOf(targetType), Byte.valueOf("1"), date);
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
		}
		// 每个门店下这个角色数据的创建
		insertTargetList = assemblyOnePositionInsertData(compId, userPosition, dept2Partner, dayTargetList, Byte.valueOf(targetType), Byte.valueOf("4"), date);
		// 插入批量创建的配置数据
		batchInsertBatchData(cityId, insertTargetList);
	}

	/**
	 * 创建某一门店全部角色情况的考核配置模板数据
	 */
	private void createOneDeptAllPositionTargetTemplate(Integer cityId, Integer compId, Integer deptId,
                                                        AppFunWorkCountTargetParam param, List<ErpCompRoles> erpCompRolesList) {
		/**
		 * 某一门店全部角色,就把这个门店的数据全删除，条件为公司、门店id
		 */
		ErpFunWorkcountTargetTemplateExample example = new ErpFunWorkcountTargetTemplateExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId);
		erpFunWorkcountTargetTemplateMapper.deleteByExample(example);
		
		Date date = new Date();
		// 需要插入的组装的集合
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		if (null != param.getDayTargetList()) {
			// 创建一条门店级别的null角色（null就是全角色）的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId,param.getPartnerId(), deptId, null, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("4"), date);
			// 插入一条级别在门店的null角色数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			// 这个门店下每个角色的数据组装
			insertTargetList = assemblyAllPositionInsertData(compId, param.getPartnerId(),deptId, erpCompRolesList, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("4"), date);
			// 分批次插入批量创建的配置数据
			batchInsertBatchData(cityId, insertTargetList);
		}
		if (null != param.getWeekTargetList()) {
			// 创建一条门店级别的null角色（null就是全角色）的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), deptId, null, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("4"), date);
			// 插入一条级别在门店的null角色数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			// 这个门店下每个角色的数据组装
			insertTargetList = assemblyAllPositionInsertData(compId,param.getPartnerId(), deptId, erpCompRolesList, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("4"), date);
			// 分批次插入批量创建的配置数据
			batchInsertBatchData(cityId, insertTargetList);
		}
		if (null != param.getMonthTargetList()) {
			// 创建一条门店级别的null角色（null就是全角色）的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(),deptId, null, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("4"), date);
			// 插入一条级别在门店的null角色数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
			// 这个门店下每个角色的数据组装
			insertTargetList = assemblyAllPositionInsertData(compId,param.getPartnerId(), deptId, erpCompRolesList, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("4"), date);
			// 分批次插入批量创建的配置数据
			batchInsertBatchData(cityId, insertTargetList);
		}
	}
	
	/**
	 * 创建某一门店某一角色情况的考核配置模板数据
	 */
	private void createOneDeptOnePositionTargetTemplate(Integer cityId, Integer compId, Integer deptId,
                                                        AppFunWorkCountTargetParam param, String userPosition) {
		/**
		 * 某一门店某一角色，条件就是用门店id和角色id做删除
		 */
		ErpFunWorkcountTargetTemplateExample example = new ErpFunWorkcountTargetTemplateExample();
		example.setShardCityId(cityId);
		example.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andUserPositionEqualTo(param.getUserPosition());
		erpFunWorkcountTargetTemplateMapper.deleteByExample(example);
		
		Date date = new Date();
		if (null != param.getDayTargetList()) {
			// 创建一条一个门店下某一角色的数据 funWorkcountTargetTemplate
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), deptId, userPosition, param.getDayTargetList(), Byte.valueOf("1"), Byte.valueOf("4"), date);
			// 插入一条级别在门店下某一角色的数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
		}
		if (null != param.getWeekTargetList()) {
			// 创建一条一个门店下某一角色的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), deptId, userPosition, param.getWeekTargetList(), Byte.valueOf("2"), Byte.valueOf("4"), date);
			// 插入一条级别在门店下某一角色的数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
		}
		if (null != param.getMonthTargetList()) {
			// 创建一条一个门店下某一角色的数据
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = createOneInsertData(compId, param.getPartnerId(), deptId, userPosition, param.getMonthTargetList(), Byte.valueOf("3"), Byte.valueOf("4"), date);
			// 插入一条级别在门店下某一角色的数据
			erpFunWorkcountTargetTemplateMapper.insertOne(cityId, erpFunWorkcountTargetTemplate);
		}
	}
	
	/**
	 * 创建一个数据，比如公司下的那条角色为null的数据
	 * @param compId 公司id
	 * @param deptId 门店id 0或者123
	 * @param userPosition 角色id null或者"abc"
	 * @param param 配置参数
	 * @param targetType 考核的类型1=日，2=周，3=月
	 * @param rangeType 考核的范围1=公司，4=门店
	 * @return 一个符合条件的配置数据
	 */
	private ErpFunWorkcountTargetTemplate createOneInsertData(Integer compId,Integer partnerId, Integer deptId, String userPosition,
                                                              AppFunWorkCountTargetSubParam param, Byte targetType, Byte rangeType, Date date) {
		ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = new ErpFunWorkcountTargetTemplate();
		erpFunWorkcountTargetTemplate.setBzwtCount(param.getBzwtCount());
		erpFunWorkcountTargetTemplate.setCkdhCount(param.getCkdhCount());
		erpFunWorkcountTargetTemplate.setCustomerAdd(param.getCustomerAdd());
		erpFunWorkcountTargetTemplate.setDjwtCount(param.getDjwtCount());
		erpFunWorkcountTargetTemplate.setDkCount(param.getDkCount());
		erpFunWorkcountTargetTemplate.setFkCount(param.getFkCount());
		erpFunWorkcountTargetTemplate.setGjCustomerCount(param.getGjCustomerCount());
		erpFunWorkcountTargetTemplate.setGjHouseCount(param.getGjHouseCount());
		erpFunWorkcountTargetTemplate.setHouseAdd(param.getHouseAdd());
		erpFunWorkcountTargetTemplate.setHouseFafaCount(param.getHouseFafaCount());
		erpFunWorkcountTargetTemplate.setKkCount(param.getKkCount());
		erpFunWorkcountTargetTemplate.setPostShareCount(param.getPostShareCount());
		erpFunWorkcountTargetTemplate.setSignDealCount(param.getSignDealCount());
		erpFunWorkcountTargetTemplate.setSpCount(param.getSpCount());
//		erpFunWorkcountTargetTemplate.setTpscCount(param.getTpscCount());
		erpFunWorkcountTargetTemplate.setVrCount(param.getVrCount());
		erpFunWorkcountTargetTemplate.setWtCount(param.getWtCount());
		erpFunWorkcountTargetTemplate.setXswtCount(param.getXswtCount());
		erpFunWorkcountTargetTemplate.setYsCount(param.getYsCount());
		erpFunWorkcountTargetTemplate.setDeptId(deptId);
		erpFunWorkcountTargetTemplate.setUserPosition(userPosition);
		erpFunWorkcountTargetTemplate.setCompId(compId);
		erpFunWorkcountTargetTemplate.setTargetType(targetType);
		erpFunWorkcountTargetTemplate.setCreateTime(date);
		erpFunWorkcountTargetTemplate.setRangeType(rangeType);
		erpFunWorkcountTargetTemplate.setMtCustomerCount(param.getMtCustomerCount());
		erpFunWorkcountTargetTemplate.setMtHouseCount(param.getMtHouseCount());
		erpFunWorkcountTargetTemplate.setKyykCount(param.getKyykCount());
		erpFunWorkcountTargetTemplate.setYjCount(param.getYjCount());
		erpFunWorkcountTargetTemplate.setIpcallCount(param.getIpcallCount());
		erpFunWorkcountTargetTemplate.setPartnerId(partnerId);
		return erpFunWorkcountTargetTemplate;
	}

	/**
	 * 每个门店下每个角色的数据组装
	 */
	private List<ErpFunWorkcountTargetTemplate> assemblyInsertData(Integer compId,Integer partnerId, List<ErpCompRoles> erpCompRolesList,
                                                                   Map<Integer,Integer> dept2Partner, AppFunWorkCountTargetSubParam param, Byte targetType, Date date) {
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		// 组装数据
		if (!erpCompRolesList.isEmpty() && !dept2Partner.isEmpty()) {
			for (ErpCompRoles erpCompRoles : erpCompRolesList) {
				for (Integer deptId : dept2Partner.keySet()) {
					ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = new ErpFunWorkcountTargetTemplate();
					erpFunWorkcountTargetTemplate.setBzwtCount(param.getBzwtCount());
					erpFunWorkcountTargetTemplate.setCkdhCount(param.getCkdhCount());
					erpFunWorkcountTargetTemplate.setCustomerAdd(param.getCustomerAdd());
					erpFunWorkcountTargetTemplate.setDjwtCount(param.getDjwtCount());
					erpFunWorkcountTargetTemplate.setDkCount(param.getDkCount());
					erpFunWorkcountTargetTemplate.setFkCount(param.getFkCount());
					erpFunWorkcountTargetTemplate.setGjCustomerCount(param.getGjCustomerCount());
					erpFunWorkcountTargetTemplate.setGjHouseCount(param.getGjHouseCount());
					erpFunWorkcountTargetTemplate.setHouseAdd(param.getHouseAdd());
					erpFunWorkcountTargetTemplate.setHouseFafaCount(param.getHouseFafaCount());
					erpFunWorkcountTargetTemplate.setKkCount(param.getKkCount());
					erpFunWorkcountTargetTemplate.setPostShareCount(param.getPostShareCount());
					erpFunWorkcountTargetTemplate.setSignDealCount(param.getSignDealCount());
					erpFunWorkcountTargetTemplate.setSpCount(param.getSpCount());
//					erpFunWorkcountTargetTemplate.setTpscCount(param.getTpscCount());
					erpFunWorkcountTargetTemplate.setVrCount(param.getVrCount());
					erpFunWorkcountTargetTemplate.setWtCount(param.getWtCount());
					erpFunWorkcountTargetTemplate.setXswtCount(param.getXswtCount());
					erpFunWorkcountTargetTemplate.setYsCount(param.getYsCount());
					erpFunWorkcountTargetTemplate.setDeptId(deptId);
					erpFunWorkcountTargetTemplate.setUserPosition(erpCompRoles.getRoleId());
					erpFunWorkcountTargetTemplate.setCompId(compId);
					erpFunWorkcountTargetTemplate.setTargetType(targetType);
					erpFunWorkcountTargetTemplate.setCreateTime(date);
					erpFunWorkcountTargetTemplate.setRangeType(Byte.valueOf("4"));
					erpFunWorkcountTargetTemplate.setMtCustomerCount(param.getMtCustomerCount());
					erpFunWorkcountTargetTemplate.setMtHouseCount(param.getMtHouseCount());
					erpFunWorkcountTargetTemplate.setKyykCount(param.getKyykCount());
					erpFunWorkcountTargetTemplate.setYjCount(param.getYjCount());
					erpFunWorkcountTargetTemplate.setIpcallCount(param.getIpcallCount());
					erpFunWorkcountTargetTemplate.setPartnerId(dept2Partner.getOrDefault(deptId, partnerId));
					insertTargetList.add(erpFunWorkcountTargetTemplate);
				}
			}
		}
		return insertTargetList;
	}
	
	/**
	 * 每个门店也要一条角色为null条件的数据
	 */
	private List<ErpFunWorkcountTargetTemplate> assemblyAllDeptInsertData(Integer compId,Integer partnerId,
																		  Map<Integer,Integer> dept2Partner, AppFunWorkCountTargetSubParam param, Byte targetType, Date date) {
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<>();
		for (Integer deptId : dept2Partner.keySet()) {
			insertTargetList.add(createOneInsertData(compId,dept2Partner.getOrDefault(deptId,partnerId), deptId, null, param, targetType, Byte.valueOf("4"), date));
		}
		return insertTargetList;
	}
	
	/**
	 * 每个门店下某一个角色的数据组装
	 */
	private List<ErpFunWorkcountTargetTemplate> assemblyOnePositionInsertData(Integer compId, String userPosition,Map<Integer,Integer> dept2Partner,
																			  AppFunWorkCountTargetSubParam param, Byte targetType, Byte rangeType, Date date) {
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		for (Integer deptId : dept2Partner.keySet()) {
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = new ErpFunWorkcountTargetTemplate();
			erpFunWorkcountTargetTemplate.setBzwtCount(param.getBzwtCount());
			erpFunWorkcountTargetTemplate.setCkdhCount(param.getCkdhCount());
			erpFunWorkcountTargetTemplate.setCustomerAdd(param.getCustomerAdd());
			erpFunWorkcountTargetTemplate.setDjwtCount(param.getDjwtCount());
			erpFunWorkcountTargetTemplate.setDkCount(param.getDkCount());
			erpFunWorkcountTargetTemplate.setFkCount(param.getFkCount());
			erpFunWorkcountTargetTemplate.setGjCustomerCount(param.getGjCustomerCount());
			erpFunWorkcountTargetTemplate.setGjHouseCount(param.getGjHouseCount());
			erpFunWorkcountTargetTemplate.setHouseAdd(param.getHouseAdd());
			erpFunWorkcountTargetTemplate.setHouseFafaCount(param.getHouseFafaCount());
			erpFunWorkcountTargetTemplate.setKkCount(param.getKkCount());
			erpFunWorkcountTargetTemplate.setPostShareCount(param.getPostShareCount());
			erpFunWorkcountTargetTemplate.setSignDealCount(param.getSignDealCount());
			erpFunWorkcountTargetTemplate.setSpCount(param.getSpCount());
			erpFunWorkcountTargetTemplate.setTpscCount(param.getTpscCount());
			erpFunWorkcountTargetTemplate.setVrCount(param.getVrCount());
			erpFunWorkcountTargetTemplate.setWtCount(param.getWtCount());
			erpFunWorkcountTargetTemplate.setXswtCount(param.getXswtCount());
			erpFunWorkcountTargetTemplate.setYsCount(param.getYsCount());
			erpFunWorkcountTargetTemplate.setDeptId(deptId);
			erpFunWorkcountTargetTemplate.setUserPosition(userPosition);
			erpFunWorkcountTargetTemplate.setCompId(compId);
			erpFunWorkcountTargetTemplate.setTargetType(targetType);
			erpFunWorkcountTargetTemplate.setCreateTime(date);
			erpFunWorkcountTargetTemplate.setRangeType(rangeType);
			erpFunWorkcountTargetTemplate.setMtCustomerCount(param.getMtCustomerCount());
			erpFunWorkcountTargetTemplate.setMtHouseCount(param.getMtHouseCount());
			erpFunWorkcountTargetTemplate.setKyykCount(param.getKyykCount());
			erpFunWorkcountTargetTemplate.setYjCount(param.getYjCount());
			erpFunWorkcountTargetTemplate.setIpcallCount(param.getIpcallCount());
			erpFunWorkcountTargetTemplate.setPartnerId(dept2Partner.getOrDefault(deptId,-1));
			insertTargetList.add(erpFunWorkcountTargetTemplate);
		}
		return insertTargetList;
	}
	
	/**
	 * 公司或某门店下的全角色数据准备
	 */
	private List<ErpFunWorkcountTargetTemplate> assemblyAllPositionInsertData(Integer compId,Integer partnerId, Integer deptId,
                                                                              List<ErpCompRoles> erpCompRolesList, AppFunWorkCountTargetSubParam param, Byte targetType, Byte rangeType, Date date) {
		List<ErpFunWorkcountTargetTemplate> insertTargetList = new ArrayList<ErpFunWorkcountTargetTemplate>();
		for (ErpCompRoles erpCompRoles : erpCompRolesList) {
			ErpFunWorkcountTargetTemplate erpFunWorkcountTargetTemplate = new ErpFunWorkcountTargetTemplate();
			erpFunWorkcountTargetTemplate.setBzwtCount(param.getBzwtCount());
			erpFunWorkcountTargetTemplate.setCkdhCount(param.getCkdhCount());
			erpFunWorkcountTargetTemplate.setCustomerAdd(param.getCustomerAdd());
			erpFunWorkcountTargetTemplate.setDjwtCount(param.getDjwtCount());
			erpFunWorkcountTargetTemplate.setDkCount(param.getDkCount());
			erpFunWorkcountTargetTemplate.setFkCount(param.getFkCount());
			erpFunWorkcountTargetTemplate.setGjCustomerCount(param.getGjCustomerCount());
			erpFunWorkcountTargetTemplate.setGjHouseCount(param.getGjHouseCount());
			erpFunWorkcountTargetTemplate.setHouseAdd(param.getHouseAdd());
			erpFunWorkcountTargetTemplate.setHouseFafaCount(param.getHouseFafaCount());
			erpFunWorkcountTargetTemplate.setKkCount(param.getKkCount());
			erpFunWorkcountTargetTemplate.setPostShareCount(param.getPostShareCount());
			erpFunWorkcountTargetTemplate.setSignDealCount(param.getSignDealCount());
			erpFunWorkcountTargetTemplate.setSpCount(param.getSpCount());
//			erpFunWorkcountTargetTemplate.setTpscCount(param.getTpscCount());
			erpFunWorkcountTargetTemplate.setVrCount(param.getVrCount());
			erpFunWorkcountTargetTemplate.setWtCount(param.getWtCount());
			erpFunWorkcountTargetTemplate.setXswtCount(param.getXswtCount());
			erpFunWorkcountTargetTemplate.setYsCount(param.getYsCount());
			erpFunWorkcountTargetTemplate.setDeptId(deptId);
			erpFunWorkcountTargetTemplate.setUserPosition(erpCompRoles.getRoleId());
			erpFunWorkcountTargetTemplate.setCompId(compId);
			erpFunWorkcountTargetTemplate.setTargetType(targetType);
			erpFunWorkcountTargetTemplate.setCreateTime(date);
			erpFunWorkcountTargetTemplate.setRangeType(rangeType);
			erpFunWorkcountTargetTemplate.setMtCustomerCount(param.getMtCustomerCount());
			erpFunWorkcountTargetTemplate.setMtHouseCount(param.getMtHouseCount());
			erpFunWorkcountTargetTemplate.setKyykCount(param.getKyykCount());
			erpFunWorkcountTargetTemplate.setYjCount(param.getYjCount());
			erpFunWorkcountTargetTemplate.setIpcallCount(param.getIpcallCount());
			erpFunWorkcountTargetTemplate.setPartnerId(partnerId);
			insertTargetList.add(erpFunWorkcountTargetTemplate);
		}
		return insertTargetList;
	}
	
	/**
	 * 分批次插入批量数据
	 */
	private void batchInsertBatchData(Integer cityId, List<ErpFunWorkcountTargetTemplate> list) {
		int batchDataCount = 60;
		int remainingDataCount = list.size();
		if (!list.isEmpty()) {
			for (int i = 0; i < list.size(); i = i + batchDataCount) {
				if (remainingDataCount < batchDataCount) {
					batchDataCount = remainingDataCount;
				}
				List<ErpFunWorkcountTargetTemplate> insertTargetList = list.subList(i, i + batchDataCount);
				erpFunWorkcountTargetTemplateMapper.insertBatch(cityId, insertTargetList);
				remainingDataCount = remainingDataCount - batchDataCount;
			}
		}
	}
	/**
	 * 写入时仅写入某个组织的某个角色一条模板记录，userPosition=''代表所有角色，orgId=0表示全公司， eg:userPosition=''&orgId=0表示全公司所有角色的配置，
	 * 	取模板数据时优先级：
	 * 		(userPosition='xxx' & orgId=xxx) >> (userPosition='' & orgId=xxx) >> (userPosition=xxx & orgId=0) >> (userPosition='' & orgId=0)
	 * 	@see ProfitBusinessController#deduceTargetTemplate(List, List, String, byte)
	 *	至于加盟商逻辑为什么这样@link产品
	 */
	@Override
	public void updateWorkCountTargetForOrg(Integer cityId, Integer compId, AppFunWorkCountTargetParam param) {
		//原来的方式设置经纪人工作量目标
		if (Objects.nonNull(param.getOrganizationId()) && param.getOrganizationId() > 0) {
			ErpFunOrganization org = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, param.getOrganizationId());
			Assert.isNullThrow(org,"组织不存在!");
			param.setOrganizationPath(org.getOrganizationPath());
		}
		updateUserWorkCountTargetForOrg(cityId, compId, param);
		if (Objects.nonNull(param.getUserId())) {
			return;
		}
		//设置模板角色模板
		String userPosition = Optional.ofNullable(param.getUserPosition()).orElse("");
		Integer orgId = Optional.ofNullable(param.getOrganizationId()).orElse(0);
		List<Integer> allOrgIds = Collections.emptyList();
		if (orgId != 0) {
			ErpFunOrganizationExample ex = new ErpFunOrganizationExample();
			ex.setShardCityId(cityId);
			ex.createCriteria().andCompIdEqualTo(compId).andOrganizationPathLike(param.getOrganizationPath()+"%").andDelFlagEqualTo((byte)0);
			List<ErpFunOrganization> subOrgList = erpFunOrganizationMapper.selectByExample(ex);
			allOrgIds = subOrgList.stream().map(ErpFunOrganization::getOrganizationId).collect(ArrayList::new,List::add,List::addAll);
		}
		//清除原有模板 当userPosition=''会删除组织下其他角色（见sql），orgId=0会删除所有组织(分加盟商)的当前角色记录
		Set<String> userPositionSet = Stream.of(userPosition.split(",")).collect(Collectors.toSet());

		if ("".equals(userPosition)) {
			erpFunWorkcountTargetOrgTemplateMapper.deleteByOrgIds(cityId, compId, allOrgIds, null, param.getPartnerIds());
		}else {
			erpFunWorkcountTargetOrgTemplateMapper.deleteByOrgIds(cityId, compId, allOrgIds, userPositionSet, param.getPartnerIds());
		}
		//添加当前模板
		if (Objects.nonNull(param.getDayTargetList())) {
			for (String position : userPositionSet) {
				insertTemplate(cityId, compId, param, position, orgId, (byte) 1);
			}
		}
		if (Objects.nonNull(param.getWeekTargetList())) {
			for (String position : userPositionSet) {
				insertTemplate(cityId, compId, param, position, orgId, (byte) 2);
			}
		}
		if (Objects.nonNull(param.getMonthTargetList())) {
			for (String position : userPositionSet) {
				insertTemplate(cityId, compId, param, position, orgId, (byte)3);
			}
		}
	}

	/**
	 * 修改经纪人工作量目标
	 * @param cityId
	 * @param compId
	 * @param param
	 */
	private void updateUserWorkCountTargetForOrg(Integer cityId, Integer compId, AppFunWorkCountTargetParam param) {
		String userPosition = param.getUserPosition();// 选择全部的时候就是空字符串，否则就是对应的角色id
		// 日目标量
		AppFunWorkCountTargetSubParam dayTargetParam = param.getDayTargetList();
		// 周目标量
		AppFunWorkCountTargetSubParam weekTargetParam = param.getWeekTargetList();
		// 月目标量
		AppFunWorkCountTargetSubParam monthTargetParam = param.getMonthTargetList();
		ErpFunUsersExample example = new ErpFunUsersExample();
		example.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = example.createCriteria();
		criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		if (StringUtils.isNotBlank(userPosition)) {
			String userPosition1 = param.getUserPosition();
			String[] split = userPosition1.split(",");
			criteria.andUserPositionIn(Arrays.asList(split));
		}
		//无限组织机构
		if (Objects.nonNull(param.getOrganizationPath())) {
			criteria.andTissueLineLike(param.getOrganizationPath()+"%");
		}
		//加盟商模式添加范围限制
		if (param.isSeparationConfig() && Objects.nonNull(param.getPartnerIds()) && !param.getPartnerIds().isEmpty()) {
			criteria.andPartnerIdIn(param.getPartnerIds());
		}
		Integer countUser = erpFunUsersMapper.countByExample(example);
		if (countUser > 0) {
			List<String> userPositinolist = null;
			if(StringUtils.isNotBlank(userPosition)){
				String[] split = userPosition.split(",");
				userPositinolist = Arrays.asList(split);
			}
			if (null != dayTargetParam) {
				erpFunWorkcountTargetMapper.createTargetForOrg(cityId, compId,param.getPartnerIds(), 1,
						userPositinolist, param.getUserId(),dayTargetParam,param.getOrganizationPath());
			}
			if (null != weekTargetParam) {
				erpFunWorkcountTargetMapper.createTargetForOrg(cityId, compId,param.getPartnerIds(),  2,
						userPositinolist, param.getUserId(),weekTargetParam,param.getOrganizationPath());
			}
			if (null != monthTargetParam) {
				erpFunWorkcountTargetMapper.createTargetForOrg(cityId, compId,param.getPartnerIds(),  3,
						userPositinolist, param.getUserId(),monthTargetParam,param.getOrganizationPath());
			}
		}
	}

	private void insertTemplate(Integer cityId, Integer compId, AppFunWorkCountTargetParam param, String userPosition, Integer orgId,Byte targetType) {
		ErpFunWorkcountTargetOrgTemplate temp = new ErpFunWorkcountTargetOrgTemplate();
		if (targetType == 3) {//月
			BeanUtils.copyProperties(param.getMonthTargetList(), temp);
		}else if(targetType == 2) {//周
			BeanUtils.copyProperties(param.getWeekTargetList(), temp);
		}else {//日
			BeanUtils.copyProperties(param.getDayTargetList(), temp);
		}
		temp.setShardCityId(cityId);
		temp.setCompId(compId);
		temp.setOrganizationId(orgId);
		temp.setTargetType(targetType);
		temp.setUserPosition(userPosition);
		temp.setPartnerId(-1);
		temp.setCreateTime(new Date());
		erpFunWorkcountTargetOrgTemplateMapper.insertSelective(temp);
	}
}