package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.common.param.*;
import com.myfun.erpWeb.common.vo.OrganizationDefinitionVO;
import com.myfun.erpWeb.common.vo.OrganizationVO;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectNmaesParam;
import com.myfun.erpWeb.statisticalAnalysis.param.GetSelectWhereParam;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.agencydb.dao.AgencyPropertyRelatedPersonMapper;
import com.myfun.repository.agencydb.po.AgencyPropertyRelatedPerson;
import com.myfun.repository.agencydb.po.AgencyPropertyRelatedPersonExample;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.erpdb.bean.vo.InsertSqlVO;
import com.myfun.service.business.erpdb.bean.vo.MoveOrganizationServiceVO;
import com.myfun.service.business.erpdb.bean.vo.OrganizationDic;
import com.myfun.service.business.taskJob.HttpRequestTask;
import com.myfun.utils.Assert;
import com.myfun.service.jms.activeMQ.ActiveMqPublisher;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.myfun.erpWeb.common.param.AddSubOrganizationParam;
import com.myfun.erpWeb.common.param.DeleteSubOrganizationParam;
import com.myfun.erpWeb.common.param.EditSubOrganizationParam;
import com.myfun.erpWeb.common.param.MoveOrganizationParam;
import com.myfun.erpWeb.managecenter.userOpers.vo.ErpOrganizationVO;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.LogInEnum;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunEmployeeLogService;
import com.myfun.service.business.erpdb.ErpFunOrganizationService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.service.business.erpdb.ErpSystemSettingLogsService;
import com.myfun.utils.SystemOperateUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import scala.annotation.meta.param;

/**
 * TODO 新组织架构部门
 * @author lzg
 * @since 2019年11月25日
 * Modified XXX lzg 2019年11月25日
 */
@Service
public class ErpFunOrganizationServiceImpl extends AbstractService<ErpFunOrganization, ErpFunOrganization> implements ErpFunOrganizationService{
	
	@Autowired
	ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	ErpFunOrganizationDefinitionMapper erpFunOrganizationDefinitionMapper;
	@Autowired
	ErpFunOrganizationManagerMapper erpFunOrganizationManagerMapper;
	@Autowired
	AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	ErpSystemSettingLogsService erpSystemSettingLogsService;
	@Autowired
	ErpFunUpdatePidApplyMapper erpFunUpdatePidApplyMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	ErpSysParaMapper erpSysParaMapper;
	@Autowired
	ErpFunLogsMapper erpFunLogsMapper;
	@Autowired
	ErpFunUsersService erpFunUsersService;
	@Autowired
	ErpFunUserManageRangeMapper erpFunUserManageRangeMapper;
	@Autowired
	ActiveMqPublisher mqPublisher;
	@Autowired
	ErpFunEmployeeLogService erpFunEmployeeLogService;
	@Autowired
	ErpFunCompMapper erpFunCompMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	ErpFunCityMapper erpFunCityMapper;
	@Autowired
	AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private AgencyPropertyRelatedPersonMapper agencyPropertyRelatedPersonMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunOrganizationMapper;
	}

	/**
	 * 添加部门
	 */
	@Override
	@Transactional
	public Integer insertOrganizationInfo(AddSubOrganizationParam param,String userName) {
		if(StringUtil.isBlank(param.getOrganizationName()) || param.getOrganizationName().length() > 31) {
			throw new BusinessException("名称不合法");
		}
		if(null == param.getPid() || param.getPid() < 0) {
			throw new BusinessException("添加部门失败，请联系在线客服");//PID不合法
		}
		Integer count = 0;
		if(StringUtils.isBlank(param.getMlOrgId())) {
			count = erpFunOrganizationMapper.countByEqualOrgName(param.getCityId(), param.getCompId(), param.getOrganizationName().trim()); //判重
			if(count > 0) {
				throw new BusinessException("部门名称重复，请核对后重新输入");
			}
		}

		boolean isFirstLevelOrg = false;
		if(param.getPid() != 0) {
			//新增部门层级不能高于父级部门层级—— 根据PID，查出父级部门的层级；对比新增部门层级
			ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
			erpFunOrganizationExample.setShardCityId(param.getCityId());
			erpFunOrganizationExample.createCriteria().andOrganizationIdEqualTo(param.getPid()).andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
			List<ErpFunOrganization> listP = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
			if(null != listP && listP.size() > 0) {
				ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
				erpFunOrganizationDefinitionExample.createCriteria().andDefinitionIdEqualTo(listP.get(0).getOrganizationDefinitionId())
				.andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
				erpFunOrganizationDefinitionExample.setShardCityId(param.getCityId());
				List<ErpFunOrganizationDefinition> selectParentLevel = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
				
				ErpFunOrganizationDefinitionExample subLevelEruFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
				subLevelEruFunOrganizationDefinitionExample.createCriteria().andDefinitionIdEqualTo(param.getDefinitionId()).andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
				subLevelEruFunOrganizationDefinitionExample.setShardCityId(param.getCityId());
				List<ErpFunOrganizationDefinition> selectSubLevel = erpFunOrganizationDefinitionMapper.selectByExample(subLevelEruFunOrganizationDefinitionExample);
				if(null == selectSubLevel || selectSubLevel.size() < 1) {
					throw new BusinessException("添加部门失败：新增部门层级未获取到");
				}
				if(selectParentLevel.get(0).getDefinitionLevel() >= selectSubLevel.get(0).getDefinitionLevel()) {
					throw new BusinessException("添加部门失败：新增部门级别不能高于或等于所属部门");
				}
			}
		}
		
		//组织机构表：自增序列、城市id、公司id，部门名称、是否删除、层级（组织机构定义id）、父级组织id、组织综合查询字段、联系电话、地址、创建时间、更新/删除时间、序号、组织人数、
		ErpFunOrganization org = new ErpFunOrganization();
		//BeanUtil.copyObject(param, org); //
		
		Integer newOrganizationId = adminFunDeptsMapper.getNewDeptIdBySeq(); //生成序列
		org.setOrganizationId(newOrganizationId);
		org.setMlOrgId(param.getMlOrgId());
		org.setQxType(param.getQxType());
		org.setShardCityId(param.getCityId());
		org.setCityId(param.getCityId());
		org.setCompId(param.getCompId());
		org.setOrganizationName(param.getOrganizationName().trim());
		org.setDelFlag((byte) 0);
		org.setOrganizationDefinitionId(param.getDefinitionId()); //组织机构定义id
		if(param.getPid() == 0) { //一级部门pid为0
			org.setPid(0);
			org.setOrganizationPath(":" + newOrganizationId + ":");
			isFirstLevelOrg = true;
			//美联专用：组织业务类型 0=初始没选状态  1=住宅 2=工商铺 3=后勤部门
	        org.setOrganizationBussinessType((byte)0);
	        if(null != param.getOrganizationBussinessType()) {
	        	int obType = param.getOrganizationBussinessType();
	        	if(obType == 0 || obType == 1 || obType == 2 || obType == 3) {
	        		org.setOrganizationBussinessType((byte) obType);
	        	}
	        }
		} else {
			org.setPid(param.getPid());
			//根据父id的组织综合查询字段+自身生成的id
			ErpFunOrganizationExample orgP = new ErpFunOrganizationExample();
			orgP.setShardCityId(param.getCityId());
			orgP.createCriteria().andOrganizationIdEqualTo(param.getPid());
			List<ErpFunOrganization> list = erpFunOrganizationMapper.selectByExample(orgP);
			org.setOrganizationPath(list.get(0).getOrganizationPath() + newOrganizationId + ":");
			//仅一级部门可设置，下级部门直接取值一级部门的
			org.setOrganizationBussinessType(list.get(0).getOrganizationBussinessType());
		}
		org.setContactNumber(param.getContactNumber());
		org.setOrganizationAddr(param.getOrganizationAddr());
		org.setCreationTime(new Date()); //new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		//org.setOrganizationSeq(param.getOrganizationSeq());
		org.setOrganizationUserNum(0); //组织人数初始为0
		
		//生成组织编号（类似门店编号）方法
		ErpFunOrganizationExample selectOrgNoExample = new ErpFunOrganizationExample();
		selectOrgNoExample.setShardCityId(param.getCityId());
		selectOrgNoExample.setOrderByClause(" CREATION_TIME DESC ");
		selectOrgNoExample.createCriteria().andCompIdEqualTo(param.getCompId()).andDelFlagEqualTo((byte)0);
		List<ErpFunOrganization> orgNo = erpFunOrganizationMapper.selectByExample(selectOrgNoExample);
		if(orgNo.size() < 1 || null == orgNo.get(0).getOrganizationNo()) {
			throw new BusinessException("组织编号生成异常");
		}
        String maxOrganizationNo = orgNo.get(0).getOrganizationNo();
        char[] orgNos = maxOrganizationNo.toCharArray();
        orgNos = this.getNewDeptNo(maxOrganizationNo);
        String newOrganizationNo = new String(orgNos);
        org.setOrganizationNo(newOrganizationNo);
		
		count  = erpFunOrganizationMapper.insertOrganizationInfo(org);
		if(count != 1) {
			throw new BusinessException("部门添加失败，请刷新后重试");
		}
		if (isFirstLevelOrg) {
			createDeptInfo(param.getCityId(), param.getCompId(), param.getCompNo(), param.getCompType().byteValue(), 0, newOrganizationId,org);
		}
		//主管表：外键组织id、主管经纪人id、公司id、创建时间
		ErpFunOrganizationManager insertErpFunOrganizationManager = new ErpFunOrganizationManager();
		insertErpFunOrganizationManager.setShardCityId(param.getCityId());
		insertErpFunOrganizationManager.setOrganizationId(newOrganizationId);
		insertErpFunOrganizationManager.setCompId(param.getCompId());
		insertErpFunOrganizationManager.setCreationTime(new Date());
		
		//efom.setUserId(param.getAdminUserId()); //主管经纪人id——  多个
		/*if(param.getAdminUserId() == null || "".equals(param.getAdminUserId().trim())) {
			throw new BusinessException("部门添加失败，至少需要添加一名管理人员");
		}*/
		if(null != param.getAdminUserId() && !StringUtil.isBlank(param.getAdminUserId().trim())) {
			String []adminUserId = param.getAdminUserId().trim().split(",");
			for(String u : adminUserId) {
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.createCriteria().andCompIdEqualTo(param.getCompId()).andUserIdEqualTo(Integer.parseInt(u));
				erpFunUsersExample.setShardCityId(param.getCityId());
				List<ErpFunUsers> selectErpFunUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
				if(null == selectErpFunUsers || selectErpFunUsers.size() < 1) {
					throw new BusinessException("部门添加失败，添加的管理人员中有用户id无法识别");
				}
				insertErpFunOrganizationManager.setUserId(Integer.parseInt(u));
				erpFunOrganizationManagerMapper.insertSelective(insertErpFunOrganizationManager);
				//向FUN_USER_MANAGE_RANGE（员工管理范围配置表）插入记录
				ErpFunUserManageRangeExample erpFunUserManageRangeExample = new ErpFunUserManageRangeExample();
				erpFunUserManageRangeExample.createCriteria().andUserIdEqualTo(Integer.parseInt(u)).andRangeIdEqualTo(newOrganizationId);
				erpFunUserManageRangeExample.setShardCityId(param.getCityId());
				List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.selectByExample(erpFunUserManageRangeExample);
				if(null == userManageRange || userManageRange.size() < 1) {
					ErpFunUserManageRange insertUserManageRange = new ErpFunUserManageRange();
					insertUserManageRange.setUserId(Integer.parseInt(u));
					insertUserManageRange.setRangeId(newOrganizationId);
					insertUserManageRange.setCreationTime(new Date());
					insertUserManageRange.setCompId(param.getCompId());
					insertUserManageRange.setRoleId(selectErpFunUsers.get(0).getUserPosition());
					insertUserManageRange.setManageType((byte)2);
					insertUserManageRange.setShardCityId(param.getCityId());
					count = erpFunUserManageRangeMapper.insertSelective(insertUserManageRange);
					if(count != 1) {
						throw new BusinessException("部门添加失败，请刷新后重试");
					}
				}
			}
		}
		
		String content = "创建了 " + param.getOrganizationName().trim();
		//erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.CREATE_ORGANIZATION, null, null, content, null,null, param.getCityId(), param.getCompId(), null, param.getUserId());
		
		erpSystemSettingLogsService.insertSysLogNew(SystemOperateUtil.SSL_TYPE.CREATE_ORGANIZATION, null, null, content, null,
				null, param.getCityId(), param.getCompId(), null, param.getUserId(),userName);
		
		return newOrganizationId;
	}
	
	private char[] getNewDeptNo( String maxDeptNo) {
		char[] deptNos = maxDeptNo.toCharArray();
			if (deptNos[0] == 'Z') {
				deptNos[0] = '0';
			}
			if (deptNos[1] == '9') {
				deptNos[1] = '0';
				deptNos[0]++;
			} else {
				deptNos[1]++;
			}
		return deptNos;
	}

	/**
	 * 编辑部门信息
	 */
	@Override
	@Transactional
	public Integer editOrganizationInfo(EditSubOrganizationParam param) {
		if(StringUtil.isBlank(param.getOrganizationName()) || param.getOrganizationName().length() > 31) {
			throw new BusinessException("名称不合法");
		}
		if(param.getOrganizationId() != null) {
			//改部门名称、电话、地址、主管
			ErpFunOrganizationExample seleName = new ErpFunOrganizationExample();
			seleName.createCriteria().andCityIdEqualTo(param.getCityId()).andCompIdEqualTo(param.getCompId()).andOrganizationIdEqualTo(param.getOrganizationId());
			seleName.setShardCityId(param.getCityId());
			List<ErpFunOrganization> listName = erpFunOrganizationMapper.selectByExample(seleName);
			Integer count = erpFunOrganizationMapper.countByEqualOrgName(param.getCityId(), param.getCompId(), param.getOrganizationName().trim()); //判重
			if(count > 0 && ! listName.get(0).getOrganizationName().equals(param.getOrganizationName().trim())) {
				throw new BusinessException("部门名称重复，请核对后重新输入");
			}
			
			ErpFunOrganization org = new ErpFunOrganization();
			//创建24小时内 -> 当前层级defId和参数层级defId相匹配：不修改。 否则，获取当前层级level；pid=0的判断子级，pid!=0的，父级和子级都判断；
			//部门层级修改：1、创建24小时内可修改
			Date endTime = DateUtil.addDay(listName.get(0).getCreationTime(), 1);
			int res = DateUtil.dateCompare(listName.get(0).getCreationTime(), endTime);
			if(res == -1) {
				if(listName.get(0).getOrganizationDefinitionId() != param.getDefinitionId()) {//当前层级defId和参数层级defId不匹配则修改
					//查询自己修改前的层级
					ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
					erpFunOrganizationDefinitionExample.createCriteria().andDefinitionIdEqualTo(listName.get(0).getOrganizationDefinitionId()).andCompIdEqualTo(param.getCompId());
					erpFunOrganizationDefinitionExample.setShardCityId(param.getCityId());
					List<ErpFunOrganizationDefinition> selectSelfLevel = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
					
					//获取子级部门层级，不能比子级部门大
					ErpFunOrganizationExample subErpFunOrganizationExample = new ErpFunOrganizationExample();
					subErpFunOrganizationExample.createCriteria().andPidEqualTo(param.getOrganizationId()).andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
					subErpFunOrganizationExample.setShardCityId(param.getCityId());
					List<ErpFunOrganization> listSub = erpFunOrganizationMapper.selectByExample(subErpFunOrganizationExample);
					
					if(null != listSub && listSub.size() > 0) {
						for (ErpFunOrganization sub : listSub) {
							ErpFunOrganizationDefinitionExample subLevelEruFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
							subLevelEruFunOrganizationDefinitionExample.createCriteria().andDefinitionIdEqualTo(sub.getOrganizationDefinitionId()).andCompIdEqualTo(param.getCompId());
							subLevelEruFunOrganizationDefinitionExample.setShardCityId(param.getCityId());
							List<ErpFunOrganizationDefinition> selectSubLevel = erpFunOrganizationDefinitionMapper.selectByExample(subLevelEruFunOrganizationDefinitionExample);
							if(selectSubLevel.get(0).getDefinitionLevel() <= selectSelfLevel.get(0).getDefinitionLevel()) {
								throw new BusinessException("编辑部门失败：部门级别不能低于或等于下属部门");
							}
						}
					}
					if(listName.get(0).getPid() > 0) {
						//2、被修改的部门层级不能小于父级部门层级，也不能大于下级部门层级—— 根据PID查出父级部门的层级；根据organizationId查PID查出自级部门的层级；对比被修改的部门层级
						ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
						erpFunOrganizationExample.setShardCityId(param.getCityId());
						erpFunOrganizationExample.createCriteria().andOrganizationIdEqualTo(listName.get(0).getPid()).andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
						List<ErpFunOrganization> listParent = erpFunOrganizationMapper.selectByExample(erpFunOrganizationExample);
						if(null != listParent && listParent.size() > 0) {
							ErpFunOrganizationDefinitionExample selectParentLevelExample = new ErpFunOrganizationDefinitionExample();
							selectParentLevelExample.createCriteria().andDefinitionIdEqualTo(listParent.get(0).getOrganizationDefinitionId())
																			.andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
							selectParentLevelExample.setShardCityId(param.getCityId());
							List<ErpFunOrganizationDefinition> selectParentLevel = erpFunOrganizationDefinitionMapper.selectByExample(selectParentLevelExample);
							if(selectParentLevel.get(0).getDefinitionLevel() >= selectSelfLevel.get(0).getDefinitionLevel()) {
								throw new BusinessException("编辑部门失败：部门级别不能高于或等于所属部门");
							}
						}
						//根据父id的组织综合查询字段+自身生成的id
						/*ErpFunOrganizationExample orgP = new ErpFunOrganizationExample();
						orgP.setShardCityId(param.getCityId());
						orgP.createCriteria().andOrganizationIdEqualTo(listName.get(0).getPid()).andDelFlagEqualTo((byte)0).andCompIdEqualTo(param.getCompId());
						List<ErpFunOrganization> list = erpFunOrganizationMapper.selectByExample(orgP);*/
						
						//org.setOrganizationPath(listParent.get(0).getOrganizationPath() + param.getOrganizationId() + ":");
					}
				}
			}
			//修改父级：新旧pid不为空，且数据库查询出的pid和收到的新pid不相同时才做修改
			//1.判断调动组织下面的房客源数据，有多少,如果超过三千，那么晚上去调动,前端需要给个文案提示
			/*MoveOrganizationVO result = new MoveOrganizationVO();
			if (null != param.getNewPid() && param.getNewPid() > 0 && listName.get(0).getPid() > 0) {
				if (listName.get(0).getPid() != param.getNewPid()) {
					if (moveFlag) {
						result.setMoveType(0);
						moveOrganization(param.getCityId(),param.getCompId(),param.getUserId(),param.getOrganizationId(),listName.get(0).getPid(),param.getNewPid());
					} else {
						result.setMoveType(1);
						result.setMoveMsg("由于当前业务数据量改动大，为避免影响使用，本次调动组织操作系统由22点开始执行本次操作！");
						MoveOrganizationParam moveParam = new MoveOrganizationParam();
						moveParam.setCityId(param.getCityId());
						moveParam.setOrganizationId(param.getOrganizationId());
						moveParam.setCompId(param.getCompId());
						moveParam.setOldPid(listName.get(0).getPid());
						moveParam.setNewPid(param.getNewPid());
						moveParam.setUserId(param.getUserId());
						insertUpdatePidApplyInfo(moveParam);
					}
				}
			}*/
			
			org.setOrganizationDefinitionId(param.getDefinitionId());
			org.setOrganizationName(param.getOrganizationName().trim());
			org.setContactNumber(param.getContactNumber());
			org.setOrganizationAddr(param.getOrganizationAddr());
			org.setUpdateTime(new Date());
			
			if(null != param.getOrganizationBussinessType()) {
				if(listName.get(0).getOrganizationBussinessType() != (byte)param.getOrganizationBussinessType().intValue()) {
					if(param.getPid() == 0) { //一级部门pid为0
						//美联专用：组织业务类型 0=初始  1=住宅 2=工商铺 3=后勤部门
						//一级部门更改后，其他子部门也要跟随变动
						//org.setOrganizationBussinessType((byte)0);
						int obType = param.getOrganizationBussinessType();
						if(obType == 0 || obType == 1 || obType == 2 || obType == 3) {
							//org.setOrganizationBussinessType((byte) obType);
							ErpFunOrganization obt = new ErpFunOrganization();
							obt.setOrganizationBussinessType((byte)obType);
							
							ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
							orgExample.createCriteria().andCompIdEqualTo(param.getCompId()).andOrganizationPathLike("%:" + param.getOrganizationId() + ":%");
							orgExample.setShardCityId(param.getCityId());
							erpFunOrganizationMapper.updateByExampleSelective(obt, orgExample);
						}
					} else {
						ErpFunOrganizationExample orgP = new ErpFunOrganizationExample();
						orgP.setShardCityId(param.getCityId());
						orgP.createCriteria().andOrganizationIdEqualTo(param.getPid());
						List<ErpFunOrganization> list = erpFunOrganizationMapper.selectByExample(orgP);
						//仅一级部门可设置，下级部门直接取值一级部门的
						org.setOrganizationBussinessType(list.get(0).getOrganizationBussinessType());
					}
					//更改组织的业务类型后，其名下对应的数据INFO_TYPE 也要批量同步修改   INFO_TYPE = OrganizationBussinessType
					erpFunOrganizationManagerMapper.updateCaseInfoType(param.getCityId(), param.getOrganizationBussinessType(), param.getOrganizationId(), param.getCompId());
				}
			}
			
			//org.setOrganizationSeq(param.getOrganizationSeq());
			ErpFunOrganizationExample example = new ErpFunOrganizationExample();
			example.setShardCityId(param.getCityId());
			example.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId());
			count  = erpFunOrganizationMapper.updateByExampleSelective(org, example);
			if(count != 1) {
				throw new BusinessException("部门修改失败，请刷新后重试");
			}
			
			this.updateOrganizationManagerCommon(param.getCityId(), param.getCompId(), param.getOrganizationId(), param.getAdminUserId());

			String content = "修改了 " + param.getOrganizationName().trim();
			erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_ORGANIZATION, null, null, content, null,
					null, param.getCityId(), param.getCompId(), null, param.getUserId());
		}
		
		return null;
	}

	// modify lcb 修改于 2020/5/26 修改
	private void updateOrganizationManagerCommon(Integer cityId, Integer compId, Integer organizationId, String userIds) {
		//主管表：外键组织id、主管经纪人id、公司id、创建时间
		//删掉FUN_ORGANIZATION_MANAGER里的对应记录
		ErpFunOrganizationManagerExample deleteOrganizaitonManagerExample = new ErpFunOrganizationManagerExample();
		deleteOrganizaitonManagerExample.createCriteria().andOrganizationIdEqualTo(organizationId).andCompIdEqualTo(compId);
		deleteOrganizaitonManagerExample.setShardCityId(cityId);
		erpFunOrganizationManagerMapper.deleteByExample(deleteOrganizaitonManagerExample);
		//删除FUN_USER_MANAGE_RANGE表里的对应记录，MANAGE_TYPE=2是主管、=1是普通管理范围
		ErpFunUserManageRangeExample deleteUserManageRangeExample = new ErpFunUserManageRangeExample();
		deleteUserManageRangeExample.createCriteria().andRangeIdEqualTo(organizationId).andManageTypeEqualTo((byte)2).andCompIdEqualTo(compId);
		deleteUserManageRangeExample.setShardCityId(cityId);
		erpFunUserManageRangeMapper.deleteByExample(deleteUserManageRangeExample);

		ErpFunOrganizationManager insertErpFunOrganizationManager = new ErpFunOrganizationManager();
		insertErpFunOrganizationManager.setShardCityId(cityId);
		insertErpFunOrganizationManager.setOrganizationId(organizationId);
		insertErpFunOrganizationManager.setCompId(compId);
		insertErpFunOrganizationManager.setCreationTime(new Date());
		//主管经纪人id——  多个
			/*if(null == param.getAdminUserId() || "".equals(param.getAdminUserId().trim())) {
				throw new BusinessException("部门添加失败，至少需要添加一名管理人员");
			}*/
		if(!StringUtil.isBlank(userIds.trim())) {
			String[] adminUserId = userIds.trim().split(",");
			for(String u : adminUserId) {
				ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
				erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdEqualTo(Integer.parseInt(u));
				erpFunUsersExample.setShardCityId(cityId);
				List<ErpFunUsers> selectErpFunUsers = erpFunUsersMapper.selectByExample(erpFunUsersExample);
				if(null == selectErpFunUsers || selectErpFunUsers.size() < 1) {
					throw new BusinessException("部门添加失败，添加的管理人员中有用户id无法识别");
				}
				insertErpFunOrganizationManager.setUserId(Integer.parseInt(u));
				erpFunOrganizationManagerMapper.insertSelective(insertErpFunOrganizationManager);
				//向FUN_USER_MANAGE_RANGE（员工管理范围配置表）插入记录
				ErpFunUserManageRangeExample erpFunUserManageRangeExample = new ErpFunUserManageRangeExample();
				erpFunUserManageRangeExample.createCriteria().andUserIdEqualTo(Integer.parseInt(u)).andRangeIdEqualTo(organizationId);
				erpFunUserManageRangeExample.setShardCityId(cityId);
				List<ErpFunUserManageRange> userManageRange = erpFunUserManageRangeMapper.selectByExample(erpFunUserManageRangeExample); //根据user_id和range_id查，有了就不添加了
				if(null == userManageRange || userManageRange.size() < 1) {
					ErpFunUserManageRange insertUserManageRange = new ErpFunUserManageRange();
					insertUserManageRange.setUserId(Integer.parseInt(u));
					insertUserManageRange.setRangeId(organizationId);
					insertUserManageRange.setCreationTime(new Date());
					insertUserManageRange.setCompId(compId);
					insertUserManageRange.setRoleId(selectErpFunUsers.get(0).getUserPosition());
					insertUserManageRange.setManageType((byte)2);
					insertUserManageRange.setShardCityId(cityId);
					erpFunUserManageRangeMapper.insertSelective(insertUserManageRange);
				}
			}
		}

	}
	
	
	/**
	 * 根据组织机构id对其逻辑删除
	 */
	@Override
	public Integer deleteOrgByOrganizationId(DeleteSubOrganizationParam param) {
		ErpFunOrganizationExample orgExample = new ErpFunOrganizationExample();
		orgExample.setShardCityId(param.getCityId());
		orgExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId());
		List<ErpFunOrganization> listOrg = erpFunOrganizationMapper.selectByExample(orgExample);
		
		ErpFunUsersExample usersExample = new ErpFunUsersExample();
		usersExample.createCriteria().andTissueLineEqualTo("%:"+param.getOrganizationId()+":%");
		usersExample.setShardCityId(param.getCityId());
		List<ErpFunUsers> listUser = erpFunUsersMapper.selectByExample(usersExample);
		
		if(listUser.size() > 0) {
			throw new BusinessException("检测到此部门下还有人员存在，不能删除！");
		}
		
		ErpFunOrganizationExample example2 = new ErpFunOrganizationExample();
		example2.createCriteria().andPidEqualTo(param.getOrganizationId()).andDelFlagEqualTo((byte)0);
		example2.setShardCityId(param.getCityId());
		List<ErpFunOrganization> listP = erpFunOrganizationMapper.selectByExample(example2);
		if(listP != null && listP.size() > 0) {
			throw new BusinessException("检测到此部门下还有下级部门存在，不能删除！");
		}
		//删掉FUN_ORGANIZATION_MANAGER里的对应记录
		ErpFunOrganizationManagerExample deleteOrganizaitonManagerExample = new ErpFunOrganizationManagerExample();
		deleteOrganizaitonManagerExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId()).andCompIdEqualTo(param.getCompId());
		deleteOrganizaitonManagerExample.setShardCityId(param.getCityId());
		erpFunOrganizationManagerMapper.deleteByExample(deleteOrganizaitonManagerExample);
		//删除FUN_USER_MANAGE_RANGE表里的对应记录
		ErpFunUserManageRangeExample deleteUserManageRangeExample = new ErpFunUserManageRangeExample();
		deleteUserManageRangeExample.createCriteria().andRangeIdEqualTo(param.getOrganizationId()).andManageTypeEqualTo((byte)2).andCompIdEqualTo(param.getCompId());
		deleteUserManageRangeExample.setShardCityId(param.getCityId());
		erpFunUserManageRangeMapper.deleteByExample(deleteUserManageRangeExample);

		ErpFunOrganization deleOrg = new ErpFunOrganization();
		deleOrg.setDelFlag((byte)1);
		deleOrg.setUpdateTime(new Date());
		ErpFunOrganizationExample example3 = new ErpFunOrganizationExample();
		example3.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId());
		example3.setShardCityId(param.getCityId());
		int count = erpFunOrganizationMapper.updateByExampleSelective(deleOrg, example3);
		if(count != 1) {
			throw new BusinessException("删除失败，请退出稍后重试。");
		}
		String content = "删除了 " + listOrg.get(0).getOrganizationName();
		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.DELETE_ORGANIZATION, null, null, content, null,
				null, param.getCityId(), listOrg.get(0).getCompId(), null, param.getUserId());
		
		return null;
	}

	/**
	 * 添加申请修改父级组织id——PID
	 */
	@Override
	public Integer insertUpdatePidApplyInfo(MoveOrganizationParam param) {
		if(param.getOrganizationId() != null && param.getOldPid() != null && param.getNewPid() != null) {
			ErpFunUpdatePidApply apply = new ErpFunUpdatePidApply();
			apply.setShardCityId(param.getCityId());
			apply.setOrganizationId(param.getOrganizationId());
			apply.setCompId(param.getCompId());
			apply.setOldPid(param.getOldPid());
			apply.setNewPid(param.getNewPid());
			apply.setCreationTime(new Date());
			apply.setUserId(param.getUserId());
			apply.setDealFlag((byte)0);
			apply.setCityId(param.getCityId());
			int count = erpFunUpdatePidApplyMapper.insertSelective(apply);//erpFunOrganizationMapper.insertUpdatePidApplyInfo(apply);
			if(count != 1) {
				throw new BusinessException("申请修改部门归属发起失败");
			}
		}
		return null;
	}


	/**
	 * 组织架构改版拼装insertSQL
	 * @param cityId
	 * @param compId
	 * @return
	 */
	@Override
	public InsertSqlVO createInsertSql(Integer cityId, Integer compId, String orgPath){
		InsertSqlVO insertSqlVO = new InsertSqlVO();

		//查询所有的组织和层级
		Map<Integer, OrganizationDic> organizationMapper = erpFunOrganizationMapper.selectOrganizationMap(cityId,compId);
		if(null == organizationMapper || organizationMapper.size() < 1){
			return insertSqlVO;
		}

		//根据缓存里面的组织ID拼装出SQL
		String[] split = orgPath.split(":");
		String dbFieldPath = "";
		String orgIds = "";
		for( String orgId : split){
			OrganizationDic organization = organizationMapper.get(StringUtil.parseInteger(orgId));
			if(null != organization){
				dbFieldPath += organization.getDbFieldPath() + ",";
				orgIds += organization.getOrgId() + ",";
			}
		}

		if(StringUtil.isNotEmpty(dbFieldPath) && StringUtil.isNotEmpty(orgIds)){
			insertSqlVO.setDbFieldPath(dbFieldPath.substring(0,dbFieldPath.length() - 1));
			insertSqlVO.setOrgIds(orgIds.substring(0,orgIds.length() - 1));
			return insertSqlVO;
		} else {
			return insertSqlVO;
		}

	}

	/**
	* 组织机构UpdateSql
	* @author zangtie
	* @since 2019/12/8 15:24
	* @return
	**/
	@Override
	public String createUpdateSql(Integer cityId, Integer compId,String path){
		String updatePath = "";
		if(null == cityId || null == compId){
			return updatePath;
		}
//		//根据系统参数判断是不是新组织架构
//		ErpSysPara para = new ErpSysPara();
//		para.setShardCityId(cityId);
//		para.setCompId(compId);
//		para.setParamId("ORGANIZATION_TYPE");
//		ErpSysPara erpSysPara = erpSysParaMapper.selectByPrimaryKey(para);
//		if(null == erpSysPara || StringUtil.isEmpty(erpSysPara.getParamValue()) || !"1".equals(erpSysPara.getParamValue())){
//			return updatePath;
//		}
		//查询所有的组织和层级
		Map<Integer, OrganizationDic> organizationMap = erpFunOrganizationMapper.selectOrganizationMap(cityId,compId);
		if(null == organizationMap || organizationMap.size() < 1){
			return updatePath;
		}
		//根据缓存里面的组织ID拼装出SQL
//		String path = ":204923:204924:204925:204927:204928:";
		String[] split = path.split(":");
		for( String orgId : split){
			OrganizationDic organization = organizationMap.get(StringUtil.parseInteger(orgId));
			if(null != organization){
				updatePath += organization.getDbFieldPath() + " = " + organization.getOrgId() + ",";
			}
		}
		if(StringUtil.isNotEmpty(updatePath)){
			updatePath = updatePath.substring(0,updatePath.length() - 1);
		}
		return updatePath;
	}

	/**
	 *
	 * 获取组织架构查询WHERE 条件
	 * @author L.X.T
	 * @since 2019-11-23 14:51:13
	 * @param param
	 * @return
	 */
	@ApiOperation(value = "获取组织架构查询WHERE 条件")
	@ApiResponses(value = {@ApiResponse(code = 1, message = "", response = AdminIpCallLog.class)})
	@PostMapping("/getSelectWhereTwo")
	public String getSelectWhereTwo(@RequestBody GetSelectWhereParam param) {
		String rangeColumn = "";//如果没有查询到组织就默认是公司
		String prefix = StringUtil.isNotEmpty(param.getPrefix()) ? param.getPrefix() : "";
		if (null != param.getUserId() && param.getUserId() > 0){
			rangeColumn = param.getFileName() + " = " + param.getUserId();
			if(param.getChange()){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getUserId());
				if (erpFunUsers!=null) {
					rangeColumn = param.getFileName() + " = " + erpFunUsers.getArchiveId();
				} else {
					throw new BusinessException("此员工不存在！");
				}
			}
		}
		//当前组织
		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(param.getCityId());
		erpFunOrganizationExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId()).andDelFlagEqualTo((byte) 0);
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOneByExample(erpFunOrganizationExample);
		if (erpFunOrganization != null && null != erpFunOrganization.getOrganizationDefinitionId()) {
			//当前组织层级
			ErpFunOrganizationDefinition definition = new ErpFunOrganizationDefinition();
			definition.setShardCityId(param.getCityId());
			definition.setDefinitionId(erpFunOrganization.getOrganizationDefinitionId());
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(definition);
			if(null != erpFunOrganizationDefinition && StringUtil.isNotEmpty(erpFunOrganizationDefinition.getMappingDbField())){
				if(StringUtil.isNotEmpty(rangeColumn)){
					rangeColumn += " AND "+ prefix + erpFunOrganizationDefinition.getMappingDbField();//AND前后空格不能动
				} else {
					rangeColumn = erpFunOrganizationDefinition.getMappingDbField();
				}
			}
		} else {
			if(StringUtil.isNotEmpty(rangeColumn)){
				rangeColumn += " AND "+ prefix + "COMP_ID";//AND前后空格不能动
			} else {
				rangeColumn = "COMP_ID";
			}
		}
		return rangeColumn;
	}


	/**
	 *
	 * 获取组织架构查询WHERE 条件
	 * @author L.X.T
	 * @since 2019-11-23 14:51:13
	 * @param param
	 * @return
	 */
	@Override
	public String getSelectWhere(GetSelectWhereParam param) {
		String rangeColumn = "";//如果没有查询到组织就默认是公司
		String prefix = StringUtil.isEmpty(param.getPrefix()) ? "" : param.getPrefix();
		if (null != param.getUserId() && param.getUserId() > 0){
			rangeColumn = prefix + param.getFileName() + " = " + param.getUserId();
			if(param.getChange()){
				ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(param.getCityId(), param.getUserId());
				if (erpFunUsers!=null) {
					rangeColumn = prefix + param.getFileName() + " = " + erpFunUsers.getArchiveId();
				} else {
					throw new BusinessException("此员工不存在！");
				}
			}
		}
		//当前组织
		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(param.getCityId());
		erpFunOrganizationExample.createCriteria().andOrganizationIdEqualTo(param.getOrganizationId()).andDelFlagEqualTo((byte) 0).andCityIdEqualTo(param.getCityId());
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOneByExample(erpFunOrganizationExample);
		if (erpFunOrganization != null && null != erpFunOrganization.getOrganizationDefinitionId()) {
			//当前组织层级
			ErpFunOrganizationDefinition definition = new ErpFunOrganizationDefinition();
			definition.setShardCityId(param.getCityId());
			definition.setDefinitionId(erpFunOrganization.getOrganizationDefinitionId());
			ErpFunOrganizationDefinition erpFunOrganizationDefinition = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(definition);
			if(null != erpFunOrganizationDefinition && StringUtil.isNotEmpty(erpFunOrganizationDefinition.getMappingDbField())){
				if(StringUtil.isNotEmpty(rangeColumn)){
					rangeColumn += " AND " + prefix + erpFunOrganizationDefinition.getMappingDbField();
				} else {
					rangeColumn = prefix + erpFunOrganizationDefinition.getMappingDbField();
				}
			}
		} else {
			rangeColumn = prefix + "COMP_ID";
		}
		return rangeColumn;
	}

	@Override
	public String getSelectSql(@RequestBody String selectSql,String petName, String prefix) {
		String sqlOne = "";
		String sqlTwo = "";
		if(StringUtil.isNotEmpty(selectSql)){
			String[] split = selectSql.split(",");
			if(StringUtil.isNotEmpty(petName)){
				if("0".equals(petName)){
					sqlOne = "isnull(" +"COMP_ID,0),";
					for (String name : split) {
						sqlOne += "isnull(" + name +",0),";
						sqlTwo += "convert(varchar,isnull(" + name +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+")";
				}
			} else {//"a.COMP_ID AS compId,a.AREA_ID AS areaId,a.REG_ID AS regId,a.DEPT_ID AS deptId,a.GR_ID AS grId
				for (String name : split) {
					sqlOne += "isnull(" + name +",0) "+this.processingFormat(name)+",";
					sqlTwo += "convert(varchar,isnull(" + name +",0))+'_'+";
				}
				//去掉后缀和加上括号
				sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+") as range";
			}
			
			if(StringUtil.isNotEmpty(prefix)){
				sqlOne = prefix+"."+selectSql.replaceAll("\\,", ","+prefix+".");
			}
		}
		return sqlOne + sqlTwo;
	}


	/**
	 *
	 * 拼装查询SQL
	 * @author L.X.T
	 * @since 2019-11-23 14:51:13
	 * @selectSql  查询参数，格式：name1,name2,name3,name4
	 * @petNmae  是否需要别名，GROUP BY 就不需要，一般GROUP BY就传0
	 *  拼装后格式为："isnull(NAME_NAME1,0) nameName1,isnull(NAME_NAME2,0) name2,(convert(varchar,isnull(NAME_NAME1,0))+'_'+convert(varchar,isnull(NAME_NAME2,0))) as range"
	 *  不需要别名格式："isnull(NAME_NAME1,0),isnull(NAME_NAME2,0),(convert(varchar,isnull(NAME_NAME1,0))+'_'+convert(varchar,isnull(NAME_NAME2,0)))
	 * @return
	 */
	@Override
	public String getSelectSqlTwo(@RequestBody String selectSql,String petName,String table) {
		String sqlOne = "";
		String sqlTwo = "";
		if(StringUtil.isNotEmpty(selectSql)){
			String[] split = selectSql.split(",");
			String tableName = StringUtil.isNotEmpty(table) ? table + "." : "";
			if(StringUtil.isNotEmpty(petName)){
				if ("0".equals(petName)){		//大写没有别名，前面会加上COMP_ID，一般用于GROUP BY :isnull(COMP_ID,0),isnull(NAME_NAME2,0),(convert(varchar,isnull(NAME_NAME1,0))+'_'+convert(varchar,isnull(NAME_NAME2,0)))
					sqlOne = "isnull("+ tableName +"COMP_ID,0),";
					for (String name : split) {
						sqlOne += "isnull("+ tableName + name +",0),";
						sqlTwo += "convert(varchar,isnull("+ tableName + name +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+")";
				} else if ("1".equals(petName)){//小写带别名 ："isnull(areaId,0) areaId,isnull(regId,0) regId,(convert(varchar,isnull(areaId,0))+'_'+convert(varchar,isnull(regId,0))) as range"
					for (String name : split) {
						sqlOne += "isnull("+ this.processingFormat(name) +",0) "+this.processingFormat(name)+",";
						sqlTwo += "convert(varchar,isnull("+ this.processingFormat(name) +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+") as range";
				} else if ("3".equals(petName)){//小写不带别名没有COMP_ID："isnull(areaId,0),isnull(regId,0),isnull(deptId,0),(convert(varchar,isnull(areaId,0))+'_'+convert(varchar,isnull(regId,0))+'_'+convert(varchar,isnull(deptId,0)))"
					for (String name : split) {
						sqlOne += "isnull("+ this.processingFormat(name) +",0),";
						sqlTwo += "convert(varchar,isnull("+ this.processingFormat(name) +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+")";
				} else if ("4".equals(petName)){//大写带别名最后没有range："COMP_ID compId,AREA_ID areaId,REG_ID regId,DEPT_ID deptId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)"
					for (String name : split) {
						sqlOne += name + " " +this.processingFormat(name)+",";
						sqlTwo += "convert(varchar,isnull("+ name +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+")";
				} else if ("5".equals(petName)){//大写不带别名最后没有range："COMP_ID compId,AREA_ID areaId,REG_ID regId,DEPT_ID deptId,CONCAT(AREA_ID,'_',REG_ID,'_',DEPT_ID)"
					sqlOne = "isnull("+ tableName +"COMP_ID,0),";
					for (String name : split) {
						sqlOne += name + ",";
						sqlTwo += "convert(varchar,isnull("+ name +",0))+'_'+";
					}
					//去掉后缀和加上括号
					sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+")";
				}
			} else {//"isnull(NAME_NAME1,0) nameName1,isnull(NAME_NAME2,0) name2,(convert(varchar,isnull(NAME_NAME1,0))+'_'+convert(varchar,isnull(NAME_NAME2,0))) as range"

				for (String name : split) {
					sqlOne += "isnull("+ tableName + name +",0) "+this.processingFormat(name)+",";
					sqlTwo += "convert(varchar,isnull("+ tableName + name +",0))+'_'+";
				}
				//去掉后缀和加上括号
				sqlTwo = "("+sqlTwo.substring(0,sqlTwo.length() - 5)+") as range";
			}
		}
		return sqlOne + sqlTwo;
	}

	@Override
	@Transactional
	public void updateFieldStaff(Integer cityId,Integer userId,Integer organizationId,Integer compId) {

		AgencyPropertyRelatedPersonExample agencyPropertyRelatedPersonExample = new AgencyPropertyRelatedPersonExample();
		agencyPropertyRelatedPersonExample.createCriteria().andUserIdEqualTo(userId);
		//查询所有驻场数据
		List<AgencyPropertyRelatedPerson> agencyPropertyRelatedPersonList = agencyPropertyRelatedPersonMapper.selectByExample(agencyPropertyRelatedPersonExample);
		AgencyPropertyRelatedPerson agencyPropertyRelatedPerson = new AgencyPropertyRelatedPerson();
		agencyPropertyRelatedPerson.setPersonType((byte)0);
		agencyPropertyRelatedPerson.setDelTime(new Date());
		agencyPropertyRelatedPerson.setStatus((byte)2);
		//更新为历史驻场人员
		agencyPropertyRelatedPersonMapper.updateByExampleSelective(agencyPropertyRelatedPerson,agencyPropertyRelatedPersonExample);
		if(organizationId == null){
		    return;
		}
		ErpFunOrganizationManagerExample erpFunOrganizationManagerExample = new ErpFunOrganizationManagerExample();
		erpFunOrganizationManagerExample.setShardCityId(cityId);
		erpFunOrganizationManagerExample.createCriteria().andOrganizationIdEqualTo(organizationId).andCompIdEqualTo(compId);
		List<ErpFunOrganizationManager> list = erpFunOrganizationManagerMapper.selectByExample(erpFunOrganizationManagerExample);
		if(list.isEmpty()){
		    return;
		}
		//查询上级组织
		ErpFunOrganizationManager erpFunOrganizationManager = list.get(0);
		Integer managerUserId = erpFunOrganizationManager.getUserId();
		Integer managerCompId = erpFunOrganizationManager.getCompId();
		ErpFunUsers funUsersSel = erpFunUsersMapper.selectDataByUserId(cityId, managerCompId,managerUserId);
		if (funUsersSel == null) {
			return;
		}
		//查询上级组织名称
		ErpFunOrganizationExample erpFunOrganizationExample = new ErpFunOrganizationExample();
		erpFunOrganizationExample.setShardCityId(cityId);
		erpFunOrganizationExample.createCriteria().andCompIdEqualTo(compId).andOrganizationIdEqualTo(erpFunOrganizationManager.getOrganizationId()).andDelFlagEqualTo((byte)0);
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOneByExample(erpFunOrganizationExample);
		if (erpFunOrganization == null) {
			return;
		}
		ErpUserOpers mlNewprojectAdd = erpUserOpersMapper.selectPerPermissionByName(cityId, funUsersSel.getUserId(), "ML_NEWPROJECT_ADD");
		if(mlNewprojectAdd == null){
			ErpUserOpers erpUserOpers = new ErpUserOpers();
			erpUserOpers.setShardCityId(cityId);
			erpUserOpers.setUserId(funUsersSel.getUserId());
			erpUserOpers.setOperId("ML_NEWPROJECT_ADD");
			erpUserOpers.setOrganizationDefinitionId(erpFunOrganization.getOrganizationId());
			erpUserOpersMapper.insertSelective(erpUserOpers);
		}
		for (AgencyPropertyRelatedPerson propertyRelatedPerson : agencyPropertyRelatedPersonList) {
			AgencyPropertyRelatedPerson relatedPerson = new AgencyPropertyRelatedPerson();
			relatedPerson.setCooperationId(propertyRelatedPerson.getCooperationId());
			relatedPerson.setAgentId(propertyRelatedPerson.getAgentId());
			relatedPerson.setPersonType(propertyRelatedPerson.getPersonType());
			relatedPerson.setUserMobile(funUsersSel.getUserMobile());
			relatedPerson.setOrgId(erpFunOrganization.getOrganizationId());
			relatedPerson.setOrgName(erpFunOrganization.getOrganizationName());
			relatedPerson.setResponsibilityPeriodBegin(propertyRelatedPerson.getResponsibilityPeriodBegin());
			relatedPerson.setResponsibilityPeriodEnd(propertyRelatedPerson.getResponsibilityPeriodEnd());
			relatedPerson.setCreateTime(new Date());
			relatedPerson.setUserId(funUsersSel.getUserId());
			relatedPerson.setUserName(funUsersSel.getUserName());
			agencyPropertyRelatedPersonMapper.insertSelective(relatedPerson);
		}

	}


	public String processingFormat(String name){
		name = name.toLowerCase();
		// 需要对比的字符串
		String compareStr = "_";
		//字符串查找初始从0开始查找
		int indexStart = 0;
		//获取查找字符串的长度，这里有个规律：第二次查找出字符串的起始位置等于 第一次ab字符串出现的位置+ab的长度
		int compareStrLength = compareStr.length();
		while(true){
			int tm = name.indexOf(compareStr,indexStart);
			if( tm >= 0){
				String replace = name.substring(tm + 1,tm +2);
				replace = replace.toUpperCase();
				String beReplace = name.substring(tm,tm +2);
				name = name.replaceAll(beReplace,replace);
				indexStart = tm+compareStrLength;
			}else{
				//直到没有匹配结果为止
				break;
			}
		}
		return name;
	}

	@Override
	public String getSelectNames(GetSelectNmaesParam param) {
		//1.先默认层级为员工，就查询出所有的组织
		//2.如果参数有defId并且查询出值了，就把查询出来的层级更新到level上，查询小于等于该level的组织(等于就是查询自己和上级所有的组织)
		String groupBy = "";
		if(null != param.getDefId()){
			ErpFunOrganizationDefinition select = new ErpFunOrganizationDefinition();
			select.setShardCityId(param.getCityId());
			select.setDefinitionId(param.getDefId());
			ErpFunOrganizationDefinition organization = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(select);
			if(null != organization && null != organization.getDefinitionLevel()){
				param.setLevel(organization.getDefinitionLevel());
			}
		}
		List<String> definitionNames = erpFunOrganizationDefinitionMapper.selectDefinitionNameByLevel(param.getCityId(),param);
		for (String name : definitionNames) {
			groupBy += name + ",";
		}
		if(null != param.getDefId() && "-2".equals(param.getDefId().toString())){
			//  -2就是查员工，默认加上USER_ID(param里面默认值)；但是因为不是所有表存的员工ID都是USER_ID，所以在调用的地方也可以动态把代表人员ID的字段名传进来加上去
			groupBy += param.getSelectName();
		} else if (StringUtil.isNotEmpty(groupBy)){
			groupBy = groupBy.substring(0,groupBy.length() - 1);
		}
		if(param.getHasGroupAll() == 1){
			//groupBy = groupBy + ",CONCAT("+groupBy.replaceAll("\\,",",\\'_\\',")+")";
		}
		return groupBy;
	}

	@Override
	public String getConcatNames(String columnNames) {
		if (StringUtil.isEmpty(columnNames)) {
			return "";
		}
		if (columnNames.indexOf("\\,") < 0) {
			return "";
		}
		columnNames = ",CONCAT("+columnNames.replaceAll("\\,",",\\'_\\',")+")";
		return columnNames;
	}

	@Override
	@Transactional
	public Integer saveOrganizationDefinitionInfo(SaveLevelDefinitionListParam listParam) {
		if (null == listParam || null == listParam.getSaveLevelDefinitionParamList()) {
			throw new BusinessException("层级数据收集失败，请退出稍后重试，或联系在线客服");
		}
		List<SaveLevelDefinitionParam> list = listParam.getSaveLevelDefinitionParamList();
		if(list.size() > 14) {
			throw new BusinessException("层级数据不合法");
		}
		/*//根据数据库已存在的层级数量 加上本次要新增的层级数量，判断是否超过14限制
		List<OrganizationDefinitionVO> erpFunOrganizationDefinitionList = erpFunOrganizationDefinitionMapper.getAllOrganizationDefinitionList(listParam.getCityId(), listParam.getCompId());
		if (!erpFunOrganizationDefinitionList.isEmpty() && erpFunOrganizationDefinitionList.size() > 0) {
			int tempi = 0;
			for (SaveLevelDefinitionParam param : list) {
				if (null == param.getDefinitionId()) {
					tempi ++;
				}
			}
			if (erpFunOrganizationDefinitionList.size() + tempi > 14) {
				throw new BusinessException("层级数据不合法");
			}
		}*/
		
		for (SaveLevelDefinitionParam param : list) {
			if (null == param.getDefinitionId()) {//新建
				if(StringUtil.isBlank(param.getDefinitionName().trim()) || param.getDefinitionName().length() > 10) {
					throw new BusinessException("【" + param.getDefinitionName() + "】层级定义名不合法");
				}
				//名称判重由前端处理
				/*ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
				erpFunOrganizationDefinitionExample.createCriteria().andCompIdEqualTo(listParam.getCompId()).andDelFlagEqualTo((byte)0).andDefinitionLevelEqualTo(param.getDefinitionLevel());
				erpFunOrganizationDefinitionExample.setShardCityId(listParam.getCityId());
				List<ErpFunOrganizationDefinition> selectErpFunOrganizationDefinitions = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
				//如果有，代表是从中间位置插入的层级，...获取并修改当前层级及其后边的所有层级：+1
				if(null != selectErpFunOrganizationDefinitions && selectErpFunOrganizationDefinitions.size() > 0) {
					ErpFunOrganizationDefinitionExample allLastLevelExample = new ErpFunOrganizationDefinitionExample();
					allLastLevelExample.createCriteria().andCompIdEqualTo(listParam.getCompId()).andDelFlagEqualTo((byte)0).andDefinitionLevelBetween(param.getDefinitionLevel(), 14);
					allLastLevelExample.setOrderByClause(" DEFINITION_LEVEL ");
					allLastLevelExample.setShardCityId(listParam.getCityId());
					List<ErpFunOrganizationDefinition> listDefinition = erpFunOrganizationDefinitionMapper.selectByExample(allLastLevelExample);
				
					int tempLevel = param.getDefinitionLevel(); //检查中间是否有断层
					for (ErpFunOrganizationDefinition d : listDefinition) {
						ErpFunOrganizationDefinition updateDefinition = new ErpFunOrganizationDefinition();
						if(tempLevel == d.getDefinitionLevel()) {
							updateDefinition.setDefinitionId(d.getDefinitionId());
							updateDefinition.setDefinitionLevel(d.getDefinitionLevel() + 1);
							updateDefinition.setShardCityId(listParam.getCityId());
							erpFunOrganizationDefinitionMapper.updateByPrimaryKeySelective(updateDefinition);
							tempLevel ++;
						}
					}
				}*/
				//如果没有，获取最后一个层级的MAPPING_DB_FIELD：ORG+1；然后直接插入
				ErpFunOrganizationDefinitionExample allLevelExample = new ErpFunOrganizationDefinitionExample();
				allLevelExample.createCriteria().andCompIdEqualTo(listParam.getCompId()).andDelFlagEqualTo((byte)0);
				allLevelExample.setShardCityId(listParam.getCityId());
				List<ErpFunOrganizationDefinition> allDefinitionByComp = erpFunOrganizationDefinitionMapper.selectByExample(allLevelExample);
				int orgX = 1;
				int level = 1;
				if(null != allDefinitionByComp && allDefinitionByComp.size() > 0) {
					for (ErpFunOrganizationDefinition ad : allDefinitionByComp) {
						int orgY = Integer.parseInt(ad.getMappingDbField().substring(ad.getMappingDbField().indexOf("_")+1));
						if(orgY >= orgX) {
							orgX = orgY;
						}
						if(ad.getDefinitionLevel() > level) {
							level = ad.getDefinitionLevel();
						}
					}
					orgX ++;
					level ++;
				}
				
				ErpFunOrganizationDefinition insertDefinitionLevel = new ErpFunOrganizationDefinition();
				insertDefinitionLevel.setCompId(listParam.getCompId());
				insertDefinitionLevel.setDefinitionName(param.getDefinitionName());
				insertDefinitionLevel.setDefinitionLevel(level);
				insertDefinitionLevel.setMappingDbField("ORG_" + orgX);
				insertDefinitionLevel.setCreationTime(new Date());
				insertDefinitionLevel.setDelFlag((byte)0);
				insertDefinitionLevel.setShardCityId(listParam.getCityId());
				erpFunOrganizationDefinitionMapper.insertSelective(insertDefinitionLevel);

				String content = "创建了业务层级定义 " + param.getDefinitionName();
				erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.CREATE_LEVEL_DEFINITION, null, null, content, null,
						null, listParam.getCityId(), listParam.getCompId(), null, listParam.getOperatorUserId());
				
			} else if (null != param.getDefinitionId() && null != param.getUpdateType()) { //编辑  删除
				if(param.getUpdateType() == 2) {//编辑
					if(StringUtil.isBlank(param.getDefinitionName().trim()) || param.getDefinitionName().length() > 10 ) {
						throw new BusinessException("【" + param.getDefinitionName() + "】层级定义名不合法");
					}
					//根据defId获取对应信息
					/*ErpFunOrganizationDefinitionExample selectNameExample = new ErpFunOrganizationDefinitionExample();
					selectNameExample.createCriteria().andCompIdEqualTo(listParam.getCompId()).andDefinitionIdEqualTo(param.getDefinitionId());
					selectNameExample.setShardCityId(listParam.getCityId());
					List<ErpFunOrganizationDefinition> selectName = erpFunOrganizationDefinitionMapper.selectByExample(selectNameExample);*/
					//名称判重由前端处理
					//业务层级排序——暂不支持修改
					/*if(selectName.get(0).getDefinitionLevel() != param.getDefinitionLevel()) {
						ErpFunOrganizationDefinitionExample erpFunOrganizationDefinitionExample = new ErpFunOrganizationDefinitionExample();
						erpFunOrganizationDefinitionExample.createCriteria().andCompIdEqualTo(param.getCompId()).andDelFlagEqualTo((byte)0).andDefinitionLevelEqualTo(param.getDefinitionLevel());
						erpFunOrganizationDefinitionExample.setShardCityId(param.getCityId());
						List<ErpFunOrganizationDefinition> selectErpFunOrganizationDefinitions = erpFunOrganizationDefinitionMapper.selectByExample(erpFunOrganizationDefinitionExample);
						//如果有，代表是从中间位置插入的层级，...获取并修改当前层级及其后边的所有层级：+1
						if(null != selectErpFunOrganizationDefinitions && selectErpFunOrganizationDefinitions.size() > 0) {
							ErpFunOrganizationDefinitionExample allLastLevelExample = new ErpFunOrganizationDefinitionExample();
							allLastLevelExample.createCriteria().andCompIdEqualTo(param.getCompId()).andDelFlagEqualTo((byte)0).andDefinitionLevelBetween(param.getDefinitionLevel(), 14);
							allLastLevelExample.setOrderByClause(" DEFINITION_LEVEL ");
							allLastLevelExample.setShardCityId(param.getCityId());
							List<ErpFunOrganizationDefinition> listDefinition = erpFunOrganizationDefinitionMapper.selectByExample(allLastLevelExample);
							
							int tempLevel = param.getDefinitionLevel(); //检查中间是否有断层
							for (ErpFunOrganizationDefinition d : listDefinition) {
								ErpFunOrganizationDefinition updateDefinition = new ErpFunOrganizationDefinition();
								if(tempLevel == d.getDefinitionLevel()) {
									updateDefinition.setDefinitionId(d.getDefinitionId());
									updateDefinition.setDefinitionLevel(d.getDefinitionLevel() + 1);
									updateDefinition.setShardCityId(param.getCityId());
									erpFunOrganizationDefinitionMapper.updateByPrimaryKeySelective(updateDefinition);
									tempLevel ++;
								} else {
									break;
								}
							}
						}
					}*/
					//如果没有，然后直接更新
					ErpFunOrganizationDefinition updateDefinition = new ErpFunOrganizationDefinition();
					updateDefinition.setDefinitionId(param.getDefinitionId());
					updateDefinition.setDefinitionName(param.getDefinitionName());
					updateDefinition.setDelFlag((byte)0);
					//updateDefinition.setDefinitionLevel(param.getDefinitionLevel());
					updateDefinition.setUpdateTime(new Date());
					updateDefinition.setShardCityId(listParam.getCityId());
					erpFunOrganizationDefinitionMapper.updateByPrimaryKeySelective(updateDefinition);

					String content = "编辑了业务层级定义 " + param.getDefinitionName();
					erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.UPDATE_LEVEL_DEFINITION, null, null, content, null,
							null, listParam.getCityId(), listParam.getCompId(), null, listParam.getOperatorUserId());
				} else if(param.getUpdateType() == 1) {//删除
					ErpFunOrganizationDefinition selectDefinition = new ErpFunOrganizationDefinition();
					selectDefinition.setDefinitionId(param.getDefinitionId());
					selectDefinition.setShardCityId(listParam.getCityId());
					ErpFunOrganizationDefinition definition = erpFunOrganizationDefinitionMapper.selectByPrimaryKey(selectDefinition);
					if(null == definition) {
						throw new BusinessException("未能找到要停用的架构定义【" + param.getDefinitionName() + "】，请退出稍后重试");
					}
					
					ErpFunOrganizationExample selectOrganizationExample = new ErpFunOrganizationExample();
					selectOrganizationExample.createCriteria().andOrganizationDefinitionIdEqualTo(param.getDefinitionId()).andCompIdEqualTo(definition.getCompId()).andDelFlagEqualTo((byte)0);
					selectOrganizationExample.setShardCityId(listParam.getCityId());
					List<ErpFunOrganization> listOrg = erpFunOrganizationMapper.selectByExample(selectOrganizationExample);
					if (null != listOrg && listOrg.size() > 0) {
						throw new BusinessException("【" + definition.getDefinitionName() + "】架构定义已经使用，请调整后再停用");
					}
					ErpUserOpersExample selectUserOpersExample = new ErpUserOpersExample();
					selectUserOpersExample.createCriteria().andOrganizationDefinitionIdEqualTo(param.getDefinitionId());
					selectUserOpersExample.setShardCityId(listParam.getCityId());
					List<ErpUserOpers> listUserOpers = erpUserOpersMapper.selectByExample(selectUserOpersExample);
					if (!listUserOpers.isEmpty() && listUserOpers.size() > 0) {
						throw new BusinessException("【" + definition.getDefinitionName() + "】架构定义已经使用，请调整后再停用");
					}
					
					ErpFunOrganizationDefinition deleteDefinition = new ErpFunOrganizationDefinition();
					deleteDefinition.setDelFlag((byte)1);
					deleteDefinition.setUpdateTime(new Date());
					ErpFunOrganizationDefinitionExample updateDefinitionExample = new ErpFunOrganizationDefinitionExample();
					updateDefinitionExample.createCriteria().andDefinitionIdEqualTo(param.getDefinitionId());
					updateDefinitionExample.setShardCityId(listParam.getCityId());
					int count = erpFunOrganizationDefinitionMapper.updateByExampleSelective(deleteDefinition, updateDefinitionExample);
					if(count != 1) {
						throw new BusinessException("【" + definition.getDefinitionName() + "】架构定义停用失败，请退出稍后重试。");
					}
					
					String content = "停用了业务层级定义 " + definition.getDefinitionName();
					erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.DELETE_LEVEL_DEFINITION, null, null, content, null,
							null, listParam.getCityId(), definition.getCompId(), null, listParam.getOperatorUserId());
				}
			}
		}
		return null;
	}

	
	@Override
	@Transactional
	public MoveOrganizationServiceVO moveOrganization(Integer cityId, Integer compId, Integer userId, 
														Integer organizationId, Integer oldPid,
													  Integer newPid) {
		MoveOrganizationServiceVO moveOrganizationServiceVO = new MoveOrganizationServiceVO();
		ErpFunComp funComp = erpFunCompMapper.selectByCompId(cityId, compId);
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, userId);
		Calendar calendar = Calendar.getInstance();
		String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		//1.先查询出来要更新的组织id,更新partnerId
		String replaceNewPrefix =":";
		String replaceOldPrefix ="";
		Integer partnerId = -1;
		Integer moveOrgId = null;
		String newOrgName ="公司";
		Set<Integer> orgIds = new HashSet<>();
		if (organizationId != null && organizationId > 0) {
			orgIds.add(organizationId);
		}
		if (newPid!=null && newPid>0) {
			orgIds.add(newPid);
		}
		if (oldPid!=null && oldPid>0) {
			orgIds.add(oldPid);
		}
		//List<ErpOrganizationVO> orgList = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, orgIds);
		List<OrganizationVO> compOrgList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, null);
		Map<Integer,OrganizationVO> orgMap = compOrgList.stream().collect(Collectors.toMap(OrganizationVO::getOrganizationId,org->org));
		OrganizationVO moveOrgInfo = orgMap.get(organizationId);
		if (newPid != null && newPid > 0) {
			OrganizationVO orgInfo = orgMap.get(newPid);
			if (Byte.valueOf("1").equals(orgInfo.getDelFlag())) {
				throw new BusinessException("新的上级组织已经被删除！请重新登录确认信息！");
			}
			if (orgInfo!=null) {
				partnerId = orgInfo.getPartnerId();
				replaceNewPrefix = orgInfo.getOrganizationPath();
				OrganizationVO tempMoveOrg = orgMap.get(organizationId);
				if (tempMoveOrg.getDefinitionLevel().compareTo(orgInfo.getDefinitionLevel()) <= 0) {
					throw new BusinessException("上级组织的层级不能小于等于下级的层级！");
				}
			} 
		}
		
		if (oldPid!=null && oldPid>0) {
			//如果老的上级存在，则把老的path替换成新上级的path ，如果新的上级是0，则把当前上级的path替换成：
			OrganizationVO orgInfo = orgMap.get(oldPid);
			if (orgInfo!=null) {
				replaceOldPrefix = orgInfo.getOrganizationPath();
			}
		} else if (organizationId != null && organizationId > 0) {
			//如果原来是一级部门，则新的不会是一级部门，这样把老的路径，替换成新的上级拼上当前组织替换掉中间两个:替换为一个：
			OrganizationVO orgInfo = orgMap.get(organizationId);
			if (orgInfo != null) {
				replaceOldPrefix = orgInfo.getOrganizationPath();
				OrganizationVO newOrgInfo = orgMap.get(newPid);
				replaceNewPrefix = (newOrgInfo.getOrganizationPath()+replaceOldPrefix).replaceAll("::", ":");
			}
		}
		
		Byte bussinessType = Byte.valueOf("0");
		//房客源上的INFO_TYPE不能为null
		if(newPid > 0){//获取最新组织的业务类型ID
			OrganizationVO orgInfo = orgMap.get(newPid);
			if (orgInfo != null) {
				bussinessType = Optional.ofNullable(orgInfo.getOrganizationBussinessType()).orElse(Byte.valueOf("0"));
			}
		}else if(newPid == 0 && organizationId > 0){
			OrganizationVO orgInfo = orgMap.get(organizationId);
			if (orgInfo != null) {
				bussinessType = Optional.ofNullable(orgInfo.getOrganizationBussinessType()).orElse(Byte.valueOf("0"));
			}
		}
		Integer newDeptId = createDeptInfo(cityId, compId, funComp.getCompNo(), funComp.getCompType(), newPid, moveOrgInfo.getOrganizationId(), moveOrgInfo);
		this.updateAfterMoveOrgUserNum(cityId, compId, oldPid, organizationId, newPid, moveOrgInfo.getOrganizationUserNum(),compOrgList);
		erpFunOrganizationMapper.updateMoveOrgPath(cityId, compId, newPid, "%:"+organizationId+":%", organizationId, 
													replaceNewPrefix, replaceOldPrefix, partnerId, 
													newDeptId, startTime, endTime, bussinessType);
		//更新现有组织机构上的人数，和原有组织机构上的人数
		//1.先把公司的组织机构查询出来，不然递归查询数据库太恼火了
		//----------------
		//2.拿到新组织和老组织的path，解析path中层级level为4的组织ID拿出来。
		//3.将老组织下所有的人员，包括老组织下的组织的人员，都查出archiveId，循环调用上面的方法
		//4.然后查询出影响到的老组织线和新组织线，发送JMS验证老组织和新组织的人数

		OrganizationVO organizationNew = orgMap.get(newPid);//有可能是id为0需要判一下空
		OrganizationVO organizationOld = orgMap.get(organizationId);//有可能是id为0需要判一下空
		String newOrgPath = null == organizationNew ? "" : organizationNew.getOrganizationPath();//新组织架构path
		String oldOrgPath = null == organizationOld ? "" : organizationOld.getOrganizationPath();//老组织架构path
		Integer lookNewLevelId = this.lookFourLevelOrgId(orgMap, newOrgPath);
		Integer lookOldLevelId = this.lookFourLevelOrgId(orgMap, oldOrgPath);
		moveOrganizationServiceVO.setLookNewLevelId(lookNewLevelId);//新组织level为4的组织ID
		moveOrganizationServiceVO.setLookOldLevelId(lookOldLevelId);//老组织level为4的组织ID
		//3.
		List<ErpFunUsers> organizationAllUser = erpFunUsersMapper.getOrganizationAllUser(cityId, compId, organizationId);
		moveOrganizationServiceVO.setOrganizationAllUser(organizationAllUser);
		//首先拿到level为4的组织的组织架构线，除去当前组织ID,拿到以上所有的价格ID,发送JMS修改人数
		// 异步执行，发送jms消息修改数据所属
		String movePath =  newOrgPath + oldOrgPath;
		//-----------------
		// 写调店日志
		String logDesc = erpFunUsers.getUserName() + " 将组织  "+ moveOrgInfo.getOrganizationName() +" 调到  " + newOrgName +"下";
		ErpFunLogs erpFunLogs = new ErpFunLogs();
		erpFunLogs.setCompId(compId);
		erpFunLogs.setCityId(cityId);
		erpFunLogs.setDeptId(erpFunUsers.getDeptId());
		erpFunLogs.setOrganizationPath(erpFunUsers.getTissueLine());
		erpFunLogs.setOperatorId(userId);
		erpFunLogs.setOperatorName(Const.DIC_STAFF_MOVE_ORGANIZATION);
		erpFunLogs.setLogtime(DateTimeHelper.formatDateTimetoString(new Date()));
		erpFunLogs.setLogtype(Const.DIC_STAFF_MOVE_TO_ORGANIZATION.toString());
		erpFunLogs.setLogDesc(logDesc);
		erpFunLogs.setShardCityId(cityId);
		erpFunLogsMapper.insertSelective(erpFunLogs);

		erpSystemSettingLogsService.insertSysLog(SystemOperateUtil.SSL_TYPE.CREATE_REGION, null, null, logDesc, null,
				null, cityId, compId, null, userId);
		// 强制退出登录
		erpFunUsersService.endLoginMoveOrgUser(cityId, compId, moveOrgId, LogInEnum.ORGANIZATION_MOVE);
		// 异步执行，发送jms消息修改数据所属
		TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
			@Override
			public void afterCommit() {
				mqPublisher.sendMoveOrgMsg(cityId, compId, moveOrgId,null);
				mqPublisher.UpdateOrgUserNum(cityId, compId,movePath);
			}
		});
		return moveOrganizationServiceVO;
	}
	
	private Integer createDeptInfo (Integer cityId, Integer compId,String compNo, Byte compType,Integer newPid, Integer newOrganizationId, ErpFunOrganization moveOrgInfo) {
		Integer newDeptId = null;
		Date dateNow = new Date();
		if (Integer.valueOf("0").equals(newPid)) {
		String orgNo = moveOrgInfo.getOrganizationNo();
		ErpFunDepts deptInfo = erpFunDeptsMapper.getDeptByDeptNo(cityId,compId,orgNo);
		AdminFunComp adminFunComp = adminFunCompMapper.selectByCompNo(compNo);

		if (deptInfo!=null) {
			newDeptId = deptInfo.getDeptId();
		} else {
			deptInfo = new ErpFunDepts();
			deptInfo.setShardCityId(cityId);
			newDeptId = newOrganizationId; //生成序列
			deptInfo.setDeptId(newDeptId);
			deptInfo.setCompId(compId);
			deptInfo.setCompNo(compNo);
			deptInfo.setDeptNo(moveOrgInfo.getOrganizationNo());
			deptInfo.setDeptName(moveOrgInfo.getOrganizationName());
			deptInfo.setDeptAddr(moveOrgInfo.getOrganizationAddr());
			deptInfo.setDeptCname(moveOrgInfo.getOrganizationName());
			deptInfo.setDeptTele(moveOrgInfo.getContactNumber());
			deptInfo.setDeptType(compType.byteValue());
			deptInfo.setIsUnpaidDept(Byte.valueOf("0"));
			deptInfo.setStatisticsFlag(Byte.valueOf("1"));
			deptInfo.setDeptFlag(1);
			deptInfo.setSupportPropertyFlag(Byte.valueOf("0"));
			deptInfo.setUpdateTime(DateTimeHelper.formatDateTimetoString(dateNow));
			erpFunDeptsMapper.createNewDept(deptInfo);
			ErpFunCity id = new ErpFunCity();
			id.setShardCityId(cityId);
			id.setCityId(cityId.shortValue());
			ErpFunCity cityInfo = erpFunCityMapper.selectByPrimaryKey(id);
			AdminFunDepts adminDept = new AdminFunDepts();
			adminDept.setCityId(cityId);
			adminDept.setDeptId(newDeptId);
			adminDept.setCompNo(compNo);
			adminDept.setCompId(adminFunComp.getCompId());
			adminDept.setDeptNo(moveOrgInfo.getOrganizationNo());
			adminDept.setDeptCname(moveOrgInfo.getOrganizationName());
			adminDept.setProvinceId(cityInfo.getProvinceId().intValue());
			adminDept.setDeptName(moveOrgInfo.getOrganizationName());
			adminDept.setDeptAddr(moveOrgInfo.getOrganizationAddr());
			adminDept.setTryEnd(DateUtil.addDay(new Date(), 100));
			adminDept.setDeptTele(moveOrgInfo.getContactNumber());
			adminDept.setDeptType(compType.byteValue());
			adminDept.setDeptFlag(1);
			adminDept.setRegNoticeCount(Byte.valueOf("0"));
			adminDept.setOrangeNoticeCount(Byte.valueOf("0"));
			adminDept.setTransFlag(false);
			adminDept.setServiceTrainingStatus(Byte.valueOf("1"));
			adminDept.setIsUnpaidDept(Byte.valueOf("0"));
			adminDept.setIsHeadquarters(Byte.valueOf("0"));
			adminDept.setCreationTime(dateNow);
			adminFunDeptsMapper.createNewDept(adminDept);
			}
		}
		return newDeptId;	
	}
	
	/**
	 * 调动员工到新的组织机构
	 * @param cityId
	 * @param compId
	 * @param selfUserId
	 * @param moveUserId
	 * @param newOrgId
	 */
	@Transactional
	@Override
	public Map<String,Integer> moveUserNewOrganization(Integer cityId, Integer compId, Integer selfUserId, Integer moveUserId, Integer oldOrgId, Integer newOrgId, String createUserName) {
		Map<String,Integer> resultMap = new HashMap<>();
		ErpFunUsers moveUsers = erpFunUsersMapper.selectByUserId(cityId, moveUserId);
		Calendar calendar = Calendar.getInstance();
		String endTime = DateTimeHelper.formatDateTimetoString(calendar.getTime());
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		String startTime = DateTimeHelper.formatDateTimetoString(calendar.getTime(), DateTimeHelper.FMT_yyyyMMdd);
		//1.先查询出来要更新的组织id,更新partnerId
		Integer partnerId = -1;
		List<OrganizationVO> compOrgList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, null);
		Map<Integer,OrganizationVO> orgMap = compOrgList.stream().collect(Collectors.toMap(OrganizationVO::getOrganizationId,org->org));
		OrganizationVO newOrgInfo = orgMap.get(newOrgId);
		if (oldOrgId.equals(moveUsers.getOrganizationId())) {
			if (newOrgInfo!=null) {
				if (Byte.valueOf("1").equals(newOrgInfo.getDelFlag())) {
					throw new BusinessException("新的上级组织已经被删除！请重新登录确认信息！");
				}
				ErpFunUsers updateUser = new ErpFunUsers();
				updateUser.setShardCityId(cityId);
				updateUser.setUserId(moveUserId);
				updateUser.setOrganizationId(newOrgId);
				updateUser.setTissueLine(newOrgInfo.getOrganizationPath());
				updateUser.setUpdateTime(DateTimeHelper.formatDateTimetoString(new Date()));
				// modify lcb 修改于 2020/5/25 查询新组织的PID
				ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, newOrgInfo.getCompId(), newOrgInfo.getOrganizationId());
				if(null != erpFunOrganization) {
					String organizationPath = erpFunOrganization.getOrganizationPath();
					if(organizationPath.startsWith(":")) {
						organizationPath = organizationPath.substring(1,organizationPath.length()-1);
						if(organizationPath.startsWith(":")) {
							organizationPath = organizationPath.substring(1,organizationPath.length()-1);
						}
						if(StringUtils.isNotBlank(organizationPath)) {
							String s = organizationPath.split(":")[0];
							if(StringUtils.isNotBlank(s)) {
								updateUser.setDeptId(Integer.valueOf(s));
							}
						}

					}
				}
				erpFunUsersMapper.updateByPrimaryKeySelective(updateUser);
				this.updateMoveUserNewOrgCount(cityId, compId, orgMap.get(oldOrgId), newOrgInfo);
				
				Byte bussinessType = newOrgInfo.getOrganizationBussinessType();
				erpFunOrganizationMapper.updateMoveUserNewOrg(cityId, compId, newOrgInfo.getOrganizationPath(), oldOrgId, newOrgId, 
						moveUserId, moveUsers.getArchiveId(), partnerId, startTime, endTime, bussinessType);
			}
			String content = "将该员工从" + orgMap.get(oldOrgId).getOrganizationName() + " 调动至 " + newOrgInfo.getOrganizationName();
			OrganizationVO organizationNew = orgMap.get(newOrgId);//有可能是id为0需要判一下空
			OrganizationVO organizationOld = orgMap.get(oldOrgId);//有可能是id为0需要判一下空
			String newOrgPath = null == organizationNew ? "" : organizationNew.getOrganizationPath();//新组织架构path
			String oldOrgPath = null == organizationOld ? "" : organizationOld.getOrganizationPath();//老组织架构path
			String movePath =  newOrgPath + oldOrgPath;
			//erpFunEmployeeLogService.insertLogNew(cityId, compId, Const.DIC_STAFF_MOVE_TO_NEWDEPT, content, moveUsers.getArchiveId(), selfUserId, oldOrgId, newOrgId, moveUsers.getUserPosition(), moveUsers.getUserPosition());
			erpFunEmployeeLogService.insertLogNewNew(cityId, compId, Const.DIC_STAFF_MOVE_TO_NEWDEPT, content, moveUsers.getArchiveId(), selfUserId, oldOrgId, newOrgId, moveUsers.getUserPosition(), moveUsers.getUserPosition(),createUserName);
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					mqPublisher.sendMoveOrgMsg(cityId, compId, newOrgId,moveUserId);
					mqPublisher.UpdateOrgUserNum(cityId, compId,movePath);
					erpFunUsersService.endLoginUser(moveUsers.getArchiveId(), moveUsers.getUserMobile(), LogInEnum.ORGANIZATION_MOVE);
				}
			});
		} else {
			throw new BusinessException("该员工已经被调组织了，请重新登录之后，确认是否调动改员工到新组织！");
		}
		String orgPath = newOrgInfo.getOrganizationPath();
		Integer lookOldLevelId = null;
		Integer lookNewLevelId = null;
		lookNewLevelId = lookFourLevelOrgId(orgMap, orgPath);
		lookOldLevelId = lookFourLevelOrgId(orgMap, orgMap.get(oldOrgId).getOrganizationPath());
		resultMap.put("lookNewLevelId", lookNewLevelId);
		resultMap.put("lookOldLevelId", lookOldLevelId);
		return resultMap;
	}

    @Override
	public Integer lookFourLevelOrgId(Map<Integer, OrganizationVO> orgMap, String orgPath) {
		Integer lookNewLevelId = null;
		String[] orgArr = orgPath.split(":");
		
		for (String orgIdStr:orgArr)
		{
			if (StringUtils.isNotBlank(orgIdStr)) {
				Integer orgId = Integer.valueOf(orgIdStr);
				OrganizationVO orgInfo = orgMap.get(orgId);
				if (Integer.valueOf(4).equals(orgInfo.getDefinitionLevel())) {
					lookNewLevelId = orgInfo.getOrganizationId();
					break;
				}
			}
		}
		return lookNewLevelId;
	}


	public void updateAfterMoveOrgUserNum(Integer cityId, Integer compId, Integer oldPid, Integer moveOrgId, Integer newPid,
			Integer needUpdateUserCount,List<OrganizationVO> compOrgList) {
		if (compOrgList==null) {
			compOrgList = erpFunOrganizationMapper.getOrganizationList(cityId, compId, null);
		}
		Map<Integer,OrganizationVO> compOrgMap = compOrgList.stream().collect(Collectors.toMap(OrganizationVO::getOrganizationId, orgInfo->orgInfo));
		//先处理老的上级上的人数
		Integer tempPid = compOrgMap.get(moveOrgId).getPid();
		if (oldPid!=null && oldPid>0) {
			if (tempPid.equals(oldPid)) {
				updateOrganizationUserNum(cityId, compId, oldPid, moveOrgId, -needUpdateUserCount, compOrgMap);
			} else {
				throw new BusinessException("请不要重复调动部门！");
			}
		}
		if (newPid!=null && newPid>0) {
			if (!tempPid.equals(newPid)) {
				updateOrganizationUserNum(cityId, compId, newPid, moveOrgId, needUpdateUserCount, compOrgMap);
			} else {
				throw new BusinessException("请不要重复调动部门！");
			}
		}
	}

	private void updateOrganizationUserNum(Integer cityId, Integer compId, Integer oldPid, Integer moveOrgId, int needUpdateUserCount,
			Map<Integer, OrganizationVO> compOrgMap) {
		List<Integer> dealPidList = new ArrayList<>();
		if (oldPid!=null && oldPid>0) {
			Integer tempPid = new Integer(oldPid);
			dealPidList.add(oldPid);
			while (tempPid!=null && tempPid>0) {
				OrganizationVO organizationVo = compOrgMap.get(tempPid);
				if (organizationVo!=null) {
					if (organizationVo.getPid()!=null && organizationVo.getPid()>0) {
						dealPidList.add(organizationVo.getPid());
						tempPid = organizationVo.getPid();
					} else {
						break;
					}
				}
			}
			erpFunOrganizationMapper.updateOrganizationUserNum(cityId, compId, dealPidList, needUpdateUserCount);
			
		}
	}


	/**
	 *
	 * @param cityId 分库标志
	 * @param compId 当前登录人公司id
	 * @param userId 当前登录人的ID
	 * @param aliasName 表别名
	 * @param defId orgId类型 -2表示个人 >0为某组织ID
	 * @param orgId 查询指定的组织
	 * @return SQL
	 */
	public String getMangeRangeWhereCause(Integer cityId,Integer compId,Integer userId, String aliasName, Integer defId,Integer orgId) {
		List<ErpFunUserManageRange> list = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		Set<Integer> set = list.stream().map(ErpFunUserManageRange::getRangeId).collect(Collectors.toSet());
		List<String> whereList = new ArrayList<>();
		//全公司
		if (set.contains(0)) {
			whereList.add(String.format("(AliasName.COMP_ID = %d)",compId));
		} else if(!set.isEmpty()){
			List<ErpOrganizationVO> vos = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, set);
			for (ErpOrganizationVO vo : vos) {
				String item = String.format("(AliasName.%s = %d)",vo.getMappingDbField(),vo.getOrganizationId());
				whereList.add(item);
			}
			whereList.add(String.format("(AliasName.USER_ID = %d)",userId));
		}
		if (whereList.isEmpty()) {
			whereList.add(String.format("(AliasName.USER_ID = %d)",userId));
		}
		String SQL = whereList.stream().collect(Collectors.joining(" OR ", "(", ")"));
		String targetOrgIdCause = "";
		//指定的范围
		if (Objects.nonNull(defId) && Objects.nonNull(orgId)) {
			if (defId == -2) {//表示查询个人
				targetOrgIdCause = "(AliasName.USER_ID = " + orgId + ")";
			} else if (defId > 0) {
				set = new HashSet<>();
				set.add(orgId);
				List<ErpOrganizationVO> vos = erpFunOrganizationMapper.getOrganizationVOs(cityId, compId, set);
				Assert.isEmptyThrow(vos,"指定的部门不存在");
				targetOrgIdCause = String.format("(AliasName.%s = %d)", vos.get(0).getMappingDbField(), orgId);
			}
		}
		if (StringUtil.isNotBlank(targetOrgIdCause)) {
			SQL = MessageFormat.format("({0} AND {1})", SQL, targetOrgIdCause);
		}
		aliasName = Optional.ofNullable(aliasName).map(str -> str + "\\.").orElse("");
		return SQL.replaceAll("AliasName\\.", aliasName);
	}

	/**
	 * 根据orgPath进行like查询 eg: ((ORGANIZATION_PATH like %777:666:555:%) or (ORGANIZATION_PATH like %11:33:22:%))
	 * @param cityId
	 * @param compId
	 * @param userId
	 * @param column 查询列名
	 * @param aliasName 表别名
	 * @param defId orgId类型 -2表示个人 >0为某组织ID
	 * @param orgId 查询指定的组织
	 * @return SQL
	 */
	public String getMangeRangePathWhereCause(Integer cityId,Integer compId,Integer userId,String column,String aliasName, Integer defId,Integer orgId) {
		List<ErpFunUserManageRange> list = erpFunUserManageRangeMapper.getUserManageRange(cityId, compId, userId);
		List<Integer> set = list.stream().map(ErpFunUserManageRange::getRangeId).distinct().collect(Collectors.toList());
		List<String> whereList = new ArrayList<>();
		//全公司
		boolean isManager = true;
		column = Optional.ofNullable(column).filter(StringUtil::isNotBlank).orElse("ORGANIZATION_PATH");
		if (set.contains(0)) {
			String s = "(AliasName.COMP_ID = " + compId + ")";
			whereList.add(s);
		} else if(!set.isEmpty()){
			List<ErpFunOrganization> vos = erpFunOrganizationMapper.selectOrgByOrgIds(cityId, compId, set);
			for (ErpFunOrganization vo : vos) {
				String s = "(AliasName." + column + " like  '%" + vo.getOrganizationPath() + "%')";
				whereList.add(s);
			}
			String s = "(AliasName.USER_ID = " + userId + ")";
			whereList.add(s);
		}
		if (whereList.isEmpty()) {
			isManager = false;
			String s = "(AliasName.USER_ID = " + userId + ")";
			whereList.add(s);
		}
		String SQL = whereList.stream().collect(Collectors.joining(" OR ", "(", ")"));
		String targetOrgIdCause = "";
		//指定的范围
		if (isManager && Objects.nonNull(defId) && Objects.nonNull(orgId)) {
			if (defId == -2) {//表示查询个人
				targetOrgIdCause = "(AliasName.USER_ID = " + orgId + ")";
			}else if (defId > 0) {
				set = new ArrayList<>();
				set.add(orgId);
				ErpFunOrganization vo = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);
				Assert.isNullThrow(vo,"指定的部门不存在");
				targetOrgIdCause =  "(AliasName." + column + " like  '%" + vo.getOrganizationPath() + "%')";
			}
		}
		if (StringUtil.isNotBlank(targetOrgIdCause)) {
			SQL = MessageFormat.format("({0} AND {1})", SQL, targetOrgIdCause);
		}
		aliasName = Optional.ofNullable(aliasName).filter(StringUtil::isNotBlank).map(str -> str + "\\.").orElse("");
		return SQL.replaceAll("AliasName\\.", aliasName);
	}

	@Override
	public void updateBelongOrgUserCount(Integer cityId, Integer compId, Integer orgId,Integer needUpdateCount) {
		ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);
		if (organization!=null) {
			String orgPath = organization.getOrganizationPath();//受影响path
			String[] orgPathArr = orgPath.split(":");
			List<Integer> orgIds = new ArrayList<>();
			boolean flag = false;
			for (String orgIdStr:orgPathArr) {
				if (StringUtils.isNotBlank(orgIdStr)) {
					orgIds.add(StringUtil.parseInteger(orgIdStr, 0));
					flag = true;
				}
			}
			if (flag) {
				erpFunOrganizationMapper.updateOrganizationUserNum(cityId, compId, orgIds, needUpdateCount);
			}
			TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
				@Override
				public void afterCommit() {
					mqPublisher.UpdateOrgUserNum(cityId, compId,orgPath);
				}
			});
		}
	}
	
	@Override
	public void updateMoveUserNewOrgCount(Integer cityId, Integer compId, ErpFunOrganization oldOrgInfo, ErpFunOrganization newOrgInfo) {
		
		/*ErpFunOrganization organization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);*/
		if (oldOrgInfo!=null) {
			String orgPath = oldOrgInfo.getOrganizationPath();
			String[] orgPathArr = orgPath.split(":");
			List<Integer> orgIds = new ArrayList<>();
			boolean flag = false;
			for (String orgIdStr:orgPathArr) {
				if (StringUtils.isNotBlank(orgIdStr)) {
					orgIds.add(StringUtil.parseInteger(orgIdStr, 0));
					flag = true;
				}
			}
			if (flag) {
				erpFunOrganizationMapper.updateOrganizationUserNum(cityId, compId, orgIds, -1);
			}
		}
		if (newOrgInfo!=null) {
			String orgPath = newOrgInfo.getOrganizationPath();
			String[] orgPathArr = orgPath.split(":");
			List<Integer> orgIds = new ArrayList<>();
			boolean flag = false;
			for (String orgIdStr:orgPathArr) {
				if (StringUtils.isNotBlank(orgIdStr)) {
					orgIds.add(StringUtil.parseInteger(orgIdStr, 0));
					flag = true;
				}
			}
			if (flag) {
				erpFunOrganizationMapper.updateOrganizationUserNum(cityId, compId, orgIds, 1);
			}
		}
	}

	@Override
	public boolean judgePermissionByOrganizationId(Integer cityId, Integer compId, Integer userOrganizationId, Integer caseOrganizationId) {
		if (null != caseOrganizationId) {
			ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, caseOrganizationId);
			if (null != erpFunOrganization && StringUtil.isNotBlank(erpFunOrganization.getOrganizationPath()) && null != userOrganizationId) {
				return erpFunOrganization.getOrganizationPath().indexOf(userOrganizationId.toString()) != -1;
			}
		}
		return false;
	}

	@Override
	public void updateOrganizationManager(Integer cityId, Integer compId, Integer organizationId, String userIds) {
		updateOrganizationManagerCommon(cityId, compId, organizationId, userIds);
	}
}