package com.myfun.service.business.erpdb.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.erpWeb.managecenter.axn.param.CreateNumberPoolParam;
import com.myfun.framework.config.AppConfig;
import com.myfun.framework.exception.BusinessException;
import com.myfun.repository.erpdb.dao.ErpAliyunNumberPoolMapper;
import com.myfun.repository.erpdb.dto.AliyunNumberPoolDto;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPool;
import com.myfun.repository.erpdb.po.ErpAliyunNumberPoolExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpAliyunNumberPoolService;

@Service
public class ErpAliyunNumberPoolServiceImpl extends AbstractService<ErpAliyunNumberPool, ErpAliyunNumberPool> implements ErpAliyunNumberPoolService{
	@Autowired private ErpAliyunNumberPoolMapper erpAliyunNumberPoolMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpAliyunNumberPoolMapper;
	}
	
	@Override
	public ErpAliyunNumberPool createNumberPool(CreateNumberPoolParam param) {
		ErpAliyunNumberPoolExample erpAliyunNumberPoolExample = new ErpAliyunNumberPoolExample();
		erpAliyunNumberPoolExample.setShardCityId(param.getCityId());
		erpAliyunNumberPoolExample.createCriteria().andCompIdEqualTo(param.getCompId()).andNumberPoolKeyEqualTo(param.getNumberPoolKey());
		int count = erpAliyunNumberPoolMapper.countByExample(erpAliyunNumberPoolExample);
		if (count > 0) {
			throw new BusinessException("该号码池key已存在");
		}
		erpAliyunNumberPoolExample.createCriteria().andCompIdEqualTo(param.getCompId()).andNumberPoolNameEqualTo(param.getNumberPoolName());
		count = erpAliyunNumberPoolMapper.countByExample(erpAliyunNumberPoolExample);
		if (count > 0) {
			throw new BusinessException("该号码池名称已存在");
		}
		ErpAliyunNumberPool erpAliyunNumberPool = new ErpAliyunNumberPool();
		erpAliyunNumberPool.setShardCityId(param.getCityId());
		erpAliyunNumberPool.setAliNumberPoolKey(AppConfig.getProperty("common.aliyun.axn.aliNumberPoolKey"));
		erpAliyunNumberPool.setCompId(param.getCompId());
		erpAliyunNumberPool.setCreateTime(new Date());
		erpAliyunNumberPool.setNumberPoolKey(param.getNumberPoolKey());
		erpAliyunNumberPool.setNumberPoolName(param.getNumberPoolName());
		erpAliyunNumberPool.setOrgId(param.getOrganizationId());
		erpAliyunNumberPoolMapper.insertSelective(erpAliyunNumberPool);
		return erpAliyunNumberPool;
	}
	
}
