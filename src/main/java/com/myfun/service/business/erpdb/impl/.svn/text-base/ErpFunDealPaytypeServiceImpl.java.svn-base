package com.myfun.service.business.erpdb.impl;

import com.myfun.repository.erpdb.dao.ErpFunDealPaytypeMapper;
import com.myfun.repository.erpdb.po.ErpFunDealPaytype;
import com.myfun.repository.erpdb.po.ErpFunDealPaytypeExample;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDealPaytypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ErpFunDealPaytypeServiceImpl extends AbstractService<ErpFunDealPaytype, ErpFunDealPaytype> implements ErpFunDealPaytypeService {
	@Autowired
	ErpFunDealPaytypeMapper erpFunDealPaytypeMapper;
	@Override
	@PostConstruct
	public void setBaseMapper() {
		super.baseMapper = erpFunDealPaytypeMapper;
	}


	@Override
	public void createCompTempleteDealPayTypeList(Integer cityId, Integer compId) {
		erpFunDealPaytypeMapper.createCompTempleteDealPayTypeList(cityId, compId);
	}

	@Transactional
	@Override
	public void updateFunDealPaytype(Integer cityId, Integer compId, List<ErpFunDealPaytype> paramList) {
		if(paramList.size() == 0) return;
		int index = 0;
		for(ErpFunDealPaytype erpFunDealPaytype : paramList){
			index++;
			erpFunDealPaytype.setCompId(compId);
			erpFunDealPaytype.setSeqNo(index);
			erpFunDealPaytype.setIsDel(new Byte("0"));
			erpFunDealPaytype.setShardCityId(cityId);
			// 类别	2：财务状态		1：合同类别
			if(null == erpFunDealPaytype.getPaytypeId()){
				Integer payTypeId = getHasFunDealPaytypeID(cityId, compId, erpFunDealPaytype.getPaytypeName());
				if(null == payTypeId){
					erpFunDealPaytype.setCanDel(1);
					erpFunDealPaytype.setCreateTime(new Date());
					erpFunDealPaytypeMapper.insertSelective(erpFunDealPaytype);
				}else{
					erpFunDealPaytype.setPaytypeId(payTypeId);
					erpFunDealPaytype.setSeqNo(index);
					erpFunDealPaytypeMapper.updateByPrimaryKeySelective(erpFunDealPaytype);
				}
			}else{
				erpFunDealPaytypeMapper.updateByPrimaryKeySelective(erpFunDealPaytype);
			}
		}
	}

	private Integer getHasFunDealPaytypeID(Integer cityId, Integer compId, String paytypeName) {
		ErpFunDealPaytypeExample erpFunDealPaytypeExample = new ErpFunDealPaytypeExample();
		erpFunDealPaytypeExample.setShardCityId(cityId);
		erpFunDealPaytypeExample.createCriteria().andCompIdEqualTo(compId).andIsDelEqualTo(new Byte("0")).andPaytypeNameEqualTo(paytypeName);

		List<ErpFunDealPaytype> erpFunDealPaytypes = erpFunDealPaytypeMapper.selectByExample(erpFunDealPaytypeExample);

		if(erpFunDealPaytypes.size() > 0){
			return erpFunDealPaytypes.get(0).getPaytypeId();
		}else{
			return null;
		}

	}
}
