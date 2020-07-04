package com.myfun.service.business.agencydb.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myfun.repository.agencydb.dao.AgencyFunCustDealMapper;
import com.myfun.repository.agencydb.dao.AgencyPaFinanceMapper;
import com.myfun.repository.agencydb.po.AgencyFunCustDeal;
import com.myfun.repository.support.param.GeneralParam;
import com.myfun.service.business.AbstractService;
import com.myfun.service.business.agencydb.AgencyFunCustDealService;

@Service
public class AgencyFunCustDealServiceImpl extends AbstractService<AgencyFunCustDeal, Integer> implements AgencyFunCustDealService {
	@Autowired
	AgencyFunCustDealMapper agencyFunCustDealMapper;
	@Autowired
	AgencyPaFinanceMapper agencyPaFinanceMapper;

	@Override
	public void setBaseMapper() {
		super.baseMapper = agencyFunCustDealMapper;
	}

	/**
	 * 查询可提现金额
	 * @author 邓永洪
	 * @since 2018/5/23
	 * @param param
	 * @param type 1:个人 2：公司
	 * @return
	 */
	@Override
	public BigDecimal[] getFunCustDealData(GeneralParam param, int type) {
		if (type != 1 && type != 2) {
			return new BigDecimal[]{BigDecimal.ZERO, BigDecimal.ZERO};
		}
		BigDecimal newHouseAllAmountBig = BigDecimal.ZERO;
		BigDecimal newHouseAmountBig = BigDecimal.ZERO;
		Float newHouseAllAmount = agencyFunCustDealMapper.getNewHouseAllAmount(type, param);
		Float newHouseAmount = agencyFunCustDealMapper.getNewHouseAmount(type, param);
		Float paFianceAmount = agencyPaFinanceMapper.getPaFianceAmount(type, param);
		if (newHouseAllAmount != null) {
			newHouseAllAmountBig = newHouseAllAmountBig.add(new BigDecimal(newHouseAllAmount));
		}
		if (newHouseAmount != null) {
			newHouseAmountBig = newHouseAmountBig.add(new BigDecimal(newHouseAmount));
		}
		if (paFianceAmount != null) {
			newHouseAmountBig = newHouseAmountBig.add(new BigDecimal(paFianceAmount));
			newHouseAllAmountBig = newHouseAllAmountBig.add(new BigDecimal(paFianceAmount));
		}
		return new BigDecimal[]{newHouseAmountBig, newHouseAllAmountBig};
	}
}
