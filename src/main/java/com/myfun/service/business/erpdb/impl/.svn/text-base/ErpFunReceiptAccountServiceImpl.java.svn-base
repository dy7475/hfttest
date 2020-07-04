package com.myfun.service.business.erpdb.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.exception.ConfirmException;
import com.myfun.repository.erpdb.dao.ErpFunReceiptAccountMapper;
import com.myfun.repository.erpdb.po.ErpFunReceiptAccount;
import com.myfun.repository.erpdb.po.ErpFunReceiptType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunReceiptAccountService;

@Service
public class ErpFunReceiptAccountServiceImpl extends AbstractService<ErpFunReceiptAccount, ErpFunReceiptAccount> implements ErpFunReceiptAccountService {
	@Autowired
	private ErpFunReceiptAccountMapper erpFunReceiptAccountMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunReceiptAccountMapper;
	}

	@Transactional
	@Override
	public void updateReceiptAccountList(Integer cityId, Integer compId, List<ErpFunReceiptAccount> paramList) {
		List<String> receiptTypeList = new ArrayList<>();
		for (ErpFunReceiptAccount erpFunReceiptAccount : paramList) {
			receiptTypeList.add(erpFunReceiptAccount.getReceiptAccount());
		}
		Set<String> setName = paramList.stream().collect(Collectors.mapping(ErpFunReceiptAccount::getReceiptAccount, Collectors.toSet()));
		if (setName.size() != receiptTypeList.size()) {
			throw new ConfirmException("财务账户名称不可重复!");
		}
		// 有专门的删除接口
//		erpFunReceiptAccountMapper.updateListByCompId(cityId, compId);
		int index = 1;
		for (ErpFunReceiptAccount erpFunReceiptAccount : paramList) {
			erpFunReceiptAccount.setSeqNo(index++);
			if (null == erpFunReceiptAccount.getId()) {
				erpFunReceiptAccount.setCompId(compId);
				erpFunReceiptAccount.setCreateTime(new Date());
//				erpFunReceiptAccount.setDelFlag((byte) 0);
				erpFunReceiptAccount.setShardCityId(cityId);
				erpFunReceiptAccountMapper.insertSelective(erpFunReceiptAccount);
			} else {
				ErpFunReceiptAccount updateModel = new ErpFunReceiptAccount();
				updateModel.setId(erpFunReceiptAccount.getId());
				updateModel.setSeqNo(erpFunReceiptAccount.getSeqNo());
				updateModel.setReceiptAccount(erpFunReceiptAccount.getReceiptAccount());
				updateModel.setShardCityId(cityId);
//				updateModel.setDelFlag((byte) 0);
				erpFunReceiptAccountMapper.updateByPrimaryKeySelective(updateModel);
			}
		}
	}
	
}
