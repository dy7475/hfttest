package com.myfun.service.business.erpdb.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myfun.repository.erpdb.dao.ErpFunOutdealMapper;
import com.myfun.repository.erpdb.param.ErpCreateTrackInfoParam;
import com.myfun.repository.erpdb.po.ErpFunOutdeal;
import com.myfun.repository.erpdb.po.ErpFunUsers;
import com.myfun.repository.support.constant.Const;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.erpdb.ErpFunOutdealService;
import com.myfun.utils.Constants_DIC;
import com.myfun.utils.DateTimeHelper;

@Service
public class ErpFunOutdealServiceImpl extends AbstractService<ErpFunOutdeal, ErpFunOutdeal> implements ErpFunOutdealService{
	@Autowired ErpFunOutdealMapper erpFunOutdealMapper;
	@Override
	public void setBaseMapper() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createOutDealInfo(ErpCreateTrackInfoParam param) {
		Integer caseType = param.getCaseType();
		Integer cityId = param.getCityId();
		ErpFunUsers createAuditUser = param.getCreateAuditUser();
		
		ErpFunOutdeal erpFunOutdeal = new ErpFunOutdeal();
		String dealTypeTmp = null;
		Integer dealType = null;
		Integer outDealId = erpFunOutdealMapper.getOutDealId(cityId);
		String nowTime = DateTimeHelper.formatDateTimetoString(new Date());
		if(Const.DIC_CASE_TYPE_SALE_FUN.equals(caseType)
				|| Const.DIC_CASE_TYPE_BUY_CUST.equals(caseType)){
			dealTypeTmp = "S";
			dealType = Const.DIC_CASE_TYPE_SALE_DEAL;
		}else if(Const.DIC_CASE_TYPE_LEASE_FUN.equals(caseType)
				|| Const.DIC_CASE_TYPE_RENT_CUST.equals(caseType)){
			dealTypeTmp = "R";
			dealType = Const.DIC_CASE_TYPE_RENT_DEAL;
		}
		String dealNo = dealTypeTmp + String.valueOf(outDealId) + DateTimeHelper.formatDateTimetoString(DateTimeHelper.getSystemDate(),"yyMMdd");
		erpFunOutdeal.setDealId(outDealId);
		erpFunOutdeal.setAgreementNo(dealNo);
		erpFunOutdeal.setDealType(dealType.byteValue());
		erpFunOutdeal.setCaseId(param.getCaseId());
		erpFunOutdeal.setCaseType(param.getCaseType().byteValue());
		erpFunOutdeal.setDealStatus(Byte.valueOf(Constants_DIC.DIC_DEAL_STATUS_DOING));
		erpFunOutdeal.setCreatorUserId(createAuditUser.getUserId());
		erpFunOutdeal.setCreatorDate(nowTime);
		erpFunOutdeal.setHouseUseage((byte) 0);
		erpFunOutdeal.setCompId(createAuditUser.getCompId());
		erpFunOutdeal.setAreaId(createAuditUser.getAreaId());
		erpFunOutdeal.setRegId(createAuditUser.getRegId());
		erpFunOutdeal.setDeptId(createAuditUser.getDeptId());
		erpFunOutdeal.setShardCityId(param.getCityId());
		erpFunOutdeal.setOrganizationPath(createAuditUser.getTissueLine());
		erpFunOutdealMapper.insertSelective(erpFunOutdeal);
	}

}
