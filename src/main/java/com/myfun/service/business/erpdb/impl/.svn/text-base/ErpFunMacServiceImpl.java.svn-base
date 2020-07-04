package com.myfun.service.business.erpdb.impl;

import com.myfun.erpWeb.managecenter.sysmanager.param.GetMgrInstallListParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunMacMapper;
import com.myfun.repository.erpdb.dao.*;
import com.myfun.repository.erpdb.dto.ErpFunMacDto;
import com.myfun.repository.erpdb.po.*;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunMacService;
import com.myfun.service.business.erpdb.ErpFunUsersService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateUtil;
import com.myfun.utils.EncryptHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;
import java.util.Map;
@Service
public class ErpFunMacServiceImpl extends AbstractService<ErpFunMac, ErpFunMac> implements
		ErpFunMacService {
	@Autowired AdminFunMacMapper adminFunMacMapper;
	@Autowired ErpFunMacMapper erpFunMacMapper;
	@Autowired ErpFunUsersService erpFunUsersService;
	@Autowired ErpCompRolesMapper erpCompRolesMapper;
	@Autowired ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired ErpFunCompMapper erpFunCompMapper;
	@Autowired ErpUserOpersMapper erpUserOpersMapper;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunMacMapper;
		
	}
	@Override
	public List<ErpFunMacDto> getMgrInstallList(BaseMapParam param) {
		GetMgrInstallListParam getMgrInstallListParam = new GetMgrInstallListParam();
		getMgrInstallListParam.setCompId(param.getInteger("compId"));
		getMgrInstallListParam.setDeptId(param.getInteger("deptId"));
		List<ErpFunMacDto> list = erpFunMacMapper.selectMgrInstallList(param.getInteger("cityId"),getMgrInstallListParam);
		for(ErpFunMacDto dto : list){
			//电脑ID,从数据库取MAC明文地址，显示列表加密,不影响数据库
			String pcId = EncryptHelper.encryptMD5(dto.getPcId());
			dto.setPcId(pcId);
		}
		return list;
	}
	
	@Override
	public void updateMgrReg(BaseMapParam param) {
		erpFunMacMapper.updateFunMacLoginStatusOrReg(param.getInteger("cityId"),param.getMap());
	}
	
	@Transactional
	@Override
	public void updateMgrchgLoginType(BaseMapParam param) {
		erpFunMacMapper.updateFunMacLoginStatusOrReg(param.getInteger("cityId"), param.getMap());
		adminFunMacMapper.updateFunMacLoginStatusOrReg(param.getMap());
	}
	
	@Transactional
	@Override
	public void updateMgrRoamUser(Integer cityId, Integer roam, Integer compId, Integer roamUserId, String macaddr) {
		ErpFunMac funMac = erpFunMacMapper.getFunMacByMacaddr(cityId,compId,macaddr);
		if (funMac != null && funMac.getRoamUser() != null) {
			updateUserUpdateTime(cityId, compId, funMac.getRoamUser());
		}
		// 设置为漫游
		if (roam != null && 1 == roam) {
			ErpFunUsers erpFunUsers = erpFunUsersService.getUserInfoByUserId(cityId, roamUserId);
//			ErpCompRoles compRoles = erpCompRolesMapper.getByRoleId(cityId, compId, erpFunUsers.getUserPosition());
//			if (compRoles != null && (compRoles.getManageLevel() == 0 || compRoles.getManageLevel() == 6)) {
//				throw new BusinessException("该员工角色没有设置管理层级（可在员工权限中设置），无法开启漫游，请重新选择！");
//			}
			// 判断是不是编辑，flj修改郭人杰，说美联那边不限制漫游人数 2020-04-21
			Integer res = erpFunMacMapper.judgeIsReamUser(cityId, macaddr);

		} else {
			roam = 0;// 取消漫游
		}
		erpFunMacMapper.updateMacInfoByMacAddr(cityId, roam, roamUserId, macaddr);
		adminFunMacMapper.updateMacInfoByMacAddr(cityId, roam, roamUserId, macaddr);
		updateUserUpdateTime(cityId, compId, roamUserId);
	}

	private void updateUserUpdateTime(Integer cityId, Integer compId, Integer userId) {
		ErpFunUsers users = new ErpFunUsers();
		users.setShardCityId(cityId);
		users.setUpdateTime(DateUtil.DateToString(new Date()));
		users.setUserId(userId);
		erpFunUsersMapper.updateByPrimaryKeySelective(users);
	}

	/**
	 * 漫游是否已达到最大
	 * @author 张宏利
	 * @since 2017年10月16日
	 * @param cityId
	 * @param compId
	 * @param deptId
	 * @return
	 */
	private boolean getRoamCountIsMax(Integer cityId, Integer compId, Integer deptId) {
		int roamMax = erpFunDeptsMapper.getRoamCount(cityId, compId, deptId);
		int roamCount = erpFunMacMapper.getRoamCountByDeptId(cityId, compId);
		return roamCount >= roamMax;
	}

	@Transactional
	@Override
	public void deleteMgrReg(BaseMapParam param) {
		erpFunMacMapper.deleteByMacAddr(param.getInteger("cityId"), param.getMap());
		adminFunMacMapper.deleteByMacAddr(param.getInteger("cityId"), param.getMap());
		adminFunDeptsMapper.updateDeptsInstallCount(param.getMap());
	}

	@Override
	public void updateMgrchgRegist(BaseMapParam param) {
		ErpFunComp erpFunComp = new ErpFunComp();
		erpFunComp.setCompId(param.getInteger("compId"));
		if ("0".equals(param.getString("registFlag"))) {
			erpFunComp.setRegistFlag(false);
		} else {
			erpFunComp.setRegistFlag(true);
		}
		erpFunComp.setShardCityId(param.getInteger("cityId"));
		erpFunCompMapper.updateByPrimaryKeySelective(erpFunComp);
	}

	@Transactional
	@Override
	public void setMgrRegistManager(BaseMapParam param) throws Exception {
		Integer userId = param.getInteger("userId");
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getUserInfoByUserId(param.getInteger("cityId"), userId);
		// 判断该用户角色
		if(!Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER.equals(erpFunUsers.getUserPosition())){
			// 清除原本的管理员，总经理角色默认不能去掉
			erpUserOpersMapper.deleteMgrRegistManager(param.getInteger("cityId"),param.getInteger("compId"),"REGIST_MANAGE",Constants_DIC.DIC_ROLE_NAME_GENERAL_MANAGER);
			ErpUserOpers erpUserOpers = new ErpUserOpers();
			erpUserOpers.setShardCityId(param.getInteger("cityId"));
			erpUserOpers.setUserId(userId);
			erpUserOpers.setOperId("REGIST_MANAGE");
			erpUserOpersMapper.insertSelective(erpUserOpers);
		}else{
			throw new BusinessException("总经理账号 无需设置为注册管理员");
		}
	}
	
	@Override
	public Map<String, Object> getRegistManagerUser(BaseMapParam param) {
		Map<String,Object> mapData = erpFunUsersService.getRegistManagerUser(param.getInteger("cityId"), param.getInteger("compId"));
		return mapData;
	}

}


