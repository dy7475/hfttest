package com.myfun.service.business.agencydb.impl;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyWebClientMapper;
import com.myfun.repository.agencydb.po.AgencyWebClient;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyWebClientService;

@Service
public class AgencyWebClientServiceImpl extends AbstractService<AgencyWebClient, Integer> implements AgencyWebClientService {
	@Autowired
	private AgencyWebClientMapper agencyWebClientMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyWebClientMapper;
	}
	@Override
	public List<AgencyWebClient> getWebClient(String phone1, String phone2) {
		List<AgencyWebClient> webcliens = agencyWebClientMapper.getWebClient(phone1, phone2);
		return webcliens;
	}
	@Override
	public Integer getId() {
		return agencyWebClientMapper.getId();
	}
	@Override
	public AgencyWebClient getClientMobile(String cityId, String caseId) {
		return agencyWebClientMapper.getClientMobile(cityId, caseId);
	}
	@Override
	public AgencyWebClient getWebClientById(Integer clientId) {
		// TODO Auto-generated method stub
		return agencyWebClientMapper.selectByPrimaryKey(clientId);
	}
	@Override
	public AgencyWebClient getClientSex(Integer getfIdHFT, Integer getfProId) {
		// TODO Auto-generated method stub
		return agencyWebClientMapper.getClientSex(getfIdHFT, getfProId);
	}
	
}
