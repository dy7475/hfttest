package com.myfun.service.business.agencydb.impl;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencySpreadPhotoMapper;
import com.myfun.repository.agencydb.po.AgencySpreadPhoto;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencySpreadPhotoService;

/** 
 * @author 作者张卓 
 * @version 创建时间：2016年5月9日 下午7:11:36 
 * 类说明 
*/
@Service
public class AgencySpreadPhotoServiceImpl extends AbstractService<AgencySpreadPhoto, Integer>implements AgencySpreadPhotoService {
	@Autowired
	private AgencySpreadPhotoMapper agencySpreadPhotoMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencySpreadPhotoMapper;
	}

	@Override
	public AgencySpreadPhoto getPhotoBySpreadId(String spreadId) {
		return agencySpreadPhotoMapper.getPhotoBySpreadId(spreadId);
	}


}
