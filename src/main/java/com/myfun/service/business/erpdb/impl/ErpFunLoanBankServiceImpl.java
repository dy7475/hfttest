package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunLoanBankMapper;
import com.myfun.repository.erpdb.po.ErpFunLoanBank;
import com.myfun.repository.erpdb.po.ErpFunLoanBankExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunLoanBankService;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.List;

@Service
public class ErpFunLoanBankServiceImpl extends AbstractService<ErpFunLoanBank, ErpFunLoanBank> implements ErpFunLoanBankService {
	@Autowired
	ErpFunLoanBankMapper erpFunLoanBankMapper;

	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunLoanBankMapper;
	}


	@Transactional
	@Override
	public void addEditLoanBank(Integer cityId, Integer compId, List<ErpFunLoanBank> paramList) {
	// 查重/排序
		Integer seq;
		if(CollectionUtils.isNotEmpty(paramList)) {
			seq = paramList.size();
			for (Integer i = 0; i < paramList.size(); i++) {
				ErpFunLoanBank erpFunLoanBankPO = paramList.get(i);
				erpFunLoanBankPO.setShardCityId(cityId);
				// 新增数据判重
				erpFunLoanBankPO.setSeqNo(seq);
				if(null == erpFunLoanBankPO.getId()) {
					Integer id = getFunLoanBankByName(cityId, compId, erpFunLoanBankPO.getBankName());
					if(null != id) {
						erpFunLoanBankPO.setId(id);
						erpFunLoanBankMapper.updateByPrimaryKeySelective(erpFunLoanBankPO);
					}else {
						erpFunLoanBankPO.setCreationTime(new Date());
						erpFunLoanBankPO.setCompId(compId);
						erpFunLoanBankMapper.insertSelective(erpFunLoanBankPO);
					}
				}else {
					erpFunLoanBankMapper.updateByPrimaryKeySelective(erpFunLoanBankPO);
				}
				seq = seq - 1;
			}
		}
	}

	private Integer getFunLoanBankByName(Integer cityId, Integer compId, String name) {
		ErpFunLoanBankExample erpFunLoanBankExample = new ErpFunLoanBankExample();
		erpFunLoanBankExample.setShardCityId(cityId);
		erpFunLoanBankExample.createCriteria().andCompIdEqualTo(compId).andBankStatusEqualTo(new Byte("1")).andBankNameEqualTo(name);

		List<ErpFunLoanBank> resList = erpFunLoanBankMapper.selectByExample(erpFunLoanBankExample);
		if(resList.size() > 0) {
			return resList.get(0).getId();
		}
		return null;
	}
}
