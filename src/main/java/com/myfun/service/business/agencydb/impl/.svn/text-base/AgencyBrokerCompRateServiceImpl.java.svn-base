package com.myfun.service.business.agencydb.impl;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.framework.httpMessageConvert.base.BaseMapParam;
import com.myfun.repository.agencydb.dao.AgencyBrokerCompRateMapper;
import com.myfun.repository.agencydb.po.AgencyBrokerCompRate;
import com.myfun.repository.agencydb.po.AgencyBrokerCompRateKey;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyBrokerCompRateService;
@Service
public class AgencyBrokerCompRateServiceImpl extends AbstractService<AgencyBrokerCompRate, AgencyBrokerCompRateKey>implements AgencyBrokerCompRateService {
	@Autowired
	private AgencyBrokerCompRateMapper agencyBrokerCompRateMapper;
	
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = agencyBrokerCompRateMapper;
	}

	@Override
	public AgencyBrokerCompRate getDistCompCommissionRate(BaseMapParam param) {
		AgencyBrokerCompRateKey agencyBrokerCompRateKey = new AgencyBrokerCompRateKey();
		agencyBrokerCompRateKey.setCityId(param.getInteger("cityId"));
		agencyBrokerCompRateKey.setCompId(param.getInteger("compId"));
		AgencyBrokerCompRate agencyBrokerCompRate = agencyBrokerCompRateMapper.selectByPrimaryKey(agencyBrokerCompRateKey);
		if(null == agencyBrokerCompRate) {
			agencyBrokerCompRate = new AgencyBrokerCompRate();
			agencyBrokerCompRate.setPaidRate(new BigDecimal(0));
		}
		return agencyBrokerCompRate;
	}

	@Override
	public Integer setCompCommissionRate(BaseMapParam param) {
		AgencyBrokerCompRateKey agencyBrokerCompRateKey = new AgencyBrokerCompRateKey();
		agencyBrokerCompRateKey.setCityId(param.getInteger("cityId"));
		agencyBrokerCompRateKey.setCompId(param.getInteger("compId"));
		AgencyBrokerCompRate agencyBrokerCompRate = agencyBrokerCompRateMapper.selectByPrimaryKey(agencyBrokerCompRateKey);
		if(null != agencyBrokerCompRate) {
			agencyBrokerCompRate.setPaidRate(new BigDecimal(param.getMap().get("paidRate")+""));
			agencyBrokerCompRateMapper.updateByPrimaryKeySelective(agencyBrokerCompRate);
		}else {
			agencyBrokerCompRate = new AgencyBrokerCompRate();
			agencyBrokerCompRate.setPaidRate(new BigDecimal(param.getMap().get("paidRate")+""));
			agencyBrokerCompRate.setCityId(param.getInteger("cityId"));
			agencyBrokerCompRate.setCompId(param.getInteger("compId"));
			agencyBrokerCompRateMapper.insertSelective(agencyBrokerCompRate);
		}
		return null;
	}

	

}
