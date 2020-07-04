package com.myfun.service.business.admindb.impl;

import java.util.Calendar;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.dao.AdminFunUserMessageMapper;
import com.myfun.repository.admindb.po.AdminFunUserMessage;
import com.myfun.repository.erpdb.dto.CaseInfoDto;
import com.myfun.repository.erpdb.po.ErpFunBuyCustomer;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunRentCustomer;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.support.constant.Const;
import com.myfun.repository.support.constant.Const.MsgModule;
import com.myfun.repository.support.constant.Const.MsgModuleType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunUserMessageService;

@Service
public class AdminFunUserMessageServiceImpl extends AbstractService<AdminFunUserMessage, Integer> implements AdminFunUserMessageService {
	@Autowired
	private AdminFunUserMessageMapper adminFunUserMessageMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = adminFunUserMessageMapper;
	}

	@Override
	public AdminFunUserMessage getUserMessage(CaseInfoDto caseInfoDto, Integer caseType, boolean judgeNowUser,
			Integer archiveId, String userName) {
		AdminFunUserMessage messagePO = new AdminFunUserMessage();
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)){
			ErpFunSale erpFunSale = caseInfoDto.getErpFunSale();
			if(erpFunSale == null || 
					// 需要判断不是本人
					(judgeNowUser && 
							(erpFunSale.getArchiveId() == null || erpFunSale.getArchiveId().equals(archiveId))
					)){
				return null;
			}
			// 非私盘数据不推送
			if(erpFunSale.getPlateType() == null || !Const.DIC_PLATE_TYPE_PRIVATE.equals(erpFunSale.getPlateType().intValue())) {
				return null;
			}
			messagePO.setCompId(erpFunSale.getCompId());
			messagePO.setArchiveId(erpFunSale.getArchiveId());
			messagePO.setHouseUseage(erpFunSale.getSaleUseage());
			messagePO.setCaseNo(erpFunSale.getSaleNo());
			messagePO.setCaseId(erpFunSale.getSaleId());
			messagePO.setCityId(erpFunSale.getCityId());
			messagePO.setMsgModule(MsgModule.HOUSE);
		} else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)){
			ErpFunLease erpFunLease = caseInfoDto.getErpFunLease();
			if(erpFunLease == null || 
					// 需要判断不是本人
					(judgeNowUser && 
							(erpFunLease.getArchiveId() == null || erpFunLease.getArchiveId().equals(archiveId))
					)){
				return null;
			}
			// 非私盘数据不推送
			if(erpFunLease.getPlateType() == null || !Const.DIC_PLATE_TYPE_PRIVATE.equals(erpFunLease.getPlateType().intValue())) {
				return null;
			}
			messagePO.setCompId(erpFunLease.getCompId());
			messagePO.setArchiveId(erpFunLease.getArchiveId());
			messagePO.setHouseUseage(erpFunLease.getLeaseUseage());
			messagePO.setCaseNo(erpFunLease.getLeaseNo());
			messagePO.setCaseId(erpFunLease.getLeaseId());
			messagePO.setCityId(erpFunLease.getCityId());
			messagePO.setMsgModule(MsgModule.HOUSE);
		} else if(Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			ErpFunBuyCustomer erpFunBuyCustomer = caseInfoDto.getErpFunBuyCustomer();
			if(erpFunBuyCustomer == null || 
					// 需要判断不是本人
					(judgeNowUser && 
							(erpFunBuyCustomer.getArchiveId() == null || erpFunBuyCustomer.getArchiveId().equals(archiveId))
					)){
				return null;
			}
			// 非私盘数据不推送
			if(erpFunBuyCustomer.getPlateType() == null || !Const.DIC_PLATE_TYPE_PRIVATE.equals(erpFunBuyCustomer.getPlateType().intValue())) {
				return null;
			}
			messagePO.setCompId(erpFunBuyCustomer.getCompId());
			messagePO.setArchiveId(erpFunBuyCustomer.getArchiveId());
			messagePO.setCaseNo(erpFunBuyCustomer.getBuyCustNo());
			messagePO.setCaseId(erpFunBuyCustomer.getBuyCustId());
			messagePO.setCityId(erpFunBuyCustomer.getCityId());
			messagePO.setMsgModule(MsgModule.CUST);
		} else if(Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			ErpFunRentCustomer erpFunRentCustomer = caseInfoDto.getErpFunRentCustomer();
			if(erpFunRentCustomer == null || 
					// 需要判断不是本人
					(judgeNowUser && 
							(erpFunRentCustomer.getArchiveId() == null || erpFunRentCustomer.getArchiveId().equals(archiveId))
					)){
				return null;
			}
			// 非私盘数据不推送
			if(erpFunRentCustomer.getPlateType() == null || !Const.DIC_PLATE_TYPE_PRIVATE.equals(erpFunRentCustomer.getPlateType().intValue())) {
				return null;
			}
			messagePO.setCompId(erpFunRentCustomer.getCompId());
			messagePO.setArchiveId(erpFunRentCustomer.getArchiveId());
			messagePO.setCaseNo(erpFunRentCustomer.getRentCustNo());
			messagePO.setCaseId(erpFunRentCustomer.getRentCustId());
			messagePO.setCityId(erpFunRentCustomer.getCityId());
			messagePO.setMsgModule(MsgModule.CUST);
		} else {
			return null;
		}
		messagePO.setCaseType(caseType);
		messagePO.setAppType(1);// 1=ERP
		messagePO.setIsDel((byte)0);// 默认未删除
		messagePO.setCreationTime(new Date());
		messagePO.setCreateArchiveId(archiveId);
		messagePO.setCreateUserName(userName);
		return messagePO;
	}
	
	@Override
	public void insertMessage(AdminFunUserMessage insert, Integer invalidHour) {
		insert.setAppType(1);// 1=ERP
		insert.setIsDel((byte) 0);// 默认未删除
		insert.setCreationTime(new Date());
		if(invalidHour != null && invalidHour > 0){
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			calendar.add(Calendar.HOUR_OF_DAY, invalidHour);
			insert.setInvalidTime(calendar.getTime());
		}
		adminFunUserMessageMapper.insertSelective(insert);
	}

	@Override
	public void createWriteTrackByViewMessage(Integer cityId, Integer compId, Integer archiveId, Integer caseId, Integer caseType, Byte caseUseage, Integer msgModule) {
		AdminFunUserMessage insert = new AdminFunUserMessage();
		insert.setCompId(compId);
		insert.setArchiveId(archiveId);
		insert.setCityId(cityId);
		insert.setCaseId(caseId);
		insert.setCaseType(caseType);
		insert.setHouseUseage(caseUseage);
		insert.setMsgModule(msgModule);
		insert.setModuleType(MsgModuleType.WRITE_TRACK_BY_VIEW);
		this.insertMessage(insert, 24);
	}
	
}


