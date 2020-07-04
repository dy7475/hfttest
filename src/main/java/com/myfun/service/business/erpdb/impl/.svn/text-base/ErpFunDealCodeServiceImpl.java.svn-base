package com.myfun.service.business.erpdb.impl;

import java.util.Map;

import com.myfun.repository.erpdb.dao.ErpFunDealCodelogMapper;
import com.myfun.service.business.erpdb.ErpSysParaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunDealCodeMapper;
import com.myfun.repository.erpdb.po.ErpFunDealCode;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunDealCodeService;

@Service
public class ErpFunDealCodeServiceImpl extends AbstractService<ErpFunDealCode, ErpFunDealCode>
		implements ErpFunDealCodeService {
	@Autowired
	private ErpFunDealCodeMapper erpFunDealCodeMapper;
	@Autowired
	private ErpFunDealCodelogMapper erpFunDealCodelogMapper;
	@Autowired
	private ErpSysParaService erpSysParaService;

	@Override
	public void setBaseMapper() {
		super.baseMapper = erpFunDealCodeMapper;
	}

	@Override
	public void updateDealFunDealCode(Integer cityId, Map<String, Object> param) {
		erpFunDealCodeMapper.updateDealFunDealCode(cityId, param);
	}

	@Override
	public Integer createDealFunDealCode(ErpFunDealCode erpFunDealCode) {
		return erpFunDealCodeMapper.insertSelective(erpFunDealCode);
	}

	@Transactional
	@Override
	public void updateCode(Integer cityId, Integer compId,String isCan,String isSplit,String isAllow) {
		erpSysParaService.updateSysPara(cityId,compId,"SALE_RENT_DEAL_REPEAT",isSplit);
		erpSysParaService.updateSysPara(cityId,compId,"ALLOW_UNUSE_DEALNO_ISBYHAND",isAllow);
		erpSysParaService.updateSysPara(cityId,compId,"INVALID_DEALNO_CAN_USE_AGAIN",isCan);
		erpFunDealCodeMapper.updateCode(cityId,compId,isCan);
		erpFunDealCodeMapper.updateCodeLog(cityId,compId,isCan);
	}

	@Override
	public void updateCodeLog(Integer cityId, Integer compId,String isCan) {
		erpFunDealCodeMapper.updateCodeLog(cityId,compId,isCan);
	}

	@Transactional
	@Override
	public void deleteByCodeId(Integer cityId, Integer codeId) {
		erpFunDealCodeMapper.deleteByCodeId(cityId,codeId);
		erpFunDealCodelogMapper.deleteByCodeId(cityId,codeId);

	}

}
