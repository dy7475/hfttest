package com.myfun.service.business.erpdb.impl;

import static com.myfun.framework.session.ThreadLocalHelper.getOperator;

import java.util.*;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.userOpers.vo.FunOpersVO;
import com.myfun.erpWeb.openApi.attendance.vo.ErpOutLogVO;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunOpersDto;
import com.myfun.repository.erpdb.dto.ErpUserOpersDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.*;
import com.myfun.utils.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.extension.framework.codis.util.CacheUtil;
import com.myfun.erpWeb.managecenter.userOpers.param.UpdatePermissionTemplateParam;
import com.myfun.erpWeb.managecenter.userOpers.param.UpdateRolePermissionTemplateParam;
import com.myfun.framework.session.Operator;
import com.myfun.framework.util.StringUtil;
import com.myfun.framework.web.json.ErpResponseJson;
import com.myfun.repository.support.cache.CacheStructure;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.mybatis.cache.CacheUtilExt;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunErpUserGuideService;
import com.myfun.service.jms.TaskQueueThread;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.service.jms.bean.TaskQueueMsg;

@Service
public class ErpCompRoleOpersServiceImpl extends AbstractService<ErpCompRoleOpers, ErpCompRoleOpers> implements ErpCompRoleOpersService{
	@Autowired
	ErpCompRoleOpersMapper erpCompRoleOpersMapper;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ErpFunDeptsgroupMapper erpFunDeptsgroupMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	AdminFunErpUserGuideService adminFunErpUserGuideService;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpCompRolesMapper erpCompRolesMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpCompRolesService erpCompRolesService;
	/** 这个service 是没得事务得 **/
	@Autowired
	ErpNoTransactionService erpNoTransactionService;
	@Autowired
	ErpUserOpersService erpUserOpersService;
	@Autowired
	ErpFunRegionMapper erpFunRegionMapper;
	@Autowired
	ErpFunOpersMapper erpFunOpersMapper;
	@Autowired
	ErpRoleOpersMapper erpRoleOpersMapper;
	@Autowired
	private CacheUtil cacheUtil;
	@Autowired
	private ErpFunCompPermissionMapper erpFunCompPermissionMapper;
	@Autowired
	private ErpFunCompPermissionTemplateMapper erpFunCompPermissionTemplateMapper;
	@Autowired
	private ErpFunCompRolesPermissionTemplateRelateMapper erpFunCompRolesPermissionTemplateRelateMapper;
	@Autowired
	private ActiveMqPublisher activeMqPublisher;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunOrganizationDefinitionService erpFunOrganizationDefinitionService;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpCompRoleOpersMapper;
	}

	@Override
	public void updateCompRoleTemplateOpers(Operator operator,String[] queryParam,Set<String> ptOperAdd,Set<String> deleteOpers,UpdatePermissionTemplateParam param) {
		Set<String> repeatUpdateOperIds = new HashSet<String>();
		
		String columnName = queryParam[0];
		String columnValue = queryParam[1];
		
		//移除权限当USER_ROLE_CHANGE != 1 时 说明是修改当前权限，等于0时说明是完全重新设置
		if(1 != param.getIsNewSetOper() && deleteOpers.size() > 0){//newSetOper !=1 这里代表不是首次设置，首次设置的时候没有数据故不需要清数据
			//这个必须在这里执行
			UserOpersUtils.addDefAreaOper(operator.getAreaFlag(), deleteOpers, deleteOpers);

			ErpFunCompPermissionExample CompPermissionExample = new ErpFunCompPermissionExample();
			CompPermissionExample.setShardCityId(operator.getCityId());
			ErpFunCompPermissionExample.Criteria criteria = CompPermissionExample.createCriteria();
			criteria.andCompIdEqualTo(operator.getCompId()).andTemplateIdEqualTo(param.getPermissionTemplateId()).andOperIdIn(new ArrayList<>(deleteOpers));
			switch (columnName) {
				case "AREA_ID" :
					criteria.andAreaIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "REG_ID" :
					criteria.andRegIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "DEPT_ID" :
					criteria.andDeptIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "GROUP_ID" :
					criteria.andGroupIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "SOURCE_COMP_ID" :
					criteria.andSourceCompIdEqualTo(Integer.valueOf(columnValue));
					break;
			}
			erpFunCompPermissionMapper.deleteByExample(CompPermissionExample); // 执行顺序不能反，必须先删除
		}
		//这个必须在这里执行
		UserOpersUtils.addDefAreaOper(operator.getAreaFlag(), ptOperAdd, ptOperAdd);
//		UserOpersUtils.addDefAreaOper(getOperator().getAreaFlag(), advanceOperAdd, advanceOperAdd);

		repeatUpdateOperIds.addAll(ptOperAdd);
//		repeatUpdateOperIds.addAll(advanceOperAdd);
		// 只要调用了这个接口就要加一个角色的权限，来表示配置过高级权限
		List<ErpFunCompPermission> CompPermissionList = erpFunCompPermissionMapper.getCheckedCommonMapOpers(operator.getCityId(),operator.getCompId(),columnName,columnValue,param.getPermissionTemplateId(), 1);

		Set<String> CompPermissionMap = CompPermissionList.stream().collect(Collectors.mapping(ErpFunCompPermission::getOperId, Collectors.toSet()));

		if(CompPermissionMap == null || !CompPermissionMap.contains("OPER_FOR_COMP_NOT_EMPTY")) {
			ptOperAdd.add("OPER_FOR_COMP_NOT_EMPTY");
		}

		//清除重复的权限和需要删除的权限
		this.deleteRepeatOperTemplate(operator.getCityId(), operator.getCompId(), columnName,columnValue,param.getPermissionTemplateId(),deleteOpers,repeatUpdateOperIds);//执行顺序不能反，必须先删除
		this.updateRangeInnerLimiteTemplate(operator.getCityId(), operator.getCompId(), columnName,columnValue,param.getPermissionTemplateId(),ptOperAdd,param.getIsNewSetOper());

		Integer allDeptFlag = null;
		if(deleteOpers.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 0 ;
		}else if(repeatUpdateOperIds.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 1;
		}

		//updateRoleCompOpers(cityId, compId, columnName,columnValue, effectRange,roleId,deleteOpers, allDeptFlag);

		ErpFunCompPermissionTemplate erpFunCompPermissionTemplate = erpFunCompPermissionTemplateMapper.getByTemplateId(operator.getCityId(),  param.getPermissionTemplateId());

	 
		String content = "修改了"+erpFunCompPermissionTemplate.getPermissionTemplateName()+"角色模板权限";
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_ROLE_OPERS, null, null , content, null, null, operator.getCityId(), operator.getCompId(),operator.getDeptId(), operator.getUserId());
		
		if(param.getIsNewSetOper() !=null && "0".equals(param.getIsNewSetOper().toString())){
			//同步角色权限
			ErpFunCompRolesPermissionTemplateRelateExample compRolesPermissionTemplateRelateExample = new ErpFunCompRolesPermissionTemplateRelateExample();
			compRolesPermissionTemplateRelateExample.setShardCityId(operator.getCityId());
			compRolesPermissionTemplateRelateExample.createCriteria().andCompIdEqualTo(operator.getCompId())
			.andTemplateIdEqualTo(param.getPermissionTemplateId());
			List<ErpFunCompRolesPermissionTemplateRelate> compRolesPermissionTemplateRelates = erpFunCompRolesPermissionTemplateRelateMapper.selectByExample(compRolesPermissionTemplateRelateExample);
			Set<String> roleIds = new HashSet<String>();
			if(compRolesPermissionTemplateRelates !=null && compRolesPermissionTemplateRelates.size() > 0){
				for (ErpFunCompRolesPermissionTemplateRelate templateRelate : compRolesPermissionTemplateRelates) {
					roleIds.add(templateRelate.getRoleId());
				}
				
				//同步删除角色权限
				if(roleIds.size() > 0){
					if(deleteOpers != null && deleteOpers.size() > 0){
						ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
						compRoleOpersExample.setShardCityId(operator.getCityId());
						compRoleOpersExample.createCriteria().andCompIdEqualTo(operator.getCompId())
						.andRoleIdIn(new ArrayList<String>(roleIds))//角色id
						.andOperIdIn(new ArrayList<String>(deleteOpers)); //权限id
						erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample);
						
					}
					if(repeatUpdateOperIds !=null && repeatUpdateOperIds.size() > 0){
						ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
						compRoleOpersExample.setShardCityId(operator.getCityId());
						compRoleOpersExample.createCriteria().andCompIdEqualTo(operator.getCompId())
						.andRoleIdIn(new ArrayList<String>(roleIds))//角色id
						.andOperIdIn(new ArrayList<String>(repeatUpdateOperIds)); //权限id
						erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample);
					}
					
					//同步增加角色权限[目前只添加公司]
					if(ptOperAdd !=null && ptOperAdd.size() > 0){
						for (String roleId : roleIds) {
							erpCompRoleOpersMapper.insertRoleOper(operator.getCityId(),operator.getCompId(),roleId,ptOperAdd,param.getPermissionTemplateId());
						}
					}
					//同步人的权限
					activeMqPublisher.sendDealUserOperMsg(operator.getCityId(), operator.getCompId(), new ArrayList<String>(roleIds), deleteOpers, repeatUpdateOperIds, ptOperAdd);
				}
			}
		}
		 
		
	}
	
	/**
	 * 鸿基定制，更新修改的权限
	 * 配置角色基本权限 应用范围 保留员工配置1否则0
	 * @param  effectRange  0:全部--清空下面的所有权限，只保留一个当前设置的范围，1:只修改当前范围，但是不清空范围下的权限，只进行差量补充和删除都有的
	 */
	@Transactional
	@Override
	public void updateCompRoleOpers(Integer cityId, Integer compId, Integer compType, Integer currentUserId,Integer currentDeptId,
									Integer effectRange, String roleId,  Set<String> ptOperAdd,
									Set<String> deleteOpers, String[] queryParam, Integer isNewSetOper, Integer isCompRole, Byte partStatistCount) {
		String columnName = queryParam[0];
		String columnValue = queryParam[1];
		
		// story#11307 先判断当前公司是否是开了加盟模式，再判断当前这个人是在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果是加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的， 3 =直营总部共用的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (getOperator().getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));// 加盟商模式下的直营和总部共用权限，例如：公告管理权，插入角色权限的时候，发现是加盟商模式，公告权限的类型就插=3或者=2，不插=0的
			}
		}

		Set<String> repeatUpdateOperIds = new HashSet<String>();
		//移除权限当USER_ROLE_CHANGE != 1 时 说明是修改当前权限，等于0时说明是完全重新设置
		if(1 != isNewSetOper && deleteOpers.size() > 0){//newSetOper !=1 这里代表不是首次设置，首次设置的时候没有数据故不需要清数据
			//这个必须在这里执行
			UserOpersUtils.addDefAreaOper(getOperator().getAreaFlag(), deleteOpers, deleteOpers);

			ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
			compRoleOpersExample.setShardCityId(cityId);
			ErpCompRoleOpersExample.Criteria criteria = compRoleOpersExample.createCriteria();
			criteria.andCompIdEqualTo(compId).andRoleIdEqualTo(roleId).andOperIdIn(new ArrayList<>(deleteOpers));
			switch (columnName) {
				case "AREA_ID" :
					criteria.andAreaIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "REG_ID" :
					criteria.andRegIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "DEPT_ID" :
					criteria.andDeptIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "GROUP_ID" :
					criteria.andGroupIdEqualTo(Integer.valueOf(columnValue));
					break;
				case "SOURCE_COMP_ID" :
					criteria.andSourceCompIdEqualTo(Integer.valueOf(columnValue));
					break;
			}
			erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample); // 执行顺序不能反，必须先删除
		}
		//这个必须在这里执行
		UserOpersUtils.addDefAreaOper(getOperator().getAreaFlag(), ptOperAdd, ptOperAdd);
//		UserOpersUtils.addDefAreaOper(getOperator().getAreaFlag(), advanceOperAdd, advanceOperAdd);

		repeatUpdateOperIds.addAll(ptOperAdd);
//		repeatUpdateOperIds.addAll(advanceOperAdd);
		
		// 只要调用了这个接口就要加一个角色的权限，来表示配置过高级权限
		List<ErpCompRoleOpers> compRoleOpersList = erpCompRoleOpersMapper.getCheckedCommonMapOpers(cityId,compId,columnName,columnValue,roleId, 1, flagList);

		Set<String> compRoleOpersPOMap = compRoleOpersList.stream().collect(Collectors.mapping(ErpCompRoleOpers::getOperId, Collectors.toSet()));

		if(compRoleOpersPOMap == null || !compRoleOpersPOMap.contains("OPER_FOR_COMP_NOT_EMPTY")) {
			ptOperAdd.add("OPER_FOR_COMP_NOT_EMPTY");
		}

		// 清除重复的权限和需要删除的权限
		this.deleteRepeatOper(cityId, compId, columnName, columnValue, roleId, effectRange, deleteOpers, repeatUpdateOperIds, flagList);//执行顺序不能反，必须先删除
		this.updateRangeInnerLimite(cityId, compId, columnName, columnValue, effectRange, roleId, ptOperAdd, isCompRole, flagList);

		Integer allDeptFlag = null;
		if(deleteOpers.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 0 ;
		}else if(repeatUpdateOperIds.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 1;
		}

		updateRoleCompOpers(cityId, compId, columnName, columnValue, effectRange, roleId, deleteOpers, ptOperAdd, allDeptFlag, flagList);

		ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);

		if(null != partStatistCount) {
			ErpCompRoles erpCompRoles = new ErpCompRoles();
			erpCompRoles.setAutoId(erpCompRoleOpers.getAutoId());
			erpCompRoles.setPartStatistCount(partStatistCount);
			erpCompRoles.setShardCityId(cityId);
			erpCompRolesMapper.updateByPrimaryKeySelective(erpCompRoles);
		}
		String content = "修改了"+erpCompRoleOpers.getRoleName()+"角色权限";
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_ROLE_OPERS, null, null , content, null, null, cityId, compId, currentDeptId, currentUserId);
	}

	/**
	 * 鸿基定制，更新修改的权限
	 * 配置角色基本权限
	 * @param  effectRange  0:全部--清空下面的所有权限，只保留一个当前设置的范围，1:只修改当前范围，但是不清空范围下的权限，只进行差量补充和删除都有的
	 */
	@Override
	public void updateCompRoleOpersNewOrg(Integer cityId, Integer compId, Integer currentUserId, Integer currentDeptId,
										  Integer effectRange, String roleId, List<FunOpersVO> updateOpers, Integer isNewSetOper,
										  Integer isCompRole, Integer organizationId, Set<String> deleteOpers,String userName) {

		// story#11307 先判断当前公司是否是开了加盟模式，再判断当前这个人说在哪个组织，总部的就 要总部特殊的权限比如说加盟商管理权， 直营不管，如果是加盟商的人，那么要把特殊的加盟商公告管理权查出来
		List<Byte> flagList =  new ArrayList<Byte>();// 查询通用的权限，1=总部的，2=加盟商的， 3 =直营总部共用的
		flagList.add(Byte.valueOf("0"));
		if (Integer.valueOf(1).equals(getOperator().openPartner())) {
			if (Integer.valueOf(0).equals(getOperator().getPartnerId())) {// 总部
				flagList.add(Byte.valueOf("1"));
				flagList.add(Byte.valueOf("3"));
			} else if (getOperator().getPartnerId() > 0) {// 加盟商
				flagList.add(Byte.valueOf("2"));
			} else {
				flagList.add(Byte.valueOf("3"));// 加盟商模式下的直营和总部共用权限，例如：公告管理权，插入角色权限的时候，发现是加盟商模式，公告权限的类型就插=3或者=2，不插=0的
			}
		}

		// 移除权限当USER_ROLE_CHANGE != 1 时 说明是修改当前权限，等于0时说明是完全重新设置
		// newSetOper !=1 这里代表不是首次设置，首次设置的时候没有数据故不需要清数据
		if(1 != isNewSetOper && deleteOpers.size() > 0){
			// 这里不管是新增的还是删除的都先删除
			ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
			compRoleOpersExample.setShardCityId(cityId);
			ErpCompRoleOpersExample.Criteria criteria = compRoleOpersExample.createCriteria();
			criteria.andCompIdEqualTo(compId).andRoleIdEqualTo(roleId).andOperIdIn(new ArrayList<>(deleteOpers)).andOrganizationIdEqualTo(organizationId);
			erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample);
		}

		// 只要调用了这个接口就要加一个角色的权限，来表示配置过高级权限
		ErpCompRoleOpersExample erpCompRoleOpersExample = new ErpCompRoleOpersExample();
		erpCompRoleOpersExample.setShardCityId(cityId);
		erpCompRoleOpersExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdEqualTo(organizationId).andRoleIdEqualTo(roleId).andOperTypeEqualTo(1);

		List<ErpCompRoleOpers> compRoleOpersList = erpCompRoleOpersMapper.selectByExample(erpCompRoleOpersExample);

		Set<String> compRoleOpersPOMap = compRoleOpersList.stream().collect(Collectors.mapping(ErpCompRoleOpers::getOperId, Collectors.toSet()));

		if(compRoleOpersPOMap == null || !compRoleOpersPOMap.contains("OPER_FOR_COMP_NOT_EMPTY")) {
			FunOpersVO funOpersVO = new FunOpersVO();
			funOpersVO.setOperId("OPER_FOR_COMP_NOT_EMPTY");
			updateOpers.add(funOpersVO);
		}

		//执行顺序不能反，必须先删除
		this.deleteRepeatOperNewOrg(cityId, compId, organizationId, roleId, effectRange, updateOpers, deleteOpers, flagList);
		this.updateRangeInnerLimiteNewOrg(cityId, compId, organizationId, effectRange, roleId, updateOpers, isCompRole, flagList);

		List<String> updateOperIdList = updateOpers.stream().collect(Collectors.mapping(val -> val.getOperId(), Collectors.toList()));
		
		// 加盟商的公告管理权判断
		List<FunOpersVO> partnerBulletOperList = updateOpers.stream().filter(oper -> "MANAGE_ORGANIZATION_BULLET".equals(oper.getOperId()) && Integer.valueOf(-1).equals(oper.getOrganizationDefinitionId())).collect(Collectors.toList());
		boolean haspartnerBulletOper = null != partnerBulletOperList && partnerBulletOperList.size() > 0 ? true : false;// 加盟商模式下的选择了加盟商公告管理权后需要处理其他非加盟商的defeeId=0
		Integer allDeptFlag = null;
		if(deleteOpers.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 0 ;
		}else if(updateOperIdList.contains("LOGIN_OTHER_DEPTS")){
			allDeptFlag = 1;

		}

		updateRoleCompOpersNewOrg(cityId, compId, organizationId, effectRange,roleId,deleteOpers, updateOperIdList, allDeptFlag, flagList, haspartnerBulletOper);

		ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);

		String content = "修改了"+ erpCompRoleOpers.getRoleName()+"角色权限";
		//erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_ROLE_OPERS, null, null , content, null, null, cityId, compId, currentDeptId, currentUserId);
		erpSystemSettingLogsService.insertSysLogNew(SystemOperateUtil.SSL_TYPE.UPDATE_ROLE_OPERS, null, null , content, null, null, cityId, compId, currentDeptId, currentUserId,userName);
	}

	
	public void updateRangeInnerLimiteTemplate(Integer cityId, Integer compId, String columnName, String columnValue ,
			   Integer templateId,Set<String> updatePtOpers,Integer  isNewSetOper) {
		if(CommonUtil.isnull(updatePtOpers)){
			return;
		}
		//大区范围内的片区ID集合
		Set<Integer> regionIds = new HashSet<Integer>();
		//片区范围内的门店ID集合
		Set<Integer> deptIds = new HashSet<Integer>();
		//门店范围内的分组ID集合
		Set<Integer> groupIds = new HashSet<Integer>();
		//要查询出该大区下面的门店和片区
		if(UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDepts tmp : erpFunDeptsList){
				deptIds.add(tmp.getDeptId());
			}
			List<ErpFunRegion> regionSet = erpFunRegionMapper.getRegionListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunRegion tmp : regionSet){
				regionIds.add(tmp.getRegId());
			}
			//要查询出该片区下面的门店
		}else if(UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDepts tmp : erpFunDeptsList){
				deptIds.add(tmp.getDeptId());
			}
		}else if(UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
		List<ErpFunDeptsgroup> groupsSet = erpFunDeptsgroupMapper.getGroupListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDeptsgroup tmp : groupsSet){
				groupIds.add(tmp.getGrId());
			}
		}

		// 判断是是否是自定义角色
		String queryRole = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		//if(null != isCompRole && 1 == isCompRole) {
			//queryRole = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		//}

		// 查询全部权限，归类基础权限还是高级权限
		ErpRoleOpersExample example = new ErpRoleOpersExample();
		example.setShardCityId(cityId);
		example.createCriteria().andRoleIdEqualTo(queryRole);
		List<ErpRoleOpers> erpFunOpers = erpRoleOpersMapper.selectByExample(example);
		Map<String, Integer> operTypeMap = erpFunOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val->val.getOperType() ? 1: 0));


		if(!CommonUtil.isnull(updatePtOpers)){
			for(String operId : updatePtOpers){
			Integer aByte = operTypeMap.get(operId);
			if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
				aByte = 1;
			}
			try{
				erpFunCompPermissionMapper.insertByDynamicId(cityId, compId, columnName, columnValue, templateId, operId, aByte);
			}catch (Exception e){}
			}
		}
 

		//需要对下级的范围进行更新
		if(null != isNewSetOper && 1 == isNewSetOper){ //非首次添加权限才需要更新下一级
			Map<String ,Set<Integer>> tmpSetMap = this.getCurrRoleCompOpersByRangIdTemplate(cityId, compId, templateId);
			Set<Integer> containAreaIds = tmpSetMap.get("area");
			Set<Integer> containRegionIds = tmpSetMap.get("region");
			Set<Integer> containDeptIds = tmpSetMap.get("dept");
			Set<Integer> containGroupIds = tmpSetMap.get("group");
			//说明是公司底下的全部覆盖
			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)){
				for(Integer areaIdTmp : containAreaIds){
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							try{
								erpFunCompPermissionMapper.insertByDynamicId(cityId, compId, "AREA_ID", areaIdTmp+"", templateId, operId,aByte);
							}catch (Exception e){}

						}
					}
				}
			}

			//大区和公司级别的更新
			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
				for(Integer regIdTmp : containRegionIds){
					//集合不为空说明才需要判断 应用范围
					if(!CommonUtil.isnull(regionIds) && !regionIds.contains(regIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							try{
								erpFunCompPermissionMapper.insertByDynamicId(cityId, compId, "REG_ID", regIdTmp+"", templateId, operId,aByte);
							}catch (Exception e){}

						}
					}
				}
			}

			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
				for(Integer deptIdTmp : containDeptIds){
					//集合不为空说明才需要判断 应用范围 包含这个门店才写入数据
					if(!CommonUtil.isnull(deptIds) && !deptIds.contains(deptIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}

							try{
								erpFunCompPermissionMapper.insertByDynamicId(cityId, compId, "DEPT_ID", deptIdTmp+"", templateId, operId,aByte);
							}catch (Exception e){}
						}
					}
				}
			}

			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
				for(Integer groupIdTmp : containGroupIds){
					//集合不为空说明才需要判断 应用范围 包含这个门店才写入数据
					if(!CommonUtil.isnull(groupIds) && !groupIds.contains(groupIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							try{
								erpFunCompPermissionMapper.insertByDynamicId(cityId, compId, "GROUP_ID", groupIdTmp+"", templateId, operId,aByte);
							}catch (Exception e){}

						}
					}
				}
			}
		}
	}
	
	public void updateRangeInnerLimite(Integer cityId, Integer compId, String columnName, String columnValue ,
									   Integer useRange,String roleId,Set<String> updatePtOpers, Integer isCompRole, List<Byte> flagList) {
		if(CommonUtil.isnull(updatePtOpers)){
			return;
		}
		//大区范围内的片区ID集合
		Set<Integer> regionIds = new HashSet<Integer>();
		//片区范围内的门店ID集合
		Set<Integer> deptIds = new HashSet<Integer>();
		//门店范围内的分组ID集合
		Set<Integer> groupIds = new HashSet<Integer>();
		//要查询出该大区下面的门店和片区
		if(UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDepts tmp : erpFunDeptsList){
				deptIds.add(tmp.getDeptId());
			}
			List<ErpFunRegion> regionSet = erpFunRegionMapper.getRegionListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunRegion tmp : regionSet){
				regionIds.add(tmp.getRegId());
			}
			//要查询出该片区下面的门店
		}else if(UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getDeptListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDepts tmp : erpFunDeptsList){
				deptIds.add(tmp.getDeptId());
			}
		}else if(UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
			List<ErpFunDeptsgroup> groupsSet = erpFunDeptsgroupMapper.getGroupListBynamicId(cityId, compId, columnName, columnValue);
			for(ErpFunDeptsgroup tmp : groupsSet){
				groupIds.add(tmp.getGrId());
			}
		}

		// 判断是是否是自定义角色
		String queryRole = roleId;
		if(null != isCompRole && 1 == isCompRole) {
			queryRole = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		}
		
		/**0=通用、1=加盟商的总部、2=加盟商的加盟商、3=加盟商的直营与加盟商
		 * flagList中的有：0、1、3 = 总部	（通用权限与加盟商管理权与公告管理权）
		 * 				 0、2	= 加盟商	（通用权限与加盟商公告管理权）
		 * 				 0、3	= 直营	（通用权限与公告管理权）
		 * 
		 *  MANAGE_COMP_BULLET		公司公告信息管理权		2	3
		 *	MANAGE_DEPT_BULLET		门店公告信息管理权		2	3
		 *	MANAGE_PARTNER_BULLET	加盟商公告信息管理权		2
		 *	PARTNER_MANAGE_OPER		加盟商管理权			1
		 */

		// 查询全部权限，归类基础权限还是高级权限
		ErpRoleOpersExample example = new ErpRoleOpersExample();
		example.setShardCityId(cityId);
		example.createCriteria().andRoleIdEqualTo(queryRole);
		List<ErpRoleOpers> erpFunOpers = erpRoleOpersMapper.selectByExample(example);
		Map<String, Integer> operTypeMap = erpFunOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val->val.getOperType() ? 1: 0));


		if(!CommonUtil.isnull(updatePtOpers)){
			for(String operId : updatePtOpers){
				Integer aByte = operTypeMap.get(operId);
				if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
					aByte = 1;
				}
				// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
				Byte partnerOper = 0;
				/*if (flagList.contains(Byte.valueOf("1")) && "PARTNER_MANAGE_OPER".equals(operId)) {// 单独处理加盟商管理权，给加盟商模式下总部的人配的
					partnerOper = 1;
				} else if (flagList.contains(Byte.valueOf("2")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId) || "MANAGE_PARTNER_BULLET".equals(operId))) {
					partnerOper = 2;
				} else if (flagList.contains(Byte.valueOf("3")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId))) {
					partnerOper = 3;
				}*/
				
				try{
					erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, columnName, columnValue, roleId, operId, aByte, partnerOper);
				}catch (Exception e){}
			}
		}
//		if(!CommonUtil.isnull(updateAdvOpers)){
//			for(String operId : updateAdvOpers){
//				Byte aByte = operTypeMap.get(operId);
//				erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, columnName, columnValue, roleId, operId, aByte);
//			}
//		}

		//需要对下级的范围进行更新
		if (null != useRange && 1 == useRange) { //非首次添加权限才需要更新下一级
			Map<String ,Set<Integer>> tmpSetMap = this.getCurrRoleCompOpersByRangId(cityId, compId, roleId);
			Set<Integer> containAreaIds = tmpSetMap.get("area");
			Set<Integer> containRegionIds = tmpSetMap.get("region");
			Set<Integer> containDeptIds = tmpSetMap.get("dept");
			Set<Integer> containGroupIds = tmpSetMap.get("group");
			//说明是公司底下的全部覆盖
			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)){
				for(Integer areaIdTmp : containAreaIds){
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
							Byte partnerOper = 0;
							/*if (flagList.contains(Byte.valueOf("1")) && "PARTNER_MANAGE_OPER".equals(operId)) {// 单独处理加盟商管理权，给加盟商模式下总部的人配的
								partnerOper = 1;
							} else if (flagList.contains(Byte.valueOf("2")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId) || "MANAGE_PARTNER_BULLET".equals(operId))) {
								partnerOper = 2;
							} else if (flagList.contains(Byte.valueOf("3")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId))) {
								partnerOper = 3;
							}*/
							try{
								erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "AREA_ID", areaIdTmp+"", roleId, operId, aByte, partnerOper);
							}catch (Exception e){}

						}
					}
//					if(!CommonUtil.isnull(updateAdvOpers)){
//						for(String operId : updateAdvOpers){
//							Byte aByte = operTypeMap.get(operId);
//							erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "AREA_ID", areaIdTmp+"", roleId, operId,aByte);
//						}
//					}
				}
			}

			//大区和公司级别的更新
			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
				for(Integer regIdTmp : containRegionIds){
					//集合不为空说明才需要判断 应用范围
					if(!CommonUtil.isnull(regionIds) && !regionIds.contains(regIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
							Byte partnerOper = 0;
							/*if (flagList.contains(Byte.valueOf("1")) && "PARTNER_MANAGE_OPER".equals(operId)) {// 单独处理加盟商管理权，给加盟商模式下总部的人配的
								partnerOper = 1;
							} else if (flagList.contains(Byte.valueOf("2")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId) || "MANAGE_PARTNER_BULLET".equals(operId))) {
								partnerOper = 2;
							} else if (flagList.contains(Byte.valueOf("3")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId))) {
								partnerOper = 3;
							}*/
							try{
								erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "REG_ID", regIdTmp+"", roleId, operId, aByte, partnerOper);
							}catch (Exception e){}

						}
					}
//					if(!CommonUtil.isnull(updateAdvOpers)){
//						for(String operId : updateAdvOpers){
//							Byte aByte = operTypeMap.get(operId);
//							erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "REG_ID", regIdTmp+"", roleId, operId,aByte);
//						}
//					}
				}
			}

			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
				for(Integer deptIdTmp : containDeptIds){
					//集合不为空说明才需要判断 应用范围 包含这个门店才写入数据
					if(!CommonUtil.isnull(deptIds) && !deptIds.contains(deptIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
							Byte partnerOper = 0;
							/*if (flagList.contains(Byte.valueOf("1")) && "PARTNER_MANAGE_OPER".equals(operId)) {// 单独处理加盟商管理权，给加盟商模式下总部的人配的
								partnerOper = 1;
							} else if (flagList.contains(Byte.valueOf("2")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId) || "MANAGE_PARTNER_BULLET".equals(operId))) {
								partnerOper = 2;
							} else if (flagList.contains(Byte.valueOf("3")) && ("MANAGE_COMP_BULLET".equals(operId) || "MANAGE_DEPT_BULLET".equals(operId))) {
								partnerOper = 3;
							}*/
							try{
								erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "DEPT_ID", deptIdTmp+"", roleId, operId, aByte, partnerOper);
							}catch (Exception e){}
						}
					}
//					if(!CommonUtil.isnull(updateAdvOpers)){
//						for(String operId : updateAdvOpers){
//							Byte aByte = operTypeMap.get(operId);
//							erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "DEPT_ID", deptIdTmp+"", roleId, operId,aByte);
//						}
//					}
				}
			}

			if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)
					|| UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
				for(Integer groupIdTmp : containGroupIds){
					//集合不为空说明才需要判断 应用范围 包含这个门店才写入数据
					if(!CommonUtil.isnull(groupIds) && !groupIds.contains(groupIdTmp)){
						continue;
					}
					if(!CommonUtil.isnull(updatePtOpers)){
						for(String operId : updatePtOpers){
							Integer aByte = operTypeMap.get(operId);
							if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
								aByte = 1;
							}
							// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
							Byte partnerOper = 0;
							/*+*/
							try{
								erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "GROUP_ID", groupIdTmp+"", roleId, operId, aByte, partnerOper);
							}catch (Exception e){}
						}
					}
//					if(!CommonUtil.isnull(updateAdvOpers)){
//						for(String operId : updateAdvOpers){
//							Byte aByte = operTypeMap.get(operId);
//							erpCompRoleOpersMapper.insertByDynamicId(cityId, compId, "GROUP_ID", groupIdTmp+"", roleId, operId,aByte);
//						}
//					}
				}
			}
		}
		this.evictCompRoleOpers(cityId,compId);
	}

	public void updateRangeInnerLimiteNewOrg(Integer cityId, Integer compId, Integer organizationId ,
									   Integer useRange,String roleId,List<FunOpersVO> updateOpers, Integer isCompRole, List<Byte> flagList) {

		if(updateOpers.size() == 0){
			return;
		}

		// 判断是是否是自定义角色
		String queryRole = roleId;
		if(null != isCompRole && 1 == isCompRole) {
			queryRole = Const.DIC_ROLE_NAME_DEPUTY_MANAGER;
		}

		/**0=通用、1=加盟商的总部、2=加盟商的加盟商、3=加盟商的直营与加盟商
		 * flagList中的有：0、1、3 = 总部	（通用权限与加盟商管理权与公告管理权）
		 * 				 0、2	= 加盟商	（通用权限与加盟商公告管理权）
		 * 				 0、3	= 直营	（通用权限与公告管理权）
		 *
		 *  MANAGE_COMP_BULLET		公司公告信息管理权		2	3
		 *	MANAGE_DEPT_BULLET		门店公告信息管理权		2	3
		 *	MANAGE_PARTNER_BULLET	加盟商公告信息管理权		2
		 *	PARTNER_MANAGE_OPER		加盟商管理权			1
		 */

		// 查询全部权限，归类基础权限还是高级权限
		ErpRoleOpersExample example = new ErpRoleOpersExample();
		example.setShardCityId(cityId);
		example.createCriteria().andRoleIdEqualTo(queryRole);
		List<ErpRoleOpers> erpFunOpers = erpRoleOpersMapper.selectByExample(example);

		Map<String, Integer> operTypeMap = erpFunOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val->val.getOperType() ? 1: 0));

		ErpCompRoleOpersExample erpCompRoleOpersExample = new ErpCompRoleOpersExample();
		erpCompRoleOpersExample.setShardCityId(cityId);
		erpCompRoleOpersExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId).andOrganizationIdEqualTo(organizationId);
		List<ErpCompRoleOpers> erpCompRoleOpers = erpCompRoleOpersMapper.selectByExample(erpCompRoleOpersExample);
		Map<String, ErpCompRoleOpers> roleAllOpersMap = erpCompRoleOpers.stream().collect(Collectors.toMap(val -> val.getOperId(), val -> val));

		for(FunOpersVO operId : updateOpers){
			Integer aByte = operTypeMap.get(operId.getOperId());
			if("OPER_FOR_COMP_NOT_EMPTY".equals(operId)) {
				aByte = 1;
			}
			// 公司角色权限中的权限的类型PARTNER_OPER	0=通用，1=加盟商模式下的总部使用，2=加盟商模式下加盟商使用,3=加盟商模式下总部和直营使用
			Byte partnerOper = 0;//CompRoleOpers的partnerOper字段已经废弃，所以默认0

			try{
				if(null == roleAllOpersMap.get(operId.getOperId())) {
					// 这里用merge , 因为如果 useRange=1 保存原有权限的话是没有全部删除模板权限的
					erpCompRoleOpersMapper.insertByDynamicIdNewOrg(cityId, compId, organizationId, operId.getOrganizationDefinitionId(), roleId, operId.getOperId(), aByte, partnerOper);
				}
			}catch (Exception e){}
		}

		this.evictCompRoleOpers(cityId,compId);
	}

	public void  evictCompRoleOpers(Integer cityId,Integer compId){
	    cacheUtil.del(CacheStructure.hfterpdb_compRoleOpersCacheByCompId + compId + "_CITY_ID_" + cityId);
	}

	
	private Map<String, Set<Integer>> getCurrRoleCompOpersByRangIdTemplate(Integer cityId, Integer compId, Integer templateId) {
		List<ErpFunCompPermission> tmps = erpFunCompPermissionMapper.parseQueryColumnForUserOpers(cityId, compId, templateId);
		Set<Integer> grIds = new HashSet<>();
		Set<Integer> deptIds = new HashSet<>();
		Set<Integer> regionIds = new HashSet<>();
		Set<Integer> areaIds = new HashSet<>();
		Set<Integer> compIds = new HashSet<>();
		Map<String, Set<Integer>> tmpIds = new HashMap<>();
		for (ErpFunCompPermission tmpOpers : tmps) {
			Integer tmpAreaId = tmpOpers.getAreaId();
			Integer tmpRegionId = tmpOpers.getRegId();
			Integer tmpDeptId = tmpOpers.getDeptId();
			Integer tmpgrId = tmpOpers.getGroupId();
			Integer tmpComptId = tmpOpers.getSourceCompId();
			if (null != tmpAreaId) {
				areaIds.add(tmpAreaId);
			}
			if (null != tmpRegionId) {
				regionIds.add(tmpRegionId);
			}
			if (null != tmpDeptId) {
				deptIds.add(tmpDeptId);
			}
			if (null != tmpgrId) {
				grIds.add(tmpgrId);
			}
			if (null != tmpComptId) {
				compIds.add(tmpComptId);
			}
		}
		tmpIds.put("area", areaIds);
		tmpIds.put("region", regionIds);
		tmpIds.put("dept", deptIds);
		tmpIds.put("group", grIds);
		tmpIds.put("comp", compIds);
		return tmpIds;
	}
	
	/**
	 *
	 * @param
	 * @return
	 * @auther 胡坤
	 * @since 2018/6/20
	 */
	private Map<String, Set<Integer>> getCurrRoleCompOpersByRangId(Integer cityId, Integer compId, String roleId) {
		List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.parseQueryColumnForUserOpers(cityId, compId, roleId);
		Set<Integer> grIds = new HashSet<>();
		Set<Integer> deptIds = new HashSet<>();
		Set<Integer> regionIds = new HashSet<>();
		Set<Integer> areaIds = new HashSet<>();
		Set<Integer> compIds = new HashSet<>();
		Map<String, Set<Integer>> tmpIds = new HashMap<>();
		for (ErpCompRoleOpers tmpOpers : tmps) {
			Integer tmpAreaId = tmpOpers.getAreaId();
			Integer tmpRegionId = tmpOpers.getRegId();
			Integer tmpDeptId = tmpOpers.getDeptId();
			Integer tmpgrId = tmpOpers.getGroupId();
			Integer tmpComptId = tmpOpers.getSourceCompId();
			if (null != tmpAreaId) {
				areaIds.add(tmpAreaId);
			}
			if (null != tmpRegionId) {
				regionIds.add(tmpRegionId);
			}
			if (null != tmpDeptId) {
				deptIds.add(tmpDeptId);
			}
			if (null != tmpgrId) {
				grIds.add(tmpgrId);
			}
			if (null != tmpComptId) {
				compIds.add(tmpComptId);
			}
		}
		tmpIds.put("area", areaIds);
		tmpIds.put("region", regionIds);
		tmpIds.put("dept", deptIds);
		tmpIds.put("group", grIds);
		tmpIds.put("comp", compIds);
		return tmpIds;
	}

	private void deleteRepeatOperTemplate(Integer cityId, Integer compId, String columnName, String columnValue ,Integer templateId,
			 Set<String> deleteOpers, Set<String> repeatUpdateOperIds) {
		 
		//只要不是分组范围则都要清空小于该范围下的所有权限，因为分组范围已经是最小，下面已经没有更小的范围了，如果后期增加这里需要修改
		if(!UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
			//直接清空该范围下的所有权限，只保留当前范围(在后面的updateRangeInnerLimite方法中添加)
			erpFunCompPermissionMapper.deleteByDynamincId2(cityId, compId, templateId, columnName, columnValue, null);
		}
		 
		//该范围下的权限配置--无论如何都会修改当前范围所有先清空在修改
		if(repeatUpdateOperIds.size() > 0){
			erpFunCompPermissionMapper.deleteByDynamincId(cityId, compId, templateId, columnName, columnValue, repeatUpdateOperIds);
		}
	}

	/**
	 * @Desc 应用范围 保留员工配置1否则0
	 * @Time 2019/11/27
	 * @Author lcb
	 **/
	private void deleteRepeatOper(Integer cityId, Integer compId, String columnName, String columnValue ,String roleId,
								 Integer useRange,Set<String> deleteOpers, Set<String> repeatUpdateOperIds, List<Byte> flagList) {
		if(null != useRange && 1 == useRange){//代表权限范围内
			if(!CommonUtil.isnull(deleteOpers)){
				erpCompRoleOpersMapper.deleteByDynamincId2(cityId, compId, roleId, columnName, columnValue, deleteOpers, flagList);
			}
			if(!CommonUtil.isnull(repeatUpdateOperIds)){
				erpCompRoleOpersMapper.deleteByDynamincId2(cityId, compId, roleId, columnName, columnValue, repeatUpdateOperIds, flagList);
			}
		}else{
			//只要不是分组范围则都要清空小于该范围下的所有权限，因为分组范围已经是最小，下面已经没有更小的范围了，如果后期增加这里需要修改
			if(!UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
				//直接清空该范围下的所有权限，只保留当前范围(在后面的updateRangeInnerLimite方法中添加)
				erpCompRoleOpersMapper.deleteByDynamincId2(cityId, compId, roleId, columnName, columnValue, null, flagList);
			}
		}
		//该范围下的权限配置--无论如何都会修改当前范围所有先清空在修改
		if(repeatUpdateOperIds.size() > 0){
			erpCompRoleOpersMapper.deleteByDynamincId(cityId, compId, roleId, columnName, columnValue, repeatUpdateOperIds, flagList);
		}
	}

	/**
	 * @Desc 新组织机构的权限
	 * @Time 2019/11/27
	 * @Author lcb
	 **/
	private void deleteRepeatOperNewOrg(Integer cityId, Integer compId, Integer organizationId ,String roleId,
								  Integer useRange, List<FunOpersVO> updateOpers, Set<String> deleteOpers, List<Byte> flagList) {

		// effectRange 保留员工配置1否则0
		List<String> updateOperIdList = updateOpers.stream().collect(Collectors.mapping(val->val.getOperId(), Collectors.toList()));

		//代表权限范围内
		if(null != useRange && 1 == useRange){
			// 只处理选中的部分权限做处理
			if(deleteOpers.size() > 0){
				erpCompRoleOpersMapper.deleteByDynaminc2NewOrg(cityId, compId, roleId, organizationId, new ArrayList<>(deleteOpers), flagList);
			}
		}else{
			//只要不是分组范围则都要清空小于该范围下的所有权限，因为分组范围已经是最小，下面已经没有更小的范围了，如果后期增加这里需要修改
			//直接清空该范围下的所有权限，只保留当前范围(在后面的updateRangeInnerLimite方法中添加)
//			erpCompRoleOpersMapper.deleteByDynaminc2NewOrg(cityId, compId, roleId, organizationId, null, flagList);
		}

		//该范围下的权限配置--无论如何都会修改当前范围所有先清空在修改
		if(updateOperIdList.size() > 0){
			erpCompRoleOpersMapper.deleteByDynamincNewOrg(cityId, compId, roleId, organizationId, updateOperIdList, flagList);
		}
	}

	private void updateRoleCompOpers(Integer cityId,Integer compId, String columnName, String columnValue ,Integer effectRange ,String roleId,Set<String> deleteOpers, Set<String> ptOperAdd, Integer allDeptFlag, List<Byte> flagList) {
		//本次需要更新的门店
		Set<Integer> avaDeptIds = new HashSet<Integer>();
		List<ErpFunDepts> queryRangIdDeptInfos = null;
		//COMP_ROLE_OPERS 公司角色权限表

		ErpFunDeptsExample erpFunDeptsExample = new ErpFunDeptsExample();
		erpFunDeptsExample.setShardCityId(cityId);
		ErpFunDeptsExample.Criteria criteria = erpFunDeptsExample.createCriteria();
		criteria.andCompIdEqualTo(compId);
		if(UserOpersUtils.COMP_ROLE_OPERS_AREA_ID.equals(columnName)){
			criteria.andAreaIdEqualTo(Integer.valueOf(columnValue));
		}else if(UserOpersUtils.COMP_ROLE_OPERS_REG_ID.equals(columnName)){
			criteria.andRegIdEqualTo(Integer.valueOf(columnValue));
		}else if(UserOpersUtils.COMP_ROLE_OPERS_DEPT_ID.equals(columnName)){
			avaDeptIds.add(Integer.valueOf(columnValue));
		}else if(UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
			ErpFunDeptsgroup dataByGrId = erpFunDeptsgroupMapper.getDataByGrId(cityId, Integer.valueOf(columnValue));
			avaDeptIds.add(dataByGrId.getDeptId());
		}

		queryRangIdDeptInfos = erpFunDeptsMapper.selectByExample(erpFunDeptsExample);

		for(ErpFunDepts deptPo : queryRangIdDeptInfos){
			avaDeptIds.add(deptPo.getDeptId());
		}

		String tmpField = "";
		if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)){
			tmpField = "COMP_ID";
		}else{
			tmpField = columnName;
		}

		//执行的顺序不能反 -- 先删除再添加处理user_opers表 步骤一
		if(null == effectRange || 1 != effectRange){
			StringBuilder sbs= new StringBuilder();
			if(avaDeptIds.size() == 0){
				erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, null, null, null);
			}else{
				//分组需要做一个特殊处理，不能更新该门店所有用户的权限，只能更新分组内的用户。
				if(UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
					erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, avaDeptIds, Integer.valueOf(columnValue), null);
				}else{
					sbs.append("delete from USER_OPERS where USER_ID in (select USER_ID from FUN_USERS where COMP_ID = ? and DEPT_ID in ("+avaDeptIds.toString().replaceAll("\\]|\\[", "")+") and USER_WRITEOFF = 0 and USER_POSITION = ?)");
					erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, avaDeptIds, null, null);
				}
			}
		}

		// 更新权限
		erpCompRolesService.updateUserOpers(cityId,compId, tmpField, columnName, columnValue, roleId, deleteOpers, ptOperAdd, flagList);
		// 增加引导
		adminFunErpUserGuideService.insertUserSeniorGuideByRole(cityId, compId, roleId);
		if(UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
			//一个分组肯定只能对应一个DEPT_ID
			updateUserInfoAndCacheByGrId(cityId, compId, roleId, allDeptFlag, avaDeptIds.toArray(new Integer[]{})[0], columnValue);
		}else{
			updateUserInfoAndCache(cityId, compId, roleId,allDeptFlag, avaDeptIds);
		}
	}

	private void updateRoleCompOpersNewOrg(Integer cityId,Integer compId, Integer organizationId, Integer effectRange ,String roleId, 
			Set<String> deleteOpers, List<String> updateOperIdList, Integer allDeptFlag, List<Byte> flagList, boolean haspartnerBulletOper) {
		//本次需要更新的门店

		//执行的顺序不能反 -- 先删除再添加处理user_opers表 步骤一
		if(null == effectRange || 1 != effectRange){
			erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, null, null, organizationId);
//			StringBuilder sbs= new StringBuilder();
//			if(avaDeptIds.size() == 0){
//
//			}else{
//				//分组需要做一个特殊处理，不能更新该门店所有用户的权限，只能更新分组内的用户。
//				if(UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
//					erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, avaDeptIds, Integer.valueOf(columnValue));
//				}else{
//					sbs.append("delete from USER_OPERS where USER_ID in (select USER_ID from FUN_USERS where COMP_ID = ? and DEPT_ID in ("+avaDeptIds.toString().replaceAll("\\]|\\[", "")+") and USER_WRITEOFF = 0 and USER_POSITION = ?)");
//					erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, avaDeptIds, null);
//				}
//			}
		}

		// 更新权限
//		erpCompRolesService.updateUserOpers(cityId,compId, tmpField, columnName, columnValue, roleId, deleteOpers, flagList);

		erpUserOpersMapper.mergeUserOpersNewOrg(cityId, compId, organizationId, roleId, flagList);
		
		// 处理加盟商模式的部分权限问题,删除
		if (flagList.size() > 1) {// 加盟商模式下，size才会大于1
			// 特殊处理加盟商需求里面，加盟商特有的两个权限的应用到人的范围，上面写，这里删除不在这个范围内的人的这两个权限
			if (updateOperIdList.contains("PARTNER_MANAGE_OPER")) {// 加盟商管理权，只能应用到总部人，删除非总部人身上的权限
				erpUserOpersMapper.deletePartnerOperByNoPartnerNewOrg(cityId, compId, "PARTNER_MANAGE_OPER", "TISSUE_LINE", organizationId == 0 ? null : organizationId.toString(), 0);// 0表示删除非总部,1表示删除非加盟商
			}
			if (haspartnerBulletOper) {// 加盟商公告管理权，只能应用到加盟商人，删除非加盟商人身上的权限
				erpUserOpersMapper.updatePartnerOperByNoPartnerNewOrg(cityId, compId, "MANAGE_ORGANIZATION_BULLET", "TISSUE_LINE", organizationId == 0 ? null : organizationId.toString(), 1);// 0表示删除非总部,1表示删除非加盟商
			}
			
		} else {
			erpUserOpersMapper.deletePartnerOperByNoPartnerNewOrg(cityId, compId, "PARTNER_MANAGE_OPER", "TISSUE_LINE", organizationId == 0 ? null : organizationId.toString(), 1);// 0表示删除非总部,1表示删除非加盟商
//			erpUserOpersMapper.updatePartnerOperByNoPartnerNewOrg(cityId, compId, "MANAGE_ORGANIZATION_BULLET", "TISSUE_LINE", compId.toString(), 1);// 0表示删除非总部,1表示删除非加盟商
		}
		// 增加引导
		adminFunErpUserGuideService.insertUserSeniorGuideByRole(cityId, compId, roleId);

		updateUserInfoAndCacheNewOrg(cityId, compId, roleId, allDeptFlag, organizationId);
	}

	private void updateUserInfoAndCacheByGrId(Integer cityId, Integer compId, String roleId, Integer allDeptFlag ,Integer deptId, String groupId) {
		//更新用户的较色信息并更新缓存 --陈文超
		if(null != allDeptFlag){
			ErpFunUsers updateFunUSers = new ErpFunUsers();
			updateFunUSers.setAlldeptFlag(allDeptFlag > 0);
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			usersExample.createCriteria().andUserWriteoffEqualTo(false).andUserPositionEqualTo(roleId).andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andGrIdEqualTo(Integer.valueOf(groupId));
			erpFunUsersMapper.updateByExampleSelective(updateFunUSers, usersExample);
		}
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(cityId);
		usersExample.createCriteria().andCompIdEqualTo(compId).andGrIdEqualTo(Integer.valueOf(groupId));
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(usersExample);

		Set<Integer> userIds = new HashSet<Integer>(userList.size());
		for(ErpFunUsers funUsersPO : userList){
			//包含在该门店范围内才更新缓存
			if(funUsersPO.getUserPosition().equals(roleId)){
				try {
					//更新人员权限，给被更改的人员一个提示,2代表修改权限
					Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
					if (loginKey != null) {
					    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
					}
					loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
					if (loginKey != null) {
					    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
					}
				} catch (Exception e) {
					//这里不需要报出异常信息}
				}
				userIds.add(funUsersPO.getArchiveId());
				erpNoTransactionService.evictCacheableModelData(cityId, funUsersPO.getUserId());
			}
		}

		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[]{}));
		TaskQueueThread.sendMessage(taskQueueMsg);

		//批量清空缓存中的用户较色信息根据指定的DEPT_ID 陈文超
		erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);
	}

	/**
	 * 批量修改权限后更新用户信息
	 * @author 陈文超
	 * @date Nov 12, 2015 4:02:05 PM
	 */
	private void updateUserInfoAndCache(Integer cityId, Integer compId, String roleId, Integer allDeptFlag ,Set<Integer> avaDeptIds) {
		//更新用户的较色信息并更新缓存 --陈文超
		if(null != allDeptFlag){
			ErpFunUsers updateFunUSers = new ErpFunUsers();

			updateFunUSers.setAlldeptFlag(allDeptFlag > 0);
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			ErpFunUsersExample.Criteria criteria = usersExample.createCriteria();
			usersExample.createCriteria().andUserWriteoffEqualTo(false).andUserPositionEqualTo(roleId).andCompIdEqualTo(compId);
			if(avaDeptIds.size() > 0) {
				criteria.andDeptIdIn(new ArrayList<>(avaDeptIds));
			}
			erpFunUsersMapper.updateByExampleSelective(updateFunUSers, usersExample);
		}
		Set<Integer> deptIds = new HashSet<Integer>();
		Set<Integer> userIds = new HashSet<Integer>();

		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(cityId);
		usersExample.createCriteria().andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(usersExample);

		for(ErpFunUsers funUsersPO : userList){
			if(avaDeptIds.size() == 0 || avaDeptIds.contains(funUsersPO.getDeptId()) ){
				//包含在该门店范围内才更新缓存
				if(funUsersPO.getUserPosition().equals(roleId)){
					try {
						//更新人员权限，给被更改的人员一个提示,2代表修改权限
						Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
						if (loginKey != null) {
						    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
						}
						loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
						if (loginKey != null) {
						    cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
						}
					} catch (Exception e) {
						//这里不需要报出异常信息}
					}
					userIds.add(funUsersPO.getArchiveId());
					erpNoTransactionService.evictCacheableModelData(cityId, funUsersPO.getUserId());
				}
				deptIds.add(funUsersPO.getDeptId());
			}
		}

		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[]{}));
		TaskQueueThread.sendMessage(taskQueueMsg);

		erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);
	}

	/**
	 * 批量修改权限后更新用户信息
	 * @author 陈文超
	 * @date Nov 12, 2015 4:02:05 PM
	 */
	private void updateUserInfoAndCacheNewOrg(Integer cityId, Integer compId, String roleId, Integer allDeptFlag ,Integer organizationId) {

		//更新用户的较色信息并更新缓存 --陈文超
		if(null != allDeptFlag){
			ErpFunUsers updateFunUSers = new ErpFunUsers();

			updateFunUSers.setAlldeptFlag(allDeptFlag > 0);
			ErpFunUsersExample usersExample = new ErpFunUsersExample();
			usersExample.setShardCityId(cityId);
			ErpFunUsersExample.Criteria criteria = usersExample.createCriteria();
			criteria.andUserWriteoffEqualTo(false).andUserPositionEqualTo(roleId).andCompIdEqualTo(compId);
			if(organizationId > 0) {
				criteria.andTissueLineLike(":"+organizationId+":");
			}
			erpFunUsersMapper.updateByExampleSelective(updateFunUSers, usersExample);
		}
		Set<Integer> deptIds = new HashSet<Integer>();
		Set<Integer> userIds = new HashSet<Integer>();

		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.setShardCityId(cityId);
		ErpFunUsersExample.Criteria criteria = usersExample.createCriteria();
		criteria.andCompIdEqualTo(compId).andUserWriteoffEqualTo(false);
		if(organizationId> 0) {
			criteria.andTissueLineLike(":"+organizationId+":");
		}
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(usersExample);

		for(ErpFunUsers funUsersPO : userList){
			//包含在该门店范围内才更新缓存
			if(funUsersPO.getUserPosition().equals(roleId)){
				try {
					//更新人员权限，给被更改的人员一个提示,2代表修改权限
					Object loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_ERP + funUsersPO.getArchiveId());
					if (loginKey != null) {
						cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
					}
					loginKey = cacheUtil.get(CacheStructure.ARCHIVE_ID_APP + funUsersPO.getArchiveId());
					if (loginKey != null) {
						cacheUtil.put(loginKey, Const.LogInEnum.RoleOrOper_UP.getValue(), CacheUtilExt.INVALID_TIME_OUT);
					}
				} catch (Exception e) {
					//这里不需要报出异常信息}
				}
				userIds.add(funUsersPO.getArchiveId());
				erpNoTransactionService.evictCacheableModelData(cityId, funUsersPO.getUserId());
			}
			deptIds.add(funUsersPO.getDeptId());
		}

		TaskQueueMsg taskQueueMsg = new TaskQueueMsg();
		taskQueueMsg.setTaskType(new TaskQueueThread.TaskType[]{TaskQueueThread.TaskType.MERGE_APP_REFRESH_USER});
		taskQueueMsg.setTargetIds(userIds.toArray(new Integer[]{}));
		TaskQueueThread.sendMessage(taskQueueMsg);

		erpNoTransactionService.evictBaseInfoByCompId(cityId, compId);
	}


	@Override
	public String[] parseQueryColumnByCompOpers(String roleId, ErpFunUsers model, Integer compId, Integer cityId) throws Exception {
		Map<String ,Set<String>> tmpSetMap = this.getCurrRoleCompOpersByRangId(roleId,compId,cityId);
		Set<String> areaIds = tmpSetMap.get("AREA");
		Set<String> regionIds = tmpSetMap.get("REGION");
		Set<String> deptIds = tmpSetMap.get("DEPT");
		Set<String> compIds = tmpSetMap.get("COMP");
		if(deptIds.contains(model.getDeptId())){
			return new String[]{"DEPT_ID",model.getDeptId().toString()};
		}else if(model.getRegId()!=null && regionIds.contains(model.getRegId().toString())){
			return new String[]{"REG_ID",model.getRegId().toString()};
		}else if(model.getAreaId()!=null && areaIds.contains(model.getAreaId().toString())){
			return new String[]{"AREA_ID",model.getAreaId().toString()};
		}else if(compIds.contains(compId)){
			return new String[]{"SOURCE_COMP_ID",compId.toString()};
		}else{
			return new String[]{"SOURCE_COMP_ID",compId.toString()};
		}
	}

	@Override
	public Map<String, Set<String>> getCurrRoleCompOpersByRangId(String roleId, Integer compId, Integer cityId) throws Exception {
		Set<String> grIds = new HashSet<String>();
		Set<String> deptIds = new HashSet<String>();
		Set<String> regionIds = new HashSet<String>();
		Set<String> areaIds = new HashSet<String>();
		Set<String> compIds = new HashSet<String>();
		List<ErpCompRoleOpers> tmps = erpCompRoleOpersMapper.parseQueryColumnForUserOpers(cityId, compId, roleId);
		Map<String,Set<String>> tmpIds = new HashMap<String,Set<String>>();
		
		for(ErpCompRoleOpers tmpOpers : tmps){
			Integer tmpAreaId = tmpOpers.getAreaId();
			Integer tmpRegionId = tmpOpers.getRegId();
			Integer tmpDeptId = tmpOpers.getDeptId();
			Integer tmpgrId = tmpOpers.getGroupId();
			Integer tmpComptId = tmpOpers.getSourceCompId();
			if(!CommonUtil.isnull(tmpAreaId)){
				areaIds.add(tmpAreaId.toString());
			}
			if(!CommonUtil.isnull(tmpRegionId)){
				regionIds.add(tmpRegionId.toString());
			}
			if(!CommonUtil.isnull(tmpDeptId)){
				deptIds.add(tmpDeptId.toString());
			}
			if(!CommonUtil.isnull(tmpgrId)){
				grIds.add(tmpgrId.toString());
			}
			if(!CommonUtil.isnull(tmpComptId)){
				compIds.add(tmpComptId.toString());
			}
		}
		tmpIds.put("AREA", areaIds);
		tmpIds.put("REGION", regionIds);
		tmpIds.put("DEPT", deptIds);
		tmpIds.put("GROUP", grIds);
		tmpIds.put("COMP", compIds);
		return tmpIds;
	}


	public static void main(String[] args) {

		Calendar  c = Calendar.getInstance();
		
		Calendar start = Calendar.getInstance();
		start.set(Calendar.HOUR_OF_DAY, 7);
		start.set(Calendar.MINUTE, 30);
		start.set(Calendar.SECOND, 0);
		start.set(Calendar.MILLISECOND, 0);

		Calendar end = Calendar.getInstance();
		end.set(Calendar.HOUR_OF_DAY, 20);
		end.set(Calendar.MINUTE, 0);
		end.set(Calendar.SECOND, 0);
		end.set(Calendar.MILLISECOND, 0);

		System.out.println(c.after(start) && c.before(end));
	}

	@Override
	@Transactional
	public void updateRolePermissionTemplate(Integer cityId, Integer compId, UpdateRolePermissionTemplateParam param) {
		Integer effectRange = param.getEffectRange();// 应用范围 保留员工配置=1，不保留=0
		Integer isCompRole = param.getIsCompRole();// 是否是公司自定义角色
		Integer permissionTemplateId = param.getPermissionTemplateId();// 权限模板id
		String roleId = param.getRoleId();// 角色id
		
		// 删除员工权限
		if (Integer.valueOf(1).equals(effectRange)) {// 保留员工独立权限
			erpUserOpersMapper.deleteByCompRoleOpers(cityId, compId, roleId);
		} else {
			erpUserOpersMapper.deleteByCompIdAndRoleId(cityId, compId, roleId, null, null, null);
		}
		
		// 先删除这个角色的权限
		ErpCompRoleOpersExample compRoleOpersExample = new ErpCompRoleOpersExample();
		compRoleOpersExample.setShardCityId(cityId);
		ErpCompRoleOpersExample.Criteria criteria = compRoleOpersExample.createCriteria();
		criteria.andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
		erpCompRoleOpersMapper.deleteByExample(compRoleOpersExample);
		
		// 插入新模板的权限给这个角色的权限
		erpCompRoleOpersMapper.insertRoleOpersByTemplateId(cityId, compId, roleId, permissionTemplateId);
		
		// 重新建立角色与模板的关联关系
		ErpFunCompRolesPermissionTemplateRelateExample erpFunCompRolesPermissionTemplateRelateExample = new ErpFunCompRolesPermissionTemplateRelateExample();
		erpFunCompRolesPermissionTemplateRelateExample.setShardCityId(cityId);
		erpFunCompRolesPermissionTemplateRelateExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId);
		List<ErpFunCompRolesPermissionTemplateRelate> rolePermissionRelateList = erpFunCompRolesPermissionTemplateRelateMapper.selectByExample(erpFunCompRolesPermissionTemplateRelateExample);
		
		ErpFunCompRolesPermissionTemplateRelate erpFunCompRolesPermissionTemplateRelate = new ErpFunCompRolesPermissionTemplateRelate();
		erpFunCompRolesPermissionTemplateRelate.setShardCityId(cityId);
		erpFunCompRolesPermissionTemplateRelate.setCompId(compId);
		erpFunCompRolesPermissionTemplateRelate.setRoleId(roleId);
		erpFunCompRolesPermissionTemplateRelate.setTemplateId(permissionTemplateId);
		Integer originalTemplateId = null;
		List<Integer> templateIdList = new ArrayList<Integer>();
		if (!rolePermissionRelateList.isEmpty()) {
			// 取一个出来，获取原始模板id
			originalTemplateId = rolePermissionRelateList.get(0).getTemplateId();
			erpFunCompRolesPermissionTemplateRelate.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
			erpFunCompRolesPermissionTemplateRelateMapper.updateByExampleSelective(erpFunCompRolesPermissionTemplateRelate, erpFunCompRolesPermissionTemplateRelateExample);
		} else {
			erpFunCompRolesPermissionTemplateRelate.setCreationTime(DateTimeHelper.formatDateTimetoString(new Date(), DateTimeHelper.FMT_yyyyMMddHHmmss));
			erpFunCompRolesPermissionTemplateRelateMapper.insertSelective(erpFunCompRolesPermissionTemplateRelate);
		}
		
		ErpCompRoles erpCompRoleOpers = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
		
		String modifyContent = "";
		List<ErpFunCompPermissionTemplate> permissionTemplateList = new ArrayList<ErpFunCompPermissionTemplate>();
		ErpFunCompPermissionTemplateExample erpFunCompPermissionTemplateExample = new ErpFunCompPermissionTemplateExample();
		erpFunCompPermissionTemplateExample.setShardCityId(cityId);
		if (null != originalTemplateId) {
			templateIdList.add(originalTemplateId);
			templateIdList.add(permissionTemplateId);
			erpFunCompPermissionTemplateExample.createCriteria().andCompIdEqualTo(compId).andIdIn(templateIdList);
			permissionTemplateList = erpFunCompPermissionTemplateMapper.selectByExample(erpFunCompPermissionTemplateExample);
		} else {
			templateIdList.add(permissionTemplateId);
			erpFunCompPermissionTemplateExample.createCriteria().andCompIdEqualTo(compId).andIdIn(templateIdList);
			permissionTemplateList = erpFunCompPermissionTemplateMapper.selectByExample(erpFunCompPermissionTemplateExample);
		}
		Map<Integer, String> permissionTemplateMap = permissionTemplateList.stream().collect(Collectors.toMap(ErpFunCompPermissionTemplate :: getId, val -> val.getPermissionTemplateName(), (oldVal, newVal) -> oldVal));
		String originalTemplateName = permissionTemplateMap.get(originalTemplateId);
		String permissionTemplateName = permissionTemplateMap.get(permissionTemplateId);
		
		if (StringUtil.isNotBlank(originalTemplateName) && StringUtil.isNotBlank(permissionTemplateName)) {
			modifyContent = "从 " + originalTemplateName + " 改为了 " + permissionTemplateName;
		} else if (StringUtil.isNotBlank(permissionTemplateName)) {
			modifyContent = "改为了 " + permissionTemplateName;
		}

//		XX修改了XX(角色名称) 修改权限 ，从XX(模板名称)改为了XX(模板名称)
		String content = "修改了" + erpCompRoleOpers.getRoleName() + "角色权限，" + modifyContent;
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_ROLE_OPERS, null, null , content, null, null, cityId, compId, param.getCurDeptId(), param.getCurUserId());
		
		// 通过JMS调用处理员工权限
		Set<String> repeatUpdateOperIds = new HashSet<String>();
		
		compRoleOpersExample = new ErpCompRoleOpersExample();
		compRoleOpersExample.setShardCityId(cityId);
		compRoleOpersExample.createCriteria().andCompIdEqualTo(compId).andRoleIdEqualTo(roleId).andSourceCompIdEqualTo(compId).andOperIdEqualTo("LOGIN_OTHER_DEPTS");
		int allDeptFlag = erpCompRoleOpersMapper.countByExample(compRoleOpersExample);
		if (allDeptFlag > 0) {
			repeatUpdateOperIds.add("LOGIN_OTHER_DEPTS");
		}
		activeMqPublisher.sendDealUserOperMsg(cityId, compId, Arrays.asList(roleId), null, repeatUpdateOperIds, null);
	}

	// 新版组织架构才处理层级
	// modelFlag：是否是模板，如果是角色模板，那么默认可以放开到全公司， 否则如果是个人的组合权限，没有organizationId 其实给他默认到最低级
	@Override
	public void dealRoleOpersDefId(Integer cityId, Integer compId, String roleId, Set<ErpFunOpersDto> funOpersPOList, Boolean modelFlag) {

//		List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition = erpFunOrganizationDefinitionService.getAllEffectiveOrganizationDefinition(cityId, compId);
//		Map<Integer, ErpFunOrganizationDefinition> definitionMap = allEffectiveOrganizationDefinition.stream().collect(Collectors.toMap(val -> val.getDefinitionLevel(), val -> val));
		// 默认2级组织
		Integer defId = 0;
		Integer defLevel=0;
//		String defName = "";
//		if(!modelFlag) {
//			defId = -2;
//			defLevel= -2;
//		}
//
//		if(Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleId)) {
//			defId = 0;
//			defLevel=0;
//		} else if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)) {
//			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(2);
//			if(null != erpFunOrganizationDefinition) {
//				defId = erpFunOrganizationDefinition.getDefinitionId();
//				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
//				defName = erpFunOrganizationDefinition.getDefinitionName();
//			}
//		} else if(Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER.equals(roleId)) {
//			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(5);
//			if(null != erpFunOrganizationDefinition) {
//				defId = erpFunOrganizationDefinition.getDefinitionId();
//				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
//				defName = erpFunOrganizationDefinition.getDefinitionName();
//			}
//		} else if(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleId)) {
//			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(4);
//			if(null != erpFunOrganizationDefinition) {
//				defId = erpFunOrganizationDefinition.getDefinitionId();
//				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
//				defName = erpFunOrganizationDefinition.getDefinitionName();
//			}
//		} else if(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(roleId)) {
//			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(1);
//			if(null != erpFunOrganizationDefinition) {
//				defId = erpFunOrganizationDefinition.getDefinitionId();
//				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
//				defName = erpFunOrganizationDefinition.getDefinitionName();
//			}
//		} else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(roleId)) {
//			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(3);
//			if(null != erpFunOrganizationDefinition) {
//				defId = erpFunOrganizationDefinition.getDefinitionId();
//				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
//				defName = erpFunOrganizationDefinition.getDefinitionName();
//			}
//		}

		Iterator<ErpFunOpersDto> iterator = funOpersPOList.iterator();
		while (iterator.hasNext()) {
			ErpFunOpersDto val = iterator.next();
			Byte operType = val.getOperType();
			if(null == operType || 0 == operType) {
				continue;
			}
			val.setOrganizationDefinitionId(defId);
			val.setDefinitionLevel(defLevel);
//			val.setDefinitionName(defName);
		}
	}

	// 新版组织架构才处理层级
	// modelFlag：是否是模板，如果是角色模板，那么默认可以放开到全公司， 否则如果是个人的组合权限，没有organizationId 其实给他默认到最低级
	@Override
	public void dealRoleOpersDefId2(Integer cityId, Integer compId, String roleId, List<ErpUserOpersDto> funOpersPOList, Boolean modelFlag) {

		List<ErpFunOrganizationDefinition> allEffectiveOrganizationDefinition = erpFunOrganizationDefinitionService.getAllEffectiveOrganizationDefinition(cityId, compId);
		Map<Integer, ErpFunOrganizationDefinition> definitionMap = allEffectiveOrganizationDefinition.stream().collect(Collectors.toMap(val -> val.getDefinitionLevel(), val -> val));
		// 默认2级组织
		Integer defId = 0;
		Integer defLevel=0;
		String defName = "";
		if(!modelFlag) {
			defId = -2;
			defLevel= -2;
		}

		if(Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(roleId)) {
			defId = 0;
			defLevel=0;
		} else if(Constants_DIC.DIC_ROLE_NAME_BIZ_GENERAL.equals(roleId)) {
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(2);
			if(null != erpFunOrganizationDefinition) {
				defId = erpFunOrganizationDefinition.getDefinitionId();
				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
				defName = erpFunOrganizationDefinition.getDefinitionName();
			}
		} else if(Constants_DIC.DIC_ROLE_NAME_BIZ_MANAGER.equals(roleId)) {
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(5);
			if(null != erpFunOrganizationDefinition) {
				defId = erpFunOrganizationDefinition.getDefinitionId();
				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
				defName = erpFunOrganizationDefinition.getDefinitionName();
			}
		} else if(Constants_DIC.DIC_ROLE_NAME_BRANCH_MANAGER.equals(roleId)) {
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(4);
			if(null != erpFunOrganizationDefinition) {
				defId = erpFunOrganizationDefinition.getDefinitionId();
				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
				defName = erpFunOrganizationDefinition.getDefinitionName();
			}
		} else if(Constants_DIC.DIC_ROLE_NAME_DEPUTY_MANAGER.equals(roleId)) {
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(1);
			if(null != erpFunOrganizationDefinition) {
				defId = erpFunOrganizationDefinition.getDefinitionId();
				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
				defName = erpFunOrganizationDefinition.getDefinitionName();
			}
		} else if(Constants_DIC.DIC_ROLE_NAME_REGION_MANAGER.equals(roleId)) {
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = definitionMap.get(3);
			if(null != erpFunOrganizationDefinition) {
				defId = erpFunOrganizationDefinition.getDefinitionId();
				defLevel = erpFunOrganizationDefinition.getDefinitionLevel();
				defName = erpFunOrganizationDefinition.getDefinitionName();
			}
		}

		for (ErpUserOpersDto erpUserOpersDto : funOpersPOList) {
			Integer organizationDefinitionId = erpUserOpersDto.getOrganizationDefinitionId();
			if(null == organizationDefinitionId) {
				continue;
			}

			erpUserOpersDto.setOrganizationDefinitionId(defId);
			erpUserOpersDto.setDefinitionLevel(defLevel);
			erpUserOpersDto.setDefinitionName(defName);
		}

	}
}


