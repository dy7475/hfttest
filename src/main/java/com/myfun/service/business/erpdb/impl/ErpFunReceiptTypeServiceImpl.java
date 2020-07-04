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
import com.myfun.repository.erpdb.dao.ErpFunReceiptTypeMapper;
import com.myfun.repository.erpdb.po.ErpFunReceiptType;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunReceiptTypeService;

@Service
public class ErpFunReceiptTypeServiceImpl extends AbstractService<ErpFunReceiptType, ErpFunReceiptType> implements ErpFunReceiptTypeService {

	@Autowired
	private ErpFunReceiptTypeMapper erpFunReceiptTypeMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunReceiptTypeMapper;
	}

	@Transactional
	@Override
	public void updateReceiptTypeList(Integer cityId, Integer compId, List<ErpFunReceiptType> paramList) {
		List<String> receiptTypeList = new ArrayList<>();
		for (ErpFunReceiptType erpFunReceiptType : paramList) {
			receiptTypeList.add(erpFunReceiptType.getReceiptType());
		}
		Set<String> setName = paramList.stream().collect(Collectors.mapping(ErpFunReceiptType::getReceiptType, Collectors.toSet()));
		if (setName.size() != receiptTypeList.size()) {
			throw new ConfirmException("财务收款名称不可重复!");
		}
		// 有专门的删除接口
//		erpFunReceiptTypeMapper.updateListByCompId(cityId, compId);
		int index = 1;
		for (ErpFunReceiptType erpFunReceiptType : paramList) {
			erpFunReceiptType.setSeqNo(index++);
			if (null == erpFunReceiptType.getId()) {
				erpFunReceiptType.setCompId(compId);
				erpFunReceiptType.setCreateTime(new Date());
//				erpFunReceiptType.setDelFlag((byte) 0);
				erpFunReceiptType.setShardCityId(cityId);
				erpFunReceiptTypeMapper.insertSelective(erpFunReceiptType);
			} else {
				ErpFunReceiptType updateModel = new ErpFunReceiptType();
				updateModel.setSeqNo(index++);
				updateModel.setId(erpFunReceiptType.getId());
				updateModel.setReceiptType(erpFunReceiptType.getReceiptType());
				updateModel.setShardCityId(cityId);
//				updateModel.setDelFlag((byte) 0);
				erpFunReceiptTypeMapper.updateByPrimaryKeySelective(updateModel);
			}
		}
	}
}
