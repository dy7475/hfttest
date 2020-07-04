package com.myfun.service.business.erpdb.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONObject;
import com.myfun.repository.erpdb.dao.ErpAliRenthouseDialingrecordMapper;
import com.myfun.repository.erpdb.dao.ErpAliRenthouseReservationMapper;
import com.myfun.repository.erpdb.dao.ErpDicDefinitionsMapper;
import com.myfun.repository.erpdb.dao.ErpFunUsersMapper;
import com.myfun.repository.erpdb.po.ErpAliRenthouseDialingrecord;
import com.myfun.repository.erpdb.po.ErpAliRenthouseReservation;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAliRentHouseReservationService;
import com.myfun.utils.DateUtil;
import com.myfun.utils.KafkaBizUtils;

@Service
public class ErpAliRentHouseReservationServiceImpl extends AbstractService<ErpAliRenthouseReservation, ErpAliRenthouseReservation> implements ErpAliRentHouseReservationService {
	@Autowired private ErpAliRenthouseReservationMapper erpAliRenthouseReservationMapper;
	@Autowired private ErpAliRenthouseDialingrecordMapper erpAliRenthouseDialingrecordMapper;
	@Autowired private ErpDicDefinitionsMapper erpDicDefinitionsMapper;
	@Autowired private ErpFunUsersMapper erpFunUsersMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAliRenthouseReservationMapper;
	}

	@Transactional
	@Override
	public void createReservation(ErpAliRenthouseReservation erpAliRenthouseReservation, ErpFunLease erpFunLease) {
		erpAliRenthouseReservationMapper.insertSelective(erpAliRenthouseReservation);
		ErpFunUsers userInfoByUserId = erpFunUsersMapper.getUserInfoByUserId(erpFunLease.getCityId(), erpAliRenthouseReservation.getCaseUserId());

		if(null != userInfoByUserId) {
			sendMsgToApp(erpFunLease.getCityId(), userInfoByUserId.getArchiveId(), erpAliRenthouseReservation.getBookName(), erpAliRenthouseReservation.getBookSex(), erpAliRenthouseReservation.getBookPhone(),
					erpFunLease.getBuildName(), erpFunLease.getLeaseRoom(), erpFunLease.getLeaseArea(), erpFunLease.getLeaseTotalPrice(), erpFunLease.getPriceUnit(), erpAliRenthouseReservation.getLookTime(), erpAliRenthouseReservation.getId());
		}
	}

	@Override
	public void createDataDialRecord(ErpAliRenthouseDialingrecord record) {
		erpAliRenthouseDialingrecordMapper.insertSelective(record);
	}

	private void sendMsgToApp(Integer cityId, Integer archiveId, String lookUserName, Integer lookSex, String lookUserMobile,
							  String buildName, Byte leaseRoom, BigDecimal leaseArea, BigDecimal leaseTotal, Byte priceUnit, Date lookTime, Integer resverId) {
		String str = "客户%s%s 对您 支付宝租房平台 挂牌的出租房源【%s %s室 %s㎡ %s%s】有意向，并预约您于%s前往看房 ，赶紧联系客户确认吧！";
		String sexStr = "";
		if(null != lookSex) {
			if(1 == lookSex) {
				sexStr = "先生";
			}else if(2== lookSex) {
				sexStr = "女士";
			}
		}

		String leaseTotalPriceStr = "";
		if(new BigDecimal(leaseTotal.intValue()).compareTo(leaseTotal)==0){
			leaseTotalPriceStr = leaseTotal.intValue()+"";
		}else{
			leaseTotalPriceStr = leaseTotal.toString();
		}

		String leaseAreaStr = "";
		if(new BigDecimal(leaseArea.intValue()).compareTo(leaseArea)==0){
			leaseAreaStr = leaseArea.intValue()+"";
		}else{
			leaseAreaStr = leaseArea.toString();
		}

		String priceUnitStr = "";
		if(null != priceUnit) {
			priceUnitStr = erpDicDefinitionsMapper.getDicCnMsg(cityId, "PRICE_UNIT", priceUnit + "");
		}
		str = String.format(str, lookUserName,sexStr,buildName,leaseRoom,leaseAreaStr,leaseTotalPriceStr,priceUnitStr, DateUtil.DateToString(lookTime, "yyyy-MM-dd HH:mm"));

		// 同步推送掌通
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("templateId", "9");
		jsonObject.put("receiver", archiveId);
		jsonObject.put("content", str);
		jsonObject.put("reservationId", resverId);
		KafkaBizUtils.pushMsgByTemplate(jsonObject);
	}

	public static void main(String[] args) {

			String str = "客户%s%s 对您 支付宝租房平台 挂牌的出租房源【%s %s室 %s㎡ %s%s】有意向，并预约您于%s前往看房 ，赶紧联系客户确认吧！";
			String sexStr = "先生";


			String leaseTotalPriceStr = "60000";


			String leaseAreaStr = "80";


			String priceUnitStr = "元/月";

			str = String.format(str, "胡军",sexStr,"香榭国际",3,leaseAreaStr,leaseTotalPriceStr,priceUnitStr, DateUtil.DateToString(new Date(), "yyyy-MM-dd HH:mm"));
		System.out.println(str);

		JSONObject extObject = new JSONObject();
		extObject.put("ios_router_url", "zshft://com.dynamic?targetclass=ApptSeeHouseDetailController&reservationId=50" );
		extObject.put("android_router_url", "zshft://com.dynamic?targetActivity=com.haofang.hftsoftapp.ui.module.customer.activity.RentAppointmentActivty&reservationId=50" );
		extObject.put("payload", "{\"routerURL\":\"zshft://com.dynamic?targetclass=ApptSeeHouseDetailController&reservationId=50\"}");
		System.out.println(extObject.toJSONString());;


		}

}
