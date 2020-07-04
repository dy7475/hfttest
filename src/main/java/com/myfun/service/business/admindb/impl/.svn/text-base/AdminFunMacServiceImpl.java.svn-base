package com.myfun.service.business.admindb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.admindb.dao.AdminFunAdsMapper;
import com.myfun.repository.admindb.dao.AdminFunCityMapper;
import com.myfun.repository.admindb.dao.AdminFunCompMapper;
import com.myfun.repository.admindb.dao.AdminFunDatasourceConfigMapper;
import com.myfun.repository.admindb.dao.AdminFunDeptsMapper;
import com.myfun.repository.admindb.dao.AdminFunMacMapper;
import com.myfun.repository.admindb.dao.AdminSysParaMapper;
import com.myfun.repository.admindb.dto.AdminFunMacDto;
import com.myfun.repository.admindb.po.AdminFunComp;
import com.myfun.repository.admindb.po.AdminFunDepts;
import com.myfun.repository.admindb.po.AdminFunMac;
import com.myfun.repository.admindb.po.AdminFunMacExample;
import com.myfun.repository.erpdb.dao.ErpCompRolesMapper;
import com.myfun.repository.erpdb.dao.ErpFunCompMapper;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunMacMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpCompRoles;
import com.myfun.repository.erpdb.po.ErpFunComp;
import com.myfun.repository.erpdb.po.ErpFunDepts;
import com.myfun.repository.erpdb.po.ErpFunMac;
import com.myfun.repository.erpdb.po.ErpFunMacExample;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const.ResponseCode;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunMacService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

/**
 * 根据mac操作业务类
 * 
 * @ClassName: AdminFunMacServiceImpl
 * @Description: TODO
 * @author jiangsonggui
 * @date 2015年11月26日 下午4:10:15
 *
 */
@Service
public class AdminFunMacServiceImpl extends AbstractService<AdminFunMac, String>implements AdminFunMacService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AdminFunMacServiceImpl.class);
	@Autowired
	private AdminFunMacMapper adminFunMacMapper;
	@Autowired
	private AdminFunDeptsMapper adminFunDeptsMapper;
	@Autowired
	private AdminSysParaMapper adminSysParaMapper;
	@Autowired
	private AdminFunDatasourceConfigMapper adminFunDatasourceConfigMapper;
	@Autowired
	private ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	private ErpFunCompMapper erpFunCompMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunAdsMapper adminFunAdsMapper;
	@Autowired
	private AdminFunCityMapper adminFunCityMapper;
	@Autowired
	private ErpFunMacMapper erpFunMacMapper;
	@Autowired
	private AdminFunCompMapper adminFunCompMapper;
	@Autowired
	private ErpCompRolesMapper erpCompRolesMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunMacMapper;
	}

	/**
	 * @see AdminFunMacService#isLoginByMac(String, String)
	 */
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Map<Object, Object> isLoginByMac(String mac, String routMac) {
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(mac);
		if (adminFunMac == null) {
			retMap = isLoginByRoutMac(routMac);
			return retMap;
		}

		// 重新注册标记
		if (adminFunMac.getCompId() == null || adminFunMac.getDeptId() == null) {
			retMap.put("ACTION", "PLEASE_REGIST");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			retMap.put("TYPE", "1");
			return retMap;
		}

		// 被禁止登陆
		if (adminFunMac.getFlag() == 1) {
			retMap.put("ACTION", "ERROR_CN_MSG");
			retMap.put("ERRMSG", "您的终端已被门店管理员禁止登录！");
			return retMap;
		}

		// 判断试用是否到期
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(adminFunMac.getDeptId());
		if (adminFunDepts == null) {
			retMap.put("ACTION", "PLEASE_REGIST");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			retMap.put("TYPE", "2");
			return retMap;
		}
		if (adminFunDepts.getDeptFlag() == 0) {
			retMap.put("ACTION", "GetUserListSJB-try");
			retMap.put("ERRMSG", "试用到期!");
			return retMap;
		}

		// 如果不是漫游用户 则判断是否超出门店
		if (!adminFunMac.getRoam()) {
			// 如果门店mac为空 则把门店mac更新为当前mac的routMac
			if (StringUtil.isEmpty(adminFunDepts.getMacaddr())) {
				AdminFunDepts upDepts = new AdminFunDepts();
				upDepts.setDeptId(adminFunDepts.getDeptId());
				upDepts.setMacaddr(routMac);
				adminFunDeptsMapper.updateByPrimaryKeySelective(upDepts);
			} else if (adminFunDepts.getMacaddr().indexOf(routMac) < 0) {
				// 超出门店 看最后登录时间是否过期 过期则提示注册 没有过期提示漫游
				if (StringUtil.isNotEmpty(adminFunMac.getLastLoginTime())) {
					int difDays = DateUtil.getIntervalDays(new Date(), DateUtil.StringToDate(adminFunMac.getLastLoginTime()));
					String wanLoginLimitDay = adminSysParaMapper.selectByPrimaryKey("WAN_LOGIN_LIMIT_DAY").getParamValue();
					if (difDays > StringUtil.parseInteger(wanLoginLimitDay, 0)) {
						retMap.put("ACTION", "PLEASE_REGIST");
						retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
						retMap.put("TYPE", "3");
						return retMap;
					}
				}

				// 提示用户漫游
				retMap.put("ACTION", "PLEASE_ROAMING");
				retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
				return retMap;
			}
		}
		return retMap;
	}

	/**
	 * @see AdminFunMacService#isLoginByRoutMac(String)
	 */
	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Map<Object, Object> isLoginByRoutMac(String routMac) {
		Map<Object, Object> retMap = new HashMap<Object, Object>();
		List<AdminFunDepts> funDepts = adminFunDeptsMapper.getDeptListByMac(routMac);

		// 既没有电脑MAC 也没有 门店MAC
		if (funDepts.size() == 0) {
			retMap.put("ACTION", "PLEASE_REGIST");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			retMap.put("TYPE", "4");
			return retMap;
		}

		// 说明有多个路由MAC 就直接喊他注册 20130405
		if (funDepts.size() > 1) {
			retMap.put("ACTION", "PLEASE_REGIST");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			retMap.put("TYPE", "5");
			return retMap;
		}

		// 试用到期
		AdminFunDepts adminDept = funDepts.get(0);
		if (adminDept.getDeptFlag() == 0) {
			retMap.put("ACTION", "GetUserListSJB-try");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			retMap.put("ERRMSG", "试用到期!");
			return retMap;
		}

		// 提示用户是否需要自动注册
		retMap.put("ACTION", "CONFIRM_REG");
		retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
		retMap.put("ERRMSG", String.format("你的电脑在 %s 注册范围内，是否加入该门店", adminDept.getDeptName()));
		return retMap;
	}

	/**
	 * @see AdminFunMacService#resetRegisterInfoByMac(String)
	 */
	@Override
	public boolean resetRegisterInfoByMac(String macAddr) {
		try {
			// 重置admin fun_mac 如果admin找不到则 则找不到本地库连接
			AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(macAddr);
			if (adminFunMac != null) {
				AdminFunComp adminFunComp = adminFunCompMapper.selectByPrimaryKey(adminFunMac.getCompId());

				// 重置本地库 fun_mac
				ErpFunMac erpFunMac = erpFunMacMapper.selectByPrimaryKey(new ErpFunMac(adminFunComp.getCityId(), macAddr));
				if (erpFunMac != null) {
					erpFunMac.setCompId(null);
					erpFunMac.setDeptId(null);
					erpFunMac.setCompNo(null);
					erpFunMac.setDeptNo(null);
					erpFunMac.setShardCompId(adminFunMac.getCompId());
					erpFunMacMapper.updateByPrimaryKey(erpFunMac);
				}

				// admin库
				adminFunMac.setCompId(null);
				adminFunMac.setDeptId(null);
				adminFunMac.setCompNo(null);
				adminFunMac.setDeptNo(null);
				adminFunMacMapper.updateByPrimaryKey(adminFunMac);
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return false;
	}

	/**
	 * @see AdminFunMacService#deleteRegisterInfoByMac(String)
	 * @param nacAddr
	 * @return
	 */
	@Transactional
	@Override
	public boolean deleteRegisterInfoByMac(String macAddr) {
		try {
			AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(macAddr);
			if (adminFunMac != null) {
				// 增加门店注册数量
				AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(adminFunMac.getDeptId());
				if (adminFunDepts != null) {
					AdminFunDepts upDepts = new AdminFunDepts();
					upDepts.setDeptId(adminFunMac.getDeptId());
					upDepts.setInstallCount(adminFunDepts.getInstallCount() + 1);
					adminFunDeptsMapper.updateByPrimaryKeySelective(upDepts);
				}

				// 删除admin库mac信息
				adminFunMacMapper.deleteByPrimaryKey(macAddr);

				// 删除本地库注册信息
				erpFunMacMapper.deleteByPrimaryKey(new ErpFunMac(adminFunDepts.getCityId(), macAddr));
			}
			return true;
		} catch (Exception e) {
			LOGGER.error("", e);
		}
		return false;
	}

	@Transactional(value = TxType.NOT_SUPPORTED)
	public String getCompNoByMacAddr(String macAddr) {
		AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(macAddr);
		if (null != adminFunMac) {
			AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(adminFunMac.getDeptId());
			if (null != adminFunDepts) {
				return adminFunDepts.getCompNo();
			}
		}
		return "";
	}

	@Override
	public Map<Object, Object> getDeptAndUserList(String mac, String routMac, String lineType) {
		Map<Object, Object> retMap = new HashMap<Object, Object>();

		AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(mac);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(adminFunMac.getDeptId());
		// 本次是否是漫游
		boolean isRoam = adminFunMac.getRoam() && (adminFunDepts.getMacaddr().indexOf(routMac) < 0);
		if (!isRoam && !adminFunDepts.getMacaddr().contains(routMac)) {//超出门店
			// 提示用户漫游
			retMap.put("ACTION", "PLEASE_ROAMING");
			retMap.put("URL", "http://www.hftsoft.com/user/registerEnt.shtml");
			return retMap;
		}
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getDeptByCompNoAndDeptNo(adminFunDepts.getCompNo(), adminFunDepts.getDeptNo());

		ErpFunComp erpFunComp = erpFunCompMapper.getCompByCompNo(erpFunDepts.getCompNo());
		// 如果是非企业版 或者是漫游用户则只能选择本门店
		List<Map<String, Object>> erpFunDeptsMapList = new ArrayList<Map<String, Object>>();
		if (isRoam || (adminFunDepts.getDeptType() != 1)) {
			Map<String, Object> tmp = new HashMap<String, Object>();
			tmp.put("DEPT_ID", erpFunDepts.getDeptId());
			tmp.put("DEPT_NAME", erpFunDepts.getDeptName());
			erpFunDeptsMapList.add(tmp);
		} else {
			ErpFunDepts erpFunDeptsCondition = new ErpFunDepts();
			// 设置分裤标记
			erpFunDeptsCondition.setShardCompNo(adminFunDepts.getCompNo());
			erpFunDeptsCondition.setCompNo(adminFunDepts.getCompNo());
			erpFunDeptsCondition.setCompId(erpFunDepts.getCompId());

			List<ErpFunDepts> erpFunDeptsList = erpFunDeptsMapper.getValidDeptListByNotNull(erpFunDeptsCondition);
			for (ErpFunDepts dept : erpFunDeptsList) {
				Map<String, Object> tmp = new HashMap<String, Object>();
				tmp.put("DEPT_ID", dept.getDeptId());
				tmp.put("DEPT_NAME", dept.getDeptName());
				erpFunDeptsMapList.add(tmp);
			}
		}
		// 追加分店列表
		retMap.put("DEPTLIST", erpFunDeptsMapList);
		// 获得本店名称及本公司分店列表 获得员工列表
		ErpFunUsers erpFunUsersCondition = new ErpFunUsers();
		erpFunUsersCondition.setShardCompId(adminFunDepts.getCompId());
		erpFunUsersCondition.setCompId(erpFunDepts.getCompId());
		erpFunUsersCondition.setUserStatus((byte) 1);
		erpFunUsersCondition.setUserWriteoff(false);
		// 如果是漫游则只能获取当前用户
		if (adminFunDepts.getDeptType() == 1) {
			if (isRoam) {
				erpFunUsersCondition.setUserId(adminFunMac.getRoamUser());
			} else {
				// 注意 and (deptId or AlldeptFlag)
				erpFunUsersCondition.setDeptId(erpFunDepts.getDeptId());
				if (erpFunComp.getCompType() == 1) {
					erpFunUsersCondition.setAlldeptFlag(true);
				}
			}
		} else {
			erpFunUsersCondition.setDeptId(erpFunDepts.getDeptId());
		}
		// 根据条件查询用户列表
		// 10、追加员工列表
		List<Map<String, Object>> erpFunUserMapList = new ArrayList<Map<String, Object>>();
		List<ErpFunUsers> erpFunUsersList = erpFunUsersMapper.getUserListByAllDept(erpFunUsersCondition);
		for (ErpFunUsers user : erpFunUsersList) {
			Map<String, Object> tmp = new HashMap<String, Object>();
			tmp.put("USER_ID", user.getUserId());
			tmp.put("USER_NAME", user.getUserName());
			tmp.put("DEPT_ID", user.getDeptId());
			tmp.put("USER_MOBILE", user.getUserMobile());
			erpFunUserMapList.add(tmp);
		}
		// 追加普通用户列
		retMap.put("USERLIST", erpFunUserMapList);
		// 返回服务器时间
		retMap.put("SERVER_TIME", DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm:ss"));
		return retMap;
	}

	@Override
	public boolean isRoam(String mac, String routMac) {
		AdminFunMac adminFunMac = adminFunMacMapper.selectByPrimaryKey(mac);
		AdminFunDepts adminFunDepts = adminFunDeptsMapper.selectByPrimaryKey(adminFunMac.getDeptId());
		// 本次是否是漫游
		boolean isRoam = adminFunMac.getRoam() && (adminFunDepts.getMacaddr().indexOf(routMac) < 0);
		return isRoam;
	}

	@Override
	public String updateResiveMAC(String macAddr) {
		AdminFunMac funMac=adminFunMacMapper.selectByPrimaryKey(macAddr);
		if(null==funMac){
			return StringUtil.StringToJson(ResponseCode.OTHER_FAIL, "该电脑未注册！", null);
		}
		ErpFunMac erpFunMac = new ErpFunMac();
		erpFunMac.setMacaddr(funMac.getMacaddr());
		erpFunMac.setCompNo(funMac.getCompNo());
		erpFunMac.setCompId(funMac.getCompId());
		erpFunMac.setDeptNo(funMac.getDeptNo());
		erpFunMac.setShardCompId(funMac.getCompId());
		erpFunMac.setRoamUser(funMac.getRoamUser());
		erpFunMac.setRegtime(funMac.getRegtime());
		erpFunMac.setPcname(funMac.getPcname());
		erpFunMac.setFlag(funMac.getFlag());
		erpFunMac.setRoam(funMac.getRoam());
		erpFunMac.setOwner(funMac.getOwner());
		erpFunMac.setPcdiskno(funMac.getPcdiskno());
		erpFunMac.setRoutemac(funMac.getRoutemac());
		erpFunMac.setRoamUser(funMac.getRoamUser());
		try{
			erpFunMacMapper.updateByPrimaryKeySelective(erpFunMac);
			return StringUtil.StringToJson(ResponseCode.SUCCESS, "MAC地址修正成功！", null);
		}catch(Exception e){
			e.printStackTrace();
			return StringUtil.StringToJson(ResponseCode.OTHER_FAIL, "保存失败！", null);
		}
	}

	@Override
	public AdminFunMacDto getCompInfoByMacAddr(String macAddr) {
		//adminFunMacMapper
		AdminFunMacDto funMacDto=adminFunMacMapper.getCompInfoByMacAddr(macAddr);
		return funMacDto;
	}

	@Override
	public void updateMgrchgCruise(Integer cityId, Integer compId, Integer roamUserId, String roam, String macaddr) {
		if("1".equals(roam)){// 设置为漫游
			ErpFunUsers roamUsersPO = erpFunUsersMapper.getFunUserByUserId(cityId, roamUserId);
			ErpCompRoles roleList =  erpCompRolesMapper.getLowerRoles(cityId, compId, "SECRETARIAL", roamUsersPO.getUserPosition(), false); //获取店务秘书以下的所有岗位
			if(roleList != null){// 店秘以下的岗位不允许漫游
				throw new BusinessException("店务秘书以下岗位不允许漫游");
			}
			if(this.getRoamCountIsMax(cityId, compId, roamUsersPO.getDeptId())){
				throw new BusinessException("门店漫游用户超过上限");
			}
			this.updateMacInfoByMacAddrWithAdminDb(cityId, true, roamUserId, macaddr);
		}else if("0".equals(roam)){// 取消漫游
			this.updateMacInfoByMacAddrWithAdminDb(cityId, false, roamUserId, macaddr);
		}
	}

	private boolean isInRoleist(String userPosition, List<ErpCompRoles> roleList) {
		if(StringUtils.isBlank(userPosition) || null == roleList || roleList.size() == 0){
			return false;
		}
		for(ErpCompRoles erpCompRoles : roleList){
			if(userPosition.equals(erpCompRoles.getRoleId())){
				return true;
			}
		}
		return false;
	}

	@Override
	public Boolean getRoamCountIsMax(Integer cityId, Integer compId, Integer deptId) {
		ErpFunDepts erpFunDepts = erpFunDeptsMapper.getByDeptId(cityId, deptId);
		Byte roamNum = erpFunDepts.getRoamNum();
		ErpFunMacExample erpFunMacExample = new ErpFunMacExample();
		erpFunMacExample.setShardCityId(cityId);
		erpFunMacExample.createCriteria().andCompIdEqualTo(compId).andDeptIdEqualTo(deptId).andRoamEqualTo(true);
		Integer count = erpFunMacMapper.countByExample(erpFunMacExample);
		return roamNum.intValue() >= count;
	}

	@Transactional
	@Override
	public void updateMacInfoByMacAddrWithAdminDb(Integer cityId, Boolean roam, Integer roamUserId, String macaddr) {
		AdminFunMacExample adminFunMacExample = new AdminFunMacExample();
		adminFunMacExample.createCriteria().andMacaddrEqualTo(macaddr);
		AdminFunMac adminFunMac = new AdminFunMac();
		adminFunMac.setRoam(roam);
		adminFunMac.setRoamUser(roamUserId);
		adminFunMacMapper.updateByExampleSelective(adminFunMac, adminFunMacExample);

		// 同步跟进
		ErpFunMacExample erpFunMacExample = new ErpFunMacExample();
		erpFunMacExample.setShardCityId(cityId);
		erpFunMacExample.createCriteria().andMacaddrEqualTo(macaddr);
		ErpFunMac erpFunMac = new ErpFunMac();
		erpFunMac.setRoam(roam);
		erpFunMac.setRoamUser(roamUserId);
		erpFunMacMapper.updateByExampleSelective(erpFunMac, erpFunMacExample);
	}
}
