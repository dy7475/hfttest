package com.myfun.service.business.agencydb.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.AdminFunUsersMapper;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyFunCompRealMapper;
import com.myfun.repository.agencydb.dao.AgencyFunDeptsMapper;
import com.myfun.repository.agencydb.dao.AgencyFunUsersMapper;
import com.myfun.repository.agencydb.dto.AgencyFunCompRealDto;
import com.myfun.repository.agencydb.param.AgencyFunCompRealParam;
import com.myfun.repository.agencydb.po.AgencyFunCompReal;
import com.myfun.repository.agencydb.po.AgencyFunDepts;
import com.myfun.repository.agencydb.po.AgencyFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunCompRealService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@Service
public class AgencyFunCompRealServiceImpl extends AbstractService<AgencyFunCompReal, Integer> implements AgencyFunCompRealService {

	@Autowired
	AgencyFunCompRealMapper agencyFunCompRealMapper;
	@Autowired
	AgencyFunDeptsMapper agencyFunDeptsMapper;
	@Autowired
	AgencyFunUsersMapper agencyFunUsersMapper;
	@Autowired
	AdminFunUsersMapper adminFunUsersMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunCompRealMapper;
	}

	@Override
	public Page<AgencyFunCompReal> getCompRealList(AgencyFunCompReal agencyFunCompReal, Integer pageNumber) {
		PageHelper.startPage(pageNumber, Const.PAGE_NUMBER, true);
		Page<AgencyFunCompReal> funCompReals = agencyFunCompRealMapper.selectByCompRealList(agencyFunCompReal);
		return funCompReals;
	}

	@Override
	public boolean updateAndAddCompReal(AgencyFunCompReal funCompReal) {
		agencyFunCompRealMapper.insertSelective(funCompReal);
		return false;
	}

	@Override
	public PageInfo<AgencyFunCompRealDto> getFunCompRealList(AgencyFunCompRealParam adminFunCompRealParam) {
		PageHelper.startPage(adminFunCompRealParam.getPageNum(), adminFunCompRealParam.getPageSize(), true);
		// 处理时间
		queryDateDeal(adminFunCompRealParam);
		List<AgencyFunCompRealDto> resList = agencyFunCompRealMapper.getFunCompRealList(adminFunCompRealParam);
		PageInfo<AgencyFunCompRealDto> info = new PageInfo<>(resList);
		return info;
	}

	/**
	 * 时间解析
	 * **/
	private void queryDateDeal(AgencyFunCompRealParam adminFunCompRealParam) {
		if(null != adminFunCompRealParam.getDateType()) {
			Date nowDate = new Date();
			String nowStr = DateUtil.DateToString(nowDate, "yyyy-MM-dd 00:00:00");
			adminFunCompRealParam.setEndTime(nowStr);
			switch (adminFunCompRealParam.getDateType()) {
			case 1: // 一周
				adminFunCompRealParam.setStartTime(DateUtil.addDay(nowStr, -7));
				break;
			case 2: // 一月
				adminFunCompRealParam.setStartTime(DateUtil.addMonth(nowStr, -1));
				break;
			case 3: // 一季度
				adminFunCompRealParam.setStartTime(DateUtil.addMonth(nowStr, -4));
				break;
			case 4	: // 半年
				adminFunCompRealParam.setStartTime(DateUtil.addMonth(nowStr, -6));
				break;
			case 5	: // 一年
				adminFunCompRealParam.setStartTime(DateUtil.addYear(nowStr, -1));
				break;
			}
		}
	}

	/**
	 * 修改新增数据
	 * **/
	@Transactional
	@Override
	public Integer addOrUpdateFunCompReal(AgencyFunCompReal agencyFunCompReal, AdminCrmUser adminCrmUser, String oldMobile, String createTime) {
		Integer res = -1;
		if(null != agencyFunCompReal.getDevloperId()) {
			res = agencyFunCompRealMapper.updateByPrimaryKeySelective(agencyFunCompReal);
			if(StringUtil.isNotBlank(oldMobile) && !oldMobile.equals(agencyFunCompReal.getSalesMobile())) {
				// 修改部门
				AgencyFunDepts agencyFunDepts = new AgencyFunDepts();
				agencyFunDepts.setCityId(new Short(agencyFunCompReal.getCityId()));
				agencyFunDepts.setDevloperId(agencyFunCompReal.getDevloperId());
				agencyFunDepts.setContactTele(oldMobile);
				
				Map<String, Object> funDeptsParamMap = new HashMap<>();
				funDeptsParamMap.put("cityId", agencyFunCompReal.getCityId());
				funDeptsParamMap.put("devloperId", agencyFunCompReal.getDevloperId());
				funDeptsParamMap.put("newMobile", agencyFunCompReal.getSalesMobile());
				agencyFunDeptsMapper.updateByCityIdAndDevelopId(funDeptsParamMap);
				// 修改账号
				Map<String, Object> funUserParamMap = new HashMap<>();
				funUserParamMap.put("oldMobile", oldMobile);
				funUserParamMap.put("newMobile", agencyFunCompReal.getSalesMobile());
				funUserParamMap.put("userPosttion", "SYS_MANAGER");
				funUserParamMap.put("userStatus", "1");
				agencyFunUsersMapper.updateFunUser(funUserParamMap);
			}
		}else {
			Date date = new Date();
			if(StringUtil.isNotBlank(createTime)) {
				date = DateUtil.StringToDate(createTime, "yyyy-MM-dd HH:mm:ss");
			}
			agencyFunCompReal.setCreationTime(date);
			agencyFunCompReal.setCreatorUid(adminCrmUser.getUserId());
			// 开公司
			res = agencyFunCompRealMapper.insertSelective(agencyFunCompReal);
			// 开部门
			Integer createFunDepts = createFunDepts(agencyFunCompReal);
			// 创建账号
			Integer createFunUser = createFunUser(agencyFunCompReal);
		}
		return res;
	}
	
	//开账户
	public Integer createFunUser(AgencyFunCompReal agencyFunCompReal) {
		AgencyFunUsers afu = new AgencyFunUsers();
		afu.setDevloperId(agencyFunCompReal.getDevloperId());
		afu.setCityId(agencyFunCompReal.getCityId());
		afu.setDeptId(agencyFunCompReal.getDevloperId());
		afu.setUserName(agencyFunCompReal.getSalesManager());
		afu.setLoginUid(agencyFunCompReal.getSalesMobile());
		afu.setLoginPwd("f9a7b11de7f38a166504bfd6eec7be43");
		afu.setUserSex(true);
		afu.setUserMobile(agencyFunCompReal.getSalesMobile());
		afu.setUserPosition("SYS_MANAGER");
		afu.setUserStatus("1"); //fixed hyq(2013-04-28) 1：正常；0：停用
		int res = agencyFunUsersMapper.insertSelective(afu);
		return res;
	}
	
	// 开公司
	private Integer createFunDepts(AgencyFunCompReal agencyFunCompReal) {
		AgencyFunDepts acf = new AgencyFunDepts();
		acf.setCityId(agencyFunCompReal.getCityId());
		acf.setDevloperId(agencyFunCompReal.getDevloperId());
		acf.setSeqNo(new Short("1"));
		acf.setDeptName(agencyFunCompReal.getCompName());
		acf.setDeptTele(agencyFunCompReal.getCompTele());
		acf.setDeptContact(agencyFunCompReal.getSalesManager());
		acf.setContactTele(agencyFunCompReal.getSalesMobile());
		Integer res = agencyFunDeptsMapper.insertSelective(acf);
		return res;
		
	}

	@Override
	public AgencyFunCompRealDto getFunCompRealListByDevelopId(Integer devloperId) {
		AgencyFunCompRealParam agencyFunCompRealParam = new AgencyFunCompRealParam();
		agencyFunCompRealParam.setDevelopId(devloperId);
		List<AgencyFunCompRealDto> resList = agencyFunCompRealMapper.getFunCompRealList(agencyFunCompRealParam);
		return (null != resList && resList.size() > 0) ? resList.get(0) : null;
	}

	@Override
	public List<AgencyFunCompReal> getDeveloperList(String developerName, AdminCrmUser adminCrmUser) {
		// 此处可能存在穿多个参数
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("developerName", developerName);
		List<AgencyFunCompReal> resList = agencyFunCompRealMapper.getDeveloperList(paramMap);
		return resList;
	}

	@Override
	public PageInfo<AgencyFunCompReal> getFunCompRealList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		pMap.put("erpCompId",param.getInteger("compId"));
		if (null != pMap.get("startTime")) {
			String conStr = pMap.get("startTime") + "";
			String nowTime = "00:00:00";
			conStr = conStr + " " + nowTime;
			pMap.put("startTime", conStr);
		}
		if (null != pMap.get("endTime")) {
			String conStr = pMap.get("endTime") + "";
			String nowTime = "23:59:59";
			conStr = conStr + " " + nowTime;
			pMap.put("endTime", conStr);
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyFunCompReal> resList = agencyFunCompRealMapper.getFunCompRealDevelopList(pMap);
		return new PageInfo<>(resList);
	}

	/**
	 * @TODO 添加编辑楼盘开发商
	 * @author lcb
	 * @2016-9-28 上午10:24:22
	 */
	@Transactional
	@Override
	public Integer setDistCompRealAdmin(BaseMapParam param) {
		Integer res = 0;
		Map<String, Object> pMap = param.getMap();
		AgencyFunCompReal agencyFunCompReal = BeanUtil.map2Bean(pMap, AgencyFunCompReal.class);
		if (null == agencyFunCompReal.getDevloperId()) { // 新建
			res = agencyFunCompRealMapper.insertSelective(agencyFunCompReal);
		} else {
			List<AgencyFunUsers> resList = agencyFunUsersMapper.selectByCondition(pMap);
			if(null != resList && resList.size() > 0) {
				res = -1;
			}else {
				agencyFunCompReal.setCityId(param.getInteger("cityId").shortValue());
				agencyFunCompReal.setErpCompId(param.getInteger("compId"));
				res = agencyFunCompRealMapper.updateByPrimaryKeySelective(agencyFunCompReal);
			}
		}
		return res;
	}

	/**
	 * @TODO 查询楼盘开发商详情信息
	 * @author lcb
	 * @2016-9-28 上午10:51:30
	 */
	@Override
	public AgencyFunCompReal getFunCompRealInfo(BaseMapParam param) {
		AgencyFunCompReal agencyFunCompReal = new AgencyFunCompReal();
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		List<AgencyFunCompReal> resList = agencyFunCompRealMapper.selectByCondition(pMap);
		if(null != resList && resList.size() > 0) {
			agencyFunCompReal = resList.get(0);
		}
		return agencyFunCompReal;
	}
	
	
}
