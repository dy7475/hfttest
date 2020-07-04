package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.admindb.po.AdminIpCallLog;
import com.myfun.repository.erpdb.dao.ErpIpCallLogRecordMapper;
import com.myfun.repository.erpdb.po.ErpFunLease;
import com.myfun.repository.erpdb.po.ErpFunSale;
import com.myfun.repository.erpdb.po.ErpIpCallLogRecord;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunLeaseService;
import com.myfun.service.business.erpdb.ErpFunSaleService;
import com.myfun.service.business.erpdb.ErpIpCallLogRecordService;
import com.myfun.utils.DateUtil;

@Service
public class ErpIpCallLogRecordServiceImpl extends AbstractService<ErpIpCallLogRecord, ErpIpCallLogRecord>implements ErpIpCallLogRecordService {
	@Autowired
	private ErpIpCallLogRecordMapper erpIpCallLogRecordMapper;
	@Autowired
	private ErpFunSaleService erpFunSaleService;
	@Autowired
	private ErpFunLeaseService erpFunLeaseService;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpIpCallLogRecordMapper;
	}

	@Transactional
	@Override
	public void insertHouseCallRecord(AdminIpCallLog adminIpCallLog) {
		Byte type = adminIpCallLog.getTargetType();
		ErpIpCallLogRecord record = new ErpIpCallLogRecord();
		if (Const.HouseCustType.SALE == type.byteValue()) {// 当前只记录房源
			ErpFunSale erpFunSale = erpFunSaleService.getFunSale(adminIpCallLog.getTargetId(), adminIpCallLog.getCallCityId());
			if (erpFunSale == null) {
				return;
			}
			record.setCaseAreaId(erpFunSale.getAreaId());
			record.setCaseDeptId(erpFunSale.getDeptId());
			record.setCaseGrId(erpFunSale.getGrId());
			record.setCaseRegId(erpFunSale.getRegId());
			record.setCaseUserId(erpFunSale.getUserId());
		} else if (Const.HouseCustType.LEASE == type.byteValue()) {
			ErpFunLease erpFunLease = erpFunLeaseService.getFunLease(adminIpCallLog.getTargetId(), adminIpCallLog.getCallCityId());
			if (erpFunLease == null) {
				return;
			}
			record.setCaseAreaId(erpFunLease.getAreaId());
			record.setCaseDeptId(erpFunLease.getDeptId());
			record.setCaseGrId(erpFunLease.getGrId());
			record.setCaseRegId(erpFunLease.getRegId());
			record.setCaseUserId(erpFunLease.getUserId());
		} else {
			return;
		}
		record.setCaseId(adminIpCallLog.getTargetId());
		record.setCompId(adminIpCallLog.getCallCompId());
		record.setCreateDate(DateUtil.StringToDate(DateUtil.getDate(new Date())));
		record.setCaseType(type.intValue());
		record.setCallCount(1);
		record.setShardCityId(adminIpCallLog.getCallCityId());
		record.setCallUserId(adminIpCallLog.getCallUserId());
		erpIpCallLogRecordMapper.addHouseCallCount(record);
	}
}
