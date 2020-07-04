package com.myfun.service.business.agencydb.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.admindb.dao.*;
import com.myfun.repository.admindb.po.*;
import com.myfun.repository.agencydb.dao.*;
import com.myfun.repository.agencydb.dto.*;
import com.myfun.repository.agencydb.param.AgencyFunCustParam;
import com.myfun.repository.agencydb.po.*;
import com.myfun.repository.erpdb.dao.ErpFunDeptsMapper;
import com.myfun.repository.erpdb.dao.ErpFunMsgMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunMsg;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunCustService;
import com.myfun.service.business.agencydb.AgencyFunCustTrackService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class AgencyFunCustServiceImpl extends AbstractService<AgencyFunCust, AgencyFunCustKey>  implements AgencyFunCustService {
	@Autowired
	AgencyFunCustMapper agencyFunCustMapper;
	@Autowired
	AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	AgencyBuildingInfoMapper agencyBuildingInfoMapper;
	@Autowired
	AgencyFunCustTrackMapper agencyFunCustTrackMapper;
	@Autowired
	AgencyFunCustDealMapper agencyFunCustDealMapper;
	@Autowired
	AgencyCooperationRuleMapper agencyCooperationRuleMapper;
	@Autowired
	AgencyBrokerCompRateMapper agencyBrokerCompRateMapper;
	@Autowired
	AgencySysParaMapper agencySysParaMapper;
	@Autowired
	AgencyFunRewardLogMapper agencyFunRewardLogMapper;
	@Autowired
	ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	AdminCrmBrokerTrackMapper adminCrmBrokerTrackMapper;
	@Autowired
	AdminSystemMessageMapper adminSystemMessageMapper;
	@Autowired
	AdminAppLoginMapper appLoginMapper;
	@Autowired
	AdminMsgPushMapper msgPushMapper;
	@Autowired
	ErpFunUsersMapper funUsersMapper;
	@Autowired
	ErpFunMsgMapper erpFunMsgMapper;
	@Autowired
	ErpFunDeptsMapper erpFunDeptsMapper;
	@Autowired
	AgencyFunAgencyAccountMapper agencyFunAgencyAccountMapper;
	@Autowired
	AgencyMyHftCustmapMapper agencyMyHftCustmapMapper;
	@Autowired
	AgencyFunCustTrackService agencyFunCustTrackService;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyFunCustMapper;
	}

	@Override
	public PageInfo<AgencyFunCustDto> getFunCustList(AgencyFunCustParam agencyFunCustParam) {
		PageHelper.startPage(agencyFunCustParam.getPageNum(), agencyFunCustParam.getPageSize(), true);
		List<AgencyFunCustDto> resList = agencyFunCustMapper.getFunCustList(agencyFunCustParam);
		listAgencyNameDeal(resList);
		PageInfo<AgencyFunCustDto> pageInfo = new PageInfo<>(resList);
		return pageInfo;
	}

	private void listAgencyNameDeal(List<AgencyFunCustDto> paramList) {
		if(null != paramList && paramList.size() > 0) {
			for (AgencyFunCustDto agencyFunCustDto : paramList) {
				AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(agencyFunCustDto.getArchiveId());
				if(null != adminFunArchive) {
					agencyFunCustDto.setAgencyName(adminFunArchive.getUserName());
					agencyFunCustDto.setAgencyMobile(adminFunArchive.getUserMobile());
				}
			}
		}
	}

	/**
	 * 详情查询
	 * **/
	@Override
	public AgencyFunCust getFunCusByCondition(Integer custId, Integer cityId) {
		AgencyFunCustKey agencyFunCustKey = new AgencyFunCustKey();
		agencyFunCustKey.setCityId(cityId.shortValue());
		agencyFunCustKey.setCustId(custId);
		AgencyFunCust agencyFunCust = agencyFunCustMapper.selectByPrimaryKey(agencyFunCustKey);
		return agencyFunCust;
	}
	@Override
	public AgencyFunCust getRecord(String custId) {
		return agencyFunCustMapper.getRecord(custId);
	}

	@Override
	public PageInfo<AgencyCommisionDto> getCommisionList(AgencyCommisionParam agencyCommisionParam) {
		PageHelper.startPage(agencyCommisionParam.getPageNum(), Const.PAGE_NUMBER, true);
		List<AgencyCommisionDto> list = agencyFunCustMapper.getCommisionList(agencyCommisionParam);
		return new PageInfo<>(list);
	}

	/**
	 * 统计
	 * **/
	@Override
	public AgencyFunCustCountDto getCountByBuildIdAndCityId(Integer buildId,Integer cityId, String dateTime) {
		AgencyFunCustCountDto agencyFunCustCountDto = null;
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("buildId", buildId);
		paramMap.put("cityId", cityId);
		if(StringUtil.isNotBlank(dateTime)) {
			dateTime = dateTime+"-01 00:00:00";
			String endDate = DateUtil.addMonth(dateTime, 1);
			paramMap.put("stratDate", dateTime);
			paramMap.put("endDate", endDate);
			agencyFunCustCountDto = agencyFunCustMapper.getFunCustCountWithTime(paramMap);
		}else{
			agencyFunCustCountDto = agencyFunCustMapper.getFunCustCount(paramMap);
			
		}
		return agencyFunCustCountDto;
	}

	@Override
	public AgencyFunCustDto getCommisionView(String cityId, String custId) {
		return agencyFunCustMapper.getCommisionView(cityId, custId);
	}

	@Transactional
	@Override
	public int saveComision(AdminCrmUser adminCrmUser, String cityId, String custId, String oldCustStatus, String custStatus, String paidAmount,
			String content, String custMobile) {
		AgencyFunCust up = new AgencyFunCust();
		up.setCustStatus(StringUtil.parseInteger(custStatus));
		up.setCityId(Short.valueOf(cityId));
		up.setCustId(StringUtil.parseInteger(custId));
		
		AgencyFunCustKey key = new AgencyFunCustKey();
		key.setCityId(Short.valueOf(cityId));
		key.setCustId(StringUtil.parseInteger(custId));;
		AgencyFunCust agencyFunCust = agencyFunCustMapper.selectByPrimaryKey(key);
		Integer archiveId = agencyFunCust.getArchiveId();
		String CUST_NAME = agencyFunCust.getCustName();
		short B_CITY_ID = agencyFunCust.getbCityId();
		Integer BUILD_ID = agencyFunCust.getBuildId();
		
		AgencyBuildingInfoKey bkey = new AgencyBuildingInfoKey();
		bkey.setBuildId(BUILD_ID);
		bkey.setCityId(StringUtil.parseInteger(String.valueOf(B_CITY_ID)));
		
		AgencyBuildingInfo agencyBuildingInfo = agencyBuildingInfoMapper.selectByPrimaryKey(bkey);
		String BUILD_NAME = agencyBuildingInfo.getBuildName();
		
		String TRACK_CONTENT = "";
		String CONTENT = "";
		String AGENCY_CONTENT = "";
		
		up.setTrackTime(new Date());
		if("0".equals(custStatus)){
			up.setCheckUid(999);
			up.setCheckTime(new Date());
			TRACK_CONTENT = "当日未通过审核，该客户无效。";
			
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】未通过审核，该客户【无效】，该客户无需带看。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】未通过审核，该客户【无效】，该客户无需带看。";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("2".equals(custStatus)){
			up.setCheckUid(999);
			up.setCheckTime(new Date());
			TRACK_CONTENT = "当日已通过审核，请尽快安排带看。";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】已通过审核，该客户有效，请尽快安排带看。";
			AGENCY_CONTENT = "您的【客户"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】已通过审核，该客户有效，请尽快安排带看。";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("3".equals(custStatus)){
			if(custMobile.trim().length() > 11){
				custMobile = custMobile.substring(0, 11);
			}
			// 更新带看与成交数
			updateNum(bkey);
			updateDaiKanRewards(custId, BUILD_ID, B_CITY_ID, cityId, archiveId);
			String _CUST_MOBILE = agencyFunCust.getCustMobile();
			if(!custMobile.equals("")){
				up.setCustMobile(custMobile);
				//带看后注销其他用户
				int ret = writeOffOtherCust(adminCrmUser.getUserId(), cityId, custMobile,_CUST_MOBILE,custId,BUILD_ID);
				if(ret != 1){
					return ret;
				}
			}
			up.setBandSawTime(new Date());
			TRACK_CONTENT = "当日确认该客户已带看，请配合跟进。";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】确认带看，请与置业顾问配合跟进。";
			AGENCY_CONTENT = "您的【客户"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认带看。";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("4".equals(custStatus)){
			//创建客户成交
			createCustDeal(cityId, custId, BUILD_ID);
			updateDealNUm(bkey);
			up.setDealTime(new Date());
			up.setApplyNext((byte)0);
			up.setUserApply((byte)0);
			TRACK_CONTENT = "当日确认该客户已认购，请及时结佣。";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】确认认购，请与置业顾问联系并确认及时结佣。";
			AGENCY_CONTENT = "您的【客户"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认认购";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("5".equals(custStatus)){//已结佣
			checkCustDeal(cityId, custId, B_CITY_ID,BUILD_ID, StringUtil.parseDouble(paidAmount), adminCrmUser.getUserId());
			up.setCommissionTime(new Date());
			up.setApplyNext((byte)0);
			up.setUserApply((byte)0);
			TRACK_CONTENT = "当日确认结佣";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认结佣，佣金金额为："+paidAmount+"元，请登录【好房通ERP-进入联动分销-我的联动】及时申请提现。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认结佣，佣金金额为："+paidAmount+"元";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("6".equals(custStatus)){
			backCommision(Integer.valueOf(cityId), custId, content, adminCrmUser.getUserId());
			TRACK_CONTENT = "当日确认退佣";
			up.setBackCommissionTime(new Date());
			up.setApplyNext((byte)0);
			up.setUserApply((byte)0);
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认退佣，该客户已确认退房。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】确认退佣，该客户已确认退房。";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("-1".equals(custStatus)){
			up.setCancelTime(new Date());
			TRACK_CONTENT = "当日撤销了该客户的认购。";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】撤消认购，该客户已退房，请与置业顾问联系并确认。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员"+adminCrmUser.getUserName()+"】撤消认购，该客户已退房，";
			//修改记录
			agencyFunCustMapper.updateByPrimaryKey(up);
		}else if("1".equals(custStatus)){
			TRACK_CONTENT = "当日重新报备了该客户。";
			CONTENT = "您的【客户:"+CUST_NAME+"】由【管理员:"+adminCrmUser.getUserName()+"】重新报备。";
			//修改记录
			agencyFunCustMapper.update(up);
		}
		
		//写跟进
		createTrack(Integer.valueOf(cityId), custId, TRACK_CONTENT, adminCrmUser.getUserId());
		return 1;
	}
	
	/**
	 * 写跟进
	 * @param cityId
	 * @param custId
	 * @param tRACK_CONTENT
	 */
	private void createTrack(Integer cityId, String custId, String trackContent, Integer userId) {
		AgencyFunCustTrack agencyFunCustTrack = new AgencyFunCustTrack();
		agencyFunCustTrack.setCityId(cityId.shortValue());
		agencyFunCustTrack.setCustId(StringUtil.parseInteger(custId));
		agencyFunCustTrack.setTrackType("管理员");
		agencyFunCustTrack.setCustSource((short)1);
		agencyFunCustTrack.setTrackContent(trackContent);
		agencyFunCustTrack.setTrackSource(Short.valueOf("1"));
		agencyFunCustTrack.setTrackUid(userId);
		agencyFunCustTrack.setTrackUname("管理员");
		agencyFunCustTrack.setTrackTime(new Date(0));
		
		agencyFunCustTrackMapper.insertSelective(agencyFunCustTrack);
	}

	/**
	 * 退佣
	 * @param cityId
	 * @param custId
	 * @param content
	 */
	private void backCommision(Integer cityId, String custId, String content, Integer userId) {
		AgencyFunCustDeal record = new AgencyFunCustDeal();
		record.setCityId(cityId.shortValue());
		record.setCustId(StringUtil.parseInteger(custId));
		record.setIsBackCommision((byte)1);
		record.setBackCommisionCause(content);
		record.setCheckUid(userId);
		record.setCheckTime(new Date());
		agencyFunCustDealMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 审核结佣
	 * @param cityId
	 * @param custId
	 * @param b_CITY_ID
	 * @param bUILD_ID
	 * @param parseDouble
	 */
	private void checkCustDeal(String cityId, String custId, short bCtyTd, Integer buildId, Double paidAmount, Integer userId) {
		AgencyFunCustDeal record = new AgencyFunCustDeal();
		record.setCityId(Short.valueOf(cityId));
		record.setCustId(StringUtil.parseInteger(custId));
		record.setCheckUid(userId);
		record.setCheckStatus(Short.valueOf("1"));
		//看看是不是还要给成交奖励
		boolean hasRewards = true;
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("buildId", buildId);
		pMap.put("cityId", cityId);
		AgencyCooperationRule agencyCooperationRule = agencyCooperationRuleMapper.selectRuleByBuildId(pMap);
		Integer dealReward = null;
		if(null != agencyCooperationRule){
			dealReward = agencyCooperationRule.getDealReward();
		}
		if(null != dealReward && 0 != dealReward){
			//查询是否有成交奖励名额
			AgencyCooperationRuleDto agencyCooperationRuleDto = agencyCooperationRuleMapper.selectDealNumAndDealRewardsNum(bCtyTd, buildId);
			if(!"".equals(agencyCooperationRuleDto.getDealRewardsNum()) &&
					!"0".equals(agencyCooperationRuleDto.getDealRewardsNum()) && 
					!"".equals(agencyCooperationRuleDto.getDealNum()) && StringUtil.parseInteger(agencyCooperationRuleDto.getDealRewardsNum()) 
					<= StringUtil.parseInteger(agencyCooperationRuleDto.getDealNum())){
				hasRewards = false;
			}
		}
		//查询用户信息
		AgencyFunCustKey agencyFunCustKey = new AgencyFunCustKey();
		agencyFunCustKey.setCityId(Short.valueOf(cityId));
		agencyFunCustKey.setCustId(StringUtil.parseInteger(custId));
		AgencyFunCust agencyFunCust = agencyFunCustMapper.selectByPrimaryKey(agencyFunCustKey);
		double brokerRate = 0;
		double compRate = 0;
		Integer compId = agencyFunCust.getCompId();
		
		AgencyBrokerCompRateKey agencyBrokerCompRateKey = new AgencyBrokerCompRateKey();
		agencyBrokerCompRateKey.setCityId(StringUtil.parseInteger(cityId));
		agencyBrokerCompRateKey.setCompId(compId);
		AgencyBrokerCompRate agencyBrokerCompRate = agencyBrokerCompRateMapper.selectByPrimaryKey(agencyBrokerCompRateKey);
		if(agencyBrokerCompRate == null){
			String rate = agencySysParaMapper.selectByPrimaryKey("PAID_RATE").getParamValue();
			compRate = StringUtil.parseDouble(rate);
		}else{
			compRate = StringUtil.parseDouble(String.valueOf(agencyBrokerCompRate.getPaidRate()));
		}
		brokerRate = 100 - compRate;
		double brokerAmount = paidAmount*brokerRate/100;
		double compAmount = paidAmount*brokerRate/100;
		record.setBrokerAmount(BigDecimal.valueOf(brokerAmount));
		record.setCompAmount(BigDecimal.valueOf(compAmount));
		record.setCompRate(BigDecimal.valueOf(compRate));
		record.setPaidAmount(BigDecimal.valueOf(paidAmount));
		if(hasRewards){
			record.setBrokerRewards(BigDecimal.valueOf(dealReward));
		}
		agencyFunCustDealMapper.updateByPrimaryKeySelective(record);
	}

	/**
	 * 修改成交数量
	 * @param bkey
	 */
	private void updateDealNUm(AgencyBuildingInfoKey bkey) {
		AgencyBuildingInfo agencyBuildingInfo = new AgencyBuildingInfo();
		agencyBuildingInfo.setCityId(bkey.getCityId());
		agencyBuildingInfo.setBuildId(bkey.getBuildId());;
		agencyFunCustMapper.updateDealNUm(bkey.getBuildId(), bkey.getCityId());
	}

	/**
	 * 创建客户成交
	 * @param cityId
	 * @param custId
	 * @param bUILD_ID
	 */
	private void createCustDeal(String cityId, String custId, Integer buildId) {
		int count = agencyFunCustDealMapper.count(cityId, custId);
		AgencyFunCustKey agencyFunCustKey = new AgencyFunCustKey();
		agencyFunCustKey.setCityId(Short.valueOf(cityId));
		agencyFunCustKey.setCustId(StringUtil.parseInteger(custId));
		AgencyFunCust agencyFunCust = agencyFunCustMapper.selectByPrimaryKey(agencyFunCustKey);
		short bCityId = agencyFunCust.getbCityId();
		Integer compId = agencyFunCust.getCompId();
		Integer deptId = agencyFunCust.getDeptId();
		Integer userId = agencyFunCust.getUserId();
		Integer archiveId = agencyFunCust.getArchiveId();
		AgencyFunCustDeal agencyFunCustDeal = new AgencyFunCustDeal();
		agencyFunCustDeal.setCityId(Short.valueOf(cityId));
		agencyFunCustDeal.setbCityId(bCityId);
		agencyFunCustDeal.setBuildId(buildId);
		agencyFunCustDeal.setContactNo("");
		agencyFunCustDeal.setCustId(StringUtil.parseInteger(custId));
		agencyFunCustDeal.setCompId(compId);
		agencyFunCustDeal.setDeptId(deptId);
		agencyFunCustDeal.setUserId(userId);
		agencyFunCustDeal.setArchiveId(archiveId);
		agencyFunCustDeal.setCustSource((byte)1);
		agencyFunCustDeal.setHouseNo("");
		agencyFunCustDeal.setHouseUsage("");
		agencyFunCustDeal.setContactAmount(BigDecimal.valueOf(0));
		agencyFunCustDeal.setContactTime(new Date());
		agencyFunCustDeal.setCreatorUid(999);
		agencyFunCustDeal.setCheckStatus((short)0);
		agencyFunCustDeal.setPaidStatus((short)0);
		agencyFunCustDeal.setBrokerStatus((short)0);
		agencyFunCustDeal.setIsBackCommision((byte)0);
		if(count == 0){
			agencyFunCustDealMapper.insertSelective(agencyFunCustDeal);
		}else{
			agencyFunCustDealMapper.updateByityIdAndCustId(agencyFunCustDeal);
		}
	}

	/**
	 * 带看后注销其他用户
	 * @param custMobile
	 * @param _CUST_MOBILE
	 * @param custId
	 * @param bUILD_ID
	 */
	private int writeOffOtherCust(Integer userId, String cityId, String custMobile, String _custmobile, String custId, Integer buildId) {
		AgencyFunCustKey key = new AgencyFunCustKey();
		key.setCityId(Short.valueOf(cityId));
		key.setCustId(StringUtil.parseInteger(custId));
		AgencyFunCust agencyFunCust = agencyFunCustMapper.selectByPrimaryKey(key);
		if(agencyFunCust.getCustStatus() > 2){
			return -1;
		}
		int count = agencyFunCustMapper.count(custMobile, buildId);
		if(count > 0){
			return -2;
		}
		short bCityId = agencyFunCust.getbCityId();
		//查询
		String flag = "0";
		int size = 11 - _custmobile.replaceAll("\\*", "").length();
		for(int i = size; i > 0; i --){
			String nextMobile = transferMobile(custMobile.substring(0, 11 - i));
			flag = "1";
		}
		List<AgencyFunCust> list = agencyFunCustMapper.getRecords(bCityId, buildId, custId, flag, custMobile, _custmobile);
		for(AgencyFunCust cust : list){
			Integer archiveId = cust.getArchiveId();
			AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
			String agentName = adminFunArchive.getUserName();
			String trackContent = "您报备的【"+cust.getCustName()+"】客户已由经纪人【"+agentName+"】于"+new Date()+" 完成带看，该客户已过带看期，请及时关注。";
			createTrack(cust.getCityId().intValue(), String.valueOf(cust.getCustId()), trackContent, userId);
		}
		
		AgencyFunCust record = new AgencyFunCust();
		agencyFunCustMapper.updateCustStatus(bCityId, buildId, custId, flag, custMobile, _custmobile);
		return 1;
	}
	
	/**
	 * 将电话号码补为星号
	 * @param mobile
	 */
	private String transferMobile(String mobile){
		int size = 11 - mobile.length();
		for(int i = 0; i < size; i ++){
			mobile += "*";
		}
		return mobile;
	}
	
	/**
	 * 检查该楼盘是否有带看奖励，如果有就把奖励发放到经纪人上去
	 * @param custId
	 * @param bUILD_ID
	 * @param b_CITY_ID
	 * @param cityId
	 * @param archiveId
	 */
	private void updateDaiKanRewards(String custId, Integer buildId, short bcityId, String cityId,
			Integer archiveId) {
		//将带看可以奖励多少钱，多少个带看具有奖励查询出来先
		AgencyCooperationRule agencyCooperationRule = agencyCooperationRuleMapper.selectByCityIdAndBuildId(bcityId, buildId);
		Integer bandRewardNum = agencyCooperationRule.getBandRewardNum();
		Integer bandreward = agencyCooperationRule.getBandReward();
		Integer bandpayment = agencyCooperationRule.getBandPayment();
		//再统计一下有多少个经纪人已经拿到了带看奖励的
		int count = agencyFunRewardLogMapper.count(bcityId, buildId, "2");
		if(bandreward == null || bandreward == 0 ||
				bandRewardNum == null || bandRewardNum == -1 || 
				(count >= bandRewardNum && bandRewardNum != 0)){
			return;
		}
		//有带看奖励的话，就把带看标记设置为有
		AgencyFunRewardLog agencyFunRewardLog = new AgencyFunRewardLog();
		if(bandpayment == 1){
			//系统发放的话，就有服务程序来计算费用
			agencyFunRewardLog.setStatus((byte)0);
		}else{
			//现场发放的话，直接改为已领取
			agencyFunRewardLog.setStatus((byte)1);
		}
		agencyFunRewardLog.setCityId(Short.valueOf(cityId));
		agencyFunRewardLog.setbCityId(Short.valueOf(bcityId));
		agencyFunRewardLog.setCustId(StringUtil.parseInteger(custId));
		agencyFunRewardLog.setBuildId(buildId);
		agencyFunRewardLog.setRewards(BigDecimal.valueOf(bandreward));
		agencyFunRewardLog.setType((byte)1);
		agencyFunRewardLog.setCreationTime(new Date(0));
		agencyFunRewardLog.setArchiveId(archiveId);
		//更新FUN_REWARD_LOG状态
		agencyFunRewardLogMapper.updateStatus("2", cityId, custId, buildId);//2 无效
		//x新增
		agencyFunRewardLogMapper.insertSelective(agencyFunRewardLog);
	}

	/**
	 *  更新带看与成交数
	 * @param string
	 * @param bUILD_ID
	 */
	private void updateNum(AgencyBuildingInfoKey key) {
		AgencyBuildingInfo agencyBuildingInfo = new AgencyBuildingInfo();
		agencyBuildingInfo.setCityId(key.getCityId());
		agencyBuildingInfo.setBuildId(key.getBuildId());;
		agencyFunCustMapper.updateNum(key.getBuildId(), key.getCityId());
	}

	/**
	 * @TODO 新房联动我的客户->查询数据
	 * @author lcb
	 * @2016-8-31 下午6:18:16
	 */
	@Override
	public Map<String, String> getDistCountCustInfo(BaseMapParam param) {
		// 已报备 已审核 已带看 已认购
		Map<String, String> resMap = agencyFunCustMapper.getDistCountCustInfo(param.getInteger("archiveId"));
		// 查询百分比
		// 查询成交数
		Integer res = agencyFunCustMapper.getSuccessCount(param.getInteger("archiveId"));
		Map<String, Object> resMap2 = agencyFunCustMapper.getCountCustInfo(res);
		String sumNum = resMap2.get("SUM_NUM") +"";//总人数
		String minNum = resMap2.get("MIN_NUM") +"";//小于的
		double runkNum = Double.parseDouble(minNum) / Double.parseDouble(sumNum);
		NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        String num = nf.format(runkNum);
        resMap.put("archiveRank", num);
		return resMap;
	}

	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-2 下午5:46:08
	 */
	@Override
	public Map<String, String> getDistCountOfferToBuy(BaseMapParam param) {
		Map<String,String> paramMap = new LinkedHashMap<String,String>();
		Calendar calendar = Calendar.getInstance();
		Date startTime = calendar.getTime();
		paramMap.put(DateUtil.formatDateTimetoString(startTime, "yyyy-MM"), "0");
		for (int i = 0; i < 11; i++) {
			calendar.add(Calendar.MONTH, -1);
			paramMap.put(DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM"), "0");
		}
		List<Map<String, String>> resList = agencyFunCustMapper.getDistCountOfferToBuy(param.getInteger("archiveId"),DateUtil.DateToString(startTime,"yyyy-MM-01"),
				DateUtil.DateToString(startTime,"yyyy-MM-dd 23:59:59"));
		for (Map<String, String> map : resList) {
			if(!map.isEmpty()) {
				String month = map.get("MONTH");
				String num = map.get("NUM");
				if(paramMap.containsKey(month)){
					paramMap.put(month, num);
				}
			}
		}
		return paramMap;
	}

	/**
	 * @TODO 查询报备客户
	 * @author lcb
	 * @2016-9-5 上午10:47:01
	 */
	@Override
	public List<AgencyFunCust> getDistCustList(BaseMapParam param) {
		
		return null;
	}

	/**
	 * @TODO 查询我的佣金数据
	 * @author lcb
	 * @2016-9-5 下午2:39:56
	 */
	@Override
	public Map<String, String> getDistCountBorkerAmmount(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("compId", param.getInteger("compId"));
		pMap.put("archiveId",param.getInteger("archiveId"));
		// 佣金数据
		Map<String, String> resMap = agencyFunCustDealMapper.getDistCountBorkerAmmount(pMap);
		// 年收入
		String m = agencyFunCustDealMapper.getCountCustInfo(param.getInteger("archiveId"));
		Map<String, Integer> r = agencyFunCustDealMapper.getCountCustPercentInfo(m);
		String sumNum = r.get("SUM_NUM")+"";//总人数
		String minNum = r.get("MIN_NUM")+"";//小于的
		double runkNum = Double.parseDouble(minNum) / Double.parseDouble(sumNum);
		NumberFormat nf = NumberFormat.getPercentInstance();
        nf.setMaximumFractionDigits(1);//这个1的意识是保存结果到小数点后几位，但是特别声明：这个结果已经先＊100了。
        String num = nf.format(runkNum);
		resMap.put("moneyRank", num);
		return resMap;
	}

	/**
	 * @TODO 获取近一年的收入趋势
	 * @author lcb
	 * @2016-9-7 上午9:49:49
	 */
	@Override
	public Map<String, String> getDistCountMoneyOfYear(BaseMapParam param) {
		Map<String,String> paramMap = new LinkedHashMap<String,String>();
		Calendar calendar = Calendar.getInstance();
		Date startTime = calendar.getTime();
		paramMap.put(DateUtil.formatDateTimetoString(startTime, "yyyy-MM"), "0");
		for (int i = 0; i < 11; i++) {
			calendar.add(Calendar.MONTH, -1);
			paramMap.put(DateUtil.formatDateTimetoString(calendar.getTime(), "yyyy-MM"), "0");
		}
		List<Map<String, String>> resList = agencyFunCustDealMapper.getCountViewMap(param.getInteger("archiveId"),DateUtil.DateToString(startTime,"yyyy-MM-01"),
				DateUtil.DateToString(startTime,"yyyy-MM-dd 23:59:59"));
		for(int i = 0;i<resList.size();i++){
			Map<String, String> rMap =  resList.get(i);
			String month = rMap.get("MONTH");
			String money = rMap.get("MONEY");
			DecimalFormat df = new DecimalFormat();
			df.applyPattern("##0.##");
			money = df.format(Double.parseDouble(money));
			if(paramMap.containsKey(month)){
				paramMap.put(month, money);
			}
		}
		return paramMap;
	}

	
	/**
	 * @TODO 查询我的佣金,个人佣金记录明细列表
	 * @author lcb
	 * @throws Exception 
	 * @2016-9-7 上午10:29:25
	 */
	@Override
	public Map<String, Object> getDistPersonalData(BaseMapParam param) {
		Map<String, Object> rMap = new HashMap<>();
		Map<String, Object> pMap = param.getMap(); // 参数公用Map
		List<String> rUserIdsList = getPersonalCommList(param, pMap);
		List<AgencyFunCustDealDto> resList = new ArrayList<>();
		if((null != pMap.get("areaId") || null != pMap.get("regId") ||
				null != pMap.get("grId")) && rUserIdsList.size() != 0) {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			resList = agencyFunCustDealMapper.getPersonalCommList(pMap);
		}else if((null == pMap.get("areaId") && null == pMap.get("regId") &&
				null == pMap.get("grId"))){
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			resList = agencyFunCustDealMapper.getPersonalCommList(pMap);
		}
		List<Map<String, String>> commCountInfo = getPersonalCommCountInfo(pMap);
		rMap.put("PERCUST_DEAL_COUNT", commCountInfo);
		rMap.put("PERCUST_DEAL_LIST", new PageInfo<>(resList));
		return rMap;
	}
	
	public List<Map<String, String>> getPersonalCommCountInfo(Map<String, Object> pMap) {
		return agencyFunCustDealMapper.getCustDealListForPersonalCommList(pMap);
	}
	
	/**
	 * @TODO
	 * @author lcb
	 * @2016-9-7 上午10:30:59
	 */
	private List<String> getPersonalCommList(BaseMapParam param, Map<String, Object> pMap) {
		pMap.put("compId", param.getInteger("compId"));
		pMap.put("archiveId",param.getInteger("archiveId"));
		pMap.put("cityId", param.getInteger("cityId"));
		if (null != pMap.get("startTime")) {
			pMap.put("startTime", pMap.get("startTime") + "00:00:00");
		}
		if (null != pMap.get("endTime")) {
			pMap.put("endTime", pMap.get("endTime") + "23:59:59");
		}
		List<String> rUserIdsList = new ArrayList<>();
		// 查询userId....
		if (null != pMap.get("areaId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), pMap.get("areaId") + "",
					param.getInteger("compId"), null, null);
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
				return new ArrayList<>();
			}else{
				pMap.put("userId", rUserIdsList);
			}
		}
		if (null != pMap.get("regId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), null, param.getInteger("compId"),
					pMap.get("regId") + "", null);
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
				return new ArrayList<>();
			}else{
				pMap.put("userId", rUserIdsList);
			}
		}
		if (null != pMap.get("grId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), null, param.getInteger("compId"), null,
					pMap.get("grId") + "");
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
				return new ArrayList<>();
			}else{
				pMap.put("userId", rUserIdsList);
			}
		}
		return rUserIdsList;
	}

	/**
	 * @TODO 佣金明细
	 * @author lcb
	 * @2016-9-19 下午4:53:39
	 */
	@Override
	public Map<String, Object> getDistCustDealList(BaseMapParam param) {
		Map<String, Object> rMap = new HashMap<>();
		List<AgencyFunCustDealDto> resList = new ArrayList<>();
		Map<String, Object> pMap = param.getMap(); // 参数公用Map
		List<String> rUserIdsList = getPersonalCommList(param, pMap);
		
		if((null != pMap.get("areaId") || null != pMap.get("regId") || null != pMap.get("grId"))) {
			if(rUserIdsList.size() != 0) {
				pMap.put("userIds", rUserIdsList);
				PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
				resList = agencyFunCustDealMapper.getCustDealListDetail(pMap);
			}
		}else {
			PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
			resList = agencyFunCustDealMapper.getCustDealListDetail(pMap);
		}
		List<Map<String, String>> countList = agencyFunCustDealMapper.getCountCustDealOfStatus(pMap);
		rMap.put("CUST_DEAL_COUNT", countList);
		rMap.put("CUST_DEAL_LIST", resList);
		return rMap;
	}

	/**
	 * @TODO 分销客户列表
	 * @author lcb
	 * @2016-9-21 下午5:19:44
	 */
	@Override
	public PageInfo<AgencyFunCustDto> getFunCustList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		pMap.put("compId",  param.getInteger("compId"));
		pMap.put("deptId", param.getInteger("deptId"));
		List<String> rUserIdsList = new ArrayList<>();
		if (null != pMap.get("areaId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), pMap.get("areaId") + "",
					param.getInteger("compId"), null, null);
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		if (null != pMap.get("regId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), null,  param.getInteger("compId"),
					pMap.get("regId") + "", null);
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		if (null != pMap.get("grId")) {
			rUserIdsList = erpFunUsersMapper.getFunUserIds(
					param.getInteger("cityId"), null,  param.getInteger("compId"), null,
					pMap.get("grId") + "");
			if (null == rUserIdsList || rUserIdsList.size() == 0) {
			}else{
				pMap.put("userIds", rUserIdsList);
			}
		}
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyFunCustDto> resList = agencyFunCustMapper.getAgencyFunCustList(pMap);
		return new PageInfo<>(resList);
	}

	@Override
	public PageInfo<AgencyFunCust>  getDistFunCustTrackList(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId",param.getInteger("cityId"));
		PageHelper.startPage(param.getPageOffset(), param.getPageRows(), true);
		List<AgencyFunCust> resList = agencyFunCustMapper.getDistFunCustTrackList(pMap);
		return new PageInfo<>(resList);
	}

	/**
	 * @TODO 分销客户查询
	 * @author lcb
	 * @2016-9-24 下午2:04:01
	 */
	@Override
	public AgencyFunCustDto getFunCustDetail(BaseMapParam param, Integer cityId) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", cityId);
		AgencyFunCustDto agencyFunCustDto = agencyFunCustMapper.getFunCustDetail(pMap);
		if(null != agencyFunCustDto) {
			AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(agencyFunCustDto.getArchiveId());
			String agencyName = "暂无";
			String agencyMobile = "暂无";
			if(null != adminFunArchive) {
				agencyName = adminFunArchive.getUserName();
				agencyMobile = adminFunArchive.getUserMobile();
			}
			agencyFunCustDto.setAgencyName(agencyName);
			agencyFunCustDto.setAgencyMobile(agencyMobile);
			// 查询buildingadmin
		}
		return agencyFunCustDto;
	}

	/**
	 * @TODO 修改客户状态
	 * @author lcb
	 * @throws Exception 
	 * @2016-10-9 下午5:30:30
	 */
	@Transactional
	@Override
	public Integer updateDistFunCust(BaseMapParam param) throws Exception {
		Map<String, Object> pMap = param.getMap();
		Integer cityId = param.getInteger("cityId");
		String custId = pMap.get("custId")+"";
		String bCityId = pMap.get("bCityId") + "";
		String backCommisionCause = pMap.get("backCommisionCause")+"";
		String cdId = pMap.get("cdId")+"";
		String saleUid = pMap.get("userId")+"";
		String buildId = pMap.get("buildId")+"";
		String custMobile = pMap.get("custMobile")+"";
		String custStatus = pMap.get("custStatus")+"";
		String oldCustStatus = pMap.get("oldCustStatus")+"";
		String paidAmount = pMap.get("paidAmount")+"";
		String buildName = pMap.get("buildName")+"";
		String custName = pMap.get("custName")+"";
		String archiveId = pMap.get("archiveId")+"";
		String custStatusText = pMap.get("custStatusText")+"";
		String content = "";
		String AGENCY_CONTENT = "";
		String trackContent = "";
		Date time = new Date();
		Map<String, Object> map = new HashMap<String, Object>(); // 更新参数Map
		map.put("custStatus", custStatus);
        if(Integer.valueOf(custStatus)<3 && Integer.valueOf(oldCustStatus)>=3){
			map.put("applyNext", "null");
		}
		if (custStatus.equals("-1")) {
			map.put("saleUid", "null");
			map.put("cancelTime", time);
			trackContent = "当日撤销了该客户的认购。";
			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName")
					+ "】撤消认购，该客户已退房，请与置业顾问联系并确认。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户:" + custName + "】由【管理员" + param.getString("userName") + "】撤消认购，该客户已退房，";
		}else if (custStatus.equals("0")) {
			map.put("checkUid", "999");
			map.put("saleUid", "null");
			map.put("checkTime", time);
			trackContent = "当日未通过审核，该客户无效。";

			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName")
					+ "】未通过审核，该客户【无效】，该客户无需带看。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户" + custName + "】由【管理员" + param.getString("userName")
					+ "】未通过审核，该客户【无效】，该客户无需带看。";
		} else if (custStatus.equals("1")) {
			trackContent = "重新报备了该客户。";
			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName") + "】重新报备。";
			map.put("verifyCode", "null");
			map.put("custCheckcode", "null");
			map.put("saleUid", "null");
			map.put("dealTime", "null");
			map.put("bandSawTime", "null");
			map.put("cancelTime", "null");
		}else if (custStatus.equals("2")) {
			map.put("checkUid", "999");
			map.put("checkTime", time);
			trackContent = "当日已通过审核，请尽快安排带看。";
			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName") + "】已通过审核，该客户有效，请尽快安排带看。";
			AGENCY_CONTENT = "您的【客户" + custName + "】由【管理员" + param.getString("userName") + "】已通过审核，该客户有效，请尽快安排带看。";
		} else if (custStatus.equals("3")) {
			if (custMobile.trim().length() > 11) {
				custMobile = custMobile.substring(0, 11);
			}
			// 修改成带看后补全手机号码
			updateNum("confirmNum", cityId, buildId);
			updateDaiKanRewards(custId, Integer.valueOf(buildId), new Short(bCityId), cityId+"", Integer.valueOf(archiveId));
			if (StringUtils.isNotBlank(custMobile)) {
				map.put("custMobile", custMobile);
				// custMobile处理过的号码 后一个为原始号码
				writeOffOtherCust(param.getInteger("userId"), cityId+"", custMobile, pMap.get("custMobile")+"", custId, Integer.valueOf(buildId));
			}else{
				throw new Exception("缺少参数！");
			}
			map.put("bandSawTime", time);
			trackContent = "当日确认该客户已带看，请配合跟进。";
			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName") + "】确认带看，请与置业顾问配合跟进。";
			AGENCY_CONTENT = "您的【客户" + custName + "】由【管理员" + param.getString("userName") + "】确认带看。";
		} else if (custStatus.equals("4")) {
			createCustDeal(cityId+"", custId, Integer.valueOf(buildId));
			updateNum("dealNum", cityId, buildId);
			map.put("dealTime", time);
			map.put("applyNext", "0");
			map.put("userApply", "0");
			trackContent = "当日确认该客户已认购，请及时结佣。";
			content = "您的【客户:" + custName + "】由【管理员:" + param.getString("userName") + "】确认认购，请与置业顾问联系并确认及时结佣。";
			AGENCY_CONTENT = "您的【客户" + custName + "】由【管理员" + param.getString("userName") + "】确认认购";
		} else if (custStatus.equals("5")) {
			if (StringUtil.isEmpty((paidAmount))) {
				throw new Exception("缺少参数！");
			}
			checkCustDeal(cityId+"", custId, new Short(bCityId), Integer.valueOf(buildId), Double.parseDouble(paidAmount),param.getInteger("userId"));
			map.put("commissionTime", time);
			map.put("applyNext", "0");
			map.put("userApply", "0");
			trackContent = "当日确认结佣";
			content = "您的【客户:" + custName + "】由【管理员" + param.getString("userName") + "】确认结佣，佣金金额为：" + paidAmount
					+ "元，请登录【好房通ERP-进入联动分销-我的联动】及时申请提现。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户" + custName + "】由【管理员" + param.getString("userName") + "】确认结佣，佣金金额为："
					+ paidAmount + "元";
		} else if (custStatus.equals("6")) {
			backCommision(cityId, custId, backCommisionCause, param.getInteger("userId"));
			trackContent = "当日确认退佣";
			map.put("backCommissionTime", time);
			map.put("applyNext", "0");
			map.put("userApply", "0");
			content = "您的【客户:" + custName + "】由【管理员" + param.getString("userName")
					+ "】确认退佣，该客户已确认退房。如有疑问请联系好房通联动客服：400-800-8548。";
			AGENCY_CONTENT = "您的【客户:" + custName + "】由【管理员" + param.getString("userName") + "】确认退佣，该客户已确认退房。";
		}
		map.put("trackTime", time);
		map.put("cityId", cityId);
		map.put("custId", custId);
		Integer r = agencyFunCustMapper.updateFunCustByCondition(map);
		createTrack(cityId, custId, trackContent, param.getInteger("userId"));

		if (!oldCustStatus.equals(custStatus) && (custStatus.equals("5") || custStatus.equals("6"))) {
			writeTrack("[佣金管理]", param.getString("userName") + "将佣金状态修改为：" + custStatusText, param);
		}
		procPushMsg(Integer.valueOf(archiveId), content, cityId, custId);
		createErpSystemMessage(archiveId, content, cityId);
		return null;
	}
	
	/**
	 * 推送小秘书erp的消息
	 * 
	 * @throws Exception
	 */
	private void createErpSystemMessage(String archiveId, String msgContent, Integer cityId) throws Exception {
		ErpFunUsers erpFunUsers = funUsersMapper.selectByArchiveId(StringUtil.parseInteger(archiveId));
		if(null != erpFunUsers) {
			if (msgContent.indexOf("'") > -1) {
				msgContent = msgContent.replaceAll("'", "''");
			}
			
			ErpFunMsg erpFunMsg = new ErpFunMsg();
			erpFunMsg.setCompId(erpFunUsers.getCompId());
			erpFunMsg.setMsgContent(msgContent);
			erpFunMsg.setReadFlag(false);
			erpFunMsg.setSendTime(new Date());
			erpFunMsg.setSendUser(Integer.valueOf(Constants_DIC.DIC_SYSTEM_USERID_999));
			erpFunMsg.setReceiveUser(erpFunUsers.getUserId());
			erpFunMsg.setSendDel(false);
			erpFunMsg.setReceiveDel(false);
			erpFunMsg.setSendDept(cityId);
			erpFunMsg.setReceiveDept(erpFunUsers.getDeptId());
			erpFunMsgMapper.insertSelective(erpFunMsg);
		}
	}
	
	private void procPushMsg(Integer archiveId, String msg, Integer cityId, String custId) throws ParseException {
		SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date=new Date();
		AdminSystemMessage systemMessage = new AdminSystemMessage();
		int msgId = adminSystemMessageMapper.getId()+1;
		systemMessage.setMsgId(msgId);
		systemMessage.setArchiveId(archiveId);
		systemMessage.setTitle("系统消息");
		systemMessage.setMsgContent(msg);
		systemMessage.setIsRead(0);
		systemMessage.setCreateTime(time.parse(time.format(date)));
		systemMessage.setMsgType(4);
		systemMessage.setJson("{\"CITY_ID\":\"" + cityId + "\",\"CUST_ID\":\"" + custId + "\",\"URL\":\"\",\"URL_TITLE\":\"\"}");
		adminSystemMessageMapper.insertSelective(systemMessage);
	// P3.短信推送 MSG_PUSH
		AdminAppLogin appLogin = appLoginMapper.selectByPrimaryKey(archiveId);
		AdminMsgPush msgPush = new AdminMsgPush();
		msgPush.setDeviceType(appLogin.getDeviceType());
		msgPush.setPushToken(appLogin.getPushToken());
		msgPush.setIsPush(0);
		msgPush.setPushTitle("系统消息");
		msgPush.setPushContent(msg);
		msgPush.setCreateTime(time.parse(time.format(date)));
		msgPush.setReceiveArchiveId(String.valueOf(archiveId));
		msgPush.setSendArchiveId("0");
		msgPush.setPushLevel(2);
		msgPush.setUserType((byte) 1);
		msgPush.setPushJson("{\"type\":\"3\",\"msg_id\":\"" + msgId + "\",\"msg_type\":\"0\"}");
		msgPushMapper.insertSelective(msgPush);
		
	}
	public void writeTrack(String desc, String content,BaseMapParam param) throws Exception {
		AdminCrmBrokerTrack adminCrmBrokerTrack = new AdminCrmBrokerTrack();
		adminCrmBrokerTrack.setArchiveId(param.getInteger("archiveId"));
		adminCrmBrokerTrack.setCityId(param.getInteger("cityId"));
		adminCrmBrokerTrack.setProvinceId(param.getInteger("provinceId"));
		adminCrmBrokerTrack.setCompId(param.getInteger("compId"));
		adminCrmBrokerTrack.setCrmCompId(param.getInteger("compId"));
		adminCrmBrokerTrack.setDeptId(param.getInteger("deptId"));
		adminCrmBrokerTrack.setTrackDesc("[联动支付]");
		adminCrmBrokerTrack.setTrackContent(content);
		adminCrmBrokerTrack.setTrackUser(param.getInteger("userId"));
		adminCrmBrokerTrack.setTrackTime(new Date());
		adminCrmBrokerTrackMapper.insertSelective(adminCrmBrokerTrack);
	}
	
	private Integer updateNum(String column, Integer cityId, String buildId) {
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("column", column);
		pMap.put("cityId", cityId);
		pMap.put("buildId", buildId);
		return agencyFunCustMapper.updateColumn(pMap);
	}

	/**
	 * @TODO 数据移交
	 * @author lcb
	 * @2016-10-11 下午4:21:55
	 */
	@Transactional
	@Override
	public Integer transferDistFunCust(BaseMapParam param) throws Exception{
		Map<String, Object> pMap = param.getMap();
		String sourceUserId = pMap.get("sourceUserId")+"";
		String targetUserId = pMap.get("targetUserId")+"";
		ErpFunUsers targetUser = funUsersMapper.getUserInfoByUserId(param.getInteger("cityId"), Integer.valueOf(targetUserId));
		ErpFunUsers sourceUser = funUsersMapper.getUserInfoByUserId(param.getInteger("cityId"), Integer.valueOf(sourceUserId));
		Integer cityId = param.getInteger("cityId");
		Integer compId =param.getInteger("compId");
		String targetDeptName = erpFunDeptsMapper.getByDeptId(cityId, targetUser.getDeptId()).getDeptName();
		String sourceDeptName = erpFunDeptsMapper.getByDeptId(cityId, sourceUser.getDeptId()).getDeptName();
		if("1".equals(pMap.get("transferFlag"))){//1代表全部移交
			pMap.put("compId", compId);
			pMap.put("cityId", cityId);
			agencyFunCustMapper.updateFuncustArchiveId(pMap);
			
			String trackContent =param.getString("deptName")+" "+  param.getString("userName")+" " + "将该 "
					+" "+sourceDeptName+" " +sourceUser.getUserName() + " 的信息移交给 "
					+ " "+targetDeptName+" " + targetUser.getUserName()
					+ "\n移交原因：" + pMap.get("transferDesc");
			pMap = new HashMap<>();
			pMap.put("cityId", cityId);
			pMap.put("compId", compId);
			pMap.put("sourceUserId", sourceUserId);
			pMap.put("trackContent", trackContent);
			pMap.put("trackUid", param.getInteger("userId"));
			pMap.put("trackUname", param.getString("userName"));
			pMap.put("nowDate", new Date());
			agencyFunCustTrackMapper.batchInsertTrack(pMap);
			
		}else{
			Map<String, Object> paramMap = new HashMap<>();
			paramMap.put("userId", targetUserId);
			paramMap.put("archiveId", targetUser.getArchiveId());
			paramMap.put("deptId", targetUser.getDeptId());
			String[] arr = pMap.get("custIds").toString().split(",");
			for(int i=0;i<arr.length;i++){
				AgencyFunCust agencyFunCust = agencyFunCustMapper.getRecord( arr[i]);
				String trackContent = param.getString("deptName")+" "+ param.getString("userName")+" " + "将该 "
						+ " "+sourceDeptName+" " +sourceUser.getUserName() + " 的信息移交给 "
						 +targetDeptName+" " + targetUser.getUserName()
						+ "\n移交原因：" + pMap.get("transferDesc");
				createTrack(cityId, agencyFunCust.getCustId(), trackContent, param);
				AgencyFunCust cond = new AgencyFunCust();
				cond.setUserId(Integer.valueOf(targetUserId));
				cond.setArchiveId(targetUser.getArchiveId());
				cond.setDeptId(targetUser.getDeptId());
				cond.setCustId(Integer.valueOf(arr[i]));
				cond.setCityId(cityId.shortValue());
				agencyFunCustMapper.updateByPrimaryKeySelective(cond);
			}
		}
		return null;
	}
	
	public void createTrack(Integer cityId, Integer custId, String trackContent, BaseMapParam param) throws Exception {
		AgencyFunCustTrack agencyFunCustTrack = new AgencyFunCustTrack();
		agencyFunCustTrack.setCityId(cityId.shortValue());
		agencyFunCustTrack.setCustId(custId);
		agencyFunCustTrack.setCustSource(new Short("1"));
		agencyFunCustTrack.setTrackContent(trackContent);
		agencyFunCustTrack.setTrackSource(new Short("1"));
		agencyFunCustTrack.setTrackTime(new Date());
		agencyFunCustTrack.setTrackType("管理员");
		agencyFunCustTrack.setTrackUid(param.getInteger("userId"));
		agencyFunCustTrack.setTrackUname(param.getString("userName"));
		agencyFunCustTrackMapper.insertSelective(agencyFunCustTrack);
	}

	/**
	 * @TODO 客户判重
	 * @author lcb
	 * @2016-10-12 下午4:39:07
	 */
	@Override
	public Integer checkDistMobileRepreated(BaseMapParam param) {
		Integer res = 0;
		Map<String, Object> pMap = param.getMap();
		String mobiles = pMap.get("firstMobile") + "";//前9位
		
		if(null != pMap.get("lastMobile")) {// 后两位
			pMap.put("firstMobile", mobiles+"%"+pMap.get("lastMobile"));
		}
		Integer count = agencyFunCustMapper.countMobile(pMap);
		
		if(count > 0){
			res = 0;
		}else{
			res = 1;
		}	
		return res;	
	}

	/**
	 * @TODO 报备
	 * @author lcb
	 * @2016-10-12 下午5:28:07
	 */
	@Transactional
	@Override
	public Integer createDistCust(BaseMapParam param) throws Exception{
		Map<String, Object> pMap = param.getMap();
		checkSignDealAccount(param);//报备的时候检测当前经纪人是否已经签订联动使用电子协议
		String flag = "";
		String everyDay = DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(),"yyyy-MM-dd");
		// 同一个客户当天只能报备3个楼盘
		
		AgencyBuildingInfoDto buildingInfo = agencyBuildingInfoMapper.getBuildingInfo(pMap);
		
		Byte buildStatus = buildingInfo.getBuildStatus();
		Short agencyStatus = buildingInfo.getAgencyStatus();
		if(buildStatus.intValue() == 0){
			throw new BusinessException("该楼盘停止分销,无法报备客户!");
		}else{
			if(buildStatus.intValue() == 1){
				throw new BusinessException("该楼盘暂未开售,请耐心等待!");
				
			}else if(buildStatus.intValue() == 3){
				throw new BusinessException("该楼盘已售罄,无法报备客户!");
				
			}
			
			if(StringUtils.isNotBlank(buildingInfo.getCooperateEnd())){
				throw new BusinessException("该楼盘合作期限已到期,无法报备客户!");
			}
		}
		pMap.put("startTime", DateTimeHelper.formatDateTimetoString(everyDay, "yyyy-MM-dd 00:00:00"));
		pMap.put("endTime", DateTimeHelper.formatDateTimetoString(everyDay, "yyyy-MM-dd 23:59:59"));
		
		
		int num = agencyFunCustMapper.countModelData(pMap);	
		if(num >= 3){
			flag = "threeRepeat";
		}else{
			AgencyFunCust agencyFunCust = new AgencyFunCust();
			agencyFunCust.setCityId(param.getInteger("cityId").shortValue());
			
			if(null != pMap.get("custName")) {
				agencyFunCust.setCustName(pMap.get("custName")+"");
			}
			if(null != pMap.get("custSex")) {
				agencyFunCust.setCustSex(new Short(pMap.get("custSex")+""));
			}
			if(null != pMap.get("custMobile")) {
				agencyFunCust.setCustMobile(pMap.get("custMobile")+"");
			}
			if(null != pMap.get("reqAmount1")) {
				agencyFunCust.setReqAmount1(new BigDecimal(pMap.get("reqAmount1")+""));
			}
			if(null != pMap.get("reqAmount2")) {
				agencyFunCust.setReqAmount2(new BigDecimal(pMap.get("reqAmount2")+""));
			}
			if(null != pMap.get("reqArea1")) {
				agencyFunCust.setReqArea1(new BigDecimal(new Short(pMap.get("reqArea1")+"")));
			}
			if(null != pMap.get("reqLayout1")) {
				agencyFunCust.setReqLayout1(new Short(pMap.get("reqLayout1")+""));
			}
			if(null != pMap.get("reqArea2")) {
				agencyFunCust.setReqArea2(new BigDecimal(pMap.get("reqArea2")+""));
			}
			if(null != pMap.get("preTime")) {
				agencyFunCust.setPreTime(pMap.get("preTime")+"");
			}
			agencyFunCust.setCustSource(new Short("2"));
			agencyFunCust.setCompId(param.getInteger("compId"));
			agencyFunCust.setDeptId(param.getInteger("deptId"));
			agencyFunCust.setUserId(param.getInteger("userId"));
			agencyFunCust.setArchiveId(param.getInteger("archiveId"));
			agencyFunCust.setCreationTime(new Date());
			agencyFunCust.setVerifyCode(new Short("2"));
			agencyFunCust.setTrackTime(new Date());
			agencyFunCust.setCustStatus(1);
			agencyFunCust.setBuildId(Integer.valueOf(pMap.get("buildId")+""));
			agencyFunCust.setBuildName(pMap.get("buildName")+"");
			agencyFunCust.setbCityId(new Short(pMap.get("bCityId")+""));
			Integer fcustId = agencyFunCustMapper.insertSelective(agencyFunCust);
			
			agencyFunCust = new AgencyFunCust();
			agencyFunCust.setCustId(fcustId);
			agencyFunCust.setQrCode(pMap.get("custMobile") + "_" + fcustId);
			agencyFunCustMapper.updateByPrimaryKeySelective(agencyFunCust);
			
			// 写跟进
			String trackContent =  param.getString("userName")+"报备客户,请尽快审核";
			agencyFunCustTrackService.writeFunCustTrack(fcustId, 2, "经纪人", trackContent, 0, param);
			AgencyBuildingInfoKey agencyBuildingInfoKey = new AgencyBuildingInfoKey();
			agencyBuildingInfoKey.setBuildId(Integer.valueOf(pMap.get("buildId")+""));
			agencyBuildingInfoKey.setCityId(param.getInteger("cityId"));
			AgencyBuildingInfo agencyBuildingInfo = agencyBuildingInfoMapper.selectByPrimaryKey(agencyBuildingInfoKey);
//			if(null != agencyBuildingInfo && 1 == agencyBuildingInfo.getBuildSource()) {
//				// 查询myHftCustmap
//				AgencyMyHftCustmap agencyMyHftCustmap = agencyMyHftCustmapMapper.getCustMap(fcustId);
//				String mapId = "";
//				if(null != agencyMyHftCustmap) {
//					mapId = agencyMyHftCustmap.getMyId();
//				}else {
//					mapId = UUID.randomUUID().toString();
//					agencyMyHftCustmap = new AgencyMyHftCustmap();
//					agencyMyHftCustmap.setCustId(fcustId);
//					agencyMyHftCustmap.setMyId(mapId);
//					agencyMyHftCustmapMapper.insertSelective(agencyMyHftCustmap);
//				}
//				// 明源数据
//				// pushMyCustInfo(buildId,mobile,myCustId);
//			}
		}
		return null;
	}
	
	/**
	 * 检测当前经纪人是否签订联动协议,如果签订不做任何操作，
	 * 没有签订，则签订联动分销电子协议
	 * @return
	 */
	private void checkSignDealAccount(BaseMapParam param) throws Exception{
		Map<String, Object> pMap = new HashMap<>();
		pMap.put("accountId", param.getInteger("archiveId"));
		pMap.put("uaType", "0"); // 个人
		pMap.put("cityId", param.getInteger("cityId"));
		
		Integer num = agencyFunAgencyAccountMapper.getAccountCount(pMap);
		if(num == 0){
				//个人账户
			AgencyFunAgencyAccount agencyFunAgencyAccount = new AgencyFunAgencyAccount();
			agencyFunAgencyAccount.setAccountId(param.getInteger("archiveId"));
			agencyFunAgencyAccount.setCityId(param.getInteger("cityId"));
			agencyFunAgencyAccount.setUaType(new Byte("0"));
			agencyFunAgencyAccount.setSignTime(new Date());
			agencyFunAgencyAccountMapper.insertSelective(agencyFunAgencyAccount);
			
			// 查询公司账户
			pMap.put("accountId", param.getInteger("compId"));
			pMap.put("uaType", "1"); // 公司
			pMap.put("cityId", param.getInteger("cityId"));
			Integer checkNum = agencyFunAgencyAccountMapper.getAccountCount(pMap);
				//公司账户
			if(checkNum == 0){//还没有当前公司账户
				agencyFunAgencyAccount.setUaId(null);
				agencyFunAgencyAccount.setAccountId( param.getInteger("compId"));
				agencyFunAgencyAccount.setUaType(new Byte("1"));//公司账户
				agencyFunAgencyAccountMapper.insertSelective(agencyFunAgencyAccount);
			}
	
	   }
	 }

	/**
	 * @TODO 我的客户-管理-详情
	 * @author lcb
	 * @2016-10-14 下午2:10:55
	 */
	@Override
	public AgencyFunCustDto getDistCustInfo(BaseMapParam param) {
		Map<String, Object> pMap = param.getMap();
		pMap.put("cityId", param.getInteger("cityId"));
		AgencyFunCustDto agencyFunCustDto = agencyFunCustMapper.getDistCustInfo(pMap);
		if(null != agencyFunCustDto) {
			Integer archiveId = agencyFunCustDto.getArchiveId();
			AdminFunArchive adminFunArchive = adminFunArchiveMapper.getArchiveById(archiveId);
			if(null != adminFunArchive) {
				agencyFunCustDto.setErpUserMobile(adminFunArchive.getUserMobile());
				agencyFunCustDto.setErpUserName(adminFunArchive.getUserName());
			}
		}
		
		return agencyFunCustDto;
	}

	
}
