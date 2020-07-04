package com.myfun.service.business.agencydb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.framework.utils.CommonUtil;
import com.myfun.repository.admindb.po.AdminCrmUser;
import com.myfun.repository.agencydb.dao.AgencyBuildingInfoMapper;
import com.myfun.repository.agencydb.dao.AgencyCooperationRuleMapper;
import com.myfun.repository.agencydb.dao.AgencyFunCustDealMapper;
import com.myfun.repository.agencydb.dao.AgencyFunCustMapper;
import com.myfun.repository.agencydb.dao.AgencyFunUsersMapper;
import com.myfun.repository.agencydb.dto.AgencyBuildingInfoDto;
import com.myfun.repository.agencydb.param.AgencyBuildingInfo4AddParam;
import com.myfun.repository.agencydb.param.AgencyBuildingInfoParam4Erp;
import com.myfun.repository.agencydb.po.AgencyBuildingInfo;
import com.myfun.repository.agencydb.po.AgencyBuildingInfoKey;
import com.myfun.repository.agencydb.po.AgencyCooperationRule;
import com.myfun.repository.agencydb.po.AgencyFunUsers;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBuildingInfoService;
import com.myfun.utils.BeanUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.KeyBean;
import com.myfun.utils.StringUtil;

@Service
public class AgencyBuildingInfoServiceImpl extends AbstractService<AgencyBuildingInfo, AgencyBuildingInfoKey>  implements AgencyBuildingInfoService {
	@Autowired
	AgencyBuildingInfoMapper agencyBuildingInfoMapper;
	@Autowired
	AgencyFunUsersMapper agencyFunUsersMapper;
	@Autowired
	AgencyCooperationRuleMapper agencyCooperationRuleMapper;
	@Autowired
	ErpFunUsersMapper funUsersMapper;
	@Autowired
	AgencyFunCustMapper agencyFunCustMapper;
	@Autowired
	AgencyFunCustDealMapper agencyFunCustDealMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBuildingInfoMapper;
	}

	/**
	 * 添加或者修改数据
	 * **/
	@Transactional
	@Override
	public Integer insertBuildInfo(AgencyBuildingInfo agencyBuildingInfo, AgencyCooperationRule agencyCooperationRule, AgencyBuildingInfo4AddParam extreParam, AdminCrmUser adminCrmUser) {
		Integer res= 0;
		agencyBuildingInfo.setOpenDate(DateUtil.StringToDate(extreParam.getOpenDateString(), "yyyy-MM-dd"));
		if(null != agencyBuildingInfo.getBuildId()) {
			// 修改处理排序
			if(!agencyBuildingInfo.getSeqNo().equals(extreParam.getOldSeqNo())) {
				Integer maxSeq = getMaxSeq(agencyBuildingInfo.getCityId()); // 数据最大排序
				Integer seqNo = agencyBuildingInfo.getSeqNo().intValue();
				if(null == maxSeq || maxSeq ==0){
					seqNo = 1;
				}else{
					Map<String, Object> paramMap = new HashMap<>();
					paramMap.put("cityId", agencyBuildingInfo.getCityId());
					paramMap.put("oldSeqNo", extreParam.getOldSeqNo());
					if(seqNo >= maxSeq){
						seqNo = maxSeq;
						// 桐城市其他的seq减一
						res = agencyBuildingInfoMapper.updateSeqSubOne(paramMap);
					}else{
						paramMap.put("seqNo", agencyBuildingInfo.getSeqNo());
						if(seqNo> extreParam.getOldSeqNo()){
							res = agencyBuildingInfoMapper.updateSeqSubOne(paramMap);
						}else{
							res = agencyBuildingInfoMapper.updateSeqAddOne(paramMap);
						}
					}
				}
			}
			// 更新楼盘信息
			res = agencyBuildingInfoMapper.updateByPrimaryKeySelective(agencyBuildingInfo);
			if(StringUtil.isBlank(extreParam.getOldLoginUid())){
				res = createAdmin(agencyBuildingInfo, extreParam);
			}else if(!extreParam.getLoginUid().equals(extreParam.getOldLoginUid()) && extreParam.getLoginUid().trim().length() == 11){
				editUser(agencyBuildingInfo, extreParam);
			}
			// 合同处理
			Map<String, Object> paramRuleMap = new HashMap<>();
			paramRuleMap.put("cityId", agencyBuildingInfo.getCityId());
			paramRuleMap.put("buildId", agencyBuildingInfo.getBuildId());
			AgencyCooperationRule resCooperationRule = agencyCooperationRuleMapper.selectRuleByBuildId(paramRuleMap);
			if(null != resCooperationRule) {
				 // 编辑
				agencyCooperationRuleMapper.updateByPrimaryKeySelective(agencyCooperationRule);
			}else {
				// 新增
				createCooperationRule(agencyBuildingInfo, agencyCooperationRule, adminCrmUser);
			}
			
		}else {
			// 新增楼盘信息
			agencyBuildingInfo.setCrmCompId(adminCrmUser.getCompId());
			agencyBuildingInfo.setCrmUserId(adminCrmUser.getUserId());
			//=======处理排序问题========== 
			agencyBuildingInfo.setSeqNo(seqDeal(agencyBuildingInfo));
			//================= 
			res = agencyBuildingInfoMapper.insertBuildInfo(agencyBuildingInfo); // 楼盘信息保存
			// 新增管理员
			res = createAdmin(agencyBuildingInfo, extreParam);
			// 合同处理
			res = createCooperationRule(agencyBuildingInfo, agencyCooperationRule, adminCrmUser);
		}
		return res;
	}

	private Integer editUser(AgencyBuildingInfo agencyBuildingInfo, AgencyBuildingInfo4AddParam exAddParam) {
		Integer res = 0;
		if(StringUtil.isNotBlank(exAddParam.getLoginUid(), exAddParam.getLoginPwd())) {
			KeyBean kb = new KeyBean();
			String loginPwd = kb.getkeyBeanofStr(exAddParam.getLoginPwd());
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("cMobile", exAddParam.getOldLoginUid());
			paramMap.put("cityId", agencyBuildingInfo.getCityId());
			paramMap.put("devloperId", agencyBuildingInfo.getDevloperId());
			paramMap.put("buildId", agencyBuildingInfo.getBuildId());
			paramMap.put("pMobile", exAddParam.getLoginUid());
			paramMap.put("pUserPwd", loginPwd);
			paramMap.put("pUserPosition", "BUILD_MANAGER");
			paramMap.put("pStatus", "1");
			res = agencyFunUsersMapper.updateByCondition(paramMap);
		}
		return res;
		//验证该手机号码是否被注册了
		
	}
	/**
	 * 新建合同
	 * **/
	private Integer createCooperationRule(AgencyBuildingInfo agencyBuildingInfo, AgencyCooperationRule agencyCooperationRule, AdminCrmUser adminCrmUser) {
		agencyCooperationRule.setCityId(agencyBuildingInfo.getCityId());
		agencyCooperationRule.setDeptId(null);
		agencyCooperationRule.setDevloperId(agencyBuildingInfo.getDevloperId());
		agencyCooperationRule.setBuildId(agencyBuildingInfo.getBuildId());
		agencyCooperationRule.setCreateUid(adminCrmUser.getUserId());
//		map.put("COMMISSION", request.getParameter("COMMISSION"));// 
		agencyCooperationRule.setCreationTime(new Date());
		return agencyCooperationRuleMapper.insertSelective(agencyCooperationRule);
	}
	@Override
	public AgencyBuildingInfo getBuildNameByCityIdAndBuildId(String cityId, String buildId) {
		AgencyBuildingInfo agencyBuildingInfo = agencyBuildingInfoMapper.getBuildNameByCityIdAndBuildId(cityId, buildId);
		return agencyBuildingInfo;
	}

	
	/**
	 * 创建用户账号
	 * **/
	private Integer createAdmin(AgencyBuildingInfo agencyBuildingInfo, AgencyBuildingInfo4AddParam extParam) {
		String loginUid = extParam.getLoginUid().trim();
		String loginPwd = extParam.getLoginPwd().trim();
		Integer cityId = agencyBuildingInfo.getCityId();
		Integer buildId = agencyBuildingInfo.getBuildId();
		Integer devloperId = agencyBuildingInfo.getDevloperId();
		//验证该手机号码是否被注册了
		KeyBean kb = new KeyBean();
		loginPwd = kb.getkeyBeanofStr(loginPwd);
		
		AgencyFunUsers funUsers = new AgencyFunUsers();
		funUsers.setUserName("项目经理");
		funUsers.setDevloperId(devloperId);
		funUsers.setDeptId(null);
		funUsers.setUserSex(true);
		funUsers.setCityId(new Short(cityId+""));
		funUsers.setBuildId(buildId);
		funUsers.setUserMobile("");
		funUsers.setUserMobile(loginUid);
		funUsers.setLoginPwd(loginPwd);
		funUsers.setLoginUid(loginUid);
		funUsers.setUserPosition("BUILD_MANAGER");
		funUsers.setUserStatus("1");
		return agencyFunUsersMapper.insertSelective(funUsers);
		
	}
	// 排序出
	private Integer seqDeal(AgencyBuildingInfo agencyBuildingInfo) {
		Integer maxSeq = getMaxSeq(agencyBuildingInfo.getCityId());
		Integer seq = agencyBuildingInfo.getSeqNo().intValue();
		if(null == maxSeq || maxSeq < 1) {
			seq = 1;
		}else {
			if(seq>maxSeq){
				seq = maxSeq + 1;
			}else{
				Map<String,Object> paramMap = new HashMap<>();
				paramMap.put("cityId", agencyBuildingInfo.getCityId());
				paramMap.put("seq", seq);
				agencyBuildingInfoMapper.updateSeqAdd(paramMap);
			}
		}
		return seq;
		
	}
	
	private Integer getMaxSeq(Integer cityId) {
		Map<String,Object> paramMap = new HashMap<>();
		paramMap.put("cityId", cityId);
		Integer maxSeq = agencyBuildingInfoMapper.getMaxSeq(paramMap);
		return maxSeq;
	}

	/**
	 * 获取详细楼盘信息
	 * **/
	@Override
	public AgencyBuildingInfoDto getBuildingInfo(Integer buildId) {
		// TODO Auto-generated method stub
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", buildId);
		return agencyBuildingInfoMapper.getBuildingInfo(pMap);
	}

	@Override
	public AgencyCooperationRule getCooperationRule(Integer buildId, Integer cityId) {
		// TODO Auto-generated method stub
		Map<String, Object> paramMap = new HashMap<>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		return agencyCooperationRuleMapper.selectRuleByBuildId(paramMap);
	}

	/**
	 * @TODO 楼盘分销查询楼盘列表
	 * @author lcb
	 * 
	 */
	@Override
	public PageInfo<AgencyBuildingInfoDto> getDistBuildListOffIndex(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("CITY_ID", param.getInteger("cityId"));
		pMap.put("COMP_NO", param.getString("compNo"));
		pMap.put("COMP_ID", param.getInteger("compId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyBuildingInfoDto> resList = agencyBuildingInfoMapper.getDistBuildingList(pMap);
		for (AgencyBuildingInfoDto agency : resList) {
			String photoAddr = agency.getPhotoAddr();
			agency.setPhotoAddr(CommonUtil.getHousePhoto(photoAddr));
		}
		return new PageInfo<AgencyBuildingInfoDto>(resList);
	}

	/**
	 * @TODO 公司相关楼盘数据
	 * @author lcb
	 * @2016-9-5 上午10:32:44
	 */
	@Override
	public List<AgencyBuildingInfo> getDistBuildByComp(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		pMap.put("compNo", param.getString("compNo"));
		pMap.put("compId", param.getInteger("compId"));
		return agencyBuildingInfoMapper.getDistBuildByComp(pMap);
	}

	/**
	 * @TODO 分销楼盘详情
	 * @author lcb
	 * @2016-9-24 下午3:46:32
	 */
	@Override
	public AgencyBuildingInfoDto getBuildInfoDetailed(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		AgencyBuildingInfoDto agencyBuildingInfoDto = new AgencyBuildingInfoDto();
		if("1".equals(pMap.get("needRule"))) { // 老版本预留的 
			agencyBuildingInfoDto = agencyBuildingInfoMapper.getBuildInfoDetailed(pMap);
		}else {
			agencyBuildingInfoDto = agencyBuildingInfoMapper.getBuildInfoDetailed(pMap);
		}
		// 查询楼盘管理员基本信息,老版本是查全部字段.这里先查询基本字段,到时考虑不全的字段临时加
		if(null != agencyBuildingInfoDto && StringUtils.isNotBlank(agencyBuildingInfoDto.getBuildingAdmin())) {
			ErpFunUsers erpFunUsers = funUsersMapper.getFunUsersBaseInfo(Integer.valueOf(agencyBuildingInfoDto.getBuildingAdmin()), agencyBuildingInfoDto.getCityId());
			if(null != erpFunUsers) {
				agencyBuildingInfoDto.setBuildingAdminName(erpFunUsers.getUserName());
				agencyBuildingInfoDto.setDeptId(erpFunUsers.getDeptId());
			}
		}
		Integer draw = agencyBuildingInfoDto.getDraw();
		if (null == draw) {
			agencyBuildingInfoDto.setDraw(0);
		}
		return agencyBuildingInfoDto;
	}

	/**
	 * @TODO 分销楼盘列表
	 * @author lcb
	 * @2016-9-27 下午1:59:42
	 */
	@Override
	public PageInfo<AgencyBuildingInfoDto> getBuildInfoList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("erpCompId",param.getInteger("compId"));
		pMap.put("cityId",param.getInteger("cityId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		// 查询主体数据
		List<AgencyBuildingInfoDto> resList = agencyBuildingInfoMapper.getBuildInfoList(pMap);
		
		// 处理时间
		pMap.put("startTime", pMap.get("startTime")+" 00:00:00");
		pMap.put("endTime", pMap.get("endTime")+" 23:59:59");
		for (AgencyBuildingInfoDto agencyBuildingInfoDto : resList) {
			// 查询参数经纪人数
			List<Map<String, String>> count= agencyFunCustMapper.getBorkerCount(pMap);
			// 报备、带看、认购、结佣
			Map<String, String> daiKanCount = agencyFunCustDealMapper.daiKanCount(pMap);
			// 已结佣金
			agencyBuildingInfoDto.setParticipatingBroker(count.size());
			agencyBuildingInfoDto.setSettledCommission(null != daiKanCount.get("SETTLED_COMMISSION") ? daiKanCount.get("SETTLED_COMMISSION") : "0");
			List<Map<String, String>> yongjin = agencyFunCustMapper.getFinishedFee(pMap);
			for (Map<String, String> map : yongjin) {
				String custNumber = map.get("custNumber");
				String custStatus = map.get("CUST_STATUS");
				if ("1".equals(custStatus)) {
					agencyBuildingInfoDto.setReport(StringUtils.isNotBlank(custNumber) ?custNumber:"0");
				} else if ("3".equals(custStatus)) {
					agencyBuildingInfoDto.setSee(StringUtils.isNotBlank(custNumber) ?custNumber:"0");
				} else if ("4".equals(custStatus)) {
					agencyBuildingInfoDto.setSubScription(StringUtils.isNotBlank(custNumber) ?custNumber:"0");
				} else if ("5".equals(custStatus)) {
					agencyBuildingInfoDto.setCommissionJunction(StringUtils.isNotBlank(custNumber) ?custNumber:"0");
				}
			}
		}
		return new PageInfo<>(resList);
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-28 上午11:21:19
	 */
	@Override
	public Integer updateDistBuildstatus(BaseMapParam param) {
		AgencyBuildingInfo agencyBuildingInfo = new AgencyBuildingInfo();
		agencyBuildingInfo.setUpdateTime(new Date());
		return agencyBuildingInfoMapper.updateByPrimaryKeySelective(agencyBuildingInfo);
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-28 上午11:29:46
	 */
	@Transactional
	@Override
	public Integer addEditBuildInfo(BaseMapParam param) throws Exception{
		Map<String, Object> pMap = param.getMap();
		AgencyBuildingInfoParam4Erp agencyBuildingInfo = BeanUtil.map2Bean(pMap, AgencyBuildingInfoParam4Erp.class);
		AgencyFunUsers agencyFunUsers = agencyBuildingInfo.getAgencyFunUsers();
		AgencyCooperationRule cooperationPo = agencyBuildingInfo.getAgencyCooperationRule();
		Integer buildId = null;
		if (null != agencyBuildingInfo.getBuildId()) {
			// 新增楼盘
			buildId = createAgencyBuildInfo(agencyBuildingInfo, agencyFunUsers, cooperationPo, param);
		} else {
			// 修改楼盘
			updateBuildInfo(agencyBuildingInfo, agencyFunUsers, cooperationPo, param);
		}
		List<Map<String,String>> list = new ArrayList<Map<String,String>>();
		if (null != buildId) {
			Map<String,String> map = new HashMap<String,String>();
			map.put("BUILD_ID", buildId+"");
			list.add(map);
		}
		return null;
	}
	
	private Integer createAgencyBuildInfo(AgencyBuildingInfoParam4Erp agencyBuildingInfoErp, AgencyFunUsers agencyFunUsers,
			AgencyCooperationRule cooperationPo,BaseMapParam param) throws Exception {
		AgencyBuildingInfo agencyBuildingInfo = new AgencyBuildingInfo();
		org.apache.commons.beanutils.BeanUtils.copyProperties(agencyBuildingInfo, agencyBuildingInfoErp);
		// 新增楼盘信息
		agencyBuildingInfo.setCityId(param.getInteger("cityId"));
		agencyBuildingInfo.setProvinceId(param.getInteger("provinceId"));
		agencyBuildingInfo.setDevloperCityId(param.getInteger("cityId"));
		agencyBuildingInfo.setUserId(param.getInteger("userId"));
		agencyBuildingInfo.setErpCompId(param.getInteger("compId"));
		agencyBuildingInfo.setErpCompNo(param.getString("compNo"));
		agencyBuildingInfo.setEditFlag(new Byte("0"));
		agencyBuildingInfo.setSystemFlag(true);
		agencyBuildingInfo.setCreateTime(new Date());
		String seq = agencyBuildingInfo.getSeqNo().toString();
		String oldSeq = agencyBuildingInfoErp.getOldSeqNo();
		Integer seqNo = 0;
		int oldSeqNo = 0;
		if (StringUtils.isNotBlank(seq)) {
			seqNo = Integer.valueOf(seq);
		}
		if (StringUtils.isNotBlank(oldSeq)) {
			oldSeqNo = Integer.valueOf(oldSeq);
		}
		if (seqNo != oldSeqNo) {
			AgencyBuildingInfo buildingInfo = agencyBuildingInfoMapper.selectMaxSeq(param.getInteger("cityId"));
			if (null == buildingInfo) {
				seqNo = 1;
				agencyBuildingInfo.setSeqNo(seqNo);
			} else {
				int maxSeqNo = buildingInfo.getSeqNo().intValue();
				if (seqNo > maxSeqNo) {
					seqNo = maxSeqNo + 1;
					agencyBuildingInfo.setSeqNo(seqNo);
				} else {
					agencyBuildingInfoMapper.updateAddSeqNo(param.getInteger("cityId"), seqNo, null);
				}
			}
		}
		Integer res = agencyBuildingInfoMapper.insertSelective(agencyBuildingInfo);

		// 创建合作规则
		cooperationPo.setCityId(param.getInteger("cityId"));
		cooperationPo.setDeptId(param.getInteger("deptId"));
		cooperationPo.setCreateUid(param.getInteger("userId"));
		cooperationPo.setBuildId(agencyBuildingInfo.getBuildId());
		cooperationPo.setCreationTime(new Date());
		cooperationPo.setBandReward(Integer.valueOf(cooperationPo.getBandSaw()));
		cooperationPo.setBandPayment(0);
		agencyCooperationRuleMapper.insertSelective(cooperationPo);
		return agencyBuildingInfo.getBuildId();
	}
	
	private void updateBuildInfo(AgencyBuildingInfoParam4Erp buildPO, AgencyFunUsers usersPo, 
			AgencyCooperationRule cooperationPo, BaseMapParam param) throws Exception {
		AgencyBuildingInfo agencyBuildingInfo = new AgencyBuildingInfo();
		org.apache.commons.beanutils.BeanUtils.copyProperties(agencyBuildingInfo, buildPO);
//		String id = getString("ID"); // 合作规则id
		Integer cityId = param.getInteger("cityId");
		String seq = agencyBuildingInfo.getSeqNo().toString();
		String oldSeq = buildPO.getOldSeqNo();
		Integer seqNo = 0;
		Integer oldSeqNo = 0;
		if (StringUtils.isNotBlank(seq)) {
			seqNo = Integer.parseInt(seq);
		}
		if (StringUtils.isNotBlank(oldSeq)) {
			oldSeqNo = Integer.parseInt(oldSeq);
		}
		if (seqNo != oldSeqNo) {
			int maxSeqNo = 1;
			AgencyBuildingInfo buildingInfo = agencyBuildingInfoMapper.selectMaxSeq(param.getInteger("cityId"));
			if (null == buildingInfo) {
				seqNo = 1;
				agencyBuildingInfo.setSeqNo(seqNo);
			} else {
				maxSeqNo = buildingInfo.getSeqNo().intValue();
				if (seqNo >= maxSeqNo) {
					seqNo = maxSeqNo;
					agencyBuildingInfoMapper.updateSubSeqNo(cityId, seqNo, null);
				} else {
					if (seqNo > oldSeqNo) {
						agencyBuildingInfoMapper.updateSubSeqNo(cityId, seqNo, oldSeqNo);
					} else {
						agencyBuildingInfoMapper.updateAddSeqNo(param.getInteger("cityId"), seqNo, oldSeqNo);
					}
				}
			}
		}
		// 修改楼盘信息
		buildPO.setUpdateTime(new Date());
		buildPO.setEditFlag(new Byte("1"));
		agencyBuildingInfoMapper.updateByPrimaryKeySelective(buildPO);
		// 修改合作规则
		if (null != cooperationPo.getId()) {
			cooperationPo.setBandReward(Integer.valueOf(cooperationPo.getBandSaw()));
			cooperationPo.setBandPayment(0);
			agencyCooperationRuleMapper.updateByPrimaryKeySelective(cooperationPo);
		}
	}
}
