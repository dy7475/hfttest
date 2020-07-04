package com.myfun.service.business.admindb.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.myfun.repository.admindb.dao.AdminFunInvoiceEnclosureMapper;
import com.myfun.repository.admindb.po.AdminFunInvoiceEnclosure;
import com.myfun.repository.erpdb.param.AddOrUpdateIssueInvoiceParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.admindb.AdminFunInvoiceEnclosureService;
@Service
public class AdminFunInvoiceEnclosureServiceImpl extends AbstractService<AdminFunInvoiceEnclosure,Integer>
		implements AdminFunInvoiceEnclosureService {
	@Autowired private AdminFunInvoiceEnclosureMapper adminFunInvoiceEnclosureMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = adminFunInvoiceEnclosureMapper;
	}

	@Transactional
	@Override
	public void conectInvoiceId(Integer invoiceId, String esList,
			AddOrUpdateIssueInvoiceParam param) {
		List<AdminFunInvoiceEnclosure> esObjList = JSON.parseObject(esList, new TypeReference<List<AdminFunInvoiceEnclosure>>() {});
		for (AdminFunInvoiceEnclosure adminFunInvoiceEnclosurePO: esObjList) {
			 // 查询地址
			String esPath = adminFunInvoiceEnclosurePO.getEsPath();
			if(esPath == null) {
			    continue;
			}
			adminFunInvoiceEnclosurePO.setCityId(param.getCityId().shortValue());
			adminFunInvoiceEnclosurePO.setCompNo(param.getCompNo());
			adminFunInvoiceEnclosurePO.setDeptNo(param.getDeptNo());
			adminFunInvoiceEnclosurePO.setCreateUid(param.getUserId());
			adminFunInvoiceEnclosurePO.setCreationTime(new Date());
			adminFunInvoiceEnclosurePO.setInvoiceId(invoiceId);
			adminFunInvoiceEnclosurePO.setEsStatus(Byte.valueOf("1"));
			adminFunInvoiceEnclosureMapper.insertSelective(adminFunInvoiceEnclosurePO);
		}
	}
	
	

}
