package com.myfun.service.business.erpdb.impl;

import javax.annotation.PostConstruct;

import com.myfun.erpWeb.managecenter.sysmanager.param.CompRolesParam;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunDeptsgroup;
import com.myfun.repository.erpdb.po.ErpFunRoleWageConfig;
import com.myfun.service.business.admindb.AdminFunCompService;
import com.myfun.utils.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpCompRolesService;
import com.myfun.service.business.erpdb.ErpFunUserManageRangeService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.Assert;
import com.myfun.utils.StringUtil;
import com.myfun.utils.UserOpersUtils;
import com.myfun.utils.SystemOperateUtil.SSL_TYPE;
import scala.annotation.meta.param;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Service
public class ErpCompRolesServiceImpl extends AbstractService<ErpCompRoles, ErpCompRoles> implements ErpCompRolesService{
	@Autowired private ErpCompRolesMapper erpCompRolesMapper;
	@Autowired ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Autowired ErpFunUserManageRangeService erpFunUserManageRangeService;
	@Autowired ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunRoleWageConfigMapper erpFunRoleWageConfigMapper;
	@Autowired
	ErpZxRoleConfigMapper erpZxRoleConfigMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	AdminFunCompService adminFunCompService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpCompRolesMapper;
	}

	@Transactional
	@Override
	public String addCompRoles(Integer cityId, Integer compId, Integer deptId, Integer userId, String roleName, Integer manageLevel, String beforRoleId, Byte partStatistCount) {
		// 角色名判重
		int count = erpCompRolesMapper.countByRoleName(cityId, compId, roleName);
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		if(count > 0) {
			if(null != adminFunComp){
				if(adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId())){
					throw new ConfirmException("该职级名已存在，请勿重复创建！");
				}
			}
			throw new ConfirmException("该角色名已存在，请勿重复创建！");
		}
		Integer seqNow = 1;
		
		ErpCompRoles compRole = erpCompRolesMapper.getByRoleId(cityId, compId, beforRoleId);
		if(compRole != null && compRole.getSeqNo() != null) {
			seqNow = compRole.getSeqNo().intValue();
		}
		
		// 先把之后的所有序号加一，给当前角色留个seq
		String roleId = StringUtil.getUUIDBySub();
		erpCompRolesMapper.addSeqForRight(cityId, compId, seqNow);
		seqNow++;// 序号+1
		ErpCompRoles erpCompRoles = new ErpCompRoles();
		erpCompRoles.setCompId(compId);
		erpCompRoles.setIsCompRole((byte) 1);
		erpCompRoles.setIsDel((byte) 0);
		erpCompRoles.setManageFlag((byte) 0);
		erpCompRoles.setRoleId(roleId);
		erpCompRoles.setRoleName(roleName);
		erpCompRoles.setSeqNo(seqNow);
		erpCompRoles.setShardCityId(cityId);
		if(null != manageLevel) {
			erpCompRoles.setManageLevel(manageLevel.byteValue());
		}else {
			erpCompRoles.setManageLevel((byte) 0);
		}

		erpCompRoles.setUpdateTime(DateUtil.DateToString(new Date()));
		erpCompRoles.setPartStatistCount(partStatistCount);
		erpCompRolesMapper.insertSelective(erpCompRoles);
		// 写修改日志
		String logContent = "新增了" + roleName + "角色";
		erpSystemSettingLogsService.insertSysLog(SSL_TYPE.OPERS_INSERT, null, null, logContent, null, null, cityId, compId, deptId, userId);


		String wstWageAccountingDay = erpSysParaMapper.getParamValue(cityId, compId, "WAGE_ACCOUNTING_DAY");
		// 判断结算月 结算日小于15号查询上月作为自然月的数据来处理 ，结算日大于15号以本月作为自然月来查询
		String assessMentMonth = DateUtil.getAssessMentMonth(wstWageAccountingDay, 0);
		// 这里初始化一条薪资配置，免得造成半途配置出现工作量统计不全的情况
		ErpFunRoleWageConfig erpFunRoleWageConfig = new ErpFunRoleWageConfig();
		erpFunRoleWageConfig.setAssessmentMonth(assessMentMonth);
		erpFunRoleWageConfig.setCompId(compId);
		erpFunRoleWageConfig.setCreateTime(Calendar.getInstance().getTime());
		erpFunRoleWageConfig.setIsCheck((byte) 1);
		erpFunRoleWageConfig.setRoleId(roleId);
		erpFunRoleWageConfig.setShardCityId(cityId);
		erpFunRoleWageConfig.setBaseWage(BigDecimal.ZERO);
		erpFunRoleWageConfig.setCreateUid(userId);
		erpFunRoleWageConfigMapper.insertSelective(erpFunRoleWageConfig);

		return roleId;
	}

	@Transactional
	@Override
	public void updateRoleManageLevel(Integer cityId, Integer compId, String roleId, Byte manageLevel) {
		ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
		Assert.isNullThrow(compRoles, "未找到该角色");
		Byte levelSel = compRoles.getManageLevel();
		Assert.isTrueThrow(levelSel != null && levelSel > 0 && levelSel < 6, "该角色已有管理层级");
		ErpCompRoles record = new ErpCompRoles();
		record.setManageLevel(manageLevel);
		record.setAutoId(compRoles.getAutoId());
		record.setShardCityId(cityId);
		record.setUpdateTime(DateUtil.DateToString(new Date()));
		erpCompRolesMapper.updateByPrimaryKeySelective(record);
		// 管理层级为公司
		if(manageLevel == 1) {
			erpFunUserManageRangeService.createRangeForComp(cityId, roleId, compId);
		}
	}

	@Transactional
	@Override
	public void updateCompRolesName(Integer cityId, Integer compId, Integer deptId, Integer userId, String roleId, String roleName, String userName, Byte partStatistCount) {
		ErpFunComp erpFunComp = erpFunCompMapper.selectByCompId(cityId, compId);
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(erpFunComp.getCompNo());
		ErpCompRoles erpCompRoles = erpCompRolesMapper.getByRoleId(cityId, compId, roleId);
		boolean fjd = adminFunCompService.judgerIsFangjidi(adminFunComp.getCompId());
		if(null == erpCompRoles){
			if(fjd){
				throw new ConfirmException("未找到该职级的任何信息！");
			}
			throw new ConfirmException("未找到该角色的任何信息！");
		}
		if(erpCompRoles.getRoleName().equals(roleName)){
			if(fjd){
				throw new ConfirmException("修改前后职级名一致！");
			}
			throw new ConfirmException("修改前后角色名一致！");
		}
		// 角色名判重
		int count = erpCompRolesMapper.countByRoleName(cityId, compId, roleName);
		if(count > 0) {
			if(fjd){
				throw new ConfirmException("该职级名已存在，请勿重复创建！");
			}
			throw new ConfirmException("该角色名已存在，请勿重复创建！");
		}
		//大白说的，系统角色也可以改
		/*if(erpCompRoles.getIsCompRole().intValue() != 1){
			throw new ConfirmException("不能修改系统角色！");
		}*/
		if (StringUtil.isNotBlank(roleName)) {
			String content = userName + " 将角色名 " + erpCompRoles.getRoleName() + " 改成 " + roleName;
			// 写系统跟进
			erpSystemSettingLogsService.insertSysLog(SSL_TYPE.UPDATE_ROLE_NAME, null, null, content, null, null, cityId, compId, deptId, userId);
		}
		erpCompRolesMapper.updateRoleNameByRoleId(cityId, compId, roleId, roleName, partStatistCount);
	}

	@Transactional
	@Override
	public void updateUserOpers(Integer cityId, Integer compId, String tmpField, String columnName, String columnValue, String roleId, Set<String> deleteOpers, Set<String> ptOperAdd, List<Byte> flagList) {
/*		if(deleteOpers.size() > 0) {
			// 删除   前面做了加判断的删除  这里就不要了
			erpUserOpersMapper.deleteByRoleId(cityId, compId, tmpField, columnValue, roleId, deleteOpers);
		}*/
		erpUserOpersMapper.mergeUserOpers(cityId, compId, tmpField, columnName, columnValue, roleId, flagList);
		
		// 处理加盟商模式的部分权限问题,删除人员身上不该有的权限
		if (flagList.size() > 1) {// 加盟商模式下，size才会大于1
			String column = columnName;
			String columnVal = columnValue;
			if(UserOpersUtils.COMP_ROLE_OPERS_GROUP_ID.equals(columnName)){
				column = "GR_ID";
			} else if(UserOpersUtils.COMP_ROLE_OPERS_SOURCE_COMP_ID.equals(columnName)){
				column = "COMP_ID";
			}
			// 特殊处理加盟商需求里面，加盟商特有的两个权限的应用到人的范围，上面写，这里删除不在这个范围内的人的这两个权限
			if (ptOperAdd.contains("PARTNER_MANAGE_OPER")) {// 加盟商管理权，只能应用到总部人，删除非总部人身上的权限
				erpUserOpersMapper.deletePartnerOperByNoPartner(cityId, compId, "PARTNER_MANAGE_OPER", column, columnVal, 0);// 0表示删除非总部,1表示删除非加盟商
			}
			if (ptOperAdd.contains("MANAGE_PARTNER_BULLET")) {// 加盟商公告管理权，只能应用到加盟商人，删除非加盟商人身上的权限
				erpUserOpersMapper.deletePartnerOperByNoPartner(cityId, compId, "MANAGE_PARTNER_BULLET", column, columnVal, 1);// 0表示删除非总部,1表示删除非加盟商
			}
		} else {
			erpUserOpersMapper.deletePartnerOperByNoPartner(cityId, compId, "PARTNER_MANAGE_OPER", "COMP_ID", compId.toString(), 0);// 0表示删除非总部,1表示删除非加盟商
			erpUserOpersMapper.deletePartnerOperByNoPartner(cityId, compId, "MANAGE_PARTNER_BULLET", "COMP_ID", compId.toString(), 1);// 0表示删除非总部,1表示删除非加盟商
		}
	}

	@Transactional
	@Override
	public void deleteCompRoles(CompRolesParam param, Integer autoId, String roleName, String roleId) {
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		//把其他角色升降级为当前角色的关闭，如：1角色开启自动升级并且升级为当前角色，就将1角色的自动升级关闭
		erpZxRoleConfigMapper.updateElseRole(cityId,compId,roleId);

		ErpCompRoles record = new ErpCompRoles();
		record.setIsDel((byte)1);
		record.setAutoId(autoId);
		record.setShardCityId(cityId);
		record.setUpdateTime(DateUtil.DateToString(new Date()));
		erpCompRolesMapper.updateByPrimaryKeySelective(record);
		String content = "删除了 " + roleName + " 角色";
		BaseMapParam baseMapParam =new BaseMapParam();
		baseMapParam.setInteger("cityId",cityId);
		baseMapParam.setInteger("compId",param.getCompId());
		baseMapParam.setInteger("deptId",param.getDeptId());
		baseMapParam.setInteger("userId",param.getUserId());
		erpSystemSettingLogsService.insertLog(SSL_TYPE.OPERS_DELETE, null, content, null, null,baseMapParam);
	}
}


