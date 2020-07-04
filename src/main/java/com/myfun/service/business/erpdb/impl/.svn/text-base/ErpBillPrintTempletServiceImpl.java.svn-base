package com.myfun.service.business.erpdb.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.erpdb.dao.ErpBillPrintTempletMapper;
import com.myfun.repository.erpdb.param.BillPrintTempletParam;
import com.myfun.repository.erpdb.po.ErpBillPrintTemplet;
import com.myfun.repository.erpdb.po.ErpBillPrintTempletExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpBillPrintTempletService;

@Service
public class ErpBillPrintTempletServiceImpl extends AbstractService<ErpBillPrintTemplet, ErpBillPrintTemplet> implements ErpBillPrintTempletService {

	@Autowired
	private ErpBillPrintTempletMapper erpBillPrintTempletMapper;
	
	@Override
	public void setBaseMapper() {
		super.baseMapper = erpBillPrintTempletMapper;
	}

	@Override
	public void createAndUpdateBillModel(BillPrintTempletParam param) {
		ErpBillPrintTempletExample example = new ErpBillPrintTempletExample();
		example.createCriteria().andCompIdEqualTo(param.getCompId());
		example.setShardCityId(param.getShardCityId());
		List<ErpBillPrintTemplet> templetList = erpBillPrintTempletMapper.selectByExample(example);
		if(null == templetList || templetList.size() <= 0){
			erpBillPrintTempletMapper.insertSelective(param);
		} else { // 一个公司只有一个票据模板
			param.setId(templetList.get(0).getId());
			erpBillPrintTempletMapper.updateByPrimaryKeySelective(param);
		}
	}
}
