package com.myfun.service.business.erpdb.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunPolicyControlMapper;
import com.myfun.repository.erpdb.dao.ErpSysParaMapper;
import com.myfun.repository.erpdb.po.ErpFunPolicyControl;
import com.myfun.repository.erpdb.po.ErpSysPara;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPolicyControlService;
import com.myfun.service.business.erpdb.ErpSysParaService;
import com.myfun.utils.Constants_DIC;

@Service
public class ErpFunPolicyControlServiceImpl extends AbstractService<ErpFunPolicyControl, ErpFunPolicyControl>implements ErpFunPolicyControlService {
	@Autowired ErpFunPolicyControlMapper erpFunPolicyControlMapper;
	@Autowired ErpSysParaMapper erpSysParaMapper;
	@Autowired ErpSysParaService erpSysParaService;
	@Autowired ErpFunUsersMapper erpFunUsersMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunPolicyControlMapper;
	}
	
	/**
	 * 修改转抢盘剩余天数为系统参数
	 * 就是重新开始策略参数天数，一般是有新跟进时调用
	 * @author 熊刚
	 * @since 2017年10月12日
	 * @param caseId
	 * @param caseType
	 * @param isTrack
	 * @param isFangKan
	 * @param compId
	 */
	@Override
	public void resetPrivateDay(Integer cityId, Integer caseId, Integer caseType, boolean isTrack, boolean isFangKan,
			Integer compId, Integer createUserId) {
		Integer trackDays = 0;
		if (isTrack) {
			trackDays = getTrackDays(caseType, compId, cityId, createUserId) + 1;// 这里需要+1天
		}

		ErpFunPolicyControl erpFunPolicyControl = erpFunPolicyControlMapper.getPolicyControl(cityId, caseId,caseType);
		if (null == erpFunPolicyControl) {
			erpFunPolicyControl = new ErpFunPolicyControl();
			erpFunPolicyControl.setCaseId(caseId);
			erpFunPolicyControl.setCaseType(caseType);
			erpFunPolicyControl.setCompId(compId);
			erpFunPolicyControl.setCreationTime(new Date());
			if (isFangKan) {
				erpFunPolicyControl.setFangkanDay(-1);
			}
			if (isTrack) {
				erpFunPolicyControl.setTrackDay(-1);
			}
			erpFunPolicyControl.setUpdateTime(new Date());
			erpFunPolicyControl.setShardCityId(cityId);
			erpFunPolicyControlMapper.insertSelective(erpFunPolicyControl);
		} else {
			boolean isNeedTrack = (isTrack && trackDays != erpFunPolicyControl.getTrackDay());
			boolean isNeedFangkan = (isFangKan && -1 != erpFunPolicyControl.getFangkanDay());
			if (!isNeedTrack && !isNeedFangkan) {
				return;// 天数没变动不修改
			}

			ErpFunPolicyControl recordUpdate = new ErpFunPolicyControl();
			if (isTrack) {
				recordUpdate.setTrackDay(trackDays);
			}
			if (isFangKan) {
				recordUpdate.setFangkanDay(-1);
			}
			recordUpdate.setUpdateTime(new Date());
			recordUpdate.setShardCityId(cityId);
			recordUpdate.setId(erpFunPolicyControl.getId());
			erpFunPolicyControlMapper.updateByPrimaryKeySelective(recordUpdate);
		}
	}

	@Override
	public void insertFunPolicyContro(Integer caseId, Integer compId,Integer cityId, Integer caseType,Integer createUserId) {
		int trackDays = getTrackDays(caseType,compId,cityId, createUserId) + 1;// 未跟进多少天跳抢，这里需要+1天
		int pubRedDays = getPubRedDays(caseType,compId,cityId, createUserId) + 1;// 未房勘多少天跳抢，这里需要+1天
		ErpFunPolicyControl insertModel = new ErpFunPolicyControl();
		insertModel.setCaseId(caseId);
		insertModel.setCaseType(caseType);
		insertModel.setCompId(compId);
		insertModel.setCreationTime(new Date());
		insertModel.setTrackDay(trackDays);
		insertModel.setFangkanDay(pubRedDays);
		insertModel.setUpdateTime(new Date());
		insertModel.setShardCityId(cityId);
		erpFunPolicyControlMapper.insertSelective(insertModel);
	}

	/**
	 * 获取未跟进多少天跳抢
	 * @author 张宏利
	 * @since 2017年2月13日
	 * @param caseType
	 * @param createUserId 
	 * @return
	 * @throws Exception
	 */
	private int getTrackDays(Integer caseType,Integer compId,Integer cityId, Integer createUserId) {
		int trackDays = 0;
		ErpFunUsers erpFunUsers = erpFunUsersMapper.selectByUserId(cityId, createUserId);
		int orgId = 0;
		if (Objects.nonNull(erpFunUsers)) {
			orgId = erpFunUsers.getOrganizationId();
		}
		if(Constants_DIC.DIC_CASE_TYPE_SALE_FUN.equals(caseType.toString())) {
			trackDays = getTrackDaysByOrgId("TRACK_RED_SELL", "RED_TRACK_PUBLIC_SELL", compId, cityId,orgId);
		} else if(Constants_DIC.DIC_CASE_TYPE_LEASE_FUN.equals(caseType.toString() )) {
			trackDays = getTrackDaysByOrgId("TRACK_RED_LEASE", "RED_TRACK_PUBLIC_LEASE", compId, cityId,orgId);
		} else if(Constants_DIC.DIC_CASE_TYPE_BUY_CUST.equals(caseType.toString())) {
			trackDays = getTrackDaysByOrgId("TRACK_RED_BUY", "RED_TRACK_PUBLIC_BUY", compId, cityId,orgId);
		} else if(Constants_DIC.DIC_CASE_TYPE_RENT_CUST.equals(caseType.toString())) {
			trackDays = getTrackDaysByOrgId("TRACK_RED_RENT", "RED_TRACK_PUBLIC_RENT", compId, cityId,orgId);
		}
		return trackDays;
	}
	
	/**
	 * 依据系统参数获取多少天跳抢
	 * @author 张宏利
	 * @since 2017年2月13日
	 * @param caseType
	 * @return
	 * @throws Exception
	 */
	private int getTrackDays(String red, String pub,Integer compId,Integer cityId,Integer createUserId) {
		try {
			String trackRed = "0";
			String redTrackPub = "0";
			List<String> sysParams = new ArrayList<>();
			sysParams.add(red);
			sysParams.add(pub);
			Map<String,String>  paraMap = erpSysParaService.getMLSysParamMapByUserType(cityId, compId, createUserId, sysParams);
			trackRed = paraMap.get(red)!=null?paraMap.get(red):"0";
			redTrackPub = paraMap.get(pub)!=null?paraMap.get(pub):"0";		
			return Integer.parseInt(trackRed)+ Integer.parseInt(redTrackPub);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	private int getTrackDaysByOrgId(String red, String pub,Integer compId,Integer cityId,Integer orgId) {
		try {
			String trackRed = "0";
			String redTrackPub = "0";
			List<String> sysParams = new ArrayList<>();
			sysParams.add(red);
			sysParams.add(pub);
			List<ErpSysPara> list = erpSysParaService.getMLErpSysParamListByOrgId(cityId, compId, orgId, sysParams);
			Map<String, String> paraMap = list.stream().collect(Collectors.toMap(ErpSysPara::getParamId, ErpSysPara::getParamValue));
			trackRed = paraMap.get(red)!=null?paraMap.get(red):"0";
			redTrackPub = paraMap.get(pub)!=null?paraMap.get(pub):"0";
			return StringUtil.parseInteger(trackRed,0) + StringUtil.parseInteger(redTrackPub,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	/**
	 * 获取未房勘剩多少天跳抢
	 * @author 张宏利
	 * @since 2017年2月13日
	 * @param caseType
	 * @param createUserId 
	 * @return
	 * @throws Exception
	 */
	private int getPubRedDays(Integer caseType,Integer compId,Integer cityId, Integer createUserId) {
		int pubRedDays = 0;
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)) {
			pubRedDays = getTrackDays("GET_PUBLIC_RED_SELL", "GET_RED_TRACK_PUBLIC_SELL",compId,cityId,createUserId);
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)) {
			pubRedDays = getTrackDays("GET_PUBLIC_RED_LEASE", "GET_RED_TRACK_PUBLIC_LEASE",compId,cityId,createUserId);
		} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)) {
			pubRedDays = getTrackDays("GET_PUBLIC_RED_BUY", "GET_RED_TRACK_PUBLIC_BUY",compId,cityId,createUserId);
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)) {
			pubRedDays = getTrackDays("GET_PUBLIC_RED_RENT", "GET_RED_TRACK_PUBLIC_RENT",compId,cityId,createUserId);
		}
		return pubRedDays;
	}

}
