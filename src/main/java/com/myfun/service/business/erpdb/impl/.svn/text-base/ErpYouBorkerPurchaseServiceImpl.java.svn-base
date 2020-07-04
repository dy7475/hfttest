package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpYouBorkerPurchaseMapper;
import com.myfun.repository.erpdb.dto.ErpYouBorkerPurchaseDto;
import com.myfun.repository.erpdb.po.ErpYouBorkerPurchase;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouBorkerPurchaseService;

@Service
public class ErpYouBorkerPurchaseServiceImpl extends AbstractService<ErpYouBorkerPurchase, ErpYouBorkerPurchase> implements ErpYouBorkerPurchaseService {

	@Autowired
	ErpYouBorkerPurchaseMapper erpYouBorkerPurchaseMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpYouBorkerPurchaseMapper;
	}

	@Override
	public List<ErpYouBorkerPurchaseDto> getPurchaseRecords(ErpYouBorkerPurchase borkerPurchase) {
		
		return erpYouBorkerPurchaseMapper.getPurchaseRecords(borkerPurchase.getCityId(),borkerPurchase.getYouShareId());
	}

	@Override
	public void sendMsgToParticipant(Integer caseType, Integer cityId, Byte status) {
		
	}


}
