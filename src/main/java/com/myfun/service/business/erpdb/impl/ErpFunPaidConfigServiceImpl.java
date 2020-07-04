package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunPaidConfigMapper;
import com.myfun.repository.erpdb.po.ErpFunPaidConfig;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunPaidConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Date;
@Service
public class ErpFunPaidConfigServiceImpl extends AbstractService<ErpFunPaidConfig, ErpFunPaidConfig> implements ErpFunPaidConfigService {
	@Autowired
	ErpFunPaidConfigMapper erpFunPaidConfigMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunPaidConfigMapper;
	}

	@Override
	public void savePaidConfig(Integer cityId, Integer compId, ErpFunPaidConfig erpFunPaidConfig) {
		ErpFunPaidConfig funPaidConfig = erpFunPaidConfigMapper.getFunPaidConfig(cityId,compId);
		erpFunPaidConfig.setCompId(compId);
		erpFunPaidConfig.setShardCityId(cityId);
		if (funPaidConfig!=null){
            erpFunPaidConfig.setId(funPaidConfig.getId());
            erpFunPaidConfigMapper.updateByPrimaryKeySelective(erpFunPaidConfig);
		}else {
			erpFunPaidConfig.setCreateTime(new Date());
			erpFunPaidConfigMapper.insertSelective(erpFunPaidConfig);
		}
	}
}
