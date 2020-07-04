package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.myfun.erpWeb.managecenter.axn.param.BatchUnBindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.BindNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.ImportNumber;
import com.myfun.erpWeb.managecenter.axn.param.ImportNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.ReleaseNumberParam;
import com.myfun.erpWeb.managecenter.axn.param.UnBindNumberParam;
import com.myfun.framework.exception.BusinessException;
import com.myfun.framework.util.DateTimeHelper;
import com.myfun.repository.admindb.dao.AdminFunArchiveMapper;
import com.myfun.repository.admindb.dao.AdminIpCallLogMapper;
import com.myfun.repository.admindb.po.AdminFunArchive;
import com.myfun.repository.erpdb.dao.ErpAliyunNumberPoolMapper;
import com.myfun.repository.erpdb.dao.ErpAliyunPhoneBindHistoryMapper;
import com.myfun.repository.erpdb.dao.ErpAliyunPhoneMapper;
import com.myfun.repository.erpdb.dao.ErpAliyunTelephoneBillMapper;
import com.myfun.repository.erpdb.dao.ErpFunOrganizationMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.dao.ErpUserOpersMapper;
import com.myfun.repository.erpdb.dto.UserOpOrgInfoDto;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPool;
import com.myfun.repository.erpdb.po.ErpAliyunPhone;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneBindHistory;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneBindHistoryExample;
import com.myfun.repository.erpdb.po.ErpAliyunPhoneExample;
import com.myfun.repository.erpdb.po.ErpAliyunTelephoneBill;
import com.myfun.repository.erpdb.po.ErpAliyunTelephoneBillExample;
import com.myfun.repository.erpdb.po.ErpFunOrganization;
import com.myfun.repository.erpdb.po.ErpFunTask;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.erpdb.po.ErpFunUsersExample;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAliyunPhoneService;
import com.myfun.service.business.erpdb.ErpFunTaskService;
import com.myfun.utils.AliyunPhoneNumberProtectionUtil;
import com.myfun.utils.DateUtil;
import com.myfun.utils.StringUtil;

@Service
public class ErpAliyunPhoneServiceImpl extends AbstractService<ErpAliyunPhone, ErpAliyunPhone> implements ErpAliyunPhoneService{
	@Autowired 
	private ErpAliyunPhoneMapper erpAliyunPhoneMapper;
	@Autowired
	private ErpAliyunNumberPoolMapper erpAliyunNumberPoolMapper;
	@Autowired
	private ErpFunOrganizationMapper erpFunOrganizationMapper;
	@Autowired
	private ErpAliyunPhoneBindHistoryMapper erpAliyunPhoneBindHistoryMapper;
	@Autowired
	private ErpFunUsersMapper erpFunUsersMapper;
	@Autowired
	private AdminFunArchiveMapper adminFunArchiveMapper;
	@Autowired
	private ErpAliyunTelephoneBillMapper erpAliyunTelephoneBillMapper;
	@Autowired
	private AdminIpCallLogMapper adminIpCallLogMapper;
	@Autowired
	private ErpUserOpersMapper erpUserOpersMapper;
	@Autowired
	private ErpFunTaskService erpFunTaskService;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAliyunPhoneMapper;
	}
	
	@Transactional
	@Override
	public int importNumber(ImportNumberParam param) {
		Date date = new Date();
		List<ImportNumber> importNumberList = param.getPhones();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String numberPoolKey = param.getNumberPoolKey();
		Date suffix = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-01"));
		// 查询号码池
		ErpAliyunNumberPool erpAliyunNumberPool = erpAliyunNumberPoolMapper.getNumberPool(cityId, numberPoolKey);
		Integer orgId = erpAliyunNumberPool.getOrgId();
		int i;
		for (i = 0; i < importNumberList.size(); i++) {
			ImportNumber importNumber = importNumberList.get(i);
			ErpAliyunPhone erpAliyunPhone = new ErpAliyunPhone();
			erpAliyunPhone.setShardCityId(cityId);
			erpAliyunPhone.setAliNumberPoolKey(importNumber.getAliNumberPoolKey());
			erpAliyunPhone.setOrgId(orgId);
			erpAliyunPhone.setBindX(importNumber.getBindX());
			erpAliyunPhone.setBuyTime(date);
			erpAliyunPhone.setCompId(compId);
			erpAliyunPhone.setIsrelease(Byte.valueOf("0"));
			erpAliyunPhone.setNumberState(Byte.valueOf("0"));
			erpAliyunPhone.setNumberPoolKey(numberPoolKey);
			erpAliyunPhoneMapper.insertSelective(erpAliyunPhone);
			// 插入月租
			int monthlyrent = 12;
			if (erpAliyunPhone.getBindX().substring(0,3).equals("171")) {
				monthlyrent = 4;
			}
			ErpAliyunTelephoneBill erpAliyunTelephoneBill = new ErpAliyunTelephoneBill();
			erpAliyunTelephoneBill.setShardCityId(cityId);
			erpAliyunTelephoneBill.setCompId(erpAliyunPhone.getCompId());
			erpAliyunTelephoneBill.setxPhone(erpAliyunPhone.getBindX());
			erpAliyunTelephoneBill.setTelePhoneBill(new BigDecimal(0));
			erpAliyunTelephoneBill.setMonthlyrent(new BigDecimal(monthlyrent));
			erpAliyunTelephoneBill.setOtherBill(new BigDecimal(0));
			erpAliyunTelephoneBill.setRecording(new BigDecimal(0));
			erpAliyunTelephoneBill.setAllMoney(new BigDecimal(monthlyrent));
			erpAliyunTelephoneBill.setToallTime(0);
			erpAliyunTelephoneBill.setToallCount(0);
			erpAliyunTelephoneBill.setSuffix(suffix);
			erpAliyunTelephoneBillMapper.insertSelective(erpAliyunTelephoneBill);
		}
		return i;
	}

	@Override
	public void unBindNumber(UnBindNumberParam param) {
		Date date = new Date();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		String bindX = param.getBindX();
		Integer operateUserId = param.getOperateUserId();
		ErpAliyunPhone erpAliyunPhone = erpAliyunPhoneMapper.getPhoneNumber(cityId, compId, bindX);
		String subsId = erpAliyunPhone.getSubsId();
		String aliNumberPoolKey = erpAliyunPhone.getAliNumberPoolKey();
		// 阿里解绑
		AliyunPhoneNumberProtectionUtil.unbindSubscription(subsId, bindX, aliNumberPoolKey);
		// 本地解绑
		erpAliyunPhoneMapper.unBindNumber(cityId, bindX);
		// 修改历史记录
		ErpAliyunPhoneBindHistoryExample erpAliyunPhoneBindHistoryExample = new ErpAliyunPhoneBindHistoryExample();
		erpAliyunPhoneBindHistoryExample.setShardCityId(cityId);
		erpAliyunPhoneBindHistoryExample.createCriteria().andBindXEqualTo(bindX).andSubsIdEqualTo(subsId).andUnbindTimeIsNull();
		ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory = new ErpAliyunPhoneBindHistory();
		erpAliyunPhoneBindHistory.setUnbindTime(date);
		erpAliyunPhoneBindHistory.setUnbindOperateUserId(operateUserId);
		erpAliyunPhoneBindHistoryMapper.updateByExampleSelective(erpAliyunPhoneBindHistory, erpAliyunPhoneBindHistoryExample);
	}

	@Override
	public void releaseNumber(ReleaseNumberParam param) {
		String bindX = param.getBindX();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer operateUserId = param.getOperateUserId();
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(cityId);
		erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(compId).andBindXEqualTo(bindX).andIsreleaseEqualTo(Byte.valueOf("0"));
		List<ErpAliyunPhone> aliyunPhoneList = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if (aliyunPhoneList.isEmpty()) {
			return;
		}
		ErpAliyunPhone erpAliyunPhone = aliyunPhoneList.get(0);
		String subsId = erpAliyunPhone.getSubsId();
		String aliNumberPoolKey = erpAliyunPhone.getAliNumberPoolKey();
		// 阿里释放
		AliyunPhoneNumberProtectionUtil.releaseSecretNo(bindX, aliNumberPoolKey);
		// 本地释放
		erpAliyunPhoneMapper.releaseNumber(cityId, bindX);
		// 修改历史记录
		ErpAliyunPhoneBindHistoryExample erpAliyunPhoneBindHistoryExample = new ErpAliyunPhoneBindHistoryExample();
		erpAliyunPhoneBindHistoryExample.setShardCityId(cityId);
		erpAliyunPhoneBindHistoryExample.createCriteria().andBindXEqualTo(bindX).andSubsIdEqualTo(subsId).andUnbindTimeIsNull();
		ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory = new ErpAliyunPhoneBindHistory();
		erpAliyunPhoneBindHistory.setUnbindTime(new Date());
		erpAliyunPhoneBindHistory.setUnbindOperateUserId(operateUserId);
		erpAliyunPhoneBindHistoryMapper.updateByExampleSelective(erpAliyunPhoneBindHistory, erpAliyunPhoneBindHistoryExample);
		
	}

	@Override
	public void bindNumber(BindNumberParam param) {
		Date date = new Date();
		Integer cityId = param.getCityId();
		Integer compId = param.getCompId();
		Integer userId = param.getUserId();
		String bindX = param.getBindX();
		Integer operateUserId = param.getOperateUserId();
		ErpAliyunPhone erpAliyunPhone = erpAliyunPhoneMapper.getPhoneNumber(cityId, compId, bindX);
		String aliNumberPoolKey = erpAliyunPhone.getAliNumberPoolKey();
		String numberPoolKey = erpAliyunPhone.getNumberPoolKey();
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		Integer archiveId = erpFunUsers.getArchiveId();
		Integer orgId = erpFunUsers.getOrganizationId();
		String userMobile = erpFunUsers.getUserMobile();
		if (StringUtil.isNotEmpty(param.getBindA())) {
			userMobile = param.getBindA();
		}
		String userName = erpFunUsers.getUserName();
		AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
		String userIccode = adminFunArchive.getUserIccode();
		ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);
		String orgNo = erpFunOrganization.getOrganizationNo();
		String orgName = erpFunOrganization.getOrganizationName();
		// 绑定axn
		JSONObject jsonObject = AliyunPhoneNumberProtectionUtil.bindAxn(userMobile, bindX, aliNumberPoolKey, null);
		if (!"OK".equalsIgnoreCase(jsonObject.getString("code"))) {
			throw new BusinessException(jsonObject.getString("message"));
		}
		// 这个一定要保存好
		String subsId = jsonObject.getJSONObject("secretBindDTO").getString("subsId");
		// 更新绑定
		erpAliyunPhone.setShardCityId(cityId);
		erpAliyunPhone.setBindA(userMobile);
		erpAliyunPhone.setBindAOrgId(orgId);
		erpAliyunPhone.setBindAOrgNo(orgNo);
		erpAliyunPhone.setBindArchiveId(archiveId);
		erpAliyunPhone.setBindATime(date);
		erpAliyunPhone.setBindUserId(userId);
		erpAliyunPhone.setBindUserName(userName);
		erpAliyunPhone.setIdentifyId(userIccode);
		erpAliyunPhone.setIdentifyName(userName);
		erpAliyunPhone.setSubsId(subsId);
		erpAliyunPhone.setNumberState(Byte.valueOf("1"));
		erpAliyunPhoneMapper.updateByPrimaryKeySelective(erpAliyunPhone);

		// 插入绑定历史记录
		ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory = new ErpAliyunPhoneBindHistory();
		erpAliyunPhoneBindHistory.setShardCityId(cityId);
		erpAliyunPhoneBindHistory.setAliNumberPoolKey(aliNumberPoolKey);
		erpAliyunPhoneBindHistory.setBindA(userMobile);
		erpAliyunPhoneBindHistory.setBindAOrgId(orgId);
		erpAliyunPhoneBindHistory.setBindAOrgNo(orgNo);
		erpAliyunPhoneBindHistory.setBindArchiveId(archiveId);
		erpAliyunPhoneBindHistory.setBindATime(date);
		erpAliyunPhoneBindHistory.setBindUserId(userId);
		erpAliyunPhoneBindHistory.setBindUserName(userName);
		erpAliyunPhoneBindHistory.setBindX(bindX);
		erpAliyunPhoneBindHistory.setCompId(compId);
		erpAliyunPhoneBindHistory.setNumberPoolKey(numberPoolKey);
		erpAliyunPhoneBindHistory.setSubsId(subsId);
		erpAliyunPhoneBindHistory.setBindOperateUserId(operateUserId);
		erpAliyunPhoneBindHistoryMapper.insertSelective(erpAliyunPhoneBindHistory);

		// 修改扣费记录
		Date billDate = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-01"));
		ErpAliyunTelephoneBillExample erpAliyunTelephoneBillExample = new ErpAliyunTelephoneBillExample();
		erpAliyunTelephoneBillExample.setShardCityId(cityId);
		erpAliyunTelephoneBillExample.createCriteria().andCompIdEqualTo(compId).andSuffixEqualTo(billDate).andXPhoneEqualTo(bindX);
		ErpAliyunTelephoneBill erpAliyunTelephoneBill = new ErpAliyunTelephoneBill();
		erpAliyunTelephoneBill.setArchiveId(archiveId);
		erpAliyunTelephoneBill.setaPhone(userMobile);
		erpAliyunTelephoneBill.setBindATime(date);
		erpAliyunTelephoneBill.setOrgId(orgId);
		erpAliyunTelephoneBill.setOrgName(orgName);
		erpAliyunTelephoneBill.setOrgNo(orgNo);
		erpAliyunTelephoneBill.setUserId(userId);
		erpAliyunTelephoneBill.setUserName(userName);
		erpAliyunTelephoneBillMapper.updateByExampleSelective(erpAliyunTelephoneBill, erpAliyunTelephoneBillExample);
		
		// 号池余量不足提醒
		if (null != erpAliyunPhone.getOrgId()) {
			Set<Integer> orgIdSet = new HashSet<>();
			orgIdSet.add(erpAliyunPhone.getOrgId());
			this.axnPoolAbsenceWarm(orgIdSet, cityId, compId);
		}
	}

	@Override
	public String batchBindNumber(Integer cityId, Integer compId, Integer operateUserId, List<Integer> userIdList) {
		Date date = new Date();
		ErpFunUsersExample erpFunUsersExample = new ErpFunUsersExample();
		erpFunUsersExample.setShardCityId(cityId);
		erpFunUsersExample.createCriteria().andCompIdEqualTo(compId).andUserIdIn(userIdList);
		List<ErpFunUsers> userList = erpFunUsersMapper.selectByExample(erpFunUsersExample);
		StringBuilder unBindUserMobile = new StringBuilder(); //未绑定上的号码
		Set<Integer> orgIdSet = new HashSet<>(); // 绑定了的组织，号码所属组织
		for (ErpFunUsers erpFunUsers : userList) {
			String userMobile = erpFunUsers.getUserMobile();
			List<String> orgIdList = Arrays.asList(erpFunUsers.getTissueLine().split(":"));
			Collections.reverse(orgIdList);
			for (int i = 0; i < orgIdList.size(); i++) {
				String orgId = orgIdList.get(i);
				if (StringUtil.isNotEmpty(orgId)) {
					ErpAliyunPhone erpAliyunPhone = erpAliyunPhoneMapper.getUnbindPhoneNumber(cityId, compId, Integer.parseInt(orgId));
					if (erpAliyunPhone != null) {
						String aliNumberPoolKey = erpAliyunPhone.getAliNumberPoolKey();
						String numberPoolKey = erpAliyunPhone.getNumberPoolKey();
						String bindX = erpAliyunPhone.getBindX();
						Integer archiveId = erpFunUsers.getArchiveId();
						String userName = erpFunUsers.getUserName();
						AdminFunArchive adminFunArchive = adminFunArchiveMapper.selectByPrimaryKey(archiveId);
						String userIccode = adminFunArchive.getUserIccode();
						ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, erpFunUsers.getOrganizationId());
						String orgNo = erpFunOrganization.getOrganizationNo();
						String orgName = erpFunOrganization.getOrganizationName();
						// 绑定axn
						JSONObject jsonObject = AliyunPhoneNumberProtectionUtil.bindAxn(userMobile, bindX, aliNumberPoolKey, null);
						if (!"OK".equalsIgnoreCase(jsonObject.getString("code"))) {
							unBindUserMobile.append(userMobile + " ");
							continue;
						}
						// 这个一定要保存好
						String subsId = jsonObject.getJSONObject("secretBindDTO").getString("subsId");
						// 更新绑定
						erpAliyunPhone.setShardCityId(cityId);
						erpAliyunPhone.setBindA(userMobile);
						erpAliyunPhone.setBindAOrgId(erpFunUsers.getOrganizationId());
						erpAliyunPhone.setBindAOrgNo(orgNo);
						erpAliyunPhone.setBindArchiveId(archiveId);
						erpAliyunPhone.setBindATime(date);
						erpAliyunPhone.setBindUserId(erpFunUsers.getUserId());
						erpAliyunPhone.setBindUserName(userName);
						erpAliyunPhone.setIdentifyId(userIccode);
						erpAliyunPhone.setIdentifyName(userName);
						erpAliyunPhone.setSubsId(subsId);
						erpAliyunPhone.setNumberState(Byte.valueOf("1"));
						erpAliyunPhoneMapper.updateByPrimaryKeySelective(erpAliyunPhone);
						orgIdSet.add(erpAliyunPhone.getOrgId());
						
						// 插入绑定历史记录
						ErpAliyunPhoneBindHistory erpAliyunPhoneBindHistory = new ErpAliyunPhoneBindHistory();
						erpAliyunPhoneBindHistory.setShardCityId(cityId);
						erpAliyunPhoneBindHistory.setAliNumberPoolKey(aliNumberPoolKey);
						erpAliyunPhoneBindHistory.setBindA(userMobile);
						erpAliyunPhoneBindHistory.setBindAOrgId(erpFunUsers.getOrganizationId());
						erpAliyunPhoneBindHistory.setBindAOrgNo(orgNo);
						erpAliyunPhoneBindHistory.setBindArchiveId(archiveId);
						erpAliyunPhoneBindHistory.setBindATime(date);
						erpAliyunPhoneBindHistory.setBindUserId(erpFunUsers.getUserId());
						erpAliyunPhoneBindHistory.setBindUserName(userName);
						erpAliyunPhoneBindHistory.setBindX(bindX);
						erpAliyunPhoneBindHistory.setCompId(compId);
						erpAliyunPhoneBindHistory.setNumberPoolKey(numberPoolKey);
						erpAliyunPhoneBindHistory.setSubsId(subsId);
						erpAliyunPhoneBindHistory.setBindOperateUserId(operateUserId);
						erpAliyunPhoneBindHistoryMapper.insertSelective(erpAliyunPhoneBindHistory);
						
						// 修改扣费记录
						Date billDate = DateTimeHelper.parseToDate(DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-01"));
						ErpAliyunTelephoneBillExample erpAliyunTelephoneBillExample = new ErpAliyunTelephoneBillExample();
						erpAliyunTelephoneBillExample.setShardCityId(cityId);
						erpAliyunTelephoneBillExample.createCriteria().andCompIdEqualTo(compId).andSuffixEqualTo(billDate).andXPhoneEqualTo(bindX);
						ErpAliyunTelephoneBill erpAliyunTelephoneBill = new ErpAliyunTelephoneBill();
						erpAliyunTelephoneBill.setArchiveId(archiveId);
						erpAliyunTelephoneBill.setaPhone(userMobile);
						erpAliyunTelephoneBill.setBindATime(date);
						erpAliyunTelephoneBill.setOrgId(erpFunUsers.getOrganizationId());
						erpAliyunTelephoneBill.setOrgName(orgName);
						erpAliyunTelephoneBill.setOrgNo(orgNo);
						erpAliyunTelephoneBill.setUserId(erpFunUsers.getUserId());
						erpAliyunTelephoneBill.setUserName(userName);
						erpAliyunTelephoneBillMapper.updateByExampleSelective(erpAliyunTelephoneBill, erpAliyunTelephoneBillExample);
						break;
					}
				}
				// 找不到绑定的了
				if (i == orgIdList.size() - 1) {
					unBindUserMobile.append(userMobile + " ");
				}
			}
		}
		
		// 号池余量不足提醒
		if (orgIdSet.size() > 0) {
			this.axnPoolAbsenceWarm(orgIdSet, cityId, compId);
		}
		return unBindUserMobile.toString();
	}

	@Override
	public void batchUnBindNumber(BatchUnBindNumberParam param) {
		UnBindNumberParam unBindNumberParam = new UnBindNumberParam();
		unBindNumberParam.setCityId(param.getCityId());
		unBindNumberParam.setCompId(param.getCompId());
		unBindNumberParam.setOperateUserId(param.getOperateUserId());
		String[] bindXArr = param.getBindXs().split(",");
		for (int i = 0; i < bindXArr.length; i++) {
			String bindX = bindXArr[i];
			ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
			erpAliyunPhoneExample.setShardCityId(param.getCityId());
			erpAliyunPhoneExample.createCriteria().andCompIdEqualTo(param.getCompId()).andBindXEqualTo(bindX).andNumberStateEqualTo(Byte.valueOf("1"));
			// 判断该号码是否是绑定状态才解绑
			int count = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
			if (count > 0) {
				unBindNumberParam.setBindX(bindX);
				this.unBindNumber(unBindNumberParam);
			}
		}
	}
	
	/**
	 * 号池余量不足提醒
	 * @author HuangJiang
	 * @since 2020年02月12日 13:41
	 * @param orgIdSet 组织ID
	 * @param cityId 城市ID
	 * @param compId 公司ID
	 * @return void
	 * Modified XXX HuangJiang 2020年02月12日
	 */
	private void axnPoolAbsenceWarm(Set<Integer> orgIdSet, Integer cityId, Integer compId) {
		// 获取需要提醒的人员
		List<UserOpOrgInfoDto> userList = erpUserOpersMapper.selectAllUserByOerId(cityId, compId, "AXN_POOL_ABSENCE_WARM");
		if (userList.size() > 0) {
			Date date = new Date();
			for (Integer orgId : orgIdSet) {
				// 该组织号池总量
				ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
				ErpAliyunPhoneExample.Criteria criteria = erpAliyunPhoneExample.createCriteria();
				erpAliyunPhoneExample.setShardCityId(cityId);
				criteria.andOrgIdEqualTo(orgId).andIsreleaseEqualTo((byte) 0);
				Integer totalPoolNum = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
				
				if (totalPoolNum > 0) {
					// 该组织号池未绑定数量
					criteria.andNumberStateEqualTo((byte) 0); // 0=未绑定 1=已绑定
					Integer notUsePoolNum = erpAliyunPhoneMapper.countByExample(erpAliyunPhoneExample);
					
					// 判断未绑定号码数量占当前号池总数是否不足10%
					BigDecimal notUseRate = new BigDecimal(notUsePoolNum).divide(new BigDecimal(totalPoolNum), 2, BigDecimal.ROUND_HALF_UP).setScale(2, BigDecimal.ROUND_HALF_UP);
					
					// 不足10%时，需要提醒相关人员 文案：XX号池共XX个号码，现时剩下X个，不足10%，请及时补充号码！
					if (notUseRate.compareTo(new BigDecimal("0.1")) == -1) { // -1表示小于，0是等于，1是大于
						ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, orgId);
						if (null != erpFunOrganization && StringUtil.isNotEmpty(erpFunOrganization.getOrganizationName())) {
							String taskDesc = erpFunOrganization.getOrganizationName() + "号池共" + totalPoolNum + "个号码，现时剩下" + notUsePoolNum + "个，不足10%，请及时补充号码！";
							Set<Integer> userIdSet = userList.stream().filter(user -> null != user.getUserId()).map(UserOpOrgInfoDto::getUserId).collect(Collectors.toSet());
							ErpFunTask erpFunTask = new ErpFunTask();
							erpFunTask.setCaseId(0);
							erpFunTask.setShardCityId(cityId);
							erpFunTask.setCaseNo("");
							erpFunTask.setCaseType((byte) 0);
							erpFunTask.setTrackType((null));
							erpFunTask.setTrackId(null);
							erpFunTask.setTaskType(Const.DIC_TASK_TYPE_AXN_POOL_ABSENCE_WARM);
							erpFunTask.setTaskSubject(taskDesc);
							erpFunTask.setTaskDesc(taskDesc);
							erpFunTask.setCompId(compId);
							erpFunTask.setTypeFlag(Const.DIC_TASK_TYPE_FLAG_0);
							erpFunTask.setIsRead(false);
							erpFunTask.setTaskStatus(Const.DIC_TASK_STATUS_NEW);
							erpFunTask.setCreatorUid(999);
							erpFunTask.setCreationTime(DateTimeHelper.formatDateTimetoString(date));
							erpFunTask.setDeptId(0);
							erpFunTask.setTrackWarm(true); // 只提醒ERP端
							erpFunTask.setIndexShow(1); // 首页显示，1=是 0=否
							erpFunTask.setWarmTime(DateUtil.DateToString(date));
							erpFunTaskService.insertTask(cityId, erpFunTask, userIdSet, (byte) 0, 1);
						}
					}
				}
			}
		}
	}
	
	@Override
	public void transAxn(Integer cityId, Integer userId) {
		ErpFunUsers erpFunUsers = erpFunUsersMapper.getFunUserByUserId(cityId, userId);
		Integer compId = erpFunUsers.getCompId();
		String userMobile = erpFunUsers.getUserMobile();
		Integer userOrganizationId = erpFunUsers.getOrganizationId();
		ErpAliyunPhone erpAliyunPhone = erpAliyunPhoneMapper.getPhoneNumberByBindA(cityId, compId, userMobile);
		if (erpAliyunPhone == null) {
			return;
		}
		Integer phoneOrgId = erpAliyunPhone.getOrgId();
		if (!userOrganizationId.equals(phoneOrgId)) {
			// 如果调换的组织不是号码给的组织就需要重新绑定换到新的组织
			List<String> orgIdList = Arrays.asList(erpFunUsers.getTissueLine().split(":"));
			Collections.reverse(orgIdList);
			for (int i = 0; i < orgIdList.size(); i++) {
				String orgId = orgIdList.get(i);
				if (StringUtil.isNotEmpty(orgId)) {
					ErpAliyunNumberPool erpAliyunNumberPool = erpAliyunNumberPoolMapper.getNumberPoolByOrgId(cityId, Integer.parseInt(orgId));
					if (erpAliyunNumberPool != null) {
						// 更换号池
						ErpFunOrganization erpFunOrganization = erpFunOrganizationMapper.selectOrgByOrgId(cityId, compId, Integer.parseInt(orgId));
						erpAliyunPhone.setOrgId(erpAliyunNumberPool.getOrgId());
						erpAliyunPhone.setBindAOrgId(erpFunUsers.getOrg1());
						erpAliyunPhone.setBindAOrgNo(erpFunOrganization.getOrganizationNo());
						erpAliyunPhone.setShardCityId(cityId);
						erpAliyunPhone.setNumberPoolKey(erpAliyunNumberPool.getNumberPoolKey());
						erpAliyunPhoneMapper.updateByPrimaryKeySelective(erpAliyunPhone);
						
						// 更换当月话费
						String suffix = DateTimeHelper.formatDateTimetoString(new Date(),"yyyy-MM-01");
						ErpAliyunTelephoneBill erpAliyunTelephoneBill = erpAliyunTelephoneBillMapper.getPhoneBillByMonth(cityId, compId, suffix, erpAliyunPhone.getBindX());
						if (erpAliyunTelephoneBill != null) {
							erpAliyunTelephoneBill.setOrgId(erpFunOrganization.getOrganizationId());
							erpAliyunTelephoneBill.setOrgName(erpFunOrganization.getOrganizationName());
							erpAliyunTelephoneBill.setOrgNo(erpFunOrganization.getOrganizationName());
							erpAliyunTelephoneBill.setShardCityId(cityId);
							erpAliyunTelephoneBillMapper.updateByPrimaryKeySelective(erpAliyunTelephoneBill);
						}
						// 更换通话记录
//						AdminIpCallLogExample adminIpCallLogExample = new AdminIpCallLogExample();
//						adminIpCallLogExample.createCriteria().andCallCompIdEqualTo(compId).andCallUserIdEqualTo(userId).andBindXEqualTo(erpAliyunPhone.getBindX()).andCreateTimeGreaterThanOrEqualTo(DateTimeHelper.parseToDate(suffix));
//						AdminIpCallLog adminIpCallLog = new AdminIpCallLog();
//						adminIpCallLog.setOrg1(erpFunUsers.getOrg1());
//						adminIpCallLog.setOrg2(erpFunUsers.getOrg1());
//						adminIpCallLog.setOrg3(erpFunUsers.getOrg3());
//						adminIpCallLog.setOrg4(erpFunUsers.getOrg4());
//						adminIpCallLog.setOrg5(erpFunUsers.getOrg5());
//						adminIpCallLog.setOrg6(erpFunUsers.getOrg6());
//						adminIpCallLog.setOrg7(erpFunUsers.getOrg7());
//						adminIpCallLog.setOrg8(erpFunUsers.getOrg8());
//						adminIpCallLog.setOrg9(erpFunUsers.getOrg9());
//						adminIpCallLog.setOrg10(erpFunUsers.getOrg10());
//						adminIpCallLog.setOrg11(erpFunUsers.getOrg11());
//						adminIpCallLog.setOrg12(erpFunUsers.getOrg12());
//						adminIpCallLog.setOrg13(erpFunUsers.getOrg13());
//						adminIpCallLog.setOrg14(erpFunUsers.getOrg14());
//						adminIpCallLog.setOrganizationId(erpFunUsers.getOrganizationId());
//						adminIpCallLog.setTissueLine(erpFunUsers.getTissueLine());
//						adminIpCallLogMapper.updateByPrimaryKeySelective(adminIpCallLog);
						break;
					}
				}
			}
		}
	}

	@Override
	public void deleteUnBindNumber(Integer cityId, Integer userId, Integer operateUserId) {
		ErpAliyunPhoneExample erpAliyunPhoneExample = new ErpAliyunPhoneExample();
		erpAliyunPhoneExample.setShardCityId(cityId);
		erpAliyunPhoneExample.createCriteria().andBindUserIdEqualTo(userId).andNumberStateEqualTo(Byte.valueOf("1"));
		List<ErpAliyunPhone> list = erpAliyunPhoneMapper.selectByExample(erpAliyunPhoneExample);
		if (list.isEmpty()) {
			return;
		}
		ErpAliyunPhone erpAliyunPhone = list.get(0);
		UnBindNumberParam unBindNumberParam = new UnBindNumberParam();
		unBindNumberParam.setCityId(cityId);
		unBindNumberParam.setCompId(erpAliyunPhone.getCompId());
		unBindNumberParam.setOperateUserId(operateUserId);
		unBindNumberParam.setBindX(erpAliyunPhone.getBindX());
		this.unBindNumber(unBindNumberParam);
	}
}
