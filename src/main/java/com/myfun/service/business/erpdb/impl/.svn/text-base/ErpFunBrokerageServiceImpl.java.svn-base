package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunBrokerageMapper;
import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunBrokerageExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunBrokerageService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ErpFunBrokerageServiceImpl extends AbstractService<ErpFunBrokerage, ErpFunBrokerage> implements ErpFunBrokerageService {
	@Autowired
	ErpFunBrokerageMapper erpFunBrokerageMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper=erpFunBrokerageMapper;
	}

	/**
	 * @tag 根据公司ID和租售类型获取佣金比例设置,没有设置将读取默认设置
	 * @author 邓永洪
	 * @since 2018/5/31
	 */
	@Override
	public ErpFunBrokerage getBrokerageByCompId(Integer cityId, Integer compId, Byte saleLease) {
		ErpFunBrokerageExample brokerageExample=new ErpFunBrokerageExample();
		brokerageExample.setShardCityId(cityId);
		brokerageExample.createCriteria().andCompIdEqualTo(compId).andSaleLeaseEqualTo(saleLease.intValue());
		List<ErpFunBrokerage> brokeragesList = erpFunBrokerageMapper.selectByExample(brokerageExample);
		if(null != brokeragesList && brokeragesList.size() > 0) {
			ErpFunBrokerage resultBrokerage = brokeragesList.get(0);
			if(null==resultBrokerage && compId!=0){
				resultBrokerage=getBrokerageByCompId(cityId,0,saleLease);
				if(null==resultBrokerage){
					//创建公司分佣比例模板
					erpFunBrokerageMapper.initBrokerageModel(cityId);
					resultBrokerage=getBrokerageByCompId(cityId,0,saleLease);
				}
			}
			return resultBrokerage;
		}else {
			return null;
		}
		
	}
}
