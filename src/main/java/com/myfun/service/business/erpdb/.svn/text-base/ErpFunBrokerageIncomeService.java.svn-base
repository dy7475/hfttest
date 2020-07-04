package com.myfun.service.business.erpdb;

import com.myfun.erpWeb.managecenter.constract.param.SaveBrokerageParamAndVo;
import com.myfun.repository.erpdb.po.ErpFunBrokerage;
import com.myfun.repository.erpdb.po.ErpFunBrokerageIncome;
import com.myfun.repository.support.mybatis.api.BaseMapper;

import java.util.List;


public interface ErpFunBrokerageIncomeService extends BaseMapper<ErpFunBrokerageIncome, ErpFunBrokerageIncome>{


	void initBrokerageIncomeByCompId(Integer cityId, List<ErpFunBrokerageIncome> paramList);

	void initBrokerageByCompId(Integer cityId, List<ErpFunBrokerage> erpFunBrokerages);

	void updateBrokerageIncome(Integer userId, Integer cityId, Integer compId, List<ErpFunBrokerageIncome> pList, String profitPercentRule);

	SaveBrokerageParamAndVo getBrokerageByComp(Integer cityId, Integer compId);
}
