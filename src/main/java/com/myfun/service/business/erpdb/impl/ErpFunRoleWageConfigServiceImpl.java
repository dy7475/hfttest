package com.myfun.service.business.erpdb.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.repository.admindb.dao.AdminFunRecalculateWageInfoMapper;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfo;
import com.myfun.repository.admindb.po.AdminFunRecalculateWageInfoExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunRoleWageConfigDto;
import com.myfun.repository.erpdb.dto.ErpFunWageTypeNewDto;
import com.myfun.repository.erpdb.dto.WageCountTypePackDto;
import com.myfun.repository.erpdb.param.RoleWageConfigParam;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.service.business.erpdb.ErpFunRoleWageConfigService;
import com.myfun.service.business.erpdb.ErpSalaryTypeRelativeService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ErpFunRoleWageConfigServiceImpl extends AbstractService<ErpFunRoleWageConfig, ErpFunRoleWageConfig> implements ErpFunRoleWageConfigService {

	@Autowired
	private ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpFunRoleWageWorkcountMapper erpFunRoleWageWorkcountMapper;
	@Autowired
	ErpFunRoleWageProfitMapper erpFunRoleWageProfitMapper;
	@Autowired
	ErpRoleWagetypeRelativeMapper erpRoleWagetypeRelativeMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpSalaryTypeRelativeMapper erpSalaryTypeRelativeMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpSysParaService erpSysParaService;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpFunAssessmentStatisticsMapper erpFunAssessmentStatisticsMapper;
	@Autowired
	AdminFunRecalculateWageInfoMapper adminFunRecalculateWageInfoMapper;
	@Autowired
	ErpFunWageMapper erpFunWageMapper;
	@Autowired
	ErpFunWageTypeNewMapper erpFunWageTypeNewMapper;
	@Autowired
	ErpFunCountwageMapper erpFunCountwageMapper;
	@Autowired
	ErpSalaryTypeRelativeService erpSalaryTypeRelativeService;
	@Autowired
	AdminFunCompService adminFunCompService;
	

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunRoleWageConfigMapper;
	}

	@Transactional
	@Override
	public void salaryConfigApplyOtherRoles(Integer adminCompId, Integer cityId, Integer compId, Integer userId, RoleWageConfigParam config) {
		
		//是否是房基地的直销模式
		boolean isFjd = adminFunCompService.judgerIsFangjidi(adminCompId);
		
        //所有配置要应用到的角色ID
        List<String> roleIdList = new ArrayList<>();
        roleIdList.add(config.getRoleId());
		if (config.getOtherRoleIds().contains(",")){
            List<String> othrerRoleId = Arrays.asList(config.getOtherRoleIds().split(","));
            roleIdList.addAll(othrerRoleId);
        } else {
            roleIdList.add(config.getOtherRoleIds());
        }

		String paramValue = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(paramValue, 0);

		//获取所有的主表
		List<ErpFunRoleWageConfig> roleWageConfigList = erpFunRoleWageConfigMapper.selectFunRoleWageConfigListByRoleIdList(roleIdList, assessMentMonth, compId, cityId, (byte) 1);

		// 删除关联关系
		ErpSalaryTypeRelative erpSalaryTypeRelative = null;

		//1.FUN_ROLE_WAGE_CONFIG主表数据处理
		if (CollectionUtils.isNotEmpty(roleWageConfigList)) {
			//根据roleId进行分组
			Map<String, List<ErpFunRoleWageConfig>> roleWageConfigMapList = roleWageConfigList.stream().collect(Collectors.groupingBy(ErpFunRoleWageConfig::getRoleId));
			for (int i = 0;i < roleIdList.size();++i) {
				List<ErpFunRoleWageConfig> configList = roleWageConfigMapList.get(roleIdList.get(i));
				//主表不存在，插入主表
				if (CollectionUtils.isEmpty(configList)) {
					config.setShardCityId(cityId);
					config.setCreateTime(new Date());
					config.setCompId(compId);
					config.setCreateUid(userId);
					config.setAssessmentMonth(assessMentMonth);
					config.setRoleId(roleIdList.get(i));//覆盖角色ID
					erpFunRoleWageConfigMapper.insertSelective(config);
					Integer funRoleWageConfigId = config.getId();
					config.setId(funRoleWageConfigId);//覆盖传递过来的Id

					// 关联到人数据
					// 查询角色上所有人
					erpSalaryTypeRelativeService.initUserBaseSalaryTypeRelative(cityId, compId, roleIdList.get(i), config.getId());
					
					//1.插入子表的数据
					// 工作量的数据
					this.updateRoleWageConfigWorkCountData(cityId, compId, config);
					// 业绩考核的数据
					this.updateRoleWageConfigProfitData(cityId, compId, config);

					Map<String,ErpRoleWagetypeRelative> relativeMap = this.updateRoleWageConfigCommonsionData(cityId, compId,i,config);

					if(null != relativeMap) {
						//管理提成
						String manageWageTypeData = config.getWageTypeNewManageJson();
						if (StringUtil.isNotEmpty(manageWageTypeData) && !"[]".equals(manageWageTypeData)) {
							//app端，如果是门店及以上的管理应用到分组上，分组上的方案无店均，需要把分组的店均的业绩修改为总业绩，产品大白需求
							Boolean isGroup = judgeIsGroups(cityId,compId,i,roleIdList.get(i));
							updateWageTypeData(cityId, compId,i,manageWageTypeData, relativeMap.get("m"), assessMentMonth,isGroup);
						} else if ((StringUtil.isEmpty(manageWageTypeData) || "[]".equals(manageWageTypeData)) && null != relativeMap.get("m")) {
							getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("m"));
							erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("m"));
						}
						//业务提成
						String bussinessWageTypeData = config.getWageTypeNewBusinessJson();
						if (StringUtil.isNotEmpty(bussinessWageTypeData) && !"[]".equals(bussinessWageTypeData)) {
							updateWageTypeData(cityId, compId,i,bussinessWageTypeData, relativeMap.get("b"), assessMentMonth,false);
						} else if ((StringUtil.isEmpty(bussinessWageTypeData) || "[]".equals(bussinessWageTypeData)) && null != relativeMap.get("b")) {
							getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("b"));
							erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("b"));
						}
					}
					// 往admin 记录表写数据  处理
					List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleIdList.get(i), null, compId);
					// 查询有哪些人需要处理
					AdminFunRecalculateWageInfoExample adminFunRecalculateWageInfoExample = new AdminFunRecalculateWageInfoExample();
					adminFunRecalculateWageInfoExample.createCriteria().andCityIdEqualTo(cityId).andRoleIdEqualTo(roleIdList.get(i)).
							andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth);
					List<AdminFunRecalculateWageInfo> adminFunRecalculateWageInfoList = adminFunRecalculateWageInfoMapper.selectByExample(adminFunRecalculateWageInfoExample);
					Set<Integer> userIdsSet = new HashSet<>(adminFunRecalculateWageInfoList.size());
					if (adminFunRecalculateWageInfoList.size() > 0) {
						userIdsSet = adminFunRecalculateWageInfoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
					}

					if (CollectionUtils.isNotEmpty(userListForRole)) {
						for (ErpFunUsers erpFunUsers : userListForRole) {
							String userPosition = erpFunUsers.getUserPosition();
							// 查询结算日
							ErpFunRoleWageConfigDto roleWageConfig = this.getRoleWageConfigInfo(cityId, compId, userPosition, null, assessMentMonth);
							if (null != roleWageConfig) {
								ErpSalaryTypeRelative salaryTypeRelative = new ErpSalaryTypeRelative();
								salaryTypeRelative.setAreaId(erpFunUsers.getAreaId());
								salaryTypeRelative.setRegId(erpFunUsers.getRegId());
								salaryTypeRelative.setDeptId(erpFunUsers.getDeptId());
								salaryTypeRelative.setGrId(erpFunUsers.getGrId());
								salaryTypeRelative.setUserId(erpFunUsers.getUserId());
								salaryTypeRelative.setRoleId(userPosition);
								salaryTypeRelative.setCreationTime(new Date());
								salaryTypeRelative.setSalaryTypeId(roleWageConfig.getId());
								salaryTypeRelative.setDelFlag(0);
								salaryTypeRelative.setCompId(compId);
								salaryTypeRelative.setShardCityId(cityId);
								erpSalaryTypeRelativeMapper.insertSelective(salaryTypeRelative);

								ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
								if (null == erpFunWage) {
									erpFunWageMapper.initWageByUserId(cityId, compId, erpFunUsers.getUserId(), config.getBaseWage(), assessMentMonth, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 1, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 2, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 1, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 2, 1, 1);
								}
							}
						}

						for (ErpFunUsers erpFunUsers : userListForRole) {
							Integer userId1 = erpFunUsers.getUserId();
							if (!userIdsSet.contains(userId1)) {
								AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
								adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
								adminFunRecalculateWageInfo.setCityId(cityId);
								adminFunRecalculateWageInfo.setCompId(compId);
								adminFunRecalculateWageInfo.setCreationTime(new Date());
								adminFunRecalculateWageInfo.setRoleId(roleIdList.get(i));
								adminFunRecalculateWageInfo.setUserId(userId1);
								if(isFjd){
									adminFunRecalculateWageInfo.setCustomizedType(1);
								}
								try {
									adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
									// 这里加了数据库唯一锁  所以try一下
								}catch (Exception e) {

								}
							}
						}
					}
				} else {
					//主表存在，更新
					config.setRoleId(roleIdList.get(i));//覆盖角色Id
					if (configList.size() > 1) {
						//脏数据处理
						configList.sort((val1, val2) -> {
							return Optional.ofNullable(val2.getId()).orElse(0) - Optional.ofNullable(val1.getId()).orElse(0);
						});
					}
					config.setId(configList.get(0).getId());//覆盖该值
					erpFunRoleWageConfigMapper.updateBaseWageById(cityId, config);
					erpSalaryTypeRelative = new ErpSalaryTypeRelative();
					erpSalaryTypeRelative.setDelFlag(1);
					erpSalaryTypeRelative.setDelTime(new Date());
					ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
					erpSalaryTypeRelativeExample.setShardCityId(cityId);
					erpSalaryTypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(config.getId());
					erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);

					// 关联到人数据
					// 查询角色上所有人
					erpSalaryTypeRelativeService.initUserBaseSalaryTypeRelative(cityId, compId, roleIdList.get(i), config.getId());
					//插入子表的数据
					// 工作量的数据
					Integer workCountManager = updateRoleWageConfigWorkCountData(cityId, compId, config);
					// 业绩考核的数据
					Integer profitManager = updateRoleWageConfigProfitData(cityId, compId, config);

					//先更新主表提成的部分数据，得到更新的relative,之后再更新relative上绑定的方案
					Map<String,ErpRoleWagetypeRelative> relativeMap = updateRoleWageConfigCommonsionData(cityId, compId,i,config);
					if(null != relativeMap) {
						//管理提成
						String manageWageTypeData = config.getWageTypeNewManageJson();
						if (StringUtil.isNotEmpty(manageWageTypeData) && !"[]".equals(manageWageTypeData)) {
							//app端，如果是门店及以上的管理应用到分组上，分组上的方案无店均，需要把分组的店均的业绩修改为总业绩，产品大白需求
							Boolean isGroup = judgeIsGroups(cityId,compId,i,roleIdList.get(i));
							updateWageTypeData(cityId, compId,i, manageWageTypeData, relativeMap.get("m"), assessMentMonth,isGroup);
						} else if ((StringUtil.isEmpty(manageWageTypeData) || "[]".equals(manageWageTypeData)) && null != relativeMap.get("m")) {
							getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("m"));
							erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("m"));
						}
						//业务提成
						String bussinessWageTypeData = config.getWageTypeNewBusinessJson();
						if (StringUtil.isNotEmpty(bussinessWageTypeData) && !"[]".equals(bussinessWageTypeData)) {
							updateWageTypeData(cityId, compId,i, bussinessWageTypeData, relativeMap.get("b"), assessMentMonth,false);
						} else if ((StringUtil.isEmpty(bussinessWageTypeData) || "[]".equals(bussinessWageTypeData)) && null != relativeMap.get("b")) {
							getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("b"));
							erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("b"));
						}
					}
					// 往admin 记录表写数据  处理
					List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleIdList.get(i), null, compId);
					// 查询有哪些人需要处理
					AdminFunRecalculateWageInfoExample adminFunRecalculateWageInfoExample = new AdminFunRecalculateWageInfoExample();
					adminFunRecalculateWageInfoExample.createCriteria().andCityIdEqualTo(cityId).andRoleIdEqualTo(roleIdList.get(i)).
							andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth);
					List<AdminFunRecalculateWageInfo> adminFunRecalculateWageInfoList = adminFunRecalculateWageInfoMapper.selectByExample(adminFunRecalculateWageInfoExample);
					Set<Integer> userIdsSet = new HashSet<>(adminFunRecalculateWageInfoList.size());
					if (adminFunRecalculateWageInfoList.size() > 0) {
						userIdsSet = adminFunRecalculateWageInfoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
					}
					if (CollectionUtils.isNotEmpty(userListForRole)) {
						for (ErpFunUsers erpFunUsers : userListForRole) {
							String userPosition = erpFunUsers.getUserPosition();
							// 查询结算日
							ErpFunRoleWageConfigDto roleWageConfig = this.getRoleWageConfigInfo(cityId, compId, userPosition, null, assessMentMonth);
							if (null != roleWageConfig) {
								ErpSalaryTypeRelative salaryTypeRelative = new ErpSalaryTypeRelative();
								salaryTypeRelative.setAreaId(erpFunUsers.getAreaId());
								salaryTypeRelative.setRegId(erpFunUsers.getRegId());
								salaryTypeRelative.setDeptId(erpFunUsers.getDeptId());
								salaryTypeRelative.setGrId(erpFunUsers.getGrId());
								salaryTypeRelative.setUserId(erpFunUsers.getUserId());
								salaryTypeRelative.setRoleId(userPosition);
								salaryTypeRelative.setCreationTime(new Date());
								salaryTypeRelative.setSalaryTypeId(roleWageConfig.getId());
								salaryTypeRelative.setDelFlag(0);
								salaryTypeRelative.setCompId(compId);
								salaryTypeRelative.setShardCityId(cityId);
								erpSalaryTypeRelativeMapper.insertSelective(salaryTypeRelative);

								ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
								if (null == erpFunWage) {
									erpFunWageMapper.initWageByUserId(cityId, compId, erpFunUsers.getUserId(), config.getBaseWage(), assessMentMonth, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 1, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 2, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 1, 1, 1);
									erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 2, 1, 1);
								}

							}
						}
						for (ErpFunUsers erpFunUsers : userListForRole) {
							Integer userId1 = erpFunUsers.getUserId();
							if (!userIdsSet.contains(userId1)) {
								AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
								adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
								adminFunRecalculateWageInfo.setCityId(cityId);
								adminFunRecalculateWageInfo.setCompId(compId);
								adminFunRecalculateWageInfo.setCreationTime(new Date());
								adminFunRecalculateWageInfo.setRoleId(roleIdList.get(i));
								adminFunRecalculateWageInfo.setUserId(userId1);
								if(isFjd){
									adminFunRecalculateWageInfo.setCustomizedType(1);
								}
								try {
									adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
									// 这里加了数据库唯一锁  所以try一下
								}catch (Exception e) {

								}
							}
						}
					}
				}
			}
		} else {
			//主表不存在，插入
			config.setShardCityId(cityId);
			config.setCreateTime(new Date());
			config.setCompId(compId);
			config.setCreateUid(userId);
			config.setAssessmentMonth(assessMentMonth);
			for (int i = 0;i < roleIdList.size();++i) {
				config.setRoleId(roleIdList.get(i));
				erpFunRoleWageConfigMapper.insertSelective(config);
				Integer funRoleWageConfigId = config.getId();
				config.setId(funRoleWageConfigId);//覆盖可能传递过来的Id

				// 关联到人数据
				// 查询角色上所有人
				erpSalaryTypeRelativeService.initUserBaseSalaryTypeRelative(cityId, compId, roleIdList.get(i), config.getId());

				//插入子表的数据
				// 工作量的数据
				updateRoleWageConfigWorkCountData(cityId, compId, config);
				// 业绩考核的数据
				updateRoleWageConfigProfitData(cityId, compId, config);
				//先更新主表提成的部分数据，得到更新的relative,之后再更新relative上绑定的方案
				Map<String,ErpRoleWagetypeRelative> relativeMap = updateRoleWageConfigCommonsionData(cityId, compId,i,config);
				if(null != relativeMap) {
					//管理提成
					String manageWageTypeData = config.getWageTypeNewManageJson();
					if (StringUtil.isNotEmpty(manageWageTypeData) && !"[]".equals(manageWageTypeData)) {
						//app端，如果是门店及以上的管理应用到分组上，分组上的方案无店均，需要把分组的店均的业绩修改为总业绩，产品大白需求
						Boolean isGroup = judgeIsGroups(cityId,compId,i,roleIdList.get(i));
						updateWageTypeData(cityId, compId,i, manageWageTypeData, relativeMap.get("m"), assessMentMonth,isGroup);
					} else if ((StringUtil.isEmpty(manageWageTypeData) || "[]".equals(manageWageTypeData)) && null != relativeMap.get("m")) {
						getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("m"));
						erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("m"));
					}
					//业务提成
					String bussinessWageTypeData = config.getWageTypeNewBusinessJson();
					if (StringUtil.isNotEmpty(bussinessWageTypeData) && !"[]".equals(bussinessWageTypeData)) {
						updateWageTypeData(cityId, compId,i, bussinessWageTypeData, relativeMap.get("b"), assessMentMonth,false);
					} else if ((StringUtil.isEmpty(bussinessWageTypeData) || "[]".equals(bussinessWageTypeData)) && null != relativeMap.get("b")) {
						getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("b"));
						erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("b"));
					}
				}
				// 往admin 记录表写数据  处理
				List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleIdList.get(i), null, compId);
				// 查询有哪些人需要处理
				AdminFunRecalculateWageInfoExample adminFunRecalculateWageInfoExample = new AdminFunRecalculateWageInfoExample();
				adminFunRecalculateWageInfoExample.createCriteria().andCityIdEqualTo(cityId).andRoleIdEqualTo(roleIdList.get(i)).
						andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth);
				List<AdminFunRecalculateWageInfo> adminFunRecalculateWageInfoList = adminFunRecalculateWageInfoMapper.selectByExample(adminFunRecalculateWageInfoExample);
				Set<Integer> userIdsSet = new HashSet<>(adminFunRecalculateWageInfoList.size());
				if (adminFunRecalculateWageInfoList.size() > 0) {
					userIdsSet = adminFunRecalculateWageInfoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
				}
				if (CollectionUtils.isNotEmpty(userListForRole)) {
					for (ErpFunUsers erpFunUsers : userListForRole) {
						String userPosition = erpFunUsers.getUserPosition();
						// 查询结算日
						ErpFunRoleWageConfigDto roleWageConfig = this.getRoleWageConfigInfo(cityId, compId, userPosition, null, assessMentMonth);
						if (null != roleWageConfig) {
							ErpSalaryTypeRelative salaryTypeRelative = new ErpSalaryTypeRelative();
							salaryTypeRelative.setAreaId(erpFunUsers.getAreaId());
							salaryTypeRelative.setRegId(erpFunUsers.getRegId());
							salaryTypeRelative.setDeptId(erpFunUsers.getDeptId());
							salaryTypeRelative.setGrId(erpFunUsers.getGrId());
							salaryTypeRelative.setUserId(erpFunUsers.getUserId());
							salaryTypeRelative.setRoleId(userPosition);
							salaryTypeRelative.setCreationTime(new Date());
							salaryTypeRelative.setSalaryTypeId(roleWageConfig.getId());
							salaryTypeRelative.setDelFlag(0);
							salaryTypeRelative.setCompId(compId);
							salaryTypeRelative.setShardCityId(cityId);
							erpSalaryTypeRelativeMapper.insertSelective(salaryTypeRelative);

							ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
							if (null == erpFunWage) {
								erpFunWageMapper.initWageByUserId(cityId, compId, erpFunUsers.getUserId(), config.getBaseWage(), assessMentMonth, 1);
								erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 1, 1, 1);
								erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 2, 1, 1);
								erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 1, 1, 1);
								erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 2, 1, 1);
							}

						}
					}

					for (ErpFunUsers erpFunUsers : userListForRole) {
						Integer userId1 = erpFunUsers.getUserId();
						if (!userIdsSet.contains(userId1)) {
							AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
							adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
							adminFunRecalculateWageInfo.setCityId(cityId);
							adminFunRecalculateWageInfo.setCompId(compId);
							adminFunRecalculateWageInfo.setCreationTime(new Date());
							adminFunRecalculateWageInfo.setRoleId(roleIdList.get(i));
							adminFunRecalculateWageInfo.setUserId(userId1);
							if(isFjd){
								adminFunRecalculateWageInfo.setCustomizedType(1);
							}
							try {
								adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
								// 这里加了数据库唯一锁  所以try一下
							}catch (Exception e) {

							}
						}
					}
				}
			}
		}
	}

	/**
	 * @Title 配置角色的考核方案
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	@Transactional
	@Override
	public Integer updateRoleWageConfig(Integer adminCompId, Integer cityId, Integer compId, Integer userId, RoleWageConfigParam roleWageConfigParam) {

		Integer id = roleWageConfigParam.getId();
		Integer roleLevelId = roleWageConfigParam.getRoleLevelId();
		/** 1.更新角色考核方案的本身数据
		 *  2.判断是否有传值，没有传值就代表不考核此项，有的话就更新，这里不做新增的处理
		 *  3.写日志
		 */
		String paramValue = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, userId,"WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(paramValue, 0);

		// 修改薪资配置看是算哪个月  当月还是下月
		Boolean isConfigNextMonth = false;
		String updateWageConfigEffective = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, userId,"UPDATE_WAGE_CONFIG_EFFECTIVE");
		// 不为空 并且大于0
		if(StringUtils.isNotBlank(updateWageConfigEffective) && StringUtil.parseInteger(updateWageConfigEffective, 0) > 0) {
			Integer configDay = StringUtil.parseInteger(updateWageConfigEffective, 0);
			Calendar calendar = Calendar.getInstance();
			Integer nowDay = calendar.get(Calendar.DAY_OF_MONTH);
			// 下月的
			String nextMonthAssessMentMonth = DateUtil.getAssessMentMonth(paramValue, 1);
			if(nowDay > configDay) {
				assessMentMonth = nextMonthAssessMentMonth;
				// 自行再查找
				roleWageConfigParam.setId(null);
				id = null;
				isConfigNextMonth = true;
			}else{
				// 逻辑是修改系统参数后不做配置上的修改，但是再去修改配置的话就会根据系统参数来操作，如果是本月的话就该把下月配置清除掉
				ErpFunRoleWageConfig updateConfigPo = new ErpFunRoleWageConfig();
				updateConfigPo.setIsCheck((byte) 0);
				// 应该修改在本月，就需要把下月配置干掉
				ErpFunRoleWageConfigExample updateConfigExample = new ErpFunRoleWageConfigExample();
				updateConfigExample.setShardCityId(cityId);
				updateConfigExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).andAssessmentMonthEqualTo(nextMonthAssessMentMonth).andIsCheckEqualTo((byte) 1);
				erpFunRoleWageConfigMapper.updateByExampleSelective(updateConfigPo, updateConfigExample);
			}
		}

		// 删除关联关系
		ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
		// 1.更新本身的数据
		if (null != id) {
			erpFunRoleWageConfigMapper.updateBaseWageById(cityId, roleWageConfigParam);
			erpSalaryTypeRelative.setDelFlag(1);
			erpSalaryTypeRelative.setDelTime(new Date());
			ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
			erpSalaryTypeRelativeExample.setShardCityId(cityId);
			erpSalaryTypeRelativeExample.createCriteria().andCompIdEqualTo(compId).andSalaryTypeIdEqualTo(roleWageConfigParam.getId());
			erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);
		} else {
			List<ErpFunRoleWageConfig> erpFunRoleWageConfigs = new ArrayList<ErpFunRoleWageConfig>();
			// 查询一下，防止前端bug，解决以前的BUG，这段代码不要删除
			if(roleLevelId == null || roleLevelId == 0){
				ErpFunRoleWageConfigExample roleWageConfigExample = new ErpFunRoleWageConfigExample();
				roleWageConfigExample.setShardCityId(cityId);
				roleWageConfigExample.setOrderByClause(" ID DESC ");
				roleWageConfigExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).andAssessmentMonthEqualTo(assessMentMonth).andIsCheckEqualTo((byte) 1);
				erpFunRoleWageConfigs = erpFunRoleWageConfigMapper.selectByExample(roleWageConfigExample);
			}
			// 已经有配置了，前端漏传ID
			if(erpFunRoleWageConfigs.size() > 0) {
				ErpFunRoleWageConfig erpFunRoleWageConfig = erpFunRoleWageConfigs.get(0);
				roleWageConfigParam.setId(erpFunRoleWageConfig.getId());
				erpFunRoleWageConfigMapper.updateBaseWageById(cityId, roleWageConfigParam);

				erpSalaryTypeRelative.setDelFlag(1);
				erpSalaryTypeRelative.setDelTime(new Date());
				ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
				erpSalaryTypeRelativeExample.setShardCityId(cityId);
				erpSalaryTypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(erpFunRoleWageConfig.getId());
				erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);
			}else {
				roleWageConfigParam.setShardCityId(cityId);
				roleWageConfigParam.setCreateTime(new Date());
				roleWageConfigParam.setCompId(compId);
				roleWageConfigParam.setCreateUid(userId);
				roleWageConfigParam.setAssessmentMonth(assessMentMonth);
				erpFunRoleWageConfigMapper.insertSelective(roleWageConfigParam);
			}
		}

		// 关联到人数据
		// 查询角色上所有人
		erpSalaryTypeRelativeService.initUserBaseSalaryTypeRelative(cityId, compId, roleWageConfigParam.getRoleId(), roleWageConfigParam.getId());

		// 工作量的数据
		updateRoleWageConfigWorkCountData(cityId, compId, roleWageConfigParam);

		// 业绩考核的数据
		updateRoleWageConfigProfitData(cityId, compId, roleWageConfigParam);

		if(isConfigNextMonth) {
			// 如果是影响到下月的，那就不用处理员工数据，taskWeb 会在月初统一处理员工数据和关联数据
			return roleWageConfigParam.getId();
		}

		//先更新主表提成的部分数据，得到更新的relative,之后再更新relative上绑定的方案
		Map<String,ErpRoleWagetypeRelative> relativeMap = updateRoleWageConfigCommonsionData(cityId, compId,0,roleWageConfigParam);

		if(null != relativeMap) {
			//管理提成
			String manageWageTypeData = roleWageConfigParam.getWageTypeNewManageJson();
			if (StringUtil.isNotEmpty(manageWageTypeData) && !"[]".equals(manageWageTypeData)) {
				updateWageTypeData(cityId, compId,0, manageWageTypeData, relativeMap.get("m"), assessMentMonth,false);
			} else if ((StringUtil.isEmpty(manageWageTypeData) || "[]".equals(manageWageTypeData)) && null != relativeMap.get("m")) {
				getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("m"));
				erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("m"));
			}
			//业务提成
			String bussinessWageTypeData = roleWageConfigParam.getWageTypeNewBusinessJson();
			if (StringUtil.isNotEmpty(bussinessWageTypeData) && !"[]".equals(bussinessWageTypeData)) {
				updateWageTypeData(cityId, compId,0, bussinessWageTypeData, relativeMap.get("b"), assessMentMonth,false);
			} else if ((StringUtil.isEmpty(bussinessWageTypeData) || "[]".equals(bussinessWageTypeData)) && null != relativeMap.get("b")) {
				getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("b"));
				erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("b"));
			}
		}
		//业务提成方案的数据更新
		// 3.写系统日志

//		// 4：如果是新增，判断下统计有没有数据，没有就初始化
//		if(null != id) {
//			// 有操作管理数据
//			if(workCountManager + profitManager > 0) {
//				erpFunAssessmentStatisticsMapper.mergeAssessmentStaticsData(cityId, compId, roleWageConfigParam.getRoleId(), assessMentMonth, roleWageConfigParam.getId());
//			}
//		}

		// 往admin 记录表写数据  处理
		List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleWageConfigParam.getRoleId(), null, compId);
		// 查询有哪些人需要处理
		AdminFunRecalculateWageInfoExample adminFunRecalculateWageInfoExample = new AdminFunRecalculateWageInfoExample();
		adminFunRecalculateWageInfoExample.createCriteria().andCityIdEqualTo(cityId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).
				andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth);
		List<AdminFunRecalculateWageInfo> adminFunRecalculateWageInfoList = adminFunRecalculateWageInfoMapper.selectByExample(adminFunRecalculateWageInfoExample);
		Set<Integer> userIdsSet = new HashSet<>(adminFunRecalculateWageInfoList.size());
		if (adminFunRecalculateWageInfoList.size() > 0) {
			userIdsSet = adminFunRecalculateWageInfoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
		}

		for (ErpFunUsers erpFunUsers : userListForRole) {
			String userPosition = erpFunUsers.getUserPosition();
			// 查询结算日
			ErpFunRoleWageConfigDto roleWageConfig = this.getRoleWageConfigInfo(cityId, compId, userPosition, null, assessMentMonth);
			if (null != roleWageConfig) {

				ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
				if (null == erpFunWage) {
					// 防止有错误数据，直接清除掉
					erpFunWageMapper.initWageByUserId(cityId, compId, erpFunUsers.getUserId(), roleWageConfig.getBaseWage(), assessMentMonth, 1);

					ErpFunAssessmentStatisticsExample assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
					assessmentStatisticsExample.setShardCityId(cityId);
					assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(erpFunUsers.getUserId());
					erpFunAssessmentStatisticsMapper.deleteByExample(assessmentStatisticsExample);

					erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 1, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 2, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 1, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsData(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 2, 1, 1);
				}
			}
		}

		//是否是房基地的直销模式
		boolean isFjd = adminFunCompService.judgerIsFangjidi(adminCompId);
		for (ErpFunUsers erpFunUsers : userListForRole) {
			Integer userId1 = erpFunUsers.getUserId();
			if (!userIdsSet.contains(userId1)) {
				AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
				adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
				adminFunRecalculateWageInfo.setCityId(cityId);
				adminFunRecalculateWageInfo.setCompId(compId);
				adminFunRecalculateWageInfo.setCreationTime(new Date());
				adminFunRecalculateWageInfo.setRoleId(roleWageConfigParam.getRoleId());
				adminFunRecalculateWageInfo.setUserId(userId1);
				if(isFjd){
					adminFunRecalculateWageInfo.setCustomizedType(1);
				}
				try {
					adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
					// 这里加了数据库唯一锁  所以try一下
				}catch (Exception e) {

				}
			}
		}
		return roleWageConfigParam.getId();
	}

	/**
	 * @Title 提成数据的更新
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	private Map<String,ErpRoleWagetypeRelative> updateRoleWageConfigCommonsionData(Integer cityId, Integer compId,Integer i, RoleWageConfigParam roleWageConfigParam) {
		String businessCommsionData = roleWageConfigParam.getErpRoleWagetypeRelativeList();
		// 删除关联的普通数据
		closeRoleWageConfigCommsion(cityId, roleWageConfigParam.getId());
		if (StringUtils.isNotBlank(businessCommsionData)) {
			// 解析成列表做更新
			List<ErpRoleWagetypeRelative> erpFunRoleWageWorkcountList = JSON.parseObject(businessCommsionData, new TypeReference<List<ErpRoleWagetypeRelative>>() {});
			return updateRoleWageConfigCommision(cityId, compId,roleWageConfigParam.getId(),i, erpFunRoleWageWorkcountList);
		}
		return null;
	}

	/**
	 * @Title 工作量数据的更新
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	private Integer updateRoleWageConfigWorkCountData(Integer cityId, Integer compId, RoleWageConfigParam roleWageConfigParam) {

		Integer res = 0;
		String personWorkCountData = roleWageConfigParam.getErpFunRoleWageWorkcountList();
		// 删除关联的个人数据
		closeRoleWageConfigWorkCount(cityId, roleWageConfigParam.getId());
		if (StringUtils.isNotBlank(personWorkCountData)) {
			// 解析成列表做更新
			List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList = JSON.parseObject(personWorkCountData, new TypeReference<List<ErpFunRoleWageWorkcount>>() {});
			res = updateRoleWageConfigWorkCount(cityId, compId, roleWageConfigParam.getId(), erpFunRoleWageWorkcountList);
		}

		return res;
	}

	/**
	 * @Title 业绩考核数据的更新
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param
	 **/
	private Integer updateRoleWageConfigProfitData(Integer cityId, Integer compId, RoleWageConfigParam roleWageConfigParam) {
		Integer res = 0;
		String personProfitData = roleWageConfigParam.getErpFunRoleWageProfitList();
		closeRoleWageConfigProfit(cityId, roleWageConfigParam.getId());
		if (StringUtils.isNotBlank(personProfitData)) {
			// 解析成列表做更新
			List<ErpFunRoleWageProfit> erpFunRoleWageProfitList = JSON.parseObject(personProfitData, new TypeReference<List<ErpFunRoleWageProfit>>() {
			});
			res = updateRoleWageConfigProfit(cityId, compId, roleWageConfigParam.getId(), erpFunRoleWageProfitList);
		}
		return res;
	}

	/**
	 * @Title 删除、作废业绩考核的数据
	 * @Author lcb
	 * @Date 2018/1/5
	 **/
	private void closeRoleWageConfigProfit(Integer cityId, Integer roleWageConfigId) {
		ErpFunRoleWageProfit erpFunRoleWageProfit = new ErpFunRoleWageProfit();
		erpFunRoleWageProfit.setIsCheck((byte) 0);
		ErpFunRoleWageProfitExample erpFunRoleWageProfitExample = new ErpFunRoleWageProfitExample();
		erpFunRoleWageProfitExample.setShardCityId(cityId);
		erpFunRoleWageProfitExample.createCriteria().andRoleWageConfigIdEqualTo(roleWageConfigId);
		erpFunRoleWageProfitMapper.updateByExampleSelective(erpFunRoleWageProfit, erpFunRoleWageProfitExample);
	}

	/**
	 * @Title 删除、作废工作量考核的数据
	 * @Author lcb
	 * @Date 2018/1/5

	 **/
	private void closeRoleWageConfigCommsion(Integer cityId, Integer roleWageConfigId) {
		ErpRoleWagetypeRelative erpRoleWagetypeRelative = new ErpRoleWagetypeRelative();
		erpRoleWagetypeRelative.setIsCheck((byte) 0);
		ErpRoleWagetypeRelativeExample erpRoleWagetypeRelativeExample = new ErpRoleWagetypeRelativeExample();
		erpRoleWagetypeRelativeExample.setShardCityId(cityId);
		erpRoleWagetypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(roleWageConfigId);
		erpRoleWagetypeRelativeMapper.updateByExampleSelective(erpRoleWagetypeRelative, erpRoleWagetypeRelativeExample);
	}

	/**
	 * @Title 删除、作废工作量考核的数据
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param configType 0 业务人员 1管理人员
	 **/
	private void closeRoleWageConfigWorkCount(Integer cityId, Integer roleWageConfigId) {
		ErpFunRoleWageWorkcount erpFunRoleWageWorkcount = new ErpFunRoleWageWorkcount();
		erpFunRoleWageWorkcount.setIsCheck((byte) 0);
		ErpFunRoleWageWorkcountExample erpFunRoleWageWorkcountExample = new ErpFunRoleWageWorkcountExample();
		erpFunRoleWageWorkcountExample.setShardCityId(cityId);
	    erpFunRoleWageWorkcountExample.createCriteria().andRoleWageConfigIdEqualTo(roleWageConfigId);
		erpFunRoleWageWorkcountMapper.updateByExampleSelective(erpFunRoleWageWorkcount, erpFunRoleWageWorkcountExample);
	}

	/**
	 * @Title 更新工作量考核的数据
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param checkConfigType 0业务人员 1管理人员
	 **/
	private Integer updateRoleWageConfigWorkCount(Integer cityId, Integer compId, Integer id, List<ErpFunRoleWageWorkcount> erpFunRoleWageWorkcountList) {
		Integer containManageData = 0;
		Integer total = erpFunRoleWageWorkcountList.size();
		for (ErpFunRoleWageWorkcount erpFunRoleWageWorkcount : erpFunRoleWageWorkcountList) {
			erpFunRoleWageWorkcount.setWorkcountSeq(total);
			erpFunRoleWageWorkcount.setShardCityId(cityId);
			erpFunRoleWageWorkcount.setCompId(compId);
			erpFunRoleWageWorkcount.setCreateTime(new Date());
			erpFunRoleWageWorkcount.setIsCheck((byte) 1);
			erpFunRoleWageWorkcount.setRoleWageConfigId(id);
			erpFunRoleWageWorkcountMapper.insertSelective(erpFunRoleWageWorkcount);

			Byte checkType = erpFunRoleWageWorkcount.getCheckType();
			if (null != checkType && 2 == erpFunRoleWageWorkcount.getCheckType().intValue() && 0 == containManageData) {
				containManageData = 1;
			}
			total--;
		}
		return containManageData;
	}

	/**
	 * @Title 更新工作量考核的数据
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param checkConfigType 0业务人员 1管理人员
	 **/
	private Integer updateRoleWageConfigProfit(Integer cityId, Integer compId, Integer id, List<ErpFunRoleWageProfit> erpFunRoleWageProfitList) {
		Integer res = 0;

		Integer total = erpFunRoleWageProfitList.size();
		for (ErpFunRoleWageProfit erpFunRoleWageProfit : erpFunRoleWageProfitList) {
			erpFunRoleWageProfit.setProfitSeq(total);
			erpFunRoleWageProfit.setCompId(compId);
			erpFunRoleWageProfit.setIsCheck((byte) 1);
			erpFunRoleWageProfit.setShardCityId(cityId);
			erpFunRoleWageProfit.setCreateTime(new Date());
			erpFunRoleWageProfit.setRoleWageConfigId(id);
			erpFunRoleWageProfitMapper.insertSelective(erpFunRoleWageProfit);
			total--;
			Byte checkType = erpFunRoleWageProfit.getCheckType();

			if (null != checkType && checkType.intValue() == 2 && res == 0) {
				res = 1;
			}
		}

		return res;
	}

	/**
	 * @Title 更新工作量考核的数据
	 * @Author lcb
	 * @Date 2018/1/5
	 * @Param i 该条件是为了控制角色配置并应用到其它角色的条件
	 **/
	private Map<String,ErpRoleWagetypeRelative> updateRoleWageConfigCommision(Integer cityId, Integer compId, Integer id, Integer i, List<ErpRoleWagetypeRelative> relativeList) {
		Map<String,ErpRoleWagetypeRelative> wagetypeRelativeMap = new HashMap<>();
		if ( i > 0) {
			for (ErpRoleWagetypeRelative relative : relativeList) {
				relative.setCompId(compId);
				relative.setIsCheck((byte) 1);
				relative.setShardCityId(cityId);
				relative.setSalaryTypeId(id);
				relative.setId(null);
				if (relative.getCountType() == 0) {
					erpRoleWagetypeRelativeMapper.insertSelective(relative);
					wagetypeRelativeMap.put("b",relative);
				} else if (relative.getCountType() == 1) {
					erpRoleWagetypeRelativeMapper.insertSelective(relative);
					wagetypeRelativeMap.put("m", relative);
				}
			}
		} else{
			for (ErpRoleWagetypeRelative relative : relativeList) {
				relative.setCompId(compId);
				relative.setIsCheck((byte) 1);
				relative.setShardCityId(cityId);
				relative.setSalaryTypeId(id);
				if (null == relative.getId() && relative.getCountType() == 0) {
					erpRoleWagetypeRelativeMapper.insertSelective(relative);
					wagetypeRelativeMap.put("b",relative);
				} else if (null == relative.getId() && relative.getCountType() == 1) {
					erpRoleWagetypeRelativeMapper.insertSelective(relative);
					wagetypeRelativeMap.put("m", relative);
				} else if (null != relative.getId() && relative.getCountType() == 0){
					erpRoleWagetypeRelativeMapper.updateByPrimaryKeySelective(relative);
					wagetypeRelativeMap.put("b",relative);
				}else if (null != relative.getId() && relative.getCountType() == 1) {
					erpRoleWagetypeRelativeMapper.updateByPrimaryKeySelective(relative);
					wagetypeRelativeMap.put("m", relative);
				}
			}
		}
		return wagetypeRelativeMap;
	}

	/**
	 * 1.更新方案--> 2.更新方案下的提成区间--> 3.更新绑定最新方案的提成
	 * @param cityId 城市ID
	 * @param compId 公司Id
	 * @param wageTypeData 提成数据
	 * @param relativeDB 旧的提成
	 * @param assessMentMonth 结算月
	 */
	private void updateWageTypeData(Integer cityId, Integer compId,Integer i,String wageTypeData,ErpRoleWagetypeRelative relativeDB,String assessMentMonth,Boolean isGroup) {
		//旧的方案ID
		List<String> wageTypeIds = getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeDB);

		// 解析成列表做更新
		List<ErpFunWageTypeNewDto> manageWageTypeDataList = JSON.parseObject(wageTypeData, new TypeReference<List<ErpFunWageTypeNewDto>>() {});
		Map<String, Integer> wageTypeNewIdMap = new HashMap<>();
		//新增的方案Id
		List<String> newWageTypeIds = manageWageTypeDataList.stream().map(val -> (val.getId() + "")).collect(Collectors.toList());
		List<String> deleteTypeIds = new ArrayList<>();
		//比起上一次，删除了一些方案，把这些删除的方案删除，但是必须注意的是老数据的方案不能删除，只删除新数据的
		//老数据的方案都没有绑定角色方案配置ID(ROLE_WAGETYPE_RELATIVE表主键)
		if(CollectionUtils.isNotEmpty(wageTypeIds)) {
			for (String wageTypeId : wageTypeIds) {
				if(!newWageTypeIds.contains(wageTypeId)){
					deleteTypeIds.add(wageTypeId);
				}
			}
		}
		if (CollectionUtils.isNotEmpty(deleteTypeIds)){
			List<ErpFunWageTypeNewDto> deleteWageType = erpFunWageTypeNewMapper.getMyWageTypeDtoListByIds(cityId,compId,deleteTypeIds);
			//过滤掉老数据的方案，老数据的方案不删除
			List<String> realDeleteTypeIds = deleteWageType.stream().filter(val -> val.getRoleWagetypeRelativeId() != null).map(val -> (val.getId() + "")).collect(Collectors.toList());
			if (CollectionUtils.isNotEmpty(realDeleteTypeIds)) {
				//删除主表Fun_wage_type_new
				erpFunWageTypeNewMapper.deleteBatchByIds(cityId, compId, realDeleteTypeIds);
				//删除子表fun_countwage
				erpFunCountwageMapper.deleteBatchByWageTypeId(cityId, compId, realDeleteTypeIds);
			}
		}
		for (ErpFunWageTypeNewDto erpFunWageTypeNewDto : manageWageTypeDataList) {
		    //保存并应用到其它角色时，重新生成一份新的方案
		    if (i > 0) {
                erpFunWageTypeNewDto.setId(null);
            }
			//新增方案
			if (null == erpFunWageTypeNewDto.getId()) {
				ErpFunWageTypeNew erpFunWageTypeNew = new ErpFunWageTypeNew();
				BeanUtils.copyProperties(erpFunWageTypeNewDto, erpFunWageTypeNew, "countWageJson");
				erpFunWageTypeNew.setShardCityId(cityId);
				erpFunWageTypeNew.setCompId(compId);
				erpFunWageTypeNew.setIsCheck((byte) 1);
				erpFunWageTypeNew.setCreateDate(DateTimeHelper.formatDateTimetoString(new Date(), "yyyy-MM-dd HH:mm:ss"));
				erpFunWageTypeNew.setRoleWagetypeRelativeId(relativeDB.getId());
				erpFunWageTypeNew.setAssessmentMonth(assessMentMonth);
                if (isNeedUpdate(isGroup,erpFunWageTypeNewDto)){
                	//分组无店均，把店均设置为总业绩
					erpFunWageTypeNew.setProfitRange((byte)2);
				}
				erpFunWageTypeNewMapper.insertSelective(erpFunWageTypeNew);
				Integer newId = erpFunWageTypeNew.getId();
				setRelative4NewWageTypeIds(erpFunWageTypeNew.getPerformanceType(), newId,relativeDB);
				insertCountWageBatch(cityId, compId, erpFunWageTypeNewDto, newId);
			} else {//有id，更新
				ErpFunWageTypeNew erpFunWageTypeNew = new ErpFunWageTypeNew();
				erpFunWageTypeNew.setId(erpFunWageTypeNewDto.getId());
				erpFunWageTypeNew.setShardCityId(cityId);
				erpFunWageTypeNew.setCompId(compId);
				erpFunWageTypeNew = erpFunWageTypeNewMapper.selectByPrimaryKey(erpFunWageTypeNew);

				//说明是新数据，需要进行更新
				if (null != erpFunWageTypeNew && erpFunWageTypeNew.getRoleWagetypeRelativeId() != null){
					BeanUtils.copyProperties(erpFunWageTypeNewDto,erpFunWageTypeNew,new String[]{"countWageJson","createDate"});
					erpFunWageTypeNew.setShardCityId(cityId);
					//更新主表，需要返回方案的id
					erpFunWageTypeNew.setAssessmentMonth(assessMentMonth);
					if (isNeedUpdate(isGroup,erpFunWageTypeNewDto)){
						//分组无店均，把店均设置为总业绩
						erpFunWageTypeNew.setProfitRange((byte)2);
					}
					erpFunWageTypeNewMapper.updateByPrimaryKeySelective(erpFunWageTypeNew);
					Integer id = erpFunWageTypeNew.getId();
					setRelative4NewWageTypeIds(erpFunWageTypeNew.getPerformanceType(), id,relativeDB);
					//更新子表，先全部删除，再进行插入
					erpFunCountwageMapper.deleteByWageTypeId(cityId,compId,id);
					insertCountWageBatch(cityId, compId, erpFunWageTypeNewDto, id);
				} else { //此时可能是老数据，也可能数据库中没有这个方案
					//更新主表
					erpFunWageTypeNew = new  ErpFunWageTypeNew();
					BeanUtils.copyProperties(erpFunWageTypeNewDto,erpFunWageTypeNew,"countWageJson");
					erpFunWageTypeNew.setShardCityId(cityId);
					//把id置为null，重新再插入一条
					erpFunWageTypeNew.setId(null);
				    erpFunWageTypeNew.setRoleWagetypeRelativeId(relativeDB.getId());
					erpFunWageTypeNew.setAssessmentMonth(assessMentMonth);
					erpFunWageTypeNew.setCreateDate(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-dd HH:mm:ss"));
					if (isNeedUpdate(isGroup,erpFunWageTypeNewDto)){
						//分组无店均，把店均设置为总业绩
						erpFunWageTypeNew.setProfitRange((byte)2);
					}
					erpFunWageTypeNewMapper.insertSelective(erpFunWageTypeNew);
					Integer id = erpFunWageTypeNew.getId();
					setRelative4NewWageTypeIds(erpFunWageTypeNew.getPerformanceType(),id,relativeDB);
					//更新子表，原来的子表也不动，重新插入1条新的
					insertCountWageBatch(cityId, compId, erpFunWageTypeNewDto, id);
				}
			}
		}
        //循环完成后，更新绑定了最新方案的提成
		//老数据处理，如果以前只是配值总业绩(0),需要改成新的总业绩(6)
		Boolean isNeed = isNeedDealOldData(relativeDB);
		if (isNeed){
			relativeDB.setNewtotalId(relativeDB.getTotalId());
			relativeDB.setTotalId(null);
			relativeDB.setRoyaltyType((byte)2);
		}
		erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId,relativeDB);
	}

	/**
	 * 得到旧提成上面的方案ID集合，并清除旧提成上面的所有方案
	 * 为绑定新方案作准备
	 * @param relativeDB
	 */
	private List<String> getRelativeOldWageTypeIdsAndClearOldWageTypeIds(ErpRoleWagetypeRelative relativeDB) {
		List<String> wageTypeIds = new ArrayList<>();
		if (relativeDB.getTransferId() != null ) {
			wageTypeIds.add(relativeDB.getTransferId() + "");
			relativeDB.setTransferId(null);
		}
		if (relativeDB.getSecondhandId() != null ) {
			wageTypeIds.add(relativeDB.getSecondhandId() + "");
			relativeDB.setSecondhandId(null);
		}
		if (relativeDB.getLeaseId() != null ) {
			wageTypeIds.add(relativeDB.getLeaseId() + "");
			relativeDB.setLeaseId(null);
		}
		if (relativeDB.getFinanceId() != null ) {
			wageTypeIds.add(relativeDB.getFinanceId() + "");
			relativeDB.setFinanceId(null);
		}
		if (relativeDB.getNewhouseId() != null ) {
			wageTypeIds.add(relativeDB.getNewhouseId() + "");
			relativeDB.setNewhouseId(null);
		}
		if (relativeDB.getTotalId() != null ) {
			wageTypeIds.add(relativeDB.getTotalId() + "");
			relativeDB.setTotalId(null);
		}
		if (relativeDB.getNewtotalId() != null ) {
			wageTypeIds.add(relativeDB.getNewtotalId() + "");
			relativeDB.setNewtotalId(null);
		}
		return  wageTypeIds;
	}

	/**
	 * 批量插入每个方案下的提成区间
	 * @param cityId
	 * @param compId
	 * @param erpFunWageTypeNewDto
	 * @param newWageTypeId 插入的新的提成方案的ID
	 */
	private void insertCountWageBatch(Integer cityId, Integer compId, ErpFunWageTypeNewDto erpFunWageTypeNewDto, Integer newWageTypeId) {
		String countWageData = erpFunWageTypeNewDto.getCountWageJson();
		if (StringUtil.isNotEmpty(countWageData)) {
            List<ErpFunCountwage> funCountWageDataList = JSON.parseObject(countWageData, new TypeReference<List<ErpFunCountwage>>() {
            });
            int seq = 1;
            for (ErpFunCountwage erpFunCountwage : funCountWageDataList) {
                erpFunCountwage.setSeq(seq);
                erpFunCountwage.setWagetypeId(newWageTypeId);
                erpFunCountwage.setCompId(compId);
                erpFunCountwage.setShardCityId(cityId);
                seq++;
            }
            erpFunCountwageMapper.insertBatch(cityId, funCountWageDataList);
        }
	}

	/**
	 * 为提成赋上新生产的方案ids
	 * @param
	 */
	private void setRelative4NewWageTypeIds(Byte type, Integer id,ErpRoleWagetypeRelative relativeDB) {
		if (type == 1) {
			relativeDB.setTransferId(id);
		} else if (type == 2) {
			relativeDB.setSecondhandId(id);
		} else if (type == 3) {
			relativeDB.setNewhouseId(id);
		} else if (type == 4) {
			relativeDB.setLeaseId(id);
		} else if (type == 5) {
			relativeDB.setFinanceId(id);
		}else if (type == 6) {
			relativeDB.setTotalId(id);
		} else if (type == 7) {
			relativeDB.setNewtotalId(id);
		}

	}

	/**
	 * 老数据只配置了方案->总业绩(6) 需要改成新版的总业绩(7)
	 * @param relative
	 * @return
	 */
	private boolean isNeedDealOldData(ErpRoleWagetypeRelative relative){
		if (null != relative.getTotalId() && null == relative.getTransferId() && null == relative.getNewhouseId()
				&& null == relative.getLeaseId() && null == relative.getFinanceId() && null == relative.getSecondhandId()
				&& null == relative.getNewtotalId()) {
			return true;
		}
		return  false;
	}

	/**
	 * 判断该角色的管理层级是不是分组
	 * @param cityId
	 * @param compId
	 * @param i 循环次数
	 * @param roleId
	 * @return
	 */
	private Boolean judgeIsGroups(Integer cityId,Integer compId,Integer i,String  roleId){
		//第二次的角色才是应用到其它角色
		if (i > 0){
			ErpCompRoles  erpCompRoles = erpCompRolesMapper.getByRoleId(cityId,compId,roleId);
			if (null != erpCompRoles && erpCompRoles.getManageLevel() == 5){
				return true;
			}
			return false;
		}
		return false;
	}

	/**
	 * 满足以下3条件，需要把其它分组的业绩设置为店均业绩
	 * 1.首要保存角色的方案是管理
	 * 2.首要保存角色的业绩范围是店均
	 * 3.应用到的角色必须是分组
	 * @param isGroup
	 * @param funWageTypeNew
	 * @return
	 */
	private Boolean  isNeedUpdate(Boolean isGroup,ErpFunWageTypeNewDto funWageTypeNew) {
		if (isGroup && funWageTypeNew.getManagePlan() == 1 && funWageTypeNew.getProfitRange() == 1) {
             return true;
		}
      return false;
	}

	@Override
	public ErpFunRoleWageConfigDto getRoleWageConfigInfo(Integer cityId, Integer compId, String roleId, Integer roleLevelId, String assessMentMonth) {
		ErpFunRoleWageConfigDto roleWageConfig = null;
		if(roleLevelId != null && roleLevelId > 0){
			roleWageConfig = erpFunRoleWageConfigMapper.getRoleWageConfig(cityId, compId, roleId, roleLevelId, assessMentMonth);
		}
		//如果为空则再查询一次基本配置，
		if (null == roleWageConfig) {
			roleWageConfig = erpFunRoleWageConfigMapper.getRoleWageConfig(cityId, compId, roleId, null, assessMentMonth);
		}
		return roleWageConfig;
	}

	@Override
	@Transactional
	public void deleteWageRoleLevelAfterInitBase(Integer oldWageConfigId, Integer baseWageConfigId, Integer compId, Integer cityId, String roleId, Integer roleLevelId) {
		
		//更新原有配置为无效
		ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
		erpSalaryTypeRelative.setDelFlag(1);
		erpSalaryTypeRelative.setDelTime(new Date());
		ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
		erpSalaryTypeRelativeExample.setShardCityId(cityId);
		erpSalaryTypeRelativeExample.createCriteria().andCompIdEqualTo(compId).andSalaryTypeIdEqualTo(oldWageConfigId);
		erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);
		
		List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleId, null, compId);
		if (CollectionUtils.isNotEmpty(userListForRole)) {
			List<Integer> userIds = new ArrayList<Integer>();
			for (ErpFunUsers erpFunUsers : userListForRole) {
				if(roleLevelId != null && erpFunUsers.getRoleLevelId() != null 
						&& roleLevelId.intValue() != erpFunUsers.getRoleLevelId()){
					continue;
				}
				userIds.add(erpFunUsers.getUserId());
			}
			
			if(!userIds.isEmpty()){
				erpSalaryTypeRelativeMapper.batCreateWageConfigForUsers(cityId, compId, userIds, baseWageConfigId);
			}
		}
	}

	@Override
	public Map<Byte, WageCountTypePackDto> getUserFunCountWageType(Integer compId, Integer cityId, Integer userId, String assessMentMonth, Set<Integer> perosonPerformanceType) {
		ErpFunRoleWageConfig erpFunRoleWageConfig = erpFunRoleWageConfigMapper.selectRoleWageConfigByUserId(cityId, compId, userId, assessMentMonth);
		if(null == erpFunRoleWageConfig) {
			return null;
		}
		ErpRoleWagetypeRelativeExample erpRoleWagetypeRelativeExample = new ErpRoleWagetypeRelativeExample();
		erpRoleWagetypeRelativeExample.setShardCityId(cityId);
		erpRoleWagetypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(erpFunRoleWageConfig.getId()).andCountTypeEqualTo((byte)0).andIsCheckEqualTo((byte)1);
		// 查询到个人的提成业绩
		List<ErpRoleWagetypeRelative> erpRoleWagetypeRelativeList = erpRoleWagetypeRelativeMapper.selectByExample(erpRoleWagetypeRelativeExample);
		if(erpRoleWagetypeRelativeList.size() == 0) {
			return null;
		}
		if(perosonPerformanceType == null || perosonPerformanceType.isEmpty()){
			return null;
		}
		Map<Byte, WageCountTypePackDto> tmpResult = new HashMap<>();
		// 个人提成配置-这里就直接循环查询了，数据不多
		ErpRoleWagetypeRelative erpRoleWagetypeRelative = erpRoleWagetypeRelativeList.get(0);
		Byte royaltyType = (byte) 1;
		//业绩合并计算的话，业绩类别只有7
		if(erpRoleWagetypeRelative.getRoyaltyType() == 2){
			perosonPerformanceType = new HashSet<Integer>(Arrays.asList(7));
			royaltyType = (byte) 2;
		}
		for(Integer erpFunPerformanceType : perosonPerformanceType){
			//查询提成标准
			ErpFunWageTypeNew erpFunWageTypeNew = this.getFunWageTypeByPerformanceId(cityId, erpRoleWagetypeRelative, erpFunPerformanceType);
			if(null == erpFunWageTypeNew) {
				return null;
			}
			//查询提成区间列表
			ErpFunCountwageExample erpFunCountwageExample = new ErpFunCountwageExample();
			erpFunCountwageExample.setShardCityId(cityId);
			erpFunCountwageExample.createCriteria().andWagetypeIdEqualTo(erpFunWageTypeNew.getId());
			erpFunCountwageExample.setOrderByClause("SEQ asc");
			List<ErpFunCountwage> erpFunCountwages = erpFunCountwageMapper.selectByExample(erpFunCountwageExample);
			WageCountTypePackDto result = new WageCountTypePackDto();
			result.setRoyaltyType(royaltyType);
			result.setErpFunWageTypeNew(erpFunWageTypeNew);
			result.setCountWageTypeList(erpFunCountwages);
			tmpResult.put(Byte.valueOf(erpFunPerformanceType.toString()), result);
		}
		return tmpResult;
	}
	
	/**
	 * 根据业绩类别 查询提成
	 * @Package com.myfun.service.business.erpdb.impl 
	 * @author 陈文超   
	 * @date 2019年9月5日 下午5:09:38
	 */
	private ErpFunWageTypeNew getFunWageTypeByPerformanceId(Integer cityId, ErpRoleWagetypeRelative erpRoleWagetypeRelative, Integer performanceType) {
		// performanceType 1=过户 2=二手佣金 3=新房佣金 4=租赁租金 5=金融 6是总业绩 7新的总业绩
		Integer relativeId = null;
		switch (performanceType.intValue()) {
			case 1:
				relativeId = erpRoleWagetypeRelative.getTransferId();
				break;
			case 2:
				relativeId = erpRoleWagetypeRelative.getSecondhandId();
				break;
			case 3:
				relativeId = erpRoleWagetypeRelative.getNewhouseId();
				break;
			case 4:
				relativeId = erpRoleWagetypeRelative.getLeaseId();
				break;
			case 5:
				relativeId = erpRoleWagetypeRelative.getFinanceId();
				break;
			case 6:
				relativeId = erpRoleWagetypeRelative.getTotalId();
				break;
			case 7:
				relativeId = erpRoleWagetypeRelative.getNewtotalId();
				break;
		}
		ErpFunWageTypeNew result = null;
		// 根据id 查询
		// 没有提成方案
		if(null == relativeId) {
			return null;
		}
		ErpFunWageTypeNew erpFunWageTypeNew = new ErpFunWageTypeNew();
		erpFunWageTypeNew.setId(relativeId);
		erpFunWageTypeNew.setShardCityId(cityId);
		result = erpFunWageTypeNewMapper.selectByPrimaryKey(erpFunWageTypeNew);
		return result;
	}

	/**
	 * @title 新版组织架构修改配置
	 * @author Lee
	 * @date 2019/12/16 22:48
	 ***/
	@Transactional
	@Override
	public Integer updateRoleWageConfigNewOrg(Integer adminCompId, Integer cityId, Integer compId, Integer userId, RoleWageConfigParam roleWageConfigParam) {

		Integer id = roleWageConfigParam.getId();
		Integer roleLevelId = roleWageConfigParam.getRoleLevelId();
		/** 1.更新角色考核方案的本身数据
		 *  2.判断是否有传值，没有传值就代表不考核此项，有的话就更新，这里不做新增的处理
		 *  3.写日志
		 */
		String paramValue = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, userId,"WAGE_ACCOUNTING_DAY");
		String assessMentMonth = DateUtil.getAssessMentMonth(paramValue, 0);

		// 修改薪资配置看是算哪个月  当月还是下月
		Boolean isConfigNextMonth = false;
		String updateWageConfigEffective = erpSysParaService.getMLSysParamValByUserDefZero(cityId, compId, userId,"UPDATE_WAGE_CONFIG_EFFECTIVE");
		// 不为空 并且大于0
		if(StringUtils.isNotBlank(updateWageConfigEffective) && StringUtil.parseInteger(updateWageConfigEffective, 0) > 0) {
			Integer configDay = StringUtil.parseInteger(updateWageConfigEffective, 0);
			Calendar calendar = Calendar.getInstance();
			Integer nowDay = calendar.get(Calendar.DAY_OF_MONTH);
			// 下月的
			String nextMonthAssessMentMonth = DateUtil.getAssessMentMonth(paramValue, 1);
			if(nowDay > configDay) {
				assessMentMonth = nextMonthAssessMentMonth;
				// 自行再查找
				roleWageConfigParam.setId(null);
				id = null;
				isConfigNextMonth = true;
			}else{
				// 逻辑是修改系统参数后不做配置上的修改，但是再去修改配置的话就会根据系统参数来操作，如果是本月的话就该把下月配置清除掉
				ErpFunRoleWageConfig updateConfigPo = new ErpFunRoleWageConfig();
				updateConfigPo.setIsCheck((byte) 0);
				// 应该修改在本月，就需要把下月配置干掉
				ErpFunRoleWageConfigExample updateConfigExample = new ErpFunRoleWageConfigExample();
				updateConfigExample.setShardCityId(cityId);
				updateConfigExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).andAssessmentMonthEqualTo(nextMonthAssessMentMonth).andIsCheckEqualTo((byte) 1);
				erpFunRoleWageConfigMapper.updateByExampleSelective(updateConfigPo, updateConfigExample);
			}
		}

		// 删除关联关系
		ErpSalaryTypeRelative erpSalaryTypeRelative = new ErpSalaryTypeRelative();
		// 1.更新本身的数据
		if (null != id) {
			erpFunRoleWageConfigMapper.updateBaseWageById(cityId, roleWageConfigParam);
			erpSalaryTypeRelative.setDelFlag(1);
			erpSalaryTypeRelative.setDelTime(new Date());
			ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
			erpSalaryTypeRelativeExample.setShardCityId(cityId);
			erpSalaryTypeRelativeExample.createCriteria().andCompIdEqualTo(compId).andSalaryTypeIdEqualTo(roleWageConfigParam.getId());
			erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);
		} else {
			List<ErpFunRoleWageConfig> erpFunRoleWageConfigs = new ArrayList<ErpFunRoleWageConfig>();
			// 查询一下，防止前端bug，解决以前的BUG，这段代码不要删除
			if(roleLevelId == null || roleLevelId == 0){
				ErpFunRoleWageConfigExample roleWageConfigExample = new ErpFunRoleWageConfigExample();
				roleWageConfigExample.setShardCityId(cityId);
				roleWageConfigExample.setOrderByClause(" ID DESC ");
				roleWageConfigExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).andAssessmentMonthEqualTo(assessMentMonth).andIsCheckEqualTo((byte) 1);
				erpFunRoleWageConfigs = erpFunRoleWageConfigMapper.selectByExample(roleWageConfigExample);
			}
			// 已经有配置了，前端漏传ID
			if(erpFunRoleWageConfigs.size() > 0) {
				ErpFunRoleWageConfig erpFunRoleWageConfig = erpFunRoleWageConfigs.get(0);
				roleWageConfigParam.setId(erpFunRoleWageConfig.getId());
				erpFunRoleWageConfigMapper.updateBaseWageById(cityId, roleWageConfigParam);

				erpSalaryTypeRelative.setDelFlag(1);
				erpSalaryTypeRelative.setDelTime(new Date());
				ErpSalaryTypeRelativeExample erpSalaryTypeRelativeExample = new ErpSalaryTypeRelativeExample();
				erpSalaryTypeRelativeExample.setShardCityId(cityId);
				erpSalaryTypeRelativeExample.createCriteria().andSalaryTypeIdEqualTo(erpFunRoleWageConfig.getId());
				erpSalaryTypeRelativeMapper.updateByExampleSelective(erpSalaryTypeRelative, erpSalaryTypeRelativeExample);
			}else {
				roleWageConfigParam.setShardCityId(cityId);
				roleWageConfigParam.setCreateTime(new Date());
				roleWageConfigParam.setCompId(compId);
				roleWageConfigParam.setCreateUid(userId);
				roleWageConfigParam.setAssessmentMonth(assessMentMonth);
				erpFunRoleWageConfigMapper.insertSelective(roleWageConfigParam);
			}
		}

		// 关联到人数据
		// 查询角色上所有人
		erpSalaryTypeRelativeService.initUserBaseSalaryTypeRelative(cityId, compId, roleWageConfigParam.getRoleId(), roleWageConfigParam.getId());

		// 工作量的数据
		updateRoleWageConfigWorkCountData(cityId, compId, roleWageConfigParam);

		// 业绩考核的数据
		updateRoleWageConfigProfitData(cityId, compId, roleWageConfigParam);

		if(isConfigNextMonth) {
			// 如果是影响到下月的，那就不用处理员工数据，taskWeb 会在月初统一处理员工数据和关联数据
			return roleWageConfigParam.getId();
		}

		//先更新主表提成的部分数据，得到更新的relative,之后再更新relative上绑定的方案
		Map<String,ErpRoleWagetypeRelative> relativeMap = updateRoleWageConfigCommonsionData(cityId, compId,0,roleWageConfigParam);

		if(null != relativeMap) {
			//管理提成
			String manageWageTypeData = roleWageConfigParam.getWageTypeNewManageJson();
			if (StringUtil.isNotEmpty(manageWageTypeData) && !"[]".equals(manageWageTypeData)) {
				updateWageTypeData(cityId, compId,0, manageWageTypeData, relativeMap.get("m"), assessMentMonth,false);
			} else if ((StringUtil.isEmpty(manageWageTypeData) || "[]".equals(manageWageTypeData)) && null != relativeMap.get("m")) {
				getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("m"));
				erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("m"));
			}
			//业务提成
			String bussinessWageTypeData = roleWageConfigParam.getWageTypeNewBusinessJson();
			if (StringUtil.isNotEmpty(bussinessWageTypeData) && !"[]".equals(bussinessWageTypeData)) {
				updateWageTypeData(cityId, compId,0, bussinessWageTypeData, relativeMap.get("b"), assessMentMonth,false);
			} else if ((StringUtil.isEmpty(bussinessWageTypeData) || "[]".equals(bussinessWageTypeData)) && null != relativeMap.get("b")) {
				getRelativeOldWageTypeIdsAndClearOldWageTypeIds(relativeMap.get("b"));
				erpRoleWagetypeRelativeMapper.canUpdateFiledIsNull(cityId, relativeMap.get("b"));
			}
		}
		//业务提成方案的数据更新
		// 3.写系统日志

//		// 4：如果是新增，判断下统计有没有数据，没有就初始化
//		if(null != id) {
//			// 有操作管理数据
//			if(workCountManager + profitManager > 0) {
//				erpFunAssessmentStatisticsMapper.mergeAssessmentStaticsData(cityId, compId, roleWageConfigParam.getRoleId(), assessMentMonth, roleWageConfigParam.getId());
//			}
//		}

		// 往admin 记录表写数据  处理
		List<ErpFunUsers> userListForRole = erpFunUsersMapper.getUserListForRole(cityId, roleWageConfigParam.getRoleId(), null, compId);
		// 查询有哪些人需要处理
		AdminFunRecalculateWageInfoExample adminFunRecalculateWageInfoExample = new AdminFunRecalculateWageInfoExample();
		adminFunRecalculateWageInfoExample.createCriteria().andCityIdEqualTo(cityId).andRoleIdEqualTo(roleWageConfigParam.getRoleId()).
				andCompIdEqualTo(compId).andAssessmentMonthEqualTo(assessMentMonth);
		List<AdminFunRecalculateWageInfo> adminFunRecalculateWageInfoList = adminFunRecalculateWageInfoMapper.selectByExample(adminFunRecalculateWageInfoExample);
		Set<Integer> userIdsSet = new HashSet<>(adminFunRecalculateWageInfoList.size());
		if (adminFunRecalculateWageInfoList.size() > 0) {
			userIdsSet = adminFunRecalculateWageInfoList.stream().collect(Collectors.mapping(val -> val.getUserId(), Collectors.toSet()));
		}

		for (ErpFunUsers erpFunUsers : userListForRole) {
			String userPosition = erpFunUsers.getUserPosition();
			// 查询结算日
			ErpFunRoleWageConfigDto roleWageConfig = this.getRoleWageConfigInfo(cityId, compId, userPosition, null, assessMentMonth);
			if (null != roleWageConfig) {

				ErpFunWage erpFunWage = erpFunWageMapper.getFunWageByUserId(cityId, compId, erpFunUsers.getUserId(), assessMentMonth);
				if (null == erpFunWage) {
					// 防止有错误数据，直接清除掉
					erpFunWageMapper.initWageByUserId(cityId, compId, erpFunUsers.getUserId(), roleWageConfig.getBaseWage(), assessMentMonth, 1);

					ErpFunAssessmentStatisticsExample assessmentStatisticsExample = new ErpFunAssessmentStatisticsExample();
					assessmentStatisticsExample.setShardCityId(cityId);
					assessmentStatisticsExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(erpFunUsers.getUserId());
					erpFunAssessmentStatisticsMapper.deleteByExample(assessmentStatisticsExample);

					erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 1, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 1, 2, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 1, 1, 1);
					erpFunAssessmentStatisticsMapper.initAssessmentStaticsDataNew(cityId, compId, erpFunUsers.getUserId(), userPosition, assessMentMonth, roleWageConfig.getId(), 2, 2, 1, 1);
				}
			}
		}

		//是否是房基地的直销模式
		boolean isFjd = adminFunCompService.judgerIsFangjidi(adminCompId);
		for (ErpFunUsers erpFunUsers : userListForRole) {
			Integer userId1 = erpFunUsers.getUserId();
			if (!userIdsSet.contains(userId1)) {
				AdminFunRecalculateWageInfo adminFunRecalculateWageInfo = new AdminFunRecalculateWageInfo();
				adminFunRecalculateWageInfo.setAssessmentMonth(assessMentMonth);
				adminFunRecalculateWageInfo.setCityId(cityId);
				adminFunRecalculateWageInfo.setCompId(compId);
				adminFunRecalculateWageInfo.setCreationTime(new Date());
				adminFunRecalculateWageInfo.setRoleId(roleWageConfigParam.getRoleId());
				adminFunRecalculateWageInfo.setUserId(userId1);
				if(isFjd){
					adminFunRecalculateWageInfo.setCustomizedType(1);
				}
				try {
					adminFunRecalculateWageInfoMapper.insertSelective(adminFunRecalculateWageInfo);
					// 这里加了数据库唯一锁  所以try一下
				}catch (Exception e) {

				}
			}
		}
		return roleWageConfigParam.getId();
	}
}
