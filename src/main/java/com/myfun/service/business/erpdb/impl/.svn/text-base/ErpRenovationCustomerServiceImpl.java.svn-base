package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpRenovationCustomerFileMapper;
import com.myfun.repository.erpdb.dao.ErpRenovationCustomerMapper;
import com.myfun.repository.erpdb.param.RenovationCustomerParam;
import com.myfun.repository.erpdb.po.ErpRenovationCustomer;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpRenovationCustomerService;
import com.myfun.service.business.erpdb.ErpRenovationFileService;
import com.myfun.service.business.erpdb.ErpRenovationTrackService;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpRenovationCustomerServiceImpl extends AbstractService<ErpRenovationCustomer, ErpRenovationCustomer> implements ErpRenovationCustomerService {

	@Autowired
	private ErpRenovationCustomerMapper erpRenovationCustomerMapper;
	@Autowired
	private ErpRenovationFileService erpRenovationFileService;
	@Autowired
	private ErpRenovationTrackService erpRenovationTrackService;
	@Autowired
	private ErpRenovationCustomerFileMapper erpRenovationCustomerFileMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpRenovationCustomerMapper;
	}

	@Transactional
	@Override
	public void addRenovationCustomer(RenovationCustomerParam param) {
		erpRenovationCustomerMapper.insertSelective(param);
		RenovationCustomerParam updateParam = new RenovationCustomerParam();
		updateParam.setShardCityId(param.getShardCityId());
		updateParam.setId(param.getId());
		updateParam.setCreationTime(new Date());
		updateParam.setRenovationNo("ZX" + DateTimeHelper.formatDateTimetoString(updateParam.getCreationTime(), "yyyyMMdd") + param.getId());
		erpRenovationCustomerMapper.updateByPrimaryKeySelective(updateParam);
		String custPhotos = param.getCustPhotos();
		String otherPhotos = param.getOtherPhotos();
		erpRenovationFileService.addRenovationFile(param.getShardCityId(), param.getCompId(), param.getUserId(), param.getArchiveId(), param.getId(), custPhotos, otherPhotos, param.getUserName());
	}

	@Transactional
	@Override
	public void updateRenovationCustomer(RenovationCustomerParam param) {
		String custPhotos = param.getCustPhotos();
		String otherPhotos = param.getOtherPhotos();
		erpRenovationCustomerMapper.updateByPrimaryKeySelective(param);
		erpRenovationCustomerFileMapper.updateIsDelByRenovationCustomerId(param.getShardCityId(), param.getCompId(),
				param.getId());
		erpRenovationFileService.addRenovationFile(param.getShardCityId(), param.getCompId(), param.getUserId(), param.getArchiveId(),
				param.getId(), custPhotos, otherPhotos,param.getUserName());
		// 编辑写跟进
		erpRenovationTrackService.createUpdateCustomeTrack(param);
	}
}
