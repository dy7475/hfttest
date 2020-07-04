package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpYouComplaintProofMapper;
import com.myfun.repository.erpdb.po.ErpYouComplaintProof;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpYouComplaintProofService;

@Service
public class ErpYouComplaintProofServiceImpl extends AbstractService<ErpYouComplaintProof, ErpYouComplaintProof> implements ErpYouComplaintProofService {

	@Autowired
	ErpYouComplaintProofMapper erpYouComplaintProofMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper=erpYouComplaintProofMapper;
	}

	@Override
	public List<ErpYouComplaintProof> getComplaintProosList(Integer cityId, Integer complainId) {
		return erpYouComplaintProofMapper.getComplaintProosList(cityId, complainId);
	}
	
	

}
